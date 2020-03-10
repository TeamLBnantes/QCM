package fr.dawan.formation.AppQCMMono.Models;

public class SubscribeValidator {
	private boolean validation;
	private String comment;
	
	public boolean isValidation() {
		return validation;
	}
	public void setValidation(boolean validaton) {
		this.validation = validaton;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
