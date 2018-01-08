package impl.model;

public class Episode {

	private long cod_episode;
	private long cod_season;
	private int aired_season;
	private int aired_episode;
	private String episode_name;
	private String first_aired;
	private String overview;
	private boolean seen;
	private String comment;
	
	// ---------- Getters -----------------------------------------------------

	public long getCodEpisode() {
		return cod_episode;
	}

	public long getCodSeason() {
		return cod_season;
	}

	public int getAiredSeason() {
		return aired_season;
	}

	public int getAiredEpisode() {
		return aired_episode;
	}

	public String getEpisodeName() {
		return episode_name;
	}

	public String getFirstAired() {
		return first_aired;
	}

	public String getOverview() {
		return overview;
	}

	public boolean isSeen() {
		return seen;
	}

	public String getComment() {
		return comment;
	}
	
	// ---------- Setters -----------------------------------------------------

	public void setCodEpisode(long codEpisode) {
		this.cod_episode = codEpisode;
	}

	public void setCodSeason(long codSeason) {
		this.cod_season = codSeason;
	}

	public void setAiredSeason(int airedSeason) {
		this.aired_season = airedSeason;
	}

	public void setAiredEpisode(int airedEpisode) {
		this.aired_episode = airedEpisode;
	}

	public void setEpisodeName(String episodeName) {
		this.episode_name = episodeName;
	}

	public void setFirstAired(String firstAired) {
		this.first_aired = firstAired;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		Episode other = (Episode) obj;
		if (aired_episode != other.aired_episode)
			return false;
		if (aired_season != other.aired_season)
			return false;
		if (cod_episode != other.cod_episode)
			return false;
		if (cod_season != other.cod_season)
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (episode_name == null) {
			if (other.episode_name != null)
				return false;
		} else if (!episode_name.equals(other.episode_name))
			return false;
		if (first_aired == null) {
			if (other.first_aired != null)
				return false;
		} else if (!first_aired.equals(other.first_aired))
			return false;
		if (overview == null) {
			if (other.overview != null)
				return false;
		} else if (!overview.equals(other.overview))
			return false;
		if (seen != other.seen)
			return false;
		return true;
	}
	
	// ---------- To String ---------------------------------------------------

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[ EPISODIO ]");
		sb.append("\n Episodio id         : " + cod_episode);
		sb.append("\n Temporada id        : " + cod_season);
		sb.append("\n Número de temporada : " + aired_season);
		sb.append("\n Número de episodio  : " + aired_episode);
		sb.append("\n Título              : " + episode_name);
		sb.append("\n fechaEmision        : " + first_aired);
		sb.append("\n Sinopsis            : " + overview);
		sb.append("\n Visto               : " + seen);
		sb.append("\n Comentario          : " + comment);
		sb.append("\n");

		return sb.toString();
	}

}
