package tests.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.managers.ILocalManager;
import abs.services.IDownloadAndStoreService;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.NotFoundSeasonOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.managers.remote.thetvdb.TheTVDBAdapter;
import impl.model.Episode;
import impl.model.Season;
import impl.services.DownloadAndStoreSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class DownloadRemoteSeasonTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// ------------------------------------------------------------------------
	
	private static IDownloadAndStoreService downloadAndStoreService;

	@BeforeClass
	public static void inicia() {
		downloadAndStoreService = new DownloadAndStoreSvc();
		downloadAndStoreService.setRemoteManager(new TheTVDBAdapter());
	}

	@AfterClass
	public static void termina() {
		downloadAndStoreService = null;
	}
	
	// ------------------------------------------------------------------------------------------------------
	//  Season downloadRemoteSeason(long codSerie, int airedSeason)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void descargarTemporadaRemota_NoAlmacenadaExisteSerieRemotaExisteTemporadaRemota_TemporadaRemota() {
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R14_1_1_1.getLocalManager();
		Season resultExpected = (Season) FactoryExpectedResults.R14_1_1_1.getExpectedResult();
		downloadAndStoreService.setLocalManager(localManager);
		
		// Act
		Season resultReturned = downloadAndStoreService.downloadRemoteSeason(321060, 1);

		// Assert
		assertNotNull(resultReturned);
		assertTrue(compruebaMismaTemporadaMismosEpisodios(resultExpected, resultReturned));
		
	}
	
	@Test
	public void descargarTemporadaRemota_NoAlmacenadaExisteSerieRemotaNoExisteTemporadaRemota_Excepcion() {
			
		// Arrange
		thrown.expect(NotFoundSeasonOnRemoteServerException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R14_1_1_2.getLocalManager());
		
		// Act
		downloadAndStoreService.downloadRemoteSeason(321060, 4);

		// Assert
		
	}
	
	@Test
	public void descargarTemporadaRemota_NoAlmacenadaNoExisteSerieRemota_Excepcion() {
		
		// Arrange
		thrown.expect(NotFoundSeasonOnRemoteServerException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R14_1_1_3.getLocalManager());
		
		// Act
		downloadAndStoreService.downloadRemoteSeason(999999, 1);

		// Assert
		
	}

	@Test
	public void descargarTemporadaRemota_AlmacenadaConTodosEpisodios_TemporadaLocal() {

		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R14_1_2_1.getLocalManager();
		Season resultExpected = (Season) FactoryExpectedResults.R14_1_2_1.getExpectedResult();
		downloadAndStoreService.setLocalManager(localManager);
		
		// Act
		Season resultReturned = downloadAndStoreService.downloadRemoteSeason(321060, 1);

		// Assert
		assertNotNull(resultReturned);
		assertTrue(compruebaMismaTemporadaMismosEpisodios(resultExpected, resultReturned));
		
	}
		
	@Test
	public void descargarTemporadaRemota_AlmacenadaConUnEpisodio_TemporadaLocal() {

		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R14_1_2_2.getLocalManager();
		Season resultExpected = (Season) FactoryExpectedResults.R14_1_2_2.getExpectedResult();
		downloadAndStoreService.setLocalManager(localManager);
		
		// Act
		Season resultReturned = downloadAndStoreService.downloadRemoteSeason(321060, 1);

		// Assert
		assertNotNull(resultReturned);
		assertTrue(compruebaMismaTemporadaMismosEpisodios(resultExpected, resultReturned));
		
	}
		
	@Test
	public void descargarTemporadaRemota_AlmacenadaSinEpisodios_TemporadaLocal() {
	
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R14_1_2_3.getLocalManager();
		Season resultExpected = (Season) FactoryExpectedResults.R14_1_2_3.getExpectedResult();
		downloadAndStoreService.setLocalManager(localManager);
		
		// Act
		Season resultReturned = downloadAndStoreService.downloadRemoteSeason(321060, 1);

		// Assert
		assertNotNull(resultReturned);
		assertTrue(compruebaMismaTemporadaMismosEpisodios(resultExpected, resultReturned));
		
	}

	@Test
	public void descargarTemporadaRemota_SerieNoAlmacenada_Excepcion() {
	
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R14_1_3_1.getLocalManager());
		
		// Act
		downloadAndStoreService.downloadRemoteSeason(321060, 1);

		// Assert
		
	}

	@Ignore
	public void descargarTemporadaRemota_ErrorDeServidor_Excepcion() {
		
		// Arrange
		thrown.expect(ErrorOnRemoteServerException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R14_1_4_1.getLocalManager());
		
		// Act
		downloadAndStoreService.downloadRemoteSeason(321060, 1);

		// Assert
		
	}

	@Ignore
	public void descargarTemporadaRemota_ErrorDeTimeout_Excepcion() {
		
		// Arrange
		thrown.expect(TimeoutOnRemoteServerException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R14_1_4_2.getLocalManager());
		
		// Act
		downloadAndStoreService.downloadRemoteSeason(321060, 1);

		// Assert
		
	}

	// -----------------------------------------------------------------------------
	
	private boolean compruebaMismaTemporadaMismosEpisodios(Season seasonExpected, Season seasonReturned) {
		if (seasonExpected.getCodSeason() != seasonReturned.getCodSeason() || 
			seasonExpected.getTotalEpisodes() != seasonReturned.getTotalEpisodes())
			return false;
		
		Episode[] seasonExpectedEpisodes = seasonExpected.getEpisodes();
		Episode[] seasonReturnedEpisodes = seasonReturned.getEpisodes();
		
		for (int i = 0; i < seasonExpectedEpisodes.length; i++)
			if (seasonExpectedEpisodes[i] != null && seasonReturnedEpisodes[i] != null)
				if (seasonExpectedEpisodes[i].getCodEpisode() != seasonReturnedEpisodes[i].getCodEpisode())
					return false;
						
		return true;
	}

}