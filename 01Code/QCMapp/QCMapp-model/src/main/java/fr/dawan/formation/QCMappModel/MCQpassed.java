package fr.dawan.formation.QCMappModel;

import javax.persistence.Entity;

@Entity
public class MCQpassed extends Entitie{

	private User user;
	private MCQ mcq;
	private int result;
}
