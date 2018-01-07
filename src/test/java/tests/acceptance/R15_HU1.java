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
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_1_1_1.getLocalManager());
		
		// When
		Season resultReturned = seriesGuideApp.checkSeasonAsViewed(321060, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R15_1_1_1.getExpectedResult(), resultReturned);
		assertTrue(compruebaTemporadaVistaConEpisodiosVistos(resultReturned));
		
	}

	// PRUEBA DE ACEPTACIÓN 15.1.1.2

	@Test
	public void indicarVistaTemporada_TemporadaNoVistaConUnEpisodio_Excepcion() {
		
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_1_1_2.getLocalManager());
		
		// When
		seriesGuideApp.checkSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.1.1.3
	
	@Test
	public void indicarVistaTemporada_TemporadaNoVistaSinEpisodios_Excepcion() {
		
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_1_1_3.getLocalManager());
		
		// When
		seriesGuideApp.checkSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.1.1.4
	
	@Test
	public void indicarVistaTemporada_TemporadaVista_TemporadaVista() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_1_1_4.getLocalManager());
		
		// When
		Season resultReturned = seriesGuideApp.checkSeasonAsViewed(321060, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R15_1_1_4.getExpectedResult(), resultReturned);
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
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_1_2_1.getLocalManager());
		
		// When
		seriesGuideApp.checkSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 15.1.2.2
	
	@Test
	public void indicarVistaTemporada_NoExisteSerie_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R15_1_2_2.getLocalManager());
		
		// When
		seriesGuideApp.checkSeasonAsViewed(321060, 1);
		
		// Then
		
	}
	
	// -----------------------------------------------------------------------------
	
	private boolean compruebaTemporadaVistaConEpisodiosVistos(Season season) {
		long codSerie = season.getCodSerie();
		int airedSeason = season.getAiredSeason();
		int totalEpisodes = season.getTotalEpisodes();
		
		if (!seriesGuideApp.getSeason(codSerie, airedSeason).isSeen())
			return false;
		
		for (int i = 1; i <= totalEpisodes; i++)
			if (!seriesGuideApp.getEpisode(codSerie, airedSeason, i).isSeen())
				return false;
		
		return true;
	}

}
