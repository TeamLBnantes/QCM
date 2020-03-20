package fr.dawan.formation.AppQCMMono.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.ObjectFiltresMCQ;
import fr.dawan.formation.AppQCMMono.Models.ObjectPasserMcq;
import fr.dawan.formation.AppQCMMono.Models.ObjectQuestionCorrection;
import fr.dawan.formation.AppQCMMono.Models.ObjectReponseCorrection;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.MCQService;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;

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
//		Set<MCQ> mcqs=mcqService.findAll();         //je vais affiner en ne proposant que les QCM qui sont à l'etat pret, et qui comporte au moint une question
		List<MCQ> mcqs=mcqService.findPlayable();
		
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
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
		
		
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("mcqs", mcqs);
		model.addAttribute("filtresMCQ", filtresMCQ);
	
	return "PasserMCQListe";
}
	
	//controleur pour lancer le QCM d'ID id
	@GetMapping(value= {"/{id}/init"})
	public String lancer(@PathVariable("id") int id, HttpSession session, Model model) {
		
		User user = (User)session.getAttribute("user");
		MCQService mcqService=new MCQService();
		MCQ mcq=mcqService.searchById(id);
		
		ObjectPasserMcq tarckMcq=mcqService.initTrackMcq(mcq, user);
		session.setAttribute("tarckMcq", tarckMcq);
		//juste pour vérifier que je le recupère bien dans la session
		//il faudra penser à la sup à la fin
//		ObjectPasserMcq tarckMcq2=(ObjectPasserMcq)session.getAttribute("tarckMcq");
//		System.out.println(tarckMcq2);
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("tarckMcq", tarckMcq);
		model.addAttribute("mcq", mcq);
		// on renvoie le nom de la jsp
		return "PasserMCQ";
	}
	
	
	@PostMapping(value= {"/next"})
	public String suivante(ObjectQuestionCorrection reponsesUser, HttpSession session, Model model) {
		Question question=null;
		int pointeurQuestionAfficher;
		User user = (User)session.getAttribute("user");
		ObjectPasserMcq tarckMcq=(ObjectPasserMcq)session.getAttribute("tarckMcq");
		MCQService mcqService=new MCQService();
	//	MCQ mcq=mcqService.searchById(tarckMcq.getMcqPassed().getMcq().getId());
		MCQ mcq=tarckMcq.getMcqPassed().getMcq();
		boolean bonnesReponses=true;
		//calcul de la valeur de étape
		switch (tarckMcq.getEtape()) {
		//################################envoyer la premiere question (question suivante)##################################################################################
		case "beforeMCQ":    //je viens de la page d'accueil du QCM, je vais envoyer la premiere question (question suivante)
			tarckMcq.setEtape("question");
			
			pointeurQuestionAfficher=tarckMcq.getNbQuestionsPassed();
			question=tarckMcq.getListQuestionsUsed().get(pointeurQuestionAfficher).getQuestion();
			
			
			
			
			break;
		//#############################la corriger et envoyer la correction #####################################################################################
		case "question":     //je viens d'une question, je vais la corriger et envoyer la correction 
			tarckMcq.setEtape("correction");
			
			pointeurQuestionAfficher=tarckMcq.getNbQuestionsPassed();
			question=tarckMcq.getListQuestionsUsed().get(pointeurQuestionAfficher).getQuestion();
			//on corrige la question

			//ObjectQuestionCorrection reponsesDesigner=new ObjectQuestionCorrection();
			List<ObjectReponseCorrection> reponsesDesigner=new ArrayList<>();
			Set<Answer> listeReponseDesigner=question.getAnswers();
			for (Answer answer : listeReponseDesigner) {
				ObjectReponseCorrection repDesigner=new ObjectReponseCorrection();
				repDesigner.setIdRepCor(answer.getId());
				repDesigner.setRepUser(answer.isExpectedAnswer());
				//reponsesDesigner.getReponsesUser().add(repDesigner);
				reponsesDesigner.add(repDesigner);
			}
			

			for (ObjectReponseCorrection rep : reponsesUser.getReponsesUser()) {
				//for (ObjectReponseCorrection repDesigner :  reponsesDesigner.getReponsesUser()) {
				for (ObjectReponseCorrection repDesigner :  reponsesDesigner) {	
				if (rep.getIdRepCor()==repDesigner.getIdRepCor()) {
						if (rep.isRepUser()==repDesigner.isRepUser()) {
							rep.setAsDesigner(true);
						}else {
							bonnesReponses = false;
							rep.setAsDesigner(false);
						}
					}
				}	
			}
			
			//on met à jour le trackMcq
			if (bonnesReponses) tarckMcq.setNbBonnesReponses(tarckMcq.getNbBonnesReponses()+1);	
			tarckMcq.setNbQuestionsPassed(pointeurQuestionAfficher+1);
			
			break;
		
		case "correction":    
			//###########################passage  à la suivante#######################################################################################
			if(tarckMcq.getNbQuestionsTotal()!=tarckMcq.getNbQuestionsPassed()) {
				tarckMcq.setEtape("question");	//je viens d'une correction, il reste des questions, donc passage  à la suivante 
			
				pointeurQuestionAfficher=tarckMcq.getNbQuestionsPassed();
				question=tarckMcq.getListQuestionsUsed().get(pointeurQuestionAfficher).getQuestion();
				
				
				//########################passage  à l'ecran de cloture ##########################################################################################
			}else {
				tarckMcq.setEtape("endMCQ");	//je viens d'une correction, il reste plus de question, donc passage  à l'ecran de cloture 
				//TODO: afficher la page resultat et enregistrer en bdd
				
				
			}
			break;	
		//##################################################################################################################
		default:
			break;
		}

		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("repsUserCOrrigees", reponsesUser.getReponsesUser());
		model.addAttribute("bonnesReponses", bonnesReponses);
		
		session.setAttribute("tarckMcq", tarckMcq);
		System.out.println(tarckMcq);
		model.addAttribute("question", question);
		model.addAttribute("tarckMcq", tarckMcq);
		model.addAttribute("mcq", mcq);
		// on renvoie le nom de la jsp
		return "PasserMCQ";
	}
	
	
	
	
}