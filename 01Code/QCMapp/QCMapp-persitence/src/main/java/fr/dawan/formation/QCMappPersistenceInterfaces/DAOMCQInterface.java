package fr.dawan.formation.QCMappPersistenceInterfaces;

import java.util.ArrayList;

import fr.dawan.formation.QCMappModel.MCQ;
import fr.dawan.formation.QCMappModelEnum.Status;
import fr.dawan.formation.QCMappModelEnum.Theme;

public interface DAOMCQInterface {


	public void create(MCQ mcq);
	public void update(MCQ mcq);
	public void delete(int idMcq);
	public ArrayList<MCQ> searchById (int idMcq);
	public ArrayList<MCQ> searchByTheme (Theme theme);
	public ArrayList<MCQ> searchByStatus (Status status);
	public ArrayList<MCQ> searchByKWBody (String kw);
	public ArrayList<MCQ> searchAll ();
	public ArrayList<MCQ> searchByAuthor (int idAuthor);
}
