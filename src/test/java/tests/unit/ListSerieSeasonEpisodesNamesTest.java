package tests.unit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.services.IGetAndListService;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.services.GetAndListSvc;
import resources.FactoryLocalManagers;

public class ListSerieSeasonEpisodesNamesTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// ------------------------------------------------------------------------
	
	private static IGetAndListService getAndListService;

	@BeforeClass
	public static void inicia() {
		getAndListService = new GetAndListSvc();
	}

	@AfterClass
	public static void termina() {
		getAndListService = null;
	}

	// ------------------------------------------------------------------------------------------------------
	// String[] listSerieSeasonsEpisodesNames(long codSerie, int airedSeason)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void listarEpisodios_UnaSerieUnaTemporadaConTodosEpisodios_ListadoCompleto() {
		
		// Arrange
		String[] resultExpected = {
				"Homecoming",
				"New Colossus",
				"Champion",
				"Away",
				"Paradise",
				"Forking Paths",
				"Empire of Light",
				"Invisible Self"
		};
		getAndListService.setLocalManager(FactoryLocalManagers.R04_1_1_1.getLocalManager());
		
		// Act
		String[] resultReturned = getAndListService.listSerieSeasonsEpisodesNames(321060, 1);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.length, resultReturned.length);
		assertArrayEquals(resultReturned, resultExpected);
		
	}

	@Test
	public void listarEpisodios_VariasSeriesVariasTemporadasConAlgunosEpisodios_ListadoIncompleto() {
		
		// Arrange
		String[] resultExpected = {
				"Homecoming",
				null,
				null,
				null,
				null,
				null,
				null,
				null
		};
		getAndListService.setLocalManager(FactoryLocalManagers.R04_1_1_2.getLocalManager());
		
		// Act
		String[] resultReturned = getAndListService.listSerieSeasonsEpisodesNames(321060, 1);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.length, resultReturned.length);
		assertArrayEquals(resultReturned, resultExpected);

	}

	@Test
	public void listarEpisodios_UnaSerieVariasTemporadasConExistenEpisodios_ListadoIncompleto() {
		
		// Arrange
		String[] resultExpected = {
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
		};
		getAndListService.setLocalManager(FactoryLocalManagers.R04_1_1_3.getLocalManager());
		
		// Act
		String[] resultReturned = getAndListService.listSerieSeasonsEpisodesNames(260449, 1);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultExpected.length, resultReturned.length);
		assertArrayEquals(resultReturned, resultExpected);
	
	}

	@Test
	public void listarEpisodios_SerieAlmacenadaTemporadaNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeasonsStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R04_1_2_1.getLocalManager());
		
		// Act
		getAndListService.listSerieSeasonsEpisodesNames(321060, 1);
		
		// Assert

	}

	@Test
	public void listarEpisodios_SerieNoAlmacenada_Excepcion() {
			
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		getAndListService.setLocalManager(FactoryLocalManagers.R04_1_3_1.getLocalManager());
		
		// Act
		getAndListService.listSerieSeasonsEpisodesNames(321060, 1);
		
		// Assert

	}

}