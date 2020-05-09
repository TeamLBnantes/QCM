package fr.dawan.formation.AppQCMMono.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answer extends Entitie{
	
	@Column(columnDefinition="text", length=2000)
	private String body;
	private boolean expectedAnswer;
	@Column(columnDefinition="text", length=2000)
	private String commentPostAnswer;
	
	@ManyToOne (fetch = FetchType.EAGER)
	private Question question;
	
	@OneToOne (mappedBy = "answer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL}, fetch = FetchType.EAGER)
	private Multimedia multimedia;
	
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
	
	
	
	public Multimedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}
	@Override
	public String toString() {
		return "Answer [body=" + body + ", expectedAnswer=" + expectedAnswer + ", commentPostAnswer="
				+ commentPostAnswer + ", question=" + "  ( pas de ref à la question, rien pour eviter ref circulaire), getId()=" + getId() + "]";
	}
	
	
	
	
	
}