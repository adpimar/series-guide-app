package abs.services;

public interface IUpdateOverviewService {

	void updateSerieOverview(long idSerie, String newOverview);

	void updateEpisodeOverview(long idSerie, int seasonNumber, int episodeNumber, String newOverview);

}
