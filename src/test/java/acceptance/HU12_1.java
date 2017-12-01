package acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.TreeMap;

import org.hamcrest.core.StringStartsWith;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import abs.IRemoteManager;
import abs.services.ISearchService;
import impl.services.SearchSvc;

public class HU12_1 {

	// 503 Service Unavailable
	// No server is available to handle this request.

	// REQUISITO 12
	// Debe permitir la realización de búsquedas por Internet usando los servicios
	// REST que proporciona el API del servidor TheTVDB. Las búsquedas se realizarán
	// siempre mediante palabras clave que puedan aparecer en el título de una
	// serie.

	// HISTORIA DE USUARIO 12.1
	// Como usuario quiero que a través de la aplicación pueda realizar búsquedas de
	// series en TheTVDB mediante palabras clave que puedan aparecer en el título
	// para poder almacenarlas en mi BDL.

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.1
	// Existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).

	// PRUEBA DE ACEPTACIÓN 12.1.1.1

	@Test
	public void busquedaSinPalabrasClave() {
		IRemoteManager theTVDBMock = mock(IRemoteManager.class);
		when(theTVDBMock.searchSeries("")).thenThrow(new IllegalArgumentException("Error : Requires only one of name, imdbId, zap2itId params."));
		ISearchService searchService = new SearchSvc(theTVDBMock, null);
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(StringStartsWith.startsWith("REQUERIDO_NOMBRE"));	
		
		searchService.searchSeriesRemote("");
	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.2

	@Test
	public void busquedaConUnaPalabrasClave() {
		Map<Long, String> fakeListSeries = new TreeMap<>();
		
		String[] serieIdsAndNames = {
				"268310", "School of Thrones",
				"273385", "King of Thrones",
				"311939", "Game of Thrones: Cartoon Parody",
				"312618", "Gay of Thrones",
				"309875", "After the Thrones",
				"121361", "Game of Thrones",
				"321282", "Tribe of Hip Hop"
				};
		
		for (int i = 0; i < serieIdsAndNames.length; i += 2)
			fakeListSeries.put(Long.parseLong(serieIdsAndNames[i]), serieIdsAndNames[i+1]);
		
		IRemoteManager theTVDBMock = mock(IRemoteManager.class);
		when(theTVDBMock.searchSeries("Thrones")).thenReturn(fakeListSeries);
		
		ISearchService searchService = new SearchSvc(theTVDBMock, null);
		Map<Long, String> listSeries = searchService.searchSeriesRemote("Thrones");
		
		assertEquals(listSeries.size(), fakeListSeries.size());
		assertEquals(listSeries, fakeListSeries);
	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.3

	@Test
	public void busquedaConVariasPalabrasClave() {
		Map<Long, String> fakeListSeries = new TreeMap<>();
		fakeListSeries.put(Long.valueOf(121361), "Game of Thrones");
		
		IRemoteManager theTVDBMock = mock(IRemoteManager.class);
		when(theTVDBMock.searchSeries("Game of Thrones")).thenReturn(fakeListSeries);
		
		ISearchService searchService = new SearchSvc(theTVDBMock, null);
		Map<Long, String> listSeries = searchService.searchSeriesRemote("Game of Thrones");
		
		String serie = null;
		assertEquals(listSeries.size(), 1);
		assertNotNull(serie = listSeries.get(Long.valueOf(121361)));
		assertEquals(serie, "Game of Thrones");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.2
	// No existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).

	// PRUEBA DE ACEPTACIÓN 12.1.2.1

	@Test
	public void busquedaDeSerieInexistente() {
		fail();
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.3
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 12.1.3.1

	@Test
	public void busquedaConErrorServidor() {
		fail();
	}

	// PRUEBA DE ACEPTACIÓN 12.1.3.2

	@Test
	public void busquedaConTimeout() {
		fail();
	}

}
