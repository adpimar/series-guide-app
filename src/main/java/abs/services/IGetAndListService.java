package abs.services;

import java.util.List;

import abs.managers.ISetLocalManager;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public interface IGetAndListService extends ISetLocalManager {
	
	List<String> listSeriesNames();
		
	String[] listSerieSeasonsEpisodesNames(long codSerie, int airedSeason);

	Serie getSerie(long codSerie);
	
	Season getSeason(long codSerie, int airedSeason);
	
	Episode getEpisode(long codSerie, int airedSeason, int airedEpisode);

}
