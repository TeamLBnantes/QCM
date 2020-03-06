package fr.dawan.formation.AppQCMMono.Persistence;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.dawan.formation.AppQCMMono.Models.Entitie;

public class GenericDAO<T extends Entitie> {

	protected EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;

	/**
	 * Initialise le dao et son EntityManager
	 */
	public GenericDAO(String persistenceUnitName) {
		// Fabrique d'entity manager : on précise le nom du persistence-unit
		// qui nous intéresse
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

		// Entity Manager : objet qui nous permet les échanges avec la BDD
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}

	public T saveOrUpdate(T entite) {

		// récupération de la transaction
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			// ouverture de la transaction
			transaction.begin();

			// persistance
			if (entite.getId() == 0) {
				// insertion
				entityManager.persist(entite);
			} else {
				// mise à jour
				entityManager.merge(entite);
			}

			// validation de la transaction
			transaction.commit();

			// fermeture de la transaction
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		return entite;
	}
	
	public void saveOrUpdate(Collection<T> entites) {

		// récupération de la transaction
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			// ouverture de la transaction
			transaction.begin();

			for (T e : entites) {
				if (e != null) {
					// persistance
					if (e.getId() == 0) {
						// insertion
						entityManager.persist(e);
					} else {
						// mise à jour
						entityManager.merge(e);
					}
				}
			}

			// validation de la transaction
			transaction.commit();

			// fermeture de la transaction
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
	}

	public T findById(Class<T> clazz, int id) {
		return entityManager.find(clazz, id);
	}

	public Set<T> findAll(Class<T> clazz) {
		TypedQuery<T> query = entityManager.createQuery("SELECT e FROM " + clazz.getName() + " e", clazz);
		// exemple avec un where :
		// WHERE e.prenom = 'Jean-Paul'

		return new HashSet<T>(query.getResultList());

	}

	public void deleteById(Class<T> clazz, int id) {
		T entite = findById(clazz, id);

		if (entite != null) {
			// récupération de la transaction
			EntityTransaction transaction = entityManager.getTransaction();

			try {
				// ouverture de la transaction
				transaction.begin();

				// suppression
				entityManager.remove(entite);
				//System.out.println("entité "+ entite + "en attente de commit remove");
				// validation de la transaction
				transaction.commit();

				// fermeture de la transaction
			} catch (Exception ex) {
				//System.out.println("on est dans le catch de la transaction commit du remove !!!!!");
				transaction.rollback();
			}
		}
	}

}
