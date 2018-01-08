package tests.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.services.ISearchService;
import impl.exceptions.NoKeywordsOnRemoteSearchException;
import impl.exceptions.NoSeriesStoredException;
import impl.services.SearchSvc;
import resources.FactoryLocalManagers;

public class SearchSeriesLocalTest {

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
	
	// ------------------------------------------------------------------------------------------------------
	//  Map<String, Long> searchSeriesLocal(String pattern)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void buscarSerieLocal_AlmacenadaVariasSeriesConCadenaVacia_Excepcion() {
				
		// Arrange
		thrown.expect(NoKeywordsOnRemoteSearchException.class);
		searchService.setLocalManager(FactoryLocalManagers.R11_1_1_1.getFakeLocalManager());
		
		// Act
		searchService.searchSeriesLocal("");
		
		// Assert

	}
		
	@Test
	public void buscarSerieLocal_AlmacenadaVariasSeriesConUnaPalabraClave_Listado() {
		
		// Arrange
		List<String> resultExpected = Arrays.asList(
				"The OA",
				"The Big Bang Theory"
		);
		searchService.setLocalManager(FactoryLocalManagers.R11_1_1_2.getFakeLocalManager());
		
		// Act
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("The");
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanLosTitulos(resultExpected, resultReturned));
		
	}
	
	@Test
	public void buscarSerieLocal_AlmacenadaVariasSeriesConVariasPalabrasClave_Listado() {
		
		// Arrange
		List<String> resultExpected = Arrays.asList(
				"The Big Bang Theory"
		);
		searchService.setLocalManager(FactoryLocalManagers.R11_1_1_3.getFakeLocalManager());
		
		// Act
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("The Big Bang");
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanLosTitulos(resultExpected, resultReturned));
		
	}

	@Test
	public void buscarSerieLocal_NoAlmacenadaVariasSeriesConUnaPalabraClave_ListadoVacio() 	{
		
		// Arrange
		searchService.setLocalManager(FactoryLocalManagers.R11_1_2_1.getFakeLocalManager());
		
		// Act
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("lalilo");
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(0, resultReturned.size());
		
	}
		
	@Test
	public void buscarSerieLocal_NoAlmacenadaVariasSeriesConVariasPalabrasClave_ListadoVacio() {
		
		// Arrange
		searchService.setLocalManager(FactoryLocalManagers.R11_1_2_2.getFakeLocalManager());
		
		// Act
		Map<String, Long> resultReturned = searchService.searchSeriesLocal("lalilo panilo");
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(0, resultReturned.size());
		
	}

	@Test
	public void buscarLocalmenteSerie_NoHaySeriesAlmacenadas_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		searchService.setLocalManager(FactoryLocalManagers.R11_1_3_1.getFakeLocalManager());
		
		// Act
		searchService.searchSeriesLocal("Stranger Things");
		
		// Assert

	}

	// ------------------------------------------------------------------------
	
	private boolean compruebaEstanLosTitulos(List<String> resultExpected, Map<String, Long> resultReturned) {
		for (String s : resultExpected)
			if (!resultReturned.containsKey(s))
				return false;
		return true;
	}
	
}