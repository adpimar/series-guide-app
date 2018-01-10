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
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.services.DeleteSvc;
import resources.FactoryLocalManagers;

public class DeleteSeasonTest {

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
	//  void deleteSeason(long codSerie, int airedSeason)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void eliminarTemporada_UnicaConTodosEpisodiosTodosVistos_TemporadaBorrada() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R09_1_1_1.getLocalManager();
		deleteService.setLocalManager(localManager);
		
		// Act
		deleteService.deleteSeason(321060, 1);
		
		// Assert
		assertNull(localManager.getSeason(321060));
		
	}

	// PRUEBA DE ACEPTACIÓN 09.1.1.2

	@Test
	public void eliminarTemporada_UnicaConTodosEpisodiosNoTodosVistos_TemporadaBorrada() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R09_1_1_2.getLocalManager();
		deleteService.setLocalManager(localManager);
		
		// Act
		deleteService.deleteSeason(321060, 1);
		
		// Assert
		assertNull(localManager.getSeason(321060));
		
	}

	@Test
	public void eliminarTemporada_UnicaConUnEpisodio_TemporadaBorrada() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R09_1_1_3.getLocalManager();
		deleteService.setLocalManager(localManager);
		
		// Act
		deleteService.deleteSeason(321060, 1);
		
		// Assert
		assertNull(localManager.getSeason(321060));
		
	}

	@Test
	public void eliminarTemporada_UnicaSinEpisodios_TemporadaBorrada() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R09_1_1_4.getLocalManager();
		deleteService.setLocalManager(localManager);
		
		// Act
		deleteService.deleteSeason(321060, 1);
		
		// Assert
		assertNull(localManager.getSeason(321060));
		
	}


	@Test
	public void eliminarTemporada_NoUnica_TemporadaBorrada() {
				
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R09_1_2_1.getLocalManager();
		deleteService.setLocalManager(localManager);
		
		// Act
		deleteService.deleteSeason(305288, 1);
		
		// Assert
		assertNull(localManager.getSeason(305288));
		
	}

	@Test
	public void eliminarTemporada_SerieAlmacenadaTemporadaNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeasonsStoredException.class);
		deleteService.setLocalManager(FactoryLocalManagers.R09_1_3_1.getLocalManager());
		
		// Act
		deleteService.deleteSeason(321060, 1);
		
		// Assert
		
	}

	@Test
	public void eliminarTemporada_SerieNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		deleteService.setLocalManager(FactoryLocalManagers.R09_1_3_2.getLocalManager());
		
		// Act
		deleteService.deleteSeason(321060, 1);
		
		// Assert

	}

}