package fr.dawan.formation.AppQCMMono.Persistence;

import java.util.ArrayList;
import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.Question;

public class QuestionDAO extends GenericDAO<Question> {

	public QuestionDAO(String persistenceUnitName) {
		super(persistenceUnitName);
		// TODO Auto-generated constructor stub
	}

	public List<Question> FindByKwBody(String kw) {
		// TODO Auto-generated method stub
		List<Question> questions = new ArrayList<>();
		String requete = "select f from "  
				+ Question.class.getName() 
				+ " f where f.body LIKE :body";
		
		// JPQL (ou HQL)
		questions=super.entityManager
				.createQuery(requete, Question.class)
				.setParameter("body", "%"+kw+"%")
				.getResultList();
		
		System.out.println(questions);
		
		return questions;
		
	}

	
	
	
}
