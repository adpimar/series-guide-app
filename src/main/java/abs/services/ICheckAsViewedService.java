package abs.services;

import abs.ISetLocalManager;
import impl.model.Episode;
import impl.model.Season;

public interface ICheckAsViewedService extends ISetLocalManager {

	Episode checkEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode);

	Episode uncheckEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode);
	
	Episode commentEpisodeViewed(long codSerie, int airedSeason, int airedEpisode, String comment);

	Season checkSeasonAsViewed(long codSerie, int airedSeason);

	Season uncheckSeasonAsViewed(long codSerie, int airedSeason);
	
}
