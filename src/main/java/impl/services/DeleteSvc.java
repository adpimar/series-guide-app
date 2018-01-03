package impl.services;

import abs.ILocalManager;
import abs.services.IDeleteService;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Season;
import impl.model.Serie;

public class DeleteSvc implements IDeleteService {

	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public void deleteSeason(long codSerie, int airedSeason) 
			throws NoSeriesStoredException, NoSeasonsStoredException 
	{	
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();	
		
		// Comprueba existe temporada
		Season season = serie.getSeasonByAired(airedSeason);
		if (season == null)
			throw new NoSeasonsStoredException();

		// Borra temporada
		serie.getSeasons().remove(season);
		localManager.removeSeason(season);
	}

	@Override
	public void deleteSerie(long codSerie) 
			throws NoSeriesStoredException 
	{	
		// Comprueba existe serie
		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();
		
		// Borra serie
		localManager.removeSerie(serie);
	}

}
