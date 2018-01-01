package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import impl.exceptions.NoSeriesStoredException;
import resources.FakeLocalManagers;

public class R11_HU1 extends AcceptanceTest {

	// REQUISITO 11
	// Debe permitir la realización de búsquedas de series en la BDL mediante
	// palabras clave que puedan aparecer en su título.

	// HISTORIA DE USUARIO 11.1
	// Como usuario quiero realizar búsquedas de series en mi BDL mediante palabras
	// clave que puedan aparecer en el título para poder consultarlas.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 11.1.1
	// Existen varias series almacenadas en la BDL y existe la serie a buscar.

	// PRUEBA DE ACEPTACIÓN 11.1.1.1

	@Test
	public void buscarLocalmenteSerie_ConCadenaVacia_ListaVacia() {
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_1_1.getLocalManager());
		
		// When
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("");
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(0, resultReturned.size());
		
	}
	
	// PRUEBA DE ACEPTACIÓN 11.1.1.2
	
	@Test
	public void buscarLocalmenteSerie_ConUnaPalabraClave_ListaNoVacia() {
		
		List<String> resultExpected = Arrays.asList(
				"The OA",
				"The Big Band Theory"
		);
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_1_2.getLocalManager());
		
		// When
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("The");
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		resultReturned.keySet().removeAll(resultExpected);
		assertEquals(0, resultReturned.size());

	}

	// PRUEBA DE ACEPTACIÓN 11.1.1.3

	@Test
	public void buscarLocalmenteSerie_ConPalabrasClave_ListaNoVacia() {
		
		List<String> resultExpected = Arrays.asList(
				"The Big Band Theory"
		);
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_1_3.getLocalManager());
		
		// When
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("The Big Bang");
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		resultReturned.keySet().removeAll(resultExpected);
		assertEquals(0, resultReturned.size());
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 11.1.2
	// Existen varias series almacenadas en la BDL y no existe la serie a buscar.

	// PRUEBA DE ACEPTACIÓN 11.1.2.1

	@Test
	public void buscarLocalmenteSerie_ConUnaPalabraClave_ListaVacia() {
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_2_1.getLocalManager());
		
		// When
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("lalilo");
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(0, resultReturned.size());

	}
	
	// PRUEBA DE ACEPTACIÓN 11.1.2.2
	
	@Test
	public void buscarLocalmenteSerie_ConPalabrasClave_ListaVacia() {
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_2_2.getLocalManager());
		
		// When
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("lalilo panilo");
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(0, resultReturned.size());

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 11.1.3
	// No existe ninguna serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 11.1.3.1
	
	@Test
	public void buscarLocalmenteSerie_NoExistenSeries_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_3_1.getLocalManager());
		
		// When
		searchService.searchSeriesLocal("Stranger Things");
		
		// Then

	}

}
