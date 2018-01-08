package tests.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.services.IDownloadAndStoreService;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.managers.remote.thetvdb.TheTVDBAdapter;
import impl.model.Serie;
import impl.services.DownloadAndStoreSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class DownloadRemoteSerieTest {

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
	//  Serie downloadRemoteSerie(long codSerie)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void descargarSerieRemota_NoAlmacenadaExisteSerieRemota_SerieDescargada() {
		
		// Arrange
		Serie resultExpected = (Serie) FactoryExpectedResults.R13_1_1_1.getExpectedResult();
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R13_1_1_1.getFakeLocalManager());
		
		// Act
		Serie resultReturned = downloadAndStoreService.downloadRemoteSerie(121361);

		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.getCodSerie(), resultReturned.getCodSerie());
		assertEquals(resultExpected.getSeriesName(), resultReturned.getSeriesName());
		
	}

	
	@Test
	public void descargarSerieRemota_NoAlmacenadaNoExisteSerieRemota_Excepcion() {
		
		// Arrange
		thrown.expect(NotFoundSerieOnRemoteServerException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R13_1_1_2.getFakeLocalManager());
		
		// Act
		downloadAndStoreService.downloadRemoteSerie(999999);
		
		// Assert
		
	}
	
	@Test
	public void descargarSerieRemota_AlmacenadaExisteSerie_SerieLocal() {
				
		// Arrange
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R13_1_2_1.getFakeLocalManager());
		
		// Act
		Serie resultReturned = downloadAndStoreService.downloadRemoteSerie(121361);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R13_1_2_1.getExpectedResult(), resultReturned);
		
	}
	
	@Ignore
	public void descargarSerieRemota_ErrorDeServidor_Excepcion() {

		// Arrange
		thrown.expect(ErrorOnRemoteServerException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R13_1_3_1.getFakeLocalManager());
		
		// Act
		downloadAndStoreService.downloadRemoteSerie(121361);
		
		// Assert
		
	}
	
	@Ignore
	public void descargarSerieRemota_ErrorDeTimeout_Excepcion() {
		
		// Arrange
		thrown.expect(TimeoutOnRemoteServerException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R13_1_3_2.getFakeLocalManager());
		
		// Act
		downloadAndStoreService.downloadRemoteSerie(121361);
		
		// Assert
			
	}
	
}