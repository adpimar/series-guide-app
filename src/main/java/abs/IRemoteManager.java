package abs;

import java.util.Map;

import impl.model.RemoteSerie;

public interface IRemoteManager {

	Map<Long, String> searchSeries(String pattern);
	
	RemoteSerie getSerie(long codSerie);
	
	Map<String, String> getSeason(long codSeason);
	
}
