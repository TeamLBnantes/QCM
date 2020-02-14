package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Designer extends Entitie{
	
	
	private String presentation;
	private LocalDateTime dateStatus;
	private String expertiseField;
	private boolean certifier;
	

	@OneToMany(mappedBy = "designer",cascade= {CascadeType.PERSIST, CascadeType.MERGE})
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
	@Override
	public String toString() {
		return "Designer [presentation=" + presentation + ", dateStatus=" + dateStatus + ", expertiseField="
				+ expertiseField + ", certifier=" + certifier + ", questions=" + questions + "]";
	}
	
	


}
