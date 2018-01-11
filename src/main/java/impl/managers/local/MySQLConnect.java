package impl.managers.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {

	private static MySQLConnect mySQLConnect;
	
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://mysql:3306/seriesguideapp?&useSSL=false";
	private static final String DATABASE_NAME = "seriesguideapp";
	
	// Database credentials
	private static final String USER = "ei1048adan";
	private static final String PASS = "adan";

	// Creates the Connection object
	private Connection connection = null;
	
	// ------------------------------------------------------------------------
	
	private MySQLConnect() {

		Statement stmt = null;

		try {

			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			System.out.println("Conectando a BDL...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = connection.createStatement();
			
			try {
				System.out.println("Creando BDL...");
				stmt.executeUpdate("CREATE DATABASE " + DATABASE_NAME);
				System.out.println("BDL creada satisfactoriamente...");
			} catch (SQLException e) {
				System.out.println("¡BDL ya había sido creada!");
			}
			
			try {
				stmt.executeUpdate("DROP TABLE EPISODIOS;");
			} catch (SQLException e) {
				System.out.println("¡No creadas todavía!");
				e.printStackTrace();
			}
			
			try {
				stmt.executeUpdate("DROP TABLE TEMPORADAS;");
			} catch (SQLException e) {
				System.out.println("¡No creadas todavía!");
				e.printStackTrace();
			}
			
			try {
				stmt.executeUpdate("DROP TABLE SERIES;");
			} catch (SQLException e) {
				System.out.println("¡No creadas todavía!");
				e.printStackTrace();
			}

			
			try {
				System.out.println("Creando tablas...");
				CreateTables.createDatabaseTables(stmt);
				System.out.println("Tablas creadas satisfactoriamente...");
			} catch (SQLException e) {
				System.out.println("¡Las tablas ya habían sido creadas!");
				e.printStackTrace();
			}

		} catch (SQLException e) {

			// Handle errors for JDBC
			e.printStackTrace();

		} catch (Exception e) {

			// Handle errors for Class.forName
			e.printStackTrace();

		} finally {
			try {
				if (stmt != null)
					stmt.close();			
			} catch (SQLException se2) {			
			}		
			try {			
				if (connection != null)
					connection.close();		
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		}
		
		System.out.println("¡Todo en orden!\n");

	}
	
	// ------------------------------------------------------------------------
	
	public static MySQLConnect getMySQLConnect() {
		if (mySQLConnect == null)
			mySQLConnect = new MySQLConnect();
		return mySQLConnect;
	}
	
	// ------------------------------------------------------------------------

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			//System.out.println("Realizada conexión con BDL");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error de conexión con BDL");
		}
		return connection;
	}

	public void disconnect() {
		try {			
			if (connection != null)
				connection.close();		
		} catch (SQLException e) {
			e.printStackTrace();		
		}
	}

}
