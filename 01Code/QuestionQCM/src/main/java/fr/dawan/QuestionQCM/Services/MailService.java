package fr.dawan.QuestionQCM.Services;



import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.QuestionQCM.Beans.AdminTechniqueAppli;
import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.Repositories.AdminTechniqueRepository;


@Service
public class MailService {

	@Autowired
	private AdminTechniqueRepository repository;
	
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
}
