package impl.services;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.IGetAndListService;
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
	public List<String> listSeries() {
		List<Serie> localSeries = localManager.listSeries();
		
		if (localSeries.isEmpty())
			throw new NoSuchElementException("No existen series en la BDL.");
		
		List<String> localSeriesList = new LinkedList<>();		
		for (Serie serie : localSeries)
			localSeriesList.add(serie.getTitulo());	
		return localSeriesList;
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
