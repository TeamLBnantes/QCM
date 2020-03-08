package fr.dawan.formation.AppQCMMono.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@GetMapping(value= {"", "/"})
	public String hello(HttpSession session, Model model) {
	
	return "test/test";
	}
	
	@GetMapping(value= {"/{id}"})
	public String hello2(@PathVariable("id") int id, HttpSession session, Model model) {
		model.addAttribute("idTest", id);
	return "test/test"+id;
	}
	
	
}
