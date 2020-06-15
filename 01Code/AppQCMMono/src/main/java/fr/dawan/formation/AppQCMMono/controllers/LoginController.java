package fr.dawan.formation.AppQCMMono.controllers;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.AdminService;
import fr.dawan.formation.AppQCMMono.Services.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("")
	public String login(
			//@requestParam sera utilisé pour conserver l'info de la page qui était 
			//demandée lorsque l'intercepteur forcera la demande d'authentification
			@RequestParam(name="returnUrl", required=false) String returnUrl) {
		return "login";
	}
	
	/**
	 * from:
	 *  login.jsp
	 *  
	 *  userService.controlLogin check if 
	 *   user is in bdd
	 *   psw is correct
	 *   
	 *  To :
	 *   if Ok : home.jsp
	 *   If not Ok : stay on login.jsp, w/ an error message
	 * 
	 * 
	 * @param session
	 * @param user
	 * @param returnUrl
	 * @param model
	 * @return
	 */
	
	@PostMapping("")
	public String login(
			HttpSession session,
			User user,
			@RequestParam(name="returnUrl", required=false) String returnUrl,
			Model model) {
		
		UserService userService = new UserService();
		
		if (userService.controlLogin(user.getEmail(), user.getPassword())){
			user=userService.searchByEmail(user.getEmail());	
			
			session.setAttribute("user", user);
			if(returnUrl != null && !"".equals(returnUrl)) {
				return "redirect:/"+returnUrl;
			}
			return "redirect:/home";
			
		}else {
			System.out.println("pb d'authentification");
			model.addAttribute("message", "pb d'authentification");
			return "login";
		}

		// TODO : vérif du login/mdp
		

	}
	
//	1	<dependency>
//	2	  <groupId>org.mindrot</groupId>
//	3	  <artifactId>jbcrypt</artifactId>
//	4	  <version>0.3m</version>
//	5	</dependency>
//	
//	1	// Hashage d'un mot de passe
//	2	String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
//	3	 
//	4	// Il est possible d'augmenter la complexité (et donc le temps
//	5	// de traitement) en passant le "workfactor" en paramètre
//	6	// ici : 12 La valeur par défaut est 10
//	7	String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
//	8	 
//	9	// Vérification d'un mot de passe à partir du hash
//	10	if (BCrypt.checkpw(candidate, hashed))
//	11	  System.out.println("It matches");
//	12	else
//	13	  System.out.println("It does not match");
	
	
	/**
	 * logout
	 *  from:
	 *   nav lateral navigateur.jsp
	 *   button: deconnexion
	 *   
	 *  to:
	 *  index.jsp
	 *  
	 * @param session
	 * @return
	 */
	@GetMapping("/out")
	public String logout(HttpSession session) {
		//session.setAttribute("user", null);
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("/admin")
	public String adminDesactivate(HttpSession session) {
		//session.setAttribute("user", null);
		User user=((User)(session.getAttribute("user")));
		user.setAdmin(false);
		session.setAttribute("user", user);
		return "redirect:/home";
	}
	
	
	@PostMapping("/admin")
	public String admin(
			HttpSession session,
			User user,
			@RequestParam(name="password") String password,
			Model model) {
		
		AdminService adminService = new AdminService();
		System.out.println("mot de passe transmis : "+ password);
		boolean pwdAdminOK=adminService.getPasswordAdmin(password);

				if (pwdAdminOK) {
					User user2=((User)(session.getAttribute("user")));
					user2.setAdmin(true);
					session.setAttribute("user", user2);
				}
			
//		if (userService.controlLogin(user.getEmail(), user.getPassword())){
//			user=userService.searchByEmail(user.getEmail());	
//			
//			session.setAttribute("admin", true);

		
	
		return "redirect:/home";
	}
}
