package impl.managers.local;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import abs.managers.ILocalManager;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class SeriesDAO implements ILocalManager {

	@Override
	public List<Serie> listSeries() {
		List<Serie> misSeries = new ArrayList<>();
		MySQLConnect conexion = new MySQLConnect();
		try {
			ResultSet res = conexion.getConnection().prepareStatement(SQLParser.listSeriesSQL()).executeQuery();
			while (res.next())
				misSeries.add(SQLParser.extractSerieFromSQL(res));
			res.close();
			conexion.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return misSeries;
	}

	@Override
	public void addSerie(Serie serie) {
		MySQLConnect conexion = new MySQLConnect();
		try {
			conexion.getConnection().createStatement().execute(SQLParser.insertSerieSQL(serie));
			conexion.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Serie getSerie(long codSerie) {
		MySQLConnect conexion = new MySQLConnect();
		Serie serie = null;
		ResultSet res;
		try {
			Connection con = conexion.getConnection();
			
			// Dame la serie
			res = con.prepareStatement(SQLParser.getSerieSQL(codSerie)).executeQuery();
			while (res.next())
				serie = SQLParser.extractSerieFromSQL(res);
			
			if (serie != null) {
			
				// Dame las temporadas
				List<Season> seasons = new LinkedList<>();
				res = con.prepareStatement(SQLParser.listSerieSeasonsSQL(codSerie)).executeQuery();
				while (res.next())
					seasons.add(SQLParser.extractSeasonFromSQL(res));
				serie.setSeasons(seasons);
				
				// Dame los episodios
				Episode[] episodes;
				Episode episode;
				for (Season season : seasons) {
					res = con.prepareStatement(SQLParser.listSeasonEpisodesSQL(season.getCodSeason())).executeQuery();
					episodes = new Episode[season.getTotalEpisodes()];
					while (res.next()) {
						episode = SQLParser.extractEpisodeFromSQL(res);
						episodes[episode.getAiredEpisode() - 1] = episode;
					}
					season.setEpisodes(episodes);
				}
				
			}

			res.close();
			conexion.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serie;
	}

	@Override
	public void updateSerie(Serie serie) {
		MySQLConnect conexion = new MySQLConnect();
		String a = null;
		try {
			conexion.getConnection().createStatement().execute(a = SQLParser.updateSerieSQL(serie));
			conexion.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(a);
		}
	}

	@Override
	public void removeSerie(Serie serie) {
		MySQLConnect conexion = new MySQLConnect();
		try {
			conexion.getConnection().createStatement().execute(SQLParser.deleteSerieSQL(serie.getCodSerie()));
			conexion.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------

	@Override
	public List<Season> listSeasons() {
		return new LinkedList<>();
	}

	@Override
	public void addSeason(Season season) {
		MySQLConnect conexion = new MySQLConnect();
		try {
			conexion.getConnection().createStatement().execute(SQLParser.insertSeasonSQL(season));
			conexion.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Season getSeason(long codSeason) {
		MySQLConnect conexion = new MySQLConnect();
		Season season = null;
		try {
			Connection con = conexion.getConnection();
			ResultSet res = con.prepareStatement(SQLParser.getSeasonSQL(codSeason)).executeQuery();
			while (res.next())
				season = SQLParser.extractSeasonFromSQL(res);
			res.close();
			conexion.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return season;
	}

	@Override
	public void updateSeason(Season season) {
		MySQLConnect conexion = new MySQLConnect();
		try {
			conexion.getConnection().createStatement().execute(SQLParser.updateSeasonSQL(season));
			conexion.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeSeason(Season season) {
		MySQLConnect conexion = new MySQLConnect();
		try {
			conexion.getConnection().createStatement().execute(SQLParser.deleteSeasonSQL(season.getCodSeason()));
			conexion.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------

	@Override
	public List<Episode> listEpisodes() {
		return new LinkedList<>();
	}

	@Override
	public void addEpisode(Episode episode) {
		MySQLConnect conexion = new MySQLConnect();
		try {
			conexion.getConnection().createStatement().execute(SQLParser.insertEpisodeSQL(episode));
			conexion.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Episode getEpisode(long codEpisode) {
		MySQLConnect conexion = new MySQLConnect();
		Episode episode = null;
		try {
			ResultSet res = conexion.getConnection().prepareStatement(SQLParser.getEpisodeSQL(codEpisode)).executeQuery();
			while (res.next())
				episode = SQLParser.extractEpisodeFromSQL(res);
			res.close();
			conexion.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return episode;
	}

	@Override
	public void updateEpisode(Episode episode) {
		MySQLConnect conexion = new MySQLConnect();
		try {
			conexion.getConnection().createStatement().execute(SQLParser.updateEpisodeSQL(episode));
			conexion.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeEpisode(Episode episode) {
		MySQLConnect conexion = new MySQLConnect();
		try {
			conexion.getConnection().createStatement().execute(SQLParser.deleteEpisodeSQL(episode.getCodEpisode()));
			conexion.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
