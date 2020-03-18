package fr.dawan.QuestionQCM.Beans;

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
		this.finalise=false;
	}
	public MCQpassed(User user, MCQ mcq, int result, boolean finalise) {
		super();
		this.user = user;
		this.mcq = mcq;
		this.result = result;
		this.finalise = finalise;
	}
	public MCQpassed() {
		super();
	}
	
	
}
