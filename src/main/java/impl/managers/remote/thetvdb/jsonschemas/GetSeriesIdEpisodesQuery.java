package impl.managers.remote.thetvdb.jsonschemas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"links", 
	"data" })
public class GetSeriesIdEpisodesQuery {

	@JsonProperty("links")
	private Links links;

	@JsonProperty("data")
	private List<QueryEpisode> data = null;
	
	// ------------------------------------------------------------------------

	@JsonProperty("links")
	public Links getLinks() {
		return links;
	}

	@JsonProperty("links")
	public void setLinks(Links links) {
		this.links = links;
	}
	
	// ------------------------------------------------------------------------

	@JsonProperty("data")
	public List<QueryEpisode> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<QueryEpisode> data) {
		this.data = data;
	}

}