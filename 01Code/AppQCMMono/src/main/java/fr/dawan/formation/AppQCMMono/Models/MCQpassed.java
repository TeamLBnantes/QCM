package fr.dawan.formation.AppQCMMono.Models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MCQpassed extends Entitie{

	@ManyToOne
	private User user;
	@ManyToOne
	private MCQ mcq;
	private int result;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
}
