package tests.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import abs.managers.IRemoteManager;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.model.Serie;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;
import resources.FactoryMocks;

public class R13_HU1 extends AcceptanceTest {

	// REQUISITO 13
	// Debe permitir la descarga de todos los datos de una serie concreta para su
	// consulta y su almacenamiento en la BDL si el usuario así lo indica.

	// HISTORIA DE USUARIO 13.1
	// Como usuario quiero que a través de la aplicación pueda descargar de TheTVDB
	// toda la información de una serie para consultarla y decidir si almacenarla o
	// no.
	
	@Mock
	private IRemoteManager remoteManager;
	
	@Before
	public void prepara() {
		MockitoAnnotations.initMocks(this);
		seriesGuideApp.setRemoteManager(remoteManager);
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.1
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 13.1.1.1
	
	@Test
	public void descargarSerieRemota_NoAlmacenadaExisteSerieRemota_SerieDescargada() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R13_1_1_1.getLocalManager());
		when(remoteManager.getRemoteSerie(121361)).thenReturn((Serie) FactoryMocks.R13_1_1_1.getMock());
		
		// When
		Serie resultReturned = seriesGuideApp.downloadRemoteSerie(121361);

		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R13_1_1_1.getExpectedResult(), resultReturned);
		
	}
	
	// PRUEBA DE ACEPTACIÓN 13.1.1.2
	
	@Test
	public void descargarSerieRemota_NoAlmacenadaNoExisteSerieRemota_Excepcion() {
		
		thrown.expect(NotFoundSerieOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R13_1_1_2.getLocalManager());
		when(remoteManager.getRemoteSerie(999999)).thenThrow(new NotFoundSerieOnRemoteServerException());
		
		// When
		seriesGuideApp.downloadRemoteSerie(999999);
		
		// Then
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.2
	// La serie está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 13.1.2.1
	
	@Test
	public void descargarSerieRemota_AlmacenadaExisteSerie_SerieLocal() {
				
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R13_1_2_1.getLocalManager());
		
		// When
		Serie resultReturned = seriesGuideApp.downloadRemoteSerie(121361);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R13_1_2_1.getExpectedResult(), resultReturned);
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.3
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 13.1.3.1
	
	@Test
	public void descargarSerieRemota_ErrorDeServidor_Excepcion() {
		
		thrown.expect(ErrorOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R13_1_3_1.getLocalManager());
		when(remoteManager.getRemoteSerie(121361)).thenThrow(new ErrorOnRemoteServerException());
		
		// When
		seriesGuideApp.downloadRemoteSerie(121361);
		
		// Then
		
	}

	// PRUEBA DE ACEPTACIÓN 13.1.3.2
	
	@Test
	public void descargarSerieRemota_ErrorDeTimeout_Excepcion() {
		
		thrown.expect(TimeoutOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R13_1_3_2.getLocalManager());
		when(remoteManager.getRemoteSerie(121361)).thenThrow(new TimeoutOnRemoteServerException());
		
		// When
		seriesGuideApp.downloadRemoteSerie(121361);
		
		// Then
		
	}

}