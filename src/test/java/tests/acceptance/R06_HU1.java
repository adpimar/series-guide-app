package tests.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongOverviewException;
import impl.model.Episode;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;

public class R06_HU1 extends AcceptanceTest {

	// REQUISITO 06
	// Debe permitir modificar la descripción que hay almacenada en la BDL sobre un
	// episodio concreto de una temporada determinada para una serie dada.

	// HISTORIA DE USUARIO 06.1
	// Como usuario quiero modificar la sinopsis de un episodio de una temporada de
	// una de mis series para que se ajuste más a mi parecer.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 06.1.1
	// El episodio está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 06.1.1.1

	@Test
	public void modificarSinopsisEpisodio_CadenaVacia_CadenaVacia() {
		
		String newOverview = "";
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R06_1_1_1.getFakeLocalManager());
		
		// When
		Episode resultReturned = seriesGuideApp.updateEpisodeOverview(321060, 1, 4, newOverview);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R06_1_1_1.getExpectedResult(), resultReturned);
		assertEquals(newOverview, seriesGuideApp.getEpisode(321060, 1, 4).getOverview());
		
	}
	
	// PRUEBA DE ACEPTACIÓN 06.1.1.2

	@Test
	public void modificarSinopsisEpisodio_CadenaMenor500Caracteres_Cadena() {
		
		String newOverview = 
				"Un doloroso dilema ofrece a OA una nueva perspectiva de los problemas "
				+ "del grupo. Homer decide averiguar el verdadero propósito de los "
				+ "experimentos de Hap.";
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R06_1_1_2.getFakeLocalManager());
		
		// When
		Episode resultReturned = seriesGuideApp.updateEpisodeOverview(321060, 1, 4, newOverview);
		
		// Then
		assertNotNull(resultReturned);
		assertEquals(FactoryExpectedResults.R06_1_1_2.getExpectedResult(), resultReturned);
		assertEquals(newOverview, seriesGuideApp.getEpisode(321060, 1, 4).getOverview());
		
	}
	
	// PRUEBA DE ACEPTACIÓN 06.1.1.3
	
	@Test
	public void modificarSinopsisEpisodio_CadenaMayor500Caracteres_Excepcion() {
		
		String newOverview = 
				"Un doloroso dilema ofrece a OA una nueva perspectiva de los problemas "
				+ "del grupo. Homer decide averiguar el verdadero propósito de los "
				+ "experimentos de Hap. (…) OA rememora las dramáticas idas y vueltas "
				+ "de su vida desde el accidente que sufrió de niña, el cual la condujo "
				+ "a un encuentro fatídico lejos de casa muchos años después (...). Una "
				+ "vez que OA relata la trágica noche final en lo de Hap, el grupo "
				+ "comienza a ver su historia de otra manera. Los fragmentos del sueño "
				+ "finalmente cobran sentido ... ";
		
		thrown.expect(TooLongOverviewException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R06_1_1_3.getFakeLocalManager());
		
		// When
		seriesGuideApp.updateEpisodeOverview(321060, 1, 4, newOverview);
		
		// Then	
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 06.1.2
	// El episodio no está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 06.1.2.1
	
	@Test
	public void modificarSinopsisEpisodio_ExisteSerieExisteTemporadaNoExisteEpidosio_Excepcion() {
		
		thrown.expect(NoEpisodesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R06_1_2_1.getFakeLocalManager());
		
		// When
		seriesGuideApp.updateEpisodeOverview(321060, 1, 4, "");
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 06.1.2.2
	
	@Test
	public void modificarSinopsisEpisodio_ExisteSerieNoExisteTemporada_Excepcion() {
		
		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R06_1_2_2.getFakeLocalManager());
		
		// When
		seriesGuideApp.updateEpisodeOverview(321060, 1, 4, "");
		
		// Then
		
	}
	
	// PRUEBA DE ACEPTACIÓN 06.1.2.3
	
	@Test
	public void modificarSinopsisEpisodio_NoExisteSerieExiste_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R06_1_2_3.getFakeLocalManager());
		
		// When
		seriesGuideApp.updateEpisodeOverview(321060, 1, 4, "");
		
		// Then
		
	}

}
