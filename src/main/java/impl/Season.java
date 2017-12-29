package impl;

import java.util.ArrayList;
import java.util.List;

public class Season {

	// cod_serie#aired_season#first_aired#status#total_episodes#seen
	
	private long codSerie;
	private int airedSeason;
	private String firstAired;
	private String status;
	private int totalEpisodes;
	private boolean seen;

	private List<Episode> episodes;

	public Season() {
		episodes = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[ TEMPORADA ]");
		sb.append("\nSerie id            : " + codSerie);
		sb.append("\nNúmero de temporada : " + airedSeason);
		sb.append("\nInicio de emisión   : " + firstAired);
		sb.append("\nEstado              : " + status);
		sb.append("\nEpisodios totales   : " + totalEpisodes);
		sb.append("\nVista               : " + seen);

		return sb.toString();
	}

	public long getCodSerie() {
		return codSerie;
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

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setCodSerie(long codSerie) {
		this.codSerie = codSerie;
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
		this.totalEpisodes = totalEpisodes;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	// ---------------------------- EQUALS -----------------------------------------


	// ---------------------------- GETTERS && SETTERS -----------------------------

	
	
}
