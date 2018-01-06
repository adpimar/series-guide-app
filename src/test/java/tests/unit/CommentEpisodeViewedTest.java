package tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.managers.ILocalManager;
import abs.services.ICheckAsViewedService;
import impl.exceptions.NoEpisodeCheckedAsViewedException;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongCommentException;
import impl.model.Episode;
import impl.services.CheckAsViewedSvc;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class CommentEpisodeViewedTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// ------------------------------------------------------------------------
	
	private static ICheckAsViewedService checkAsViewedService;

	@BeforeClass
	public static void inicia() {
		checkAsViewedService = new CheckAsViewedSvc();
	}

	@AfterClass
	public static void termina() {
		checkAsViewedService = null;
	}
	
	// ------------------------------------------------------------------------------------------------------
	//  Episode commentEpisodeViewed(long codSerie, int airedSeason, int airedEpisode, String comment)
	// ------------------------------------------------------------------------------------------------------
	
	@Test
	public void comentarEpisodio_NoVisto_Excepcion() {
		
		// Arrange
		thrown.expect(NoEpisodeCheckedAsViewedException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R07_2_1_1.getLocalManager());
		
		// Act
		checkAsViewedService.commentEpisodeViewed(321060, 1, 1, "");
		
		// Assert

	}

	@Test
	public void comentarEpisodio_VistoNoComentadoCadenaVacia_Comentado() {
			
		// Arrange
		String comment = "";
		ILocalManager localManager = FactoryLocalManagers.R07_2_2_1.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);
		
		// Act
		Episode resultReturned = checkAsViewedService.commentEpisodeViewed(321060, 1, 2, comment);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R07_2_2_1.getExpectedResult());
		assertEquals(localManager.getEpisode(resultReturned.getCodEpisode()).getComment(), comment);
		
	}

	@Test
	public void comentarEpisodio_VistoNoComentadoCadenaMenor150Caracteres_Comentado() {

		// Arrange
		String comment = "¡Qué gran episodio! El mejor de la temporada hasta el momento.";
		ILocalManager localManager = FactoryLocalManagers.R07_2_2_2.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);
		
		// Act
		Episode resultReturned = checkAsViewedService.commentEpisodeViewed(321060, 1, 2, comment);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R07_2_2_2.getExpectedResult());
		assertEquals(localManager.getEpisode(resultReturned.getCodEpisode()).getComment(), comment);
		
	}
	
	@Test
	public void comentarEpisodio_VistoNoComentadoCadenaMayor150Caracteres_Excepcion() {
		
		// Arrange
		String comment = 
				"¡Qué impotencia de episodio! Después de ver el anterior episodio que tan "
				+ "buenas esperanzas dio para el siguiente, este me ha defraudado muchísimo."
				+ " Esperaba bastante más. Todo pasa de forma muy lenta y me he aburrido "
				+ "demasiado. ¡Qué me devuelvan mi tiempo perdido!";
		thrown.expect(TooLongCommentException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R07_2_2_3.getLocalManager());

		// Act		
		checkAsViewedService.commentEpisodeViewed(321060, 1, 2, comment);
		
		// Assert
		
	}
	
	@Test
	public void comentarEpisodio_VistoComentado_NuevoComentario() {
		
		// Arrange
		String comment = "¡Ya no me gusta!";
		ILocalManager localManager = FactoryLocalManagers.R07_2_3_1.getLocalManager();
		checkAsViewedService.setLocalManager(localManager);
		
		// Act
		Episode resultReturned = checkAsViewedService.commentEpisodeViewed(321060, 1, 2, comment);
		
		// Assert
		assertNotNull(resultReturned);
		assertEquals(resultReturned, FactoryExpectedResults.R07_2_3_1.getExpectedResult());
		assertEquals(localManager.getEpisode(resultReturned.getCodEpisode()).getComment(), comment);
		

	}

	@Test
	public void comentarEpisodio_SerieAlmacenadaTemporadaAlmacenadaEpisodioNoAlmacenado_Excepcion() {
		
		// Arrange
		thrown.expect(NoEpisodesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R07_2_4_1.getLocalManager());

		// Act		
		checkAsViewedService.commentEpisodeViewed(321060, 1, 2, "");
		
		// Assert

	}
		
	@Test
	public void comentarEpisodio_SerieAlmacenadaTemporadaNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeasonsStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R07_2_4_2.getLocalManager());

		// Act		
		checkAsViewedService.commentEpisodeViewed(321060, 1, 2, "");
		
		// Assert

	}
		
	@Test
	public void comentarEpisodio_SerieNoAlmacenada_Excepcion() {
		
		// Arrange
		thrown.expect(NoSeriesStoredException.class);
		checkAsViewedService.setLocalManager(FactoryLocalManagers.R07_2_4_3.getLocalManager());

		// Act		
		checkAsViewedService.commentEpisodeViewed(321060, 1, 2, "");
		
		// Assert

	}
		
}
