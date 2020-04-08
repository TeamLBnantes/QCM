package fr.dawan.formation.AppQCMMono.Services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Service;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.MailDTO;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.UserDAO;

@Service
public class AdminService {

	public MailDTO envoyerMail(MailDTO mailDTO, User user) throws EmailException{
		UserDAO userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME); //j'ouvre un acces au service DAO de User
		Email email = new SimpleEmail(); //création de l'objet utilisé pour envoyer le mail
		// pour le moment je vais me contenter d'envoyer un mail à l'administrateur
		//avec une adresse en dure, ce sera l'adresse du quiz, quizizskillz@gmail.com
		//pour les autres (concepteur et user, j'utilise les adresses de la base)
		//mise en forme du mail
		String body=mailDTO.getBody();
		String objet=mailDTO.getTitre();
		
		switch (mailDTO.getCible()) {     
		case "question":	//le mail concerne une question, mais pas de lien avec un qcm. la question doit être dans le mail et dans le titre
			//recupèrer les info de la question
			QuestionService questionService = new QuestionService();
			Question question = questionService.findById(mailDTO.getQuestionId());
			
			objet=objet+"  | question (id:"+question.getId()+") : "+question.getBody().substring(0, 20)+"...";
			
			body=body+"\r\n\r\n xxxxxxxxxxxxxx question concernée xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n"+
					"id : "+question.getId()+"\r\n"+
					"texte : "+question.getBody()+"\r\n"+
					"theme : "+question.getTheme()+"\r\n"+
					"commentaire post réponse : "+question.getCommentPostAnswer()+"\r\n"+
					"\r\n-------------- reponses proposées --------------------\r\n";
			for (Answer rep : question.getAnswers()) {
				body=body+"id : "+rep.getId()+"\r\n"+
				"texte : "+rep.getBody()+"\r\n"+
				"rep attendu : "+rep.isExpectedAnswer()+"\r\n"+
				"commentaire post réponse : "+question.getCommentPostAnswer()+"\r\n"+
				"-------------- \r\n";	
			}
			body=body+" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n\r\n";
			break;
		case "qcm":
			
			break;
		case "qcmQuestion":
			
			break;
		default: //le mail ne concerne ni une question ni un qcm, il sera donc à destination exclusive de l'administrateur
			
			break;
		}
		
		
		if (mailDTO.isMailToAdmin()) {
			email.addBcc("quizizskillz@gmail.com");  //donc adresse en dur pour le moment
			body=body+"l'Utilisateur à souhaité envoyer ce mail à l'administrateur de l'application\r\n";
		}
		if (mailDTO.isMailToQCMDesigner()) {
			String adrQCMDesigner=userDao.searchMailDesignerByMcqId(mailDTO.getMcqId()).getEmail();
			email.addBcc(adrQCMDesigner);  //donc adresse en dur pour le moment
			body=body+"l'Utilisateur à souhaité envoyer ce mail au gestionnaire de ce QCM \r\n";
		}
		
		if (mailDTO.isMailToQuestionDesigner()) {
			String adrQuestionDesigner=userDao.searchMailDesignerByQuestionId(mailDTO.getQuestionId()).getEmail();
			email.addBcc(adrQuestionDesigner);  //donc adresse en dur pour le moment
			body=body+"l'Utilisateur à souhaité envoyer ce mail au gestionnaire de cette Question \r\n";
		}
		
		if (mailDTO.isMailToUser()) {
			  
			if (mailDTO.isEmetteurAnonyme()) {
				email.addBcc(user.getEmail());
				body=body+"Une copie de ce mail a été conservée par l'utilisateur \r\n";
			}else {
				email.addTo(user.getEmail());
				body=body+"Une copie de ce mail a été envoyée par l'utilisateur, vous pouvez donc lui répondre en utilisant 'Répondre à Tous' \r\n";
			}
			
		}
		
		
		body=body+"\r\n\r\n~~~~~~~~~~~infos techniques~~~~~~~~~~~ \r\n"+
				"id user à l'origine du mail : "+mailDTO.getUserId()+
				"\r\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\n";
		
		body=body+"\r\n\r\n Ceci est un message automatique. Merci de ne pas y répondre.\r\n" + 
				"Si vous souhaitez vous désinscrire .......";
		
		
		userDao.close();
		
		mailDTO.setBody(body);
		
		//envoi du mail
		
		//Email email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
//		email.setAuthentication("quizizskillz@gmail.com", "@dawan20");
//		email.setSSL(true);
		email.setAuthenticator(new DefaultAuthenticator("quizizskillz@gmail.com", "@dawan20"));
		email.setSSLOnConnect(true);
		email.setFrom("quizizskillz@gmail.com");
		email.setSubject(objet);
		email.setMsg(body);
//		email.setMsg("mon message");
//		email.addTo("laurent.boureau.nant@gmail.com");
//		email.addTo("quizizskillz@gmail.com");
		email.send();
		return mailDTO;
		
	}

	
	
	
	
}
