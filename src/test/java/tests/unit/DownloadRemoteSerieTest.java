package tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

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
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.model.Serie;
import impl.services.DownloadAndStoreSvc;
import resources.FactoryExpectedResults;
import resources.FactoryMocks;

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
	//  Serie downloadRemoteSerie(long codSerie)
	// ------------------------------------------------------------------------------------------------------

	@Test
	public void descargarSerieRemota_Existe_SerieDescargada() {
		
		// Arrange
		when(remoteManager.getRemoteSerie(121361)).thenReturn((Serie) FactoryMocks.R13_1_1_1.getMock());
		
		// Act
		Serie resultReturned = downloadAndStoreService.downloadRemoteSerie(121361);

		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R13_1_1_1.getExpectedResult());
		
	}

	
	@Test
	public void descargarSerieRemota_NoExiste_Excepcion() {
		
		// Arrange
		thrown.expect(NotFoundSerieOnRemoteServerException.class);
		when(remoteManager.getRemoteSerie(999999)).thenThrow(new NotFoundSerieOnRemoteServerException());
		
		// Act
		downloadAndStoreService.downloadRemoteSerie(999999);
		
		// Assert
		
	}
	
	@Test
	public void descargarSerieRemota_ErrorDeServidor_Excepcion() {

		// Arrange
		thrown.expect(ErrorOnRemoteServerException.class);
		when(remoteManager.getRemoteSerie(121361)).thenThrow(new ErrorOnRemoteServerException());
		
		// Act
		downloadAndStoreService.downloadRemoteSerie(121361);
		
		// Assert
		
	}
	
	@Test
	public void descargarSerieRemota_ErrorDeTimeout_Excepcion() {
		
		// Arrange
		thrown.expect(TimeoutOnRemoteServerException.class);
		when(remoteManager.getRemoteSerie(121361)).thenThrow(new TimeoutOnRemoteServerException());
		
		// Act
		downloadAndStoreService.downloadRemoteSerie(121361);
		
		// Assert
			
	}
	
}