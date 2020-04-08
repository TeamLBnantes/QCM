package fr.dawan.formation.AppQCMMono.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.formation.AppQCMMono.Models.MailDTO;
import fr.dawan.formation.AppQCMMono.Models.ObjectListDto;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.AdminService;
import fr.dawan.formation.AppQCMMono.Services.MCQService;
import fr.dawan.formation.AppQCMMono.Services.QuestionService;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;

@Controller
@RequestMapping("/MailEngine")
public class MailEngine {

//  les GetMapping que je me propose d'utiliser pour appeler les fonction mails
//  questionFromGestion/{questionID}        pour un mail concernant une question dans la base des questions, mail d'un designer donc.
//  {questionID}/questionFromQCM/{mcqID}     pour le mail concernant une question dans un qcm
//  FromQCM/{mcqID}     pour un mail concernant un qcm  

	
	//controleur pour lancer le QCM d'ID id
	@GetMapping(value= {"questionFromGestion/{questionID}"})
	public String intMail(@PathVariable("questionID") int questionID, HttpSession session, Model model) {
	//affichage du formulaire d'envoie de mail, prend en parametre la page appelante
	//les infos pour la génération du mail sont dans la session et dans le modele
		
		//recupèrer les info de la question
		QuestionService questionService = new QuestionService();
		Question question = questionService.findById(questionID);
		
		//les renvoyer dans le model 
		model.addAttribute("cible", "question"); // mail portant sur une question, un qcm ou une questionQCM. donc ici question
		model.addAttribute("question", question);
		model.addAttribute("envoyer", false);
		//afficher la page de renseignement du mail à envoyer
		return "mail"; 	
	}
	
	@PostMapping(value= {""})
	public String envoyerMail(MailDTO mailDTO, HttpSession session, Model model) {
	//affichage du formulaire d'envoie de mail, prend en parametre la page appelante
	//les infos pour la génération du mail sont dans la session et dans le modele
		
		//recup info user et appel du service de messagerie 
		String message="envoie OK";
		User user = (User) session.getAttribute("user");
		AdminService adminService=new AdminService();
		try {
			mailDTO=adminService.envoyerMail(mailDTO, user);
		} catch (Exception e) {
			message=e.toString();
		}
		
		
		
		//recupèrer les info de la question
		QuestionService questionService = new QuestionService();
		Question question = questionService.findById(mailDTO.getQuestionId());
		

		
		//les renvoyer dans le model
		model.addAttribute("messageErreur", message);
		model.addAttribute("envoyer", true);
		model.addAttribute("mailDTO", mailDTO);
		model.addAttribute("question", question);
		//va à présent afficher la page de resultat de l'envoie du mail. Champ vérouillés et log exception eventuelles.
		return "mail"; 	
	}
	
	
}



