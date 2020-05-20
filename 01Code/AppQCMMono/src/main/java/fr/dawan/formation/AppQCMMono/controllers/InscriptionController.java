package fr.dawan.formation.AppQCMMono.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.SubscribeValidator;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;
import fr.dawan.formation.AppQCMMono.Services.UserService;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {

	/**
	 * from :
	 *  login.jsp
	 *  button "inscrption"
	 * 
	 */
	
	@GetMapping("")
	public String Inscription() {
		return "inscription";
	}
	
	/**
	 * 
	 * from :
	 *  inscription.jsp
	 *  button "valider"
	 *  
	 *  Create a new user from
	 *  @param user
	 *  
	 *  Validation of password and email using
	 *  @param user
	 *  @param confirmPassword
	 *  @param confirmEmail
	 *  
	 *  If validation is Ok, register this user in bdd
	 *  
	 *  To:
	 *  Validation Ok : redirect to login.jsp, w/ email already filled
	 *  Validation not Ok : stay on inscription.jsp, w/ an error message
	 * 
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping(value="", params= {"confirmPassword", "confirmEmail"})
	public String EnregistrerUser(User user, Model model,
			@RequestParam("confirmPassword") String confirmPassword,
			@RequestParam("confirmEmail") String confirmEmail ) {
		
		SubscribeValidator subsVal=new SubscribeValidator();
		UserService userService = new UserService();
		
	if(!(user.getPassword().equals(confirmPassword))) {
		subsVal.setComment("Confirmation du mot de passe non conforme");
		model.addAttribute("confirmEmail", confirmEmail);
		user.setPassword("");
	}else if(!(user.getEmail().equals(confirmEmail))){
		subsVal.setComment("Confirmation de l'Email non conforme");
		model.addAttribute("confirmPassword", confirmPassword);
		}else {
		    
			subsVal=userService.createUser(user);
			if (!subsVal.isValidation()) {
				user.setEmail("");
				model.addAttribute("confirmPassword", confirmPassword);
				}
			}
			
			//possible de tester la valeur de retour de createUser
			// en fonction, si l'utilisateur n'a pas été cérer, possible de renvoyer sur eecran de création en disant pourquoi
			if (subsVal.isValidation()) {
				model.addAttribute("email", user.getEmail());
				return "login";
			}else {
				model.addAttribute("message", subsVal.getComment());
				model.addAttribute(user);
				return "inscription";
			}
		
	}
	
	/**
	 * from:
	 *  lateral nav navigateur.jsp
	 *  button "inscription designer"
	 *  
	 * To:
	 *  inscriptionDesigner.jsp
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	
	@GetMapping("/designer")
	public String inscriptionDesigner(HttpSession session, Model model) {
		SessionServiceDTO ssdto = new SessionServiceDTO();
		User user = ssdto.sessionUserService(session);
		ssdto.isDesignerService(user, model);
		return "inscriptionDesigner";
	}
	
	
	/**
	 * From :
	 *  inscriptionDesigner.jsp
	 *  button : valider
	 * 
	 * create a new designer from form
	 * @param designer
	 * designer is linked to user using the user stocked in :
	 * @param model
	 * 
	 * To:
	 *  home.jsp
	 * 
	 * @param session
	 * @return
	 */
	@PostMapping("/designer")
	public String EnregistrementDesigner(			
			HttpSession session,
			Designer designer,
			Model model) {
		
		UserService userService = new UserService();
		User userSession=(User) session.getAttribute("user");
		userSession = userService.createUserDesigner(userSession, designer);
		SessionServiceDTO ssdto = new SessionServiceDTO();
		User user = ssdto.sessionUserService(session);
		ssdto.isDesignerService(user, model);
				
		session.setAttribute("user", userSession);
		
		return "redirect:/home";
	}
	
}
