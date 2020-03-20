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

import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.DTO.MCQdto;
import fr.dawan.QuestionQCM.Services.QCMService;

@RestController
@CrossOrigin (origins="http://localhost:4200")
@RequestMapping("/qcm")
public class QCMController {

	@Autowired
	private QCMService service;

	@GetMapping("/default")
	public MCQ getDefault() {
		MCQ mcq = new MCQ(); 
		
		mcq.setBody("Tour de Bretagne");
		

		return mcq;
	}

	// version initiale
	@GetMapping("/{id}")
	public MCQ find(@PathVariable("id") int id) {
		return service.find(id);
	}

	// pour avoir du JSON ou du XML (conso/prod)
	// !!! MediaType = import Spring !!!
	@GetMapping(value = "/alltypes/{id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.TEXT_XML_VALUE })
	public MCQ findTousTypes(@PathVariable("id") int id) {
		return service.find(id);
	}

	@GetMapping(value = { "/", "", "/all" })
	public List<MCQdto> findAll() {
		return service.findAllDto();
	}


	@PostMapping("")
	public MCQ create(@RequestBody MCQ mcq) {
		return service.create(mcq);
	}

	@PutMapping("")
	public MCQ update(@RequestBody MCQ mcq) {
		return service.update(mcq);
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") int id) {
		return service.delete(id);
	}



}
