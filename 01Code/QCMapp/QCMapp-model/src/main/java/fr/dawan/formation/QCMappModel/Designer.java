package fr.dawan.formation.QCMappModel;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Designer extends Entitie{
	
	
	private String presentation;
	private LocalDateTime dateStatus;
	private String expertiseField;
	private boolean certifier;
	

	@OneToMany(mappedBy = "designer")
	private Set<Question> questions;
	
	
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
	
	


}
