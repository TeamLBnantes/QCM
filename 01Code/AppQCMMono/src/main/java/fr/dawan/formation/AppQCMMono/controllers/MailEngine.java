package fr.dawan.formation.AppQCMMono.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.formation.AppQCMMono.Models.AdminTechniqueAppli;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.MailDTO;
import fr.dawan.formation.AppQCMMono.Models.ObjectListDto;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.GenericDAO;
import fr.dawan.formation.AppQCMMono.Services.AdminService;
import fr.dawan.formation.AppQCMMono.Services.MCQService;
import fr.dawan.formation.AppQCMMono.Services.QuestionService;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;

@Controller
@RequestMapping("/MailEngine")
public class MailEngine {

//  les GetMapping que je me propose d'utiliser pour appeler les fonction mails
//  questionFromGestion/{questionID}        pour un mail concernant une question dans la base des questions, mail d'un designer donc.
//  {mcqID}/questionFromQCM/{questionID}     pour le mail concernant une question dans un qcm
//  fromQCM/{mcqID}     pour un mail concernant un qcm  
// "" pour une question pour admin sans lien avec question ou qcm	

	
	//controleur pour mail concernant une question (non lié à un qcm)
	@GetMapping(value= {"questionFromGestion/{questionID}"})
	public String intMailQuestion(@PathVariable("questionID") int questionID, HttpSession session, Model model) {
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
	
	//controleur pour un mail concernant un qcm  
	@GetMapping(value= {"fromQCM/{mcqID}"})  
	public String intMailMcq(@PathVariable("mcqID") int mcqID, HttpSession session, Model model) {
		//recupèrer les info du QCM
		MCQService mcqService = new MCQService();
		MCQ mcq = mcqService.searchById(mcqID);

		//les renvoyer dans le model 
		model.addAttribute("cible", "qcm"); // mail portant sur une question, un qcm ou une questionQCM. donc ici question
		model.addAttribute("mcq", mcq);
		model.addAttribute("envoyer", false);
		//afficher la page de renseignement du mail à envoyer
		return "mail"; 	
	}	
	
	//controleur pour un mail concernant une question lié à un qcm 
	@GetMapping(value= {"{mcqID}/questionFromQCM/{questionID}"})  
	public String intMailQuestionMCQ(@PathVariable("questionID") int questionID, @PathVariable("mcqID") int mcqID, HttpSession session, Model model) {
		//recupèrer les info du QCM
		MCQService mcqService = new MCQService();
		MCQ mcq = mcqService.searchById(mcqID);
		//recupèrer les info de la question
		QuestionService questionService = new QuestionService();
		Question question = questionService.findById(questionID);
		
		//les renvoyer dans le model 
		model.addAttribute("cible", "questionQcm"); // mail portant sur une question, un qcm ou une questionQCM. donc ici question
		model.addAttribute("mcq", mcq);
		model.addAttribute("question", question);
		model.addAttribute("envoyer", false);
		//afficher la page de renseignement du mail à envoyer
		return "mail"; 	
	}
	
	//controleur pour un mail concernant un qcm  
	@GetMapping(value= {""})  
	public String intMailAdmin(HttpSession session, Model model) {

		//les renvoyer dans le model 
		model.addAttribute("cible", "admin"); // mail portant sur une question, un qcm ou une questionQCM. donc ici question
		model.addAttribute("envoyer", false);
		//afficher la page de renseignement du mail à envoyer
		return "mail"; 	
	}	
	
	
	
	
	
	@PostMapping(value= {""})
	public String envoyerMail(MailDTO mailDTO, HttpSession session, Model model) {	
	//TODO: en javascript, dans la page mail appelante, empecher de valider le formulaire tant que les champs titre et body ne sont pas renseignés	

	//affichage du formulaire d'envoie de mail, prend en parametre la page appelante
	//les infos pour la génération du mail sont dans la session et dans le modele
		
		//recup info user et appel du service de messagerie 
		String message="envoie OK";
		User user = (User) session.getAttribute("user");
		try {
			AdminService adminService=new AdminService();
			mailDTO=adminService.envoyerMail(mailDTO, user);
		} catch (Exception e) {
			message=e.toString();
			
			AdminTechniqueAppli donneesAdmin=AdminTechniqueAppli.getInstance();
		    GenericDAO<AdminTechniqueAppli> adminDAO=new GenericDAO<AdminTechniqueAppli>(Constantes.PERSISTENCE_UNIT_NAME);
		    donneesAdmin=adminDAO.findById(AdminTechniqueAppli.class, 1);
		    adminDAO.close();
			if (donneesAdmin==null) {
				message=message+ "\r\n\r\n         les donnees de parametrage de l'application ne sont pas présentent dans la base de données !!";
			}
			
		}

		String lignes[] = mailDTO.getBody().split("\r\n");
		//les renvoyer dans le model
		model.addAttribute("lignes", lignes);
		model.addAttribute("messageErreur", message);
		model.addAttribute("envoyer", true);
		model.addAttribute("mailDTO", mailDTO);
		//va à présent afficher la page de resultat de l'envoie du mail. Champ vérouillés et log exception eventuelles.
		return "mail"; 	
	}
	
	
}



