package tests.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.services.ISearchService;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NoKeywordsOnRemoteSearchException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.managers.remote.thetvdb.TheTVDBAdapter;
import impl.services.SearchSvc;

public class SearchSeriesRemoteTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// ------------------------------------------------------------------------
	
	private static ISearchService searchService;

	@BeforeClass
	public static void inicia() {
		searchService = new SearchSvc();
		searchService.setRemoteManager(new TheTVDBAdapter());
	}

	@AfterClass
	public static void termina() {
		searchService = null;
	}
	
	// ------------------------------------------------------------------------------------------------------
	//  Map<String, Long> searchSeriesRemote(String pattern)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void buscarSerieRemota_ConCadenaVacia_Excepcion() {
		
		// Arrange
		String searchPattern = "";
		thrown.expect(NoKeywordsOnRemoteSearchException.class);
		
		// Act
		searchService.searchSeriesRemote(searchPattern);
		
		// Assert
		
	}

	@Test
	public void buscarSerieRemota_HayCoincidenciaConUnaPalabraClave_Listado() {
		
		// Arrange
		String searchPattern = "Thrones";	
		String[] searchSeries = {
				"268310", "School of Thrones",
				"273385", "King of Thrones",
				"311939", "Game of Thrones: Cartoon Parody",
				"312618", "Gay of Thrones",
				"309875", "After the Thrones",
				"121361", "Game of Thrones",
				"321282", "Tribe of Hip Hop",
		};
		
		Map<String, Long> resultExpected = new TreeMap<>();
		for (int i = 0; i < searchSeries.length; i += 2)
			resultExpected.put(searchSeries[i + 1], Long.parseLong(searchSeries[i]));
				
		// Act
		Map<String, Long> resultReturned = searchService.searchSeriesRemote(searchPattern);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanTodosElementos(resultExpected, resultReturned));
		
	}

	@Test
	public void buscarSerieRemota_HayCoincidenciaConVariasPalabraClave_Listado() {
		
		// Arrange
		String searchPattern = "Game of Thrones";
		String[] searchSeries = {
				"311939", "Game of Thrones: Cartoon Parody",
				"121361", "Game of Thrones",
				"321282", "Tribe of Hip Hop",
		};
		
		Map<String, Long> resultExpected = new TreeMap<>();
		for (int i = 0; i < searchSeries.length; i += 2)
			resultExpected.put(searchSeries[i + 1], Long.parseLong(searchSeries[i]));
		
		// Act
		Map<String, Long> resultReturned = searchService.searchSeriesRemote(searchPattern);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanTodosElementos(resultExpected, resultReturned));
		
	}


	@Test
	public void buscarSerieRemota_NoHayCoincidencia_Excepcion() {
		
		// Arrange
		String searchPattern = "lalilos";
		thrown.expect(NotFoundSerieOnRemoteServerException.class);
		
		// Act
		System.out.println(searchService.searchSeriesRemote(searchPattern));
		
		// Assert

	}

	@Ignore
	public void buscarSerieRemota_ErrorDeServidor_Excepcion() {

		// Arrange
		String searchPattern = "Thrones";
		thrown.expect(ErrorOnRemoteServerException.class);
		
		// Act
		searchService.searchSeriesRemote(searchPattern);
		
		// Assert
		
	}

	@Ignore
	public void buscarSerieRemota_ErrorDeTimeout_Excepcion() {
				
		// Arrange
		String searchPattern = "Thrones";
		thrown.expect(TimeoutOnRemoteServerException.class);
		
		// Act
		searchService.searchSeriesRemote(searchPattern);
		
		// Assert
		
	}
	
	// ------------------------------------------------------------------------

	private boolean compruebaEstanTodosElementos(Map<String, Long> resultExpected, Map<String, Long> resultReturned) {
		Long value = null;
		for (Entry<String, Long> e : resultExpected.entrySet()) {
			value = resultReturned.get(e.getKey());
			if (value == null || !value.equals(e.getValue()))
				return false;
		}
		return true;
	}
		
}