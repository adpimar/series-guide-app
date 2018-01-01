package resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import abs.ILocalManager;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class AuxiliarBDL implements ILocalManager {

	private String filename;

	private List<Serie> series;
	private List<Season> seasons;
	private List<Episode> episodes;

	public AuxiliarBDL(String filename) {
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
	
	// ---------- Readers -----------------------------------------------------

	private void read() throws FileNotFoundException, IOException {
		BufferedReader b = new BufferedReader(new FileReader(filename));
		String line;
		while ((line = b.readLine()) != null) {
			String[] fields = line.split("#");
			switch (fields[0].charAt(0)) {
				case 'S': series.add(TestParsers.localSerieParser(fields)); break;
				case 'T': seasons.add(TestParsers.localSeasonParser(fields)); break;
				case 'E': episodes.add(TestParsers.localEpisodeParser(fields));
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
	public List<Season> listSeasons() {
		return seasons;
	}

	@Override
	public List<Episode> listEpisodes() {
		return episodes;
	}

	@Override
	public Serie getSerie(long codSerie) {
		for (Serie s : series)
			if (s.getCodSerie() == codSerie)
				return s;
		return null;
	}

	@Override
	public Season getSeason(long codSeason) {
		for (Season t : seasons)
			if (t.getCodSeason() == codSeason)
				return t;
		return null;
	}

	@Override
	public Episode getEpisode(long codEpisode) {
		for (Episode e : episodes)
			if (e.getCodEpisode() == codEpisode)
				return e;
		return null;
	}

	@Override
	public Serie updateSerie(Serie serie) {
		for (Serie s : series)
			if (s.getCodSerie() == serie.getCodSerie()) {
				s = serie;
				return s;
			}
		return null;
	}

	@Override
	public Season updateSeason(Season season) {
		for (Season t : seasons)
			if (t.getCodSeason() == season.getCodSeason()) {
				t = season;
				return t;
			}
		return null;
	}

	@Override
	public Episode updateEpisode(Episode episode) {
		for (Episode e : episodes)
			if (e.getCodEpisode() == episode.getCodEpisode()) {
				e = episode;
				return e;
			}
		return null;
	}

	@Override
	public boolean removeSerie(Serie serie) {
		return series.remove(serie);
	}

	@Override
	public boolean removeSeason(Season season) {
		return seasons.remove(season);
	}

	@Override
	public boolean removeEpisode(Episode episode) {
		return episodes.remove(episode);
	}
	
}
