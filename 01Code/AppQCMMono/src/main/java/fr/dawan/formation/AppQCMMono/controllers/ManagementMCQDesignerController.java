package fr.dawan.formation.AppQCMMono.controllers;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.AnswerService;
import fr.dawan.formation.AppQCMMono.Services.MCQService;
import fr.dawan.formation.AppQCMMono.Services.QuestionService;
import fr.dawan.formation.AppQCMMono.Services.UserService;

@Controller
@RequestMapping("/ManagementMCQDesigner")
public class ManagementMCQDesignerController {

	@GetMapping(value = { "" })
	public String hello(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		MCQService mcqService=new MCQService();
		List<MCQ> mcqs=mcqService.searchByDesigner(user.getDesigner());
		
		//for (Question question : questions) {
		//	System.out.println(question);
		//}
		model.addAttribute("newMcq", false);
		model.addAttribute("mcqs", mcqs);
		//model.addAttribute("enumStatus", Status.values());
		// on renvoie le nom de la jsp
		return "MCQDesignerListe";
	}
	
	//     /delete/${mcq.id}
	//TODO : attention, je ne met pas de secours, un clique et pas de retour arrière. Il faudra demander une confirmation
	@GetMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable("id") int id, HttpSession session, Model model) {
		
		MCQService mcqService=new MCQService();
		mcqService.deleteById(id);
			
		// on renvoie le nom de la jsp
		return "redirect:/ManagementMCQDesigner";
	}
	
	
//	@GetMapping(value = { "/{id}" })    //id de la question à cibler
//	public String afficherQuestion(@PathVariable("id") int id, HttpSession session, Model model) {
//
//		User user = (User) session.getAttribute("user");
//
//		QuestionService questionService=new QuestionService();
//		List<Question> questions=questionService.searchByDesigner(user.getDesigner());
//		Question question=questionService.findById(id);
//
//		
//		model.addAttribute("Response", false);
//		model.addAttribute("question", question);
//		model.addAttribute("questions", questions);
//		model.addAttribute("enumStatus", Status.values());
//		// on renvoie le nom de la jsp
//		return "ManagementQuestionDesigner";
//	}
	
	@GetMapping(value = { "/new" })    
	public String renseignerNouvelleQuestion(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		MCQService mcqService=new MCQService();
		List<MCQ> mcqs=mcqService.searchByDesigner(user.getDesigner());
		
		//for (Question question : questions) {
		//	System.out.println(question);
		//}
		model.addAttribute("newMcq", true);
		model.addAttribute("mcqs", mcqs);
		//model.addAttribute("enumStatus", Status.values());
		// on renvoie le nom de la jsp
		return "MCQDesignerListe";
	}
	
//	@GetMapping(value = { "/newResponse/{id}" })    //id de la question à cibler
//	public String renseignerNouvelleReponse(@PathVariable("id") int id, HttpSession session, Model model) {
//
//		User user = (User) session.getAttribute("user");
//
//		QuestionService questionService=new QuestionService();
//		List<Question> questions=questionService.searchByDesigner(user.getDesigner());
//		Question question=questionService.findById(id);
//		Answer answer=new Answer();
//		answer.setId(0);
//		
//		model.addAttribute("Response", true);
//		model.addAttribute("answer", answer);
//		model.addAttribute("question", question);
//		model.addAttribute("questions", questions);
//		model.addAttribute("enumStatus", Status.values());
//		// on renvoie le nom de la jsp
//		return "ManagementQuestionDesigner";
//	}
	
//	@GetMapping(value = { "/updateResponse/{idQuestion}/{idAnswer}" })    //id de la reponse à cibler
//	public String majAffichageReponse(
//				@PathVariable("idQuestion") int idQuestion, 
//				@PathVariable("idAnswer") int idAnswer, 
//				HttpSession session, 
//				Model model) {
//
//		
//		QuestionService questionService=new QuestionService();
//		
//		Question question=questionService.findById(idQuestion);
//		Answer answer=null;
//		for (Answer q : question.getAnswers()) {
//			if (q.getId()==idAnswer) answer=q;
//		}
//		
//		model.addAttribute("Response", true);
//		model.addAttribute("answer", answer);
//		model.addAttribute("question", question);
//		//model.addAttribute("questions", questions);
//		model.addAttribute("enumStatus", Status.values());
//		// on renvoie le nom de la jsp
//		return "ManagementQuestionDesigner";
//	}
	
	//////enregistrement du nouveau qcm
	//     createMCQ
	@PostMapping("createMCQ")
	public String createMcq(MCQ mcq, HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
		MCQService mcqService=new MCQService();
		mcq.setDesigner(user.getDesigner());
		mcqService.create(mcq);
		
		return "redirect:/ManagementMCQDesigner";
	}
	
	
	
	
