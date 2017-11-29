package impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import abs.ISearchService;

public class SeriesGuideApp {

	private ISearchService searchService;
	
	private List<Serie> series;
	
	
	public Map<Long, String> busquedaSeriesServidorRemoto(String pattern) {
		
		if (pattern.isEmpty())
			throw new IllegalArgumentException("REQUERIDO_NOMBRE_PARA_BÚSQUEDA_EN_EL_SERVIDOR_REMOTO");
		
		Map<Long, String> series = new TreeMap<>();
		
		series.put(Long.valueOf(268310), "School of Thrones");
		series.put(Long.valueOf(273385), "King of Thrones");
		series.put(Long.valueOf(311939), "Game of Thrones: Cartoon Parody");
		series.put(Long.valueOf(312618), "Gay of Thrones");
		series.put(Long.valueOf(309875), "After the Thrones");
		series.put(Long.valueOf(121361), "Game of Thrones");
		series.put(Long.valueOf(321282), "Tribe of Hip Hop");
		
		return series;
		
	}
	
}
