package abs;

import java.util.List;

import impl.model.RemoteEpisode;
import impl.model.RemoteSearchSerie;
import impl.model.RemoteSerie;

public interface IRemoteManager {

	List<RemoteSearchSerie> searchRemoteSeries(String pattern);
	
	RemoteSerie getRemoteSerie(long codSerie);
	
	RemoteEpisode[] getRemoteSeason(long codSerie, int airedSeason);
	
}
