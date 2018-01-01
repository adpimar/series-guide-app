package abs.services;

import abs.ISetLocalManager;
import abs.ISetRemoteManager;

public interface IDeleteService extends ISetLocalManager, ISetRemoteManager {

	void deleteSeason(long idSerie, int seasonNumber);

	void deleteSerie(long idSerie);

}
