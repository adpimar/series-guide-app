package abs.services;

import abs.ISetLocalManager;
import abs.ISetRemoteManager;
import impl.model.Episode;
import impl.model.Season;

public interface ICheckAsViewedService extends ISetLocalManager, ISetRemoteManager {

	Episode checkEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber);

	Episode uncheckEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber);
	
	Episode commentEpisodeViewed(long idSerie, int seasonNumber, int episodeNumber, String comment);

	Season checkSeasonAsViewed(long idSerie, int seasonNumber);

	Season uncheckSeasonAsViewed(long idSerie, int seasonNumber);
	
}
