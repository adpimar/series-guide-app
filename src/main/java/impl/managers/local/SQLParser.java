package impl.managers.local;

import java.sql.ResultSet;
import java.sql.SQLException;

import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class SQLParser {
	
	private static final int OVERVIEW_LIMIT = 500;
	
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	
	public static String insertSerieSQL(Serie serie) {
		StringBuilder sb = new StringBuilder();	
		sb.append("INSERT INTO SERIES (cod_serie, series_name, status, first_aired, airs_dow, airs_time, network, genres, site_rating, site_rating_count, overview) VALUES (");
		sb.append(serie.getCodSerie() + ", ");
		sb.append(checkStringField(serie.getSeriesName()) + ", ");
		sb.append(checkStringField(serie.getStatus()) + ", ");
		sb.append(checkStringField(serie.getFirstAired()) + ", ");
		sb.append(checkStringField(serie.getAirsDOW()) + ", ");
		sb.append(checkStringField(serie.getAirsTime()) + ", ");
		sb.append(checkStringField(serie.getNetwork()) + ", ");
		sb.append(checkStringField(serie.getGenres()) + ", ");
		sb.append(serie.getSiteRating() + ", ");
		sb.append(serie.getSiteRatingCount() + ", ");
		sb.append(makeOverviewShorterIfExceeds(checkStringField(serie.getOverview())) + ")");
		return sb.toString();
	}
	
	public static String insertSeasonSQL(Season season) {
		StringBuilder sb = new StringBuilder();	
		sb.append("INSERT INTO TEMPORADAS (cod_serie, cod_season, aired_season, first_aired, total_episodes, seen) VALUES (");
		sb.append(season.getCodSerie() + ", ");
		sb.append(season.getCodSeason() + ", ");
		sb.append(season.getAiredSeason() + ", ");
		sb.append(checkStringField(season.getFirstAired()) + ", ");
		sb.append(season.getTotalEpisodes() + ", ");
		sb.append(checkBooleanField(season.isSeen()) + ")");
		return sb.toString();
	}
	
	public static String insertEpisodeSQL(Episode episode) {
		StringBuilder sb = new StringBuilder();	
		sb.append("INSERT INTO EPISODIOS (cod_episode, cod_season, aired_season, aired_episode, episode_name, first_aired, overview, seen, comment) VALUES (");
		sb.append(episode.getCodEpisode() + ", ");
		sb.append(episode.getCodSeason() + ", ");
		sb.append(episode.getAiredSeason() + ", ");
		sb.append(episode.getAiredEpisode() + ", ");
		sb.append(checkStringField(episode.getEpisodeName()) + ", ");
		sb.append(checkStringField(episode.getFirstAired()) + ", ");
		sb.append(makeOverviewShorterIfExceeds(checkStringField(episode.getOverview())) + ", ");
		sb.append(checkBooleanField(episode.isSeen()) + ", ");
		sb.append(checkStringField(episode.getComment()) + ")");
		return sb.toString();
	}
	
	// ------------------------------------------------------------------------
	
	public static String listSeriesSQL() {
		return "SELECT * FROM SERIES";
	}
	
	public static String listSeasonsSQL() {
		return "SELECT * FROM TEMPORADAS";
	}
	
	public static String listEpisodesSQL() {
		return "SELECT * FROM EPISODIOS";
	}
	
	// ------------------------------------------------------------------------
	
	public static String updateSerieSQL(Serie serie) {
		StringBuilder sb = new StringBuilder();	
		sb.append("UPDATE SERIES SET ");
		sb.append("series_name = " + checkStringField(serie.getSeriesName()) + ", ");
		sb.append("status = " + checkStringField(serie.getStatus()) + ", ");
		sb.append("first_aired = " + checkStringField(serie.getFirstAired()) + ", ");
		sb.append("airs_dow = " + checkStringField(serie.getAirsDOW()) + ", ");
		sb.append("airs_time = " + checkStringField(serie.getAirsTime()) + ", ");
		sb.append("network = " + checkStringField(serie.getNetwork()) + ", ");
		sb.append("genres = " + checkStringField(serie.getGenres()) + ", ");
		sb.append("site_rating = " + serie.getSiteRating() + ", ");
		sb.append("site_rating_count = " + serie.getSiteRatingCount() + ", ");
		sb.append("overview = " + makeOverviewShorterIfExceeds(checkStringField(serie.getOverview())) + " ");
		sb.append("WHERE cod_serie = " + serie.getCodSerie());
		return sb.toString();
	}
	
	public static String updateSeasonSQL(Season season) {
		StringBuilder sb = new StringBuilder();			
		sb.append("UPDATE TEMPORADAS SET ");
		sb.append("cod_season = " + season.getCodSeason() + ", ");
		sb.append("aired_season = " + season.getAiredSeason() + ", ");
		sb.append("first_aired = " + checkStringField(season.getFirstAired()) + ", ");
		sb.append("total_episodes = " + season.getTotalEpisodes() + ", ");
		sb.append("seen = " + checkBooleanField(season.isSeen()) + " ");
		sb.append("WHERE cod_serie = " + season.getCodSerie());
		return sb.toString();
	}
	
	public static String updateEpisodeSQL(Episode episode) {
		StringBuilder sb = new StringBuilder();	
		sb.append("UPDATE EPISODIOS SET ");
		sb.append("cod_season = " + episode.getCodSeason() + ", ");
		sb.append("aired_season = " + episode.getAiredSeason() + ", ");
		sb.append("aired_episode = " + episode.getAiredEpisode() + ", ");
		sb.append("episode_name = " + checkStringField(episode.getEpisodeName()) + ", ");
		sb.append("first_aired = " + checkStringField(episode.getFirstAired()) + ", ");
		sb.append("overview = " + makeOverviewShorterIfExceeds(checkStringField(episode.getOverview())) + ", ");
		sb.append("seen = " + checkBooleanField(episode.isSeen()) + ", ");
		sb.append("comment = " + checkStringField(episode.getComment()) + " ");
		sb.append("WHERE cod_episode = " + episode.getCodEpisode());
		return sb.toString();
	}
	
	// ------------------------------------------------------------------------
	
	public static String getSerieSQL(long codSerie) {
		return "SELECT * FROM SERIES WHERE cod_serie = " + codSerie;
	}
	
	public static String getSeasonSQL(long codSeason) {
		return "SELECT * FROM TEMPORADAS WHERE cod_season = " + codSeason;
	}
	
	public static String getEpisodeSQL(long codEpisode) {
		return "SELECT * FROM EPISODIOS WHERE cod_episode = " + codEpisode;
	}
	
	// ------------------------------------------------------------------------
	
	public static String deleteSerieSQL(long codSerie) {
		return "DELETE FROM SERIES WHERE cod_serie = " + codSerie;
	}
	
	public static String deleteSeasonSQL(long codSeason) {
		return "DELETE FROM TEMPORADAS WHERE cod_season = " + codSeason;
	}
	
	public static String deleteEpisodeSQL(long codEpisode) {
		return "DELETE FROM EPISODIOS WHERE cod_episode = " + codEpisode;
	}
	
	// ------------------------------------------------------------------------
	
	public static String listSerieSeasonsSQL(long codSerie) {
		return "SELECT * FROM TEMPORADAS WHERE cod_serie = " + codSerie;
	}
	
	public static String listSeasonEpisodesSQL(long codSeason) {
		return "SELECT * FROM EPISODIOS WHERE cod_season = " + codSeason;
	}
	
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	
	public static Serie extractSerieFromSQL(ResultSet res) throws SQLException {
		Serie serie = new Serie();
		serie.setCodSerie(res.getInt("cod_serie"));
		serie.setSeriesName(res.getString("series_name"));
		serie.setStatus(res.getString("status"));
		serie.setFirstAired(res.getString("first_aired"));
		serie.setAirsDOW(res.getString("airs_dow"));
		serie.setAirsTime(res.getString("airs_time"));
		serie.setNetwork(res.getString("network"));
		serie.setGenres(res.getString("genres"));
		serie.setSiteRating(res.getDouble("site_rating"));
		serie.setSiteRatingCount(res.getInt("site_rating_count"));
		serie.setOverview(res.getString("overview"));
		return serie;
	}
	
	public static Season extractSeasonFromSQL(ResultSet res) throws SQLException {
		Season season = new Season();
		season.setCodSerie(res.getInt("cod_serie"));
		season.setCodSeason(res.getInt("cod_season"));
		season.setAiredSeason(res.getInt("aired_season"));
		season.setFirstAired(res.getString("first_aired"));
		season.setTotalEpisodes(res.getInt("total_episodes"));
		season.setSeen(res.getBoolean("seen"));
		return season;
	}
	
	public static Episode extractEpisodeFromSQL(ResultSet res) throws SQLException {
		Episode episode = new Episode();
		episode.setCodEpisode(res.getInt("cod_episode"));
		episode.setCodSeason(res.getInt("cod_season"));
		episode.setAiredSeason(res.getInt("aired_season"));
		episode.setAiredEpisode(res.getInt("aired_episode"));
		episode.setEpisodeName(res.getString("episode_name"));
		episode.setFirstAired(res.getString("first_aired"));
		episode.setOverview(res.getString("overview"));
		episode.setSeen(res.getBoolean("seen"));
		episode.setComment(res.getString("comment"));
		return episode;
	}
	
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------

	private static String checkStringField(String field) {
		if (field == null)
			return "NULL";
		return "\"" + field + "\"";
	}
	
	private static String checkBooleanField(boolean field) {
		if (field)
			return "TRUE";
		return "FALSE";
	}
	
	private static String makeOverviewShorterIfExceeds(String overview) {
		if (overview.length() > OVERVIEW_LIMIT)
			return overview.substring(0, OVERVIEW_LIMIT - 1);
		return overview;
	}
	
}
