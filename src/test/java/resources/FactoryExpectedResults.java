package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public enum FactoryExpectedResults {

	R02_1_1_1("R02.1.1.1.txt", "S"),
	R02_1_1_2("R02.1.1.2.txt", "S"),
	
	R03_1_1_1("R03.1.1.1.txt", "S"),
	R03_1_1_2("R03.1.1.2.txt", "S"),
	
	R05_1_1_1("R05.1.1.1.txt", "E"),
	R05_1_1_2("R05.1.1.2.txt", "E"),
	R05_1_1_3("R05.1.1.3.txt", "E"),
	
	R06_1_1_1("R06.1.1.1.txt", "E"),
	R06_1_1_2("R06.1.1.2.txt", "E"),
	
	R07_1_1_1("R07.1.1.1.txt", "E"),
	R07_1_1_2("R07.1.1.2.txt", "E"),
	R07_1_2_1("R07.1.2.1.txt", "E"),
	R07_1_2_2("R07.1.2.2.txt", "E"),
	R07_2_2_1("R07.2.2.1.txt", "E"),
	R07_2_2_2("R07.2.2.2.txt", "E"),
	R07_2_3_1("R07.2.3.1.txt", "E"),
	
	R08_1_1_1("R08.1.1.1.txt", "E"),
	R08_1_2_1("R08.1.2.1.txt", "E"),
	R08_1_2_2("R08.1.2.2.txt", "E"),
	R08_1_2_3("R08.1.2.3.txt", "E"),
	
	R13_1_1_1("R13.1.1.1.txt", "S"),
	R13_2_1_1("R13.2.1.1.txt", "S"),
	R13_2_2_1("R13.2.2.1.txt", "S"),
	
	R15_1_1_1("R15.1.1.1.txt", "T"),
	R15_1_1_4("R15.1.1.4.txt", "T"),
	R15_2_1_1("R15.2.1.1.txt", "T"),
	R15_2_1_4("R15.2.1.4.txt", "T");
	
	// ------------------------------------------------------------------------
	
	private static final String PATH;
	
	static {
		PATH = "src" + File.separator 
				+ "test" + File.separator 
				+ "resources" + File.separator 
				+ "expected" + File.separator;
	}
	
	// ------------------------------------------------------------------------
	
	private final String filename;
	private final String objectExpected;
	
	private FactoryExpectedResults(final String filename, final String objectExpected) {
        this.filename = filename;
        this.objectExpected = objectExpected;
    }
	
	// ------------------------------------------------------------------------
	
	public Object getExpectedResult() {
		BufferedReader b;
		try {
			b = new BufferedReader(new FileReader(PATH + filename));
			
			if (objectExpected.equals("S"))
				return getExpectedSerie(b);
			if (objectExpected.equals("T"))
				return getExpectedSeason(b);
			if (objectExpected.equals("E"))
				return getExpectedEpisode(b);
			
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ------------------------------------------------------------------------

	private Serie getExpectedSerie(BufferedReader b) throws IOException {
		String[] fields = b.readLine().split("#");		
		return TestParsers.localSerieParser(fields);
	}
	
	private Season getExpectedSeason(BufferedReader b) throws IOException {
		String[] fields = b.readLine().split("#");		
		return TestParsers.localSeasonParser(fields);
	}
	
	private Episode getExpectedEpisode(BufferedReader b) throws IOException {
		String[] fields = b.readLine().split("#");		
		return TestParsers.localEpisodeParser(fields);
	}

}
