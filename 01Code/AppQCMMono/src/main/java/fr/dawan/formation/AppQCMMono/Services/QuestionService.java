package fr.dawan.formation.AppQCMMono.Services;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.AnswerDAO;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.QuestionDAO;
import fr.dawan.formation.AppQCMMono.Persistence.UserDAO;

public class QuestionService {

	
	
	public void saveOrUpdate(Question q) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);

		
		//if.q..q..q..q..q..q..
		
		
		
		
		questionDao.saveOrUpdate(q);
		questionDao.close();
	}
	
	public void saveOrUpdate(Collection<Question> questions) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);

		questionDao.saveOrUpdate(questions);
		questionDao.close();

	}

	public Question findById(int id) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);

		return questionDao.findById(Question.class, id);
		
	}

	public Set<Question> findAll(Question d) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);


	return questionDao.findAll(Question.class);
}



	public List<Question> searchByDesigner(Designer designer) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<Question> questions=questionDao.searchByDesigner(designer);	
		questionDao.close();
		return questions;
	}
}
