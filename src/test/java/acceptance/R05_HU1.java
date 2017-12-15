package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R05_HU1 {

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
	public void getInfoEpisodio_ExisteSerieExisteTemporadaExisteEpidosio_UnaSerieUnaTemporada_UnaInfo() {
		fail("Not yet implemented");
	}
	
	// PRUEBA DE ACEPTACIÓN 05.1.1.2
	
	@Test
	public void getInfoEpisodio_ExisteSerieExisteTemporadaExisteEpidosio_UnaSerieVariasTemporadas_UnaInfo() {
		fail("Not yet implemented");
	}
	
	// PRUEBA DE ACEPTACIÓN 05.1.1.3

	@Test
	public void getInfoEpisodio_ExisteSerieExisteTemporadaExisteEpidosio_VariasSeriesVariasTemporadas_UnaInfo() {
		fail("Not yet implemented");
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 05.1.2
	// La serie está almacenada en la BDL + la temporada está almacenada en la BDL +
	// el episodio no está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 05.1.2.1
	
	@Test
	public void getInfoEpisodio_ExisteSerieExisteTemporadaNoExisteEpidosio_Excepcion() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 05.1.3
	// La serie está almacenada en la BDL + la temporada no está almacenada en la
	// BDL.

	// PRUEBA DE ACEPTACIÓN 05.1.3.1
	
	@Test
	public void getInfoEpisodio_ExisteSerieNoExisteTemporada_Excepcion() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 05.1.4
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 05.1.4.1
	
	@Test
	public void getInfoEpisodio_NoExisteSerie_Excepcion() {
		fail("Not yet implemented");
	}

}
