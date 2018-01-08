package tests.acceptance;

import org.junit.Test;

import impl.exceptions.NoSeriesStoredException;
import resources.FactoryLocalManagers;

public class R10_HU1 extends AcceptanceTest {

	// REQUISITO 10
	// Debe permitir borrar todos los datos que hay almacenados en la BDL sobre una
	// serie concreta.

	// HISTORIA DE USUARIO 01.1
	// Como usuario quiero eliminar toda la información de una de mis series porque
	// porque ya no me interesa ni la quiero tener almacenada.

	// -----------------------------------------------------------------------------

	// ESCENARIO 10.1.1
	// Existe una serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 10.1.1.1

	@Test
	public void eliminarSerie_SerieAlmacenadaConVariasTemporadas_SerieBorrada() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R10_1_1_1.getFakeLocalManager());
		
		// When
		seriesGuideApp.deleteSerie(305288);
		
		// Then
		thrown.expect(NoSeriesStoredException.class);
		seriesGuideApp.getSerie(305288);
		
	}

	// PRUEBA DE ACEPTACIÓN 10.1.1.2

	@Test
	public void eliminarSerie_SerieAlmacenadaConUnaTemporada_SerieBorrada() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R10_1_1_2.getFakeLocalManager());
		
		// When
		seriesGuideApp.deleteSerie(305288);
		
		// Then
		thrown.expect(NoSeriesStoredException.class);
		seriesGuideApp.getSerie(305288);
		
	}

	// PRUEBA DE ACEPTACIÓN 10.1.1.3

	@Test
	public void eliminarSerie_SerieAlmacenadaSinTemporadas_SerieBorrada() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R10_1_1_3.getFakeLocalManager());
		
		// When
		seriesGuideApp.deleteSerie(305288);
		
		// Then
		thrown.expect(NoSeriesStoredException.class);
		seriesGuideApp.getSerie(305288);
		
	}

	// PRUEBA DE ACEPTACIÓN 10.1.1.4
	
	@Test
	public void eliminarSerie_SerieNoAlmacenada_Excepcion() {
		
		thrown.expect(NoSeriesStoredException.class);
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R10_1_1_4.getFakeLocalManager());
		
		// When
		seriesGuideApp.deleteSerie(321060);
		
		// Then

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 10.1.2
	// Existen varias series almacenadas en la BDL.

	// PRUEBA DE ACEPTACIÓN 10.1.2.1

	@Test
	public void eliminarSerie_ExistenVariasSeries_SerieBorrada() {
		
		// Given
		seriesGuideApp.setLocalManager(FactoryLocalManagers.R10_1_2_1.getFakeLocalManager());
		
		// When
		seriesGuideApp.deleteSerie(305288);
		
		// Then
		thrown.expect(NoSeriesStoredException.class);
		seriesGuideApp.getSerie(305288);
		
	}

}
