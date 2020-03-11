package fr.dawan.formation.AppQCMMono.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Models.SubscribeValidator;
import fr.dawan.formation.AppQCMMono.Services.DesignerService;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;
import fr.dawan.formation.AppQCMMono.Services.UserService;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {

	@GetMapping("")
	public String Inscription() {
		return "inscription";
	}
	
	
	@PostMapping(value="", params= {"confirmPassword", "confirmEmail"})
	public String EnregistrerUser(User user, Model model,
			@RequestParam("confirmPassword") String confirmPassword,
			@RequestParam("confirmEmail") String confirmEmail ) {
		
		SubscribeValidator subsVal;
		UserService userService = new UserService();
		
			
			subsVal=userService.createUser(user, confirmPassword, confirmEmail);
			
			
			
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

	@GetMapping("/designer")
	public String inscriptionDesigner(HttpSession session, Model model) {
		SessionServiceDTO ssdto = new SessionServiceDTO();
		User user = ssdto.sessionUserService(session);
		ssdto.isDesignerService(user, model);
		return "inscriptionDesigner";
	}
	
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
		
		//userSession.setDesigner(designer);
		
		session.setAttribute("user", userSession);
		
		//model.addAttribute("isDesigner", true);
		

		return "redirect:/home";
	}
	
}
