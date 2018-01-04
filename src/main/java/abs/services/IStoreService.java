package abs.services;

import abs.ISetLocalManager;
import impl.model.RemoteSerie;
import impl.model.Season;
import impl.model.Serie;

public interface IStoreService extends ISetLocalManager {

	Serie storeRemoteSerie(RemoteSerie remoteSerie);

	void storeRemoteSeason(Serie serie, Season remoteSeason);
	
}
