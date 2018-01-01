package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import impl.model.Season;

public enum ExpectedSeasons {

	R15_1_1_1("R15.1.1.1.txt"),
	R15_1_1_4("R15.1.1.4.txt"),
	R15_2_1_1("R15.2.1.1.txt"),
	R15_2_1_4("R15.2.1.4.txt");
	
	private static final String PATH;
	
	static {
		PATH = "src" + File.separator 
				+ "test" + File.separator 
				+ "resources" + File.separator 
				+ "expectedSeasons" + File.separator;
	}
	
	private final String filename;
	
	private ExpectedSeasons(final String filename) {
        this.filename = filename;
    }

	public Season getExpectedSeason() {
		Season season = null;
		try {
			BufferedReader b = new BufferedReader(new FileReader(PATH + filename));
			String[] fields = b.readLine().split("#");		
			season = TestParsers.localSeasonParser(fields);
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return season;
	}

}
