package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

public class StatsQuestionUsedDto extends Entitie{

	private int id;   //id identique à celui de Question used

	private int nbAnswered;
	private int nbCorrect;
	private LocalTime AnswerAverageTime;
  
	private int idMcq;
	private int idDesignerMcq;
	private String mailDesignerMcq;
	private String bodyMCQ;
	private String topicMCQ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getIdMcq() {
		return idMcq;
	}
	public void setIdMcq(int idMcq) {
		this.idMcq = idMcq;
	}
	public int getIdDesignerMcq() {
		return idDesignerMcq;
	}
	public void setIdDesignerMcq(int idDesignerMcq) {
		this.idDesignerMcq = idDesignerMcq;
	}
	public String getMailDesignerMcq() {
		return mailDesignerMcq;
	}
	public void setMailDesignerMcq(String mailDesignerMcq) {
		this.mailDesignerMcq = mailDesignerMcq;
	}
	public String getBodyMCQ() {
		return bodyMCQ;
	}
	public void setBodyMCQ(String bodyMCQ) {
		this.bodyMCQ = bodyMCQ;
	}
	public String getTopicMCQ() {
		return topicMCQ;
	}
	public void setTopicMCQ(String topic) {
		this.topicMCQ = topic;
	}
	public StatsQuestionUsedDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StatsQuestionUsedDto [id=" + id + ", nbAnswered=" + nbAnswered + ", nbCorrect=" + nbCorrect
				+ ", AnswerAverageTime=" + AnswerAverageTime + ", idMcq=" + idMcq + ", idDesignerMcq=" + idDesignerMcq
				+ ", mailDesignerMcq=" + mailDesignerMcq + ", bodyMCQ=" + bodyMCQ + ", topicMCQ=" + topicMCQ + "]";
	}
	
	



	
	
	
}
