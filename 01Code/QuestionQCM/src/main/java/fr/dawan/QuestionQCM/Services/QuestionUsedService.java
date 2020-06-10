package fr.dawan.QuestionQCM.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.Beans.Question;
import fr.dawan.QuestionQCM.Beans.QuestionUsed;
import fr.dawan.QuestionQCM.DTO.MCQPlayableDto;
import fr.dawan.QuestionQCM.Repositories.QCMRepository;
import fr.dawan.QuestionQCM.Repositories.QuestionRepository;
import fr.dawan.QuestionQCM.Repositories.QuestionUsedRepository;

@Service
public class QuestionUsedService {

	
	@Autowired
	private QuestionUsedRepository repository;
	@Autowired
	private QCMRepository qcmRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
	
	public QuestionUsed find(int id) {
		QuestionUsed questionUsed = repository.findById(id).orElse(null);
		if (questionUsed == null) {
			return null;
		}
		return questionUsed;
	}
	
	public QuestionUsed findQuestionUsed(MCQ qcm, Question question) {
		QuestionUsed questionUsed = repository.findQuestionUsed(qcm,question);
		if (questionUsed == null) {
			return null;
		}
		return questionUsed;
	}
	
	
	
	public QuestionUsed create(QuestionUsed questionUsed) {
		// Le flush permet de faire un commit intermédiare, en cours de la transaction
		// repository.flush();
		return repository.save(questionUsed);
	}

	public QuestionUsed update(QuestionUsed questionUsed) {
		if (!repository.existsById(questionUsed.getId())) {
			throw new RuntimeException("cette QuestionUsed n'existe pas");
		}
		return repository.save(questionUsed);
	}

	public boolean delete(int id) {
		repository.deleteById(id);
		repository.flush();
		return !repository.existsById(id);
	}

	public void updateResultat(int idQcm, int idQuestion, boolean correction) {
		// TODO Auto-generated method stub
		MCQ mcq=qcmRepository.findById(idQcm).orElse(null);
		Question question=questionRepository.findById(idQuestion).orElse(null);
		QuestionUsed questionUsed=this.findQuestionUsed(mcq, question);
		questionUsed.setNbAnswered(questionUsed.getNbAnswered()+1);
		if (correction) {
			questionUsed.setNbCorrect(questionUsed.getNbCorrect()+1);
		}
		this.update(questionUsed);
	}
	
	
	
	
}
