package impl.managers.remote.thetvdb.jsonschemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data" })
public class GetSerieId {

	@JsonProperty("data")
	private SpecificSerie data;

	// ------------------------------------------------------------------------
	
	@JsonProperty("data")
	public SpecificSerie getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(SpecificSerie data) {
		this.data = data;
	}

}
