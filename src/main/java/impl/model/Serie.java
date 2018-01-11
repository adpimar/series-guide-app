package impl.model;

import java.util.LinkedList;
import java.util.List;

public class Serie {
	
	private long codSerie;
	private String seriesName;
	private String status;
	private String firstAired;
	private String airsDow;
	private String airsTime;
	private String network;
	private String genres;
	private double siteRating;
	private int siteRatingCount;
	private String overview;

	private List<Season> seasons;
	
	public Serie() {
		seasons = new LinkedList<>();
	}
	
	// ------------------------------------------------------------------------
	
	public Season getSeasonByAired(int airedSeason) {
		for (Season season : seasons)
			if (season.getAiredSeason() == airedSeason)
				return season;
		return null;
	}

	// ---------- Getters -----------------------------------------------------

	public long getCodSerie() {
		return codSerie;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public String getStatus() {
		return status;
	}

	public String getFirstAired() {
		return firstAired;
	}

	public String getAirsDOW() {
		return airsDow;
	}

	public String getAirsTime() {
		return airsTime;
	}

	public String getNetwork() {
		return network;
	}
	
	public String getGenres() {
		return genres;
	}

	public double getSiteRating() {
		return siteRating;
	}

	public int getSiteRatingCount() {
		return siteRatingCount;
	}

	public String getOverview() {
		return overview;
	}

	public List<Season> getSeasons() {
		return seasons;
	}
	
	// ---------- Setters -----------------------------------------------------

	public void setCodSerie(long cod_serie) {
		this.codSerie = cod_serie;
	}

	public void setSeriesName(String series_name) {
		this.seriesName = series_name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setFirstAired(String first_aired) {
		this.firstAired = first_aired;
	}

	public void setAirsDOW(String airs_dow) {
		this.airsDow = airs_dow;
	}

	public void setAirsTime(String airs_time) {
		this.airsTime = airs_time;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
	
	public void setGenres(String genres) {
		this.genres = genres;
	}

	public void setSiteRating(double site_rating) {
		this.siteRating = site_rating;
	}

	public void setSiteRatingCount(int site_ratingCount) {
		this.siteRatingCount = site_ratingCount;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
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
		Serie other = (Serie) obj;
		if (airsDow == null) {
			if (other.airsDow != null)
				return false;
		} else if (!airsDow.equals(other.airsDow))
			return false;
		if (airsTime == null) {
			if (other.airsTime != null)
				return false;
		} else if (!airsTime.equals(other.airsTime))
			return false;
		if (codSerie != other.codSerie)
			return false;
		if (firstAired == null) {
			if (other.firstAired != null)
				return false;
		} else if (!firstAired.equals(other.firstAired))
			return false;
		if (network == null) {
			if (other.network != null)
				return false;
		} else if (!network.equals(other.network))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (overview == null) {
			if (other.overview != null)
				return false;
		} else if (!overview.equals(other.overview))
			return false;
		if (seriesName == null) {
			if (other.seriesName != null)
				return false;
		} else if (!seriesName.equals(other.seriesName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	// ---------- To String ---------------------------------------------------

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[ SERIE ]");
		sb.append("\n Id                 : " + codSerie);
		sb.append("\n Título             : " + seriesName);
		sb.append("\n Estado             : " + status);
		sb.append("\n Inicio de emisión  : " + firstAired);
		sb.append("\n Día de emisión     : " + airsDow);
		sb.append("\n Horario de emisión : " + airsTime);
		sb.append("\n Cadena             : " + network);
		sb.append("\n Géneros            : " + genres);
		sb.append("\n Puntuación         : " + siteRating);
		sb.append("\n Total puntuaciones : " + siteRatingCount);
		sb.append("\n Sinopsis           : " + overview);
		sb.append("\n");
		
		return sb.toString();
	}
	
}
