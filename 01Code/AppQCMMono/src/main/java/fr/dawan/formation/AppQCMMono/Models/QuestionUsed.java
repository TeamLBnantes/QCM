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
	
	
	
}
