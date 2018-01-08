package tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.services.IGetAndListService;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Serie;
import impl.services.GetAndListSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class GetSerieTest {
	
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
	//  Serie getSerie(long codSerie)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void obtenerSerie_EncontradaEntreUnaSerie_Serie() {
		
		// Arrange
		getAndListService.setLocalManager(FactoryLocalManagers.R02_1_1_1.getFakeLocalManager());
		
		// Act
		Serie resultReturned = getAndListService.getSerie(321060);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R02_1_1_1.getExpectedResult(), resultReturned);
		
	}

	@Test
	public void obtenerSerie_EncontradaEntreVariasSerie_Serie() {
		
		// Arrange
		getAndListService.setLocalManager(FactoryLocalManagers.R02_1_1_2.getFakeLocalManager());
		
		// Act
		Serie resultReturned = getAndListService.getSerie(260449);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R02_1_1_2.getExpectedResult(), resultReturned);
		
	}

	@Test
	public void obtenerSerie_NoEncontradaEntreUnaSerie_Excepcion() {
				
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R02_1_2_1.getFakeLocalManager());
		
		// Act
		getAndListService.getSerie(260449);
		
		// Assert
		
	}
		
	@Test
	public void obtenerSerie_NoEncontradaEntreVariasSerie_Excepcion() {
				
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R02_1_2_2.getFakeLocalManager());
		
		// Act
		getAndListService.getSerie(000000);
		
		// Assert
		
	}
	
	@Test
	public void obtenerSerie_NoHaySeriesAlmacenadas_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R02_1_2_3.getFakeLocalManager());
		
		// Act
		getAndListService.getSerie(321060);
		
		// Assert
		
	}
		
}