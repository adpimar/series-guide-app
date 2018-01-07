package tests.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abs.managers.ILocalManager;
import impl.exceptions.NoSeriesStoredException;
import impl.model.Season;
import resources.FactoryExpectedResults;
import resources.FactoryLocalManagers;
import resources.FactoryMocks;

public class R14_HU2 extends AcceptanceTest {

	// REQUISITO 14
	// Debe permitir la descarga del título y la descripción de todos los episodios
	// que conforman una temporada concreta de una serie dada y su almacenamiento en
	// la BDL si el usuario así lo indica.

	// HISTORIA DE USUARIO 14.2
	// Como usuario quiero que a través de la aplicación pueda almacenar toda la
	// información de una temporada (todos los episodios) de una serie previamente
	// consultada en TheTVDB para disponer de ella en la BDL.

	// -----------------------------------------------------------------------------

	// ESCENARIO 14.2.1
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 14.2.1.1
	
	@Test
	public void almacenarTemporadaRemota_SerieNoAlmacenada_Excepcion() {

		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_2_1_1.getLocalManager());
		
		// When
		seriesGuideApp.storeRemoteSeason((Season) FactoryMocks.R14_2_1_1.getMock());

		// Then
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 14.2.2
	// La serie está almacenada en la BDL + la temporada no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 14.2.2.1
	
	@Test
	public void almacenarTemporadaRemota_NoAlmacenadaSerieSinTemporadas_TemporadaAlmacenada() {
		
		ILocalManager localManager = FactoryLocalManagers.R14_2_2_1.getLocalManager();
		Season mockSeason = (Season) FactoryMocks.R14_2_2_1.getMock();
		Season resultExpected = (Season) FactoryExpectedResults.R14_2_2_1.getExpectedResult();
		
		// Given
		seriesGuideApp.setLocalManager(localManager);
				
		// When
		seriesGuideApp.storeRemoteSeason(mockSeason);

		// Then
		assertEquals(resultExpected, seriesGuideApp.getSeason(mockSeason.getCodSerie(), mockSeason.getAiredSeason()));
		
	}
	
	// PRUEBA DE ACEPTACIÓN 14.2.2.2
	
	@Test
	public void almacenarTemporadaRemota_NoAlmacenadaSerieConTemporadas_TemporadaAlmacenada() {

		ILocalManager localManager = FactoryLocalManagers.R14_2_2_2.getLocalManager();
		Season mockSeason = (Season) FactoryMocks.R14_2_2_2.getMock();
		Season resultExpected = (Season) FactoryExpectedResults.R14_2_2_2.getExpectedResult();
		
		// Given
		seriesGuideApp.setLocalManager(localManager);
				
		// When
		seriesGuideApp.storeRemoteSeason(mockSeason);

		// Then
		assertEquals(resultExpected, seriesGuideApp.getSeason(mockSeason.getCodSerie(), mockSeason.getAiredSeason()));
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 14.2.3
	// La serie está almacenada en la BDL + la temporada está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 14.2.3.1
	
	@Test
	public void almacenarTemporadaRemota_Almacenada_Excepcion() {

		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R14_2_3_1.getLocalManager());
		
		// When
		seriesGuideApp.storeRemoteSeason((Season) FactoryMocks.R14_2_3_1.getMock());

		// Then
		
	}

}