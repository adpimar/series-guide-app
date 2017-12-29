package impl;

import java.util.ArrayList;
import java.util.List;

public class Serie {

	// cod_serie#series_name#status#first_aired#airs_dow#airs_time#network#site_rating#site_rating_count#overview
	
	private long codSerie;
	private String seriesName;
	private String status;
	private String firstAired;
	private String airsDOW;
	private String airsTime;
	private String network;
	private double siteRating;
	private int siteRatingCount;
	private String overview;

	private List<Season> seasons;
	
	public Serie() {
		seasons = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ SERIE ]");
		sb.append("\nId                 : " + codSerie);
		sb.append("\nTítulo             : " + seriesName);
		sb.append("\nEstado             : " + status);
		sb.append("\nInicio de emisión  : " + firstAired);
		sb.append("\nDía de emisión     : " + airsDOW);
		sb.append("\nHorario de emisión : " + airsTime);
		sb.append("\nCadena             : " + network);
		sb.append("\nPuntuación         : " + siteRating);
		sb.append("\nTotal puntuaciones : " + siteRatingCount);
		sb.append("\nSinopsis           : " + overview);
		
		return sb.toString();
	}

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
		return airsDOW;
	}

	public String getAirsTime() {
		return airsTime;
	}

	public String getNetwork() {
		return network;
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

	public void setCodSerie(long codSerie) {
		this.codSerie = codSerie;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
	}

	public void setAirsDOW(String airsDOW) {
		this.airsDOW = airsDOW;
	}

	public void setAirsTime(String airsTime) {
		this.airsTime = airsTime;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public void setSiteRating(double siteRating) {
		this.siteRating = siteRating;
	}

	public void setSiteRatingCount(int siteRatingCount) {
		this.siteRatingCount = siteRatingCount;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}
	
	// ---------------------------- EQUALS -----------------------------------------
	
	
	// ---------------------------- GETTERS && SETTERS -----------------------------

	
}
