package fr.dawan.QuestionQCM.Controllers;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
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
@CrossOrigin (origins= {"http://localhost:4200", "http://localhost:8080","http://homer.iguane.org:4200", "http://ratiatum.iguane.org:4200"})
@RequestMapping("/signaler")
public class SignalerController {


	@Autowired
	private MailService mailService;
	/*
	 * called by Angular to post a signalement
	 * data={"idQuestion": idQuestion, "idQcm": idQcm, "cause": cause}
	 * 
	 */
	@PostMapping(value = { "/", ""})
	//public void signaler(@RequestBody  MultiValueMap<String, String> values) {
	public void signaler(@RequestBody  String values) throws JSONException	{
		System.out.println("signalement receptionné"); 
		System.out.println(values);
		//System.out.println("id Qcm : "+idQcm);
		//String jsonString = values;
		JSONObject object = new JSONObject(values);
		 
		int idQcm = object.getInt("idQcm");
		System.out.println("idQcm : "+idQcm);
		int idQuestion=0;
		try {
			idQuestion = object.getInt("idQuestion");
			System.out.println("idQuestion : "+idQuestion);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("pas de ref à une question");
		}
		String cause = object.getString("cause");
		System.out.println("cause : "+cause);
		
		 try {
			 mailService.signaler(idQcm, idQuestion, cause);
			 System.out.println("mail bien envoyé");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("pb lors de l'envoie du mail");
		} 
		
		
	}




}
