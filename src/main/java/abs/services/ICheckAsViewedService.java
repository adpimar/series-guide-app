package abs.services;

import abs.ISetLocalManager;
import impl.exceptions.NoEpisodeCheckedAsViewedException;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongCommentException;
import impl.model.Episode;
import impl.model.Season;

public interface ICheckAsViewedService extends ISetLocalManager {

	Episode checkEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode) throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException;

	Episode uncheckEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode) throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException;
	
	Episode commentEpisodeViewed(long codSerie, int airedSeason, int airedEpisode, String comment) throws TooLongCommentException, NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException, NoEpisodeCheckedAsViewedException;

	Season checkSeasonAsViewed(long codSerie, int airedSeason) throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException;

	Season uncheckSeasonAsViewed(long codSerie, int airedSeason) throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException;
	
}
