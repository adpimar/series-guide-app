package tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import abs.managers.ILocalManager;
import abs.managers.IRemoteManager;
import abs.services.IDownloadAndStoreService;
import impl.model.Serie;
import impl.services.DownloadAndStoreSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;
import resources.FactoryMocks;

public class StoreRemoteSerieTest {

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
	//  void storeRemoteSerie(Serie remoteSerie)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void almacenarSerieRemota_NoAlmacenada_SerieAlmacenada() {
				
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R13_2_1_1.getLocalManager();
		downloadAndStoreService.setLocalManager(localManager);
				
		// Act
		int resultReturned = downloadAndStoreService.storeRemoteSerie((Serie) FactoryMocks.R13_2_1_1.getMock());

		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R13_2_1_1.getExpectedResult());
		assertEquals(localManager.getSerie(resultReturned.getCodSerie()), FactoryExpectedResults.R13_2_1_1.getExpectedResult());
		
	}
	
	@Test
	public void almacenarSerie_Almacenada_SerieNoAlmacenada() {

		// TODO: Actualizar
		
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R13_2_2_1.getLocalManager();
		downloadAndStoreService.setLocalManager(localManager);
				
		// Act
		int resultReturned = downloadAndStoreService.storeRemoteSerie((Serie) FactoryMocks.R13_2_2_1.getMock());

		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R13_2_2_1.getExpectedResult());
		assertEquals(localManager.getSerie(resultReturned.getCodSerie()), FactoryExpectedResults.R13_2_1_1.getExpectedResult());		
		
	}
	
}