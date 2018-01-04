package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {
	
	static final String url = "jdbc:mysql://mysql:3306/seriesguideapp-adan";
	
	//Creates the Connection object
    static Connection connection = null;
    
	public static Connection getConnection() {
		
		try {
			if (connection != null && !connection.isClosed())
				return connection;
			
			connection = DriverManager.getConnection(url);
			
			if (connection != null) 
				System.out.println("Connected to the database seriesguideapp-adan");
			else 
				System.out.println("Connexion to the database seriesguideapp-adan has failed!");
			
		} catch (SQLException ex) {
            System.out.println("An error occurred. <MySQLConnect>");
            ex.printStackTrace();
        }
		
		return connection;
	
	}
	
}
