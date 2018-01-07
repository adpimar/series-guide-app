package tests.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.managers.ILocalManager;
import abs.services.ICheckAsViewedService;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Episode;
import impl.model.Season;
import impl.services.CheckAsViewedSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class CheckSeasonAsViewedTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// ------------------------------------------------------------------------
	
	private static ICheckAsViewedService checkAsViewedService;

	@BeforeClass
	public static void inicia() {
		checkAsViewedService = new CheckAsViewedSvc();
	}

	@AfterClass
	public static void termina() {
		checkAsViewedService = null;
	}

	// ------------------------------------------------------------------------------------------------------
	//  Season checkSeasonAsViewed(long codSerie, int airedSeason)
	// ------------------------------------------------------------------------------------------------------
		
	@Test
	public void indicarVistaTemporada_NoVistaConTodosEpisodios_TemporadaVista() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R15_1_1_1.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act		
		Season resultReturned = checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R15_1_1_1.getExpectedResult(), resultReturned);
		assertTrue(compruebaTemporadaVistaConEpisodiosVistos(resultReturned, localManager));
		
	}

	@Test
	public void indicarVistaTemporada_NoVistaConUnEpisodio_Excepcion() {
		
		// Arrange
		thrown.expect(NoEpisodesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R15_1_1_2.getLocalManager());
		
		// Act
		checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Assert
		
	}
		
	@Test
	public void indicarVistaTemporada_NoVistaSinEpisodios_Excepcion() {
		
		// Arrange
		thrown.expect(NoEpisodesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R15_1_1_3.getLocalManager());
		
		// Act
		checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Assert
		
	}
		
	@Test
	public void indicarVistaTemporada_Vista_TemporadaVista() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R15_1_1_4.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act		
		Season resultReturned = checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R15_1_1_4.getExpectedResult(), resultReturned);
		assertTrue(compruebaTemporadaVistaConEpisodiosVistos(resultReturned, localManager));	

	}
	
	@Test
	public void indicarVistaTemporada_SerieAlmacenadaTemporadaNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeasonsStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R15_1_2_1.getLocalManager());
		
		// Act
		checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Assert
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.1.2.2
	
	@Test
	public void indicarVistaTemporada_SerieNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R15_1_2_2.getLocalManager());
		
		// Act
		checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Assert
		
	}
	
	// ------------------------------------------------------------------------
	
	private boolean compruebaTemporadaVistaConEpisodiosVistos(Season season, ILocalManager localManager) {
		if (!localManager.getSeason(season.getCodSeason()).isSeen())
			return false;
		for (Episode episode : season.getEpisodes())
			if (!episode.isSeen())
				return false;
		return true;
	}
		
}