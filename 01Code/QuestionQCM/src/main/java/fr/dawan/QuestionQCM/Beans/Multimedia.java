package fr.dawan.QuestionQCM.Beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.dawan.QuestionQCM.Enum.TypeMultimedia;



@Entity
public class Multimedia extends Entitie{
	
	@Enumerated(EnumType.STRING)
	TypeMultimedia typeMultimedia;
	String adresseCible;
	
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY)   
//	@JoinColumn(name="mcq_id", unique=true)
	@JoinColumn(name="mcq_id")
	MCQ mcq;
	
	@JsonIgnore
	@OneToOne   (fetch=FetchType.LAZY)   
	@JoinColumn(name="question_id")
	Question question;
	
	@JsonIgnore
	@OneToOne   (fetch=FetchType.LAZY)   
	@JoinColumn(name="answer_id")
	Answer answer;
	
	
	
	
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
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public TypeMultimedia getTypeMultimedia() {
		return typeMultimedia;
	}
	public void setTypeMultimedia(TypeMultimedia typeMultimedia) {
		this.typeMultimedia = typeMultimedia;
	}
	public String getAdresseCible() {
		return adresseCible;
	}
	public void setAdresseCible(String adresseCible) {
		this.adresseCible = adresseCible;
	}
	
	
}
