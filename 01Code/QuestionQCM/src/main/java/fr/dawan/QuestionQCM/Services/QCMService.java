package fr.dawan.QuestionQCM.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.Beans.Multimedia;
import fr.dawan.QuestionQCM.Beans.QuestionUsed;
import fr.dawan.QuestionQCM.DTO.MCQPlayableDto;
import fr.dawan.QuestionQCM.DTO.MCQforListDto;
import fr.dawan.QuestionQCM.DTO.QuestionPlayableDto;
import fr.dawan.QuestionQCM.DTO.QuestionUsedPlayableDto;
import fr.dawan.QuestionQCM.Repositories.QCMRepository;

@Service
public class QCMService {
	
	@Autowired
	private QCMRepository repository;
	
	public MCQPlayableDto find(int id) {
		MCQ mcq = repository.findById(id).orElse(null);
		
		if (mcq == null) {
			return null;
		}
		MCQPlayableDto mcqdto = new MCQPlayableDto();
		mcqdto.setId(mcq.getId());
		mcqdto.setBody(mcq.getBody());
		mcqdto.setTopic(mcq.getTopic());
		mcqdto.setCreateDate(mcq.getCreateDate());
		mcqdto.setEditDate(mcq.getEditDate());
		mcqdto.setDesignerPseudo(mcq.getDesigner().getUser().getPseudo());
		mcqdto.setMultimedia(mcq.getMultimedia());
		Set<Integer> questionsId = new HashSet<Integer>();
		for (QuestionUsed questionused : mcq.getQuestionUseds()) {
			questionsId.add(questionused.getQuestion().getId());
		}
		mcqdto.setQuestionsId(questionsId);
		
		return mcqdto;
	}

	public List<MCQ> findAll() {
		return repository.findAll2();
	}
	
	/**
	 * called to generate list of MCQ
	 * No question (nor question id)
	 * No Multimedia object
	 * @return
	 */
	//
	public List<MCQforListDto> findAllDto() {
		List <MCQ> listMcq = repository.findAll2();
		List <MCQforListDto> listMcqDto = new ArrayList<MCQforListDto>();
		
		for (MCQ mcq : listMcq) {
			MCQforListDto mcqdto =new MCQforListDto();
			mcqdto.setId(mcq.getId());
			mcqdto.setBody(mcq.getBody());
			mcqdto.setTopic(mcq.getTopic());
			mcqdto.setCreateDate(mcq.getCreateDate());
			mcqdto.setEditDate(mcq.getEditDate());
			mcqdto.setDesignerPseudo(mcq.getDesigner().getUser().getPseudo());
			mcqdto.setNbOfQuestions(mcq.getQuestionUseds().size());
			
			listMcqDto.add(mcqdto);
		}
		
		return listMcqDto;
	}

	public MCQ create(MCQ qcm) {
		// Le flush permet de faire un commit intermédiare, en cours de la transaction
		// repository.flush();
		return repository.save(qcm);
	}

	public MCQ update(MCQ qcm) {
		if (!repository.existsById(qcm.getId())) {
			throw new RuntimeException("Le QCM n'existe pas");
		}
		return repository.save(qcm);
	}

	public boolean delete(int id) {
		repository.deleteById(id);
		repository.flush();
		return !repository.existsById(id);
	}
	
	
}
