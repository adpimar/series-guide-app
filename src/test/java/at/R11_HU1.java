package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import impl.exceptions.NoKeywordsOnRemoteSearchException;
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
	public void buscarLocalmenteSerie_ExisteSerieConCadenaVacia_Excepcion() 
			throws NoSeriesStoredException, NoKeywordsOnRemoteSearchException 
	{
		thrown.expect(NoKeywordsOnRemoteSearchException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_1_1.getLocalManager());
		
		// When
		searchService.searchSeriesLocal("");
		
		// Then

	}
	
	// PRUEBA DE ACEPTACIÓN 11.1.1.2
	
	@Test
	public void buscarLocalmenteSerie_ExisteSerieConUnaPalabraClave_ListaNoVacia() 
			throws NoSeriesStoredException, NoKeywordsOnRemoteSearchException  
	{
		List<String> resultExpected = Arrays.asList(
				"The OA",
				"The Big Bang Theory"
		);
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_1_2.getLocalManager());
		
		// When
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("The");
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanLosTitulos(resultExpected, resultReturned));
	}

	// PRUEBA DE ACEPTACIÓN 11.1.1.3

	
	public void buscarLocalmenteSerie_ExisteSerieConPalabrasClave_ListaNoVacia() 
			throws NoSeriesStoredException, NoKeywordsOnRemoteSearchException  
	{
		List<String> resultExpected = Arrays.asList(
				"The Big Bang Theory"
		);
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_1_3.getLocalManager());
		
		// When
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("The Big Bang");
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanLosTitulos(resultExpected, resultReturned));
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 11.1.2
	// Existen varias series almacenadas en la BDL y no existe la serie a buscar.

	// PRUEBA DE ACEPTACIÓN 11.1.2.1

	@Test
	public void buscarLocalmenteSerie_NoExisteSerieConUnaPalabraClave_ListaVacia() 
			throws NoSeriesStoredException, NoKeywordsOnRemoteSearchException  
	{	
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
	public void buscarLocalmenteSerie_NoExisteSerieConPalabrasClave_ListaVacia() 
			throws NoSeriesStoredException, NoKeywordsOnRemoteSearchException  
	{
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
	public void buscarLocalmenteSerie_NoExistenSeries_Excepcion() 
			throws NoSeriesStoredException, NoKeywordsOnRemoteSearchException  
	{	
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R11_1_3_1.getLocalManager());
		
		// When
		searchService.searchSeriesLocal("Stranger Things");
		
		// Then

	}

	// -----------------------------------------------------------------------------
	
	private boolean compruebaEstanLosTitulos(List<String> resultExpected, Map<String, Long> resultReturned) {
		boolean flag = true;
		for (String s : resultExpected) 
			flag = flag && resultReturned.containsKey(s);
		return flag;
	}
}
