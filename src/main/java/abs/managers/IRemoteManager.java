package abs.managers;

import java.util.List;

import impl.model.Season;
import impl.model.Serie;

public interface IRemoteManager {

	List<Serie> searchRemoteSeries(String pattern);
	
	Serie getRemoteSerie(long codSerie);
	
	Season getRemoteSeason(long codSerie, int airedSeason);
	
}
