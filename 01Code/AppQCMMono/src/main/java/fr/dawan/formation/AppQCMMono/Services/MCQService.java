package fr.dawan.formation.AppQCMMono.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.MCQpassed;
import fr.dawan.formation.AppQCMMono.Models.Multimedia;
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
		//GenericDAO<Multimedia> multimediaDao=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		Multimedia multimedia = mcq.getMultimedia();
		mcq=mcqDao.saveOrUpdate(mcq);
		//mcq.setMultimedia(multimediaDao.saveOrUpdate(mcq.getMultimedia()));
		//mcq.setMultimedia(multimedia);
		multimedia.setMcq(mcq);
		mcqDao.saveOrUpdate(mcq);
		mcqDao.close();
	}

	
	//choix fonctionnel, si demande de sup le qcm, on sup mêm si il y a encore des questions 
	//	attachées et/ou qu'il a dejà été passé
	//ce comportement poura être affiné par la suite
	public void deleteById(int id) {
		
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		
		MCQ mcq=searchById(id);
		//sup des questionsUsed qui sont potentiellement attachées à ce qcm
		
		List<QuestionUsed> listeQuestions=mcqDao.findQuestionUsedbyMcq(mcq);
		if (listeQuestions.size()!=0) {
			for (QuestionUsed questionUsed : listeQuestions) {
				deleteQuestion(id, questionUsed.getQuestion().getId());
			}
		}
		
		//idem pour les QCMPassed
		
		List<MCQpassed> mcqsList=mcqDao.findMCQpassedByMcq(mcq);
		if (mcqsList.size()!=0) {
			GenericDAO<MCQpassed> mcqPassedDao=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
			for (MCQpassed mcQpassed : mcqsList) {
				mcqPassedDao.deleteById(MCQpassed.class, mcQpassed.getId());
			}
			mcqPassedDao.close();
		}
		
		
		
		//plus de questions Used ni de QCM passed, je peux donc sup le qcm
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

	
		//id represente l'identifiant du mcq
	//cette methode, sup les questionsUsed attachées à ce MCQ
	// ce qui revient à sup la question de QCM
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
		List<MCQ> mcqsPlayable= new ArrayList<>();
		for (MCQ mcq : mcqs) {
			if ((mcq.getStatus()==Status.disponible) && (mcq.getQuestionUseds().size()!=0)){
				mcqsPlayable.add(mcq);
			}
		}
		mcqDao.close();
		return mcqsPlayable;
	}

	
	//lancement du passage du qcm choisi
	public ObjectPasserMcq initTrackMcq(MCQ mcq, User user) {
		MCQDAO mcqDao=new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		ObjectPasserMcq trackMcq=new ObjectPasserMcq();
		trackMcq.setListQuestionsUsed(mcqDao.findQuestionUsedbyMcq(mcq));
		mcqDao.close();
		trackMcq.setNbQuestionsTotal(trackMcq.getListQuestionsUsed().size());
		//mélange de la liste des question
		//if (mcq.getId()!=1) {    //je melange sauf si mcqID=1
		if (!(mcq.getBody().indexOf("[QOrdonnees]")>=0)){
		Collections.shuffle(trackMcq.getListQuestionsUsed());
		//fin du mélange
		}
		trackMcq.setNbQuestionsPassed(0);
		trackMcq.setNbBonnesReponses(0);
		// dans mono, je desactive le suivi des qcm passé
		// pour le moment, seul les qcm passé via webApp seront tracés
		//GenericDAO<MCQpassed> mcqPassedDao=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		//MCQpassed mcqPassed=new MCQpassed(user, mcq);
		//mcqPassed=mcqPassedDao.saveOrUpdate(mcqPassed);
		//mcqPassedDao.close();
		//trackMcq.setMcqPassed(mcqPassed);
		trackMcq.setEtape("beforeMCQ");
		
		return trackMcq;
	}

	public static List<MCQ> findMcqByIdQuestion(int id) {
		MCQDAO mcqDao=new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		
		QuestionService questionService=new QuestionService();
		Question question=questionService.findById(id);
		
		List<MCQ> listMcqs=mcqDao.findMcqByQuestion(question);
		mcqDao.close();

		return listMcqs;
	}

	public List<MCQ> findPlayable() {
		MCQDAO mcqDao=new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		
		List<MCQ> mcqs= mcqDao.findByStatus(Status.disponible);
		List<MCQ> mcqsPlayable= new ArrayList<MCQ>();
//		QuestionDAO questionDAO=new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		int nbQ=0;
		for (MCQ mcq : mcqs) {
//			nbQ=questionDAO.searchByMcq(mcq).size();
			nbQ=mcq.getQuestionUseds().size();
			if( nbQ!=0) {
				mcqsPlayable.add(mcq);
			}
			
		}
		mcqDao.close();
//		questionDAO.close();
		return mcqsPlayable;
	}


	


}
