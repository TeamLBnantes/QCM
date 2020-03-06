package fr.dawan.formation.AppQCMMono;

import java.util.HashSet;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.GenericDAO;

public class creation_question_answer_manuelle {

	public static void main(String[] args) {
//enregistrement de 3 reponses et de 2 questions associées
		
		

		Set<Question> questions=new HashSet<>();

		Set<Answer> answers=new HashSet<>();
		

		GenericDAO<Designer> daoDesigner = new  GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		Designer designer=daoDesigner.findById(Designer.class, 1);
		daoDesigner.close();
		
		//ajout question 1
		Question question1=new Question();
		question1.setBody("question 1");
		question1.setAnswers(null);
		question1.setDesigner(designer);
		questions.add(question1);
		
		//ajout question 2
		Question question2=new Question();
		question2.setBody("question 2");
		question2.setAnswers(null);
		question2.setDesigner(designer);
		questions.add(question2);
		
		
		
		// ajout answer 1
		Answer answer1=new Answer();
		answer1.setBody("body de la premiere repone. Je vais la lier à la question 1, elle sera bonne");
		answer1.setCommentPostAnswer("commentaire après reponse de rep1");
		answer1.setExpectedAnswer(true);
		answers.add(answer1);
		// ajout answer 2
		Answer answer2=new Answer();
		answer2.setBody("body de la seconde reponse. Je vais la lier à la question 1, elle sera fausse");
		answer2.setCommentPostAnswer("commentaire après reponse de rep2");
		answer2.setExpectedAnswer(false);
		answers.add(answer2);
		// ajout answer 3
		Answer answer3=new Answer();
		answer3.setBody("body de la troisieme reponse. Je vais la lier à la question 2, elle sera fausse");
		answer3.setCommentPostAnswer("commentaire après reponse de rep3");
		answer3.setExpectedAnswer(true);
		answers.add(answer3);
		
		
		Set<Answer> tmp=new HashSet<>();
		tmp.add(answer1);
		tmp.add(answer2);
		question1.setAnswers(tmp);
		
		Set<Answer> tmp2=new HashSet<>();
		tmp2.add(answer3);
		question2.setAnswers(tmp2);
		
		
		/*
l'ecriture dans la table Question, provoque l'ecriture de la table réponse, car le lien dans reponse et @ en cascade
par ailleurs, l'id de la question est recup au moment de la premiere ecriture suite à la création, il est ensuite utilisé
pour le lien de la table answer, via le mappage de l'abjet question. On met une question dans l'objet java, et c'est l'id de la question qui 
est enregistré dans la table answer
		 */
		
		GenericDAO<Question> daoQuestion = new  GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
		
		
		
		//dao.saveOrUpdate(formations.values());
		for (Question question : questions) {
			daoQuestion.saveOrUpdate(question);
			System.out.println(question);
			
			for (Answer answer : question.getAnswers()) {
				answer.setQuestion(question);
			}
			
		daoQuestion.saveOrUpdate(question1);	//ceci pour enregister la derniere info dans la table Answer
			
			
		}
		
		

		daoQuestion.close();	
	//	daoAnswer.close();
		
		
		
		
		
		

		
		
	}

}
