package impl.managers.local;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

	public static void createDatabaseTables(Statement stmt) throws SQLException {
		
		String sql;

		sql = "CREATE TABLE seriesguideapp.SERIES (" +
			" cod_serie INT NOT NULL, " +
			" series_name VARCHAR(50) NOT NULL, " +
			" status VARCHAR(20) NOT NULL, " +
			" first_aired DATE NOT NULL, " +
			" airs_dow VARCHAR(10) NOT NULL, " +
			" airs_time VARCHAR(10) NOT NULL, " +
			" network VARCHAR(20) NOT NULL, " +
			" genres VARCHAR(100) NOT NULL, " +
			" site_rating NUMERIC(2,0) NOT NULL, " +
			" site_rating_count INT NOT NULL, " +
			" overview VARCHAR(500), " +
			" CONSTRAINT SERIES_pk PRIMARY KEY (cod_serie));";
		
		stmt.executeUpdate(sql);

		System.out.println("Tabla SERIES creada.");
		
		sql = "CREATE TABLE seriesguideapp.TEMPORADAS (" +
			"cod_serie INT NOT NULL, " +
			"cod_season INT NOT NULL, " +
			"aired_season NUMERIC(2,0) NOT NULL, " +
			"first_aired VARCHAR(10) NOT NULL, " +
			"total_episodes NUMERIC(2,0) NOT NULL, " +
			"seen BOOLEAN NOT NULL DEFAULT false, " +
			"CONSTRAINT TEMPORADAS_pk PRIMARY KEY (cod_season)," + 
			"FOREIGN KEY (cod_serie) REFERENCES seriesguideapp.SERIES (cod_serie) ON DELETE CASCADE ON UPDATE CASCADE);";
				
		stmt.executeUpdate(sql);
		
		System.out.println("Tabla TEMPORADAS creada.");

		sql = "CREATE TABLE seriesguideapp.EPISODIOS (" +
			"cod_episode INT NOT NULL, " +
			"cod_season INT NOT NULL, " +
			"aired_season NUMERIC(2,0) NOT NULL, " +
			"aired_episode NUMERIC(2,0) NOT NULL, " +
			"episode_name VARCHAR(50) NOT NULL, " +
			"first_aired VARCHAR(10) NOT NULL, " +
			"overview VARCHAR(500), " +
			"seen BOOLEAN NOT NULL DEFAULT false, " +
			"comment varchar(150), " +
			"CONSTRAINT EPISODIOS_pk PRIMARY KEY (cod_episode), " +
			"FOREIGN KEY (cod_season) REFERENCES seriesguideapp.TEMPORADAS (cod_season) ON DELETE CASCADE ON UPDATE CASCADE);";
		
		stmt.executeUpdate(sql);
		
		System.out.println("Tabla EPISODIOS creada.");

	}

}
