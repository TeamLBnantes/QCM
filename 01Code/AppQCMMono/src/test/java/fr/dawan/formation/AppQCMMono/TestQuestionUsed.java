package fr.dawan.formation.AppQCMMono;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.QuestionUsed;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.MCQDAO;
import fr.dawan.formation.AppQCMMono.Persistence.QuestionDAO;
import fr.dawan.formation.AppQCMMono.Services.MCQService;

public class TestQuestionUsed {

	@Test
	public void testQuestionsByMcq() {
		
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		MCQ	mcq = new MCQ();
		
		Designer designer = new Designer();
		
		QuestionDAO questionDAO = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		Question question1 = new Question();
		Question question2 = new Question();
		
		QuestionUsed questionUsed1 = new QuestionUsed();
		QuestionUsed questionUsed2 = new QuestionUsed();
		
		
		//designer.setId(99);
		
		//mcq.setId(99);
		mcq.setBody("questionnaireTest1");
		mcq.setDesigner(designer);
		mcqDao.saveOrUpdate(mcq);
		mcqDao.close();
		
		//question1.setId(999);
		question1.setBody("questionTest1");
		question1.setDesigner(designer);
		questionDAO.saveOrUpdate(question1);
		
		//question2.setId(998);
		question2.setBody("questionTest2");
		question2.setDesigner(designer);
		questionDAO.saveOrUpdate(question2);
		questionDAO.close();
		
		//questionUsed1.setId(999);
		questionUsed1.setMcq(mcq);
		questionUsed1.setQuestion(question1);
		
		//questionUsed2.setId(998);
		questionUsed2.setMcq(mcq);
		questionUsed2.setQuestion(question2);
		

	}

}
