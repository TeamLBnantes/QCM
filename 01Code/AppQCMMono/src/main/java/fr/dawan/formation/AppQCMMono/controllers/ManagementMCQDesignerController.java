package fr.dawan.formation.AppQCMMono.controllers;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Enum.TypeMultimedia;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.ObjectFiltresQuestion;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.QuestionDTO;
import fr.dawan.formation.AppQCMMono.Models.StatsMCQdto;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.MCQService;
import fr.dawan.formation.AppQCMMono.Services.QuestionService;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;

@Controller
@RequestMapping("/ManagementMCQDesigner")
public class ManagementMCQDesignerController {

	@GetMapping(value = { "" })
	public String hello(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		MCQService mcqService=new MCQService();
		List<MCQ> mcqs=mcqService.searchByDesigner(user.getDesigner());

		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());
		model.addAttribute("newMcq", false);
		model.addAttribute("mcqs", mcqs);

		return "MCQDesignerListe";
	}
	
	
//Création d'un nouveau qcm, affichage du formulaire pour renseigner les attributs	
	@GetMapping(value = { "/new" })    
	public String renseignerNouveauMcq(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		MCQService mcqService=new MCQService();
		List<MCQ> mcqs=mcqService.searchByDesigner(user.getDesigner());
		
		//for (Question question : questions) {
		//	System.out.println(question);
		//}
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());
		model.addAttribute("newMcq", true);
		model.addAttribute("mcqs", mcqs);
		//model.addAttribute("enumStatus", Status.values());
		// on renvoie le nom de la jsp
		return "MCQDesignerListe";
	}
	

	//////enregistrement du nouveau qcm
	@PostMapping("createMCQ")
	public String createMcq(MCQ mcq, HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
		MCQService mcqService=new MCQService();
		mcq.setDesigner(user.getDesigner());
		mcq.setCreateDate(LocalDateTime.now());
		mcq.setEditDate(LocalDateTime.now());
		mcqService.create(mcq);
		
		return "redirect:/ManagementMCQDesigner";
	}

	
	// Suppression d'un QCM
	//TODO : attention, je ne met pas de secours, un clique et pas de retour arrière. Il faudra demander une confirmation
	@GetMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable("id") int id, HttpSession session, Model model) {
		
		MCQService mcqService=new MCQService();
		
		mcqService.deleteById(id);

		// on renvoie le nom de la jsp
		return "redirect:/ManagementMCQDesigner";
	}

	
	//affichage de la page de gestion d'un QCM d'id ID. ses attributs et les questions qui le compose
	@GetMapping(value = { "/{id}" })    //id du qcm sur lequel le designer souhaite travailler. on va l'afficher
	public String afficherMcq(@PathVariable("id") int id, HttpSession session, Model model) {
		
		//TODO : il faudra securiser le fait que seul le proprétaire du QCM peu le modifier
		// donc vérifier qu'il est bien le propriétaire (et que c'est pas un petit malin qui a ecrit l'adresse dans la barre de nav 
		User user = (User) session.getAttribute("user");

		
		MCQService mcqService=new MCQService();
		MCQ mcq=mcqService.searchById(id);
		QuestionService questionService=new QuestionService();
		List<Question> questions=questionService.searchByMcq(mcq);

		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("mcq", mcq);
		model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());
		// on renvoie le nom de la jsp
		return "ManagementMCQDesigner";
	}
	
	//save or Update des attribut du QCM (sans les questions)
	@PostMapping(value = { "/{id}" })    //id du qcm à sauvegarder
	public String enregistrerMcq(MCQ mcq,@PathVariable("id") int id, Model model) {
		System.out.println(mcq.getBody());
		MCQService mcqService=new MCQService();
		MCQ mcqUpdate=mcqService.searchById(id);
		mcqUpdate.setBody(mcq.getBody());
		mcqUpdate.setEditDate(LocalDateTime.now());
		mcqUpdate.setTopic(mcq.getTopic());  //sauv du theme
		mcqUpdate.setStatus(mcq.getStatus());
		
		//mise à jour des données de l'objet multimedia. (il sera sauvegardé par la sauvegarde
		// de mcq update, et le lien fort entre les deux table
		//poura aventageusement etre remplacé par une methode ServiceMultimedia.update(old, new)
		mcqUpdate.getMultimedia().setAdresseCible(mcq.getMultimedia().getAdresseCible());
		mcqUpdate.getMultimedia().setAdresseVignette(mcq.getMultimedia().getAdresseVignette());
		mcqUpdate.getMultimedia().setLegende(mcq.getMultimedia().getLegende());
		mcqUpdate.getMultimedia().setTypeMultimedia(mcq.getMultimedia().getTypeMultimedia());
		
		
		
		
		
		mcqService.saveOrUpdate(mcqUpdate);
	//***********************************************************************************************
		System.out.println(mcqService);
		// on renvoie le nom de la jsp
		return "redirect:/ManagementMCQDesigner/"+id;
	}	
	
	
	
	//accès à la gestion de la liste des questions qui composent le qcm, + listes des questions candidates
	@GetMapping(value = { "/{id}/questions" })    //id du qcm pour lequel nous allons chercher d'autres questions
	public String listerQuestionsMcq(@PathVariable("id") int id, HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");

		
		MCQService mcqService=new MCQService();
		MCQ mcq=mcqService.searchById(id);
		QuestionService questionService=new QuestionService();
		List<Question> questions=questionService.searchByMcq(mcq);
		
		//TODO : module de recherche des questions à dispo
		// pour le moment, je donne tout
		Set<Question> questionsTrouvees=questionService.findAll();
		Set<QuestionDTO> questionsTrouveesDTO=new HashSet<>();
		
		List<Integer> listeIdQuestionSelect=new ArrayList<>();    //j'utilise un tableau des id des questions déjà inscritent pour  filtrer l'affichage des propositions de qusetion a y ajouter
		for (Question question : questions) {
			listeIdQuestionSelect.add(question.getId());
		}

		for (Question q : questionsTrouvees) {
			if(q.getAnswers().size()>0) {									//je vérifie que la question a au moins une reponse
				//TODO : surveiller qu'une question utilisée ne peu pas se retrouver sans aucune réponse (à faire dans la gestion des question)
				if(!(listeIdQuestionSelect.contains(q.getId()))) {			//je vérifie que la question n'est pas déjà select dans ce qcm
					questionsTrouveesDTO.add(new QuestionDTO(q));
				}
			}
		}
		
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("questionsTrouveesDTO", questionsTrouveesDTO);
		model.addAttribute("BodyMCQ", mcq.getBody());
		model.addAttribute("idMCQ", id);
		model.addAttribute("questions", questions);

		// on renvoie le nom de la jsp
		return "ManagementMCQQuestionsDesigner";
	}
	
	//desinscrire question d'un qcm   
	@GetMapping(value = { "/{id}/sup/{questionId}" })    //id du qcm pour lequel nous allons sur la question d'id IdQuestion
	public String supQuestionsMcq(@PathVariable("id") int id,@PathVariable("questionId") int questionId, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");


		MCQService mcqService=new MCQService();
		//id correspond à l'ID du qcm
		mcqService.deleteQuestion(id, questionId);
		// on renvoie le nom de la jsp
		return "redirect:/ManagementMCQDesigner/"+id+"/questions";
	}	
	
	//inscription d'une question sur le qcm d'id "id"
	@PostMapping(value = { "/{id}/addQuestion" })    //id du qcm pour lequel nous allons ajouter une question
	public String gererQuestionsMcq(@PathVariable("id") int id, Question question, ObjectFiltresQuestion filtresQuestion, HttpSession session, Model model) {
//		Set<QuestionDTO> questionsTrouveesDTO=new HashSet<>();
		User user = (User) session.getAttribute("user");


		MCQService mcqService=new MCQService();
		MCQ mcq=mcqService.searchById(id);
		
		mcqService.addQuestion(mcq, question.getId());


		// on renvoie le nom de la jsp
		//return "redirect:/ManagementMCQDesigner/"+id+"/questions";
		// TODO: je ne parviens pas pour le moment à renvoyer des info en direct au controleur 
		// ..../id/filtre
		//Du coup, je fait le traitement et je retourne le tout sans repasser par lui
		Designer designer=user.getDesigner();
		QuestionService questionService=new QuestionService();
		List<Question> questions=questionService.searchByMcq(mcq);
		
		//la methode de la ligne suivante retourne les question qui correspondent aux critere parmis (body contient, theme contient, restrient au designer ou non)
		List<Question> questionsTrouvees=questionService.searchWithFiltre(filtresQuestion, designer);
		Set<QuestionDTO> questionsTrouveesDTO=new HashSet<>();
		
		List<Integer> listeIdQuestionSelect=new ArrayList<>();    //j'utilise un tableau des id des questions déjà inscritent pour  filtrer l'affichage des propositions de qusetion a y ajouter
		for (Question questionTmp : questions) {
			listeIdQuestionSelect.add(questionTmp.getId());
		}

		for (Question q : questionsTrouvees) {
			if(q.getAnswers().size()>0) {									//je vérifie que la question a au moins une reponse
				//TODO : surveiller qu'une question utilisée ne peu pas se retrouver sans aucune réponse (à faire dans la gestion des question)
				if(!(listeIdQuestionSelect.contains(q.getId()))) {			//je vérifie que la question n'est pas déjà select dans ce qcm
					questionsTrouveesDTO.add(new QuestionDTO(q));
				}
			}
		}
		
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("questionsTrouveesDTO", questionsTrouveesDTO);
		model.addAttribute("BodyMCQ", mcq.getBody());
		model.addAttribute("idMCQ", id);
		model.addAttribute("questions", questions);
		model.addAttribute("filtresQuestion", filtresQuestion);

		// on renvoie le nom de la jsp
		return "ManagementMCQQuestionsDesigner";
		
	}
	

