package abs.services;

import abs.ISetLocalManager;
import abs.ISetRemoteManager;
import impl.model.Season;
import impl.model.Serie;

public interface IStoreService extends ISetLocalManager, ISetRemoteManager {

	void storeRemoteSerie(Serie remoteSerie);

	void storeRemoteSeason(Serie serie, Season remoteSeason);
	
}
