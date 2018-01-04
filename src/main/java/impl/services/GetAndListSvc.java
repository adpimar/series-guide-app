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
	public List<String> listSeriesNames() 
			throws NoSeriesStoredException 
	{
		// Comprueba existen series
		List<Serie> series = localManager.listSeries();
		if (series.isEmpty())
			throw new NoSeriesStoredException();

		// Crea lista nombres series
		List<String> seriesNames = new LinkedList<>();
		for (Serie serie : localManager.listSeries())
			seriesNames.add(serie.getSeriesName());
		
		return seriesNames;
	}

	@Override
	public String[] listSerieSeasonEpisodesNamesOrderedByAired(long codSerie, int airedSeason) {
		
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();	
		
		// Comprueba existe temporada
		Season season = serie.getSeasonByAired(airedSeason);
		if (season == null)
			throw new NoSeasonsStoredException();
		
		// Crea vector episodios ordenados
		String[] episodesNames = new String[season.getTotalEpisodes()];
		for (Episode episode : season.getEpisodes())
			episodesNames[episode.getAiredEpisode() - 1] = episode.getEpisodeName();
		
		return episodesNames;
	}

	@Override
	public Serie getSerie(long codSerie) {
		
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();

		return serie;
	}

	@Override
	public Season getSeason(long codSerie, int airedSeason) {
		
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();
		
		// Comprueba existe temporada
		Season season = serie.getSeasonByAired(airedSeason);
		if (season == null)
			throw new NoSeasonsStoredException();
		
		return season;
	}

	@Override
	public Episode getEpisode(long codSerie, int airedSeason, int airedEpisode) {
		
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();	
		
		// Comprueba existe temporada
		Season season = serie.getSeasonByAired(airedSeason);
		if (season == null)
			throw new NoSeasonsStoredException();
		
		// Comprueba existe episodio
		Episode episode = season.getEpisodeByAired(airedEpisode);
		if (episode == null)
			throw new NoEpisodesStoredException();
		
		return episode;
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
	
}
