package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import impl.exceptions.NoSeriesStoredException;
import impl.model.Serie;
import resources.ExpectedSeries;
import resources.FakeLocalManagers;

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
	public void obtenerSerieAlmacenada_ExisteUnaSerie_Serie() throws NoSeriesStoredException {
		
		// Given
		setLocalManagers(FakeLocalManagers.R02_1_1_1.getLocalManager());
		
		// When
		Serie resultReturned = getAndListService.getSerie(321060);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedSeries.R02_1_1_1.getExpectedSerie());

	}

	// PRUEBA DE ACEPTACIÓN 02.1.1.2

	@Test
	public void obtenerSerieAlmacenada_ExistenVariasSeries_Serie() throws NoSeriesStoredException {
		
		// Given
		setLocalManagers(FakeLocalManagers.R02_1_1_2.getLocalManager());
		
		// When
		Serie resultReturned = getAndListService.getSerie(260449);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedSeries.R02_1_1_2.getExpectedSerie());

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 02.1.2
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 02.1.2.1

	@Test
	public void obtenerSerieNoAlmacenada_ExisteUnaSerie_Excepcion() throws NoSeriesStoredException {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R02_1_2_1.getLocalManager());
		
		// When
		getAndListService.getSerie(260449);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 02.1.2.2
	
	@Test
	public void obtenerSerieNoAlmacenada_ExistenVariasSeries_Excepcion() throws NoSeriesStoredException {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R02_1_2_2.getLocalManager());
		
		// When
		getAndListService.getSerie(000000);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 02.1.2.3

	@Test
	public void obtenerSerieNoAlmacenada_NoExistenSeries_Excepcion() throws NoSeriesStoredException {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R02_1_2_3.getLocalManager());
		
		// When
		getAndListService.getSerie(321060);
		
		// Then
		
	}

}
