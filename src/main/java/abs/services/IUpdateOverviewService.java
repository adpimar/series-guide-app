package abs.services;

import abs.ISetLocalManager;
import impl.model.Episode;
import impl.model.Serie;

public interface IUpdateOverviewService extends ISetLocalManager {
	
	Serie updateSerieOverview(long idSerie, String newOverview);

	Episode updateEpisodeOverview(long idSerie, int seasonNumber, int episodeNumber, String newOverview);

}
