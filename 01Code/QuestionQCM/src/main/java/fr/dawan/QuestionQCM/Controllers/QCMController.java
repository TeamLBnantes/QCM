package fr.dawan.QuestionQCM.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.DTO.MCQPlayableDto;
import fr.dawan.QuestionQCM.DTO.MCQforListDto;
import fr.dawan.QuestionQCM.Services.QCMService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200", "http://localhost:8080","http://ratiatum.iguane.org:4200","*"})
@RequestMapping("/qcm")
public class QCMController {

	@Autowired
	private QCMService service;

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


}
