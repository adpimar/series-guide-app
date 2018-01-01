package impl.model;

import java.util.ArrayList;
import java.util.List;

public class RemoteSeason {

	private long codSerie;
	private long codSeason;
	private int airedSeason;
	private String firstAired;
	private String status;
	private int totalEpisodes;
	private boolean seen;

	private List<Episode> episodes;

	public RemoteSeason() {
		episodes = new ArrayList<>();
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

	public List<Episode> getEpisodes() {
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
		this.totalEpisodes = totalEpisodes;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public void setEpisodes(List<Episode> episodes) {
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
		RemoteSeason other = (RemoteSeason) obj;
		if (airedSeason != other.airedSeason)
			return false;
		if (codSeason != other.codSeason)
			return false;
		if (codSerie != other.codSerie)
			return false;
		if (episodes == null) {
			if (other.episodes != null)
				return false;
		} else if (!episodes.equals(other.episodes))
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
		sb.append("\nNúmero de temporada : " + airedSeason);
		sb.append("\nInicio de emisión   : " + firstAired);
		sb.append("\nEstado              : " + status);
		sb.append("\nEpisodios totales   : " + totalEpisodes);
		sb.append("\nVista               : " + seen);

		return sb.toString();
	}
	
}
