package tests.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import abs.managers.ILocalManager;
import impl.model.Serie;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;
import resources.FactoryMocks;

public class R13_HU2 extends AcceptanceTest {

	// REQUISITO 13
	// Debe permitir la descarga de todos los datos de una serie concreta para su
	// consulta y su almacenamiento en la BDL si el usuario así lo indica.

	// HISTORIA DE USUARIO 13.2
	// Como usuario quiero que a través de la aplicación pueda almacenar toda la
	// información de un serie previamente consultada en TheTVDB para disponer de
	// ella desde la BDL.

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.2.1
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 13.2.1.1
	
	@Test
	public void almacenarSerie_SerieNoAlmacenada_SerieAlmacenada() {
				
		// Given
		ILocalManager localManager = FactoryLocalManagers.R13_2_1_1.getLocalManager();
		setLocalManagers(localManager);
				
		// When
		Serie resultReturned = downloadAndStoreService.storeRemoteSerie(FactoryMocks.R13_2_1_1.getMockRemoteSerie());

		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R13_2_1_1.getExpectedSerie());
		assertEquals(localManager.getSerie(resultReturned.getCodSerie()), FactoryExpectedResults.R13_2_1_1.getExpectedSerie());
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.2.2
	// La serie está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 13.2.2.1
	
	@Test
	public void almacenarSerie_SerieAlmacenada_SerieNoAlmacenada() {

		// Given
		ILocalManager localManager = FactoryLocalManagers.R13_2_2_1.getLocalManager();
		setLocalManagers(localManager);
				
		// When
		Serie resultReturned = downloadAndStoreService.storeRemoteSerie(FactoryMocks.R13_2_2_1.getMockRemoteSerie());

		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R13_2_2_1.getExpectedSerie());
		assertEquals(localManager.getSerie(resultReturned.getCodSerie()), FactoryExpectedResults.R13_2_1_1.getExpectedSerie());		
		
	}

}
