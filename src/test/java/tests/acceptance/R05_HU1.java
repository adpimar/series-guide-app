package tests.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Episode;
import resources.ExpectedEpisodes;
import resources.FactoryLocalManagers;

public class R05_HU1 extends AcceptanceTest {

	// REQUISITO 05
	// Debe permitir visualizar la información que hay almacenada en la BDL sobre un
	// episodio concreto de una temporada determinada para una serie dada.

	// HISTORIA DE USUARIO 05.1
	// Como usuario quiero obtener información de un episodio de una temporada de
	// una de mis series para saber acerca de él.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 05.1.1
	// La serie está almacenada en la BDL + la temporada está almacenada en la BDL +
	// el episodio está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 05.1.1.1
	
	@Test
	public void obtenerEpisodio_ExisteUnaSerieUnaTemporada_Episodio() {
		
		// Given
		setLocalManagers(FactoryLocalManagers.R05_1_1_1.getLocalManager());
		
		// When
		Episode resultReturned = getAndListService.getEpisode(321060, 1, 6);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedEpisodes.R05_1_1_1.getExpectedEpisode());
		
	}
	
	// PRUEBA DE ACEPTACIÓN 05.1.1.2
	
	@Test
	public void obtenerEpisodio_ExisteUnaSerieVariasTemporadas_Episodio() {
		
		// Given
		setLocalManagers(FactoryLocalManagers.R05_1_1_2.getLocalManager());
		
		// When
		Episode resultReturned = getAndListService.getEpisode(305288, 1, 6);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedEpisodes.R05_1_1_2.getExpectedEpisode());
		
	}
	
	// PRUEBA DE ACEPTACIÓN 05.1.1.3

	@Test
	public void obtenerEpisodio_ExistenVariasSeriesVariasTemporadas_Episodio() {
		
		// Given
		setLocalManagers(FactoryLocalManagers.R05_1_1_3.getLocalManager());
		
		// When
		Episode resultReturned = getAndListService.getEpisode(321060, 1, 6);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(resultReturned, ExpectedEpisodes.R05_1_1_3.getExpectedEpisode());
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 05.1.2
	// La serie está almacenada en la BDL + la temporada está almacenada en la BDL +
	// el episodio no está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 05.1.2.1
	
	@Test
	public void obtenerEpisodio_ExisteSerieExisteTemporadaNoExisteEpidosio_Excepcion() {
		
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		setLocalManagers(FactoryLocalManagers.R05_1_2_1.getLocalManager());
		
		// When
		getAndListService.getEpisode(321060, 1, 6);
		
		// Then
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 05.1.3
	// La serie está almacenada en la BDL + la temporada no está almacenada en la
	// BDL.

	// PRUEBA DE ACEPTACIÓN 05.1.3.1
	
	@Test
	public void obtenerEpisodio_ExisteSerieNoExisteTemporada_Excepcion() {
		
		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		setLocalManagers(FactoryLocalManagers.R05_1_3_1.getLocalManager());
		
		// When
		getAndListService.getEpisode(321060, 1, 6);
		
		// Then
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 05.1.4
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 05.1.4.1
	
	@Test
	public void obtenerEpisodio_NoExisteSerie_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FactoryLocalManagers.R05_1_4_1.getLocalManager());
		
		// When
		getAndListService.getEpisode(321060, 1, 6);
		
		// Then
		
	}

}
