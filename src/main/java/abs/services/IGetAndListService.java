package abs.services;

import java.util.List;

import abs.ISetLocalManager;
import abs.ISetRemoteManager;
import impl.Season;
import impl.Serie;

public interface IGetAndListService extends ISetLocalManager, ISetRemoteManager {
	
	List<String> listSeriesNames();
	
	List<String> listSerieSeasonsNames(long codSerie);
	
	String[] listSerieSeasonsEpisodesNames(long codSerie, int airedSeason);

	Serie getInfoSerie(long id);

	Serie getRemoteSerie(long idSerie, int seasonNumber);

	Season getRemoteSeason(long idSerie, int seasonNumber);

}
