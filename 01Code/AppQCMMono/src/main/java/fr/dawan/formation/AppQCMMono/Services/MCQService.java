package fr.dawan.formation.AppQCMMono.Services;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.MCQpassed;
import fr.dawan.formation.AppQCMMono.Models.ObjectFiltresMCQ;
import fr.dawan.formation.AppQCMMono.Models.ObjectPasserMcq;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.QuestionUsed;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.GenericDAO;
import fr.dawan.formation.AppQCMMono.Persistence.MCQDAO;
import fr.dawan.formation.AppQCMMono.Persistence.QuestionDAO;

public class MCQService {

	public List<MCQ> searchByDesigner(Designer designer) {
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<MCQ> mcqs=mcqDao.searchByDesigner(designer);
		mcqDao.close();
		return mcqs;
	}

	public void create(MCQ mcq) {
		// TODO attention pour le moment, je ne vérifie pas si présence de doublon dans les mcq
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		mcqDao.saveOrUpdate(mcq);
		mcqDao.close();
	}

	public void deleteById(int id) {
		
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		mcqDao.deleteById(MCQ.class, id);
		mcqDao.close();
	}

	public MCQ searchById(int id) {
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		MCQ mcq=mcqDao.findById(MCQ.class, id);
		mcqDao.close();

		return mcq;
	}

	public void saveOrUpdate(MCQ mcqUpdate) {
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		mcqDao.saveOrUpdate(mcqUpdate);
		mcqDao.close();
		
	}
	
	

	public void addQuestion(MCQ mcq, int idQuestion) {
		GenericDAO<QuestionUsed> questionUsedDao=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		QuestionUsed questionUsed=new QuestionUsed();
		questionUsed.setMcq(mcq);
		QuestionDAO questionDAO=new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		questionUsed.setQuestion(questionDAO.findById(Question.class, idQuestion));
		questionDAO.close();
		questionUsedDao.saveOrUpdate(questionUsed);
		questionUsedDao.close();
		
	}

	public void deleteQuestion(int id, int questionId) {
	
		GenericDAO<QuestionUsed> questionUsedDao=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		MCQDAO mcqDao=new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		QuestionDAO questionDao=new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		
		Question question=questionDao.findById(Question.class, questionId);
		MCQ mcq=mcqDao.findById(MCQ.class, id);
		QuestionUsed qUsed=mcqDao.findQuestionUsedbyMcqAndQuestion(mcq, question);
		
		questionUsedDao.deleteById(QuestionUsed.class, qUsed.getId());
		
		questionUsedDao.close();
		mcqDao.close();
		questionDao.close();
		
	}

	public Set<MCQ> findAll() {
		MCQDAO mcqDao=new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		Set<MCQ> mcqs= mcqDao.findAll(MCQ.class);
		mcqDao.close();
		return mcqs;
	}

	public List<MCQ> searchWithFiltre(ObjectFiltresMCQ filtresMCQ, User user) {
		MCQDAO mcqDao=new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<MCQ> mcqs= mcqDao.searchWithFiltre(filtresMCQ, user);
		mcqDao.close();
		return mcqs;
	}

	public ObjectPasserMcq initTrackMcq(MCQ mcq, User user) {
		MCQDAO mcqDao=new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		ObjectPasserMcq trackMcq=new ObjectPasserMcq();
		trackMcq.setListQuestionsUsed(mcqDao.findQuestionUsedbyMcq(mcq));
		mcqDao.close();
		trackMcq.setNbQuestionsTotal(trackMcq.getListQuestionsUsed().size());
		//mélange de la liste des question
		Collections.shuffle(trackMcq.getListQuestionsUsed());
		//fin du mélange
		trackMcq.setNbQuestionsPassed(0);
		trackMcq.setNbBonnesReponses(0);
		GenericDAO<MCQpassed> mcqPassedDao=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		MCQpassed mcqPassed=new MCQpassed(user, mcq);
		mcqPassed=mcqPassedDao.saveOrUpdate(mcqPassed);
		mcqPassedDao.close();
		trackMcq.setMcqPassed(mcqPassed);
		
		return trackMcq;
	}


	


}
