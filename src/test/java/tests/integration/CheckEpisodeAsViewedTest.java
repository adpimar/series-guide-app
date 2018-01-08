package tests.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import impl.services.CheckAsViewedSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class CheckEpisodeAsViewedTest {

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
	//  Episode checkEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void indicarVistoEpisodio_UnicoNoVisto_EpisodioVistoTemporadaVista() {

		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R07_1_1_1.getFakeLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act
		Episode resultReturned = checkAsViewedService.checkEpisodeAsViewed(321060, 1, 1);

		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R07_1_1_1.getExpectedResult(), resultReturned);
		assertTrue(localManager.getEpisode(resultReturned.getCodEpisode()).isSeen());
		assertTrue(localManager.getSeason(resultReturned.getCodSeason()).isSeen());

	}

	@Test
	public void indicarVistoEpisodio_NoUnicoNoVisto_EpisodioVistoTemporadaNoVista() {

		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R07_1_1_2.getFakeLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act
		Episode resultReturned = checkAsViewedService.checkEpisodeAsViewed(321060, 1, 1);

		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R07_1_1_2.getExpectedResult(), resultReturned);
		assertTrue(localManager.getEpisode(resultReturned.getCodEpisode()).isSeen());
		assertFalse(localManager.getSeason(resultReturned.getCodSeason()).isSeen());

	}

	@Test
	public void indicarVistoEpisodio_VistoNoComentado_EpisodioVisto() {

		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R07_1_2_1.getFakeLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act
		Episode resultReturned = checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);

		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R07_1_2_1.getExpectedResult(), resultReturned);
		assertTrue(localManager.getEpisode(resultReturned.getCodEpisode()).isSeen());

	}

	@Test
	public void indicarVistoEpisodio_VistoComentado_EpisodioVisto() {

		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R07_1_2_2.getFakeLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act
		Episode resultReturned = checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);

		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R07_1_2_2.getExpectedResult(), resultReturned);
		assertTrue(localManager.getEpisode(resultReturned.getCodEpisode()).isSeen());

	}

	@Test
	public void indicarVistoEpisodio_SerieAlmacenadaTemporadaAlmacenadaEpisodioNoAlmacenado_Excepcion() {

		// Arrange
		thrown.expect(NoEpisodesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R07_1_3_1.getFakeLocalManager());

		// Act
		checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);

		// Assert

	}

	@Test
	public void indicarVistoEpisodio_SerieAlmacenadaTemporadaNoAlmacenada_Excepcion() {

		// Arrange
		thrown.expect(NoSeasonsStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R07_1_3_2.getFakeLocalManager());

		// Act
		checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);

		// Assert

	}

	@Test
	public void indicarVistoEpisodio_SerieNoAlmacenada_Excepcion() {

		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R07_1_3_3.getFakeLocalManager());

		// Act
		checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);

		// Assert

	}

}