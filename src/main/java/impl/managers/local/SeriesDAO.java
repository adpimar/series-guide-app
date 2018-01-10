package impl.managers.local;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abs.managers.ILocalManager;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class SeriesDAO implements ILocalManager {

	private static final int OVERVIEW_LIMIT = 500;

	// ------------------------------------------------------------------------

	@Override
	public List<Serie> listSeries() {
		List<Serie> misSeries = new ArrayList<Serie>();
		MySQLConnect conexion = new MySQLConnect();

		try {
			PreparedStatement consulta = conexion.getConnection().prepareStatement("SELECT * FROM SERIES");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				Serie serie = new Serie();
				serie.setCodSerie(res.getLong("cod_serie"));
				serie.setSeriesName(res.getString("series_name"));
				serie.setStatus(res.getString("status"));
				serie.setFirstAired(res.getString("first_aired"));
				serie.setAirsDOW(res.getString("airs_dow"));
				serie.setAirsTime(res.getString("airs_time"));
				serie.setNetwork(res.getString("network"));
				serie.setGenres(res.getString("genres"));
				serie.setSiteRating(Double.parseDouble(res.getString("site_rating")));
				serie.setSiteRatingCount(Integer.parseInt(res.getString("site_rating_count")));
				serie.setOverview(res.getString("overview"));

				misSeries.add(serie);
			}
			res.close();
			consulta.close();
			conexion.disconnect();

		} catch (Exception e) {
			System.out.println("Error: Clase SeriesDAO, método listSeries()");
			e.printStackTrace();
		}

		return misSeries;

	}

	@Override
	public Serie getSerie(long codSerie) {
		MySQLConnect conexion = new MySQLConnect();

		Serie serie = new Serie();

		try {
			PreparedStatement consulta = conexion.getConnection()
					.prepareStatement("SELECT * FROM SERIES WHERE cod_serie='" + codSerie + "'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				serie.setCodSerie(res.getLong("cod_serie"));
				serie.setSeriesName(res.getString("series_name"));
				serie.setStatus(res.getString("status"));
				serie.setFirstAired(res.getString("first_aired"));
				serie.setAirsDOW(res.getString("airs_dow"));
				serie.setAirsTime(res.getString("airs_time"));
				serie.setNetwork(res.getString("network"));
				serie.setGenres(res.getString("genres"));
				serie.setSiteRating(Double.parseDouble(res.getString("site_rating")));
				serie.setSiteRatingCount(Integer.parseInt(res.getString("site_rating_count")));
				serie.setOverview(res.getString("overview"));
			}
			res.close();
			consulta.close();
			conexion.disconnect();

		} catch (Exception e) {
			System.out.println("Error: Clase SeriesDAO, método getSerie()");
			e.printStackTrace();
		}

		return serie;
	}

	@Override
	public void updateSerie(Serie serie) {
		MySQLConnect conexion = new MySQLConnect();

		Statement stm = null;

		String sql = "UPDATE SERIES SET series_name='" + serie.getSeriesName() + "', status='" + serie.getStatus()
				+ "', first_aired='" + serie.getFirstAired() + "', airs_dow='" + serie.getAirsDOW() + "', airs_time='"
				+ serie.getAirsTime() + "', network='" + serie.getNetwork() + "', genres='" + serie.getGenres()
				+ "', site_rating='" + serie.getSiteRating() + "', site_rating_count='" + serie.getSiteRatingCount()
				+ "', overview='" + serie.getOverview() + "'" + " WHERE cod_serie=" + serie.getCodSerie();

		try {
			Connection connect = conexion.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método updateSerie(serie)");
			e.printStackTrace();
		}
	}

	@Override
	public void removeSerie(Serie serie) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm = null;

		String sql = "DELETE FROM SERIES WHERE cod_serie=" + serie.getCodSerie();
		try {
			Connection connect = conexion.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, metodo removeSerie(serie)");
			e.printStackTrace();
		}

	}

	@Override
	public List<Season> listSeasons() {
		/*
		 * List<Season> misTemporadas = new ArrayList<Season>(); MySQLConnect conexion =
		 * new MySQLConnect();
		 * 
		 * try { PreparedStatement consulta =
		 * conexion.getConnection().prepareStatement("SELECT * FROM TEMPORADAS");
		 * ResultSet res = consulta.executeQuery(); while(res.next()){ Season season=
		 * new Season(); season.setCodSerie(res.getLong("cod_serie"));
		 * season.setCodSeason(res.getLong("cod_season"));
		 * season.setAiredSeason(Integer.parseInt("aired_season"));
		 * season.setFirstAired(res.getString("first_aired"));
		 * season.setTotalEpisodes(Integer.parseInt("total_episodes"));
		 * season.setSeen(Boolean.parseBoolean("seen"));
		 * 
		 * misTemporadas.add(season); } res.close(); consulta.close();
		 * conexion.disconnect();
		 * 
		 * } catch (Exception e) {
		 * System.out.println("Error: Clase SeriesDAO, m�todo listSeasons()");
		 * e.printStackTrace(); }
		 * 
		 * return misTemporadas;
		 */
		return null;
	}

	@Override
	public Season getSeason(long codSeason) {
		MySQLConnect conexion = new MySQLConnect();

		Season temporada = new Season();

		try {
			PreparedStatement consulta = conexion.getConnection()
					.prepareStatement("SELECT * FROM TEMPORADAS WHERE cod_season='" + codSeason + "'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				temporada.setCodSerie(res.getLong("cod_serie"));
				temporada.setCodSeason(res.getLong("cod_season"));
				temporada.setAiredSeason(Integer.parseInt(res.getString("aired_season")));
				temporada.setFirstAired(res.getString("first_aired"));
				temporada.setTotalEpisodes(Integer.parseInt(res.getString("total_episodes")));
				temporada.setSeen(Boolean.parseBoolean(res.getString("seen")));
			}
			res.close();
			consulta.close();
			conexion.disconnect();

		} catch (Exception e) {
			System.out.println("Error: Clase SeriesDAO, método getSeason()");
			e.printStackTrace();
		}

		return temporada;
	}

	@Override
	public void updateSeason(Season season) {
		MySQLConnect conexion = new MySQLConnect();

		Statement stm = null;

		String sql = "UPDATE TEMPORADAS SET aired_season='" + season.getAiredSeason() + "', first_aired='"
				+ season.getFirstAired() + "', total_episodes='" + season.getTotalEpisodes() + "', seen='"
				+ season.isSeen() + " WHERE cod_season=" + season.getCodSeason();

		try {
			Connection connect = conexion.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método updateSeason(season)");
			e.printStackTrace();
		}

	}

	@Override
	public void removeSeason(Season season) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm = null;

		String sql = "DELETE FROM TEMPORADAS WHERE cod_season=" + season.getCodSeason();
		try {
			Connection connect = conexion.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método removeSeason(season)");
			e.printStackTrace();
		}

	}

	@Override
	public List<Episode> listEpisodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode getEpisode(long codEpisode) {
		MySQLConnect conexion = new MySQLConnect();

		Episode episodio = new Episode();

		try {
			PreparedStatement consulta = conexion.getConnection()
					.prepareStatement("SELECT * FROM EPISODIOS WHERE cod_episode='" + codEpisode + "'");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				episodio.setCodEpisode(res.getLong("cod_episode"));
				episodio.setCodSeason(res.getLong("cod_season"));
				episodio.setAiredSeason(Integer.parseInt(res.getString("aired_season")));
				episodio.setAiredEpisode(Integer.parseInt(res.getString("aired_episode")));
				episodio.setEpisodeName(res.getString("episode_name"));
				episodio.setFirstAired(res.getString("first_aired"));
				episodio.setOverview(res.getString("overview"));
				episodio.setSeen(Boolean.parseBoolean(res.getString("seen")));
				episodio.setComment(res.getString("comment"));
			}
			res.close();
			consulta.close();
			conexion.disconnect();

		} catch (Exception e) {
			System.out.println("Error: Clase SeriesDAO, método getEpisode()");
			e.printStackTrace();
		}

		return episodio;
	}

	@Override
	public void updateEpisode(Episode episode) {
		MySQLConnect conexion = new MySQLConnect();

		Statement stm = null;

		String sql = "UPDATE EPISODIOS SET aired_season='" + episode.getAiredSeason() + "', aired_episode='"
				+ episode.getAiredEpisode() + "', episode_name='" + episode.getEpisodeName() + "', first_aired='"
				+ episode.getFirstAired() + "', overview='" + episode.getOverview() + "', seen='" + episode.isSeen()
				+ "', comment='" + episode.getComment() + " WHERE cod_episode=" + episode.getCodEpisode();

		try {
			Connection connect = conexion.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método updateEpisode(episode)");
			e.printStackTrace();
		}

	}

	@Override
	public void removeEpisode(Episode episode) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm = null;

		String sql = "DELETE FROM EPISODIOS WHERE cod_episode=" + episode.getCodEpisode();
		try {
			Connection connect = conexion.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método removeEpisode(episode)");
			e.printStackTrace();
		}

	}

	@Override
	public void addSerie(Serie serie) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm = null;
		
		String overview = serie.getOverview();
		if (overview.length() > OVERVIEW_LIMIT)
			overview = acortaSinopsis(overview);

		String sql = "INSERT INTO SERIES values ('" + serie.getCodSerie() + "','" + serie.getSeriesName() + "','"
				+ serie.getStatus() + "','" + serie.getFirstAired() + "','" + serie.getAirsDOW() + "','"
				+ serie.getAirsTime() + "','" + serie.getNetwork() + "','" + serie.getGenres() + "','"
				+ serie.getSiteRating() + "','" + serie.getSiteRatingCount() + "','" + overview + "')";

		List<Season> temporadas = serie.getSeasons();
		for (int i = 0; i < temporadas.size() - 1; i++) {
			addSeason(temporadas.get(i));
		}

		try {
			Connection connect = conexion.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
			stm.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método addSerie(serie)");
			e.printStackTrace();
		}
	}

	@Override
	public void addSeason(Season season) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm = null;

		String sql = "INSERT INTO TEMPORADAS values ('" + season.getCodSerie() + "','" + season.getCodSeason() + "','"
				+ season.getAiredSeason() + "','" + season.getFirstAired() + "','" + season.getTotalEpisodes() + "','"
				+ season.isSeen() + "')";

		Episode[] episodios = season.getEpisodes();
		for (int i = 0; i < episodios.length - 1; i++) {
			addEpisode(episodios[i]);
		}

		try {
			Connection connect = conexion.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
			stm.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método addSeason(season)");
			e.printStackTrace();
		}
	}

	@Override
	public void addEpisode(Episode episode) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm = null;
		
		String overview = episode.getOverview();
		if (overview.length() > OVERVIEW_LIMIT)
			overview = acortaSinopsis(overview);

		String sql = "INSERT INTO EPISODIOS values ('" + episode.getCodEpisode() + "','" + episode.getCodSeason()
				+ "','" + episode.getAiredSeason() + "','" + episode.getAiredEpisode() + "','"
				+ episode.getEpisodeName() + "','" + episode.getFirstAired() + "','" + overview + "','"
				+ episode.isSeen() + "','" + episode.getComment() + "')";

		try {
			Connection connect = conexion.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
			stm.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método addEpisode(episode)");
			e.printStackTrace();
		}

	}

	private String acortaSinopsis(String overview) {
		return overview.substring(0, OVERVIEW_LIMIT - 1);
	}

}
