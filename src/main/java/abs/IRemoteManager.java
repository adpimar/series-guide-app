package abs;

import java.util.List;
import java.util.Map;

import impl.model.RemoteSerie;

public interface IRemoteManager {

	List<RemoteSerie> searchSeries(String pattern);
	
	RemoteSerie getSerie(long codSerie);
	
	Map<String, String> getSeason(long codSeason);
	
}
