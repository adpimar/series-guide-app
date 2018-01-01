package abs.services;

import abs.ISetLocalManager;
import abs.ISetRemoteManager;

public interface IDeleteService extends ISetLocalManager, ISetRemoteManager {

	void deleteSeason(long codSerie, int airedSeason);

	void deleteSerie(long codSerie);

}
