package fr.dawan.formation.QCMappModel;

import java.time.LocalTime;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class QuestionUsed extends Entity{

	private int nbAnswered;
	private int nbCorrect;
	private LocalTime AnswerAverageTime;
	@ManyToOne
	private MCQ mcq;
	@ManyToOne
	private Question question;
	
	
	
}
