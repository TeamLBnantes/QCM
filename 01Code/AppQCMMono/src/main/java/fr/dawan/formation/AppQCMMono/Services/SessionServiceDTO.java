package fr.dawan.formation.AppQCMMono.Services;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import fr.dawan.formation.AppQCMMono.Models.User;

public class SessionServiceDTO {
	User user;
	Model model;
	
	
	public void isDesignerService (User user, Model model) {
		

	boolean isNotDesigner=true;
	if (user.getDesigner()!=null) {
		isNotDesigner=false;
	}
	model.addAttribute("isNotDesigner", isNotDesigner);
	}
	
	
	public User sessionUserService(HttpSession session) {
		User user= (User)session.getAttribute("user");
		return user;

	}
	 
}
