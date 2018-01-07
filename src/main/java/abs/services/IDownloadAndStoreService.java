package abs.services;

import abs.managers.ISetLocalManager;
import abs.managers.ISetRemoteManager;
import impl.model.Season;
import impl.model.Serie;

public interface IDownloadAndStoreService extends ISetLocalManager, ISetRemoteManager {

	Serie downloadRemoteSerie(long codSerie);

	Season downloadRemoteSeason(long codSerie, int airedSeason);
	
	void storeRemoteSerie(Serie remoteSerie);

	void storeRemoteSeason(Season remoteSeason);
	
}
