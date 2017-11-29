package abs.services;

import impl.Season;
import impl.Serie;

public interface IStoreService {

	void storeRemoteSerie(Serie remoteSerie);

	void storeRemoteSeason(Serie serie, Season remoteSeason);
	
}
