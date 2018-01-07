package tests.integration;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
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
		List<String> resultReturned = getAndListService.listSeriesNames();
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertThat(resultExpected, containsInAnyOrder(resultReturned.toArray()));
		
	}

	@Test
	public void listarTitulosSeries_UnaSerieAlmacenada_Listado() {
		
		// Arrange
		getAndListService.setLocalManager(FactoryLocalManagers.R01_1_2_1.getLocalManager());
		List<String> resultExpected = Arrays.asList(
				"The OA"
		);
		
		// Act
		List<String> resultReturned = getAndListService.listSeriesNames();
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertThat(resultExpected, containsInAnyOrder(resultReturned.toArray()));
		
	}

	@Test
	public void listarTitulosSeries_NoHaySeriesAlmacenadas_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R01_1_3_1.getLocalManager());
		
		// Act
		getAndListService.listSeriesNames();
		
		// Assert

	}
		
}