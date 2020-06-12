package fr.dawan.QuestionQCM.Controllers;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.DTO.MCQPlayableDto;
import fr.dawan.QuestionQCM.DTO.MCQforListDto;
import fr.dawan.QuestionQCM.Services.MailService;
import fr.dawan.QuestionQCM.Services.QCMService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200", "http://localhost:8080","http://ratiatum.iguane.org:4200","http://homer.iguane.org:4200"})
//@CrossOrigin (origins= {"http://localhost:4200", "http://localhost:8080","http://ratiatum.iguane.org:4200","*"})
@RequestMapping("/qcm")
public class QCMController {

	@Autowired
	private QCMService service;
	@Autowired
	private MailService mailService;
	/*
	 * called by Angular to list all qcm
	 */
	@GetMapping(value = { "/", "", "/all" })
	public List<MCQforListDto> findAll() {
		return service.findAllDto();
	}

	/*
	 * called by Angular to play with this mcq
	 */
	@GetMapping("/{id}")
	public MCQPlayableDto find(@PathVariable("id") int id) {
		return service.find(id);
	}

	

	/*
	 * called by Angular to post a result to a qcm for a user
	 * data={"idQcm": idMCQpassed, "mail": mail}
	 * 
	 */
	@PostMapping(value = { "/mailResult"})
	public void mailresult(@RequestBody  String values) throws JSONException	{
		System.out.println("demande transfert result receptionné"); 
		System.out.println(values);
		//System.out.println("id Qcm : "+idQcm);
		//String jsonString = values;
		JSONObject object = new JSONObject(values);
		 
		int idMCQpassed = object.getInt("idMCQpassed");
		System.out.println("idMCQpassed : "+idMCQpassed);
		String mail = object.getString("mail");
		System.out.println("mail : "+mail);
		
		 try {
			 mailService.mailResultat(idMCQpassed, mail);
			 System.out.println("mail resultat bien envoyé");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("pb lors de l'envoie du mail du resultat");
		} 
		
		
	}
	
	/*
	 * called by Angular to post a mail from a user to a designer
	 * data={"idMCQpassed": idMCQpassed, "mail": mail, "sujet": sujet, "corp":corp}
	 * 
	 */
	@PostMapping(value = { "/mailToDesigner"})
	public void mailToDesigner(@RequestBody  String values) throws JSONException	{
		System.out.println("demande envoie mail receptionné"); 
		System.out.println(values);
		//System.out.println("id Qcm : "+idQcm);
		//String jsonString = values;
		JSONObject object = new JSONObject(values);
		 
		int idMCQpassed = object.getInt("idMCQpassed");
		System.out.println("idMCQpassed : "+idMCQpassed);
		String mail = object.getString("mail");
		System.out.println("mail : "+mail);
		String sujet = object.getString("sujet");
		System.out.println("sujet : "+sujet);
		String corp = object.getString("corp");
		System.out.println("corp : "+corp);
		
		 try {
			 mailService.mailToDesigner(idMCQpassed, mail, sujet, corp);
			 System.out.println("mail to designer bien envoyé");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("pb lors de l'envoie du mail vers le designer");
		} 
		
		
	}
	
}
