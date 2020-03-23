package fr.dawan.QuestionQCM.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.QuestionQCM.Beans.Answer;
import fr.dawan.QuestionQCM.Beans.Question;
import fr.dawan.QuestionQCM.DTO.AnswerCorrectionDto;
import fr.dawan.QuestionQCM.DTO.AnswerPlayableDto;
import fr.dawan.QuestionQCM.DTO.QuestionCorrectionDto;
import fr.dawan.QuestionQCM.DTO.QuestionPlayableDto;
import fr.dawan.QuestionQCM.Repositories.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository repository;
	/**
	 * Send DTO of a question
	 *  @param id
	 * during the game,
	 * without any part of answer
	 *
	 * @return
	 */
	public QuestionPlayableDto find(int id) {
		Question q=repository.findById(id).orElse(null);
		if (q == null) {
			return null;
		}
		QuestionPlayableDto qdto =new QuestionPlayableDto();
		qdto.setId(q.getId());
		qdto.setBody(q.getBody());
		qdto.setCreateDate(q.getCreateDate());
		qdto.setEditDate(q.getEditDate());
		qdto.setTopic(q.getTopic());
		qdto.setMultimedia(q.getMultimedia());
		qdto.setDesignerPseudo(q.getDesigner().getUser().getPseudo());
		Set <AnswerPlayableDto>answersPlayableDto = new HashSet<AnswerPlayableDto>();
		for (Answer answer : q.getAnswers()) {
			AnswerPlayableDto answerPlayable = new AnswerPlayableDto();
			answerPlayable.setId(answer.getId());
			answerPlayable.setBody(answer.getBody());
			answerPlayable.setMultimedia(answer.getMultimedia());

			answersPlayableDto.add(answerPlayable);
		}
		qdto.setAnswersPlayableDto(answersPlayableDto);
		
		
		return qdto;
	}
 /**
  * send the correction elements
  * for a question
  * @param id
  * @return
  */
	public QuestionCorrectionDto correction(int id) {
		Question q=repository.findById(id).orElse(null);
		if (q == null) {
			return null;
		}
		QuestionCorrectionDto qCorrection = new QuestionCorrectionDto();
		
		qCorrection.setId(q.getId());
		qCorrection.setCommentPostAnswer(q.getCommentPostAnswer());
		
		Set <AnswerCorrectionDto>answersCorrectionDto = new HashSet<AnswerCorrectionDto>();
		for (Answer answer : q.getAnswers()) {
			AnswerCorrectionDto answerCorrection= new AnswerCorrectionDto();
			answerCorrection.setId(answer.getId());
			answerCorrection.setExpectedAnswer(answer.isExpectedAnswer());
			answerCorrection.setCommentPostAnswer(answer.getCommentPostAnswer());

			answersCorrectionDto.add(answerCorrection);
		}
		qCorrection.setAnswersCorrectionDto(answersCorrectionDto);
		
		return qCorrection;
	}
	
	
	public List<Question> findAll() {
		return repository.findAll2();
	}

	public Question create(Question m) {
		// Le flush permet de faire un commit intermédiare, en cours de la transaction
		// repository.flush();
		return repository.save(m);
	}

	public Question update(Question m) {
		if (!repository.existsById(m.getId())) {
			throw new RuntimeException("Le Question n'existe pas");
		}
		return repository.save(m);
	}

	public boolean delete(int id) {
		repository.deleteById(id);
		repository.flush();
		return !repository.existsById(id);
	}

	
	
	
}
