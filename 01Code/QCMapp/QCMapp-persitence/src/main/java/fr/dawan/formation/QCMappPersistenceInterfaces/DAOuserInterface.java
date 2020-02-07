package fr.dawan.formation.QCMappPersistenceInterfaces;

import java.util.ArrayList;
import java.util.Date;

import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;


public interface DAOuserInterface {


	public void create(User user);
	public void update(User user);
	public void delete(int idUser);
	public ArrayList<User> searchByDesigner (boolean designer);
	public ArrayList<User> searchByKW (String kw);
	public ArrayList<User> searchAll ();
	public ArrayList<User> searchByDate (Date date1, Date date2);
	public User searchById (int id);
}
