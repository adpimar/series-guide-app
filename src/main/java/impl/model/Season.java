package impl.model;

public class Season {

	private long cod_serie;
	private long cod_season;
	private int aired_season;
	private String first_aired;
	private int total_episodes;
	private boolean seen;

	private Episode[] episodes;

	public Season() {
		episodes = new Episode[total_episodes];
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
		return cod_serie;
	}
	
	public long getCodSeason() {
		return cod_season;
	}

	public int getAiredSeason() {
		return aired_season;
	}

	public String getFirstAired() {
		return first_aired;
	}

	public int getTotalEpisodes() {
		return total_episodes;
	}

	public boolean isSeen() {
		return seen;
	}

	public Episode[] getEpisodes() {
		return episodes;
	}
	
	// ---------- Setters -----------------------------------------------------

	public void setCodSerie(long codSerie) {
		this.cod_serie = codSerie;
	}
	
	public void setCodSeason(long codSeason) {
		this.cod_season = codSeason;
	}

	public void setAiredSeason(int airedSeason) {
		this.aired_season = airedSeason;
	}

	public void setFirstAired(String firstAired) {
		this.first_aired = firstAired;
	}

	public void setTotalEpisodes(int totalEpisodes) {
		Episode[] newEpisodes = new Episode[totalEpisodes];
		for (int i = 0; i < episodes.length; i++)
			newEpisodes[i] = episodes[i];
		episodes = newEpisodes;
		this.total_episodes = totalEpisodes;
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
		if (aired_season != other.aired_season)
			return false;
		if (cod_season != other.cod_season)
			return false;
		if (cod_serie != other.cod_serie)
			return false;
		if (first_aired == null) {
			if (other.first_aired != null)
				return false;
		} else if (!first_aired.equals(other.first_aired))
			return false;
		if (seen != other.seen)
			return false;
		if (total_episodes != other.total_episodes)
			return false;
		return true;
	}
	
	// ---------- To String ---------------------------------------------------
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[ TEMPORADA ]");
		sb.append("\n Serie id            : " + cod_serie);
		sb.append("\n Temporada id        : " + cod_season);
		sb.append("\n Número de temporada : " + aired_season);
		sb.append("\n Inicio de emisión   : " + first_aired);
		sb.append("\n Episodios totales   : " + total_episodes);
		sb.append("\n Vista               : " + seen);
		sb.append("\n");

		return sb.toString();
	}
	
}
