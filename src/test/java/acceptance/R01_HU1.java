package acceptance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.hamcrest.core.StringStartsWith;
import org.junit.After;
import org.junit.Before;
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

	private ILocalManager localManager;
	private IGetAndListService getAndListService;
	private List<Serie> fakeLocalSeries;
	
	@Before
	public void inicia() {
		localManager = mock(ILocalManager.class);
		fakeLocalSeries = new LinkedList<>();
		when(localManager.listSeries()).thenReturn(fakeLocalSeries);
		getAndListService = new GetAndListSvc();
		getAndListService.setLocalManager(localManager);
	}
	
	@After
	public void termina() {
		fakeLocalSeries = null;
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.1
	// Existen varias series almacenadas en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.1.1

	@Test
	public void listarTitulosSeries_ExistenVariasSeries_DosSeries() {
		
		fakeLocalSeries.add(FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie());
		fakeLocalSeries.add(FakeSeriesFactory.VIKINGS_SIN_TEMPORADAS.getSerie());

		List<String> expectedSerieList = new LinkedList<>();
		expectedSerieList.add("The OA");
		expectedSerieList.add("Vikings");

		List<String> returnedSerieList = getAndListService.listSeriesNames();

		assertEquals(returnedSerieList.size(), expectedSerieList.size());
		assertEquals(returnedSerieList, expectedSerieList);

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.2
	// Existe sólo una serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.2.1

	@Test
	public void listarTitulosSeries_ExisteUnaSerie_UnaSerie() {
		
		fakeLocalSeries.add(FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie());

		List<String> expectedSerieList = new LinkedList<>();
		expectedSerieList.add("The OA");

		List<String> returnedSerieList = getAndListService.listSeriesNames();

		assertEquals(returnedSerieList.size(), expectedSerieList.size());
		assertEquals(returnedSerieList, expectedSerieList);
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.3
	// No existe ninguna serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.3.1

	@Test
	public void listarTitulosSeries_NoExistenSeries_Excepcion() {
		
		thrown.expect(NoSuchElementException.class);
		thrown.expectMessage(StringStartsWith.startsWith("No existen series"));
		
		getAndListService.listSeriesNames();

	}

}
