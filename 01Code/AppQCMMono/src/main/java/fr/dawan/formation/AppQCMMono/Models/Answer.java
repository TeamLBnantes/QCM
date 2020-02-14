package fr.dawan.formation.AppQCMMono.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Answer extends Entitie{
	
	private String body;
	private boolean expectedAnswer;
	private String commentPostAnswer;
	
	@ManyToOne (fetch = FetchType.EAGER)
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
	@Override
	public String toString() {
		return "Answer [body=" + body + ", expectedAnswer=" + expectedAnswer + ", commentPostAnswer="
				+ commentPostAnswer + ", question=" + "  ( pas de ref à la question, rien pour eviter ref circulaire), getId()=" + getId() + "]";
	}
	
	
	
	
	
}