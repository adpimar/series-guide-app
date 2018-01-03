package impl.model;

import java.util.LinkedList;
import java.util.List;

public class RemoteSearchSerie {

	private List<String> aliases;
	private String banner;
	private String firstAired;
	private long id;
	private String network;
	private String overview;
	private String seriesName;
	private String status;

	public RemoteSearchSerie() {
		aliases = new LinkedList<>();
	}

	public List<String> getAliases() {
		return aliases;
	}

	public String getBanner() {
		return banner;
	}

	public String getFirstAired() {
		return firstAired;
	}

	public long getId() {
		return id;
	}

	public String getNetwork() {
		return network;
	}

	public String getOverview() {
		return overview;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public String getStatus() {
		return status;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
