package impl.managers.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {
	
	static final String url = "jdbc:mysql://localhost:3306/seriesguideapp?&useSSL=false";
    static final String user = "ei1048adan";
    static final String pass = "adan";
    
	//Creates the Connection object
    Connection connection = null;
    
    public MySQLConnect() {
    	try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, user, pass);
			
			if (connection != null) 
				System.out.println("Connected to the database seriesguideapp-adan");
			else 
				System.out.println("Connexion to the database seriesguideapp-adan has failed!");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException ex) {
            System.out.println("An error occurred. <MySQLConnect>");
            ex.printStackTrace();
        }
		
    }
    
	public Connection getConnection() {
		return connection;
	}
	
	public void disconnect() {
		connection = null;
	}
	
}
