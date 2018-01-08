package resources;

public class TestSQLParsers {

	public static String serieInsertSQL(String[] fields) {
		int i = 1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO SERIES (cod_serie, series_name, status, first_aired, airs_dow, airs_time, network, genres, site_rating, site_rating_count, overview) ");
		sb.append("VALUES (");
		sb.append(fields[i++] + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(fields[i++] + ", ");
		sb.append(fields[i++] + ", ");
		sb.append(readStringFields(fields[i++]) + ");");
		
		return sb.toString();
	}
	
	public static String seasonInsertSQL(String[] fields) {
		int i = 1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO TEMPORADAS (cod_serie, cod_season, aired_season, first_aired, total_episodes, seen) ");
		sb.append("VALUES (");
		sb.append(fields[i++] + ", ");
		sb.append(fields[i++] + ", ");
		sb.append(fields[i++] + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(fields[i++] + ", ");
		sb.append((fields[i++].toUpperCase().charAt(0) == 'T') + ");");
		
		return sb.toString();
	}
	
	public static String episodeInsertSQL(String[] fields) {
		int i = 1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO EPISODIOS (cod_episode, cod_season, aired_season, aired_episode, episode_name, first_aired, overview, seen, comment) ");
		sb.append("VALUES (");
		sb.append(fields[i++] + ", ");
		sb.append(fields[i++] + ", ");
		sb.append(fields[i++] + ", ");
		sb.append(fields[i++] + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append(readStringFields(fields[i++]) + ", ");
		sb.append((fields[i++].toUpperCase().charAt(0) == 'T') + ", ");
		sb.append(readStringFields(fields[i++]) + ");");
		
		return sb.toString();
	}

	private static String readStringFields(String field) {
		if (field.equals("null"))
			return "null";
		if (field.equals("\"\"") || field.equals("empty"))
			return "\"\"";
		return "\"" + field + "\"";
	}

}
