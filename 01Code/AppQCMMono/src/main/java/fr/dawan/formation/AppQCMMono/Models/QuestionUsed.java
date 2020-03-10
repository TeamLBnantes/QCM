package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
public class QuestionUsed extends Entitie{

	private int nbAnswered;
	private int nbCorrect;
	private LocalTime AnswerAverageTime;
	@ManyToOne  
	private MCQ mcq;
	@ManyToOne    //line de type eager
	private Question question;
	public int getNbAnswered() {
		return nbAnswered;
	}
	public void setNbAnswered(int nbAnswered) {
		this.nbAnswered = nbAnswered;
	}
	public int getNbCorrect() {
		return nbCorrect;
	}
	public void setNbCorrect(int nbCorrect) {
		this.nbCorrect = nbCorrect;
	}
	public LocalTime getAnswerAverageTime() {
		return AnswerAverageTime;
	}
	public void setAnswerAverageTime(LocalTime answerAverageTime) {
		AnswerAverageTime = answerAverageTime;
	}
	public MCQ getMcq() {
		return mcq;
	}
	public void setMcq(MCQ mcq) {
		this.mcq = mcq;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
	
}
