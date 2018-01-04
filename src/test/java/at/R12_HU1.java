package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import abs.IRemoteManager;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NoKeywordsOnRemoteSearchException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import resources.MockRemoteSearchSeries;

public class R12_HU1 extends AcceptanceTest {

	// REQUISITO 12
	// Debe permitir la realización de búsquedas por Internet usando los servicios
	// REST que proporciona el API del servidor TheTVDB. Las búsquedas se realizarán
	// siempre mediante palabras clave que puedan aparecer en el título de una
	// serie.

	// HISTORIA DE USUARIO 12.1
	// Como usuario quiero que a través de la aplicación pueda realizar búsquedas de
	// series en TheTVDB mediante palabras clave que puedan aparecer en el título
	// para poder almacenarlas en mi BDL.

	@Mock
	private IRemoteManager remoteManager;
	
	@Before
	public void prepara() {
		MockitoAnnotations.initMocks(this);
		setRemoteManagers(remoteManager);
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.1
	// Existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).
	
	// PRUEBA DE ACEPTACIÓN 12.1.1.1

	@Test
	public void buscarRemotamenteSerie_ConCadenaVacia_Excepcion() {
		
		String searchPattern = "";
		
		// Given
		thrown.expect(NoKeywordsOnRemoteSearchException.class);
		
		// When
		searchService.searchSeriesRemote(searchPattern);
		
		// Then
		
	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.2

	@Test
	public void buscarRemotamenteSerie_ConUnaPalabraClave_Series() {
		
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
		
		// Given
		when(remoteManager.searchRemoteSeries(searchPattern)).thenReturn(MockRemoteSearchSeries.R12_1_1_2.getMockRemoteSearchSeries());
		
		// When
		Map<String, Long> resultReturned = searchService.searchSeriesRemote(searchPattern);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanTodosElementos(resultExpected, resultReturned));
		
	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.3

	@Test
	public void buscarRemotamenteSerie_ConVariasPalabrasClave_Series() {
		
		String searchPattern = "Game of Thrones";
		
		String[] searchSeries = {
				"311939", "Game of Thrones: Cartoon Parody",
				"121361", "Game of Thrones",
				"321282", "Tribe of Hip Hop",
		};
		
		Map<String, Long> resultExpected = new TreeMap<>();
		for (int i = 0; i < searchSeries.length; i += 2)
			resultExpected.put(searchSeries[i + 1], Long.parseLong(searchSeries[i]));
		
		// Given
		when(remoteManager.searchRemoteSeries(searchPattern)).thenReturn(MockRemoteSearchSeries.R12_1_1_3.getMockRemoteSearchSeries());
		
		// When
		Map<String, Long> resultReturned = searchService.searchSeriesRemote(searchPattern);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanTodosElementos(resultExpected, resultReturned));
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.2
	// No existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).

	// PRUEBA DE ACEPTACIÓN 12.1.2.1

	@Test
	public void buscarRemotamenteSerie_NoExisteSerie_Excepcion() {
		
		String searchPattern = "lalilos";
		
		thrown.expect(NotFoundSerieOnRemoteServerException.class);
		
		// Given
		when(remoteManager.searchRemoteSeries(searchPattern)).thenThrow(new NotFoundSerieOnRemoteServerException());
		
		// When
		searchService.searchSeriesRemote(searchPattern);
		
		// Then

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.3
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 12.1.3.1

	@Test
	public void buscarRemotamenteSerie_ErrorDeServidor_Excepcion() {
		
		String searchPattern = "Thrones";
		
		thrown.expect(ErrorOnRemoteServerException.class);
		
		// Given
		when(remoteManager.searchRemoteSeries(searchPattern)).thenThrow(new ErrorOnRemoteServerException());
		
		// When
		searchService.searchSeriesRemote(searchPattern);
		
		// Then
		
	}

	// PRUEBA DE ACEPTACIÓN 12.1.3.2

	@Test
	public void buscarRemotamenteSerie_ErrorDeTimeout_Excepcion() {
		
		String searchPattern = "Thrones";
		
		thrown.expect(TimeoutOnRemoteServerException.class);
		
		// Given
		when(remoteManager.searchRemoteSeries(searchPattern)).thenThrow(new TimeoutOnRemoteServerException());
		
		// When
		searchService.searchSeriesRemote(searchPattern);
		
		// Then
		
	}
	
	// -----------------------------------------------------------------------------

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
