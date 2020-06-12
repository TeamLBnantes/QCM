package fr.dawan.QuestionQCM.Services;



import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.QuestionQCM.Beans.AdminTechniqueAppli;
import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.Beans.MCQpassed;
import fr.dawan.QuestionQCM.Repositories.AdminTechniqueRepository;


@Service
public class MailService {

	@Autowired
	private AdminTechniqueRepository repository;
	@Autowired
	private MCQpassedService mcqPassedService;
	
	public String signaler(int idQcm, int idQuestion, String cause)  throws EmailException{
		
		AdminTechniqueAppli donneesAdmin = repository.findById(1).orElse(null);
		
		if (donneesAdmin == null) {
			return null;
		}
		//les infos ont été trouvée, on va donc envoyer le mail aux admins
		Email email = new SimpleEmail(); //création de l'objet utilisé pour envoyer le mail
		// pour le moment je vais me contenter d'envoyer un mail à l'administrateur
		email.setHostName(donneesAdmin.getServeurSmtp());
		//email.setSmtpPort(465);
		email.setSmtpPort(donneesAdmin.getServeurSmtpPort());
		//email.setAuthenticator(new DefaultAuthenticator("quizizskillz@gmail.com", "@dawan20"));
		email.setAuthenticator(new DefaultAuthenticator(donneesAdmin.getServeurMailCompte(), donneesAdmin.getServeurMailComptePassword()));
		//email.setSSLOnConnect(true);
		email.setSSLOnConnect(donneesAdmin.isModeSSL());
		//email.setFrom("quizizskillz@gmail.com");
		email.setFrom(donneesAdmin.getMailAdmin());
		email.addTo(donneesAdmin.getMailAdmin());
		email.setSubject("Signalement depuis QCM_Light");
		String body="cause du signalement : "+cause+". id du QCM concerné : "+idQcm+
				". Id de la Question (0 si non lié) :"+idQuestion+
				"\n lien vers le qcm : http://homer.iguane.org:4200/play/"+idQcm;
		email.setMsg(body);
		email.send();
		
		//j'en reste la pour ce moment, c'est pas très joli, mais ça fonctionne ;-)
		
		return "ok";
		
	}

	public String mailResultat(int idMCQpassed, String mail) throws EmailException{
		// TODO Auto-generated method stub
		System.out.println("dans mail service.mailResultat, idMCQpassed : "+ idMCQpassed);
		System.out.println("dans mail service.mailResultat, mail : "+ mail);
		
		AdminTechniqueAppli donneesAdmin = repository.findById(1).orElse(null);
		
		if (donneesAdmin == null) {
			return null;
		}
		//les infos ont été trouvée, on va donc envoyer le mail aux admins
		Email email = new SimpleEmail(); //création de l'objet utilisé pour envoyer le mail
		// pour le moment je vais me contenter d'envoyer un mail à l'administrateur
		email.setHostName(donneesAdmin.getServeurSmtp());
		//email.setSmtpPort(465);
		email.setSmtpPort(donneesAdmin.getServeurSmtpPort());
		//email.setAuthenticator(new DefaultAuthenticator("quizizskillz@gmail.com", "@dawan20"));
		email.setAuthenticator(new DefaultAuthenticator(donneesAdmin.getServeurMailCompte(), donneesAdmin.getServeurMailComptePassword()));
		//email.setSSLOnConnect(true);
		email.setSSLOnConnect(donneesAdmin.isModeSSL());
		//email.setFrom("quizizskillz@gmail.com");
		email.setFrom(donneesAdmin.getMailAdmin());
		
		
		
		//je recupère les infos sur MCQpassed
		MCQpassed mcqPassed=mcqPassedService.find(idMCQpassed);
		mcqPassed.setMailDeclaratifWebApp(mail);
		mcqPassed=mcqPassedService.update(mcqPassed);
		String sujet="Votre Resultat au QCM "+mcqPassed.getMcq().getBody();
		String corp="Bonjour \n\n"
				+ "Vous avez demandé à recevoir votre atestation de passage du qcm : "
				+ mcqPassed.getMcq().getBody()+"\n"
				+ "Pseudo du concepteur de ce QCM dans l'application de gestion QuizIzSkills : "
				+mcqPassed.getMcq().getDesigner().getUser().getPseudo()+" .\n"
				+"sur l'adresse mail : "+mail+" .\n"
				+ "date de passage du QCM : "+mcqPassed.getDate()+" .\n"
				+ "nombre de questions total dans ce QCM : "+mcqPassed.getNbQuestionTotal()+" .\n"
				+ "lors de ce passage, vous avez répondu à : "+mcqPassed.getNbQuestionRep()+" questions.\n"
				+ "et parmis ces questions, vous avez correctement répondu à : "+mcqPassed.getResult()+" questions.\n"
				+ "ce qui vous vaut un score de "+(mcqPassed.getResult()*100/mcqPassed.getNbQuestionTotal())+" % de bonnes réponses.\n"
				+ "\n"
				+ "rejouer ce QCM via le lien : "+donneesAdmin.getUrlBaseWebApp()+"/play/"+mcqPassed.getMcq().getId()+" .\n"
				+ "\n"
				+ "jouer à d'autres QCM : "+donneesAdmin.getUrlBaseWebApp()+"/qcmList .\n"
				+ "\n"
				+ "info technique de certification de ce passage, disponible auprès des admin de QuizIzSkillz .\n"
				+"QCMpassed ID : "+mcqPassed.getId()+" .\n"
				+"code unique d'authentification : "+mcqPassed.getSignatureAutentification()+" .\n"
				+ "\n"
				+ "Bonne continuation. \n"
				+ "L'équipe QuizIzSkillz";
		//url de base vers webapp pour jouer à mettre dans bdd http://homer.iguane.org:4200		
		email.addTo(mail);
		email.setSubject(sujet);
		email.setMsg(corp);
		email.send();

		return "ok";
	}

