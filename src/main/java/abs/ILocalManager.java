package abs;

import java.util.List;

import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public interface ILocalManager {

	List<Serie> listSeries();

	List<Season> listSeasons();

	List<Episode> listEpisodes();

	Serie getSerie(long codSerie);

	Season getSeason(long codSeason);

	Episode getEpisode(long codEpisode);

	Serie updateSerie(Serie serie);

	Season updateSeason(Season season);

	Episode updateEpisode(Episode episode);

	boolean removeSerie(Serie serie);

	boolean removeSeason(Season season);

	boolean removeEpisode(Episode episode);

}
