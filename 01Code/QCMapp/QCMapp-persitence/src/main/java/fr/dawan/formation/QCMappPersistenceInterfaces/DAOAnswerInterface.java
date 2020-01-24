package fr.dawan.formation.QCMappPersistenceInterfaces;

import java.util.ArrayList;

import fr.dawan.formation.QCMappModel.Answer;

public interface DAOAnswerInterface {


	public void create(Answer answer);
	public void update(Answer answer);
	public void delete(int idAnswer);
	public ArrayList<Answer> searchById (int idAnswer);
	public ArrayList<Answer> searchByIdQuestion (int idQuestion);
}
