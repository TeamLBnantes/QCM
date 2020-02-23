package fr.dawan.formation.AppQCMMono.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.User;

@Controller
@RequestMapping("/ManagementQuestionsDesigner")
public class ManagementQuestionsDesigner {

	@GetMapping(value = { "" })
	public String hello(HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		
		model.addAttribute("enumStatus", Status.values());
		// on renvoie le nom de la jsp
		return "ManagementQuestionsDesigner";
	}
}
