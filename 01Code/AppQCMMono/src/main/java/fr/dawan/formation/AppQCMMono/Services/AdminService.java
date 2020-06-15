package fr.dawan.formation.AppQCMMono.Services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Service;

import fr.dawan.formation.AppQCMMono.Models.AdminTechniqueAppli;
import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.MailDTO;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.GenericDAO;
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
		
  
		if (mailDTO.getCible().equals("qcm")||mailDTO.getCible().equals("questionQcm")) {
			//le mail concerne un QCM, . le QCM doit être dans le mail et dans le titre
			//recupèrer		
			MCQService mcqService = new MCQService();
			MCQ mcq = mcqService.searchById(mailDTO.getMcqId());
			int l1=(mcq.getBody().length()>20)?19:mcq.getBody().length();
			objet=objet+" | QCM (id:"+mcq.getId()+") : "+mcq.getBody().substring(0, l1-1)+"...";
			
			body=body+"\r\n\r\n xxxxxxxxxxxxxx QCM concernée xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n"+
					"id : "+mcq.getId()+"\r\n"+
					"texte : "+mcq.getBody()+"\r\n"+
					"theme : "+mcq.getTopic()+"\r\n"+
					"lien Vignette Multimedia : "+mcq.getMultimedia().getAdresseVignette()+"\r\n"+
					"legende Multimedia : "+mcq.getMultimedia().getLegende()+"\r\n"+
					"lien Multimedia : "+mcq.getMultimedia().getAdresseCible()+"\r\n"+
					"\r\n\r\n";	
		}	
		if (mailDTO.getCible().equals("question")||mailDTO.getCible().equals("questionQcm")) {
			//le mail concerne une question, . la question doit être dans le mail et dans le titre
			//recupèrer les info de la question
			QuestionService questionService = new QuestionService();
			Question question = questionService.findById(mailDTO.getQuestionId());
			int l2=(question.getBody().length()>20)?19:question.getBody().length();
			objet=objet+"  | question (id:"+question.getId()+") : "+question.getBody().substring(0, l2-1)+"...";
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
		}
		
		body=body+"\r\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~ suivi ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\n\r\n";
		
		if (mailDTO.getCible().equals("admin")) {
				//ce mail concerne ni une question ni un QCM, c'est simplement un user qui souhaite s'adresser au administrateurs
		//pour le moment je ne vois rien à completer
			body=body+"\r\n\r\n\r\n\r\n Ce message vous est envoyé par "+user.getEmail() +" qui a souhaité écrire à l'administrateur de l'application. \r\n"+
					" Se message n'est pas en lien direct avec un QCM ou une Question. \r\n\r\n";
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
			//ligne suivant pour ne pas ecrire 2 fois à la même personne. (si designerQCM=designer de la question
			if (!mailDTO.isMailToQCMDesigner() || !adrQuestionDesigner.equals(adrQuestionDesigner))	email.addBcc(adrQuestionDesigner);  		
			body=body+"l'Utilisateur à souhaité envoyer ce mail au gestionnaire de cette Question \r\n";
		}  
		if (mailDTO.isEmetteurAnonyme()) {
				if (mailDTO.isMailToUser()) {
				email.addBcc(user.getEmail());
				body=body+"Une copie de ce mail a été conservée par l'utilisateur \r\n";
				}else {
					body=body+"L'utilisateur à fait le choix de rester anonyme (seul les admins ont une trace de cet envoie) \r\n";
				}
		}else {
				if (mailDTO.isMailToUser()) {
					email.addTo(user.getEmail());
					body=body+"Une copie de ce mail a été envoyée par l'utilisateur ("+user.getEmail()+"), vous pouvez donc lui répondre en utilisant 'Répondre à Tous' \r\n";
				}else if (!mailDTO.getCible().equals("admin")){
					body=body+"l'utilisateur à laissé son identité ("+user.getEmail()+"), vous pouvez donc le recontacter si vous le souhaitez \r\n";
				}	
		}
			
			
		
		
		
		body=body+"\r\n\r\n~~~~~~~~~~~infos techniques~~~~~~~~~~~ \r\n"+
				"id user à l'origine du mail : "+user.getId()+
				"\r\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\n";
		
		body=body+"\r\n\r\n Ceci est un message automatique. Merci de ne pas y répondre.\r\n" + 
				"Si vous souhaitez vous désinscrire .......";
		
		
		userDao.close();
		mailDTO.setTitre(objet);
		mailDTO.setBody(body);
		
		//envoi du mail
		
		//par la suite, possible de recup ces infos des l'entree dans l'appli, et stoker dans la session.
		AdminTechniqueAppli donneesAdmin=AdminTechniqueAppli.getInstance();
	    GenericDAO<AdminTechniqueAppli> adminDAO=new GenericDAO<AdminTechniqueAppli>(Constantes.PERSISTENCE_UNIT_NAME);
	    donneesAdmin=adminDAO.findById(AdminTechniqueAppli.class, 1);
	    adminDAO.close();
	    
	    

		
		//Email email = new HtmlEmail();   possible eventuellement de passer à un format de mail HTTP
		//email.setHostName("smtp.gmail.com");
		email.setHostName(donneesAdmin.getServeurSmtp());
		//email.setSmtpPort(465);
		email.setSmtpPort(donneesAdmin.getServeurSmtpPort());
		//email.setAuthenticator(new DefaultAuthenticator("quizizskillz@gmail.com", "@dawan20"));
		email.setAuthenticator(new DefaultAuthenticator(donneesAdmin.getServeurMailCompte(), donneesAdmin.getServeurMailComptePassword()));
		//email.setSSLOnConnect(true);
		email.setSSLOnConnect(donneesAdmin.isModeSSL());
		//email.setFrom("quizizskillz@gmail.com");
		email.setFrom(donneesAdmin.getMailAdmin());
		email.setSubject(objet);
		email.setMsg(body);
		email.send();       //decommenter la ligne pour activer l'envois de mail
		return mailDTO;
		     
		
	}

	public boolean getPasswordAdmin(String password) {
		// pour le moment, je met le passord admin en claire en base de données
		//il sera ensuite possible de le crypter (lorsque l'ecran pour le générer sera fait
		AdminTechniqueAppli donneesAdmin=AdminTechniqueAppli.getInstance();
	    GenericDAO<AdminTechniqueAppli> adminDAO=new GenericDAO<AdminTechniqueAppli>(Constantes.PERSISTENCE_UNIT_NAME);
	    donneesAdmin=adminDAO.findById(AdminTechniqueAppli.class, 1);
	    adminDAO.close();
		if (donneesAdmin.getAdminPassword().equals(password)) {
			return true;
		}else {
		return false;
		}
	}

	
	
	
	
}
