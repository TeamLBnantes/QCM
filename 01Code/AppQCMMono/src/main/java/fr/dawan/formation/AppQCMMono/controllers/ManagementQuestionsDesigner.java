package fr.dawan.formation.AppQCMMono.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.QuestionService;

@Controller
@RequestMapping("/ManagementQuestionsDesigner")
public class ManagementQuestionsDesigner {

	@GetMapping(value = { "" })
	public String hello(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		QuestionService questionService=new QuestionService();
		List<Question> questions=questionService.searchByDesigner(user.getDesigner());
		
		for (Question question : questions) {
			System.out.println(question);
		}
		
		model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		// on renvoie le nom de la jsp
		return "QuestionsDesignerListe";
	}
	
	
	@GetMapping(value = { "/{id}" })    //id de la question à cibler
	public String afficherQuestion(@PathVariable("id") int id, HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		QuestionService questionService=new QuestionService();
		List<Question> questions=questionService.searchByDesigner(user.getDesigner());
		Question question=questionService.findById(id);
		
		model.addAttribute("question", question);
		model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		// on renvoie le nom de la jsp
		return "ManagementQuestionDesigner";
	}
	
	@GetMapping(value = { "/new" })    
	public String renseignerNouvelleQuestion(HttpSession session, Model model) {

		//User user = (User) session.getAttribute("user");
		model.addAttribute("newResponse", true);
		model.addAttribute("enumStatus", Status.values());
		// on renvoie le nom de la jsp
		return "ManagementQuestionDesigner";
	}
	
	
}
