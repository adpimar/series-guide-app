package acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import org.hamcrest.core.StringStartsWith;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import abs.ILocalManager;
import abs.services.IGetAndListService;
import impl.Serie;
import impl.services.GetAndListSvc;
import resources.FakeSeriesFactory;

public class R02_HU1 {

	// REQUISITO 02
	// Debe permitir visualizar la información que hay almacenada en la BDL sobre
	// una serie concreta.

	// HISTORIA DE USUARIO 02.1
	// Como usuario quiero obtener la información de una de mis series para saber
	// acerca de ella.

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private ILocalManager localManager;
	private IGetAndListService getAndListService;
	
	@Before
	public void inicia() {
		localManager = mock(ILocalManager.class);
		when(localManager.getSerie(anyLong()))
			.thenReturn(FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie());
		getAndListService = new GetAndListSvc();
		getAndListService.setLocalManager(localManager);
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 02.1.1
	// La serie está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 02.1.1.1

	@Test
	public void getInfoSerie_ExisteUnaSerie_UnaInfo() {
		
		Serie expectedSerie = FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie();

		Serie returnedSerie = getAndListService.getInfoSerie(321060);

		assertNotNull(returnedSerie);
		assertEquals(returnedSerie, expectedSerie);

	}

	// PRUEBA DE ACEPTACIÓN 02.1.1.2

	@Test
	public void getInfoSerie_ExistenVariasSeries_UnaInfo() {
		
		Serie expectedSerie = FakeSeriesFactory.THE_OA_SIN_TEMPORADAS.getSerie();
	
		Serie returnedSerie = getAndListService.getInfoSerie(321060);
	
		assertNotNull(returnedSerie);
		assertEquals(returnedSerie, expectedSerie);		

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 02.1.2
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 02.1.2.1

	@Test
	public void getInfoSerie_NoExisteSerie_Excepcion() {
		
		when(localManager.getSerie(000000)).thenReturn(null);
		
		thrown.expect(NoSuchElementException.class);
		thrown.expectMessage(StringStartsWith.startsWith("No existe la serie"));
		
		getAndListService.getInfoSerie(000000);
		
	}

}
