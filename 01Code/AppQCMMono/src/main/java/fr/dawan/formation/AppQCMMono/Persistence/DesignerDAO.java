package fr.dawan.formation.AppQCMMono.Persistence;

import java.time.LocalDate;
import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Persistence.Interfaces.DAODesignerInterface;

public class DesignerDAO extends GenericDAO<Designer> implements DAODesignerInterface
{

	public DesignerDAO(String persistenceUnitName) {
		super(persistenceUnitName);
	}

	@Override
	public List<Designer> searchByCertifier(boolean Certifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Designer> searchByKW(String kw) {
		String requete = "select d from "
				+ Designer.class.getName()
				+" d where d.presentation"
				+ " like  :kw";
				return super.entityManager
						.createQuery(requete, Designer.class)
						.setParameter("kw", "%"+kw+"%")
						.getResultList();
	}
	
	@Override
	public List<Designer> searchByDate(LocalDate dateInf, LocalDate dateSup) { 
		String requete = "SELECT DISTINCT d FROM "
		+ Designer.class.getName()
		+ " WHERE ((d.dateStatus > :dateInf)&&(d.dateStatus < :dateSup))";
		return super.entityManager
				.createQuery(requete, Designer.class)
				.setParameter("dateInf", dateInf)
				.setParameter("dateSup", dateSup)
				.getResultList();
	}

}