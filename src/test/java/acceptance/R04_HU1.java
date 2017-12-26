package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R04_HU1 {

	// REQUISITO 04
	// Debe permitir obtener una lista con los títulos de todos los episodios de una
	// temporada concreta para una serie determinada que hay almacenados en la BDL.

	// HISTORIA DE USUARIO 04.1
	// Como usuario quiero obtener un listado de los títulos de todos los episodios
	// de una temporada de una de mis series para saber qué capítulos tiene.

	// -----------------------------------------------------------------------------

	// ESCENARIO 04.1.1
	// La serie está almacenada en la BDL + la temporada está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 04.1.1.1

	@Test
	public void listarEpisodios_UnaSerieUnaTemporadaExistenTodosEpisodios_TodosEpisodios() {

	}

	// PRUEBA DE ACEPTACIÓN 04.1.1.2

	@Test
	public void listarEpisodios_VariasSeriesVariasTemporadasExistenAlgunosEpisodios_AlgunosEpisodiosConOpcionDescargaRestoEpisodios() {

	}

	// PRUEBA DE ACEPTACIÓN 04.1.1.3

	@Test
	public void listarEpisodios_UnaSerieVariasTemporadasNoExistenEpisodios_OpcionDescargaEpisodios() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 04.1.2
	// La serie está almacenada en la BDL + la temporada no está almacenada en la
	// BDL.

	// PRUEBA DE ACEPTACIÓN 04.1.2.1

	@Test
	public void listarEpisodios_NoExisteTemporada_Excepcion() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 04.1.3
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 04.1.3.1

	@Test
	public void listarEpisodios_NoExisteSerie_Excepcion() {

	}

}
