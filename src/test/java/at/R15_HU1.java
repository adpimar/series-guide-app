package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Season;
import resources.ExpectedSeasons;
import resources.FakeLocalManagers;

public class R15_HU1 extends AcceptanceTest {

	// REQUISITO 15
	// Debe permitir que el usuario indique que ha visto todos los episodios de una
	// determinada temporada a través de ella y viceversa.

	// HISTORIA DE USUARIO 15.1
	// Como usuario quiero indicar como vista una temporada de una de mis series
	// para que se indiquen automáticamente todos los episodios como vistos de dicha
	// temporada.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 15.1.1
	// La temporada está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 15.1.1.1
	
	@Test
	public void indicarVistaTemporada_TemporadaNoVistaConTodosEpisodios_TemporadaVista() {
		
		// Given
		setLocalManagers(FakeLocalManagers.R15_1_1_1.getLocalManager());
		
		// When
		Season resultReturned = checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedSeasons.R15_1_1_1.getExpectedSeason());
		assertTrue(compruebaTemporadaVistaConEpisodiosVistos(resultReturned));

	}

	// PRUEBA DE ACEPTACIÓN 15.1.1.2

	@Test
	public void indicarVistaTemporada_TemporadaNoVistaConUnEpisodio_Excepcion() {

		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R15_1_1_2.getLocalManager());
		
		// When
		checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.1.1.3
	
	@Test
	public void indicarVistaTemporada_TemporadaNoVistaSinEpisodios_Excepcion() {

		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R15_1_1_3.getLocalManager());
		
		// When
		checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.1.1.4
	
	@Test
	public void indicarVistaTemporada_TemporadaVista_TemporadaVista() {
		
		// Given
		setLocalManagers(FakeLocalManagers.R15_1_1_4.getLocalManager());
		
		// When
		Season resultReturned = checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedSeasons.R15_1_1_4.getExpectedSeason());
		assertTrue(compruebaTemporadaVistaConEpisodiosVistos(resultReturned));

	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 15.1.2
	// La temporada no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 15.1.2.1
	
	@Test
	public void indicarVistaTemporada_ExisteSerieNoExisteTemporada_Excepcion() {

		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R15_1_2_1.getLocalManager());
		
		// When
		checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.1.2.2
	
	@Test
	public void indicarVistaTemporada_NoExisteSerie_Excepcion() {

		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R15_1_2_2.getLocalManager());
		
		// When
		checkAsViewedService.checkSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// -----------------------------------------------------------------------------
	
	private boolean compruebaTemporadaVistaConEpisodiosVistos(Season season) {
		long codSerie = season.getCodSerie();
		int airedSeason = season.getAiredSeason();
		int totalEpisodes = season.getTotalEpisodes();
		
		if (!getAndListService.getSeason(codSerie, airedSeason).isSeen())
			return false;
		
		for (int i = 1; i <= totalEpisodes; i++)
			if (!getAndListService.getEpisode(codSerie, airedSeason, i).isSeen())
				return false;
		
		return true;
	}

}
