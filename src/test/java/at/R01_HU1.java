package at;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import impl.exceptions.NoSeriesStoredException;
import resources.FakeLocalManagers;

public class R01_HU1 extends AcceptanceTest {

	// REQUISITO 01
	// Debe permitir obtener una lista con los títulos de todas las series
	// almacenadas en la BDL.

	// HISTORIA DE USUARIO 01.1
	// Como usuario quiero obtener un listado de todos los títulos de mis series
	// para saber cuáles estoy siguiendo.

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.1
	// Existen varias series almacenadas en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.1.1

	@Test
	public void listarTitulosSeries_ExistenVariasSeries_DosSeries() {
		
		List<String> resultExpected = Arrays.asList(
				"The OA",
				"Vikings"
		);
		
		// Given
		setLocalManagers(FakeLocalManagers.R01_1_1_1.getLocalManager());
		
		// When
		List<String> resultReturned = getAndListService.listSeriesNames();
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertThat(resultReturned, containsInAnyOrder(resultExpected));

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.2
	// Existe sólo una serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.2.1

	@Test
	public void listarTitulosSeries_ExisteUnaSerie_UnaSerie() {
		
		List<String> resultExpected = Arrays.asList(
				"The OA"
		);
		
		// Given
		setLocalManagers(FakeLocalManagers.R01_1_2_1.getLocalManager());
		
		// When
		List<String> resultReturned = getAndListService.listSeriesNames();
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.size(), resultReturned.size());
		assertThat(resultReturned, containsInAnyOrder(resultExpected));
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.3
	// No existe ninguna serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.3.1

	@Test
	public void listarTitulosSeries_NoExistenSeries_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R01_1_3_1.getLocalManager());
		
		// When
		getAndListService.listSeriesNames();
		
		// Then

	}

}
