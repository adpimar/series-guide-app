package impl.managers.remote.thetvdb.jsonschemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"apikey", 
	"userkey", 
	"username" })
public class Login {

	@JsonProperty("apikey")
	private String apikey;
	
	@JsonProperty("userkey")
	private String userkey;
	
	@JsonProperty("username")
	private String username;

	// ------------------------------------------------------------------------
	
	@JsonProperty("apikey")
	public String getApikey() {
		return apikey;
	}

	@JsonProperty("apikey")
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	
	// ------------------------------------------------------------------------

	@JsonProperty("userkey")
	public String getUserkey() {
		return userkey;
	}
	
	@JsonProperty("userkey")
	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
	
	// ------------------------------------------------------------------------

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

}