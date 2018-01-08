package tests.acceptance;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import abs.managers.ILocalManager;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.NotFoundSeasonOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.model.Episode;
import impl.model.Season;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class R14_HU1 extends AcceptanceTest {

	// REQUISITO 14
	// Debe permitir la descarga del título y la descripción de todos los episodios
	// que conforman una temporada concreta de una serie dada y su almacenamiento en
	// la BDL si el usuario así lo indica.

	// HISTORIA DE USUARIO 14.1
	// Como usuario quiero que a través de la aplicación pueda descargar de TheTVDB
	// toda la información de una temporada (títulos y descripciones de los
	// episodios) de una serie para consultarta y decidir si almacenarla o no.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.1
	// La serie está almacenada en la BDL + la temporada no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 14.1.1.1

	@Test
	public void descargarTemporadaRemota_NoAlmacenadaExisteSerieRemotaExisteTemporadaRemota_TemporadaRemota() {

		ILocalManager localManager = FactoryLocalManagers.R14_1_1_1.getFakeLocalManager();
		Season resultExpected = (Season) FactoryExpectedResults.R14_1_1_1.getExpectedResult();
		
		// Given
		seriesGuideApp.setLocalManager(localManager);
		
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
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_1_2.getFakeLocalManager());
		
		// When
		seriesGuideApp.downloadRemoteSeason(321060, 4);

		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.1.3

	@Test
	public void descargarTemporadaRemota_NoAlmacenadaNoExisteSerieRemota_Excepcion() {

		thrown.expect(NotFoundSeasonOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_1_3.getFakeLocalManager());
		
		// When
		seriesGuideApp.downloadRemoteSeason(999999, 1);

		// Then
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.2
	// La serie está almacenada en la BDL + la temporada está almacenada en la BDL.	

	// PRUEBA DE ACEPTACIÓN 14.1.2.1
	
	@Test
	public void descargarTemporadaRemota_AlmacenadaConTodosEpisodios_TemporadaLocal() {

		ILocalManager localManager = FactoryLocalManagers.R14_1_2_1.getFakeLocalManager();
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

		ILocalManager localManager = FactoryLocalManagers.R14_1_2_2.getFakeLocalManager();
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

		ILocalManager localManager = FactoryLocalManagers.R14_1_2_3.getFakeLocalManager();
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
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_3_1.getFakeLocalManager());
		
		// When
		seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.4
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 14.1.4.1

	@Ignore
	public void descargarTemporadaRemota_ErrorDeServidor_Excepcion() {

		thrown.expect(ErrorOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_4_1.getFakeLocalManager());
		
		// When
		seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.4.2
	
	@Ignore
	public void descargarTemporadaRemota_ErrorDeTimeout_Excepcion() {

		thrown.expect(TimeoutOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_1_4_2.getFakeLocalManager());
		
		// When
		seriesGuideApp.downloadRemoteSeason(321060, 1);

		// Then
		
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