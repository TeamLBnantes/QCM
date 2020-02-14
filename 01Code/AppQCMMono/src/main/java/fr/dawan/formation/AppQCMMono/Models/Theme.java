package fr.dawan.formation.AppQCMMono.Models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Theme extends Entitie{

	
	private String value;
	
	@OneToMany (mappedBy = "theme")
	private Set<Question> question;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}
	
	
	
}
