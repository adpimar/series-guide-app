package impl.managers.remote.thetvdb.jsonschemas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"aliases", 
	"banner", 
	"firstAired", 
	"id", 
	"network", 
	"overview", 
	"seriesName", 
	"status" })
public class SearchSerie {

	@JsonProperty("aliases")
	private List<String> aliases = null;
	
	@JsonProperty("banner")
	private String banner;
	
	@JsonProperty("firstAired")
	private String firstAired;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("network")
	private String network;
	
	@JsonProperty("overview")
	private String overview;
	
	@JsonProperty("seriesName")
	private String seriesName;
	
	@JsonProperty("status")
	private String status;

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

	@JsonProperty("network")
	public String getNetwork() {
		return network;
	}

	@JsonProperty("network")
	public void setNetwork(String network) {
		this.network = network;
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

	@JsonProperty("seriesName")
	public String getSeriesName() {
		return seriesName;
	}

	@JsonProperty("seriesName")
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
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

}