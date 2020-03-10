package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Designer extends Entitie{
	
	
	private String presentation;
	private LocalDateTime dateStatus;
	private String expertiseField;
	private boolean certifier;
	
	
	@OneToOne   
	@JoinColumn(name="user_id", nullable=false, unique=true)
	private User user;

	@OneToMany(mappedBy = "designer")
	private Set<Question> questions;
	
	@OneToMany(mappedBy = "designer")
	private Set<MCQ> mcq;
	
	
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public LocalDateTime getDateStatus() {
		return dateStatus;
	}
	public void setDateStatus(LocalDateTime dateStatus) {
		this.dateStatus = dateStatus;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	
	public String getExpertiseField() {
		return expertiseField;
	}
	public void setExpertiseField(String expertiseField) {
		this.expertiseField = expertiseField;
	}
	public boolean isCertifier() {
		return certifier;
	}
	public void setCertifier(boolean certifier) {
		this.certifier = certifier;
	}
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


}