//	@PostMapping("updateQuestion")
//	public String updateQuestion(Question question, HttpSession session, Model model) {
//		
//		
//		QuestionService questionService=new QuestionService();
//		UserService userService=new UserService();
//		
//		System.out.println("l'id de la question est : " +question.getId());
//		System.out.println("le body (avant saveor update)est  : " +question.getBody());
//		
//		Question questionMaj=new Question();
//		if (question.getId()==0) {
//			
//			User user = (User) session.getAttribute("user");
//			user=userService.findById(user.getId());
//			//question.setDesigner(user.getDesigner());
//			//questionMaj.setDesigner(question.getDesigner());
//			questionMaj.setDesigner(user.getDesigner());
//			
//		}else {
//			questionMaj=questionService.findById(question.getId());
//		}
//		
//		
//		
//		questionMaj.setBody(question.getBody());
//		questionMaj.setCommentPostAnswer(question.getCommentPostAnswer());
//		questionMaj.setStatus(question.getStatus());
//		
//		
//		
//		question=questionService.saveOrUpdate(questionMaj);
//
//		question=questionService.findById(question.getId());
//		System.out.println("le body (apres le find est  )est  : " +question.getBody());
//
//		
//		model.addAttribute("Response", false);
//		model.addAttribute("question", question);
//		//model.addAttribute("questions", questions);
//		model.addAttribute("enumStatus", Status.values());
//		// on renvoie le nom de la jsp
//		return "ManagementQuestionDesigner";
//	}
	

	
//	@PostMapping("updateAnswer/{idQuestion}")      //c'est ici l'id de la question liée
//	public String updateAnswer(
//				Answer answer, 
//				@PathVariable("idQuestion") int idQuestion,  
//				HttpSession session, 
//				Model model) {
//		User user = (User) session.getAttribute("user");
//		QuestionService questionService=new QuestionService();
//		
//		Question question=questionService.findById(idQuestion);
//		
//		if (answer.getId()==0) {
//				question.getAnswers().add(answer);
//				answer.setQuestion(question);
//				question=questionService.saveOrUpdate(question);
//		}else {
//			answer.setQuestion(question);
//			AnswerService answerService=new AnswerService();
//			answer=answerService.saveOrUpdate(answer);
//		
//		}
//		
//		//
//			
//
//		//List<Question> questions=questionService.searchByDesigner(user.getDesigner());
//		question=questionService.findById(idQuestion);
//		
//		model.addAttribute("Response", false);
//		model.addAttribute("question", question);
//		//model.addAttribute("questions", questions);
//		model.addAttribute("enumStatus", Status.values());
//		// on renvoie le nom de la jsp
//		return "ManagementQuestionDesigner";
//	}
//	
//	//    deleteResponse/${question.id}/${answer.id}
	
//	@GetMapping(value = { "deleteResponse/{idQuestion}/{idAnswer}" })    //id de la reponse à cibler
//	public String deleteReponse(
//				@PathVariable("idQuestion") int idQuestion, 
//				@PathVariable("idAnswer") int idAnswer, 
//				HttpSession session, 
//				Model model) {
//
//		QuestionService questionService=new QuestionService();
//		Question question=questionService.findById(idQuestion);
//		AnswerService answerService=new AnswerService();
//		//todo : enlever la ref vers la reponse d'id idAnswer
//		//Answer a=answerService.findById(idAnswer);
//		
//
//		Set<Answer> newAnswers=new HashSet<Answer>();
//		for (Answer answer : question.getAnswers()) {
//			if (answer.getId()!=idAnswer) newAnswers.add(answer);
//		}
//		System.out.println(newAnswers);
//		System.out.println(question.getAnswers());
//		question.setAnswers(newAnswers);
//		
//
//	      System.out.println(question.getAnswers());
//
//		
//		question=questionService.saveOrUpdate(question);
//
//		question=questionService.findById(idQuestion);
//		
//		answerService.deleteById(idAnswer);
//		
//		
//
//		
//		
//		
//		
//		model.addAttribute("Response", false);
//
//		model.addAttribute("question", question);
//		//model.addAttribute("questions", questions);
//		model.addAttribute("enumStatus", Status.values());
//		// on renvoie le nom de la jsp
//		return "ManagementQuestionDesigner";
//	}
	
	
	
}
