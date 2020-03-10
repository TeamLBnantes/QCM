package fr.dawan.formation.AppQCMMono.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.ObjectFiltresMCQ;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.MCQService;

@Controller
@RequestMapping("/passerQCM")
public class PasserQCMController {
	
	@GetMapping(value= {"", "/"})
	public String hello(HttpSession session, Model model) {
		
		User user = (User)session.getAttribute("user");
		// on récupère l'attribut "user" dans la session
		// s'il existe, on lui dit bonjour, en le passant dans le modèle
		if (user != null) {
			model.addAttribute("message", "Bonjour " 
				+ user.getFirstName());
		}
		
		boolean isDesigner=false;
		if (user.getDesigner()!=null) {
			isDesigner=true;
		}

		MCQService mcqService=new MCQService();
		Set<MCQ> mcqs=mcqService.findAll();

		model.addAttribute("mcqs", mcqs);
		
		model.addAttribute("isDesigner", isDesigner);
		
		
		// on renvoie le nom de la jsp
		return "PasserMCQListe";
	}
	
	
	//     passerQCM/filtres    on demande l'affichage des qcm pour les passr, mais avec le filtre
	@PostMapping(value= {"/filtres"})
	public String qcmPasseFiltre(HttpSession session, ObjectFiltresMCQ filtresMCQ,  Model model) {
		User user = (User)session.getAttribute("user");
		MCQService mcqService=new MCQService();
		
		List<MCQ> mcqs=mcqService.searchWithFiltre(filtresMCQ, user);
		
		
		
		model.addAttribute("mcqs", mcqs);
		model.addAttribute("filtresMCQ", filtresMCQ);
	
	return "PasserMCQListe";
}
	
	@GetMapping(value= {"/{id}/init"})
	public String lancer(@PathVariable("id") int id, HttpSession session, Model model) {
		
		User user = (User)session.getAttribute("user");
		
		
		// on renvoie le nom de la jsp
		return "PasserMCQ";
	}
	
	
}