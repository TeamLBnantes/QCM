package fr.dawan.formation.AppQCMMono.Models;

import java.util.List;
import java.util.Set;

//Cette object servira à stocker dans la session le qcm que l'utilisateur est en train de passer
// au début du qcm, il sera init dans la session
//à la fin, il sera détruit de la session.
public class ObjectPasserMcq {

	private List<QuestionUsed> listQuestionsUsed;
	private int nbQuestionsTotal;
	private int nbQuestionsPassed;
	private int nbBonnesReponses;
	private MCQpassed mcqPassed;
	private String etape;  // à valeur dans {beforeMCQ, question, correction, endMCQ}
							//TODO: faire une ennum pour cet attribut.
	
	

	

	
	public List<QuestionUsed> getListQuestionsUsed() {
		return listQuestionsUsed;
	}
	public void setListQuestionsUsed(List<QuestionUsed> listQuestionsUsed) {
		this.listQuestionsUsed = listQuestionsUsed;
	}
	public int getNbQuestionsPassed() {
		return nbQuestionsPassed;
	}
	public void setNbQuestionsPassed(int nbQuestionsPassed) {
		this.nbQuestionsPassed = nbQuestionsPassed;
	}
	public int getNbBonnesReponses() {
		return nbBonnesReponses;
	}
	public void setNbBonnesReponses(int nbBonnesReponses) {
		this.nbBonnesReponses = nbBonnesReponses;
	}
	public MCQpassed getMcqPassed() {
		return mcqPassed;
	}
	public void setMcqPassed(MCQpassed mcqPassed) {
		this.mcqPassed = mcqPassed;
	}
	public int getNbQuestionsTotal() {
		return nbQuestionsTotal;
	}
	public void setNbQuestionsTotal(int nbQuestionsTotal) {
		this.nbQuestionsTotal = nbQuestionsTotal;
	}
	public String getEtape() {
		return etape;
	}
	public void setEtape(String etape) {
		this.etape = etape;
	}
	@Override
	public String toString() {
		return "ObjectPasserMcq [listQuestionsUsed=" + listQuestionsUsed + ", nbQuestionsTotal=" + nbQuestionsTotal
				+ ", nbQuestionsPassed=" + nbQuestionsPassed + ", nbBonnesReponses=" + nbBonnesReponses + ", mcqPassed="
				+ mcqPassed + ", etape=" + etape + "]";
	}

	
	
	
}
