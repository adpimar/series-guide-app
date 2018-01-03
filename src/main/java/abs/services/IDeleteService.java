package abs.services;

import abs.ISetLocalManager;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;

public interface IDeleteService extends ISetLocalManager {

	void deleteSeason(long codSerie, int airedSeason) throws NoSeriesStoredException, NoSeasonsStoredException;

	void deleteSerie(long codSerie) throws NoSeriesStoredException;

}
