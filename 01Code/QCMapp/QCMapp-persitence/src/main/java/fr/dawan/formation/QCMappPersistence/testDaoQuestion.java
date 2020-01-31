package fr.dawan.formation.QCMappPersistence;


import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import fr.dawan.formation.QCMappModel.Question;
import fr.dawan.formation.QCMappModelEnum.Status;
import fr.dawan.formation.QCMappPersistenceDAO.DAOQuestion;


public class testDaoQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAOQuestion daoQuestion = new DAOQuestion();
		Date date1 = new Date ();
		System.out.println(date1);
		Date date2 = new Date ();
		Status statusTest = Status.free ;
		
		// test methode create
		Question rep1=new Question(0,"ihegmesf", date1, date2, "1", statusTest, "fhemsf", "efjff",1,1,1);
		daoQuestion.create(rep1);
		daoQuestion.delete(3);
		
		//test methode searchById
		rep1=daoQuestion.searchById(1);
		System.out.println(rep1);
		
		//test update de la question d'id 5
		rep1=new Question(0,"ihegmesfuhefqjk:jkf", date1, date2, "1", statusTest, "fhemsffses", "efjfffqq",1,2,1);
		daoQuestion.update(rep1);
		
		//test searchByIdQuestion. Rcherche des reponses dont la question est d'ID 1177
		ArrayList<Question> tabQuestion=new ArrayList<Question>();
		tabQuestion=daoQuestion.searchByDesigner(1177);
		System.out.println("rep trouvées : ");
		for (Question question : tabQuestion) {
			System.out.println(question);
		
	}}

}
