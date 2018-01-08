package tests.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import impl.exceptions.NoSeriesStoredException;
import impl.model.Serie;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class R02_HU1 extends AcceptanceTest {

	// REQUISITO 02
	// Debe permitir visualizar la información que hay almacenada en la BDL sobre
	// una serie concreta.

	// HISTORIA DE USUARIO 02.1
	// Como usuario quiero obtener la información de una de mis series para saber
	// acerca de ella.

	// -----------------------------------------------------------------------------

	// ESCENARIO 02.1.1
	// La serie está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 02.1.1.1

	@Test
	public void obtenerSerieAlmacenada_ExisteUnaSerie_Serie() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R02_1_1_1.getFakeLocalManager());
		
		// When
		Serie resultReturned = seriesGuideApp.getSerie(321060);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R02_1_1_1.getExpectedResult(), resultReturned);
		
	}

	// PRUEBA DE ACEPTACIÓN 02.1.1.2

	@Test
	public void obtenerSerieAlmacenada_ExistenVariasSeries_Serie() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R02_1_1_2.getFakeLocalManager());
		
		// When
		Serie resultReturned = seriesGuideApp.getSerie(260449);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R02_1_1_2.getExpectedResult(), resultReturned);
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 02.1.2
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 02.1.2.1

	@Test
	public void obtenerSerieNoAlmacenada_ExisteUnaSerie_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R02_1_2_1.getFakeLocalManager());
		
		// When
		seriesGuideApp.getSerie(260449);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 02.1.2.2
	
	@Test
	public void obtenerSerieNoAlmacenada_ExistenVariasSeries_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R02_1_2_2.getFakeLocalManager());
		
		// When
		seriesGuideApp.getSerie(000000);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 02.1.2.3

	@Test
	public void obtenerSerieNoAlmacenada_NoExistenSeries_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R02_1_2_3.getFakeLocalManager());
		
		// When
		seriesGuideApp.getSerie(321060);
		
		// Then
		
	}

}
