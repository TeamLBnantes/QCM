package fr.dawan.formation.AppQCMMono.controllers;

import java.util.Locale;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.SessionServiceDTO;
import fr.dawan.formation.AppQCMMono.Services.UserService;
import sun.print.resources.serviceui;
import sun.print.resources.serviceui_sv;

@Controller
@RequestMapping("/modificationUserInformations")
public class UserController {

	@Autowired
	private UserService userService;
	
	//Afficher informations de l'utilisateur
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		SessionServiceDTO ssdto = new SessionServiceDTO();
		User user = ssdto.sessionUserService(session);
		ssdto.isDesignerService(user, model);
		session.setAttribute("messageProblemeChangeEmail", "");
		return "modificationUserInformations";
	}
	
	//Maj des données de l'utilisateur après modification en base de données
	// user = information en provenance du formulaire - session = valeur de la session active
	@PostMapping("/update")
	public String updateUserInformations(User userEcran,boolean changeMailDemande,boolean changePasswordDemande, HttpSession session, Model model) {
		System.out.println("changement de mail demandé : "+changeMailDemande);
		System.out.println("changement de password demandé : "+changePasswordDemande);
		SessionServiceDTO ssdto = new SessionServiceDTO();
		User user = ssdto.sessionUserService(session);
		ssdto.isDesignerService(user, model);   //envoie dans le model l'info isNotDesigner pour user en cours. qui vaut true ou false.
						//il en me semble pas que ce soit utile pour le moment, nous n'en faisons rien !!!
		// a moins que /home ne le recup dans le model ??? (mais je ne crois pas, vu qu'elle relance la procedure !!
		User userSession = (User) session.getAttribute("user");
		//si changement de mail non demandé, alors on affect pour etre plus sur, sinon, on laisse donc le nouveau
		// dans le service de maj, si le mail est identique, pas besoin de se compliquer la vie
		if (!changeMailDemande) {
			userEcran.setEmail(null);
			//si pas de demande de changement de mot de passe, alors je le vide pour etre plus sur
		}else if (userEcran.getEmail().equals(userSession.getEmail())) {
			//demande de changement, mais en fait c'est le même :-(, on ne change donc rien
			userEcran.setEmail(null);
		}
		    
		if (!changePasswordDemande) {
			userEcran.setPassword(null);
		}
		
		//et donc dans le service, les champs à null (mail et password ne seront pas modifiés
		// au retour, nous pourons tester si le mail à bien été changé si demandé, et reagir si ce n'est pas le cas
		// en informant l'utilisateur et en retournant sur la page de maj
		

		
		User userMaj = userService.UpdateUserInformations(userSession, userEcran);
		
		//deux cas de figure, changement d'email demandé mais non possible ou cas sans problème
		if ((userEcran.getEmail()!=null) && (!(userEcran.getEmail().equals(userMaj.getEmail())))  ) {
			//chagt mail demandé, mais non effectué, il etait donc déja pris
			session.setAttribute("user", userMaj);
			
			session.setAttribute("messageProblemeChangeEmail", userEcran.getEmail());
			
			return "modificationUserInformations";
			
			
		}else {
			session.setAttribute("user", userMaj);
			return "redirect:/home";
		}
		
		
		

	}
	
	
}
