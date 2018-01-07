package tests.acceptance;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import abs.managers.ILocalManager;
import abs.managers.IRemoteManager;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.NotFoundSeasonOnRemoteServerException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.model.Episode;
import impl.model.Season;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;
import resources.FactoryMocks;

public class R14_HU1 extends AcceptanceTest {

	// REQUISITO 14
	// Debe permitir la descarga del título y la descripción de todos los episodios
	// que conforman una temporada concreta de una serie dada y su almacenamiento en
	// la BDL si el usuario así lo indica.

	// HISTORIA DE USUARIO 14.1
	// Como usuario quiero que a través de la aplicación pueda descargar de TheTVDB
	// toda la información de una temporada (títulos y descripciones de los
	// episodios) de una serie para consultarta y decidir si almacenarla o no.

	@Mock
	private IRemoteManager remoteManager;
	
	@Before
	public void prepara() {
		MockitoAnnotations.initMocks(this);
		seriesGuideApp.setRemoteManager(remoteManager);
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.1
	// La serie está almacenada en la BDL + la temporada no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 14.1.1.1

	@Test
	public void descargarTemporadaRemota_NoAlmacenadaExisteSerieRemotaExisteTemporadaRemota_TemporadaRemota() {

		ILocalManager localManager = FactoryLocalManagers.R14_1_1_1.getLocalManager();
		Season mockSeason = (Season) FactoryMocks.R14_1_1_1.getMock();
		Season resultExpected = (Season) FactoryExpectedResults.R14_1_1_1.getExpectedResult();
		
		// Given
		seriesGuideApp.setLocalManager(localManager);
		when(remoteManager.getRemoteSeason(321060, 1)).thenReturn(mockSeason);
		
		// When
		Season resultReturned = seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		assertNotNull(resultReturned);
		assertTrue(compruebaMismaTemporadaMismosEpisodios(resultExpected, resultReturned));
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.1.2

	@Test
	public void descargarTemporadaRemota_NoAlmacenadaExisteSerieRemotaNoExisteTemporadaRemota_Excepcion() {

		thrown.expect(NotFoundSeasonOnRemoteServerException.class);
				
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_1_2.getLocalManager());
		when(remoteManager.getRemoteSeason(321060, 4)).thenThrow(NotFoundSeasonOnRemoteServerException.class);
		
		// When
		seriesGuideApp.downloadRemoteSeason(321060, 4);

		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.1.3

	@Test
	public void descargarTemporadaRemota_NoAlmacenadaNoExisteSerieRemota_Excepcion() {

		thrown.expect(NotFoundSerieOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_1_3.getLocalManager());
		when(remoteManager.getRemoteSeason(321060, 1)).thenThrow(NotFoundSerieOnRemoteServerException.class);
		
		// When
		seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.2
	// La serie está almacenada en la BDL + la temporada está almacenada en la BDL.	

	// PRUEBA DE ACEPTACIÓN 14.1.2.1
	
	@Test
	public void descargarTemporadaRemota_AlmacenadaConTodosEpisodios_TemporadaLocal() {

		ILocalManager localManager = FactoryLocalManagers.R14_1_2_1.getLocalManager();
		Season resultExpected = (Season) FactoryExpectedResults.R14_1_2_1.getExpectedResult();
		
		// Given
		seriesGuideApp.setLocalManager(localManager);
		
		// When
		Season resultReturned = seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		assertNotNull(resultReturned);
		assertTrue(compruebaMismaTemporadaMismosEpisodios(resultExpected, resultReturned));
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.2.2
	
	@Test
	public void descargarTemporadaRemota_AlmacenadaConUnEpisodio_TemporadaLocal() {

		ILocalManager localManager = FactoryLocalManagers.R14_1_2_2.getLocalManager();
		Season resultExpected = (Season) FactoryExpectedResults.R14_1_2_2.getExpectedResult();
		
		// Given
		seriesGuideApp.setLocalManager(localManager);
		
		// When
		Season resultReturned = seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		assertNotNull(resultReturned);
		assertTrue(compruebaMismaTemporadaMismosEpisodios(resultExpected, resultReturned));
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.2.3
	
	@Test
	public void descargarTemporadaRemota_AlmacenadaSinEpisodios_TemporadaLocal() {

		ILocalManager localManager = FactoryLocalManagers.R14_1_2_3.getLocalManager();
		Season resultExpected = (Season) FactoryExpectedResults.R14_1_2_3.getExpectedResult();
		
		// Given
		seriesGuideApp.setLocalManager(localManager);
		
		// When
		Season resultReturned = seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		assertNotNull(resultReturned);
		assertTrue(compruebaMismaTemporadaMismosEpisodios(resultExpected, resultReturned));
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.3
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 14.1.3.1
	
	@Test
	public void descargarTemporadaRemota_SerieNoAlmacenada_Excepcion() {

		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_3_1.getLocalManager());
		when(remoteManager.getRemoteSeason(321060, 1)).thenThrow(NoSeriesStoredException.class);
		
		// When
		seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.4
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 14.1.4.1

	@Test
	public void descargarTemporadaRemota_ErrorDeServidor_Excepcion() {

		thrown.expect(ErrorOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_4_1.getLocalManager());
		when(remoteManager.getRemoteSeason(321060, 1)).thenThrow(ErrorOnRemoteServerException.class);
		
		// When
		seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.4.2
	
	@Test
	public void descargarTemporadaRemota_ErrorDeTimeout_Excepcion() {

		thrown.expect(TimeoutOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_4_2.getLocalManager());
		when(remoteManager.getRemoteSeason(321060, 1)).thenThrow(TimeoutOnRemoteServerException.class);
		
		// When
		seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		
	}

	// -----------------------------------------------------------------------------
	
	private boolean compruebaMismaTemporadaMismosEpisodios(Season seasonExpected, Season seasonReturned) {
		if (!seasonExpected.equals(seasonReturned))
			return false;
		Episode[] seasonExpectedEpisodes = seasonExpected.getEpisodes();
		Episode[] seasonReturnedEpisodes = seasonReturned.getEpisodes();
		return Arrays.equals(seasonExpectedEpisodes, seasonReturnedEpisodes);
	}
	
}