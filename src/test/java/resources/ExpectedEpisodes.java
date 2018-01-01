package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import impl.model.Episode;

public enum ExpectedEpisodes {

	R05_1_1_1("R05.1.1.1.txt"),
	R05_1_1_2("R05.1.1.2.txt"),
	R05_1_1_3("R05.1.1.3.txt"),
	
	R06_1_1_1("R06.1.1.1.txt"),
	R06_1_1_2("R06.1.1.2.txt"),
	
	R07_1_1_1("R07.1.1.1.txt"),
	R07_1_1_2("R07.1.1.2.txt"),
	R07_2_2_1("R07.2.2.1.txt"),
	R07_2_2_2("R07.2.2.2.txt"),
	R07_2_3_1("R07.2.3.1.txt"),
	
	R08_1_2_1("R08.1.2.1.txt"),
	R08_1_2_2("R08.1.2.2.txt"),
	R08_1_2_3("R08.1.2.3.txt");
	
	private static final String PATH;
	
	static {
		PATH = "src" + File.separator 
				+ "test" + File.separator 
				+ "resources" + File.separator 
				+ "expectedEpisodes" + File.separator;
	}
	
	private final String filename;
	
	private ExpectedEpisodes(final String filename) {
        this.filename = filename;
    }

	public Episode getExpectedEpisode() {
		Episode episode = null;
		try {
			BufferedReader b = new BufferedReader(new FileReader(PATH + filename));
			String[] fields = b.readLine().split("#");		
			episode = TestParsers.localEpisodeParser(fields);
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return episode;
	}

}
