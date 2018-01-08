package tests.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Episode;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class R08_HU1 extends AcceptanceTest {

	// REQUISITO 08
	// Debe permitir que el usuario indique que NO ha visto un episodio concreto de
	// una temporada determinada para una serie dada. Si hubiese un comentario del
	// usuario asociado con dicho episodio, debe borrarlo en este caso.

	// HISTORIA DE USUARIO 08.1
	// Como usuario quiero indicar que no he visto un episodio de una temporada de
	// una de mis series para saber que no lo he visto.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 08.1.1
	// El episodio está almacenado en la BDL + está ya indicado como no visto.

	// PRUEBA DE ACEPTACIÓN 08.1.1.1
	
	@Test
	public void indicarNoVistoEpisodio_ExisteEpisodioNoVisto_EpisodioNoVisto() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R08_1_1_1.getFakeLocalManager());

		// When		
		Episode resultReturned = seriesGuideApp.uncheckEpisodeAsViewed(321060, 1, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R08_1_1_1.getExpectedResult(), resultReturned);
		assertFalse(seriesGuideApp.getEpisode(321060, 1, 1).isSeen());
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 08.1.2
	// El episodio está almacenado en la BDL + está indicado como visto.

	// PRUEBA DE ACEPTACIÓN 08.1.2.1
	
	@Test
	public void indicarNoVistoEpisodio_NoTodosVistosEpisodioVistoNoComentado_EpisodioNoVisto() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R08_1_2_1.getFakeLocalManager());
		
		// When
		Episode resultReturned = seriesGuideApp.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R08_1_2_1.getExpectedResult(), resultReturned);
		assertFalse(seriesGuideApp.getEpisode(321060, 1, 2).isSeen());
		
	}

	// PRUEBA DE ACEPTACIÓN 08.1.2.2
	
	@Test
	public void indicarNoVistoEpisodio_NoTodosVistosEpisodioVistoComentado_EpisodioNoVistoSinComentario() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R08_1_2_2.getFakeLocalManager());
		
		// When
		Episode resultReturned = seriesGuideApp.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R08_1_2_2.getExpectedResult(), resultReturned);
		assertFalse(seriesGuideApp.getEpisode(321060, 1, 2).isSeen());
		
	}
	
	// PRUEBA DE ACEPTACIÓN 08.1.2.3
	
	@Test
	public void indicarNoVistoEpisodio_TodosVistosEpisodioVistoNoComentado_EpisodioNoVistoTemporadaNoVista() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R08_1_2_3.getFakeLocalManager());
		
		// When
		Episode resultReturned = seriesGuideApp.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R08_1_2_3.getExpectedResult(), resultReturned);
		assertFalse(seriesGuideApp.getEpisode(321060, 1, 2).isSeen());
		assertFalse(seriesGuideApp.getSeason(321060, 1).isSeen());
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 08.1.3
	// El episodio no está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 08.1.3.1
	
	@Test
	public void indicarNoVistoEpisodio_ExisteSerieExisteTemporadaNoExisteEpisodio_Excepcion() {
		
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R08_1_3_1.getFakeLocalManager());

		// When		
		seriesGuideApp.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then

	}
	
	// PRUEBA DE ACEPTACIÓN 08.1.3.2
	
	@Test
	public void indicarNoVistoEpisodio_ExisteSerieNoExisteTemporada_Excepcion() {
		
		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R08_1_3_2.getFakeLocalManager());

		// When		
		seriesGuideApp.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then

	}
	
	// PRUEBA DE ACEPTACIÓN 08.1.3.3
	
	@Test
	public void indicarNoVistoEpisodio_NoExisteSerie_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R08_1_3_3.getFakeLocalManager());

		// When		
		seriesGuideApp.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then

	}

}
