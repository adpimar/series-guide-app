package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import abs.IRemoteManager;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
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
	public void descargarSerie_ExisteSerie_SerieDescargada() throws NoSeriesStoredException {

//		// Given
//		
//		// When
//		when(remoteManager.getSerie(121361)).thenReturn(MockRemoteSeries.R13_1_1_1.getMockRemoteSerie());
//		Serie resultReturned = getAndListService.getSerie(121361);
//
//		// Then
//		assertNotNull(resultReturned);
//		assertEquals(resultReturned, ExpectedSeries.R13_1_1_1.getExpectedSerie());
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.2
	// No existe la serie en el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 13.1.2.1
	
	@Test
	public void descargarSerie_NoExisteSerie_Excepcion() throws NoSeriesStoredException {

//		thrown.expect(NotFoundSerieOnRemoteServerException.class);
//		
//		// Given
//		
//		// When
//		when(remoteManager.getSerie(999999)).thenThrow(new NotFoundSerieOnRemoteServerException());
//		getAndListService.getSerie(999999);
//		
//		// Then
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.3
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 13.1.3.1
	
	@Test
	public void descargarSerie_ErrorDeServidor_Excepcion() {

	}

	// PRUEBA DE ACEPTACIÓN 13.1.3.2
	
	@Test
	public void descargarSerie_ErrorDeTimeout_Excepcion() {

	}

}
