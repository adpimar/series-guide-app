package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongOverviewException;
import impl.model.Serie;
import resources.ExpectedSeries;
import resources.FakeLocalManagers;

public class R03_HU1 extends AcceptanceTest {

	// REQUISITO 03
	// Debe permitir modificar la descripción que hay almacenada en la BDL sobre una
	// serie concreta.

	// HISTORIA DE USUARIO 03.1
	// Como usuario quiero modificar la sinopsis de una de mis series para que se
	// ajuste más a mi parecer.

	// -----------------------------------------------------------------------------

	// ESCENARIO 03.1.1
	// La serie está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 03.1.1.1

	@Test
	public void modificarSinopsisSerie_CadenaVacia_CadenaVacia() {
		
		String newOverview = "";

		// Given
		setLocalManagers(FakeLocalManagers.R03_1_1_1.getLocalManager());

		// When
		Serie resultReturned = updateOverviewService.updateSerieOverview(321060, newOverview);

		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedSeries.R03_1_1_1.getExpectedSerie());
		assertEquals(getAndListService.getSerie(321060).getOverview(), newOverview);
		
	}

	// PRUEBA DE ACEPTACIÓN 03.1.1.2

	@Test
	public void modificarSinopsisSerie_CadenaMenor500Caracteres_Cadena() {
		
		String newOverview = "Prairie Johnson es una chica ciega que ha estado desaparecida durante"
				+ " 7 largos años. Un día, vuelve a la comunidad donde se crió con un "
				+ "gran cambio: su vista se ha curado.";

		// Given
		setLocalManagers(FakeLocalManagers.R03_1_1_2.getLocalManager());

		// When
		Serie resultReturned = updateOverviewService.updateSerieOverview(321060, newOverview);

		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedSeries.R03_1_1_2.getExpectedSerie());
		assertEquals(getAndListService.getSerie(321060).getOverview(), newOverview);
		
	}

	// PRUEBA DE ACEPTACIÓN 03.1.1.3

	@Test
	public void modificarSinopsisSerie_CadenaMayor500Caracteres_Excepcion() {
		
		String newOverview = "Prairie Johnson es una chica ciega que ha estado desaparecida durante 7"
				+ " largos años. Un día, vuelve a la comunidad donde se crió con un gran "
				+ "cambio: su vista se ha curado. Prairie puede ver. Algunos de sus vecinos "
				+ "creen que es un milagro mientras otros opinan que es algo peligroso, un "
				+ "temible misterio que hay que resolver. A pesar de que su familia y el FBI "
				+ "intentan hacerle hablar sobre qué ha pasado en todo ese tiempo, son "
				+ "incapaces de conseguir información. La joven solo habla con un grupo de...";

		thrown.expect(TooLongOverviewException.class);

		// Given
		setLocalManagers(FakeLocalManagers.R03_1_1_3.getLocalManager());

		// When
		updateOverviewService.updateSerieOverview(321060, newOverview);

		// Then
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 03.1.2
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 03.1.2.1

	@Test
	public void modificarSinopsisSerie_NoExisteSerie_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);

		// Given
		setLocalManagers(FakeLocalManagers.R03_1_2_1.getLocalManager());

		// When
		updateOverviewService.updateSerieOverview(321060, "");

		// Then

	}

}
