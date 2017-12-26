package abs;

import java.util.List;

import impl.Serie;

public interface ILocalManager {

	List<String> searchSeries(String pattern);
	
	List<Serie> listSeries();
	
	Serie getSerie(long id);
	
}
