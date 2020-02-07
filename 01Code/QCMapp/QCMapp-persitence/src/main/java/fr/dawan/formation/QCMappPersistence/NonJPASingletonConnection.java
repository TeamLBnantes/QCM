package fr.dawan.formation.QCMappPersistence;


	/* Version Vincent

	import java.io.File;
	import java.io.FileInputStream;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.util.Properties;

	public class SingletonConnection {
		
		private static Connection connection;
		private static Properties props =  new Properties();
		
		static {
			try {
				props.load(new FileInputStream(new File("app.properties")));
                String url = props.getProperty("url");
                String user = props.getProperty("user");
                String pass = props.getProperty("pass");
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url,user,pass);
				
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}
		public static Connection getConnection() {
			return connection;
		}*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class NonJPASingletonConnection {

	private static Connection connection;
	private static Properties props = new Properties();
	
	static {
		try {

			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
			String driver=props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String pass = props.getProperty("pass");
            Class.forName(driver);
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url, user, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