	public String mailToDesigner(int idMCQpassed, String mail, String sujet, String corp) throws EmailException{
		// TODO Auto-generated method stub
		System.out.println("dans mail service.mailToDesigner, idMCQpassed : "+ idMCQpassed);
		System.out.println("dans mail service.mailToDesigner, mail : "+ mail);
		System.out.println("dans mail service.mailToDesigner, sujet : "+ sujet);
		System.out.println("dans mail service.mailToDesigner, corp : "+ corp);
		
		AdminTechniqueAppli donneesAdmin = repository.findById(1).orElse(null);
		
		if (donneesAdmin == null) {
			return null;
		}
		//les infos ont été trouvée, on va donc envoyer le mail aux admins
		Email email = new SimpleEmail(); //création de l'objet utilisé pour envoyer le mail
		// pour le moment je vais me contenter d'envoyer un mail à l'administrateur
		email.setHostName(donneesAdmin.getServeurSmtp());
		//email.setSmtpPort(465);
		email.setSmtpPort(donneesAdmin.getServeurSmtpPort());
		//email.setAuthenticator(new DefaultAuthenticator("quizizskillz@gmail.com", "@dawan20"));
		email.setAuthenticator(new DefaultAuthenticator(donneesAdmin.getServeurMailCompte(), donneesAdmin.getServeurMailComptePassword()));
		//email.setSSLOnConnect(true);
		email.setSSLOnConnect(donneesAdmin.isModeSSL());
		//email.setFrom("quizizskillz@gmail.com");
		email.setFrom(donneesAdmin.getMailAdmin());
		
		//je retrouve l'adresse mail du designer
		MCQpassed mcqPassed=mcqPassedService.find(idMCQpassed);
		String mailDesigner=mcqPassed.getMcq().getDesigner().getUser().getEmail();
		String subject="QuizIzSkillz. Réaction sur un de vos QCM : "+sujet;
		String body="Qcm concerné : "+mcqPassed.getMcq().getBody()+"\n\n"
					+"=============message de l'utilisateur =====================================================\n\n"
					+corp+"\n\n"
					+"=== adresse mail fournis par l'utilisateur pour le recontacter si vous le souhaitez =======\n\n"
					+"          mailto : "+mail+" \n\n"
					+"=== infos sur le passage de votre QCM par cette utilisateur ===============================\n\n"
					+ "date de passage du QCM : "+mcqPassed.getDate()+" .\n"
					+ "Pseudo du concepteur de ce QCM dans l'application de gestion QuizIzSkills : "
					+mcqPassed.getMcq().getDesigner().getUser().getPseudo()+" .\n"
					+ "nombre de questions total dans ce QCM : "+mcqPassed.getNbQuestionTotal()+" .\n"
					+ "lors de ce passage, vous avez répondu à : "+mcqPassed.getNbQuestionRep()+" questions.\n"
					+ "et parmis ces questions, vous avez correctement répondu à : "+mcqPassed.getResult()+" questions.\n"
					+ "ce qui vous vaut un score de "+(mcqPassed.getResult()*100/mcqPassed.getNbQuestionTotal())+" % de bonnes réponses.\n"
					+ "\n"
					+ "rejouer ce QCM via le lien : "+donneesAdmin.getUrlBaseWebApp()+"/play/"+mcqPassed.getMcq().getId()+" .\n"
					+ "\n"
					+ "jouer à d'autres QCM : "+donneesAdmin.getUrlBaseWebApp()+"/qcmList .\n"
					+ "\n"
					+ "info technique de certification de ce passage, disponible auprès des admin de QuizIzSkillz .\n"
					+"QCMpassed ID : "+mcqPassed.getId()+" .\n"
					+"code unique d'authentification : "+mcqPassed.getSignatureAutentification()+" .\n";
		

		email.addTo(mailDesigner);
		email.addBcc(donneesAdmin.getMailAdmin());
		email.setSubject(subject);
		email.setMsg(body);
		email.send();

		return "ok";
	}
	
	
	
}
