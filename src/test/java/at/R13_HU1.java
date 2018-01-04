package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import abs.IRemoteManager;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.model.Serie;
import resources.ExpectedSeries;
import resources.MockRemoteSeries;

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
		setRemoteManagers(remoteManager);
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.1
	// Existe la serie en el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 13.1.1.1
	
	@Test
	public void descargarSerie_ExisteSerie_SerieDescargada() {

		long codSerie = 121361;
		
		// Given
		when(remoteManager.getRemoteSerie(codSerie)).thenReturn(MockRemoteSeries.R13_1_1_1.getMockRemoteSerie());
		
		// When
		Serie resultReturned = getAndListService.getRemoteSerie(codSerie);

		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedSeries.R13_1_1_1.getExpectedSerie());
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.2
	// No existe la serie en el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 13.1.2.1
	
	@Test
	public void descargarSerie_NoExisteSerie_Excepcion() {
		
		long codSerie = 999999;

		thrown.expect(NotFoundSerieOnRemoteServerException.class);
		
		// Given
		when(remoteManager.getRemoteSerie(codSerie)).thenThrow(new NotFoundSerieOnRemoteServerException());
		
		// When
		getAndListService.getRemoteSerie(codSerie);
		
		// Then
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.3
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 13.1.3.1
	
	@Test
	public void descargarSerie_ErrorDeServidor_Excepcion() {

		long codSerie = 121361;
		
		thrown.expect(ErrorOnRemoteServerException.class);
		
		// Given
		when(remoteManager.getRemoteSerie(codSerie)).thenThrow(new ErrorOnRemoteServerException());
		
		// When
		getAndListService.getRemoteSerie(codSerie);
		
		// Then
		
	}

	// PRUEBA DE ACEPTACIÓN 13.1.3.2
	
	@Test
	public void descargarSerie_ErrorDeTimeout_Excepcion() {
		
		long codSerie = 121361;

		thrown.expect(TimeoutOnRemoteServerException.class);
		
		// Given
		when(remoteManager.getRemoteSerie(codSerie)).thenThrow(new TimeoutOnRemoteServerException());
		
		// When
		getAndListService.getRemoteSerie(codSerie);
		
		// Then
		
	}

}
