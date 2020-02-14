package fr.dawan.formation.AppQCMMono.Persistence;

import java.util.List;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Persistence.Interfaces.DAOQuestionInterface;

public class QuestionDAO extends GenericDAO<Question> implements DAOQuestionInterface{

	public QuestionDAO(String persistenceUnitName) {
		super(persistenceUnitName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Question> searchByTheme(String theme) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> searchByStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> searchByKWBody(String kw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> searchByDesigner(int idQuestion) {
		// TODO Auto-generated method stub
		return null;
	}

}
