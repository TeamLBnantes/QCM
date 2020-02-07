package fr.dawan.formation.QCMappPersistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

import fr.dawan.formation.QCMappModel.Answer;
import fr.dawan.formation.QCMappPersistence.SingletonConnection;
import fr.dawan.formation.QCMappPersistenceInterfaces.DAOAnswerInterface;
import sun.reflect.generics.tree.ReturnType;

public class DAOAnswer implements DAOAnswerInterface{

	@Override
	public void create(Answer answer) {
		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "INSERT INTO answer(body, expectedAnswer, commentPostAnswer, idQuestion) VALUES(?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, answer.getBody());
			ps.setBoolean(2, answer.isExpectedAnswer());
			ps.setString(3, answer.getCommentPostAnswer());
			ps.setInt(4, answer.getIdQuestion());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Answer answer) {

		// update de la reponse, pointage depuis answer.id
		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "UPDATE answer SET body=?,expectedAnswer=?, commentPostAnswer=?, idQuestion=? WHERE id=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, answer.getBody());
			ps.setBoolean(2, answer.isExpectedAnswer());
			ps.setString(3, answer.getCommentPostAnswer());
			ps.setInt(4, answer.getIdQuestion());
			ps.setInt(5, answer.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void delete(int idAnswer) {

		Connection cn = SingletonConnection.getConnection();
		Answer retourAnswer=null;
		try {
			retourAnswer=searchById(idAnswer);
			if (retourAnswer!=null) {
				String sql = "DELETE FROM answer  WHERE id=?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setInt(1, idAnswer);
				ps.executeUpdate();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override

	public Answer searchById(int idAnswer) {
		// recherche d'une reponse par son id
		Connection cn = SingletonConnection.getConnection();
		Answer retourAnswer=null;
		try {
			String sql = "SELECT * FROM answer WHERE id = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idAnswer);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				retourAnswer = new Answer(rs.getInt("id"), rs.getString("body"), 
						rs.getBoolean("expectedAnswer"), rs.getString("commentPostAnswer"), rs.getInt("idQuestion"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retourAnswer;

	}

	@Override
	public ArrayList<Answer> searchByIdQuestion(int idQuestion) {

		ArrayList<Answer> answers = new ArrayList<Answer>();
		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "SELECT * FROM answer WHERE idQuestion = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idQuestion);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				answers.add(new Answer(rs.getInt("id"), rs.getString("body"), 
						rs.getBoolean("expectedAnswer"), rs.getString("commentPostAnswer"), rs.getInt("idQuestion")));
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return answers;

	}

}
