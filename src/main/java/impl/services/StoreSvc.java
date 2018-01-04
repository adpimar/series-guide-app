package impl.services;

import abs.ILocalManager;
import abs.services.IStoreService;
import impl.model.RemoteSerie;
import impl.model.Season;
import impl.model.Serie;

public class StoreSvc implements IStoreService {

	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public Serie storeRemoteSerie(RemoteSerie remoteSerie) {
		
		// Comprueba si existe serie en BDL
		Serie serie = localManager.getSerie(remoteSerie.getId());
		
		// Almacena serie en BDL si no existe
		if (serie == null) {
			serie = remoteSerie.getSerie();
			localManager.addSerie(serie);
		}
		
		return serie;
	}

	@Override
	public void storeRemoteSeason(Serie serie, Season remoteSeason) {
		// TODO Auto-generated method stub

	}

}
