package tests.unit;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import abs.managers.IRemoteManager;
import abs.services.IDownloadAndStoreService;
import impl.services.DownloadAndStoreSvc;

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
	}

	@AfterClass
	public static void termina() {
		downloadAndStoreService = null;
	}
	
	// ------------------------------------------------------------------------
	
	@Mock
	private IRemoteManager remoteManager;
	
	@Before
	public void prepara() {
		MockitoAnnotations.initMocks(this);
		downloadAndStoreService.setRemoteManager(remoteManager);
	}
	
	// ------------------------------------------------------------------------------------------------------
	//  Season downloadRemoteSeason(long codSerie, int airedSeason)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void descargarTemporada_ExisteSerieExisteTemporadaConVariosEpisodios_TemporadaDescargada() {
		
		long codSerie = 321060;
		int airedSeason = 1;
		
		// Arrange
		//when(remoteManager.getRemoteSeason(codSerie, airedSeason)).thenReturn(MockRemoteSeason.R14_1_1_1.getMockRemoteSeason());
		
		// Act
		//Season resultReturned = getAndListService.getRemoteSeason(codSerie, airedSeason);
		//System.out.println(resultReturned);
		// Assert
		
	}
	
	@Test
	public void descargarTemporada_ExisteSerieExisteTemporadaConUnEpisodio_TemporadaDescargada() {

		// Arrange

		// Act

		// Assert
		
	}
	
	@Test
	public void descargarTemporada_ExisteSerieExisteTemporadaSinEpisodios_TemporadaDescargada() {

		// Arrange

		// Act

		// Assert
		
	}

	@Test
	public void descargarTemporada_ExisteSerieNoExisteTemporada_Excepcion() {

		// Arrange

		// Act

		// Assert
		
	}
	
	@Test
	public void descargarTemporada_NoExisteSerie_Excepcion() {

		// Arrange

		// Act

		// Assert
		
	}

	@Test
	public void descargarTemporada_ErrorDeServidor_Excepcion() {

		// Arrange

		// Act

		// Assert
		
	}
	
	
	@Test
	public void descargarTemporada_ErrorDeTimeout_Excepcion() {

		// Arrange

		// Act

		// Assert
		
	}

}