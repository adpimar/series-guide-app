package abs;

import java.util.List;

import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public interface ILocalManager {

	List<Serie> listSeries();
	
	Serie getSerie(long codSerie);
	
	void addSerie(Serie serie);
	
	void updateSerie(Serie serie);
			
	void removeSerie(Serie serie);
	
	// -----------------------------------------------------------------------------

	List<Season> listSeasons();
		
	Season getSeason(long codSeason);
	
	void addSeason(Season season);
	
	void updateSeason(Season season);
	
	void removeSeason(Season season);
				
	// -----------------------------------------------------------------------------
	
	List<Episode> listEpisodes();
		
	Episode getEpisode(long codEpisode);
	
	void addEpisode(Episode episode);
			
	void updateEpisode(Episode episode);
		
	void removeEpisode(Episode episode);
	
}
