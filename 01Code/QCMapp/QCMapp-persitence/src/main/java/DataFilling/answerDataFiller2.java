package DataFilling;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import fr.dawan.formation.QCMappModel.Answer;
import fr.dawan.formation.QCMappPersistence.SingletonConnection;
import fr.dawan.formation.QCMappPersistenceDAO.DAOAnswer;

public class answerDataFiller2 {

	public static void main(String[] args) {
		
		

		Connection cn = SingletonConnection.getConnection();
		
		try {
			String sql = "TRUNCATE TABLE answer";
			
			PreparedStatement ps = cn.prepareStatement(sql);
			
			ps.executeUpdate();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		DAOAnswer daoAnswer= new DAOAnswer();
		Answer aDAO = new Answer();
		
		ArrayList<Answer> a = new ArrayList<Answer>();
		a.add(new Answer (1,"bleu",true, "comment1",1));
		a.add(new Answer (2,"blanc",true, "comment1",1));
		a.add(new Answer (3,"bleu",true, "comment1",1));
		a.add(new Answer (4,"bleu",true, "comment1",1));
		a.add(new Answer (5,"bleu",true, "comment1",1));
		a.add(new Answer (6,"bleu",true, "comment1",1));
		a.add(new Answer (7,"bleu",true, "comment1",1));
		a.add(new Answer (8,"bleu",true, "comment1",1));
		a.add(new Answer (9,"bleu",true, "comment1",1));
		a.add(new Answer (10,"bleu",true, "comment1",1));
		a.add(new Answer (11,"bleu",true, "comment1",1));
		a.add(new Answer (12,"bleu",true, "comment1",1));
		a.add(new Answer (13,"bleu",true, "comment1",1));
		a.add(new Answer (14,"bleu",true, "comment1",1));
		a.add(new Answer (15,"bleu",true, "comment1",1));
		a.add(new Answer (16,"bleu",true, "comment1",1));
		a.add(new Answer (17,"bleu",true, "comment1",1));
		a.add(new Answer (18,"bleu",true, "comment1",1));
		
		for (int i = 0; i < 18; i++) {
			
			aDAO = a.get(i);
			System.out.println(aDAO.toString());
			daoAnswer.create(aDAO);
	}

}}
