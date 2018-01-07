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
import impl.exceptions.NoSeriesStoredException;
import impl.model.Season;
import impl.services.DownloadAndStoreSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;
import resources.FactoryMocks;

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
	
	// ------------------------------------------------------------------------------------------------------
	//  void storeRemoteSeason(Serie serie, Season remoteSeason)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void almacenarTemporadaRemota_SerieNoAlmacenada_Excepcion() {

		thrown.expect(NoSeriesStoredException.class);
		
		// Arrange
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R14_2_1_1.getLocalManager());
		
		// Act
		downloadAndStoreService.storeRemoteSeason((Season) FactoryMocks.R14_2_1_1.getMock());

		// Assert
		
	}
	
	@Test
	public void almacenarTemporadaRemota_NoAlmacenadaSerieSinTemporadas_TemporadaAlmacenada() {
				
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R14_2_2_1.getLocalManager();
		Season mockSeason = (Season) FactoryMocks.R14_2_2_1.getMock();
		Season resultExpected = (Season) FactoryExpectedResults.R14_2_2_1.getExpectedResult();
		downloadAndStoreService.setLocalManager(localManager);
				
		// Act
		downloadAndStoreService.storeRemoteSeason(mockSeason);

		// Assert
		assertEquals(resultExpected, localManager.getSeason(mockSeason.getCodSeason()));
		
	}
		
	@Test
	public void almacenarTemporadaRemota_NoAlmacenadaSerieConTemporadas_TemporadaAlmacenada() {
	
		// Arrange
		ILocalManager localManager = FactoryLocalManagers.R14_2_2_2.getLocalManager();
		Season mockSeason = (Season) FactoryMocks.R14_2_2_2.getMock();
		Season resultExpected = (Season) FactoryExpectedResults.R14_2_2_2.getExpectedResult();
		downloadAndStoreService.setLocalManager(localManager);
				
		// Act
		downloadAndStoreService.storeRemoteSeason(mockSeason);

		// Assert
		assertEquals(resultExpected, localManager.getSeason(mockSeason.getCodSeason()));
		
	}
	
	@Test
	public void almacenarTemporadaRemota_Almacenada_Excepcion() {

		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		downloadAndStoreService.setLocalManager(FactoryLocalManagers.R14_2_3_1.getLocalManager());
		
		// Act
		downloadAndStoreService.storeRemoteSeason((Season) FactoryMocks.R14_2_3_1.getMock());

		// Assert
		
	}
	
}