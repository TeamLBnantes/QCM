package fr.dawan.formation.AppQCMMono.Persistence.Interfaces;

import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.Answer;

public interface DAOAnswerInterface {


	
	public List<Answer> searchByIdQuestion (int idQuestion);
}
