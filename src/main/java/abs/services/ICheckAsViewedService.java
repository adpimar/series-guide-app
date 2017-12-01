package abs.services;

public interface ICheckAsViewedService {

	void checkEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber);

	void uncheckEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber);
	
	void setEpisodeComment(long idSerie, int seasonNumber, int episodeNumber, String comment);

	void checkSeasonAsViewed(long idSerie, int seasonNumber);

	void uncheckSeasonAsViewed(long idSerie, int seasonNumber);
	
}
