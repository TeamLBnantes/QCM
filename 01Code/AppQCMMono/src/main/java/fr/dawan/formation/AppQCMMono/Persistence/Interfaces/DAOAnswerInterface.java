package fr.dawan.formation.AppQCMMono.Persistence.Interfaces;

import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.Question;

public interface DAOAnswerInterface {


	
	public List<Answer> searchByIdQuestion (Question question);
}
