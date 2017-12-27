package acceptance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import org.hamcrest.core.StringStartsWith;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import abs.ILocalManager;
import abs.services.IUpdateOverviewService;
import impl.Serie;
import impl.services.UpdateOverviewSvc;
import resources.FakeSeriesFactory;

public class R03_HU1 {

	// REQUISITO 03
	// Debe permitir modificar la descripción que hay almacenada en la BDL sobre una
	// serie concreta.

	// HISTORIA DE USUARIO 03.1
	// Como usuario quiero modificar la sinopsis de una de mis series para que se
	// ajuste más a mi parecer.
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// -----------------------------------------------------------------------------

	// ESCENARIO 03.1.1
	// La serie está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 03.1.1.1

	@Test
	public void setSinopsisSerie_CadenaVacia_CadenaVacia() {
		
		ILocalManager localManager;
		
		// --- PARTE SIMULADA -----------------------------
		
		Serie fakeSerie = FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie();
		localManager = mock(ILocalManager.class);
		when(localManager.getSerie(321060)).thenReturn(fakeSerie);

		// --- PARTE REAL ---------------------------------

		// TODO Implementar parte real.

		// --- PRUEBA DEL SERVICIO ------------------------
		
		IUpdateOverviewService updateOverviewService = new UpdateOverviewSvc();
		updateOverviewService.setLocalManager(localManager);
		Serie serieEsperada = updateOverviewService.updateSerieOverview(321060, "");
		
		assertEquals(serieEsperada.getSinopsis(), "");

	}
	
	// PRUEBA DE ACEPTACIÓN 03.1.1.2

	@Test
	public void setSinopsisSerie_CadenaMenor500Caracteres_Cadena() {

		ILocalManager localManager;
		String nuevaSinopsis = 
				"Prairie Johnson es una chica ciega que ha estado desaparecida durante"
				+ " 7 largos años. Un día, vuelve a la comunidad donde se crió con un "
				+ "gran cambio: su vista se ha curado.";
		
		// --- PARTE SIMULADA -----------------------------
		
		Serie fakeSerie = FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie();
		localManager = mock(ILocalManager.class);
		when(localManager.getSerie(321060)).thenReturn(fakeSerie);

		// --- PARTE REAL ---------------------------------

		// TODO Implementar parte real.

		// --- PRUEBA DEL SERVICIO ------------------------
		
		IUpdateOverviewService updateOverviewService = new UpdateOverviewSvc();
		updateOverviewService.setLocalManager(localManager);
		Serie serieEsperada = updateOverviewService.updateSerieOverview(321060, nuevaSinopsis);
		
		assertEquals(serieEsperada.getSinopsis(), nuevaSinopsis);
		
	}
	
	// PRUEBA DE ACEPTACIÓN 03.1.1.3

	@Test
	public void setSinopsisSerie_CadenaMayor500Caracteres_Excepcion() {

		ILocalManager localManager;
		String nuevaSinopsis = 
				"Prairie Johnson es una chica ciega que ha estado desaparecida durante 7"
				+ " largos años. Un día, vuelve a la comunidad donde se crió con un gran "
				+ "cambio: su vista se ha curado. Prairie puede ver. Algunos de sus vecinos "
				+ "creen que es un milagro mientras otros opinan que es algo peligroso, un "
				+ "temible misterio que hay que resolver. A pesar de que su familia y el FBI "
				+ "intentan hacerle hablar sobre qué ha pasado en todo ese tiempo, son "
				+ "incapaces de conseguir información. La joven solo habla con un grupo de...";
		
		// --- PARTE SIMULADA -----------------------------
		
		Serie fakeSerie = FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie();
		localManager = mock(ILocalManager.class);
		when(localManager.getSerie(321060)).thenReturn(fakeSerie);

		// --- PARTE REAL ---------------------------------

		// TODO Implementar parte real.

		// --- PRUEBA DEL SERVICIO ------------------------
		
		IUpdateOverviewService updateOverviewService = new UpdateOverviewSvc();
		updateOverviewService.setLocalManager(localManager);
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(StringStartsWith.startsWith("La nueva sinopsis excede"));
		
		updateOverviewService.updateSerieOverview(321060, nuevaSinopsis);
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 03.1.2
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 03.1.2.1
	
	@Test
	public void setSinopsisSerie_NoExisteSerie_Excepcion() {

		ILocalManager localManager;
		
		// --- PARTE SIMULADA -----------------------------
		
		localManager = mock(ILocalManager.class);
		when(localManager.getSerie(000000)).thenReturn(null);

		// --- PARTE REAL ---------------------------------

		// TODO Implementar parte real.

		// --- PRUEBA DEL SERVICIO ------------------------
		
		IUpdateOverviewService updateOverviewService = new UpdateOverviewSvc();
		updateOverviewService.setLocalManager(localManager);
		
		thrown.expect(NoSuchElementException.class);
		thrown.expectMessage(StringStartsWith.startsWith("No existe la serie"));
		
		updateOverviewService.updateSerieOverview(000000, "");
		
	}

}
