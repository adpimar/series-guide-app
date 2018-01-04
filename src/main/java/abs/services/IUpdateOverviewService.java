package abs.services;

import abs.ISetLocalManager;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongOverviewException;
import impl.model.Episode;
import impl.model.Serie;

public interface IUpdateOverviewService extends ISetLocalManager {

	Serie updateSerieOverview(long codSerie, String newOverview);
	
	Episode updateEpisodeOverview(long codSerie, int airedSeason, int airedEpisode, String newOverview);

}
