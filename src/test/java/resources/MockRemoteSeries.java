package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import impl.model.RemoteSerie;

public enum MockRemoteSeries {
	
	R13_1_1_1("R13.1.1.1.txt");
	
	private static final String PATH;
	
	static {
		PATH = "src" + File.separator 
				+ "test" + File.separator 
				+ "resources" + File.separator 
				+ "mockRemoteSeries" + File.separator;
	}
	
	private final String filename;
	
	private MockRemoteSeries(final String filename) {
        this.filename = filename;
    }

	public RemoteSerie getMockRemoteSerie() {
		RemoteSerie serie = null;
		try {
			BufferedReader b = new BufferedReader(new FileReader(PATH + filename));
			String[] fields = b.readLine().split("#");		
			serie = TestParsers.remoteSerieParser(fields);
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serie;
	}

}
