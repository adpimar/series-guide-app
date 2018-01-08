package impl.managers.local;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

	public static void main(String[] argv) throws Exception {
		
		//Connect to the database
		MySQLConnect conexion = new MySQLConnect();
		Connection conn = conexion.getConnection();
				
		
		/* Statement to create the tables */
		if(conn != null){
			Statement stmt = null;
			
			try {
	 			System.out.println("Creating tables in the database...");
	      			stmt = conn.createStatement();
	      		
					String sql = "CREATE TABLE SERIES(" +
							" cod_serie LONG NOT NULL CHECK (cod_serie >= 0), " +
							" series_name VARCHAR(50) NOT NULL, " +
							" status VARCHAR(20) NOT NULL, " +
							" first_aired DATE NOT NULL, " +
							" airs_dow VARCHAR(10) NOT NULL, " +
							" airs_time TIME NOT NULL, " +
							" network VARCHAR(20) NOT NULL, " +
							" genres VARCHAR(100) NOT NULL, " +
							" site_rating NUMERIC(2,0) NOT NULL, " +
							" site_rating_count INT NOT NULL, " +
							" overview VARCHAR(500), " +
							" CONSTRAINT SERIES_pk PRIMARY KEY (cod_serie));";
					
					stmt.executeUpdate(sql);
					System.out.println("SERIES table created...");
			
					sql = "CREATE TABLE TEMPORADAS (" +
							" cod_serie LONG NOT NULL CHECK (cod_serie >= 0), " +
							" cod_season LONG NOT NULL CHECK (cod_season >= 0), " +
							" aired_season NUMERIC(2,0) NOT NULL, " +
							" first_aired DATE NOT NULL, " +
							" total_episodes NUMERIC(2,0) NOT NULL, " +
							" seen  BOOLEAN NOT NULL DEFAULT false, " +
							" CONSTRAINT TEMPORADAS_pk PRIMARY KEY (cod_season));";
							
					stmt.executeUpdate(sql);
					System.out.println("TEMPORADAS table created...");
					
					
					sql = "CREATE TABLE EPISODIOS (" +
							" cod_episode LONG NOT NULL CHECK (cod_episode >= 0), " +
							" cod_season LONG NOT NULL CHECK (cod_season >= 0), " +
							" aired_season NUMERIC(2,0) NOT NULL, " +
							" aired_episode NUMERIC(2,0) NOT NULL, " +
							" episode_name VARCHAR(50) NOT NULL, " +
							" first_aired DATE NOT NULL, " +
							" overview VARCHAR(500), " +
							" seen BOOLEAN NOT NULL DEFAULT false, " +
							" comment varchar(150), " +
							" CONSTRAINT EPISODIOS_pk PRIMARY KEY (cod_episode)," +
							" CONSTRAINT COMMENT_chk CHECK (seen = false AND comment IS NULL));";
					
					stmt.executeUpdate(sql);
					System.out.println("EPISODIOS table created...");
					
				  	sql = "ALTER TABLE TEMPORADAS ADD CONSTRAINT SERIES_TEMPORADAS" + 
				  			" FOREIGN KEY (cod_serie) " +
		                   	" REFERENCES SERIES (cod_serie) " + 
				  			" ON DELETE CASCADE " +
		                   	" ON UPDATE CASCADE " +
		                   	" DEFERRABLE " +
		                   	" INITIALLY IMMEDIATE;";
	
					stmt.executeUpdate(sql);
					System.out.println("SERIES_TEMPORADAS relation created...");
					
					sql = "ALTER TABLE EPISODIOS ADD CONSTRAINT TEMPORADAS_EPISODIOS" + 
				  			" FOREIGN KEY (cod_season) " +
		                   	" REFERENCES TEMPORADAS (cod_season) " + 
				  			" ON DELETE CASCADE " +
		                   	" ON UPDATE CASCADE " +
		                   	" DEFERRABLE " +
		                   	" INITIALLY IMMEDIATE;";
								
					stmt.executeUpdate(sql);
					System.out.println("TEMPORADAS_EPISODIOS relation created...");
				
					System.out.println("The database has been created...");
	 		
			} catch (SQLException e) {
				System.out.println("The table could not be created... ");
				e.printStackTrace();
				return;
			}
			
			try {
			    if (stmt != null) {  
			    	stmt.close();
			    }
			    if (conn != null) { 
			    	conn.close();
			    }
			} catch (SQLException e) {
			       e.printStackTrace();
			}
		}
	}


}
