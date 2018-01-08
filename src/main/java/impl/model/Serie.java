package impl.model;

import java.util.LinkedList;
import java.util.List;

public class Serie {
	
	private long cod_serie;
	private String series_name;
	private String status;
	private String first_aired;
	private String airs_dow;
	private String airs_time;
	private String network;
	private String genres;
	private double site_rating;
	private int site_rating_count;
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
		return cod_serie;
	}

	public String getSeriesName() {
		return series_name;
	}

	public String getStatus() {
		return status;
	}

	public String getFirstAired() {
		return first_aired;
	}

	public String getAirsDOW() {
		return airs_dow;
	}

	public String getAirsTime() {
		return airs_time;
	}

	public String getNetwork() {
		return network;
	}
	
	public String getGenres() {
		return genres;
	}

	public double getSiteRating() {
		return site_rating;
	}

	public int getSiteRatingCount() {
		return site_rating_count;
	}

	public String getOverview() {
		return overview;
	}

	public List<Season> getSeasons() {
		return seasons;
	}
	
	// ---------- Setters -----------------------------------------------------

	public void setCodSerie(long cod_serie) {
		this.cod_serie = cod_serie;
	}

	public void setSeriesName(String series_name) {
		this.series_name = series_name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setFirstAired(String first_aired) {
		this.first_aired = first_aired;
	}

	public void setAirsDOW(String airs_dow) {
		this.airs_dow = airs_dow;
	}

	public void setAirsTime(String airs_time) {
		this.airs_time = airs_time;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
	
	public void setGenres(String genres) {
		this.genres = genres;
	}

	public void setSiteRating(double site_rating) {
		this.site_rating = site_rating;
	}

	public void setSiteRatingCount(int site_ratingCount) {
		this.site_rating_count = site_ratingCount;
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
		if (airs_dow == null) {
			if (other.airs_dow != null)
				return false;
		} else if (!airs_dow.equals(other.airs_dow))
			return false;
		if (airs_time == null) {
			if (other.airs_time != null)
				return false;
		} else if (!airs_time.equals(other.airs_time))
			return false;
		if (cod_serie != other.cod_serie)
			return false;
		if (first_aired == null) {
			if (other.first_aired != null)
				return false;
		} else if (!first_aired.equals(other.first_aired))
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
		if (series_name == null) {
			if (other.series_name != null)
				return false;
		} else if (!series_name.equals(other.series_name))
			return false;
		if (Double.doubleToLongBits(site_rating) != Double.doubleToLongBits(other.site_rating))
			return false;
		if (site_rating_count != other.site_rating_count)
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
		sb.append("\n Id                 : " + cod_serie);
		sb.append("\n Título             : " + series_name);
		sb.append("\n Estado             : " + status);
		sb.append("\n Inicio de emisión  : " + first_aired);
		sb.append("\n Día de emisión     : " + airs_dow);
		sb.append("\n Horario de emisión : " + airs_time);
		sb.append("\n Cadena             : " + network);
		sb.append("\n Géneros            : " + genres);
		sb.append("\n Puntuación         : " + site_rating);
		sb.append("\n Total puntuaciones : " + site_rating_count);
		sb.append("\n Sinopsis           : " + overview);
		sb.append("\n");
		
		return sb.toString();
	}
	
}
