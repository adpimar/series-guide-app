package abs.services;

import abs.ISetLocalManager;
import impl.Serie;

public interface IUpdateOverviewService extends ISetLocalManager {
	
	Serie updateSerieOverview(long idSerie, String newOverview);

	void updateEpisodeOverview(long idSerie, int seasonNumber, int episodeNumber, String newOverview);

}
