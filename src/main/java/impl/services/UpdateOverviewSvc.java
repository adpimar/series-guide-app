package impl.services;

import abs.ILocalManager;
import abs.services.IUpdateOverviewService;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongOverviewException;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class UpdateOverviewSvc implements IUpdateOverviewService {

	private static final int LIMITE_CARACTERES_SINOPSIS = 500;

	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public Serie updateSerieOverview(long codSerie, String newOverview)
			throws NoSeriesStoredException, TooLongOverviewException 
	{
		// Comprueba sinopsis no excede limite caracteres
		if (newOverview.length() > LIMITE_CARACTERES_SINOPSIS)
			throw new TooLongOverviewException();

		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();
		
		// Modifica sinopsis
		serie.setOverview(newOverview);
		
		// Almacena modificaciones
		localManager.updateSerie(serie);
		
		return serie;
	}

	@Override
	public Episode updateEpisodeOverview(long codSerie, int airedSeason, int airedEpisode, String newOverview) 
			throws TooLongOverviewException, NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException 
	{		
		// Comprueba sinopsis no excede limite caracteres
		if (newOverview.length() > LIMITE_CARACTERES_SINOPSIS)
			throw new TooLongOverviewException();

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
		
		// Modifica sinopsis
		episode.setOverview(newOverview);
		
		// Almacena modificaciones
		localManager.updateEpisode(episode);
		
		return episode;
	}

}
