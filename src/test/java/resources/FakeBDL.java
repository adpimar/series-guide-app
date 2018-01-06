package resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import abs.managers.ILocalManager;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class FakeBDL implements ILocalManager {

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
	
	// ------------------------------------------------------------------------

	private void read() throws FileNotFoundException, IOException {
		BufferedReader b = new BufferedReader(new FileReader(filename));
		String line;
		while ((line = b.readLine()) != null) {
			String[] fields = line.split("#");
			switch (fields[0].charAt(0)) {
				case 'S': addSerie(TestParsers.localSerieParser(fields)); break;
				case 'T': addSeason(TestParsers.localSeasonParser(fields)); break;
				case 'E': addEpisode(TestParsers.localEpisodeParser(fields));
			}
		}
		b.close();
	}
	
	// ---------- ILocalManager -----------------------------------------------

	@Override
	public List<Serie> listSeries() {
		return series;
	}

	@Override
	public Serie getSerie(long codSerie) {
		for (Serie s : series)
			if (s.getCodSerie() == codSerie)
				return s;
		return null;
	}

	@Override
	public void addSerie(Serie serie) {
		series.add(serie);
	}
	
	@Override
	public void updateSerie(Serie serie) {
		for (Serie s : series)
			if (s.getCodSerie() == serie.getCodSerie())
				s = serie;
	}

	@Override
	public void removeSerie(Serie serie) {
		series.remove(serie);
	}

	// ----------
	
	@Override
	public List<Season> listSeasons() {
		return seasons;
	}

	@Override
	public Season getSeason(long codSeason) {
		for (Season s : seasons)
			if (s.getCodSeason() == codSeason)
				return s;
		return null;
	}

	@Override
	public void addSeason(Season season) {
		for (Serie serie : series)
			if (serie.getCodSerie() == season.getCodSerie())
				if (!serie.getSeasons().add(season))
					throw new IllegalArgumentException();
		seasons.add(season);
	}
	
	@Override
	public void updateSeason(Season season) {
		for (Season s : seasons)
			if (s.getCodSeason() == season.getCodSeason())
				s = season;
	}

	@Override
	public void removeSeason(Season season) {
		List<Episode> listEpisodes = new LinkedList<>();
		for (Episode e : episodes)
			if (e.getCodSeason() != season.getCodSeason())
				listEpisodes.add(e);
		episodes = listEpisodes;
		
		seasons.remove(season);
	}
	
	// ----------

	@Override
	public List<Episode> listEpisodes() {
		return episodes;
	}

	@Override
	public Episode getEpisode(long codEpisode) {
		for (Episode e : episodes)
			if (e.getCodEpisode() == codEpisode)
				return e;
		return null;
	}
	
	@Override
	public void addEpisode(Episode episode) {
		for (Season season : seasons)
			if (season.getCodSeason() == episode.getCodSeason()) {
				Episode[] episodes = season.getEpisodes();
				episodes[episode.getAiredEpisode() - 1] = episode;
			}
		episodes.add(episode);
	}

	@Override
	public void updateEpisode(Episode episode) {
		for (Episode e : episodes)
			if (e.getCodEpisode() == episode.getCodEpisode())
				e = episode;
	}

	@Override
	public void removeEpisode(Episode episode) {
		episodes.remove(episode);
	}

}
