package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MCQpassed extends Entitie{

	@ManyToOne
	private User user;
	@ManyToOne
	private MCQ mcq;
	private int result;    //entier entre 0 et 100, representant le score en % de bonnes reponses.
	private boolean finalise;
	private LocalDateTime date;
	private int nbQuestionRep;
	private int nbQuestionTotal;
	
	
	public int getNbQuestionRep() {
		return nbQuestionRep;
	}
	public void setNbQuestionRep(int nbQuestionRep) {
		this.nbQuestionRep = nbQuestionRep;
	}
	public int getNbQuestionTotal() {
		return nbQuestionTotal;
	}
	public void setNbQuestionTotal(int nbQuestionTotal) {
		this.nbQuestionTotal = nbQuestionTotal;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MCQ getMcq() {
		return mcq;
	}
	public void setMcq(MCQ mcq) {
		this.mcq = mcq;
	}
	
	public boolean isFinalise() {
		return finalise;
	}
	public void setFinalise(boolean finalise) {
		this.finalise = finalise;
	}
	public MCQpassed(User user, MCQ mcq) {
		super();
		this.user = user;
		this.mcq = mcq;
		this.result=0;
		this.nbQuestionRep=0;
		this.finalise=false;
		this.date=LocalDateTime.now();
	}
	
	public MCQpassed() {
	}
	
}
