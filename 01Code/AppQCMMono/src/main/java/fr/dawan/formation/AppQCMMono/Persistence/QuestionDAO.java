package fr.dawan.formation.AppQCMMono.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.ObjectFiltresQuestion;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.QuestionUsed;
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

	public List<Question> findWithFiltre(ObjectFiltresQuestion filtresQuestion, Designer designer) {
		List<Question> questions=new ArrayList<Question>();
		int filtre=0;
		String requete="";

		if(filtresQuestion.isYoursFiltre()) filtre+=100;      //on filtre par ce designer
		if(filtresQuestion.getBodyFiltre().length()>0) 	filtre+=10;	  // on filtre par body contient
		if(filtresQuestion.getThemeFiltre().length()>0)	filtre+=1;  //on filtre par theme contient
		
		switch (filtre) {
		case 0: // aucun filtre, on renvois tout
			requete = "select f from "  
					+ Question.class.getName()+" f";
			questions = super.entityManager
					.createQuery(requete, Question.class)
//					.setParameter("designer", designer)
//					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
//					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;
		case 1: // on ne filtre que sur le theme
			requete = "select f from "  
					+ Question.class.getName() 
					+ " f where f.topic LIKE :theme";
			questions = super.entityManager
					.createQuery(requete, Question.class)
//					.setParameter("designer", designer)
//					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;
		case 10: // on ne filtre que sur le body
			requete = "select f from "  
					+ Question.class.getName() 
					+ " f where f.body LIKE :body";
			questions = super.entityManager
					.createQuery(requete, Question.class)
//					.setParameter("designer", designer)
					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
//					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;	
		case 11: // on ne filtre que sur le body et theme
			requete = "select f from "  
					+ Question.class.getName() 
					+ " f where f.body LIKE :body and f.topic LIKE :theme";
			questions = super.entityManager
					.createQuery(requete, Question.class)
//					.setParameter("designer", designer)
					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;	
		case 100: // on ne filtre que sur le designer
			requete = "select f from "  
					+ Question.class.getName() 
					+ " f where f.designer = :designer";
			questions = super.entityManager
					.createQuery(requete, Question.class)
					.setParameter("designer", designer)
//					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
//					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;	
		case 101: // on ne filtre  sur le designer et le theme
			requete = "select f from "  
					+ Question.class.getName() 
					+ " f where f.designer = :designer and f.topic LIKE :theme";
			questions = super.entityManager
					.createQuery(requete, Question.class)
					.setParameter("designer", designer)
//					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;	
		case 110: // on ne filtre que sur le designer et body
			requete = "select f from "  
					+ Question.class.getName() 
					+ " f where f.designer = :designer and f.body LIKE :body";
			questions = super.entityManager
					.createQuery(requete, Question.class)
					.setParameter("designer", designer)
					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
//					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;	
		case 111: // on ne filtre que sur le designer, body et theme
			requete = "select f from "  
					+ Question.class.getName() 
					+ " f where f.designer = :designer and f.body LIKE :body and f.topic LIKE :theme";
			questions = super.entityManager
					.createQuery(requete, Question.class)
					.setParameter("designer", designer)
					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;			
		default:
			break;
		}
		

		
		return questions;
		
		

	}

	public List<QuestionUsed> findQuestionUsedbyQuestion(Question question) {

		List<QuestionUsed> questionsUsed = new ArrayList<>();
		String requete = "select q from "  
				+ QuestionUsed.class.getName() 
				+ " q where q.question = :question";
		
		// JPQL (ou HQL)
		questionsUsed=super.entityManager
				.createQuery(requete, QuestionUsed.class)
				.setParameter("question", question)
				.getResultList();
		

		
		return questionsUsed;
	}
			


	
	
}
