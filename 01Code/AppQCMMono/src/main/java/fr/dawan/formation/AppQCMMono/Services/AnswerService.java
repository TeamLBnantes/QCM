package fr.dawan.formation.AppQCMMono.Services;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Persistence.AnswerDAO;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.DesignerDAO;

public class AnswerService {

	AnswerDAO answerDAO = new AnswerDAO(Constantes.PERSISTENCE_UNIT_NAME);
	
	public Answer saveOrUpdate(Answer a) {
		a=answerDAO.saveOrUpdate(a);
		answerDAO.close();
		return a;
	}

	public void deleteById(int idAnswer) {
		answerDAO.deleteById(Answer.class, idAnswer);
		answerDAO.close();
	}

	public Answer findById(int idAnswer) {
		
		Answer a=answerDAO.findById(Answer.class, idAnswer);
		answerDAO.close();

		return a;
	}
}
