package tests.integration;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.managers.ILocalManager;
import abs.services.IDownloadAndStoreService;
import impl.exceptions.SerieAlreadyStoredException;
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
	
	// ------------------------------------------------------------------------------------------------------
	//  void storeRemoteSerie(Serie remoteSerie)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void almacenarSerieRemota_NoAlmacenada_SerieAlmacenada() {
				
		// Arrange
		Serie mockSerie = (Serie) FactoryMocks.R13_2_1_1.getMock();
		ILocalManager localManager = FactoryLocalManagers.R13_2_1_1.getLocalManager();
		downloadAndStoreService.setLocalManager(localManager);
				
		// Act
		downloadAndStoreService.storeRemoteSerie(mockSerie);

		// Assert
		assertEquals(FactoryExpectedResults.R13_2_1_1.getExpectedResult(), localManager.getSerie(mockSerie.getCodSerie()));
		
	}
	
	@Test
	public void almacenarSerieRemota_Almacenada_Excepcion() {

		// Arrange
		thrown.expect(SerieAlreadyStoredException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R13_2_2_1.getLocalManager());
				
		// Act
		downloadAndStoreService.storeRemoteSerie((Serie) FactoryMocks.R13_2_2_1.getMock());

		// Assert
		
	}
	
}