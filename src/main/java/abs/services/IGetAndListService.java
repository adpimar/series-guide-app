package abs.services;

import java.util.List;

import abs.ILocalManager;
import abs.IRemoteManager;
import impl.Season;
import impl.Serie;

public interface IGetAndListService {

	void setLocalManager(ILocalManager localManager);
	
	void setRemoteManager(IRemoteManager remoteManager);
	
	List<String> listSeries();

	Serie getInfoSerie(long id);

	Serie getRemoteSerie(long idSerie, int seasonNumber);

	Season getRemoteSeason(long idSerie, int seasonNumber);

}
