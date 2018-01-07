package impl.services;

import abs.managers.ILocalManager;
import abs.managers.IRemoteManager;
import abs.services.IDownloadAndStoreService;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.SeasonAlreadyStoredException;
import impl.exceptions.SerieAlreadyStoredException;
import impl.model.Season;
import impl.model.Serie;

public class DownloadAndStoreSvc implements IDownloadAndStoreService {

	private ILocalManager localManager;
	private IRemoteManager remoteManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}
	
	@Override
	public void setRemoteManager(IRemoteManager remoteManager) {
		this.remoteManager = remoteManager;
	}
	
	@Override
	public Serie downloadRemoteSerie(long codSerie) {
		
		// Comprueba si existe serie en BDL
		Serie localSerie = localManager.getSerie(codSerie);
		if (localSerie != null)
			return localSerie;
		
		return remoteManager.getRemoteSerie(codSerie);	
	}

	@Override
	public void storeRemoteSerie(Serie remoteSerie) {
				
		// Comprueba si existe serie en BDL
		Serie localSerie = localManager.getSerie(remoteSerie.getCodSerie());
		if (localSerie != null)
			throw new SerieAlreadyStoredException();
			
		// Almacena serie en BDL si no existe
		localManager.addSerie(remoteSerie);

	}

	@Override
	public Season downloadRemoteSeason(long codSerie, int airedSeason) {
		
		// Comprueba si existe la serie en BDL
		Serie localSerie = localManager.getSerie(codSerie);
		if (localSerie == null)
			throw new NoSeriesStoredException();
		
		// Comprueba si existe temporada en BDL
		Season localSeason	= localSerie.getSeasonByAired(airedSeason);
		if (localSeason != null)
			return localSeason;
		
		return remoteManager.getRemoteSeason(codSerie, airedSeason);
	}
	
	@Override
	public void storeRemoteSeason(Season remoteSeason) {
		
		// Comprueba si existe la serie en BDL
		Serie localSerie = localManager.getSerie(remoteSeason.getCodSerie());
		if (localSerie == null)
			throw new NoSeriesStoredException();
				
		// Comprueba si existe temporada en BDL
		Season localSeason = localManager.getSeason(remoteSeason.getCodSeason());
		if (localSeason != null)
			throw new SeasonAlreadyStoredException();
			
		// Almacena temporada en BDL si no existe
		localManager.addSeason(remoteSeason);

	}

}
