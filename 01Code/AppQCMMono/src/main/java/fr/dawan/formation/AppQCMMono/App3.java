package fr.dawan.formation.AppQCMMono;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dawan.formation.AppQCMMono.Models.Question;

/**
 * Hello world!
 *
 */
public class App3 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("app_QCM");

		// Entity manager : objet qui nous permet les échanges avec la bdd
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// création d'un objet formation
		Question question = new Question();
		question.setBody("ifjsdivfsjmfjsjflsjvs");

		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(question);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			//rollback annule la transaction, ici dans le cas d'une exception.
			transaction.rollback();
			
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
    }
}
