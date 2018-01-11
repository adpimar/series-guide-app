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

	protected MySQLConnect mySQLConnect;

	public SeriesDAO() {
		mySQLConnect = MySQLConnect.getMySQLConnect();
	}

	@Override
	public List<Serie> listSeries() {
		List<Serie> misSeries = new ArrayList<>();
		try {
			ResultSet res = mySQLConnect.getConnection().prepareStatement(SQLParser.listSeriesSQL()).executeQuery();
			while (res.next())
				misSeries.add(SQLParser.extractSerieFromSQL(res));
			res.close();
			mySQLConnect.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return misSeries;
	}

	@Override
	public void addSerie(Serie serie) {
		try {
			mySQLConnect.getConnection().createStatement().execute(SQLParser.insertSerieSQL(serie));
			mySQLConnect.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Serie getSerie(long codSerie) {
		Serie serie = null;
		ResultSet res;
		try {
			Connection con = mySQLConnect.getConnection();

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
			mySQLConnect.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serie;
	}

	@Override
	public void updateSerie(Serie serie) {
		String a = null;
		try {
			mySQLConnect.getConnection().createStatement().execute(a = SQLParser.updateSerieSQL(serie));
			mySQLConnect.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(a);
		}
	}

	@Override
	public void removeSerie(Serie serie) {
		try {
			mySQLConnect.getConnection().createStatement().execute(SQLParser.deleteSerieSQL(serie.getCodSerie()));
			mySQLConnect.disconnect();
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
		try {
			mySQLConnect.getConnection().createStatement().execute(SQLParser.insertSeasonSQL(season));
			mySQLConnect.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Season getSeason(long codSeason) {
		Season season = null;
		try {
			Connection con = mySQLConnect.getConnection();
			ResultSet res = con.prepareStatement(SQLParser.getSeasonSQL(codSeason)).executeQuery();
			while (res.next())
				season = SQLParser.extractSeasonFromSQL(res);
			res.close();
			mySQLConnect.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return season;
	}

	@Override
	public void updateSeason(Season season) {
		try {
			mySQLConnect.getConnection().createStatement().execute(SQLParser.updateSeasonSQL(season));
			mySQLConnect.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeSeason(Season season) {
		try {
			mySQLConnect.getConnection().createStatement().execute(SQLParser.deleteSeasonSQL(season.getCodSeason()));
			mySQLConnect.disconnect();
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
		try {
			mySQLConnect.getConnection().createStatement().execute(SQLParser.insertEpisodeSQL(episode));
			mySQLConnect.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Episode getEpisode(long codEpisode) {
		Episode episode = null;
		try {
			ResultSet res = mySQLConnect.getConnection().prepareStatement(SQLParser.getEpisodeSQL(codEpisode)).executeQuery();
			while (res.next())
				episode = SQLParser.extractEpisodeFromSQL(res);
			res.close();
			mySQLConnect.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return episode;
	}

	@Override
	public void updateEpisode(Episode episode) {
		try {
			mySQLConnect.getConnection().createStatement().execute(SQLParser.updateEpisodeSQL(episode));
			mySQLConnect.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeEpisode(Episode episode) {
		try {
			mySQLConnect.getConnection().createStatement().execute(SQLParser.deleteEpisodeSQL(episode.getCodEpisode()));
			mySQLConnect.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
