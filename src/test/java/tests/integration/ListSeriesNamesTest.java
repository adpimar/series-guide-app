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

import abs.services.IGetAndListService;
import impl.exceptions.NoSeriesStoredException;
import impl.services.GetAndListSvc;
import resources.FactoryLocalManagers;

public class ListSeriesNamesTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// ------------------------------------------------------------------------
	
	private static IGetAndListService getAndListService;

	@BeforeClass
	public static void inicia() {
		getAndListService = new GetAndListSvc();
	}

	@AfterClass
	public static void termina() {
		getAndListService = null;
	}

	// ------------------------------------------------------------------------------------------------------
	//  List<String> listSeriesNames()
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void listarTitulosSeries_VariasSeriesAlmacenadas_Listado() {
		
		// Arrange
		getAndListService.setLocalManager(FactoryLocalManagers.R01_1_1_1.getLocalManager());
		List<String> resultExpected = Arrays.asList(
				"The OA",
				"Vikings"
		);
		
		// Act
		Map<String, Long> resultReturned = getAndListService.listSeriesNames();
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanLosTitulos(resultExpected, resultReturned));
		
	}

	@Test
	public void listarTitulosSeries_UnaSerieAlmacenada_Listado() {
		
		// Arrange
		getAndListService.setLocalManager(FactoryLocalManagers.R01_1_2_1.getFakeLocalManager());
		List<String> resultExpected = Arrays.asList(
				"The OA"
		);
		
		// Act
		Map<String, Long> resultReturned = getAndListService.listSeriesNames();
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertTrue(compruebaEstanLosTitulos(resultExpected, resultReturned));
		
	}

	@Test
	public void listarTitulosSeries_NoHaySeriesAlmacenadas_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R01_1_3_1.getFakeLocalManager());
		
		// Act
		getAndListService.listSeriesNames();
		
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