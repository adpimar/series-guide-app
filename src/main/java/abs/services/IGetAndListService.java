package abs.services;

import java.util.List;

import abs.ISetLocalManager;
import abs.ISetRemoteManager;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public interface IGetAndListService extends ISetLocalManager, ISetRemoteManager {
	
	List<String> listSeriesNames() throws NoSeriesStoredException;
	
	String[] listSerieSeasonsNamesOrderedByAired(long codSerie);
	
	String[] listSerieSeasonEpisodesNamesOrderedByAired(long codSerie, int airedSeason) throws NoSeriesStoredException, NoSeasonsStoredException;

	Serie getSerie(long codSerie) throws NoSeriesStoredException;
	
	Season getSeason(long codSerie, int airedSeason);
	
	Episode getEpisode(long codSerie, int airedSeason, int airedEpisode);

	Serie getRemoteSerie(long idSerie, int airedSeason);

	Serie getRemoteSeason(long idSerie, int airedSeason);

}
