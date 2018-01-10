package resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import impl.managers.local.MySQLConnect;
import impl.managers.local.SeriesDAO;

public class RealBDL extends SeriesDAO {

	public RealBDL(String filename) {
		configureBDL(filename);
	}

	private void configureBDL(String filename) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm = null;
		BufferedReader b;
		String line = "";
		String sqlSentence = "";
		Connection connect;

		try {

			connect = conexion.getConnection();
			stm = connect.createStatement();

			stm.execute("DELETE FROM episodios");
			stm.execute("DELETE FROM temporadas");
			stm.execute("DELETE FROM series");

			b = new BufferedReader(new FileReader(filename));

			while ((line = b.readLine()) != null) {
				String[] fields = line.split("#");
				switch (fields[0].charAt(0)) {
				case 'S':
					sqlSentence = ParserSQL.serieInsertSQL(fields);
					break;
				case 'T':
					sqlSentence = ParserSQL.seasonInsertSQL(fields);
					break;
				case 'E':
					sqlSentence = ParserSQL.episodeInsertSQL(fields);
				}
				stm.execute(sqlSentence);
			}

			stm.close();
			connect.close();
			b.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sqlSentence);
		}

	}

}
