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
import fr.dawan.QuestionQCM.Services.QuestionService;

@RestController
@CrossOrigin (origins="http://localhost:4200")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;

	@GetMapping("/default")
	public Question getDefault() {
		Question q = new Question();
		q.setId(1);
		q.setBody("Tour de Bretagne");
		q.setCommentPostAnswer("La plus grand tour de Nantes");

		return q;
	}

	// version initiale
	@GetMapping("/{id}")
	public Question find(@PathVariable("id") int id) {
		return service.find(id);
	}

	// pour avoir du JSON ou du XML (conso/prod)
	// !!! MediaType = import Spring !!!
	@GetMapping(value = "/alltypes/{id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.TEXT_XML_VALUE })
	public Question findTousTypes(@PathVariable("id") int id) {
		return service.find(id);
	}

	@GetMapping(value = { "/", "", "/all" })
	public List<Question> findAll() {
		return service.findAll();
	}


	@PostMapping("")
	public Question create(@RequestBody Question q) {
		return service.create(q);
	}

	@PutMapping("")
	public Question update(@RequestBody Question q) {
		return service.update(q);
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") int id) {
		return service.delete(id);
	}



}
