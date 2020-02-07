package fr.dawan.formation.QCMappPersistence;


import java.util.ArrayList;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.QCMappPersistenceDAO.NonJPADAOAnswer;


public class NonJPAtestDaoAnswer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonJPADAOAnswer daoAnswer = new NonJPADAOAnswer();
		
		
		// test methode create

		Answer rep1=new Answer(0,"tesxte du body de la reponse de vendredi matin", true, "commentaire post rep", 1);

		daoAnswer.create(rep1);
		daoAnswer.delete(3);
		
		//test methode searchById
		rep1=daoAnswer.searchById(1);
		System.out.println(rep1);
		
		//test update de la question d'id 5
		rep1=new Answer(5,"tesxte MAJ de la 5", true, "commentaire post rep", 1);
		daoAnswer.update(rep1);
		
		//test searchByIdQuestion. Rcherche des reponses dont la question est d'ID 1177
		ArrayList<Answer> tabAnswers=new ArrayList<Answer>();
		tabAnswers=daoAnswer.searchByIdQuestion(1177);
		System.out.println("rep trouvées : ");
		for (Answer answer : tabAnswers) {
			System.out.println(answer);
		}
	}

}
