package resources;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import impl.model.Episode;
import impl.model.RemoteEpisode;
import impl.model.RemoteSearchSerie;
import impl.model.RemoteSerie;
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

	public static RemoteSerie remoteSerieParser(String[] fields) {
		RemoteSerie remoteSerie = new RemoteSerie();

		int i = 1;

		remoteSerie.setId(Long.parseLong(readStringFields(fields[i++])));
		remoteSerie.setSeriesName(readStringFields(fields[i++]));
		remoteSerie.setAliases(aliasesAndGenresParser(fields[i++]));
		remoteSerie.setBanner(readStringFields(fields[i++]));
		remoteSerie.setSeriesId(readStringFields(fields[i++]));
		remoteSerie.setStatus(readStringFields(fields[i++]));
		remoteSerie.setFirstAired(readStringFields(fields[i++]));
		remoteSerie.setNetwork(readStringFields(fields[i++]));
		remoteSerie.setNetworkId(readStringFields(fields[i++]));
		remoteSerie.setRuntime(readStringFields(fields[i++]));
		remoteSerie.setGenre(aliasesAndGenresParser(fields[i++]));
		remoteSerie.setOverview(readStringFields(fields[i++]));
		remoteSerie.setLastUpdated(Long.parseLong(fields[i++]));
		remoteSerie.setAirsDayOfWeek(readStringFields(fields[i++]));
		remoteSerie.setAirsTime(readStringFields(fields[i++]));
		remoteSerie.setRating(readStringFields(fields[i++]));
		remoteSerie.setImdbId(readStringFields(fields[i++]));
		remoteSerie.setZap2itld(readStringFields(fields[i++]));
		remoteSerie.setAdded(readStringFields(fields[i++]));
		remoteSerie.setAddedBy(Long.parseLong(fields[i++]));
		remoteSerie.setSiteRating(Double.parseDouble(fields[i++]));
		remoteSerie.setSiteRatingCount(Integer.parseInt(fields[i++]));

		return remoteSerie;
	}
		
	public static RemoteEpisode remoteEpisodeParser(String[] fields) {
		RemoteEpisode remoteEpisode = new RemoteEpisode();

		int i = 1;

		remoteEpisode.setAbsoluteNumber(Integer.parseInt(fields[i++]));
		remoteEpisode.setAiredEpisodeNumber(Integer.parseInt(fields[i++]));
		remoteEpisode.setAiredSeason(Integer.parseInt(fields[i++]));
		remoteEpisode.setAiredSeasonID(Long.parseLong(fields[i++]));
		remoteEpisode.setDvdEpisodeNumber(Integer.parseInt(fields[i++]));
		remoteEpisode.setDvdSeason(Integer.parseInt(fields[i++]));
		remoteEpisode.setEpisodeName(readStringFields(fields[i++]));
		remoteEpisode.setFirstAired(readStringFields(fields[i++]));
		remoteEpisode.setId(Long.parseLong(fields[i++]));
		remoteEpisode.setLanguage(readStringFields(fields[i++]));
		remoteEpisode.setLastUpdated(Long.parseLong(fields[i++]));
		remoteEpisode.setOverview(readStringFields(fields[i++]));

		return remoteEpisode;
	}
	
	public static RemoteSearchSerie remoteSearchSerieParser(String[] fields) {
		RemoteSearchSerie remoteSearchSerie = new RemoteSearchSerie();

		int i = 1;
		
		remoteSearchSerie.setAliases(stringListParser(fields[i++]));
		remoteSearchSerie.setBanner(readStringFields(fields[i++]));
		remoteSearchSerie.setFirstAired(readStringFields(fields[i++]));
		remoteSearchSerie.setId(Long.parseLong(fields[i++]));
		remoteSearchSerie.setNetwork(readStringFields(fields[i++]));
		remoteSearchSerie.setOverview(readStringFields(fields[i++]));
		remoteSearchSerie.setSeriesName(readStringFields(fields[i++]));
		remoteSearchSerie.setStatus(readStringFields(fields[i++]));

		return remoteSearchSerie;
	}
	
	private static List<String> stringListParser(String field) {
		if (field.equals("null"))
			return null;
		if (field.equals("empty"))
			return new LinkedList<>();
		return Arrays.asList(field.split(";"));
	}
	
	private static String readStringFields(String field) {
		if (field.equals("null"))
			return null;
		if (field.equals("\"\"") || field.equals("empty"))
			return "";
		return field;
	}
	
	private static List<String> aliasesAndGenresParser(String field) {
		List<String> list = new LinkedList<>();
		String[] ags = field.split(",");
		for (String ag : ags)
			list.add(ag.trim());
		return list;
	}

}
