package resources;

import java.util.List;

import impl.Episode;
import impl.Season;
import impl.Serie;

public class Pruebas {

	public static void main(String[] args) {
		
		FakeBDL sr = new FakeBDL("R04.1.1.1.txt");
		
		for (Serie s : sr.getSeries())
			System.out.println(s);
		
		for (Season t : sr.getSeasons())
			System.out.println(t);
		
		for (Episode e : sr.getEpisodes())
			System.out.println(e);

	}
	
	private static void printer(Serie serie) {
		System.out.println(serie);
		List<Season> seasons = serie.getSeasons();
		if (seasons != null && seasons.size() > 0)
			for (Season season : seasons) {
				System.out.println(season);
				List<Episode> episodes = season.getEpisodes();
				if (episodes != null && episodes.size() > 0)
					for (Episode episode : episodes)
						System.out.println(episode);
			}
	}
	
	public static void printer(FakeBDL sr) {
		for (Serie s : sr.getSeries())
			System.out.println(s);
		
		for (Season t : sr.getSeasons())
			System.out.println(t);
		
		for (Episode e : sr.getEpisodes())
			System.out.println(e);
	}

}
