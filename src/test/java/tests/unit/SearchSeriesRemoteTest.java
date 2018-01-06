package tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import abs.managers.IRemoteManager;
import abs.services.ISearchService;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NoKeywordsOnRemoteSearchException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.model.Serie;
import impl.services.SearchSvc;
import resources.FactoryMocks;

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
	}

	@AfterClass
	public static void termina() {
		searchService = null;
	}
	
	// ------------------------------------------------------------------------
	
	@Mock
	private IRemoteManager remoteManager;
	
	@Before
	public void prepara() {
		MockitoAnnotations.initMocks(this);
		searchService.setRemoteManager(remoteManager);
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
		
		when(remoteManager.searchRemoteSeries(searchPattern)).thenReturn((List<Serie>) FactoryMocks.R12_1_1_2.getMock());
		
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

		when(remoteManager.searchRemoteSeries(searchPattern)).thenReturn((List<Serie>) FactoryMocks.R12_1_1_3.getMock());
		
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
		when(remoteManager.searchRemoteSeries(searchPattern)).thenThrow(new NotFoundSerieOnRemoteServerException());
		
		// Act
		searchService.searchSeriesRemote(searchPattern);
		
		// Assert

	}

	@Test
	public void buscarSerieRemota_ErrorDeServidor_Excepcion() {
				
		// Arrange
		String searchPattern = "Thrones";
		thrown.expect(ErrorOnRemoteServerException.class);
		when(remoteManager.searchRemoteSeries(searchPattern)).thenThrow(new ErrorOnRemoteServerException());
		
		// Act
		searchService.searchSeriesRemote(searchPattern);
		
		// Assert
		
	}

	@Test
	public void buscarSerieRemota_ErrorDeTimeout_Excepcion() {
				
		// Arrange
		String searchPattern = "Thrones";
		thrown.expect(TimeoutOnRemoteServerException.class);
		when(remoteManager.searchRemoteSeries(searchPattern)).thenThrow(new TimeoutOnRemoteServerException());
		
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