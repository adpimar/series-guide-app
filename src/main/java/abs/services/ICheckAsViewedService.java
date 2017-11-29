package abs.services;

public interface ICheckAsViewedService {

	void checkEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber);

	void setEpisodeComment(long idSerie, int seasonNumber, int episodeNumber, String comment);

	void uncheckEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber);

}
