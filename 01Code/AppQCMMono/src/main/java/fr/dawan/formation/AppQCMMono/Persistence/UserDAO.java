 package fr.dawan.formation.AppQCMMono.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Interfaces.DAOInterfaceUser;

public class UserDAO extends GenericDAO<User> implements DAOInterfaceUser {

	public UserDAO(String persistenceUnitName) {
		super(persistenceUnitName);
	}

	@Override
	public List<User> searchDesigners() {
		 String requete = "SELECT u FROM " 
				 + User.class.getName()
				 +" u join fetch u.designer d"	
				 +" WHERE d.user!= :user";
		 
		return super.entityManager
				.createQuery(requete, User.class)
				.setParameter("user", null)
				.getResultList();	
	}

	@Override
	public List<User> searchByPseudo(String pseudo) {
		String requete = "SELECT u FROM "
				+ User.class.getName()
				+ " u WHERE u.pseudo LIKE :pseudo";
		
		return super.entityManager
				.createQuery(requete, User.class)
				.setParameter("pseudo", "%"+pseudo+"%")
				.getResultList();
	}

	@Override
	public List<User> searchByDate(LocalDate dateInf, LocalDate dateSup) {
		String requete = "SELECT DISTINCT u FROM "
				+ User.class.getName()
				+ " WHERE ((u.signInDate > :dateInf)&&(u.signInDate < :dateSup))";
		
		return super.entityManager
						.createQuery(requete, User.class)
						.setParameter("dateInf", dateInf)
						.setParameter("dateSup", dateSup)
						.getResultList();
	}

	@Override
	public User searchByEmail(String email) {
		try {
			 String requete = "SELECT u FROM " + User.class.getName()
					 +" u WHERE u.email= :email";
					 
					return super.entityManager
							.createQuery(requete, User.class)
							.setParameter("email", email)
							.getSingleResult();	
		} catch (Exception e) {
			return null;
		}
		
	}

	public User searchMailDesignerByMcqId(int mcqId) {
		String requete = "select u from "  
				+ User.class.getName() 
				+ " u join fetch u.designer d"
				+ "  join fetch d.mcq m"
				+ " where m.id = :id";
				//+ " f where f.value = theme";
		
		// JPQL (ou HQL)
		return super.entityManager
				.createQuery(requete, User.class)
				.setParameter("id", mcqId)
				.getSingleResult();	

	}

	public User searchMailDesignerByQuestionId(int questionId) {
		String requete = "select u from "  
				+ User.class.getName() 
				+ " u join fetch u.designer d"
				+ "  join fetch d.questions q"
				+ " where q.id = :id";
				//+ " f where f.value = theme";
		
		// JPQL (ou HQL)
		return super.entityManager
				.createQuery(requete,  User.class)
				.setParameter("id", questionId)
				.getSingleResult();	

	}
	
	
}
