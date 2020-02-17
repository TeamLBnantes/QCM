package fr.dawan.formation.AppQCMMono.Persistence.Interfaces;

import java.time.LocalDate;
import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.User;


public interface DAOuserInterface {


	
	public List<User> searchByDesigner ();
	public List<User> searchByKW (String kw);
	public List<User> searchByDate (LocalDate date1, LocalDate date2);

}
