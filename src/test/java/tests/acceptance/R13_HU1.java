package tests.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.model.Serie;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class R13_HU1 extends AcceptanceTest {

	// REQUISITO 13
	// Debe permitir la descarga de todos los datos de una serie concreta para su
	// consulta y su almacenamiento en la BDL si el usuario así lo indica.

	// HISTORIA DE USUARIO 13.1
	// Como usuario quiero que a través de la aplicación pueda descargar de TheTVDB
	// toda la información de una serie para consultarla y decidir si almacenarla o
	// no.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.1
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 13.1.1.1
	
	@Test
	public void descargarSerieRemota_NoAlmacenadaExisteSerieRemota_SerieDescargada() {
		
		Serie resultExpected = (Serie) FactoryExpectedResults.R13_1_1_1.getExpectedResult();
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R13_1_1_1.getLocalManager());
		
		// When
		Serie resultReturned = seriesGuideApp.downloadRemoteSerie(121361);

		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.getCodSerie(), resultReturned.getCodSerie());
		assertEquals(resultExpected.getSeriesName(), resultReturned.getSeriesName());
		
	}
	
	// PRUEBA DE ACEPTACIÓN 13.1.1.2
	
	@Test
	public void descargarSerieRemota_NoAlmacenadaNoExisteSerieRemota_Excepcion() {
		
		thrown.expect(NotFoundSerieOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R13_1_1_2.getLocalManager());
		
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
	
	@Ignore
	public void descargarSerieRemota_ErrorDeServidor_Excepcion() {
		
		thrown.expect(ErrorOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R13_1_3_1.getLocalManager());
		
		// When
		seriesGuideApp.downloadRemoteSerie(121361);
		
		// Then
		
	}

	// PRUEBA DE ACEPTACIÓN 13.1.3.2
	
	@Ignore
	public void descargarSerieRemota_ErrorDeTimeout_Excepcion() {
		
		thrown.expect(TimeoutOnRemoteServerException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R13_1_3_2.getLocalManager());
		
		// When
		seriesGuideApp.downloadRemoteSerie(121361);
		
		// Then
		
	}

}