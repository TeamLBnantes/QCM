package fr.dawan.formation.QCMappModel;

import java.time.LocalTime;

public class QuestionUsed extends Entity{

	private int nbAnswered;
	private int nbCorrect;
	private LocalTime AnswerAverageTime;
	private MCQ mcq;
	private Question question;
}
