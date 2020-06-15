package fr.dawan.formation.AppQCMMono.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.MCQpassed;
import fr.dawan.formation.AppQCMMono.Models.Multimedia;
import fr.dawan.formation.AppQCMMono.Models.ObjectFiltresQuestion;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.QuestionUsed;
import fr.dawan.formation.AppQCMMono.Models.StatsMCQdto;
import fr.dawan.formation.AppQCMMono.Models.StatsQuestionDto;
import fr.dawan.formation.AppQCMMono.Models.StatsQuestionUsedDto;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.AnswerDAO;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.GenericDAO;
import fr.dawan.formation.AppQCMMono.Persistence.MCQDAO;
import fr.dawan.formation.AppQCMMono.Persistence.QuestionDAO;
import fr.dawan.formation.AppQCMMono.Persistence.UserDAO;
@Service
public class QuestionService {

	
	
	public Question saveOrUpdate(Question q) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		Question question=questionDao.saveOrUpdate(q);
		Multimedia multimedia = question.getMultimedia();
		if (multimedia != null) {
		multimedia.setQuestion(question);
		questionDao.saveOrUpdate(question);
		}
		questionDao.close();
		return question;
	}
	public Question saveOrUpdate2(Question question) {

		
	// TODO attention pour le moment, je ne vérifie pas si présence de doublon dans les mcq
			QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
			if (question.getId() == 0 ) {
			Multimedia multimedia = question.getMultimedia();
			question=questionDao.saveOrUpdate(question);
			//mcq.setMultimedia(multimediaDao.saveOrUpdate(mcq.getMultimedia()));
			//mcq.setMultimedia(multimedia);
			multimedia.setQuestion(question);
			}
			questionDao.saveOrUpdate(question);
			questionDao.close();
			return question;

	}
	
	
	public void saveOrUpdate(Collection<Question> questions) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);

		questionDao.saveOrUpdate(questions);
		questionDao.close();

	}

	public Question findById(int id) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		Question questionFound = questionDao.findById(Question.class, id);
		questionDao.close();

		return questionFound;

	}

	public Set<Question> findAll() {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		Set<Question> questions=questionDao.findAll(Question.class);
		questionDao.close();

	return questions;
}



	public List<Question> searchByDesigner(Designer designer) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<Question> questions=questionDao.searchByDesigner(designer);	
		questionDao.close();
		return questions;
	}

	public void deleteById(int id) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		AnswerDAO answerDAO=new AnswerDAO(Constantes.PERSISTENCE_UNIT_NAME);
		Question question=questionDao.findById(Question.class, id);
		for (Answer answer : question.getAnswers()) {
			answerDAO.deleteById(Answer.class, answer.getId());
		}
		questionDao.deleteById(Question.class, id);
		
		questionDao.close();
		answerDAO.close();

		
		
	}





	public List<Question> searchByMcq(MCQ mcq) {
		
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<Question> questions=questionDao.searchByMcq(mcq);
		questionDao.close();
		return questions;
	}





	public List<Question> searchWithFiltre(ObjectFiltresQuestion filtresQuestion, Designer designer) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<Question> questions=questionDao.findWithFiltre(filtresQuestion,designer);
		questionDao.close();

		return questions;
	}


//	private StatsQuestionDto StatsQuestion(Question question) {
//		StatsQuestionDto statsQuestionDto=new StatsQuestionDto();
//	
//		statsQuestionDto.setId(question.getId());
//		statsQuestionDto.setBody(question.getBody());
//		statsQuestionDto.setTopic(question.getTopic());   
//		statsQuestionDto.setDesigner(question.getDesigner()); 
//		QuestionDAO questionDao=new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
//		//statsMCQdto.setNbQuestionUsed(mcq.getQuestionUseds().size());
//		List<QuestionUsed> questionsUsed=questionDao.findQuestionUsedbyQuestion(question);
//		Collections.reverse(questionsUsed);   //pour afficher de plus recent au plus ancien		
//		
//		statsQuestionDto.setNbUsedByQcms(questionsUsed.size());
//		
//		List<StatsQuestionUsedDto> questionUsedDtos=new ArrayList<StatsQuestionUsedDto>();    //j'ai mis en direct dedans
//		
//		for (QuestionUsed questionUsed : questionsUsed) {
//			StatsQuestionUsedDto statsQuestionUsedDto=new StatsQuestionUsedDto();
//			statsQuestionUsedDto.setId(questionUsed.getId());
//			statsQuestionUsedDto.setNbAnswered(questionUsed.getNbAnswered());
//			statsQuestionDto.setNbAnswered(statsQuestionDto.getNbAnswered()+statsQuestionUsedDto.getNbAnswered());
//			statsQuestionUsedDto.setNbCorrect(questionUsed.getNbCorrect());
//			statsQuestionDto.setNbCorrect(statsQuestionDto.getNbCorrect()+statsQuestionUsedDto.getNbCorrect());
//			statsQuestionUsedDto.setIdMcq(questionUsed.getMcq().getId());
//			statsQuestionUsedDto.setIdDesignerMcq(questionUsed.getMcq().getDesigner().getId());
//			statsQuestionUsedDto.setMailDesignerMcq(questionUsed.getMcq().getDesigner().getUser().getEmail());
//			statsQuestionUsedDto.setBodyMCQ(questionUsed.getMcq().getBody());
//			statsQuestionUsedDto.setTopicMCQ(questionUsed.getMcq().getTopic());
//			questionUsedDtos.add(statsQuestionUsedDto);
//			
//		}
//		
//		statsQuestionDto.setQuestionUsedDtos(questionUsedDtos);
//		questionDao.close();
//		
//		return statsQuestionDto;
//	}
	
	
	
	// methode obsolete pour la recherche de tous les qcm
	//privilegier la v2, stat all QCM
