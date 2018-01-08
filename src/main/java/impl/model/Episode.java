package impl.model;

public class Episode {

	private long codEpisode;
	private long codSeason;
	private int airedSeason;
	private int airedEpisode;
	private String episodeName;
	private String firstAired;
	private String overview;
	private boolean seen;
	private String comment;
	
	// ---------- Getters -----------------------------------------------------

	public long getCodEpisode() {
		return codEpisode;
	}

	public long getCodSeason() {
		return codSeason;
	}

	public int getAiredSeason() {
		return airedSeason;
	}

	public int getAiredEpisode() {
		return airedEpisode;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public String getFirstAired() {
		return firstAired;
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
		this.codEpisode = codEpisode;
	}

	public void setCodSeason(long codSeason) {
		this.codSeason = codSeason;
	}

	public void setAiredSeason(int airedSeason) {
		this.airedSeason = airedSeason;
	}

	public void setAiredEpisode(int airedEpisode) {
		this.airedEpisode = airedEpisode;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
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
		if (airedEpisode != other.airedEpisode)
			return false;
		if (airedSeason != other.airedSeason)
			return false;
		if (codEpisode != other.codEpisode)
			return false;
		if (codSeason != other.codSeason)
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (episodeName == null) {
			if (other.episodeName != null)
				return false;
		} else if (!episodeName.equals(other.episodeName))
			return false;
		if (firstAired == null) {
			if (other.firstAired != null)
				return false;
		} else if (!firstAired.equals(other.firstAired))
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

		sb.append(" [ EPISODIO ]");
		sb.append("\n  Episodio id         : " + codEpisode);
		sb.append("\n  Temporada id        : " + codSeason);
		sb.append("\n  Número de temporada : " + airedSeason);
		sb.append("\n  Número de episodio  : " + airedEpisode);
		sb.append("\n  Título              : " + episodeName);
		sb.append("\n  Fecha de emisión    : " + firstAired);
		sb.append("\n  Sinopsis            : " + overview);
		sb.append("\n  Visto               : " + seen);
		sb.append("\n  Comentario          : " + comment);

		return sb.toString();
	}

}
