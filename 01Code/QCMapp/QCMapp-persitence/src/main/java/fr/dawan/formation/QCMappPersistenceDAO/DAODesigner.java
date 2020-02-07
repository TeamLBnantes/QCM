package fr.dawan.formation.QCMappPersistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import fr.dawan.formation.QCMappModel.Designer;

import fr.dawan.formation.QCMappPersistence.SingletonConnection;
import fr.dawan.formation.QCMappPersistenceInterfaces.DAODesignerInterface;

public class DAODesigner implements DAODesignerInterface{

	@Override
	public void create(Designer designer) {
		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "INSERT INTO designer (id, presentation, dateStatus, expertiseField, certifier) VALUES(?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, designer.getId());
			ps.setString(2, designer.getPresentation());
			ps.setDouble(3, designer.getDateStatus().getTime());
			ps.setString(4, designer.getExpertiseField());
			ps.setBoolean(5, designer.isCertifier());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Designer designer) {

		Connection cn = SingletonConnection.getConnection();
		try {
			String sql = "UPDATE designer SET presentation=?, dateStatus=?, expertiseField=?, certifier=? WHERE id=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, designer.getPresentation());
			ps.setDouble(2, designer.getDateStatus().getTime());
			ps.setString(3, designer.getExpertiseField());
			ps.setBoolean(4, designer.isCertifier());
			ps.setInt(5, designer.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void delete(int idDesigner) {

		Connection cn = SingletonConnection.getConnection();
		Designer retourDesigner=null;
		try {
			retourDesigner=searchById(idDesigner);
			if (retourDesigner!=null) {
				String sql = "DELETE FROM designer  WHERE id=?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setInt(1, idDesigner);
				ps.executeUpdate();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override

	public Designer searchById(int idDesigner) {
		Connection cn = SingletonConnection.getConnection();
		Designer retourDesigner=null;
		try {
			String sql = "SELECT * FROM designer WHERE id = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idDesigner);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date dateStatus = new Date((rs.getLong("dateStatus")));
				retourDesigner = new Designer(rs.getInt("id"), rs.getString("presentation"), 
						dateStatus, rs.getString("expertiseField"), rs.getBoolean("certifier"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retourDesigner;

	}

	@Override
	public ArrayList<Designer> searchByCertifier(boolean certifier) {
		ArrayList<Designer> designers = new ArrayList<Designer>();
		Connection cn = SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM designer WHERE certifier=? ");
			
			ps.setBoolean(1, certifier);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date dateStatus = new Date((rs.getLong("dateStatus")));
				designers.add(new Designer(rs.getInt("id"), rs.getString("presentation"), dateStatus,
						rs.getString("expertiseField"), rs.getBoolean("certifier")));}
			
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return designers;
	}

	@Override
	// Recherche de KW sur PRESENTATION uniquement !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public ArrayList<Designer> searchByKW(String kw) {
		ArrayList<Designer> designers = new ArrayList<Designer>();
		Connection cn = SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM designer WHERE PRESENTATION LIKE ?");
			
			ps.setString(1, "%"+kw+"%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date dateStatus = new Date((rs.getLong("dateStatus")));
				designers.add(new Designer(rs.getInt("id"), rs.getString("presentation"), dateStatus,
						rs.getString("expertiseField"), rs.getBoolean("certifier")));}
			
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return designers;
	}

	@Override
	public ArrayList<Designer> searchAll() {
		ArrayList<Designer> designers = new ArrayList<Designer>();
		Connection cn = SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM designer");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date dateStatus = new Date((rs.getLong("dateStatus")));
				designers.add(new Designer(rs.getInt("id"), rs.getString("presentation"), dateStatus,
						rs.getString("expertiseField"), rs.getBoolean("certifier")));}
			
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return designers;
	}

	@Override
	public ArrayList<Designer> searchByDate(Date date1, Date date2) {
		ArrayList<Designer> designers = new ArrayList<Designer>();
		Connection cn = SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM designer WHERE (dateStatus>=? && dateStatus<=?)");
			ps.setDouble(1, date1.getTime());
			ps.setDouble(2, date2.getTime());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date dateStatus = new Date((rs.getLong("dateStatus")));
				designers.add(new Designer(rs.getInt("id"), rs.getString("presentation"), dateStatus,
						rs.getString("expertiseField"), rs.getBoolean("certifier")));}
			
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return designers;
	
	}

	

}
