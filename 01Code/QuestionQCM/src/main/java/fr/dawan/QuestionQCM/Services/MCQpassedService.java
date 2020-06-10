package fr.dawan.QuestionQCM.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.Beans.MCQpassed;
import fr.dawan.QuestionQCM.Beans.QuestionUsed;
import fr.dawan.QuestionQCM.DTO.MCQPlayableDto;
import fr.dawan.QuestionQCM.Repositories.MCQpassedRepository;
import fr.dawan.QuestionQCM.Repositories.QCMRepository;
import fr.dawan.QuestionQCM.Repositories.QuestionUsedRepository;
import javassist.bytecode.Mnemonic;

@Service
public class MCQpassedService {

	
	@Autowired
	private MCQpassedRepository repository;
	
	
	
	public int updateResultatMCQpassed(int idMcqPassed, boolean resultQuestion) {  //je vais renvoyer l'Id du QCM pour maj Q used en retour
		MCQpassed mcqPassed=this.find(idMcqPassed);
		// mcqPassed.getResult()   entier entre 0 et 100 correspondant au 100% de bonne reponses
		if (resultQuestion) {
			mcqPassed.setResult(mcqPassed.getResult()+1);
		}
		mcqPassed.setNbQuestionRep(mcqPassed.getNbQuestionRep()+1);
		if (mcqPassed.getNbQuestionRep()==mcqPassed.getNbQuestionTotal()) {
			mcqPassed.setFinalise(true);
		}
		mcqPassed=this.update(mcqPassed);
		System.out.println(mcqPassed.getResult()+" / "+mcqPassed.getNbQuestionRep()+" / "+mcqPassed.getNbQuestionTotal());
		System.out.println("% de bonne rep (/total): "+(mcqPassed.getResult() *100/mcqPassed.getNbQuestionTotal()));
		return mcqPassed.getMcq().getId();
	}
	
	
	public MCQpassed find(int id) {
		MCQpassed mcqPassed = repository.findById(id).orElse(null);
		if (mcqPassed == null) {
			return null;
		}
		return mcqPassed;
	}
	
	
	public MCQpassed create(MCQpassed mcqPassed) {
		// Le flush permet de faire un commit intermédiare, en cours de la transaction
		// repository.flush();
		return repository.save(mcqPassed);
	}

	public MCQpassed  update(MCQpassed  mcqPassed) {
		if (!repository.existsById(mcqPassed.getId())) {
			throw new RuntimeException("cette QuestionUsed n'existe pas");
		}
		return repository.save(mcqPassed);
	}

	public boolean delete(int id) {
		repository.deleteById(id);
		repository.flush();
		return !repository.existsById(id);
	}
	
	
	
	
}
