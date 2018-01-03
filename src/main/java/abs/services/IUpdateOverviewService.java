package abs.services;

import abs.ISetLocalManager;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongOverviewException;
import impl.model.Episode;
import impl.model.Serie;

public interface IUpdateOverviewService extends ISetLocalManager {

	Serie updateSerieOverview(long codSerie, String newOverview)
			throws NoSeriesStoredException, TooLongOverviewException;

	Episode updateEpisodeOverview(long codSerie, int airedSeason, int airedEpisode, String newOverview)
			throws TooLongOverviewException, NoEpisodesStoredException, NoSeriesStoredException,
			NoSeasonsStoredException;

}
