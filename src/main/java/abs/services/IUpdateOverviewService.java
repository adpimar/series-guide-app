package abs.services;

import abs.ILocalManager;
import impl.Serie;

public interface IUpdateOverviewService {

	void setLocalManager(ILocalManager localManager);
	
	Serie updateSerieOverview(long idSerie, String newOverview);

	void updateEpisodeOverview(long idSerie, int seasonNumber, int episodeNumber, String newOverview);

}
