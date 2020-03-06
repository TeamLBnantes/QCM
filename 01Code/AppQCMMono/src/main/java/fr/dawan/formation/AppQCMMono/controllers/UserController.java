package fr.dawan.formation.AppQCMMono.controllers;

import java.util.Locale;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
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
	
	//Maj des données de l'utilisateur après modification en base de données
	// user = information en provenance du formulaire - session = valeur de la session active
	@PostMapping("/update")
	public String update(User user, HttpSession session) {
		
		
		User userSession = (User) session.getAttribute("user");
		userSession.setLastName(user.getLastName());
		userSession.setFirstName(user.getFirstName());
		
		if(!userSession.getEmail().equals(user.getEmail())){
			if(userService.searchByEmail(user.getEmail())==null) {
				userSession.setEmail(user.getEmail());
			}else {
				System.out.println("refus de modifier l'email car déja présent en BDD");
			}
		}
		
		//TODO gérer l'information utilisateur selon l'état de l'info d'authentification
		//TODO case à cocher modif pwd (modification du mdp)
	
		// Hashage d'un mot de passe
		String pwd=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		userSession.setPassword(pwd);
		
		session.setAttribute("user", userSession);
		
		userService.saveOrUpdate(userSession);
		
		return "redirect:/home";
	}
	
	
}
