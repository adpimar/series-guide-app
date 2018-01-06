package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public enum FactoryMocks {
	
	R12_1_1_2("R12.1.1.2.txt", "SS"),
	R12_1_1_3("R12.1.1.3.txt", "SS"),

	R13_1_1_1("R13.1.1.1.txt", "S"),
	R13_2_1_1("R13.2.1.1.txt", "S"),
	R13_2_2_1("R13.2.2.1.txt", "S"),
	
	R14_1_1_1("R14.1.1.1.txt", "T"),
	R14_1_1_2("R14.1.1.2.txt", "T"),
	R14_1_1_3("R14.1.1.3.txt", "T");
	
	// ------------------------------------------------------------------------
	
	private static final String PATH;
	
	static {
		PATH = "src" + File.separator 
				+ "test" + File.separator 
				+ "resources" + File.separator 
				+ "mocks" + File.separator;
	}
	
	// ------------------------------------------------------------------------
	
	private final String filename;
	private final String objectExpected;
	
	private FactoryMocks(final String filename, final String objectExpected) {
        this.filename = filename;
        this.objectExpected = objectExpected;
    }
	
	// ------------------------------------------------------------------------

	public Object getMock() {
		BufferedReader b;
		try {
			b = new BufferedReader(new FileReader(PATH + filename));
			
			if (objectExpected.equals("S"))
				return getMockRemoteSerie(b);
			if (objectExpected.equals("T"))
				return getMockRemoteSearchSerie(b);
			if (objectExpected.equals("E"))
				return getMockRemoteSeason(b);
			
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ------------------------------------------------------------------------
	
	private Serie getMockRemoteSerie(BufferedReader b) throws IOException {
		String[] fields = b.readLine().split("#");		
		return TestParsers.localSerieParser(fields);
	}
	
	private Serie getMockRemoteSearchSerie(BufferedReader b) throws IOException {
		String[] fields = b.readLine().split("#");		
		return TestParsers.remoteSearchSerieParser(fields);
	}
	
	private Season getMockRemoteSeason(BufferedReader b) throws IOException {
		String[] fields = b.readLine().split("#");
		Season season = TestParsers.localSeasonParser(fields);
		Episode[] episodes = season.getEpisodes();
		String line;
		Episode episode;
		while ((line = b.readLine()) != null) {
			fields = line.split("#");
			episode = TestParsers.localEpisodeParser(fields);
			episodes[episode.getAiredEpisode() - 1] = episode;
		}
		return season;
	}
	
}