package fr.dawan.QuestionQCM.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.QuestionQCM.Beans.Question;
import fr.dawan.QuestionQCM.DTO.QuestionCorrectionDto;
import fr.dawan.QuestionQCM.DTO.QuestionPlayableDto;
import fr.dawan.QuestionQCM.Services.QuestionService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200", "http://localhost:8080","http://homer.iguane.org:4200", "http://ratiatum.iguane.org:4200"})
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;

	

	// version initiale
	@GetMapping("/{id}")
	public QuestionPlayableDto find(@PathVariable("id") int id) {
		return service.find(id);
	}


	@GetMapping("/{id}/correction")
	public QuestionCorrectionDto correction(@PathVariable("id") int id) {
		return service.correction(id);
	}


}
