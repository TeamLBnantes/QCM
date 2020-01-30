package DataFilling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import fr.dawan.formation.QCMappModel.Answer;
import fr.dawan.formation.QCMappPersistence.SingletonConnection;
import fr.dawan.formation.QCMappPersistenceDAO.DAOAnswer;

public class answerDataFiller {

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
		
		int[] id = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
		String[] body = {"marron", "blanc", "noir", "rouge", "bais", "paille", "1900", "1909","1911","1914","1915","1918","0", "2", "4", "8", "10", "100"};   
		boolean[] expectedAnswer = {false, true, false,false,false,false,false,false,false,true,false,false,false,false,false,true,false,false};
		String[] commentPostAnswer= {
				"bah non",
				"eh oui, suffit de bien lire!",
				"bah non",
				"sérieusement?",
				"c'est bien une couleur de cheval, mais non",
				"non",
				"pas la bonne date!",
				"pas la bonne date!",
				"pas la bonne date!",
				"c'est bien ca!",
				"pas la bonne date!",
				"pas la bonne date!",
				"Je sais pas encore la question",
				"Je sais pas encore la question",
				"Je sais pas encore la question",
				"Je sais pas encore la question",
				"Je sais pas encore la question",
				"Je sais pas encore la question",};
		int [] idQuestion = {1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3};
		
		
		
		for (int i = 0; i < id.length; i++) {
			Answer a = new Answer();
					a.setId(id[i]);
					a.setBody(body[i]);
					a.setExpectedAnswer(expectedAnswer[i]);
					a.setCommentPostAnswer(commentPostAnswer[i]);
					a.setIdQuestion(idQuestion[i]);
			System.out.println(a.toString());
		daoAnswer.create(a);
		}
		
		
	}

}
