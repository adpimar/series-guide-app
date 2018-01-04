package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {

	public static void main(String[] args) {
		 
        //Creates the Connection object
        Connection conn = null;
 
        try {
            String url = "jdbc:mysql://mysql:3306/seriesguideapp-adan";
 
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("Connected to the database seriesguideapp-adan");
            }
 
        } catch (SQLException ex) {
            System.out.println("An error occurred. <MySQLConnect>");
            ex.printStackTrace();
        }
    }
	
}
