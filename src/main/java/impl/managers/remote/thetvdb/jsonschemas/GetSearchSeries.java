package impl.managers.remote.thetvdb.jsonschemas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data" })
public class GetSearchSeries {

	@JsonProperty("data")
	private List<SearchSerie> data = null;

	// ------------------------------------------------------------------------

	@JsonProperty("data")
	public List<SearchSerie> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<SearchSerie> data) {
		this.data = data;
	}

}