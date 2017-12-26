package abs.services;

import java.util.List;

import abs.ILocalManager;
import abs.IRemoteManager;
import impl.Season;

public interface IGetAndListService {

	void setLocalManager(ILocalManager remoteManager);
	
	void setRemoteManager(IRemoteManager localManager);
	
	List<String> listSeries();

	String getInfoSerie(long id);

	String getRemoteSerie(long idSerie, int seasonNumber);

	Season getRemoteSeason(long idSerie, int seasonNumber);

}
