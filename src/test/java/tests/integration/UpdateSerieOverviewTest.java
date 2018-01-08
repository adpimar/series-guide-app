package tests.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.managers.ILocalManager;
import abs.services.IUpdateOverviewService;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongOverviewException;
import impl.model.Serie;
import impl.services.UpdateOverviewSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class UpdateSerieOverviewTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// ------------------------------------------------------------------------
	
	private static IUpdateOverviewService updateOverviewService;

	@BeforeClass
	public static void inicia() {
		updateOverviewService = new UpdateOverviewSvc();
	}

	@AfterClass
	public static void termina() {
		updateOverviewService = null;
	}
	
	// ------------------------------------------------------------------------------------------------------
	//  Serie updateSerieOverview(long codSerie, String newOverview)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void modificarSinopsisSerie_CadenaVacia_SinopsisModificada() {
		
		// Arrange
		String newOverview = "";
		ILocalManager localManager = FactoryLocalManagers.R03_1_1_1.getFakeLocalManager();
		updateOverviewService.setLocalManager(localManager);

		// Act
		Serie resultReturned = updateOverviewService.updateSerieOverview(321060, newOverview);

		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R03_1_1_1.getExpectedResult(), resultReturned);
		assertEquals(localManager.getSerie(resultReturned.getCodSerie()).getOverview(), newOverview);
		
	}

	@Test
	public void modificarSinopsisSerie_CadenaMenor500Caracteres_SinopsisModificada() {
		
		// Arrange
		String newOverview = 
				"Prairie Johnson es una chica ciega que ha estado desaparecida durante"
				+ " 7 largos años. Un día, vuelve a la comunidad donde se crió con un "
				+ "gran cambio: su vista se ha curado.";
		
		ILocalManager localManager = FactoryLocalManagers.R03_1_1_2.getFakeLocalManager();
		updateOverviewService.setLocalManager(localManager);

		// Act
		Serie resultReturned = updateOverviewService.updateSerieOverview(321060, newOverview);

		// Assert
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R03_1_1_2.getExpectedResult(), resultReturned);
		assertEquals(localManager.getSerie(resultReturned.getCodSerie()).getOverview(), newOverview);
		
	}

	@Test
	public void modificarSinopsisSerie_CadenaMayor500Caracteres_Excepcion() {
		
		// Arrange
		String newOverview = 
				"Prairie Johnson es una chica ciega que ha estado desaparecida durante 7"
				+ " largos años. Un día, vuelve a la comunidad donde se crió con un gran "
				+ "cambio: su vista se ha curado. Prairie puede ver. Algunos de sus vecinos "
				+ "creen que es un milagro mientras otros opinan que es algo peligroso, un "
				+ "temible misterio que hay que resolver. A pesar de que su familia y el FBI "
				+ "intentan hacerle hablar sobre qué ha pasado en todo ese tiempo, son "
				+ "incapaces de conseguir información. La joven solo habla con un grupo de...";
		
		thrown.expect(TooLongOverviewException.class);
		updateOverviewService.setLocalManager(FactoryLocalManagers.R03_1_1_3.getFakeLocalManager());

		// Act
		updateOverviewService.updateSerieOverview(321060, newOverview);

		// Assert
		
	}

	@Test
	public void modificarSinopsisSerie_SerieNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		updateOverviewService.setLocalManager(FactoryLocalManagers.R03_1_2_1.getFakeLocalManager());

		// Act
		updateOverviewService.updateSerieOverview(321060, "");

		// Assert

	}

}