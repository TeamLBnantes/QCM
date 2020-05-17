package fr.dawan.formation.AppQCMMono.controllers;

import java.time.LocalDateTime;
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
import fr.dawan.formation.AppQCMMono.Enum.TypeMultimedia;
import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.Multimedia;
import fr.dawan.formation.AppQCMMono.Models.ObjectListDto;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.AnswerService;
import fr.dawan.formation.AppQCMMono.Services.MCQService;
import fr.dawan.formation.AppQCMMono.Services.QuestionService;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;
import fr.dawan.formation.AppQCMMono.Services.UserService;

@Controller
@RequestMapping("/ManagementQuestionsDesigner")
public class ManagementQuestionsDesignerController {

	@GetMapping(value = { "" })
	public String hello(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		QuestionService questionService = new QuestionService();
		List<Question> questions = questionService.searchByDesigner(user.getDesigner());

		for (Question question : questions) {
			System.out.println(question);
		}
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

		// on renvoie le nom de la jsp
		return "QuestionsDesignerListe";
	}

	// /delete/${question.id}
	@GetMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable("id") int id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		QuestionService questionService = new QuestionService();
		questionService.deleteById(id);

		List<Question> questions = questionService.searchByDesigner(user.getDesigner());
		
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

		// on renvoie le nom de la jsp
		return "QuestionsDesignerListe";
	}

	//eran de modification de la question
	@GetMapping(value = { "/{id}" }) // id de la question à cibler
	public String afficherQuestion(@PathVariable("id") int id, HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");
		QuestionService questionService = new QuestionService();
		//TODO: il me semble que la ligne suivant ene sert à rien, on gere ici une question, pas la liste des question de l'utilisateur
		List<Question> questions = questionService.searchByDesigner(user.getDesigner());
		Question question = questionService.findById(id);
		
		//recuperation de la liste des QCM qui utilisent cette question
		ObjectListDto listDto=new ObjectListDto();
		//findMcqByIdQuestion est une methode static de MCQService, donc inutile d'instancier un MCQService
		listDto.setMcqs(MCQService.findMcqByIdQuestion(id));
		model.addAttribute("listDto", listDto);
		
		
		SessionServiceDTO ssdto = new SessionServiceDTO();
		//l'User est designer?
		ssdto.isDesignerService(user, model);
		// avons nous déjà 6 réponses ?
		ssdto.nbMaxAnswers(model, question);

		
		model.addAttribute("Response", false);
		model.addAttribute("question", question);
		//TODO: et donc la ligne suivante ne sert pas non pls à rand chose
		model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

		// on renvoie le nom de la jsp
		return "ManagementQuestionDesigner";
	}

	
//creation d'une question
	@GetMapping(value = { "/new" })
	public String renseignerNouvelleQuestion(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");
		
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		model.addAttribute("Response", false);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

		// on renvoie le nom de la jsp
		return "ManagementQuestionDesigner";
	}

	//demande affichage de la page ajout d'une reponse à la question d'id id
	@GetMapping(value = { "/newResponse/{id}" }) // id de la question à cibler
	public String renseignerNouvelleReponse(@PathVariable("id") int id, HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		QuestionService questionService = new QuestionService();
		List<Question> questions = questionService.searchByDesigner(user.getDesigner());
		Question question = questionService.findById(id);
		Answer answer = new Answer();
		answer.setId(0);
		SessionServiceDTO ssdto = new SessionServiceDTO();
		ssdto.isDesignerService(user, model);
		ssdto.nbMaxAnswers(model, question);

		//recuperation de la liste des QCM qui utilisent cette question
		ObjectListDto listDto=new ObjectListDto();
		//findMcqByIdQuestion est une methode static de MCQService, donc inutile d'instancier un MCQService
		listDto.setMcqs(MCQService.findMcqByIdQuestion(id));
		model.addAttribute("listDto", listDto);
		
		
		model.addAttribute("Response", true);
		model.addAttribute("answer", answer);
		model.addAttribute("question", question);
		model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());
		
		// on renvoie le nom de la jsp
		return "ManagementQuestionDesigner";
	}

