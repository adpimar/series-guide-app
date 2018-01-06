package impl.managers.remote.thetvdb.jsonschemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"episodeName", 
	"overview" })
public class Language {

	@JsonProperty("episodeName")
	private String episodeName;

	@JsonProperty("overview")
	private String overview;
	
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
	
	@JsonProperty("overview")
	public String getOverview() {
		return overview;
	}

	@JsonProperty("overview")
	public void setOverview(String overview) {
		this.overview = overview;
	}

}
