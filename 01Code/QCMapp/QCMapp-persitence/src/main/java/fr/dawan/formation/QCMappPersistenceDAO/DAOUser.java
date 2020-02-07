package fr.dawan.formation.QCMappPersistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import fr.dawan.formation.QCMappModel.Answer;
import fr.dawan.formation.QCMappModel.User;
import fr.dawan.formation.QCMappPersistence.SingletonConnection;
import fr.dawan.formation.QCMappPersistenceInterfaces.DAOuserInterface;

public class DAOUser implements DAOuserInterface {

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		Connection cn=SingletonConnection.getConnection();
		try {
			String sql = "INSERT INTO user(lastName, firstName, email, pseudo, signInDate, lastConnectionDate, designer) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, user.getLastName());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPseudo());
			ps.setDouble(5, user.getSignInDate().getTime());
			ps.setDouble(6, user.getLastConnectionDate().getTime());
			ps.setBoolean(7, user.isDesigner());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Connection cn=SingletonConnection.getConnection();
		try {
			String sql = "UPDATE user set lastName=?,firstName=?,email=?,pseudo=?,signInDate=?,lastConnectionDate=?,designer=? WHERE id=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, user.getLastName());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPseudo());
			ps.setDouble(5, user.getSignInDate().getTime());
			ps.setDouble(6, user.getLastConnectionDate().getTime());
			ps.setBoolean(7, user.isDesigner());
			ps.setInt(8, user.getId());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(int idUser) {
		// TODO Auto-generated method stub
		Connection cn = SingletonConnection.getConnection();
		User retourUser=null;
		try {
			retourUser=searchById(idUser);
			if (retourUser!=null) {
				String sql = "DELETE FROM user  WHERE id=?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setInt(1, idUser);
				ps.executeUpdate();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<User> searchByDesigner(boolean designer) {
		//recherche les indiv qui sont designer ou non designer suivant la valeur du parametre boolean passé en argument
		Connection cn = SingletonConnection.getConnection();
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			String sql = "SELECT * FROM user WHERE designer = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setBoolean(1, designer);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Date dateSign = new Date(rs.getLong("signInDate"));
				Date dateLastCon = new Date(rs.getLong("lastConnectionDate"));
				users.add(new User(rs.getInt("id"), rs.getString("lastName"), rs.getString("firstName"),rs.getString("email"),rs.getString("pseudo"),
						dateSign, dateLastCon, rs.getBoolean("designer")));
			}
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	@Override
	public ArrayList<User> searchByKW(String kw) {
		//recherche de la chaine passee en parametre, dans l'ensembles des 
		//champs String de User (nom, prenom, pseudo et email
		Connection cn = SingletonConnection.getConnection();
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			String sql = "SELECT * FROM user WHERE (lastName like ?) OR (firstName like ?) OR (email like ?) OR (pseudo like ?)";
			PreparedStatement ps = cn.prepareStatement(sql);

			/* je modifie cette partie du code 
			 * sans le sup pour echange avec Guillaume
			String kw2 = new String();
			ps.setString(1, kw2);
			*/
			ps.setString(1, '%'+kw+'%');
			ps.setString(2, '%'+kw+'%');
			ps.setString(3, '%'+kw+'%');
			ps.setString(4, '%'+kw+'%');
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Date dateSign = new Date(rs.getLong("signInDate"));
				Date dateLastCon = new Date(rs.getLong("lastConnectionDate"));
				users.add(new User(rs.getInt("id"), rs.getString("lastName"), rs.getString("firstName"),rs.getString("email"),rs.getString("pseudo"),
						dateSign, dateLastCon, rs.getBoolean("designer")));
			}
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	@Override
	public ArrayList<User> searchAll() {
		Connection cn = SingletonConnection.getConnection();
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			String sql = "SELECT * FROM user";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Date dateSign = new Date(rs.getLong("signInDate"));
				Date dateLastCon = new Date(rs.getLong("lastConnectionDate"));
				users.add(new User(rs.getInt("id"), rs.getString("lastName"), rs.getString("firstName"),rs.getString("email"),rs.getString("pseudo"),
						dateSign, dateLastCon, rs.getBoolean("designer")));
			}
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	@Override
	public ArrayList<User> searchByDate(Date date1, Date date2) {
		//cette methode fait une recherche par rapport à la date de derniere connection
		
		Connection cn = SingletonConnection.getConnection();
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			String sql = "SELECT * FROM user WHERE  (lastConnectionDate >= ? &&  lastConnectionDate <= ?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setDouble(1, date1.getTime());
			ps.setDouble(2, date2.getTime());	
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Date dateSign = new Date(rs.getLong("signInDate"));
				Date dateLastCon = new Date(rs.getLong("lastConnectionDate"));
				users.add(new User(rs.getInt("id"), rs.getString("lastName"), rs.getString("firstName"),rs.getString("email"),rs.getString("pseudo"),
						dateSign, dateLastCon, rs.getBoolean("designer")));
			}
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return users;
		
	}

	@Override
	public User searchById(int id) {
		// TODO Auto-generated method stub
		Connection cn=SingletonConnection.getConnection();
		User retourUser = null;
		try {
			String sql = "SELECT * FROM user WHERE id = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Date dateSign = new Date(rs.getLong("signInDate"));
				Date dateLastCon = new Date(rs.getLong("lastConnectionDate"));
				retourUser = new User(rs.getInt("id"), rs.getString("lastName"), rs.getString("firstName"),rs.getString("email"),rs.getString("pseudo"),
						dateSign, dateLastCon, rs.getBoolean("designer"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (retourUser==null) {
			System.out.println("personne avec cette id");
		}
		return retourUser;
	}

	
	
}
