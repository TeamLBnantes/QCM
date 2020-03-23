package fr.dawan.QuestionQCM.DTO;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.dawan.QuestionQCM.Beans.Multimedia;
import fr.dawan.QuestionQCM.Beans.Question;

public class AnswerPlayableDto {
	
	private int id;
	private String body;
	private Multimedia multimedia;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Multimedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}
	public AnswerPlayableDto(int id, String body, Multimedia multimedia) {
		super();
		this.id = id;
		this.body = body;
		this.multimedia = multimedia;
	}
	public AnswerPlayableDto() {
		super();
	}

	
	
}
