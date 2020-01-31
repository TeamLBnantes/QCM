package fr.dawan.formation.QCMappPersistenceDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fr.dawan.formation.QCMappModel.Question;
import fr.dawan.formation.QCMappModelEnum.Status;
import fr.dawan.formation.QCMappPersistence.SingletonConnection;
import fr.dawan.formation.QCMappPersistenceInterfaces.DAOQuestionInterface;

public class DAOQuestion implements DAOQuestionInterface{

	@Override
	public void create(Question question) {
		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "INSERT INTO question (body, createDate, editDate, idTheme, status, commentPostAnswer, help, idMultimedia, idForum, idDesigner) VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, question.getBody());
			ps.setDouble(2, (question.getCreateDate()).getTime());
			ps.setDouble(3, (question.getEditDate()).getTime());
			ps.setString(4, (question.getTheme()));
			ps.setString(5, String.valueOf(question.getStatus()));
			ps.setString(6, question.getCommentPostAnswer());
			ps.setString(7, question.getHelp());
			ps.setInt(8, question.getIdMultimedia());
			ps.setInt(9, question.getIdForum());
			ps.setInt(10, question.getIdDesigner());
			
			
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Question question) {

		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "UPDATE question SET body=?, createDate=?, editDate=?, idTheme=?, status=?, commentPostAnswer=?, help=?, idMultimedia=?, idForum=?, idDesigner=? WHERE id=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, question.getBody());
			ps.setDouble(2, (question.getCreateDate()).getTime());
			ps.setDouble(3, (question.getEditDate()).getTime());
			ps.setString(4, (question.getTheme()));
			ps.setString(5, String.valueOf(question.getStatus()));
			ps.setString(6, question.getCommentPostAnswer());
			ps.setString(7, question.getHelp());
			ps.setInt(8, question.getIdMultimedia());
			ps.setInt(9, question.getIdForum());
			ps.setInt(10, question.getIdDesigner());
			ps.setInt(11, question.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void delete(int idQuestion) {

		Connection cn = SingletonConnection.getConnection();
		Question retourQuestion=null;
		try {
			retourQuestion=searchById(idQuestion);
			if (retourQuestion!=null) {
				String sql = "DELETE FROM question  WHERE id=?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setInt(1, idQuestion);
				ps.executeUpdate();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public Question searchById(int idQuestion) {
		Connection cn = SingletonConnection.getConnection();
		Question retourQuestion=null;
		try {
			String sql = "SELECT * FROM question WHERE id = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idQuestion);
			
			ResultSet rs = ps.executeQuery();;
			while(rs.next()) {
				Date createDate = new Date((rs.getLong("createDate")));
				Date editDate = new Date((rs.getLong("editDate")));
				retourQuestion = new Question(rs.getInt("id"), rs.getString("body"), createDate, 
						editDate, rs.getString("theme"), Status.valueOf(rs.getString ("status")), 
						rs.getString("commentPostAnswer"), rs.getString("help"), rs.getInt("idMultimedia"), rs.getInt("idForum"), rs.getInt ("idDesigner"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retourQuestion;

	}

	@Override
	public ArrayList<Question> searchByTheme(String theme) {
		ArrayList<Question> questions = new ArrayList<Question>();
		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "SELECT * FROM question WHERE theme = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, theme);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Date createDate = new Date((rs.getLong("createDate")));
				Date editDate = new Date((rs.getLong("editDate")));
				questions.add(new Question(rs.getInt("id"), rs.getString("body"), createDate, 
						editDate, rs.getString("theme"), Status.valueOf(rs.getString ("status")), 
						rs.getString("commentPostAnswer"), rs.getString("help"), rs.getInt("idMultimedia"), rs.getInt("idForum"), rs.getInt ("idDesigner")));
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questions;
	}

	@Override
	public ArrayList<Question> searchByStatus(Status status) {
		ArrayList<Question> questions = new ArrayList<Question>();
		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "SELECT * FROM question WHERE status = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1,  String.valueOf(status));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Date createDate = new Date((rs.getLong("createDate")));
				Date editDate = new Date((rs.getLong("editDate")));
				questions.add(new Question(rs.getInt("id"), rs.getString("body"), createDate, 
						editDate, rs.getString("theme"), Status.valueOf(rs.getString ("status")), 
						rs.getString("commentPostAnswer"), rs.getString("help"), rs.getInt("idMultimedia"), rs.getInt("idForum"), rs.getInt ("idDesigner")));
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questions;
	}

	@Override
	public ArrayList<Question> searchByKWBody(String kw) {
		
		ArrayList<Question> questions = new ArrayList<Question>();
		Connection cn = SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM questions WHERE BODY LIKE ?");
			
			ps.setString(1, "%"+kw+"%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date createDate = new Date((rs.getLong("createDate")));
				Date editDate = new Date((rs.getLong("editDate")));
				questions.add(new Question(rs.getInt("id"), rs.getString("body"), createDate, 
						editDate, rs.getString("theme"), Status.valueOf(rs.getString ("status")), 
						rs.getString("commentPostAnswer"), rs.getString("help"), rs.getInt("idMultimedia"), rs.getInt("idForum"), rs.getInt ("idDesigner")));
			}
			
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questions;
		
	}

	@Override
	public ArrayList<Question> searchAll() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Connection cn = SingletonConnection.getConnection();
		
		try {
			
			String sql = "SELECT * FROM question";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date createDate = new Date((rs.getLong("createDate")));
				Date editDate = new Date((rs.getLong("editDate")));
				questions.add(new Question(rs.getInt("id"), rs.getString("body"), createDate, 
						editDate, rs.getString("theme"), Status.valueOf(rs.getString ("status")), 
						rs.getString("commentPostAnswer"), rs.getString("help"), rs.getInt("idMultimedia"), rs.getInt("idForum"), rs.getInt ("idDesigner")));
			}
			
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return questions;
	}

	@Override
	public ArrayList<Question> searchByDesigner(int idDesigner) {
		ArrayList<Question> questions = new ArrayList<Question>();
		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "SELECT * FROM question WHERE idDesigner = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idDesigner);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Date createDate = new Date((rs.getLong("createDate")));
				Date editDate = new Date((rs.getLong("editDate")));
				questions.add(new Question(rs.getInt("id"), rs.getString("body"), createDate, 
						editDate, rs.getString("theme"), Status.valueOf(rs.getString ("status")), 
						rs.getString("commentPostAnswer"), rs.getString("help"), rs.getInt("idMultimedia"), rs.getInt("idForum"), rs.getInt ("idDesigner")));
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questions;
	}

	
	

}