//filtre des question candidates dans la page Management MCQQuestionDesigner
	//  ${idMCQ}/filtres
	@PostMapping(value = { "/{id}/filtres" })    //id du qcm pour lequel nous allons chercher d'autres questions
	public String listerQuestionsMcqFiltrees(@PathVariable("id") int id, ObjectFiltresQuestion filtresQuestion, HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
		
		Designer designer=user.getDesigner();
		
		MCQService mcqService=new MCQService();
		MCQ mcq=mcqService.searchById(id);
		QuestionService questionService=new QuestionService();
		List<Question> questions=questionService.searchByMcq(mcq);
		
		//la methode de la ligne suivante retourne les question qui correspondent aux critere parmis (body contient, theme contient, restrient au designer ou non)
		List<Question> questionsTrouvees=questionService.searchWithFiltre(filtresQuestion, designer);
		Set<QuestionDTO> questionsTrouveesDTO=new HashSet<>();
		
		List<Integer> listeIdQuestionSelect=new ArrayList<>();    //j'utilise un tableau des id des questions déjà inscritent pour  filtrer l'affichage des propositions de qusetion a y ajouter
		for (Question question : questions) {
			listeIdQuestionSelect.add(question.getId());
		}

		for (Question q : questionsTrouvees) {
			if(q.getAnswers().size()>0) {									//je vérifie que la question a au moins une reponse
				//TODO : surveiller qu'une question utilisée ne peu pas se retrouver sans aucune réponse (à faire dans la gestion des question)
				if(!(listeIdQuestionSelect.contains(q.getId()))) {			//je vérifie que la question n'est pas déjà select dans ce qcm
					questionsTrouveesDTO.add(new QuestionDTO(q));
				}
			}
		}
		
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("questionsTrouveesDTO", questionsTrouveesDTO);
		model.addAttribute("BodyMCQ", mcq.getBody());
		model.addAttribute("idMCQ", id);
		model.addAttribute("questions", questions);
		model.addAttribute("filtresQuestion", filtresQuestion);

		// on renvoie le nom de la jsp
		return "ManagementMCQQuestionsDesigner";
	}	

	
	@GetMapping(value = { "/statsMcq" })
	public String statsMCQs(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		MCQService mcqService=new MCQService();
		
		List<StatsMCQdto> statsMCQdtos=mcqService.StatsMcqs(user.getId());
		//pour recup tous les stats (de tout les mcq, passer 0 à la place de user.getId()
		//servira dans une autre methode pour les administrateurs
		 
		
        
		List<MCQ> mcqs=mcqService.searchByDesigner(user.getDesigner());

		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());
		model.addAttribute("newMcq", false);
		model.addAttribute("stats", true);
		model.addAttribute("mcqs", mcqs);
		model.addAttribute("statsMCQdtos", statsMCQdtos);
		return "MCQDesignerListe";
	}

	

	
	
	

	
	
	
}


