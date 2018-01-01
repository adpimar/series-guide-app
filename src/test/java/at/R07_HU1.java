package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import impl.exceptions.AlreadyCheckedAsViewedException;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Episode;
import resources.ExpectedEpisodes;
import resources.FakeLocalManagers;

public class R07_HU1 extends AcceptanceTest {

	// REQUISITO 07
	// Debe permitir que el usuario indique que ha visto un episodio concreto de una
	// temporada determinada para una serie dada. En ese caso el programa debe
	// permitir que el usuario introduzca un comentario al respecto si es su
	// voluntad -máx. 150 caracteres.

	// HISTORIA DE USUARIO 07.1
	// Como usuario quiero indicar como visto un episodio de una temporada de una de
	// mis series para saber que lo he visto.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 07.1.1
	// El episodio está almacenado en la BDL + está indicado como no visto.

	// PRUEBA DE ACEPTACIÓN 07.1.1.1
	
	@Test
	public void indicarVistoEpisodio_EpisodioUnicoComoNoVisto_EpisodioVistoTemporadaVista() {
		
		// Given
		setLocalManagers(FakeLocalManagers.R07_1_1_1.getLocalManager());

		// When
		Episode resultReturned = checkAsViewedService.checkEpisodeAsViewed(321060, 1, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedEpisodes.R07_1_1_1.getExpectedEpisode());
		assertTrue(getAndListService.getEpisode(321060, 1, 1).isSeen());
		assertTrue(getAndListService.getSeason(321060, 1).isSeen());
		
	}
	
	// PRUEBA DE ACEPTACIÓN 07.1.1.2
	
	@Test
	public void indicarVistoEpisodio_EpisodioVariosComoNoVistos_EpisodioVisto() {
		
		// Given
		setLocalManagers(FakeLocalManagers.R07_1_1_2.getLocalManager());

		// When
		Episode resultReturned = checkAsViewedService.checkEpisodeAsViewed(321060, 1, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedEpisodes.R07_1_1_2.getExpectedEpisode());
		assertTrue(getAndListService.getEpisode(321060, 1, 1).isSeen());
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 07.1.2
	// El episodio está almacenado en la BDL + está ya indicado como visto.

	// PRUEBA DE ACEPTACIÓN 07.1.2.1
	
	@Test
	public void indicarVistoEpisodio_EpisodioVistoNoComentado_Excepcion() {
		
		thrown.expect(AlreadyCheckedAsViewedException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R07_1_2_1.getLocalManager());
		
		// When
		checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 07.1.2.2
	
	@Test
	public void indicarVistoEpisodio_EpisodioVistoComentado_Excepcion() {
		
		thrown.expect(AlreadyCheckedAsViewedException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R07_1_2_1.getLocalManager());
		
		// When
		checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);
		
		// Then

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 07.1.3
	// El episodio no está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 07.1.3.1
	
	@Test
	public void indicarVistoEpisodio_ExisteSerieExisteTemporadaNoExisteEpisodio_Excepcion() {
		
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R07_1_3_1.getLocalManager());
		
		// When
		checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 07.1.3.2
	
	@Test
	public void indicarVistoEpisodio_ExisteSerieNoExisteTemporada_Excepcion() {
		
		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R07_1_3_2.getLocalManager());
		
		// When
		checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 07.1.3.3
	
	@Test
	public void indicarVistoEpisodio_NoExisteSerie_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R07_1_3_3.getLocalManager());
		
		// When
		checkAsViewedService.checkEpisodeAsViewed(321060, 1, 2);
		
		// Then
		
	}

}
