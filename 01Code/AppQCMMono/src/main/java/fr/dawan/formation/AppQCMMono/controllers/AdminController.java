package fr.dawan.formation.AppQCMMono.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Enum.TypeMultimedia;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.StatsMCQdto;
import fr.dawan.formation.AppQCMMono.Models.StatsQuestionDto;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.AdminService;
import fr.dawan.formation.AppQCMMono.Services.MCQService;
import fr.dawan.formation.AppQCMMono.Services.QuestionService;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;
import fr.dawan.formation.AppQCMMono.Services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/qcm")
	public String qcm(
			HttpSession session, Model model) {
		
		// on verifie que nous somme bien en mode admin avant d'afficher la page
		// si ce n'est pas le cas, on retoure à home
		User user=(User)(session.getAttribute("user"));
		if (!user.isAdmin()) {
			return "redirect:/home";
		}
		MCQService mcqService=new MCQService();
		List<MCQ> mcqs=new ArrayList<MCQ>();
		mcqs.addAll(mcqService.findAll());  //transforme un set en list
		
		
		//trier statsMCQdtos, du QCM le plus recemment jouer au plus ancien
		Collections.sort(mcqs, new Comparator<MCQ>() {
		    @Override
		    public int compare(MCQ MCQ1, MCQ MCQ2) {
		    	return (Integer.compare(MCQ1.getId(),MCQ2.getId()));
		    }
		});


		//certain des champs ci dessous ne sont pas utiles, c'est une reprise du controleur non admin
		//je prendrais le temps de nettoyer ....
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());
		model.addAttribute("newMcq", false);
		model.addAttribute("mcqs", mcqs);

		return "MCQDesignerListeAdmin";

	}
	
	
	@GetMapping("/qcm/stats")
	public String qcmStats(
			HttpSession session, Model model) {
		
		// on verifie que nous somme bien en mode admin avant d'afficher la page
		// si ce n'est pas le cas, on retoure à home
		User user=(User)(session.getAttribute("user"));
		if (!user.isAdmin()) {
			return "redirect:/home";
		}
		
		MCQService mcqService=new MCQService();
		List<StatsMCQdto> statsMCQdtos=mcqService.StatsMcqs(0);   //avec 0, tout les stats sont renvoyés
		

		//certain des champs ci dessous ne sont pas utiles, c'est une reprise du controleur non admin
		//je prendrais le temps de nettoyer ....
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());
		model.addAttribute("newMcq", false);
		model.addAttribute("statsMCQdtos", statsMCQdtos);
		
		return "MCQStatsListeAdmin";

	}
	
	
	
	
	
	
	
	
	

	@GetMapping("/question")
	public String question(
			HttpSession session, Model model) {
		
		// on verifie que nous somme bien en mode admin avant d'afficher la page
		// si ce n'est pas le cas, on retoure à home
		User user=(User)(session.getAttribute("user"));
		if (!user.isAdmin()) {
			return "redirect:/home";
		}
	
			QuestionService questionService = new QuestionService();
			
			List<Question> questions=new ArrayList<Question>();
			questions.addAll(questionService.findAll());  //transforme un set en list
			
			
			Collections.sort(questions, new Comparator<Question>() {
			    @Override
			    public int compare(Question Q1, Question Q2) {
			    	return (Integer.compare(Q1.getId(),Q2.getId()));
			    }
			});
			
			//certain des champs ci dessous ne sont pas utiles, c'est une reprise du controleur non admin
			//je prendrais le temps de nettoyer ....
			SessionServiceDTO ssdto = new SessionServiceDTO();
			ssdto.isDesignerService(user, model);
			model.addAttribute("questions", questions);
			model.addAttribute("enumStatus", Status.values());
			model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

			// on renvoie le nom de la jsp
			return "QuestionsDesignerListeAdmin";

	}
	
	
//	@GetMapping("/question/stats")
//	public String questionStats(
//			HttpSession session, Model model) {
//		
//		// on verifie que nous somme bien en mode admin avant d'afficher la page
//		// si ce n'est pas le cas, on retoure à home
//		User user=(User)(session.getAttribute("user"));
//		if (!user.isAdmin()) {
//			return "redirect:/home";
//		}
//		
//		QuestionService questionService=new QuestionService();
//		List<StatsQuestionDto> statsQuestiondtos=questionService.StatsQuestions(0);   //avec 0, tout les stats sont renvoyés
//		
//
//		//certain des champs ci dessous ne sont pas utiles, c'est une reprise du controleur non admin
//		//je prendrais le temps de nettoyer ....
//		SessionServiceDTO ssdto = new SessionServiceDTO();
//		ssdto.isDesignerService(user, model);
//		model.addAttribute("enumStatus", Status.values());
//		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());
//
//		model.addAttribute("statsQuestiondtos", statsQuestiondtos);
//		
//		return "QuestionStatsListeAdmin";
//
//	}
	
	@GetMapping("/question/stats")
	public String questionStatsV2(
			HttpSession session, Model model) {
		
		// on verifie que nous somme bien en mode admin avant d'afficher la page
		// si ce n'est pas le cas, on retoure à home
		User user=(User)(session.getAttribute("user"));
		if (!user.isAdmin()) {
			return "redirect:/home";
		}
		
		QuestionService questionService=new QuestionService();
		List<StatsQuestionDto> statsQuestiondtos=questionService.StatsQuestionsAll();   //avec 0, tout les stats sont renvoyés
		

		//certain des champs ci dessous ne sont pas utiles, c'est une reprise du controleur non admin
		//je prendrais le temps de nettoyer ....
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

		model.addAttribute("statsQuestiondtos", statsQuestiondtos);
		
		return "QuestionStatsListeAdmin";

	}
	
	
}
