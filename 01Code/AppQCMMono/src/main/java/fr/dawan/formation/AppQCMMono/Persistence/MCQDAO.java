package fr.dawan.formation.AppQCMMono.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.MCQpassed;
import fr.dawan.formation.AppQCMMono.Models.ObjectFiltresMCQ;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.QuestionUsed;
import fr.dawan.formation.AppQCMMono.Models.Theme;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Interfaces.DAOMCQInterface;

public class MCQDAO extends GenericDAO<MCQ> implements DAOMCQInterface {

	public MCQDAO(String persistenceUnitName) {
		super(persistenceUnitName);
	}
	
	
	@Override
	public List<MCQ> searchByTheme(String theme) {
		
		String requete = "select f from "  
				+ MCQ.class.getName() 
				+ " f where f.theme like :theme";

		
		// JPQL (ou HQL)
		return super.entityManager
				.createQuery(requete, MCQ.class)
				.setParameter("theme", "%"+theme+"%")
				.getResultList();
		
	}

	@Override
	public List<MCQ> searchByStatus(Status status) {
		String requete = "select f from "  
				+ MCQ.class.getName() 
				+ " f where f.status = :status";
		
		// JPQL (ou HQL)
		return super.entityManager
				.createQuery(requete, MCQ.class)
				.setParameter("status", status)
				.getResultList();
	}

	@Override
	public List<MCQ> searchByKWBody(String kw) {
		// TODO Auto-generated method stub
		String requete = "select f from "  
				+ MCQ.class.getName() 
				+ " f where f.body LIKE :body";
		
		// JPQL (ou HQL)
		return super.entityManager
				.createQuery(requete, MCQ.class)
				.setParameter("body", "%"+kw+"%")
				.getResultList();
	}

	@Override
	public List<MCQ> searchByDesigner(Designer designer) {
		// TODO Auto-generated method stub
		String requete = "select f from "  
				+ MCQ.class.getName() 
				+ " f where f.designer = :designer";
		
		// JPQL (ou HQL)
		return super.entityManager
				.createQuery(requete, MCQ.class)
				.setParameter("designer", designer)
				.getResultList();
	}
//extends GenericDAO<Question> implements DAOQuestionInterface


	public QuestionUsed findQuestionUsedbyMcqAndQuestion(MCQ mcq, Question question) {
		// TODO Auto-generated method stub
		String requete = "select q from "  
				+ QuestionUsed.class.getName() 
				+ " q where ( q.question = :question and q.mcq= :mcq )";
		
		// JPQL (ou HQL)
		return super.entityManager
				.createQuery(requete, QuestionUsed.class)
				.setParameter("question", question)
				.setParameter("mcq", mcq)
				.getSingleResult();

	}


	public List<MCQ> searchWithFiltre(ObjectFiltresMCQ filtresMCQ, User user) {
		// TODO pour le moment, je ne gère pas le filtyre sur deja passé par user
		List<MCQ> mcqs=new ArrayList<MCQ>();
		int filtre=0;
		String requete="";
		
		if(filtresMCQ.getBodyFiltre().length()>0) 	filtre+=10;	  // on filtre par body contient
		if(filtresMCQ.getThemeFiltre().length()>0)	filtre+=1;  //on filtre par theme contient
		
		switch (filtre) {
		case 0: // aucun filtre, on renvois tout
			requete = "select f from "  
					+ MCQ.class.getName()+" f";
			mcqs = super.entityManager
					.createQuery(requete, MCQ.class)
//					.setParameter("designer", designer)
//					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
//					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;
		case 1: // on ne filtre que sur le theme
			requete = "select f from "  
					+ MCQ.class.getName() 
					+ " f where f.topic LIKE :theme";
			mcqs = super.entityManager
					.createQuery(requete, MCQ.class)
//					.setParameter("designer", designer)
//					.setParameter("body", "%"+filtresQuestion.getBodyFiltre()+"%")
					.setParameter("theme","%"+ filtresMCQ.getThemeFiltre()+"%")
					.getResultList();
			break;
		case 10: // on ne filtre que sur le body
			requete = "select f from "  
					+ MCQ.class.getName() 
					+ " f where f.body LIKE :body";
			mcqs = super.entityManager
					.createQuery(requete, MCQ.class)
//					.setParameter("designer", designer)
					.setParameter("body", "%"+filtresMCQ.getBodyFiltre()+"%")
//					.setParameter("theme","%"+ filtresQuestion.getThemeFiltre()+"%")
					.getResultList();
			break;
		case 11: // on ne filtre  sur le body et le theme
			requete = "select f from "  
					+ MCQ.class.getName() 
					+ " f where f.body LIKE :body and f.topic LIKE :theme";
			mcqs = super.entityManager
					.createQuery(requete, MCQ.class)
//					.setParameter("designer", designer)
					.setParameter("body", "%"+filtresMCQ.getBodyFiltre()+"%")
					.setParameter("theme","%"+ filtresMCQ.getThemeFiltre()+"%")
					.getResultList();
			break;	
		default:
			break;
		}
		return mcqs;
	}


