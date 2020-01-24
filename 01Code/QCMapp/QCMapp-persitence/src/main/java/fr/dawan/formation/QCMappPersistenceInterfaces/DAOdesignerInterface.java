package fr.dawan.formation.QCMappPersistenceInterfaces;

import java.util.ArrayList;
import java.util.Date;

import fr.dawan.formation.QCMappModel.Designer;



public interface DAOdesignerInterface {


	public void create(Designer designer);
	public void update(Designer designer);
	public void delete(int id);
	public ArrayList<Designer> searchByCertifier (boolean Certifier);
	public ArrayList<Designer> searchByKW (String kw);
	public ArrayList<Designer> searchAll ();
	public ArrayList<Designer> searchByDate (Date date1, Date date2);
	public ArrayList<Designer> searchById (int id);
}
