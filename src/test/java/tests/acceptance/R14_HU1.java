package tests.acceptance;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import abs.managers.IRemoteManager;
import impl.model.Season;
import resources.MockRemoteSeason;

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
		setRemoteManagers(remoteManager);
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.1
	// La serie existe en TheTVDB + la temporada existe en TheTVDB.

	// PRUEBA DE ACEPTACIÓN 14.1.1.1

	@Test
	public void descargarTemporada_ExisteSerieExisteTemporadaConVariosEpisodios_TemporadaDescargada() {
		
		long codSerie = 321060;
		int airedSeason = 1;
		
		// Given
		//when(remoteManager.getRemoteSeason(codSerie, airedSeason)).thenReturn(MockRemoteSeason.R14_1_1_1.getMockRemoteSeason());
		
		// When
		//Season resultReturned = getAndListService.getRemoteSeason(codSerie, airedSeason);
		//System.out.println(resultReturned);
		// Then
		
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.1.2

	@Test
	public void descargarTemporada_ExisteSerieExisteTemporadaConUnEpisodio_TemporadaDescargada() {

		
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.1.3

	@Test
	public void descargarTemporada_ExisteSerieExisteTemporadaSinEpisodios_TemporadaDescargada() {

		
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.2
	// La serie existe en TheTVDB + la temporada no existe en TheTVDB.

	// PRUEBA DE ACEPTACIÓN 14.1.2.1
	
	@Test
	public void descargarTemporada_ExisteSerieNoExisteTemporada_Excepcion() {

		
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.3
	// La serie no existe en TheTVDB.

	// PRUEBA DE ACEPTACIÓN 14.1.3.1
	
	@Test
	public void descargarTemporada_NoExisteSerie_Excepcion() {

		
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.4
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 14.1.4.1

	@Test
	public void descargarTemporada_ErrorDeServidor_Excepcion() {

		
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.1.4.2
	
	@Test
	public void descargarTemporada_ErrorDeTimeout_Excepcion() {

		
		
	}

}
