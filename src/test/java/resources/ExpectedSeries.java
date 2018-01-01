package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import impl.model.Serie;

public enum ExpectedSeries {
	
	R02_1_1_1("R02.1.1.1.txt"),
	R02_1_1_2("R02.1.1.2.txt"),
	
	R03_1_1_1("R03.1.1.1.txt"),
	R03_1_1_2("R03.1.1.2.txt"),
	
	R13_1_1_1("R13.1.1.1.txt");
	
	private static final String PATH;
	
	static {
		PATH = "src" + File.separator 
				+ "test" + File.separator 
				+ "resources" + File.separator 
				+ "expectedSeries" + File.separator;
	}
	
	private final String filename;
	
	private ExpectedSeries(final String filename) {
        this.filename = filename;
    }

	public Serie getExpectedSerie() {
		Serie serie = null;
		try {
			BufferedReader b = new BufferedReader(new FileReader(PATH + filename));
			String[] fields = b.readLine().split("#");		
			serie = TestParsers.localSerieParser(fields);
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serie;
	}

}
