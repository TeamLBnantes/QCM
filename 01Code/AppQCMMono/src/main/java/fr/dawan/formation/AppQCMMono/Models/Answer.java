package fr.dawan.formation.AppQCMMono.Models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Answer extends Entitie{
	
	private String body;
	private boolean expectedAnswer;
	private String commentPostAnswer;
	
	@ManyToOne
	private Question question;
	
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isExpectedAnswer() {
		return expectedAnswer;
	}
	public void setExpectedAnswer(boolean expectedAnswer) {
		this.expectedAnswer = expectedAnswer;
	}
	public String getCommentPostAnswer() {
		return commentPostAnswer;
	}
	public void setCommentPostAnswer(String commentPostAnswer) {
		this.commentPostAnswer = commentPostAnswer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
	
	
}