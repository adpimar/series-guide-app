package tests.unit;

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

public class UncheckSeasonAsViewedTest {

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
	//  Season uncheckSeasonAsViewed(long codSerie, int airedSeason)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void indicarNoVistaTemporada_NoVistaConTodosEpisodios_TemporadaNoVista() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R15_2_1_1.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);
		
		// Act
		Season resultReturned = checkAsViewedService.uncheckSeasonAsViewed(321060, 1);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R15_2_1_1.getExpectedResult());
		assertTrue(compruebaTemporadaNoVistaConEpisodiosNoVistos(resultReturned, localManager));
		
	}

	@Test
	public void indicarNoVistaTemporada_NoVistaConUnEpisodio_TemporadaNoVista() {
		
		// Arrange
		thrown.expect(NoEpisodesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R15_2_1_2.getLocalManager());
		
		// Act
		checkAsViewedService.uncheckSeasonAsViewed(321060, 1);
		
		// Assert
		
	}
		
	@Test
	public void indicarNoVistaTemporada_NoVistaSinEpisodios_TemporadaNoVista() {
		
		// Arrange
		thrown.expect(NoEpisodesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R15_2_1_3.getLocalManager());
		
		// Act
		checkAsViewedService.uncheckSeasonAsViewed(321060, 1);
		
		// Assert
		
	}
		
	@Test
	public void indicarNoVistaTemporada_Vista_TemporadaNoVista() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R15_2_1_4.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);
		
		// Act
		Season resultReturned = checkAsViewedService.uncheckSeasonAsViewed(321060, 1);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R15_2_1_4.getExpectedResult());
		assertTrue(compruebaTemporadaNoVistaConEpisodiosNoVistos(resultReturned, localManager));
		
	}
	
	@Test
	public void indicarNoVistaTemporada_SerieAlmacenadaTemporadaNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeasonsStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R15_2_2_1.getLocalManager());
		
		// Act
		checkAsViewedService.uncheckSeasonAsViewed(321060, 1);
		
		// Assert
		
	}
		
	@Test
	public void indicarNoVistaTemporada_SerieNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R15_2_2_2.getLocalManager());
		
		// Act
		checkAsViewedService.uncheckSeasonAsViewed(321060, 1);
		
		// Assert
		
	}

	// -----------------------------------------------------------------------------
	
	private boolean compruebaTemporadaNoVistaConEpisodiosNoVistos(Season season, ILocalManager localManager) {
		if (localManager.getSeason(season.getCodSeason()).isSeen())
			return false;
		for (Episode episode : season.getEpisodes())
			if (episode.isSeen())
				return false;
		return true;
	}
		
}
