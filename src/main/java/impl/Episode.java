package impl;

public class Episode {

	// cod_episode#cod_serie#aired_season#aired_episode#episode_name#first_aired#overview#seen#comment

	private long codEpisode;
	private long codSerie;
	private int airedSeason;
	private int airedEpisode;
	private String episodeName;
	private String firstAired;
	private String overview;
	private boolean seen;
	private String comment;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[ EPISODIO ]");
		sb.append("\nEpisodio id         : " + codEpisode);
		sb.append("\nSerie id            : " + codSerie);
		sb.append("\nNúmero de temporada : " + airedSeason);
		sb.append("\nNúmero de episodio  : " + airedEpisode);
		sb.append("\nTítulo              : " + episodeName);
		sb.append("\nfechaEmision        : " + firstAired);
		sb.append("\nSinopsis            : " + overview);
		sb.append("\nVisto               : " + seen);
		sb.append("\nComentario          : " + comment);

		return sb.toString();
	}

	public long getCodEpisode() {
		return codEpisode;
	}

	public long getCodSerie() {
		return codSerie;
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

	public void setCodEpisode(long codEpisode) {
		this.codEpisode = codEpisode;
	}

	public void setCodSerie(long codSerie) {
		this.codSerie = codSerie;
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

	// ---------------------------- GETTERS && SETTERS -----------------------------

}
