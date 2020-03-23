package fr.dawan.formation.AppQCMMono.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	/**
	 * from:
	 * 	page login.jsp
	 * 	button connexion
	 * 
	 *  nav lateral: navigateur.jsp
	 *  button accueil
	 * 	
	 * @param session
	 * @param model
	 * @return
	 */
	
	
	@GetMapping(value= {"", "/"})
	public String hello(HttpSession session, Model model) {
		SessionServiceDTO ssdto = new SessionServiceDTO();
		User user = ssdto.sessionUserService(session);
		
		// on récupère l'attribut "user" dans la session
		// s'il existe, on lui dit bonjour, en le passant dans le modèle
		if (user != null) {
			model.addAttribute("message", "Bonjour " 
				+ user.getFirstName());
		}
		ssdto.isDesignerService(user, model);
		
		
		// on renvoie le nom de la jsp
		return "home";
	}


	
}