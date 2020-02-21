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
import fr.dawan.formation.AppQCMMono.Services.UserService;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {

	@GetMapping("")
	public String Inscription() {
		return "inscription";
	}
	
	
	@PostMapping("")
	public String EnregistrerUser(User user) {
		
		UserService userService = new UserService();
		userService.createUser(user);
		return "login";
		

	}
	

	
	
}
