package fr.dawan.formation.AppQCMMono.Models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MCQpassed extends Entitie{

	@ManyToOne
	private User user;
	@ManyToOne
	private MCQ mcq;
	private int result;    //entier entre 0 et 100, representant le score en % de bonnes reponses.
	
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
	public MCQpassed(User user, MCQ mcq) {
		super();
		this.user = user;
		this.mcq = mcq;
		this.result=0;
	}
	
	
}