//enregistrement de la rep .... de la question ....	
	@GetMapping(value = { "/updateResponse/{idQuestion}/{idAnswer}" }) // id de la reponse à cibler
	public String majAffichageReponse(@PathVariable("idQuestion") int idQuestion,
			@PathVariable("idAnswer") int idAnswer, HttpSession session, Model model) {

		QuestionService questionService = new QuestionService();

		Question question = questionService.findById(idQuestion);
		Answer answer = null;
		for (Answer q : question.getAnswers()) {
			if (q.getId() == idAnswer)
				answer = q;
		}
		SessionServiceDTO ssdto = new SessionServiceDTO();
		User user = ssdto.sessionUserService(session);
		ssdto.isDesignerService(user, model);
		ssdto.nbMaxAnswers(model, question);
		
		//recuperation de la liste des QCM qui utilisent cette question
		ObjectListDto listDto=new ObjectListDto();
		//findMcqByIdQuestion est une methode static de MCQService, donc inutile d'instancier un MCQService
		listDto.setMcqs(MCQService.findMcqByIdQuestion(idQuestion));
		model.addAttribute("listDto", listDto);
		
		model.addAttribute("Response", true);
		model.addAttribute("answer", answer);
		model.addAttribute("question", question);
		// model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

		// on renvoie le nom de la jsp
		return "ManagementQuestionDesigner";
	}

	//maj de la question
	@PostMapping("updateQuestion")
	public String updateQuestion(Question question, HttpSession session, Model model) {


		QuestionService questionService = new QuestionService();
		UserService userService = new UserService();

		System.out.println("l'id de la question est : " + question.getId());
		System.out.println("le body (avant save or update)est  : " + question.getBody());
		

		Question questionMaj = new Question();

		

			if (question.getId() == 0) {

				User user = (User) session.getAttribute("user");
				user = userService.findById(user.getId());
				// question.setDesigner(user.getDesigner());
				// questionMaj.setDesigner(question.getDesigner());
				questionMaj.setDesigner(user.getDesigner());
				questionMaj.setCreateDate(LocalDateTime.now());
				questionMaj.setEditDate(LocalDateTime.now());
				Multimedia multimedia = new Multimedia();
				questionMaj.setMultimedia(multimedia);


			} else {
				questionMaj = questionService.findById(question.getId());
				
				//recuperation de la liste des QCM qui utilisent cette question
				ObjectListDto listDto=new ObjectListDto();
				//findMcqByIdQuestion est une methode static de MCQService, donc inutile d'instancier un MCQService
				listDto.setMcqs(MCQService.findMcqByIdQuestion(question.getId()));
				model.addAttribute("listDto", listDto);
				
			}

			questionMaj.setEditDate(LocalDateTime.now());
			questionMaj.setTopic(question.getTopic());
			questionMaj.setBody(question.getBody());
			questionMaj.setCommentPostAnswer(question.getCommentPostAnswer());
			questionMaj.setStatus(question.getStatus());
			questionMaj = questionService.saveOrUpdate(questionMaj);


			//mise à jour des données de l'objet multimedia. (il sera sauvegardé par la sauvegarde
			// de mcq update, et le lien fort entre les deux table
			//poura aventageusement etre remplacé par une methode ServiceMultimedia.update(old, new)
			
			if (question.getMultimedia() != null){
				
			questionMaj.getMultimedia().setAdresseCible(question.getMultimedia().getAdresseCible());
			questionMaj.getMultimedia().setAdresseVignette(question.getMultimedia().getAdresseVignette());
			questionMaj.getMultimedia().setLegende(question.getMultimedia().getLegende());
			questionMaj.getMultimedia().setTypeMultimedia(question.getMultimedia().getTypeMultimedia());
			
			}
	

			question = questionService.saveOrUpdate(questionMaj);

			question = questionService.findById(question.getId());
			
		
		System.out.println("le body (apres le find est  )est  : " + question.getBody());
		SessionServiceDTO ssdto = new SessionServiceDTO();
		User user = ssdto.sessionUserService(session);
		ssdto.isDesignerService(user, model);
		ssdto.nbMaxAnswers(model, question);
		model.addAttribute("Response", false);
		model.addAttribute("question", question);
		// model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

		// on renvoie le nom de la jsp
		return "ManagementQuestionDesigner";
	}

	@PostMapping("updateAnswer/{idQuestion}") // c'est ici l'id de la question liée
	public String updateAnswer(Answer answer, @PathVariable("idQuestion") int idQuestion, HttpSession session,
			Model model) {
		User user = (User) session.getAttribute("user");
		QuestionService questionService = new QuestionService();

		Question question = questionService.findById(idQuestion);

		if (answer.getId() == 0) {
			question.getAnswers().add(answer);
			answer.setQuestion(question);
			question = questionService.saveOrUpdate(question);
		} else {
			answer.setQuestion(question);
			AnswerService answerService = new AnswerService();
			answer = answerService.saveOrUpdate(answer);

		}

		//

		// List<Question>
		// questions=questionService.searchByDesigner(user.getDesigner());
		question = questionService.findById(idQuestion);
		SessionServiceDTO ssdto = new SessionServiceDTO();

		ssdto.isDesignerService(user, model);
		ssdto.nbMaxAnswers(model, question);
		
		
		//recuperation de la liste des QCM qui utilisent cette question
		ObjectListDto listDto=new ObjectListDto();
		//findMcqByIdQuestion est une methode static de MCQService, donc inutile d'instancier un MCQService
		listDto.setMcqs(MCQService.findMcqByIdQuestion(idQuestion));
		model.addAttribute("listDto", listDto);
		
		model.addAttribute("Response", false);
		model.addAttribute("question", question);
		// model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

		// on renvoie le nom de la jsp
		return "ManagementQuestionDesigner";
	}

	// deleteResponse/${question.id}/${answer.id}
	// 

	@GetMapping(value = { "deleteResponse/{idQuestion}/{idAnswer}" }) // id de la reponse à cibler
	public String deleteReponse(@PathVariable("idQuestion") int idQuestion, @PathVariable("idAnswer") int idAnswer,
			HttpSession session, Model model) {

		QuestionService questionService = new QuestionService();
		Question question = questionService.findById(idQuestion);
		AnswerService answerService = new AnswerService();
		// todo : enlever la ref vers la reponse d'id idAnswer
		// Answer a=answerService.findById(idAnswer);

		//recuperation de la liste des QCM qui utilisent cette question
		ObjectListDto listDto=new ObjectListDto();
		//findMcqByIdQuestion est une methode static de MCQService, donc inutile d'instancier un MCQService
		listDto.setMcqs(MCQService.findMcqByIdQuestion(idQuestion));
		model.addAttribute("listDto", listDto);
		
		int nbQcmUsedQ=listDto.getMcqs().size();
		int nbRepBeforeDel=question.getAnswers().size();
		if ((nbRepBeforeDel>1)||(nbQcmUsedQ==0)) {
				//sup de la derniere reponse uniquement si aucun qcm rataché
				Set<Answer> newAnswers = new HashSet<Answer>();
				for (Answer answer : question.getAnswers()) {
					if (answer.getId() != idAnswer)
						newAnswers.add(answer);
				}
				//System.out.println(newAnswers);
				//System.out.println(question.getAnswers());
				question.setAnswers(newAnswers);
				//System.out.println(question.getAnswers());
				question = questionService.saveOrUpdate(question);
				question = questionService.findById(idQuestion);
				answerService.deleteById(idAnswer);
		}

		SessionServiceDTO ssdto = new SessionServiceDTO();
		User user = ssdto.sessionUserService(session);
		ssdto.isDesignerService(user, model);
		ssdto.nbMaxAnswers(model, question);
		

		
		model.addAttribute("Response", false);

		model.addAttribute("question", question);
		// model.addAttribute("questions", questions);
		model.addAttribute("enumStatus", Status.values());
		model.addAttribute("enumTypeMultimedia", TypeMultimedia.values());

		// on renvoie le nom de la jsp
		return "ManagementQuestionDesigner";
	}

}
