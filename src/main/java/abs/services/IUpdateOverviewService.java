package abs.services;

import abs.managers.ISetLocalManager;
import impl.model.Episode;
import impl.model.Serie;

public interface IUpdateOverviewService extends ISetLocalManager {

	Serie updateSerieOverview(long codSerie, String newOverview);
	
	Episode updateEpisodeOverview(long codSerie, int airedSeason, int airedEpisode, String newOverview);

}
