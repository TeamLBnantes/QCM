package fr.dawan.formation.QCMappPersistenceInterfaces;

import java.util.ArrayList;

import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.QCMappModelEnum.Status;
import fr.dawan.formation.QCMappModelEnum.Theme;

public interface DAOQuestionInterface {


	public void create(Question question);
	public void update(Question question);
	public void delete(int idQuestion);
	public Question searchById (int idQuestion);
	public ArrayList<Question> searchByTheme (String theme);
	public ArrayList<Question> searchByStatus (Status status);
	public ArrayList<Question> searchByKWBody (String kw);
	public ArrayList<Question> searchAll ();
	public ArrayList<Question> searchByDesigner (int idDesigner);
}
