package abs;

import java.util.List;

import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public interface ILocalManager {

	List<Serie> listSeries();
		
	Serie getSerie(long codSerie);
	
	void updateSerie(Serie serie);
			
	void removeSerie(Serie serie);
	
	// -----------------------------------------------------------------------------

	List<Season> listSeasons();
		
	Season getSeason(long codSeason);
	
	void updateSeason(Season season);
	
	void removeSeason(Season season);
				
	// -----------------------------------------------------------------------------
	
	List<Episode> listEpisodes();
		
	Episode getEpisode(long codEpisode);
			
	void updateEpisode(Episode episode);
		
	void removeEpisode(Episode episode);
	
}
