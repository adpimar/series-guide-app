package impl.services;

import java.util.Arrays;

import abs.managers.ILocalManager;
import abs.managers.IRemoteManager;
import abs.services.IDownloadAndStoreService;
import impl.model.Episode;
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
		return remoteManager.getRemoteSerie(codSerie);	
	}

	@Override
	public int storeRemoteSerie(Serie remoteSerie) {
		
		// 0 = No almacenada; 1 = Almacenada; 2 = Actualizada
		
		// Comprueba si existe serie en BDL
		Serie localSerie = localManager.getSerie(remoteSerie.getCodSerie());

		// Almacena serie en BDL si no existe
		if (localSerie == null) {
			localManager.addSerie(remoteSerie);
			return 1;
		}
		
		// Actualiza serie en BDL si es necesario
		if (!localSerie.equals(remoteSerie)) {
			localManager.addSerie(remoteSerie);
			return 2;
		}
		
		return 0;
	}

	@Override
	public Season downloadRemoteSeason(long codSerie, int airedSeason) {
		return remoteManager.getRemoteSeason(codSerie, airedSeason);
	}
	
	@Override
	public int storeRemoteSeason(Serie serie, Season remoteSeason) {
		
		// 0 = No almacenada; 1 = Almacenada; 2 = Actualizada
		
		// Comprueba si existe temporada en BDL
		Season localSeason = localManager.getSeason(remoteSeason.getCodSeason());

		// Almacena temporada en BDL si no existe
		if (localSeason == null) {
			localManager.addSeason(remoteSeason);
			return 1;
		}
		
		// Actualiza temporada en BDL si es necesario
		if (checkIfSeasonNeedToUpdate(localSeason, remoteSeason)) {
			localManager.addSeason(remoteSeason);
			return 2;
		}
		
		return 0;
	}
	
	private boolean checkIfSeasonNeedToUpdate(Season localSeason, Season remoteSeason) {
		if (!localSeason.equals(remoteSeason))
			return true;
		
		Episode[] localEpisodes = localSeason.getEpisodes();
		Episode[] remoteEpisodes = remoteSeason.getEpisodes();
		
		return Arrays.equals(localEpisodes, remoteEpisodes);		
	}

}
