package tests.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import impl.exceptions.NoEpisodeCheckedAsViewedException;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongCommentException;
import impl.model.Episode;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class R07_HU2 extends AcceptanceTest {

	// REQUISITO 07
	// Debe permitir que el usuario indique que ha visto un episodio concreto de una
	// temporada determinada para una serie dada. En ese caso el programa debe
	// permitir que el usuario introduzca un comentario al respecto si es su
	// voluntad -máx. 150 caracteres.

	// HISTORIA DE USUARIO 07.2
	// Como usuario quiero comentar un episodio visto de una temporada de una de mis
	// series para expresar y recordar las impresiones que tuve de él.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 07.2.1
	// El episodio está almacenado en la BDL + está indicado como no visto.

	// PRUEBA DE ACEPTACIÓN 07.2.1.1
	
	@Test
	public void comentarEpisodio_ExisteEpisodioNoVisto_Excepcion() {
		
		thrown.expect(NoEpisodeCheckedAsViewedException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R07_2_1_1.getLocalManager());
		
		// When
		seriesGuideApp.commentEpisodeViewed(321060, 1, 1, "");
		
		// Then

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 07.2.2
	// El episodio está almacenado en la BDL + está indicado como visto + no está
	// comentado.

	// PRUEBA DE ACEPTACIÓN 07.2.2.1
	
	@Test
	public void comentarEpisodio_ExisteEpisodioVistoCadenaVacia_CadenaVacia() {
		
		String comment = "";
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R07_2_2_1.getLocalManager());
		
		// When
		Episode resultReturned = seriesGuideApp.commentEpisodeViewed(321060, 1, 2, comment);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R07_2_2_1.getExpectedResult(), resultReturned);
		assertEquals(comment, seriesGuideApp.getEpisode(321060, 1, 2).getComment());
		
	}

	// PRUEBA DE ACEPTACIÓN 07.2.2.2

	@Test
	public void comentarEpisodio_ExisteEpisodioVistoCadenaMenor150Caracteres_Cadena() {
		
		String comment = "¡Qué gran episodio! El mejor de la temporada hasta el momento.";
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R07_2_2_2.getLocalManager());

		// When		
		Episode resultReturned = seriesGuideApp.commentEpisodeViewed(321060, 1, 2, comment);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R07_2_2_2.getExpectedResult(), resultReturned);
		assertEquals(comment, seriesGuideApp.getEpisode(321060, 1, 2).getComment());
		
	}
	
	// PRUEBA DE ACEPTACIÓN 07.2.2.3

	@Test
	public void comentarEpisodio_ExisteEpisodioVistoCadenaMayor150Caracteres_Excepcion() {
		
		String comment = 
				"¡Qué impotencia de episodio! Después de ver el anterior episodio que tan "
				+ "buenas esperanzas dio para el siguiente, este me ha defraudado muchísimo."
				+ " Esperaba bastante más. Todo pasa de forma muy lenta y me he aburrido "
				+ "demasiado. ¡Qué me devuelvan mi tiempo perdido!";
		
		thrown.expect(TooLongCommentException.class);
				
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R07_2_2_3.getLocalManager());

		// When		
		seriesGuideApp.commentEpisodeViewed(321060, 1, 2, comment);
		
		// Then
		
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 07.2.3
	// El episodio está almacenado en la BDL + está indicado como visto + está
	// comentado.

	// PRUEBA DE ACEPTACIÓN 07.2.3.1
	
	@Test
	public void comentarEpisodio_ExisteEpisodioVistoComentado_NuevoComentario() {
		
		String comment = "¡Ya no me gusta!";
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R07_2_3_1.getLocalManager());

		// When		
		Episode resultReturned = seriesGuideApp.commentEpisodeViewed(321060, 1, 2, comment);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R07_2_3_1.getExpectedResult(), resultReturned);
		assertEquals(comment, seriesGuideApp.getEpisode(321060, 1, 2).getComment());

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 07.2.4
	// El episodio no está almacenado en la BDL.
	
	// PRUEBA DE ACEPTACIÓN 07.2.4.1
	
	@Test
	public void comentarEpisodio_ExisteSerieExisteTemporadaNoExisteEpisodio_Excepcion() {
		
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R07_2_4_1.getLocalManager());

		// When		
		seriesGuideApp.commentEpisodeViewed(321060, 1, 2, "");
		
		// Then

	}
	
	// PRUEBA DE ACEPTACIÓN 07.2.4.2
	
	@Test
	public void comentarEpisodio_ExisteSerieNoExisteTemporada_Excepcion() {
		
		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R07_2_4_2.getLocalManager());

		// When		
		seriesGuideApp.commentEpisodeViewed(321060, 1, 2, "");
		
		// Then

	}
	
	// PRUEBA DE ACEPTACIÓN 07.2.4.3
	
	@Test
	public void comentarEpisodio_NoExisteSerie_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R07_2_4_3.getLocalManager());

		// When		
		seriesGuideApp.commentEpisodeViewed(321060, 1, 2, "");
		
		// Then

	}

}
