package acceptance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.hamcrest.core.StringStartsWith;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import abs.ILocalManager;
import abs.services.IGetAndListService;
import impl.Serie;
import impl.services.GetAndListSvc;
import resources.FakeSeriesFactory;

public class R01_HU1 {

	// REQUISITO 01
	// Debe permitir obtener una lista con los títulos de todas las series
	// almacenadas en la BDL.

	// HISTORIA DE USUARIO 01.1
	// Como usuario quiero obtener un listado de todos los títulos de mis series
	// para saber cuáles estoy siguiendo.

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.1
	// Existen varias series almacenadas en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.1.1

	@Test
	public void listar_ExistenVariasSeries_DosSeries() {

		ILocalManager localManager;
		
		// --- PARTE SIMULADA -----------------------------

		List<Serie> fakeLocalSeries = new LinkedList<>();
		fakeLocalSeries.add(FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie());
		fakeLocalSeries.add(FakeSeriesFactory.VIKINGS_SIN_TEMPORADAS.getSerie());

		localManager = mock(ILocalManager.class);
		when(localManager.listSeries()).thenReturn(fakeLocalSeries);

		// --- PARTE REAL ---------------------------------

		// TODO Implementar parte real.

		// --- PRUEBA DEL SERVICIO ------------------------

		List<String> fakeSeriesList = new LinkedList<>();
		fakeSeriesList.add("The OA");
		fakeSeriesList.add("Vikings");

		IGetAndListService getAndListService = new GetAndListSvc();
		getAndListService.setLocalManager(localManager);
		List<String> seriesList = getAndListService.listSeries();

		assertEquals(seriesList.size(), fakeSeriesList.size());
		assertEquals(seriesList, fakeSeriesList);

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.2
	// Existe sólo una serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.2.1

	@Test
	public void listar_ExisteUnaSerie_UnaSerie() {
		
		ILocalManager localManager;
		
		// --- PARTE SIMULADA -----------------------------

		List<Serie> fakeLocalSeries = new LinkedList<>();
		fakeLocalSeries.add(FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie());

		localManager = mock(ILocalManager.class);
		when(localManager.listSeries()).thenReturn(fakeLocalSeries);

		// --- PARTE REAL ---------------------------------

		// TODO Implementar parte real.

		// --- PRUEBA DEL SERVICIO ------------------------

		List<String> fakeSeriesList = new LinkedList<>();
		fakeSeriesList.add("The OA");

		IGetAndListService getAndListService = new GetAndListSvc();
		getAndListService.setLocalManager(localManager);
		List<String> seriesList = getAndListService.listSeries();

		assertEquals(seriesList.size(), fakeSeriesList.size());
		assertEquals(seriesList, fakeSeriesList);
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.3
	// No existe ninguna serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.3.1

	@Test
	public void listar_NoExistenSeries_Excepcion() {
		
		ILocalManager localManager;
		
		// --- PARTE SIMULADA -----------------------------

		List<Serie> fakeLocalSeries = new LinkedList<>();

		localManager = mock(ILocalManager.class);
		when(localManager.listSeries()).thenReturn(fakeLocalSeries);

		// --- PARTE REAL ---------------------------------

		// TODO Implementar parte real.

		// --- PRUEBA DEL SERVICIO ------------------------

		IGetAndListService getAndListService = new GetAndListSvc();
		getAndListService.setLocalManager(localManager);

		thrown.expect(NoSuchElementException.class);
		thrown.expectMessage(StringStartsWith.startsWith("No existen series."));
		
		getAndListService.listSeries();

	}

}