//	public List<StatsQuestionDto>  StatsQuestions(int idUser) {
//		Set<Question> questions=new HashSet<Question>();
//		if (idUser==0) {//pour les admin, je vais renvoyer tous les stats (donc de tous les qcm)
//			questions=this.findAll();
//		}else {  //et donc sinon, je retourne les qcm de l'utilisateur(designer) connecté
//			UserService userService=new UserService();
//			
//			questions=new HashSet<Question>(this.searchByDesigner(userService.findById(idUser).getDesigner()));
//		}
//		
//		List<StatsQuestionDto> statsQuestionDtos = new ArrayList<StatsQuestionDto>();
//		for (Question question : questions) {
//			statsQuestionDtos.add(this.StatsQuestion(question));
//		}
//		
//		//trier statsMCQdtos, du QCM le plus recemment jouer au plus ancien
//		Collections.sort(statsQuestionDtos, new Comparator<StatsQuestionDto>() {
//		    @Override
//		    public int compare(StatsQuestionDto Q1, StatsQuestionDto Q2) {
//		    	return (Integer.compare(Q1.getId(), Q2.getId()));
//		    }
//		});
//		// a present le premier est le plus vieux, je vais donc inverser
//		//Collections.reverse(statsQuestionDtos);
//		
//		return statsQuestionDtos;
//		
//	}
	
	public List<StatsQuestionDto>  StatsQuestionsAll() {
		
		Set<Question> questions=new HashSet<Question>();
		questions=this.findAll();
		Map<Integer, StatsQuestionDto> mapStatsQuestionDto = new HashMap<>();
		//on parcour les question, et on remplis le map
		for (Question question : questions) {
			
			StatsQuestionDto statsQuestionDto=new StatsQuestionDto();
			statsQuestionDto.setId(question.getId());
			statsQuestionDto.setBody(question.getBody());
			statsQuestionDto.setTopic(question.getTopic());   
			statsQuestionDto.setDesigner(question.getDesigner());
			List<StatsQuestionUsedDto> questionUsedDtos=new ArrayList<>();
			statsQuestionDto.setQuestionUsedDtos(questionUsedDtos);   //j'initialise avec une liste vide
			//voila pour les infos propre à la question
			mapStatsQuestionDto.put(question.getId(), statsQuestionDto);
		}
		
		
		//ensuite on parcours les questionUsed et on remplis le map statsQuestionDto
		GenericDAO<QuestionUsed> questionUsedDAO=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		List<QuestionUsed> questionsUsed=new ArrayList<QuestionUsed>();
		questionsUsed.addAll(questionUsedDAO.findAll(QuestionUsed.class)); //je recupère un set que je transforme en liste
		questionUsedDAO.close();
		
		for (QuestionUsed questionUsed : questionsUsed) {
			//je recup l'ojet dans le map (je le met temporairement dans statsQdto
			StatsQuestionDto statsQdto=mapStatsQuestionDto.get(questionUsed.getQuestion().getId());
			//je le met à jour
			statsQdto.setNbAnswered(statsQdto.getNbAnswered()+questionUsed.getNbAnswered());
			statsQdto.setNbCorrect(statsQdto.getNbCorrect()+questionUsed.getNbCorrect());
			statsQdto.setNbUsedByQcms(statsQdto.getNbUsedByQcms()+1);
			
			StatsQuestionUsedDto statsQuestionUsedDto=new StatsQuestionUsedDto();
			statsQuestionUsedDto.setId(questionUsed.getId());
			statsQuestionUsedDto.setNbAnswered(questionUsed.getNbAnswered());
			statsQuestionUsedDto.setNbCorrect(questionUsed.getNbCorrect());
			statsQuestionUsedDto.setIdMcq(questionUsed.getMcq().getId());
			statsQuestionUsedDto.setMailDesignerMcq(questionUsed.getMcq().getDesigner().getUser().getEmail());
			statsQuestionUsedDto.setBodyMCQ(questionUsed.getMcq().getBody());
			statsQuestionUsedDto.setTopicMCQ(questionUsed.getMcq().getTopic());	
			
			statsQdto.getQuestionUsedDtos().add(statsQuestionUsedDto);
			
			mapStatsQuestionDto.replace(questionUsed.getQuestion().getId(), statsQdto);   
				
		}
		

		List<StatsQuestionDto> statsQuestionDtos = new ArrayList<StatsQuestionDto>();
		for (Question question : questions) {
			statsQuestionDtos.add(mapStatsQuestionDto.get(question.getId()));
		}
		
		//trier statsMCQdtos, du QCM le plus recemment jouer au plus ancien
		Collections.sort(statsQuestionDtos, new Comparator<StatsQuestionDto>() {
		    @Override
		    public int compare(StatsQuestionDto Q1, StatsQuestionDto Q2) {
		    	return (Integer.compare(Q1.getId(), Q2.getId()));
		    }
		});
		// a present le premier est le plus vieux, je vais donc inverser
		//Collections.reverse(statsQuestionDtos);
		
		
		
		return statsQuestionDtos;
		
	}
	




}
