package abs.services;

import abs.managers.ISetLocalManager;
import abs.managers.ISetRemoteManager;
import impl.model.Season;
import impl.model.Serie;

public interface IDownloadAndStoreService extends ISetLocalManager, ISetRemoteManager {

	Serie downloadRemoteSerie(long codSerie);

	Season downloadRemoteSeason(long codSerie, int airedSeason);
	
	int storeRemoteSerie(Serie remoteSerie);

	int storeRemoteSeason(Serie serie, Season remoteSeason);
	
}
