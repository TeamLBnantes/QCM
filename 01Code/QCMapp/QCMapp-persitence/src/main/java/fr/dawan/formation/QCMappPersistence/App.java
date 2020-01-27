package fr.dawan.formation.QCMappPersistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection cn=SingletonConnection.getConnection();
        
        try {
        	String sql = "INSERT INTO answer (body, expectedAnswer, commentPostAnswer,idQuestion) VALUES(?,?,?,?)";
        	PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, "deuxieme reponse de la base");
			ps.setBoolean(2, true);
			ps.setString(3, "et bien oui, .....");
			ps.setInt(4, 1177);
			
			
			ps.executeUpdate();
			ps.close();
        	
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
