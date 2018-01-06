package impl.managers.remote.thetvdb.jsonschemas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"id", 
	"seriesName", 
	"aliases", 
	"banner", 
	"seriesId", 
	"status", 
	"firstAired", 
	"network",
	"networkId", 
	"runtime", 
	"genre", 
	"overview", 
	"lastUpdated", 
	"airsDayOfWeek", 
	"airsTime", 
	"rating", 
	"imdbId",
	"zap2itId", 
	"added", 
	"addedBy", 
	"siteRating", 
	"siteRatingCount" })
public class SpecificSerie {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("seriesName")
	private String seriesName;
	
	@JsonProperty("aliases")
	private List<String> aliases = null;
	
	@JsonProperty("banner")
	private String banner;
	
	@JsonProperty("seriesId")
	private String seriesId;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("firstAired")
	private String firstAired;
	
	@JsonProperty("network")
	private String network;
	
	@JsonProperty("networkId")
	private String networkId;
	
	@JsonProperty("runtime")
	private String runtime;
	
	@JsonProperty("genre")
	private List<String> genre = null;
	
	@JsonProperty("overview")
	private String overview;
	
	@JsonProperty("lastUpdated")
	private Long lastUpdated;
	
	@JsonProperty("airsDayOfWeek")
	private String airsDayOfWeek;
	
	@JsonProperty("airsTime")
	private String airsTime;
	
	@JsonProperty("rating")
	private String rating;
	
	@JsonProperty("imdbId")
	private String imdbId;
	
	@JsonProperty("zap2itId")
	private String zap2itId;
	
	@JsonProperty("added")
	private String added;
	
	@JsonProperty("addedBy")
	private Long addedBy;
	
	@JsonProperty("siteRating")
	private Double siteRating;
	
	@JsonProperty("siteRatingCount")
	private Integer siteRatingCount;

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

	@JsonProperty("seriesName")
	public String getSeriesName() {
		return seriesName;
	}

	@JsonProperty("seriesName")
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("aliases")
	public List<String> getAliases() {
		return aliases;
	}

	@JsonProperty("aliases")
	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("banner")
	public String getBanner() {
		return banner;
	}

	@JsonProperty("banner")
	public void setBanner(String banner) {
		this.banner = banner;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("seriesId")
	public String getSeriesId() {
		return seriesId;
	}

	@JsonProperty("seriesId")
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
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

	@JsonProperty("network")
	public String getNetwork() {
		return network;
	}

	@JsonProperty("network")
	public void setNetwork(String network) {
		this.network = network;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("networkId")
	public String getNetworkId() {
		return networkId;
	}

	@JsonProperty("networkId")
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("runtime")
	public String getRuntime() {
		return runtime;
	}

	@JsonProperty("runtime")
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("genre")
	public List<String> getGenre() {
		return genre;
	}

	@JsonProperty("genre")
	public void setGenre(List<String> genre) {
		this.genre = genre;
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

	@JsonProperty("airsDayOfWeek")
	public String getAirsDayOfWeek() {
		return airsDayOfWeek;
	}

	@JsonProperty("airsDayOfWeek")
	public void setAirsDayOfWeek(String airsDayOfWeek) {
		this.airsDayOfWeek = airsDayOfWeek;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("airsTime")
	public String getAirsTime() {
		return airsTime;
	}

	@JsonProperty("airsTime")
	public void setAirsTime(String airsTime) {
		this.airsTime = airsTime;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("rating")
	public String getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(String rating) {
		this.rating = rating;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("imdbId")
	public String getImdbId() {
		return imdbId;
	}

	@JsonProperty("imdbId")
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("zap2itId")
	public String getZap2itId() {
		return zap2itId;
	}

	@JsonProperty("zap2itId")
	public void setZap2itId(String zap2itId) {
		this.zap2itId = zap2itId;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("added")
	public String getAdded() {
		return added;
	}

	@JsonProperty("added")
	public void setAdded(String added) {
		this.added = added;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("addedBy")
	public Long getAddedBy() {
		return addedBy;
	}

	@JsonProperty("addedBy")
	public void setAddedBy(Long addedBy) {
		this.addedBy = addedBy;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("siteRating")
	public Double getSiteRating() {
		return siteRating;
	}

	@JsonProperty("siteRating")
	public void setSiteRating(Double siteRating) {
		this.siteRating = siteRating;
	}

	// ------------------------------------------------------------------------

	@JsonProperty("siteRatingCount")
	public Integer getSiteRatingCount() {
		return siteRatingCount;
	}

	@JsonProperty("siteRatingCount")
	public void setSiteRatingCount(Integer siteRatingCount) {
		this.siteRatingCount = siteRatingCount;
	}

}