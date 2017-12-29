package impl.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.IGetAndListService;
import impl.Episode;
import impl.Season;
import impl.Serie;

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
	public List<String> listSeriesNames() {
		List<Serie> localSeries = localManager.listSeries();
		
		if (localSeries.isEmpty())
			throw new NoSuchElementException("No existen series en la BDL.");
		
		List<String> localSeriesList = new LinkedList<>();		
		for (Serie serie : localSeries)
			localSeriesList.add(serie.getSeriesName());	
		return localSeriesList;
	}
	
	@Override
	public List<String> listSerieSeasonsNames(long codSerie) {
		return null;
	}
	
	@Override
	public String[] listSerieSeasonsEpisodesNames(long codSerie, int airedSeason) {
		List<Episode> listSerieSeasonEpisodes = localManager.listSerieSeasonEpisodes(codSerie, airedSeason);
		String[] listSerieSeasonEpisodesNames = new String[listSerieSeasonEpisodes.size()];
		for (Episode e : listSerieSeasonEpisodes)
			listSerieSeasonEpisodesNames[e.getAiredEpisode()-1] = e.getEpisodeName();
		return listSerieSeasonEpisodesNames;
	}

	@Override
	public Serie getInfoSerie(long id) {
		Serie serie = localManager.getSerie(id);
		
		if (serie == null)
			throw new NoSuchElementException("No existe la serie con id " + id + " en la BDL.");
		
		return serie;
	}

	@Override
	public Serie getRemoteSerie(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season getRemoteSeason(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
