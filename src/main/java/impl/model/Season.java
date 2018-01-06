package impl.model;

public class Season {

	private long codSerie;
	private long codSeason;
	private int airedSeason;
	private String firstAired;
	private String status;
	private int totalEpisodes;
	private boolean seen;

	private Episode[] episodes;

	public Season() {
		episodes = new Episode[totalEpisodes];
	}
	
	// ------------------------------------------------------------------------
	
	public boolean checkSeasonSeen() {
		boolean oldValue = seen;
		seen = true;
		for (Episode episode : episodes)
			seen = seen && episode.isSeen();
		return oldValue != seen;
	}
	
	// ---------- Getters -----------------------------------------------------
	
	public long getCodSerie() {
		return codSerie;
	}
	
	public long getCodSeason() {
		return codSeason;
	}

	public int getAiredSeason() {
		return airedSeason;
	}

	public String getFirstAired() {
		return firstAired;
	}

	public String getStatus() {
		return status;
	}

	public int getTotalEpisodes() {
		return totalEpisodes;
	}

	public boolean isSeen() {
		return seen;
	}

	public Episode[] getEpisodes() {
		return episodes;
	}
	
	// ---------- Setters -----------------------------------------------------

	public void setCodSerie(long codSerie) {
		this.codSerie = codSerie;
	}
	
	public void setCodSeason(long codSeason) {
		this.codSeason = codSeason;
	}

	public void setAiredSeason(int airedSeason) {
		this.airedSeason = airedSeason;
	}

	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotalEpisodes(int totalEpisodes) {
		Episode[] newEpisodes = new Episode[totalEpisodes];
		for (int i = 0; i < episodes.length; i++)
			newEpisodes[i] = episodes[i];
		episodes = newEpisodes;
		this.totalEpisodes = totalEpisodes;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public void setEpisodes(Episode[] episodes) {
		this.episodes = episodes;
	}
	
	// ---------- Equals ------------------------------------------------------
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season other = (Season) obj;
		if (airedSeason != other.airedSeason)
			return false;
		if (codSeason != other.codSeason)
			return false;
		if (codSerie != other.codSerie)
			return false;
		if (firstAired == null) {
			if (other.firstAired != null)
				return false;
		} else if (!firstAired.equals(other.firstAired))
			return false;
		if (seen != other.seen)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalEpisodes != other.totalEpisodes)
			return false;
		return true;
	}
	
	// ---------- To String ---------------------------------------------------
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[ TEMPORADA ]");
		sb.append("\nSerie id            : " + codSerie);
		sb.append("\nTemporada id        : " + codSeason);
		sb.append("\nNúmero de temporada : " + airedSeason);
		sb.append("\nInicio de emisión   : " + firstAired);
		sb.append("\nEstado              : " + status);
		sb.append("\nEpisodios totales   : " + totalEpisodes);
		sb.append("\nVista               : " + seen);
		sb.append("\n");

		return sb.toString();
	}
	
}
