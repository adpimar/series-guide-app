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

public class StoreRemoteSeasonTest {

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
	//  void storeRemoteSeason(Serie serie, Season remoteSeason)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void almacenarTemporada_SerieNoAlmacenada_SerieAlmacenadaTemporadaAlmacenada() {

		// Arrange

		// Act

		// Assert
		
	}

	@Test
	public void almacenarTemporada_NoAlmacenada_TemporadaAlmacenada() {

		// Arrange

		// Act

		// Assert
		
	}

	@Test
	public void almacenarTemporada_Almacenada_Excepcion() {

		// Arrange

		// Act

		// Assert
		
	}
	
}