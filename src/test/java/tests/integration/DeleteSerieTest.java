package tests.integration;

import static org.junit.Assert.assertNull;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.managers.ILocalManager;
import abs.services.IDeleteService;
import impl.exceptions.NoSeriesStoredException;
import impl.services.DeleteSvc;
import resources.FactoryLocalManagers;

public class DeleteSerieTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// ------------------------------------------------------------------------
	
	private static IDeleteService deleteService;

	@BeforeClass
	public static void inicia() {
		deleteService = new DeleteSvc();
	}

	@AfterClass
	public static void termina() {
		deleteService = null;
	}
	
	// ------------------------------------------------------------------------------------------------------
	//  void deleteSerie(long codSerie)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void eliminarSerie_ConVariasTemporadas_SerieBorrada() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R10_1_1_1.getFakeLocalManager();
		deleteService.setLocalManager(localManager);
		
		// Act
		deleteService.deleteSerie(305288);
		
		// Assert
		assertNull(localManager.getSerie(305288));
		
	}

	@Test
	public void eliminarSerie_ConUnaTemporada_SerieBorrada() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R10_1_1_2.getFakeLocalManager();
		deleteService.setLocalManager(localManager);
		
		// Act
		deleteService.deleteSerie(305288);
		
		// Assert
		assertNull(localManager.getSerie(305288));
		
	}

	@Test
	public void eliminarSerie_SinTemporadas_SerieBorrada() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R10_1_1_3.getFakeLocalManager();
		deleteService.setLocalManager(localManager);
		
		// Act
		deleteService.deleteSerie(305288);
		
		// Assert
		assertNull(localManager.getSerie(305288));
		
	}
	
	@Test
	public void eliminarSerie_SerieNoAlmacenada_Excepcion() {
				
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		deleteService.setLocalManager(FactoryLocalManagers.R10_1_1_4.getFakeLocalManager());
		
		// Act
		deleteService.deleteSerie(321060);
		
		// Assert

	}

	@Test
	public void eliminarSerie_VariasSeriesAlmacenadas_SerieBorrada() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R10_1_2_1.getFakeLocalManager();
		deleteService.setLocalManager(localManager);
		
		// Act
		deleteService.deleteSerie(305288);
		
		// Assert
		assertNull(localManager.getSerie(305288));
		
	}
	
}