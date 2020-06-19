package fr.dawan.formation.AppQCMMono.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.catalina.manager.StatusTransformer;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.MCQpassed;
import fr.dawan.formation.AppQCMMono.Models.Multimedia;
import fr.dawan.formation.AppQCMMono.Models.ObjectFiltresMCQ;
import fr.dawan.formation.AppQCMMono.Models.ObjectPasserMcq;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.QuestionUsed;
import fr.dawan.formation.AppQCMMono.Models.StatsMCQdto;
import fr.dawan.formation.AppQCMMono.Models.StatsQuestionDto;
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
		//attention, la ref du qcm est stockee dans mcqPassed dans trackMCQ
		//donc ne pas le sup ou prevoir un autre stockage
		GenericDAO<MCQpassed> mcqPassedDao=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		MCQpassed mcqPassed=new MCQpassed(user, mcq);
		mcqPassed.setMailDeclaratifWebApp("AppGestionQuizIzSkillz");
		mcqPassed=mcqPassedDao.saveOrUpdate(mcqPassed);
		mcqPassedDao.close();
		trackMcq.setMcqPassed(mcqPassed);
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

	// je ne prends en compe que les jeux fait depuis webApp
	// si aucune question validée, alors je ne prends pas en compte non plus
	// (d'ailleur il faudra penser à sup ces fiche (attention qd mêm à celle en cours de création)
	// les fiche qui ne proviennent pas de webapp dans QCMpassed on un champs signatureAuthentification à null
	// pas de question passée, alors nbQuestionRep=0
	
	// attention, pas du tout optimisée, non utilisée pour le moment
	// à revoir avant eventuelle mise en service
	public StatsMCQdto StatsMcq_aVerifier(MCQ mcq) {
		

		StatsMCQdto statsMCQdto=new StatsMCQdto();
		statsMCQdto.setId(mcq.getId());
		statsMCQdto.setQcmBody(mcq.getBody());
		statsMCQdto.setTopic(mcq.getTopic());
		statsMCQdto.setPseudoDesigner(mcq.getDesigner().getUser().getPseudo());
		
		MCQDAO mcqDao=new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		//statsMCQdto.setNbQuestionUsed(mcq.getQuestionUseds().size());
		statsMCQdto.setNbQuestionUsed(mcqDao.findQuestionUsedbyMcq(mcq).size());
		List<MCQpassed> mcqsPassed=mcqDao.findMCQpassedForResultByMcq(mcq);
		statsMCQdto.setQuestionsUsed(mcqDao.findQuestionUsedbyMcq(mcq)); //j'integre la liste des questionUsed de ce QCM dans l'objet stats
		mcqDao.close();
		Collections.reverse(mcqsPassed);   //pour afficher de plus recent au plus ancien
		statsMCQdto.setMcqsPassed(mcqsPassed); //j'integre la liste des mcqPassed dans l'objet statsMCQdto
		statsMCQdto.setNbPlayeur(mcqsPassed.size());
		for (MCQpassed mcqPassed : mcqsPassed) {
			if (mcqPassed.isFinalise()) statsMCQdto.setNbPlayComplete(statsMCQdto.getNbPlayComplete()+1);
			//pour chaque fiche, je prends le taux de question rep, que je divise par le nbre de fiche total, et que j'ajoute au taux en cours de calcul
			//de ce fait, à la fin du parcours, j'ai bien la moyenne des taux de parcours
			statsMCQdto.setTauxDeParcourQuestion(statsMCQdto.getTauxDeParcourQuestion()+(((double)mcqPassed.getNbQuestionRep()/mcqPassed.getNbQuestionTotal())/mcqsPassed.size()));
			//idem pour le taux de reussite
			statsMCQdto.setTauxDeReussite(statsMCQdto.getTauxDeReussite()+(((double)mcqPassed.getResult()/mcqPassed.getNbQuestionTotal())/mcqsPassed.size()));
			//reste à trouver la date la plus récente
			if (statsMCQdto.getDateLast()==null) {
				statsMCQdto.setDateLast(mcqPassed.getDate());
			}else {
				if (mcqPassed.getDate().isAfter(statsMCQdto.getDateLast())) {
					statsMCQdto.setDateLast(mcqPassed.getDate());
				}
			}
		
		}
		
		return statsMCQdto;
	}

	
	public List<StatsMCQdto>  StatsMcqs_Old(int idUser) {
		Set<MCQ> mcqs=new HashSet<MCQ>();
		if (idUser==0) {//pour les admin, je vais renvoyer tous les stats (donc de tous les qcm)
			 mcqs=this.findAll();
		}else {  //et donc sinon, je retourne les qcm de l'utilisateur(designer) connecté
			UserService userService=new UserService();
			
			mcqs=new HashSet<MCQ>(this.searchByDesigner(userService.findById(idUser).getDesigner()));
		}
		
		List<StatsMCQdto> statsMCQdtos = new ArrayList<StatsMCQdto>();
		for (MCQ mcq : mcqs) {
			statsMCQdtos.add(this.StatsMcq_aVerifier(mcq));
		}
		
		//trier statsMCQdtos, du QCM le plus recemment jouer au plus ancien
		Collections.sort(statsMCQdtos, new Comparator<StatsMCQdto>() {
		    @Override
		    public int compare(StatsMCQdto MCQdto1, StatsMCQdto MCQdto2) {
		    	return (MCQdto1.getDateLast().compareTo(MCQdto2.getDateLast()));
		    }
		});
		// a present le premier est le plus vieux, je vais donc inverser
		Collections.reverse(statsMCQdtos);
		
		return statsMCQdtos;
		
	}
	
	public List<StatsMCQdto>  StatsMcqs(int idUser) {
		Set<MCQ> mcqs=new HashSet<MCQ>();
		if (idUser==0) {//pour les admin, je vais renvoyer tous les stats (donc de tous les qcm)
			 mcqs=this.findAll();
		}else {  //et donc sinon, je retourne les qcm de l'utilisateur(designer) connecté
			UserService userService=new UserService();
			
			mcqs=new HashSet<MCQ>(this.searchByDesigner(userService.findById(idUser).getDesigner()));
		}
		
		Map<Integer, StatsMCQdto> mapStatsMCQDto = new HashMap<>();
		//on parcour les QCM, et on remplis le map	
		for (MCQ mcq : mcqs) {
			StatsMCQdto statsMCQdto=new StatsMCQdto();
			statsMCQdto.setId(mcq.getId());
			statsMCQdto.setQcmBody(mcq.getBody());
			statsMCQdto.setTopic(mcq.getTopic());
			statsMCQdto.setPseudoDesigner(mcq.getDesigner().getUser().getPseudo());
			//j'initialise les listes
			List<MCQpassed> mcqsPassed=new ArrayList<>();
			statsMCQdto.setMcqsPassed(mcqsPassed);
			List<QuestionUsed> questionsUsed=new ArrayList<>();
			statsMCQdto.setQuestionsUsed(questionsUsed);
			//et je stocke dans le map
			mapStatsMCQDto.put(mcq.getId(), statsMCQdto);
		}
		//ensuite on parcours QCM passed et on remplis le map statsQuestionDto

		//je vais tout prendre et je filtrerais si je suis pas en mode admin, regarder tout
//		GenericDAO<MCQpassed> mcqPassedDAO=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
//		List<MCQpassed> mcqsPassed=new ArrayList<MCQpassed>();
//		mcqsPassed.addAll(mcqPassedDAO.findAll(MCQpassed.class)); //je recupère un set que je transforme en liste
//		mcqPassedDAO.close();
		MCQDAO mcqDao=new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<MCQpassed> mcqsPassed=new ArrayList<MCQpassed>();
		//on ne va prendre que les MCQPassed qui viennent de WebApp et avec au moins une rep
		 mcqsPassed=mcqDao.findAllMCQpassedWithResult();
		 mcqDao.close();
		
		
		
		if (idUser==0) { //mode admin, on prend tout
			
		} else { //on ne va prendre que la mcq de la liste de l'utilisateur
			List<MCQpassed> aSup=new ArrayList<>();
			for (MCQpassed mcqPassed : mcqsPassed) {
				if (mcqPassed.getMcq().getDesigner().getUser().getId()!=idUser) {
					//ne pointe pas vers un QCM de cet utilisateur, donc je sup
					aSup.add(mcqPassed);
					//je les met dans une liste et ensuite je les enleve
				}	
			}
			//je les enleve ici
			for (MCQpassed mcqPassed : aSup) {
				mcqsPassed.remove(mcqPassed);
			}
			
			
		} //la liste restante est donc à jour 
		//trier mcqsPassed, du  plus recemment jouer au plus ancien
		Collections.sort(mcqsPassed, new Comparator<MCQpassed>() {
		    @Override
		    public int compare(MCQpassed MCQ1, MCQpassed MCQ2) {
		    	return (MCQ1.getDate().compareTo(MCQ2.getDate()));
		    }
		});
		Collections.reverse(mcqsPassed);
		
		
		
		
		
		//on va donc la parcourir et stocker les infos nécéssaire
		for (MCQpassed mcqPassed : mcqsPassed) {
			StatsMCQdto statsMCQtmp=mapStatsMCQDto.get(mcqPassed.getMcq().getId());
			
			statsMCQtmp.setNbPlayeur(statsMCQtmp.getNbPlayeur()+1);
			if (mcqPassed.isFinalise()) statsMCQtmp.setNbPlayComplete(statsMCQtmp.getNbPlayComplete()+1);
			//les taux seront a diviser à la fin par le nombre de questionUsed par qcm
			statsMCQtmp.setTauxDeParcourQuestion(statsMCQtmp.getTauxDeParcourQuestion()+
					(((double)mcqPassed.getNbQuestionRep()/mcqPassed.getNbQuestionTotal())));
			statsMCQtmp.setTauxDeReussite(statsMCQtmp.getTauxDeReussite()+
					(((double)mcqPassed.getResult()/mcqPassed.getNbQuestionTotal())));
			if (statsMCQtmp.getDateLast()==null) {
				statsMCQtmp.setDateLast(mcqPassed.getDate());
			}else {
				if (mcqPassed.getDate().isAfter(statsMCQtmp.getDateLast())) {
					statsMCQtmp.setDateLast(mcqPassed.getDate());
				}
			}
			statsMCQtmp.getMcqsPassed().add(mcqPassed);
			mapStatsMCQDto.replace(mcqPassed.getMcq().getId(), statsMCQtmp);
			//il ne faudra pas oublier de reparcourir le StatsMCQDTo pour diviser les taux comme il se doit	
			//je le fait à la fin car de toute façon uil faudra les reparcourir pour compter les questionUsed
			
		}
		
		//même punition à présent pour les Questions used
		//je vais tout prendre et je filtrerais si je suis pas en mode admin, regarder tout
		GenericDAO<QuestionUsed> questionUsedDAO=new GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		List<QuestionUsed> questionsUsed=new ArrayList<QuestionUsed>();
		questionsUsed.addAll(questionUsedDAO.findAll(QuestionUsed.class)); //je recupère un set que je transforme en liste
		questionUsedDAO.close();
		
		if (idUser==0) { //mode admin, on prend tout
			
		} else { //on ne va prendre que les QuestionsUsed des mcq de la liste de l'utilisateur
			List<QuestionUsed> aSup2=new ArrayList<>();    //liste tmp des qUsed à sup
			// besoin car peu pas sup un elet de la liste que je suis entrain de parcourir
			for (QuestionUsed questionUsed : questionsUsed) {
				if (questionUsed.getMcq().getDesigner().getUser().getId()!=idUser) {
					//ne pointe pas vers un QCM de cet utilisateur, donc je sup
					aSup2.add(questionUsed);
				}
			}
			// et donc maintenant je parcours la liste des elts à sup et je les supprime dans la liste des 
			// qUsed à traiter
			for (QuestionUsed questionUsed : aSup2) {
				questionsUsed.remove(questionUsed);
			}
			
			
		} //la liste restante est donc à jour 
		// reste plus qu'a trier

	Collections.sort(questionsUsed, new Comparator<QuestionUsed>() {
	    @Override
	    public int compare(QuestionUsed Q1, QuestionUsed Q2) {
	    	return (Integer.compare(Q1.getQuestion().getId(),Q2.getQuestion().getId()));
	    }
	});

		
		
		
		
		//on va donc la parcourir et stocker les infos nécéssaire
		for (QuestionUsed questionUsed : questionsUsed) {
			StatsMCQdto statsMCQtmp=mapStatsMCQDto.get(questionUsed.getMcq().getId());
			statsMCQtmp.setNbQuestionUsed(statsMCQtmp.getNbQuestionUsed()+1);
			statsMCQtmp.getQuestionsUsed().add(questionUsed);
			mapStatsMCQDto.replace(questionUsed.getMcq().getId(), statsMCQtmp);
			
		}
		
		List<StatsMCQdto> statsMCQdtos = new ArrayList<StatsMCQdto>();
		// on remet le map dans la liste
		for (MCQ mcq : mcqs) {
			statsMCQdtos.add(mapStatsMCQDto.get(mcq.getId()));
		}

		// je met à jour les variable, maintenant que tos les elements sont presents
		for (StatsMCQdto statsMCQdto : statsMCQdtos) {
			//je verifie qu'il y a des reponses	avant de diviser par 0. et si pas de reponses, je met à blanc
			int nbMCQPassed=statsMCQdto.getMcqsPassed().size();
			if (nbMCQPassed>0) {
				statsMCQdto.setTauxDeParcourQuestion(statsMCQdto.getTauxDeParcourQuestion()/nbMCQPassed);
				statsMCQdto.setTauxDeReussite(statsMCQdto.getTauxDeReussite()/nbMCQPassed);
			}
		}
		
		
		
		
		//trier statsMCQdtos, du QCM le plus recemment jouer au plus ancien
		Collections.sort(statsMCQdtos, new Comparator<StatsMCQdto>() {
		    @Override
		    public int compare(StatsMCQdto MCQdto1, StatsMCQdto MCQdto2) {
		    	return (MCQdto1.getDateLast().compareTo(MCQdto2.getDateLast()));
		    }
		});
		// a present le premier est le plus vieux, je vais donc inverser
		Collections.reverse(statsMCQdtos);
		
		return statsMCQdtos;
		
	}
	
	
	
}
