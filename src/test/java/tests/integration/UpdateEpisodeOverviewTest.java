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

import abs.managers.ILocalManager;
import abs.services.IUpdateOverviewService;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongOverviewException;
import impl.model.Episode;
import impl.services.UpdateOverviewSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class UpdateEpisodeOverviewTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// ------------------------------------------------------------------------
	
	private static IUpdateOverviewService updateOverviewService;

	@BeforeClass
	public static void inicia() {
		updateOverviewService = new UpdateOverviewSvc();
	}

	@AfterClass
	public static void termina() {
		updateOverviewService = null;
	}

	// ------------------------------------------------------------------------------------------------------
	//  Episode updateEpisodeOverview(long codSerie, int airedSeason, int airedEpisode, String newOverview)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void modificarSinopsisEpisodio_CadenaVacia_SinopsisModificada() {
		
		// Arrange
		String newOverview = "";		
		ILocalManager localManager = FactoryLocalManagers.R06_1_1_1.getLocalManager();
		updateOverviewService.setLocalManager(localManager);
		
		// Act
		Episode resultReturned = updateOverviewService.updateEpisodeOverview(321060, 1, 4, newOverview);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R06_1_1_1.getExpectedResult(), resultReturned);
		assertEquals(localManager.getEpisode(resultReturned.getCodEpisode()).getOverview(), newOverview);
		
	}
	
	@Test
	public void modificarSinopsisEpisodio_CadenaMenor500Caracteres_SinopsisModificada() {
		
		// Arrange
		String newOverview = 
				"Un doloroso dilema ofrece a OA una nueva perspectiva de los problemas "
				+ "del grupo. Homer decide averiguar el verdadero propósito de los "
				+ "experimentos de Hap.";

		ILocalManager localManager = FactoryLocalManagers.R06_1_1_2.getLocalManager();
		updateOverviewService.setLocalManager(localManager);
		
		// Act
		Episode resultReturned = updateOverviewService.updateEpisodeOverview(321060, 1, 4, newOverview);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R06_1_1_2.getExpectedResult(), resultReturned);
		assertEquals(localManager.getEpisode(resultReturned.getCodEpisode()).getOverview(), newOverview);
		
	}
		
	@Test
	public void modificarSinopsisEpisodio_CadenaMayor500Caracteres_Excepcion() {
			
		// Arrange
		String newOverview = 
				"Un doloroso dilema ofrece a OA una nueva perspectiva de los problemas "
						+ "del grupo. Homer decide averiguar el verdadero propósito de los "
						+ "experimentos de Hap. (…) OA rememora las dramáticas idas y vueltas "
						+ "de su vida desde el accidente que sufrió de niña, el cual la condujo "
						+ "a un encuentro fatídico lejos de casa muchos años después (...). Una "
						+ "vez que OA relata la trágica noche final en lo de Hap, el grupo "
						+ "comienza a ver su historia de otra manera. Los fragmentos del sueño "
						+ "finalmente cobran sentido ... ";
		
		thrown.expect(TooLongOverviewException.class);
		updateOverviewService.setLocalManager(FactoryLocalManagers.R06_1_1_3.getLocalManager());
		
		// Act
		updateOverviewService.updateEpisodeOverview(321060, 1, 4, newOverview);
		
		// Assert	
		
	}

	@Test
	public void modificarSinopsisEpisodio_SerieAlmacenadaTemporadaAlmacenadaEpisodioNoAlmacenado_Excepcion() {
		
		// Arrange
		thrown.expect(NoEpisodesStoredException.class);
		updateOverviewService.setLocalManager(FactoryLocalManagers.R06_1_2_1.getLocalManager());
		
		// Act
		updateOverviewService.updateEpisodeOverview(321060, 1, 4, "");
		
		// Assert
		
	}
		
	@Test
	public void modificarSinopsisEpisodio_SerieAlmacenadaTemporadaNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeasonsStoredException.class);
		updateOverviewService.setLocalManager(FactoryLocalManagers.R06_1_2_2.getLocalManager());
		
		// Act
		updateOverviewService.updateEpisodeOverview(321060, 1, 4, "");
		
		// Assert
		
	}
		
	@Test
	public void modificarSinopsisEpisodio_SerieNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		updateOverviewService.setLocalManager(FactoryLocalManagers.R06_1_2_3.getLocalManager());
		
		// Act
		updateOverviewService.updateEpisodeOverview(321060, 1, 4, "");
		
		// Assert
		
	}

}