	public List<QuestionUsed> findQuestionUsedbyMcq(MCQ mcq) {		
		String requete = "select q from "  
				+ QuestionUsed.class.getName() 
				+ " q where ( q.mcq= :mcq )";
		
		// JPQL (ou HQL)
		return super.entityManager
				.createQuery(requete, QuestionUsed.class)
				.setParameter("mcq", mcq)
				.getResultList();
	}


	
	//cette requete plante, je ne parviens pas à lire dans la base MCQpassed ??? !!!
	//soucis avec l'entityManager de MCQ qui ne me donne pas acces à la table MCQPAssed ??
	
	public List<MCQpassed> findMCQpassedByMcq(MCQ mcq) {
		List<MCQpassed> mcqPasseds=new ArrayList<>();
		try {
			String requete = "select q from "  
					+ MCQpassed.class.getName() 
					+ " q where ( q.mcq= :mcq )";
			
			// JPQL (ou HQL)
			mcqPasseds=super.entityManager
					.createQuery(requete, MCQpassed.class)
					.setParameter("mcq", mcq)
					.getResultList();
	
		} catch (Exception e) {
			System.out.println("exception leve par findMCQpassedByMcq");
		}
		return mcqPasseds;
		
	}
	


		
		public List<MCQ> findMcqByQuestion(Question question) {
			String requete = "select f from "  
					+ MCQ.class.getName() 
					+ " f join fetch f.questionUseds t"
					+ " where t.question = :question";
			
			// JPQL (ou HQL)
			return super.entityManager
					.createQuery(requete, MCQ.class)
					.setParameter("question", question)
					.getResultList();
	}


		public List<MCQ> findByStatus(Status status) {
			String requete = "select f from "  
					+ MCQ.class.getName() 
					+ " f where f.status = :status";
			
			// JPQL (ou HQL)
			return super.entityManager
					.createQuery(requete, MCQ.class)
					.setParameter("status", status)
					.getResultList();
		}


		public List<MCQpassed> findMCQpassedForResultByMcq(MCQ mcq) {
			//je ne retourne donc que les MCQpassed de ce MCQ
			// je ne prends en compte que les jeux fait depuis webApp
			// si aucune question validée, alors je ne prends pas en compte non plus
			// (d'ailleur il faudra penser à sup ces fiche (attention qd mêm à celle en cours de création)
			// les fiche qui ne proviennent pas de webapp dans QCMpassed on un champs signatureAuthentification à null
			// pas de question passée, alors nbQuestionRep=0
			List<MCQpassed> mcqPasseds=new ArrayList<>();
			try {
				String requete = "select q from "  
						+ MCQpassed.class.getName() 
						+ " q where ( q.mcq= :mcq ) and (q.nbQuestionRep!= '0' ) and (q.signatureAutentification != 'null')";
					
				// JPQL (ou HQL)
				mcqPasseds=super.entityManager
						.createQuery(requete, MCQpassed.class)
						.setParameter("mcq", mcq)
						.getResultList();
		
			} catch (Exception e) {
				System.out.println("exception leve par findMCQpassedByMcq");
			}
			return mcqPasseds;
		}


		public List<MCQpassed> findAllMCQpassedWithResult() {
			List<MCQpassed> mcqPasseds=new ArrayList<>();
			try {
				String requete = "select q from "  
						+ MCQpassed.class.getName() 
						+ " q where (q.nbQuestionRep!= '0' ) and (q.signatureAutentification != 'null')";
					
				// JPQL (ou HQL)
				mcqPasseds=super.entityManager
						.createQuery(requete, MCQpassed.class)
						.getResultList();
		
			} catch (Exception e) {
				System.out.println("exception leve par findMCQpassedByMcq");
			}
			return mcqPasseds;
		}
}
