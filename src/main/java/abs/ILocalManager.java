package abs;

import java.util.List;

import impl.Episode;
import impl.Season;
import impl.Serie;

public interface ILocalManager {

	List<String> searchSeries(String pattern);
	
	List<Serie> listSeries();
	
	List<Season> listSerieSeasons(long codSerie);

	List<Episode> listSerieEpisodes(long codSerie);
	
	List<Episode> listSerieSeasonEpisodes(long codSerie, int airedSeason);
	
	Serie getSerie(long codSerie);
	
	Season getSerieSeason(long codSerie, int airedSeason);
	
	Episode getSerieEpisode(long codEpisode);
	
	Episode getSerieSeasonEpisode(long codSerie, int airedSeason, int airedEpisode);
	
}
