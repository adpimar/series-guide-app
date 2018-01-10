package tests.integration;

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
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Episode;
import impl.services.GetAndListSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class GetEpisodeTest {
	
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
	// Episode getEpisode(long codSerie, int airedSeason, int airedEpisode)
	// ------------------------------------------------------------------------------------------------------
		
	@Test
	public void obtenerEpisodio_UnaSerieUnaTemporada_Episodio() {
		
		// Arrange
		getAndListService.setLocalManager(FactoryLocalManagers.R05_1_1_1.getLocalManager());
		
		// Act
		Episode resultReturned = getAndListService.getEpisode(321060, 1, 6);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R05_1_1_1.getExpectedResult(), resultReturned);
		
	}
			
	@Test
	public void obtenerEpisodio_UnaSerieVariasTemporadas_Episodio() {
		
		// Arrange
		getAndListService.setLocalManager(FactoryLocalManagers.R05_1_1_2.getLocalManager());
		
		// Act
		Episode resultReturned = getAndListService.getEpisode(305288, 1, 6);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R05_1_1_2.getExpectedResult(), resultReturned);
		
	}
	
	@Test
	public void obtenerEpisodio_VariasSeriesVariasTemporadas_Episodio() {

		// Arrange
		getAndListService.setLocalManager(FactoryLocalManagers.R05_1_1_3.getLocalManager());
		
		// Act
		Episode resultReturned = getAndListService.getEpisode(321060, 1, 6);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R05_1_1_3.getExpectedResult(), resultReturned);
		
	}

	@Test
	public void obtenerEpisodio_SerieAlmacenadaTemporadaAlmaceandaEpisodioNoAlmacenado_Excepcion() {
		
		// Arrange
		thrown.expect(NoEpisodesStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R05_1_2_1.getLocalManager());
		
		// Act
		getAndListService.getEpisode(321060, 1, 6);
		
		// Assert
		
	}

	@Test
	public void obtenerEpisodio_SerieAlmacenadaTemporadaNoAlmaceanda_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeasonsStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R05_1_3_1.getLocalManager());
		
		// Act
		getAndListService.getEpisode(321060, 1, 6);
		
		// Assert
		
	}

	@Test
	public void obtenerEpisodio_SerieNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R05_1_4_1.getLocalManager());
		
		// Act
		getAndListService.getEpisode(321060, 1, 6);
		
		// Assert
		
	}
		
}