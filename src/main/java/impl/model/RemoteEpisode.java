package impl.model;

public class RemoteEpisode {

	private int absoluteNumber;
	private int airedEpisodeNumber;
	private int airedSeason;
	private long airedSeasonID;
	private int dvdEpisodeNumber;
	private int dvdSeason;
	private String episodeName;
	private String firstAired;
	private long id;
	private String language;
	private long lastUpdated;
	private String overview;

	public Episode getEpisode() {
		Episode episode = new Episode();
		
		episode.setCodEpisode(id);
		episode.setCodSeason(airedSeasonID);
		episode.setAiredSeason(airedSeason);
		episode.setAiredEpisode(airedEpisodeNumber);
		episode.setEpisodeName(episodeName);
		episode.setEpisodeName(episodeName);
		episode.setFirstAired(firstAired);
		episode.setOverview(overview);
		episode.setSeen(false);
		episode.setComment(null);
		
		return episode;
	}
	
	public int getAbsoluteNumber() {
		return absoluteNumber;
	}

	public int getAiredEpisodeNumber() {
		return airedEpisodeNumber;
	}

	public int getAiredSeason() {
		return airedSeason;
	}

	public long getAiredSeasonID() {
		return airedSeasonID;
	}

	public int getDvdEpisodeNumber() {
		return dvdEpisodeNumber;
	}

	public int getDvdSeason() {
		return dvdSeason;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public String getFirstAired() {
		return firstAired;
	}

	public long getId() {
		return id;
	}

	public String getLanguage() {
		return language;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public String getOverview() {
		return overview;
	}

	public void setAbsoluteNumber(int absoluteNumber) {
		this.absoluteNumber = absoluteNumber;
	}

	public void setAiredEpisodeNumber(int airedEpisodeNumber) {
		this.airedEpisodeNumber = airedEpisodeNumber;
	}

	public void setAiredSeason(int airedSeason) {
		this.airedSeason = airedSeason;
	}

	public void setAiredSeasonID(long airedSeasonID) {
		this.airedSeasonID = airedSeasonID;
	}

	public void setDvdEpisodeNumber(int dvdEpisodeNumber) {
		this.dvdEpisodeNumber = dvdEpisodeNumber;
	}

	public void setDvdSeason(int dvdSeason) {
		this.dvdSeason = dvdSeason;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

}
