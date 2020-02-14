package fr.dawan.formation.AppQCMMono.Persistence;

import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.Question;

public class AnswerDAO extends GenericDAO<Answer> {

	public AnswerDAO(String persistenceUnitName) {
		super(persistenceUnitName);
	}

	
	  public List<Answer> findByQuestion(Question question){
	  
	  String requete = "select f from " 
			  		+ Answer.class.getName() 
			  		+" f where f.question = :idQuestion";
	  
	  // JPQL (ou HQL) 
	  return super.entityManager .createQuery(requete,Answer.class) 
			  		.setParameter("idQuestion", question) 
			  		.getResultList(); 
	  }
	 

	
	
	
	
}
