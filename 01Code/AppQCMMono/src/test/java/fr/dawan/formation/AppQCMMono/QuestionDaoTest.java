package fr.dawan.formation.AppQCMMono;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.QuestionDAO;

public class QuestionDaoTest {
	
	private  QuestionDAO daoQuestion;
	private Question question;
	private int id;
	@Before
	public void testSaveOrUpdate() {
		//test de l'ecriture en base de SaveOrUpdate
		daoQuestion = new  QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		question=new Question();
		//ajout question 1
		question.setBody("taratata 1");
		question.setAnswers(null);
		Assert.assertEquals(0L, question.getId());
		daoQuestion.saveOrUpdate(question);	
		Assert.assertNotEquals(0L, question.getId());
		id=question.getId();
		daoQuestion.close();
	}
	
	@After
	public void testDeleteById() {
		daoQuestion = new  QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		question=daoQuestion.findById(Question.class, id);
		Assert.assertNotNull(question);
		daoQuestion.deleteById(Question.class, question.getId());
		question=daoQuestion.findById(Question.class, id);
		Assert.assertNull(question);
		daoQuestion.close();
	}
	
	@Test
	public void TestFindById() {
		daoQuestion = new  QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		question=new Question();
		Assert.assertEquals(0, question.getId());
		question=daoQuestion.findById(Question.class, id);
		Assert.assertNotNull(question);
		Assert.assertEquals(id, question.getId());
		Assert.assertEquals("taratata 1", question.getBody());
		Assert.assertEquals(0,question.getAnswers().size());
		daoQuestion.close();	
	}

	@Test
	public void TestFindByKWBody() {
		daoQuestion = new  QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<Question> questions = new ArrayList<>();
		Assert.assertEquals(0,questions.size());
		questions=daoQuestion.FindByKwBody("taratata");
		Assert.assertEquals(1,questions.size());
		
		
		
		
		daoQuestion.close();
	}
}
