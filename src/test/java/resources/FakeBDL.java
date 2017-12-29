package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import abs.ILocalManager;
import impl.Episode;
import impl.Season;
import impl.Serie;

public class FakeBDL implements ILocalManager {

	private static final String PATH;
	
	static {
		PATH = "src" + File.separator 
				+ "test" + File.separator 
				+ "resources" + File.separator 
				+ "statesBDL" + File.separator;
	}
	
	private String filename;

	private List<Serie> series;
	private List<Season> seasons;
	private List<Episode> episodes;

	public FakeBDL(String filename) {
		this.series = new LinkedList<>();
		this.seasons = new LinkedList<>();
		this.episodes = new LinkedList<>();
		this.filename = filename;

		try {
			read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ---------- Getters -----------------------------------------------------
	
	public List<Serie> getSeries() {
		return series;
	}
	
	public List<Season> getSeasons() {
		return seasons;
	}
	
	public List<Episode> getEpisodes() {
		return episodes;
	}	
	
	// ---------- Readers -----------------------------------------------------

	private void read() throws FileNotFoundException, IOException {
		BufferedReader b = new BufferedReader(new FileReader(PATH + filename));
		String line;
		while ((line = b.readLine()) != null) {
			String[] fields = line.split("#");
			switch (fields[0].charAt(0)) {
				case 'S': serieParser(fields); break;
				case 'T': seasonParser(fields); break;
				case 'E': episodeParser(fields);
			}
		}
		b.close();
	}

	//
	// cod_serie#series_name#status#first_aired#airs_dow#airs_time#network#site_rating#site_rating_count#overview
	//
	private void serieParser(String[] fields) {
		Serie serie = new Serie();

		serie.setCodSerie(Long.parseLong(fields[1]));
		serie.setSeriesName(fields[2]);
		serie.setStatus(fields[3]);
		serie.setFirstAired(fields[4]);
		serie.setAirsDOW(fields[5]);
		serie.setAirsTime(fields[6]);
		serie.setNetwork(fields[7]);
		serie.setSiteRating(Double.parseDouble(fields[8]));
		serie.setSiteRatingCount(Integer.parseInt(fields[9]));
		serie.setOverview(fields[10]);

		series.add(serie);
	}

	//
	// cod_serie#aired_season#first_aired#status#total_episodes#seen
	//
	private void seasonParser(String[] fields) {
		Season season = new Season();

		season.setCodSerie(Long.parseLong(fields[1]));
		season.setAiredSeason(Integer.parseInt(fields[2]));
		season.setFirstAired(fields[3]);
		season.setStatus(fields[4]);
		season.setTotalEpisodes(Integer.parseInt(fields[5]));
		season.setSeen(fields[6].toUpperCase().charAt(0) == 'T');

		seasons.add(season);
	}

	//
	// cod_episode#cod_serie#aired_season#aired_episode#episode_name#first_aired#overview#seen#comment
	//
	private void episodeParser(String[] fields) {
		Episode episode = new Episode();

		episode.setCodEpisode(Long.parseLong(fields[1]));
		episode.setCodSerie(Long.parseLong(fields[2]));
		episode.setAiredSeason(Integer.parseInt(fields[3]));
		episode.setAiredEpisode(Integer.parseInt(fields[4]));
		episode.setEpisodeName(fields[5]);
		episode.setFirstAired(fields[6]);
		episode.setOverview(fields[7]);
		episode.setSeen(fields[8].toUpperCase().charAt(0) == 'T');
		episode.setComment(fields.length == 9 ? null : fields[9]);

		episodes.add(episode);
	}
	
	// ---------- ILocalManager -----------------------------------------------

	@Override
	public List<String> searchSeries(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serie> listSeries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Season> listSerieSeasons(long codSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Episode> listSerieEpisodes(long codSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Episode> listSerieSeasonEpisodes(long codSerie, int airedSeason) {
		List<Episode> seasonEpisodes = new LinkedList<>();
		for (Episode e : episodes)
			if (e.getCodSerie() == codSerie && e.getAiredSeason() == airedSeason)
				seasonEpisodes.add(e);
		return seasonEpisodes;
	}

	@Override
	public Serie getSerie(long codSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season getSerieSeason(long codSerie, int airedSeason) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode getSerieEpisode(long codEpisode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode getSerieSeasonEpisode(long codSerie, int airedSeason, int airedEpisode) {
		// TODO Auto-generated method stub
		return null;
	}

}
