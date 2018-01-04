package abs.services;

import abs.ISetLocalManager;

public interface IDeleteService extends ISetLocalManager {

	void deleteSeason(long codSerie, int airedSeason);

	void deleteSerie(long codSerie);

}
