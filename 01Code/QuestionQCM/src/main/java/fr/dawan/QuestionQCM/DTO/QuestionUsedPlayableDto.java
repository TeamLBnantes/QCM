package fr.dawan.QuestionQCM.DTO;

import java.time.LocalTime;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.Beans.Question;


/**
 * Actually not used...
 * @author vbill
 *
 */

public class QuestionUsedPlayableDto {
	private int id;
	private int nbAnswered;
	private int nbCorrect;
	private LocalTime AnswerAverageTime;
	private int questionId;
	
	
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
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public QuestionUsedPlayableDto() {
		super();
	}
	public QuestionUsedPlayableDto(int id, int nbAnswered, int nbCorrect, LocalTime answerAverageTime, int questionId) {
		super();
		this.questionId=id;
		this.nbAnswered = nbAnswered;
		this.nbCorrect = nbCorrect;
		AnswerAverageTime = answerAverageTime;
		this.questionId = questionId;
	}
	
	
	
	
}
