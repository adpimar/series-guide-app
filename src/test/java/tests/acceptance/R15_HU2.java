package tests.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Season;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class R15_HU2 extends AcceptanceTest {

	// REQUISITO 15
	// Debe permitir que el usuario indique que ha visto todos los episodios de una
	// determinada temporada a través de ella y viceversa.

	// HISTORIA DE USUARIO 15.2
	// Como usuario quiero indicar como no vista una temporada de una de mis series
	// para que se indiquen automáticamente todos los episodios como no vistos de
	// dicha temporada.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 15.2.1
	// La temporada está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 15.2.1.1
	
	@Test
	public void indicarNoVistaTemporada_TemporadaNoVistaConTodosEpisodios_TemporadaNoVista() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_2_1_1.getFakeLocalManager());
		
		// When
		Season resultReturned = seriesGuideApp.uncheckSeasonAsViewed(321060, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R15_2_1_1.getExpectedResult(), resultReturned);
		assertTrue(compruebaTemporadaNoVistaConEpisodiosNoVistos(resultReturned));
		
	}

	// PRUEBA DE ACEPTACIÓN 15.2.1.2

	@Test
	public void indicarNoVistaTemporada_TemporadaNoVistaConUnEpisodio_TemporadaNoVista() {
		
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_2_1_2.getFakeLocalManager());
		
		// When
		seriesGuideApp.uncheckSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.2.1.3
	
	@Test
	public void indicarNoVistaTemporada_TemporadaNoVistaSinEpisodios_TemporadaNoVista() {
		
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_2_1_3.getFakeLocalManager());
		
		// When
		seriesGuideApp.uncheckSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.2.1.4
	
	@Test
	public void indicarNoVistaTemporada_TemporadaVista_TemporadaNoVista() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_2_1_4.getFakeLocalManager());
		
		// When
		Season resultReturned = seriesGuideApp.uncheckSeasonAsViewed(321060, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R15_2_1_4.getExpectedResult(), resultReturned);
		assertTrue(compruebaTemporadaNoVistaConEpisodiosNoVistos(resultReturned));
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 15.1.2
	// La temporada no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 15.2.2.1
	
	@Test
	public void indicarNoVistaTemporada_ExisteSerieNoExisteTemporada_Excepcion() {
		
		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_2_2_1.getFakeLocalManager());
		
		// When
		seriesGuideApp.uncheckSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.2.2.2
	
	@Test
	public void indicarNoVistaTemporada_NoExisteSerie_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_2_2_2.getFakeLocalManager());
		
		// When
		seriesGuideApp.uncheckSeasonAsViewed(321060, 1);
		
		// Then
		
	}

	// -----------------------------------------------------------------------------
	
	private boolean compruebaTemporadaNoVistaConEpisodiosNoVistos(Season season) {
		long codSerie = season.getCodSerie();
		int airedSeason = season.getAiredSeason();
		int totalEpisodes = season.getTotalEpisodes();
				
		if (seriesGuideApp.getSeason(codSerie, airedSeason).isSeen())
			return false;
		
		for (int i = 1; i <= totalEpisodes; i++)
			if (seriesGuideApp.getEpisode(codSerie, airedSeason, i).isSeen())
				return false;
		
		return true;
	}
	
}
