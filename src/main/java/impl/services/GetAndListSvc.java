package impl.services;

import java.util.LinkedList;
import java.util.List;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.IGetAndListService;
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
	public String[] listSerieSeasonsNamesOrderedByAired(long codSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] listSerieSeasonEpisodesNamesOrderedByAired(long codSerie, int airedSeason) {
		// TODO Auto-generated method stub
		return null;
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
	public Episode getEpisode(long codSerie, int airedSeason, int airedEpisode) {
		// TODO Auto-generated method stub
		return null;
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
