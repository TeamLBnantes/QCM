package fr.dawan.formation.QCMappPersistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import fr.dawan.formation.QCMappModel.Answer;
import fr.dawan.formation.QCMappPersistence.SingletonConnection;
import fr.dawan.formation.QCMappPersistenceInterfaces.DAOAnswerInterface;

public class DAOAnswer implements DAOAnswerInterface{

	Answer a = new Answer();
	
	@Override
	public void create(Answer answer) {
		Connection cn = SingletonConnection.getConnection();
		
		try {
			String sql = "INSERT INTO answer (id, body, expectedAnswer, commentPostAnswer, idQuestion) VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = cn.prepareStatement(sql);
			
			ps.setInt(1,a.getId());
			ps.setString(2, a.getBody());
			ps.setBoolean(3, a.isExpectedAnswer());
			ps.setString(4, a.getCommentPostAnswer());
			ps.setInt(5, a.getIdQuestion());
			
			
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(Answer answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idAnswer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Answer> searchById(int idAnswer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Answer> searchByIdQuestion(int idQuestion) {
		// TODO Auto-generated method stub
		return null;
	}

}
