package fr.dawan.formation.AppQCMMono.Persistence;

import java.util.ArrayList;
import java.util.List;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Persistence.Interfaces.DAOQuestionInterface;

public class QuestionDAO extends GenericDAO<Question> implements DAOQuestionInterface{

	public QuestionDAO(String persistenceUnitName) {
		super(persistenceUnitName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Question> searchByKWBody(String kw) {
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

	@Override
	public List<Question> searchByTheme(String theme) {
		// TODO Auto-generated method stub
		List<Question> questions=new ArrayList<Question>();
		String requete = "select f from "  
				+ Question.class.getName() 
				+ " f where f.theme like :theme";
		
		// JPQL (ou HQL)
		questions = super.entityManager
				.createQuery(requete, Question.class)
				.setParameter("theme", "%"+theme+"%")
				.getResultList();
		System.out.println("question trouvees : "+questions);
		return questions;
	}

	@Override
	public List<Question> searchByStatus(Status status) {
		String requete = "select f from "  
				+ Question.class.getName() 
				+ " f where f.status = :status";
				//+ " f where f.value = theme";
		
		// JPQL (ou HQL)
		return super.entityManager
				.createQuery(requete, Question.class)
				.setParameter("status", status)
				.getResultList();
		
		
				
	}

	@Override
	public List<Question> searchByDesigner(Designer designer) {
		
		List<Question> questions = new ArrayList<>();
		String requete = "select f from "  
				+ Question.class.getName() 
				+ " f where f.designer = :designer";
		
		// JPQL (ou HQL)
		questions=super.entityManager
				.createQuery(requete, Question.class)
				.setParameter("designer", designer)
				.getResultList();
		
		System.out.println(questions);
		
		return questions;

	}

	public List<Question> searchByMcq(MCQ mcq) {
		List<Question> questions=new ArrayList<Question>();
		String requete = "select f from "  
				+ Question.class.getName() 
				+ " f join fetch f.questionUseds t"
				+ " where t.mcq = :mcq";
				//+ " f where f.value = theme";
		
		// JPQL (ou HQL)
		questions = super.entityManager
				.createQuery(requete, Question.class)
				.setParameter("mcq", mcq)
				.getResultList();
		System.out.println("question trouvees : "+questions);
		return questions;
	}


	
	
	
}
