package impl.services;

import java.util.LinkedList;
import java.util.List;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.IGetAndListService;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class GetAndListSvc implements IGetAndListService {

	private IRemoteManager remoteManager;
	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public void setRemoteManager(IRemoteManager remoteManager) {
		this.remoteManager = remoteManager;
	}

	@Override
	public List<String> listSeriesNames() throws NoSeriesStoredException {
		List<Serie> series = localManager.listSeries();

		if (series.isEmpty())
			throw new NoSeriesStoredException();

		List<String> seriesNames = new LinkedList<>();
		for (Serie serie : localManager.listSeries())
			seriesNames.add(serie.getSeriesName());
		return seriesNames;
	}

	@Override
	public String[] listSerieSeasonEpisodesNamesOrderedByAired(long codSerie, int airedSeason)
			throws NoSeriesStoredException, NoSeasonsStoredException {

		if (localManager.getSerie(codSerie) == null)
			throw new NoSeriesStoredException();

		Season season = getSerieSeasonByAiredSeason(codSerie, airedSeason);

		if (season == null)
			throw new NoSeasonsStoredException();

		List<Episode> episodes = listSerieSeasonEpisodes(season.getCodSeason());

		String[] episodesNames = new String[season.getTotalEpisodes()];
		for (Episode episode : episodes)
			episodesNames[episode.getAiredEpisode() - 1] = episode.getEpisodeName();

		return episodesNames;
	}

	@Override
	public Serie getSerie(long codSerie) throws NoSeriesStoredException {
		Serie serie = localManager.getSerie(codSerie);

		if (serie == null)
			throw new NoSeriesStoredException();

		return serie;
	}

	@Override
	public Season getSeason(long codSerie, int airedSeason) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode getEpisode(long codSerie, int airedSeason, int airedEpisode) 
			throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException {
		
		if (localManager.getSerie(codSerie) == null)
			throw new NoSeriesStoredException();

		Season season = getSerieSeasonByAiredSeason(codSerie, airedSeason);

		if (season == null)
			throw new NoSeasonsStoredException();
		
		for (Episode episode : localManager.listEpisodes())
			if (episode.getCodSeason() == season.getCodSeason() && episode.getAiredEpisode() == airedEpisode)
				return episode;
		
		throw new NoEpisodesStoredException();
	}

	@Override
	public Serie getRemoteSerie(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie getRemoteSeason(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	// -----------------------------------------------------------------------------

	private List<Season> listSerieSeasons(long codSerie) {
		List<Season> seasons = new LinkedList<>();
		for (Season season : localManager.listSeasons())
			if (season.getCodSerie() == codSerie)
				seasons.add(season);
		return seasons;
	}

	private Season getSerieSeasonByAiredSeason(long codSerie, int airedSeason) {
		for (Season season : localManager.listSeasons())
			if (season.getCodSerie() == codSerie && season.getAiredSeason() == airedSeason)
				return season;
		return null;
	}

	private List<Episode> listSerieSeasonEpisodes(long codSeason) {
		List<Episode> episodes = new LinkedList<>();
		for (Episode episode : localManager.listEpisodes())
			if (episode.getCodSeason() == codSeason)
				episodes.add(episode);
		return episodes;
	}

}
