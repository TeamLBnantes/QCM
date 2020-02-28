package fr.dawan.formation.AppQCMMono.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.UserService;
import sun.print.resources.serviceui;
import sun.print.resources.serviceui_sv;

@Controller
@RequestMapping("/modificationUserInformations")
public class UserController {

	@Autowired
	private UserService userService;
	
	//Afficher informations de l'utilisateur
	@GetMapping("/update")
	public String update() {
		
		return "modificationUserInformations";
	}
	
	//Maj des données de l'utilisateur après modification
	@PostMapping("/update")
	public String update(User user, HttpSession session) {

		User userSession = (User) session.getAttribute("user");
		userSession.setLastName(user.getLastName());
		userSession.setFirstName(user.getFirstName());
		userSession.setEmail(user.getEmail());
		userSession.setPassword(user.getPassword());
		
		session.setAttribute("user", userSession);
		
		userService.saveOrUpdate(user);
		
		return "redirect:/home";
	}
	
	
}
