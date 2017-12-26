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
			throw new NoSuchElementException("No existen series.");
		
		List<String> localSeriesList = new LinkedList<>();		
		for (Serie serie : localSeries)
			localSeriesList.add(serie.getTitulo());	
		return localSeriesList;
	}

	@Override
	public String getInfoSerie(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRemoteSerie(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season getRemoteSeason(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
