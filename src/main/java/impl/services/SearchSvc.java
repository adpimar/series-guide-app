package impl.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.ISearchService;
import impl.exceptions.NoKeywordsOnRemoteSearchException;
import impl.exceptions.NoSeriesStoredException;
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
	public Map<String, Long> searchSeriesLocal(String pattern) 
			throws NoSeriesStoredException, NoKeywordsOnRemoteSearchException 
	{
		// Comprueba existen series
		List<Serie> series = localManager.listSeries();
		if (series.isEmpty())
			throw new NoSeriesStoredException();
		
		// Filtra el patrón y obtén palabras claves
		String[] keyWords = getCleanKeyWords(pattern);
		
		// Comprueba si se han introducido palabras
		if (keyWords.length == 1 && keyWords[0].equals(""))
			throw new NoKeywordsOnRemoteSearchException();
		
		Map<String, Long> seriesMatched = new HashMap<>();

		Arrays.sort(keyWords);
		
		// Busca coincidencias con las series
		for (Serie serie : series)
			if (doesMatchSerie(keyWords, serie.getSeriesName()))
				seriesMatched.put(serie.getSeriesName(), serie.getCodSerie());

		return seriesMatched;
	}

	@Override
	public Map<String, Long> searchSeriesRemote(String pattern) 
			throws NoKeywordsOnRemoteSearchException 
	{
		// Filtra el patrón y obtén palabras claves
		String[] keyWords = getCleanKeyWords(pattern);
		
		// Comprueba si se han introducido palabras
		if (keyWords.length == 1 && keyWords[0].equals(""))
			throw new NoKeywordsOnRemoteSearchException();
		
		Map<String, Long> seriesMatched = new HashMap<>();
		
		
		
		return null;
	}

	private static String[] getCleanKeyWords(String s) {
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

	public static void main(String[] args) {
		
		String pattern1 = "   \\$    ` ? =  ";
		String pattern2 = "     ";
		String pattern3 = "";
				
		System.out.println(getCleanKeyWords(pattern1)[0].equals(""));
		System.out.println(Arrays.deepToString(getCleanKeyWords(pattern2)));
		System.out.println(Arrays.deepToString(getCleanKeyWords(pattern3)));
		
	}
	
}
