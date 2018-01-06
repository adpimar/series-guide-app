package impl.managers.remote.thetvdb.jsonschemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"absoluteNumber", 
	"airedEpisodeNumber", 
	"airedSeason", 
	"airedSeasonID", 
	"dvdEpisodeNumber",
	"dvdSeason", 
	"episodeName", 
	"firstAired", 
	"id", 
	"language", 
	"lastUpdated", 
	"overview" })
public class QueryEpisode {

	@JsonProperty("absoluteNumber")
	private Long absoluteNumber;

	@JsonProperty("airedEpisodeNumber")
	private Integer airedEpisodeNumber;

	@JsonProperty("airedSeason")
	private Integer airedSeason;

	@JsonProperty("airedSeasonID")
	private Long airedSeasonID;

	@JsonProperty("dvdEpisodeNumber")
	private Integer dvdEpisodeNumber;

	@JsonProperty("dvdSeason")
	private Integer dvdSeason;

	@JsonProperty("episodeName")
	private String episodeName;

	@JsonProperty("firstAired")
	private String firstAired;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("language")
	private Language language;

	@JsonProperty("lastUpdated")
	private Long lastUpdated;

	@JsonProperty("overview")
	private String overview;
	
	// ------------------------------------------------------------------------

	@JsonProperty("absoluteNumber")
	public Long getAbsoluteNumber() {
		return absoluteNumber;
	}

	@JsonProperty("absoluteNumber")
	public void setAbsoluteNumber(Long absoluteNumber) {
		this.absoluteNumber = absoluteNumber;
	}

	// ------------------------------------------------------------------------
	
	@JsonProperty("airedEpisodeNumber")
	public Integer getAiredEpisodeNumber() {
		return airedEpisodeNumber;
	}

	@JsonProperty("airedEpisodeNumber")
	public void setAiredEpisodeNumber(Integer airedEpisodeNumber) {
		this.airedEpisodeNumber = airedEpisodeNumber;
	}
	
	// ------------------------------------------------------------------------

	@JsonProperty("airedSeason")
	public Integer getAiredSeason() {
		return airedSeason;
	}

	@JsonProperty("airedSeason")
	public void setAiredSeason(Integer airedSeason) {
		this.airedSeason = airedSeason;
	}

	// ------------------------------------------------------------------------
	
	@JsonProperty("airedSeasonID")
	public Long getAiredSeasonID() {
		return airedSeasonID;
	}

	@JsonProperty("airedSeasonID")
	public void setAiredSeasonID(Long airedSeasonID) {
		this.airedSeasonID = airedSeasonID;
	}

	// ------------------------------------------------------------------------
	
	@JsonProperty("dvdEpisodeNumber")
	public Integer getDvdEpisodeNumber() {
		return dvdEpisodeNumber;
	}

	@JsonProperty("dvdEpisodeNumber")
	public void setDvdEpisodeNumber(Integer dvdEpisodeNumber) {
		this.dvdEpisodeNumber = dvdEpisodeNumber;
	}

	// ------------------------------------------------------------------------
	
	@JsonProperty("dvdSeason")
	public Integer getDvdSeason() {
		return dvdSeason;
	}

	@JsonProperty("dvdSeason")
	public void setDvdSeason(Integer dvdSeason) {
		this.dvdSeason = dvdSeason;
	}

	// ------------------------------------------------------------------------
	
	@JsonProperty("episodeName")
	public String getEpisodeName() {
		return episodeName;
	}

	@JsonProperty("episodeName")
	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}
	
	// ------------------------------------------------------------------------

	@JsonProperty("firstAired")
	public String getFirstAired() {
		return firstAired;
	}

	@JsonProperty("firstAired")
	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
	}

	// ------------------------------------------------------------------------
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	// ------------------------------------------------------------------------
	
	@JsonProperty("language")
	public Language getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	// ------------------------------------------------------------------------

	@JsonProperty("lastUpdated")
	public Long getLastUpdated() {
		return lastUpdated;
	}

	@JsonProperty("lastUpdated")
	public void setLastUpdated(Long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	// ------------------------------------------------------------------------
	
	@JsonProperty("overview")
	public String getOverview() {
		return overview;
	}

	@JsonProperty("overview")
	public void setOverview(String overview) {
		this.overview = overview;
	}

}