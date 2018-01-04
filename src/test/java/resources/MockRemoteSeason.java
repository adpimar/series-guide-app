package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import impl.model.RemoteEpisode;

public enum MockRemoteSeason {
	
	R14_1_1_1("R14.1.1.1.txt"),
	R14_1_1_2("R14.1.1.2.txt"),
	R14_1_1_3("R14.1.1.3.txt");
	
	private static final String PATH;
	
	static {
		PATH = "src" + File.separator 
				+ "test" + File.separator 
				+ "resources" + File.separator 
				+ "mockRemoteSeries" + File.separator;
	}
	
	private final String filename;
	
	private MockRemoteSeason(final String filename) {
        this.filename = filename;
    }

	public RemoteEpisode[] getMockRemoteSeason() {
		List<RemoteEpisode> remoteSeason = new LinkedList<>();
		try {
			BufferedReader b = new BufferedReader(new FileReader(PATH + filename));
			String line;
			while ((line = b.readLine()) != null) {
				String[] fields = line.split("#");
				switch (fields[0].charAt(0)) {
					case 'E': remoteSeason.add(TestParsers.remoteEpisodeParser(fields)); break;
				}
			}
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (RemoteEpisode[]) remoteSeason.toArray();
	}

}
