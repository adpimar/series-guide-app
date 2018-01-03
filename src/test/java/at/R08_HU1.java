package at;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Episode;
import resources.ExpectedEpisodes;
import resources.FakeLocalManagers;

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
	public void indicarNoVistoEpisodio_ExisteEpisodioNoVisto_EpisodioNoVisto() 
			throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException 
	{		
		// Given
		setLocalManagers(FakeLocalManagers.R08_1_1_1.getLocalManager());

		// When		
		Episode resultReturned = checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 1);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedEpisodes.R08_1_1_1.getExpectedEpisode());
		assertFalse(getAndListService.getEpisode(321060, 1, 1).isSeen());			
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 08.1.2
	// El episodio está almacenado en la BDL + está indicado como visto.

	// PRUEBA DE ACEPTACIÓN 08.1.2.1
	
	@Test
	public void indicarNoVistoEpisodio_NoTodosVistosEpisodioVistoNoComentado_EpisodioNoVisto() 
			throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException 
	{
		// Given
		setLocalManagers(FakeLocalManagers.R08_1_2_1.getLocalManager());
		
		// When
		Episode resultReturned = checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedEpisodes.R08_1_2_1.getExpectedEpisode());
		assertFalse(getAndListService.getEpisode(321060, 1, 2).isSeen());	
	}

	// PRUEBA DE ACEPTACIÓN 08.1.2.2
	
	@Test
	public void indicarNoVistoEpisodio_NoTodosVistosEpisodioVistoComentado_EpisodioNoVistoSinComentario() 
			throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException 
	{
		// Given
		setLocalManagers(FakeLocalManagers.R08_1_2_2.getLocalManager());
		
		// When
		Episode resultReturned = checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedEpisodes.R08_1_2_2.getExpectedEpisode());
		assertFalse(getAndListService.getEpisode(321060, 1, 2).isSeen());	
	}
	
	// PRUEBA DE ACEPTACIÓN 08.1.2.3
	
	@Test
	public void indicarNoVistoEpisodio_TodosVistosEpisodioVistoNoComentado_EpisodioNoVistoTemporadaNoVista() 
			throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException 
	{
		// Given
		setLocalManagers(FakeLocalManagers.R08_1_2_3.getLocalManager());
		
		// When
		Episode resultReturned = checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedEpisodes.R08_1_2_3.getExpectedEpisode());
		assertFalse(getAndListService.getEpisode(321060, 1, 2).isSeen());
		assertFalse(getAndListService.getSeason(321060, 1).isSeen());	
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 08.1.3
	// El episodio no está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 08.1.3.1
	
	@Test
	public void indicarNoVistoEpisodio_ExisteSerieExisteTemporadaNoExisteEpisodio_Excepcion() 
			throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException 
	{	
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R08_1_3_1.getLocalManager());

		// When		
		checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then

	}
	
	// PRUEBA DE ACEPTACIÓN 08.1.3.2
	
	@Test
	public void indicarNoVistoEpisodio_ExisteSerieNoExisteTemporada_Excepcion() 
			throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException 
	{	
		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R08_1_3_2.getLocalManager());

		// When		
		checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then

	}
	
	// PRUEBA DE ACEPTACIÓN 08.1.3.3
	
	@Test
	public void indicarNoVistoEpisodio_NoExisteSerie_Excepcion() 
			throws NoSeriesStoredException, NoSeasonsStoredException, NoEpisodesStoredException 
	{
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FakeLocalManagers.R08_1_3_3.getLocalManager());

		// When		
		checkAsViewedService.uncheckEpisodeAsViewed(321060, 1, 2);
		
		// Then

	}

}
