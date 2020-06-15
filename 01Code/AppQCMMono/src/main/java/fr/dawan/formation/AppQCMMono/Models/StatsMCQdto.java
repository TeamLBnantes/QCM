package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// je ne prends en compe que les jeux fait depuis webApp
// si aucune question validée, alors je ne prends pas en compte non plus
// (d'ailleur il faudra penser à sup ces fiche (attention qd mêm à celle en cours de création)
// les fiche qui ne proviennent pas de webapp dans QCMpassed on un champs signatureAuthentification à null
// pas de question passée, alors nbQuestionRep=0

public class StatsMCQdto {

	private int id;          //correspond à l'id du QCM ciblé
	private String qcmBody;
	private String topic;
	private String pseudoDesigner;
	private int nbQuestionUsed;				//nb question dans ce qcm (au moment de l'appel)
	private int nbPlayeur;					//nb joueur
	private int nbPlayComplete;        		//nb joueur ayant terminé le QCM
	private double tauxDeParcourQuestion;   //% moyen du nombre de question parcourus (/nb question)
	private double tauxDeReussite;			//% de reussite (q bien rep sur nb q totale
	private LocalDateTime dateLast;			//date utilisation la plus recente de ce qcm
	private List<MCQpassed> mcqsPassed;
	private List<QuestionUsed> questionsUsed;
	
	
	public StatsMCQdto() {
		super();
		this.nbQuestionUsed=0;
		this.nbPlayeur=0;
		this.nbPlayComplete=0;
		this.tauxDeParcourQuestion=0;
		this.tauxDeReussite=0;
		LocalDate date=LocalDate.of(2000, 1, 1);
		this.dateLast=date.atTime(0, 0);
		// TODO Auto-generated constructor stub
	}


	
	

	@Override
	public String toString() {
		return "StatsMCQdto [id=" + id + ", qcmBody=" + qcmBody + ", topic=" + topic + ", pseudoDesigner="
				+ pseudoDesigner + ", nbQuestionUsed=" + nbQuestionUsed + ", nbPlayeur=" + nbPlayeur
				+ ", nbPlayComplete=" + nbPlayComplete + ", tauxDeParcourQuestion=" + tauxDeParcourQuestion
				+ ", tauxDeReussite=" + tauxDeReussite + ", dateLast=" + dateLast + ", mcqsPassed=" + mcqsPassed
				+ ", questionsUsed=" + questionsUsed + "]";
	}





	public List<MCQpassed> getMcqsPassed() {
		return mcqsPassed;
	}



	public void setMcqsPassed(List<MCQpassed> mcqsPassed) {
		this.mcqsPassed = mcqsPassed;
	}



	public List<QuestionUsed> getQuestionsUsed() {
		return questionsUsed;
	}



	public void setQuestionsUsed(List<QuestionUsed> questionsUsed) {
		this.questionsUsed = questionsUsed;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQcmBody() {
		return qcmBody;
	}

	public void setQcmBody(String qcmBody) {
		this.qcmBody = qcmBody;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getPseudoDesigner() {
		return pseudoDesigner;
	}

	public void setPseudoDesigner(String pseudoDesigner) {
		this.pseudoDesigner = pseudoDesigner;
	}

	public int getNbQuestionUsed() {
		return nbQuestionUsed;
	}

	public void setNbQuestionUsed(int nbQuestionUsed) {
		this.nbQuestionUsed = nbQuestionUsed;
	}

	public int getNbPlayeur() {
		return nbPlayeur;
	}

	public void setNbPlayeur(int nbPlayeur) {
		this.nbPlayeur = nbPlayeur;
	}

	public int getNbPlayComplete() {
		return nbPlayComplete;
	}

	public void setNbPlayComplete(int nbPlayComplete) {
		this.nbPlayComplete = nbPlayComplete;
	}

	public double getTauxDeParcourQuestion() {
		return tauxDeParcourQuestion;
	}

	public void setTauxDeParcourQuestion(double tauxDeParcourQuestion) {
		this.tauxDeParcourQuestion = tauxDeParcourQuestion;
	}

	public double getTauxDeReussite() {
		return tauxDeReussite;
	}

	public void setTauxDeReussite(double tauxDeReussite) {
		this.tauxDeReussite = tauxDeReussite;
	}

	public LocalDateTime getDateLast() {
		return dateLast;
	}

	public void setDateLast(LocalDateTime dateLast) {
		this.dateLast = dateLast;
	}
	
	
	
	
	
	
}
