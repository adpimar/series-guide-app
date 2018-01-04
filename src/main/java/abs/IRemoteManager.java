package abs;

import java.util.List;
import java.util.Map;

import impl.model.RemoteSearchSerie;
import impl.model.RemoteSerie;

public interface IRemoteManager {

	List<RemoteSearchSerie> searchSeries(String pattern);
	
	RemoteSerie getSerie(long codSerie);
	
	Map<String, String> getSeason(long codSeason);
	
}
