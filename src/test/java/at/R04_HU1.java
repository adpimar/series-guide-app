package at;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import resources.FakeLocalManagers;

public class R04_HU1 extends AcceptanceTest {

	// REQUISITO 04
	// Debe permitir obtener una lista con los títulos de todos los episodios de una
	// temporada concreta para una serie determinada que hay almacenados en la BDL.

	// HISTORIA DE USUARIO 04.1
	// Como usuario quiero obtener un listado de los títulos de todos los episodios
	// de una temporada de una de mis series para saber qué capítulos tiene.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 04.1.1
	// La serie está almacenada en la BDL + la temporada está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 04.1.1.1

	@Test
	public void listarEpisodios_UnaSerieUnaTemporadaExistenTodosEpisodios_TodosEpisodios() 
			throws NoSeriesStoredException, NoSeasonsStoredException {

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
		
		// Given
		setLocalManagers(FakeLocalManagers.R04_1_1_1.getLocalManager());
		
		// When
		String[] resultReturned = getAndListService.listSerieSeasonEpisodesNamesOrderedByAired(321060, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.length, resultReturned.length);
		assertArrayEquals(resultReturned, resultExpected);
		
	}

	// PRUEBA DE ACEPTACIÓN 04.1.1.2

	@Test
	public void listarEpisodios_VariasSeriesVariasTemporadasExistenAlgunosEpisodios_AlgunosEpisodios() 
			throws NoSeriesStoredException, NoSeasonsStoredException {
		
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
		
		// Given
		setLocalManagers(FakeLocalManagers.R04_1_1_2.getLocalManager());
		
		// When
		String[] resultReturned = getAndListService.listSerieSeasonEpisodesNamesOrderedByAired(321060, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.length, resultReturned.length);
		assertArrayEquals(resultReturned, resultExpected);

	}

	// PRUEBA DE ACEPTACIÓN 04.1.1.3

	@Test
	public void listarEpisodios_UnaSerieVariasTemporadasNoExistenEpisodios_NingunEpisodio() 
			throws NoSeriesStoredException, NoSeasonsStoredException {
		
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
		
		// Given
		setLocalManagers(FakeLocalManagers.R04_1_1_3.getLocalManager());
		
		// When
		String[] resultReturned = getAndListService.listSerieSeasonEpisodesNamesOrderedByAired(260449, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultExpected.length, resultReturned.length);
		assertArrayEquals(resultReturned, resultExpected);

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 04.1.2
	// La serie está almacenada en la BDL + la temporada no está almacenada en la
	// BDL.

	// PRUEBA DE ACEPTACIÓN 04.1.2.1

	@Test
	public void listarEpisodios_NoExisteTemporada_Excepcion() 
			throws NoSeriesStoredException, NoSeasonsStoredException {
				
		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R04_1_2_1.getLocalManager());
		
		// When
		getAndListService.listSerieSeasonEpisodesNamesOrderedByAired(321060, 1);
		
		// Then

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 04.1.3
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 04.1.3.1

	@Test
	public void listarEpisodios_NoExisteSerie_Excepcion() 
			throws NoSeriesStoredException, NoSeasonsStoredException {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R04_1_3_1.getLocalManager());
		
		// When
		getAndListService.listSerieSeasonEpisodesNamesOrderedByAired(321060, 1);
		
		// Then

	}

}
