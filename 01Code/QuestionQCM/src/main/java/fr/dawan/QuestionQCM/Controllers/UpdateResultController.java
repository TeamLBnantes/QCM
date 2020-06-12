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
import fr.dawan.QuestionQCM.Services.MCQpassedService;
import fr.dawan.QuestionQCM.Services.MailService;
import fr.dawan.QuestionQCM.Services.QCMService;
import fr.dawan.QuestionQCM.Services.QuestionUsedService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200", "http://localhost:8080","http://ratiatum.iguane.org:4200","http://homer.iguane.org:4200" })
@RequestMapping("/updateResult")
public class UpdateResultController {


	@Autowired
	private MCQpassedService mcqPassedService;
	@Autowired
	private QuestionUsedService questionUsedService;
	/*
	 * called by Angular to post a signalement
	 * data={"idQuestion": idQuestion, "idQcm": idQcm, "cause": cause}
	 * 
	 */
	@PostMapping(value = { "/", ""})
	//public void signaler(@RequestBody  MultiValueMap<String, String> values) {
	public void update(@RequestBody  String values) throws JSONException	{
		System.out.println("resultat receptionné "); 
		System.out.println(values);
		//System.out.println("id Qcm : "+idQcm);
		//String jsonString = values;
		JSONObject object = new JSONObject(values);
		 
		int idQuestion = object.getInt("idQuestion");
		System.out.println("idQuestion : "+idQuestion);
		int idMCQpassed = object.getInt("idMCQpassed");
		System.out.println("idMCQpassed : "+idMCQpassed);
		boolean correction = object.getBoolean("correction");
		System.out.println("correction : "+correction);
		//mise à jour des données de QCMpassed  (qui renvois la ref du QCM, pour pouvoir ensuite acceder à  QUestionUsed
		int idQcm=mcqPassedService.updateResultatMCQpassed(idMCQpassed, correction);
        //à present, enregistrement des données de QuestionUsed
		questionUsedService.updateResultat(idQcm,idQuestion,correction);
	}




}
