package impl.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.ISearchService;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Serie;
import javafx.scene.chart.XYChart.Series;

public class SearchSvc implements ISearchService {

	private IRemoteManager remoteManager;
	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public void setRemoteManager(IRemoteManager remoteManager) {
		this.remoteManager = remoteManager;
	}

	@Override
	public Map<String, Long> searchSeriesLocal(String pattern) 
			throws NoSeriesStoredException 
	{
		Map<String, Long> seriesMatched = new HashMap<>();
		
		// Comprueba no cadena vacía
		if (pattern.isEmpty())
			return seriesMatched;
		
		// Comrpueba existen series
		List<Serie> series = localManager.listSeries();
		if (series.isEmpty())
			throw new NoSeriesStoredException();

		// Dame y ordena palabras clave
		String[] keyWords = getCleanKeyWords(pattern);
		Arrays.sort(keyWords);
		
		// Busca coincidencias con las series
		for (Serie serie : series)
			if (doesMatchSerie(keyWords, serie.getSeriesName()))
				seriesMatched.put(serie.getSeriesName(), serie.getCodSerie());

		return seriesMatched;
	}

	@Override
	public Map<String, Long> searchSeriesRemote(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	private String[] getCleanKeyWords(String s) {
		return s.replaceAll("\\W", " ")
				.replaceAll("^ +| +$|( )+", "$1")
				.toLowerCase()
				.split(" ");
	}
	
	private boolean doesMatchSerie(String[] sortedKeyWords, String seriesName) {
		String[] serieKeyWords = getCleanKeyWords(seriesName);
		for (String s : serieKeyWords)
			if (Arrays.binarySearch(sortedKeyWords, s) >= 0)
				return true;
		return false;
	}

}
