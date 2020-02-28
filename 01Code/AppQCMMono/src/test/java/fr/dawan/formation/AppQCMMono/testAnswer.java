package fr.dawan.formation.AppQCMMono;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Persistence.AnswerDAO;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Services.AnswerService;

public class testAnswer {

	@Test
	public void test() {
//		AnswerService answerService=new AnswerService();
//		answerService.deleteById(4);

		AnswerDAO answerDAO = new AnswerDAO(Constantes.PERSISTENCE_UNIT_NAME);
		answerDAO.deleteById(Answer.class, 4);
		Answer a=answerDAO.findById(Answer.class, 4);
		assertNull(a);
		answerDAO.close();
	}

}
