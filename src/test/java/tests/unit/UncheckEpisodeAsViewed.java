package tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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

public class UncheckEpisodeAsViewed {

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
	//  Episode uncheckEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void indicarNoVistoEpisodio_NoVisto_EpisodioNoVisto() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R08_1_1_1.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act		
		Episode resultReturned = checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 1);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R08_1_1_1.getExpectedResult(), resultReturned);
		assertFalse(localManager.getEpisode(resultReturned.getCodEpisode()).isSeen());
		
	}

		
	@Test
	public void indicarNoVistoEpisodio_VistoNoComentadoNoTodosVistos_EpisodioNoVisto() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R08_1_2_1.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act		
		Episode resultReturned = checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R08_1_2_1.getExpectedResult(), resultReturned);
		assertFalse(localManager.getEpisode(resultReturned.getCodEpisode()).isSeen());
		
	}
	
	@Test
	public void indicarNoVistoEpisodio_VistoComentadoNoTodosVistos_EpisodioNoVistoSinComentario() {
					
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R08_1_2_2.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act		
		Episode resultReturned = checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R08_1_2_2.getExpectedResult(), resultReturned);
		assertFalse(localManager.getEpisode(resultReturned.getCodEpisode()).isSeen());
		
	}
			
	@Test
	public void indicarNoVistoEpisodio_VistoNoComentadoTodosVistos_EpisodioNoVistoTemporadaNoVista() {

		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R08_1_2_3.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);

		// Act		
		Episode resultReturned = checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R08_1_2_3.getExpectedResult(), resultReturned);
		assertFalse(localManager.getEpisode(resultReturned.getCodEpisode()).isSeen());
		assertFalse(localManager.getSeason(resultReturned.getCodSeason()).isSeen());
		
	}

	@Test
	public void indicarNoVistoEpisodio_SerieAlmacenadaTemporadaAlmacenadaEpisodioNoAlmacenado_Excepcion() {
		
		// Arrange
		thrown.expect(NoEpisodesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R08_1_3_1.getLocalManager());

		// Act		
		checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Assert

	}
		
	@Test
	public void indicarNoVistoEpisodio_SerieAlmacenadaTemporadaNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeasonsStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R08_1_3_2.getLocalManager());

		// Act		
		checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Assert

	}
		
	@Test
	public void indicarNoVistoEpisodio_SerieNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R08_1_3_3.getLocalManager());

		// Act		
		checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Assert

	}
	
}