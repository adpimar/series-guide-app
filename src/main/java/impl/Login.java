package impl;

public class Login {

	private String apikey;
	private String userkey;
	private String username;

	public Login() {
		apikey = "A3FCE8D7D14CB414";
		userkey = "4266C50AAC342851";
		username = "adpimar";
	}

	public String getApikey() {
		return apikey;
	}

	public String getUserkey() {
		return userkey;
	}

	public String getUsername() {
		return username;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
