package resources;

import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class TestParsers {

	public static Serie localSerieParser(String[] fields) {
		Serie serie = new Serie();

		int i = 1;

		serie.setCodSerie(Long.parseLong(fields[i++]));
		serie.setSeriesName(readStringFields(fields[i++]));
		serie.setStatus(readStringFields(fields[i++]));
		serie.setFirstAired(readStringFields(fields[i++]));
		serie.setAirsDOW(readStringFields(fields[i++]));
		serie.setAirsTime(readStringFields(fields[i++]));
		serie.setNetwork(readStringFields(fields[i++]));
		serie.setGenres(readStringFields(fields[i++]));
		serie.setSiteRating(Double.parseDouble(fields[i++]));
		serie.setSiteRatingCount(Integer.parseInt(fields[i++]));
		serie.setOverview(readStringFields(fields[i++]));

		return serie;
	}

	public static Serie remoteSearchSerieParser(String[] fields) {
		Serie serie = new Serie();

		int i = 1;

		serie.setCodSerie(Long.parseLong(fields[i++]));
		serie.setSeriesName(readStringFields(fields[i++]));
		serie.setStatus(readStringFields(fields[i++]));
		serie.setFirstAired(readStringFields(fields[i++]));
		serie.setAirsDOW(null);
		serie.setAirsTime(null);
		serie.setNetwork(readStringFields(fields[i++]));
		serie.setGenres(null);
		serie.setSiteRating(-1);
		serie.setSiteRatingCount(-1);
		serie.setOverview(readStringFields(fields[i++]));

		return serie;
	}

	public static Season localSeasonParser(String[] fields) {
		Season season = new Season();

		int i = 1;

		season.setCodSerie(Long.parseLong(fields[i++]));
		season.setCodSeason(Long.parseLong(fields[i++]));
		season.setAiredSeason(Integer.parseInt(fields[i++]));
		season.setFirstAired(readStringFields(fields[i++]));
		season.setStatus(readStringFields(fields[i++]));
		season.setTotalEpisodes(Integer.parseInt(fields[i++]));
		season.setSeen(fields[i++].toUpperCase().charAt(0) == 'T');

		return season;
	}

	public static Episode localEpisodeParser(String[] fields) {
		Episode episode = new Episode();

		int i = 1;

		episode.setCodEpisode(Long.parseLong(fields[i++]));
		episode.setCodSeason(Long.parseLong(fields[i++]));
		episode.setAiredSeason(Integer.parseInt(fields[i++]));
		episode.setAiredEpisode(Integer.parseInt(fields[i++]));
		episode.setEpisodeName(readStringFields(fields[i++]));
		episode.setFirstAired(readStringFields(fields[i++]));
		episode.setOverview(readStringFields(fields[i++]));
		episode.setSeen(fields[i++].toUpperCase().charAt(0) == 'T');
		episode.setComment(readStringFields(fields[i++]));

		return episode;
	}

	private static String readStringFields(String field) {
		if (field.equals("null"))
			return null;
		if (field.equals("\"\"") || field.equals("empty"))
			return "";
		return field;
	}

}
