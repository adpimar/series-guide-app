package impl.services;

import abs.managers.ILocalManager;
import abs.services.ICheckAsViewedService;
import impl.exceptions.NoEpisodeCheckedAsViewedException;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongCommentException;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class CheckAsViewedSvc implements ICheckAsViewedService {

	private static final int LIMITE_CARACTERES_COMENTARIO = 150;
	
	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public Episode checkEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode) {
		
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();	
		
		// Comprueba existe temporada
		Season season = serie.getSeasonByAired(airedSeason);
		if (season == null)
			throw new NoSeasonsStoredException();
		
		// Comprueba existe episodio
		Episode episode = season.getEpisodes()[airedEpisode - 1];
		if (episode == null)
			throw new NoEpisodesStoredException();
		
		// Comprueba si mismo estado episodio
		if (episode.isSeen())
			return episode;
		
		// Modifica episodio
		episode.setSeen(true);
		
		// Almacena modificaciones
		localManager.updateEpisode(episode);
		
		// Comprueba si todos episodios vistos
		if (season.checkSeasonSeen())
			localManager.updateSeason(season);

		return episode;	
	}

	@Override
	public Episode uncheckEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode) {
		
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();	
		
		// Comprueba existe temporada
		Season season = serie.getSeasonByAired(airedSeason);
		if (season == null)
			throw new NoSeasonsStoredException();
		
		// Comprueba existe episodio
		Episode episode = season.getEpisodes()[airedEpisode - 1];
		if (episode == null)
			throw new NoEpisodesStoredException();
		
		// Comprueba si mismo estado episodio
		if (!episode.isSeen())
			return episode;
		
		// Modifica episodio
		episode.setSeen(false);
		episode.setComment(null);
		
		// Almacena modificaciones
		localManager.updateEpisode(episode);
		
		// Comprueba si todos episodios vistos
		if (season.checkSeasonSeen())
			localManager.updateSeason(season);

		return episode;	
	}

	@Override
	public Episode commentEpisodeViewed(long codSerie, int airedSeason, int airedEpisode, String comment) {
		
		// Comprueba comentario no excede limite caracteres
		if (comment.length() > LIMITE_CARACTERES_COMENTARIO)
			throw new TooLongCommentException();
		
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();	
		
		// Comprueba existe temporada
		Season season = serie.getSeasonByAired(airedSeason);
		if (season == null)
			throw new NoSeasonsStoredException();
		
		// Comprueba existe episodio
		Episode episode = season.getEpisodes()[airedEpisode - 1];
		if (episode == null)
			throw new NoEpisodesStoredException();
		
		// Comprueba episodio visto
		if (!episode.isSeen())
			throw new NoEpisodeCheckedAsViewedException();
		
		// Modifica episodio
		episode.setComment(comment);
		
		// Almacena modificaciones
		localManager.updateEpisode(episode);
		
		return episode;	
	}

	@Override
	public Season checkSeasonAsViewed(long codSerie, int airedSeason) {
		
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();	
		
		// Comprueba existe temporada
		Season season = serie.getSeasonByAired(airedSeason);
		if (season == null)
			throw new NoSeasonsStoredException();

		// Comprueba tiene todos episodios
		Episode[] episodes = season.getEpisodes();
		if (episodes.length < season.getTotalEpisodes())
			throw new NoEpisodesStoredException();
		for (int i = 0; i < season.getTotalEpisodes(); i++)
			if (episodes[i] == null)
				throw new NoEpisodesStoredException();
		
		// Comprueba temporada vista
		if (season.isSeen())
			return season;
		
		// Modifica temporada
		season.setSeen(true);
		
		// Almacena modificaciones
		localManager.updateSeason(season);
		
		// Modifica episodios
		for (Episode episode : season.getEpisodes()) {
			episode.setSeen(true);
			localManager.updateEpisode(episode);
		}
		
		return season;	
	}

	@Override
	public Season uncheckSeasonAsViewed(long codSerie, int airedSeason) {
		
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();	
		
		// Comprueba existe temporada
		Season season = serie.getSeasonByAired(airedSeason);
		if (season == null)
			throw new NoSeasonsStoredException();
		
		// Comprueba tiene todos episodios
		Episode[] episodes = season.getEpisodes();
		if (episodes.length < season.getTotalEpisodes())
			throw new NoEpisodesStoredException();
		for (int i = 0; i < season.getTotalEpisodes(); i++)
			if (episodes[i] == null)
				throw new NoEpisodesStoredException();
		
		// Modifica temporada
		season.setSeen(false);
		
		// Almacena modificaciones
		localManager.updateSeason(season);
		
		// Modifica episodios
		for (Episode episode : season.getEpisodes()) {
			episode.setSeen(false);
			localManager.updateEpisode(episode);
		}
		
		return season;
	}
	
}
