package fr.dawan.formation.AppQCMMono;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Persistence.AnswerDAO;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.GenericDAO;

public class affiches_question {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericDAO<Question> daoQuestion = new  GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		
		System.out.println("Liste des questions de la table : ");
		Set<Question> questions=new HashSet<>();
		questions=daoQuestion.findAll(Question.class);
		
		AnswerDAO answerDAO = new AnswerDAO(Constantes.PERSISTENCE_UNIT_NAME);

				
				
				
		for (Question question : questions) {
			List<Answer> answers = answerDAO.searchByIdQuestion(question);
			Set<Answer> set = new HashSet<>(answers);
			question.setAnswers(set);
			System.out.println(question);
			System.out.println("nb rep de cette question : "+question.getAnswers().size());
			for (Answer answer : question.getAnswers()) {
				System.out.println("      "+answer);
			}
			
		}
		
		System.out.println("affichage uniquement de la question 7");
		Question question;
		question=daoQuestion.findById(Question.class, 7);
		List<Answer> answers = answerDAO.searchByIdQuestion(question);
		Set<Answer> set = new HashSet<>(answers);
		question.setAnswers(set);
			System.out.println(question);
			System.out.println("nb rep de cette question : "+question.getAnswers().size());
			for (Answer answer : question.getAnswers()) {
				System.out.println("      "+answer);
			}	
			
		daoQuestion.close();
		answerDAO.close();
	}

}
