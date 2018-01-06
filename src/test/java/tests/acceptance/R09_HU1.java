package tests.acceptance;

import org.junit.Test;

import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import resources.FactoryLocalManagers;

public class R09_HU1 extends AcceptanceTest {

	// REQUISITO 09
	// Debe permitir borrar todos los datos que hay almacenados en la BDL sobre una
	// temporada concreta de una serie determinada.

	// HISTORIA DE USUARIO 09.1
	// Como usuario quiero eliminar toda la información de una temporada de una de
	// mis series porque ya no me interesa ni la quiero tener almacenada.
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 09.1.1
	// La temporada está almacenada en la BDL + la serie no tiene más temporadas
	// almacenadas en la BDL.

	// PRUEBA DE ACEPTACIÓN 09.1.1.1

	@Test
	public void eliminarTemporada_TodosEpisodiosAlmacenadosTodosVistos_TemporadaBorrada() {
		
		// Given
		setLocalManagers(FactoryLocalManagers.R09_1_1_1.getLocalManager());
		
		// When
		deleteService.deleteSeason(321060, 1);
		
		// Then
		thrown.expect(NoSeasonsStoredException.class);
		getAndListService.getSeason(321060, 1);
		
	}

	// PRUEBA DE ACEPTACIÓN 09.1.1.2

	@Test
	public void eliminarTemporada_TodosEpisodiosAlmacenadosNoTodosVistos_TemporadaBorrada() {
		
		// Given
		setLocalManagers(FactoryLocalManagers.R09_1_1_2.getLocalManager());
		
		// When
		deleteService.deleteSeason(321060, 1);
		
		// Then
		thrown.expect(NoSeasonsStoredException.class);
		getAndListService.getSeason(321060, 1);
		
	}

	// PRUEBA DE ACEPTACIÓN 09.1.1.3

	@Test
	public void eliminarTemporada_UnEpisodioAlmacenado_TemporadaBorrada() {
		
		// Given
		setLocalManagers(FactoryLocalManagers.R09_1_1_3.getLocalManager());
		
		// When
		deleteService.deleteSeason(321060, 1);
		
		// Then
		thrown.expect(NoSeasonsStoredException.class);
		getAndListService.getSeason(321060, 1);
		
	}

	// PRUEBA DE ACEPTACIÓN 09.1.1.4

	@Test
	public void eliminarTemporada_NingunEpisodioAlmacenado_TemporadaBorrada() {
		
		// Given
		setLocalManagers(FactoryLocalManagers.R09_1_1_4.getLocalManager());
		
		// When
		deleteService.deleteSeason(321060, 1);
		
		// Then
		thrown.expect(NoSeasonsStoredException.class);
		getAndListService.getSeason(321060, 1);
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 09.1.2
	// La temporada está almacenada en la BDL + la serie tiene más temporadas
	// almacenadas en la BDL.

	// PRUEBA DE ACEPTACIÓN 09.1.2.1

	@Test
	public void eliminarTemporada_SerieConVariasTemporadas_TemporadaBorrada() {
		
		// Given
		setLocalManagers(FactoryLocalManagers.R09_1_2_1.getLocalManager());
		
		// When
		deleteService.deleteSeason(305288, 1);
		
		// Then
		thrown.expect(NoSeasonsStoredException.class);
		getAndListService.getSeason(305288, 1);
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 09.1.3
	// La temporada no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 09.1.3.1

	@Test
	public void eliminarTemporada_ExisteSerieNoExisteTemporada_Excepcion() {
		
		thrown.expect(NoSeasonsStoredException.class);
		
		// Given
		setLocalManagers(FactoryLocalManagers.R09_1_3_1.getLocalManager());
		
		// When
		deleteService.deleteSeason(321060, 1);
		
		// Then
		
	}

	// PRUEBA DE ACEPTACIÓN 09.1.3.2

	@Test
	public void eliminarTemporada_NoExisteSerie_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		setLocalManagers(FactoryLocalManagers.R09_1_3_2.getLocalManager());
		
		// When
		deleteService.deleteSeason(321060, 1);
		
		// Then

	}

}
