package impl.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import abs.managers.ILocalManager;
import abs.managers.IRemoteManager;
import abs.services.ISearchService;
import impl.exceptions.NoKeywordsOnRemoteSearchException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.NotFoundOnRemoteServerException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.model.Serie;

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
	public Map<String, Long> searchSeriesLocal(String pattern) {
		
		// Comprueba existen series
		List<Serie> series = localManager.listSeries();
		if (series.isEmpty())
			throw new NoSeriesStoredException();
		
		// Filtra el patrón y obtén palabras claves
		String[] keyWords = getCleanKeyWords(pattern);
		
		// Comprueba si se han introducido palabras
		if (keyWords.length == 1 && keyWords[0].equals(""))
			throw new NoKeywordsOnRemoteSearchException();
		
		Map<String, Long> seriesMatched = new TreeMap<>();
		
		// Busca coincidencias con las series
		for (Serie serie : series)
			if (doesMatchSerie(keyWords, getCleanKeyWords(serie.getSeriesName())))
				seriesMatched.put(serie.getSeriesName(), serie.getCodSerie());

		return seriesMatched;
	}

	@Override
	public Map<String, Long> searchSeriesRemote(String pattern) {
		
		// Filtra el patrón y obtén palabras claves
		String[] keyWords = getCleanKeyWords(pattern);
		
		// Comprueba si se han introducido palabras
		if (keyWords.length == 1 && keyWords[0].equals(""))
			throw new NoKeywordsOnRemoteSearchException();
		
		Map<String, Long> seriesMatched = new TreeMap<>();
						
		// Busca coincidencias con las series
		try {
			for (Serie serie : remoteManager.searchRemoteSeries(pattern))
				seriesMatched.put(serie.getSeriesName(), serie.getCodSerie());
		} catch(NotFoundOnRemoteServerException e) {
			throw new NotFoundSerieOnRemoteServerException();
		}
		
		return seriesMatched;
	}

	private static String[] getCleanKeyWords(String s) {
		return s.replaceAll("\\W", " ")
				.replaceAll("^ +| +$|( )+", "$1")
				.toLowerCase()
				.split(" ");
	}
	
	private boolean doesMatchSerie(String[] keyWords, String[] serieKeyWords) {
		Set<String> keyWordsSet = new HashSet<>(Arrays.asList(keyWords));
		Set<String> seriekeyWordsSet = new HashSet<>(Arrays.asList(serieKeyWords));
		return seriekeyWordsSet.containsAll(keyWordsSet);
	}
	
}
