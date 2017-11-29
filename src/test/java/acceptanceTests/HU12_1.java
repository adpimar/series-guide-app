package acceptanceTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.hamcrest.core.StringStartsWith;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import impl.SeriesGuideApp;

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

	private static SeriesGuideApp seriesGuideApp;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void creaProgramaPrincipal() {
		seriesGuideApp = new SeriesGuideApp();
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.1
	// Existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).

	// PRUEBA DE ACEPTACIÓN 12.1.1.1

	@Test
	public void busquedaSinPalabrasClave() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(StringStartsWith.startsWith("REQUERIDO_NOMBRE"));
		seriesGuideApp.busquedaSeriesServidorRemoto("");
	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.2

	@Test
	public void busquedaConUnaPalabrasClave() {
		Map<Long, String> series = seriesGuideApp.busquedaSeriesServidorRemoto("Thrones");
		
		String[] serieIdsAndNames = {
				"268310", "School of Thrones",
				"273385", "King of Thrones",
				"311939", "Game of Thrones: Cartoon Parody",
				"312618", "Gay of Thrones",
				"309875", "After the Thrones",
				"121361", "Game of Thrones",
				"321282", "Tribe of Hip Hop"
				};
		
		assertEquals(series.size(), serieIdsAndNames.length / 2);
		
		String serie;
		for (int i = 0; i < serieIdsAndNames.length; i += 2) {
			serie = null;
			assertNotNull(serie = series.get(Long.valueOf(serieIdsAndNames[i])));
			assertEquals(serie, serieIdsAndNames[i+1]);
		}
	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.3

	@Test
	public void busquedaConVariasPalabrasClave() {
		Map<Long, String> series = seriesGuideApp.busquedaSeriesServidorRemoto("Game of Thrones");
		String serie = null;
		assertEquals(series.size(), 1);
		assertNotNull(serie = series.get(Long.valueOf(121361)));
		assertEquals(serie, "Game of Thrones");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.2
	// No existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).

	// PRUEBA DE ACEPTACIÓN 12.1.2.1

	@Test
	public void busquedaDeSerieInexistente() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.3
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 12.1.3.1

	@Test
	public void busquedaConErrorServidor() {

	}

	// PRUEBA DE ACEPTACIÓN 12.1.3.2

	@Test
	public void busquedaConTimeout() {

	}

}
