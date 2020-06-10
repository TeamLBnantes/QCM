package fr.dawan.QuestionQCM.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.Beans.MCQpassed;
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
	@Autowired
	private MCQpassedService mcqPassedService;
	
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
//		Set<Integer> questionsId = new HashSet<Integer>();
		List<Integer> questionsId = new ArrayList<>();
		
		//mcq.getQuestionUseds() fournis un set, je vais transformer en list, pour trier suivant id questionUsed
		List<QuestionUsed> listQuestionsUsed=new ArrayList<>();
		for (QuestionUsed questionused : mcq.getQuestionUseds()) {
			listQuestionsUsed.add(questionused);
		}
		System.out.println(listQuestionsUsed);
		Collections.sort(listQuestionsUsed, new Comparator<QuestionUsed>() {
		    @Override
		    public int compare(QuestionUsed QU1, QuestionUsed QU2) {
		    	return Integer.compare(QU1.getId(),QU2.getId());
		    }
		});
		
		//for (QuestionUsed questionused : mcq.getQuestionUseds()) {
		for (QuestionUsed questionused : listQuestionsUsed) {
			questionsId.add(questionused.getQuestion().getId());
		}
		System.out.println(questionsId);
		if (!(mcq.getBody().indexOf("[QOrdonnees]")>=0)){
			//les question sont dans l'ordre id Question Used, je les melange puisque mcq non ordonn�es
			Collections.shuffle(questionsId);
		}
		System.out.println(questionsId);

		mcqdto.setQuestionsId(questionsId);

		//créer la fiche QCMpassed, et affecter son id dans mcqdto
		// on crer avec id du qcm et pas de ref au user(on le laisse à null)
		// en fin de process, l'utilisateur poura doner son login pour enregistrement
		MCQpassed mcqPassed=new MCQpassed(null, mcq);  //creation de la données MCQpassed
		int nbQ=mcqPassed.getMcq().getQuestionUseds().size();
		mcqPassed.setNbQuestionTotal(nbQ);
		mcqPassed=mcqPassedService.create(mcqPassed);  //enregistrement en bdd pour recup id
		mcqdto.setIdMCQpassed(mcqPassed.getId());
		

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
		int i=0;
		for (MCQ mcq : listMcq) {
			i=mcq.getQuestionUseds().size();
			if ((i!=0) && (mcq.getStatus().getLibelle()=="disponible")) {       //je ne retourne que les qcm qui ont au moins une question
				MCQforListDto mcqdto =new MCQforListDto();
				mcqdto.setId(mcq.getId());
				mcqdto.setBody(mcq.getBody());
				mcqdto.setTopic(mcq.getTopic());
				mcqdto.setCreateDate(mcq.getCreateDate());
				mcqdto.setEditDate(mcq.getEditDate());
				mcqdto.setDesignerPseudo(mcq.getDesigner().getUser().getPseudo());
				mcqdto.setNbOfQuestions(i);
				listMcqDto.add(mcqdto);
			}
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
