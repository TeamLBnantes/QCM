package fr.dawan.formation.AppQCMMono.Persistence.Interfaces;
import java.time.LocalDate;
import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.User;

public interface DAOInterfaceUser {	
	
	public User searchByEmail(String email);
	public List<User> searchDesigners ();
	public List<User> searchByPseudo (String pseudo);
	public List<User> searchByDate (LocalDate dateInf, LocalDate dateSup);
}
