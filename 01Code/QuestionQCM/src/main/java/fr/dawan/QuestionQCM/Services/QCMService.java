package fr.dawan.QuestionQCM.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.Beans.Multimedia;
import fr.dawan.QuestionQCM.DTO.MCQdto;
import fr.dawan.QuestionQCM.Repositories.QCMRepository;

@Service
public class QCMService {
	
	@Autowired
	private QCMRepository repository;
	
	public MCQ find(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<MCQ> findAll() {
		return repository.findAll2();
	}
	public List<MCQdto> findAllDto() {
		List <MCQ> listMcq = repository.findAll2();
		List <MCQdto> listMcqDto = new ArrayList();
		
	
		for (MCQ mcq : listMcq) {
			MCQdto mcqdto =new MCQdto();
			mcqdto.setId(mcq.getId());
			mcqdto.setBody(mcq.getBody());
			mcqdto.setTopic(mcq.getTopic());
			mcqdto.setCreateDate(mcq.getCreateDate());
			mcqdto.setEditDate(mcq.getEditDate());
			mcqdto.setDesignerPseudo(mcq.getDesigner().getUser().getPseudo());
			mcqdto.setMultimedia(mcq.getMultimedia());
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
