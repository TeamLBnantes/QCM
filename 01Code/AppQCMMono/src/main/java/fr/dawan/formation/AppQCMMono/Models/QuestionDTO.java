package fr.dawan.formation.AppQCMMono.Models;

import javax.persistence.Entity;

/*
 * classe utiliser dans les tableaux front, pour gerer la selection ou non des questions
 */



public class QuestionDTO {

	private boolean select;
	private Question question;
	
	
	
	public QuestionDTO(Question question) {
		super();
		this.select = false;
		this.question = question;
	}
	
	
	
	public QuestionDTO(boolean select, Question question) {
		super();
		this.select = select;
		this.question = question;
	}



	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
	
	
	
	
}
