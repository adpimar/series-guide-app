package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R06_HU1 {

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
	public void setSinopsisEpisodio_CadenaVacia_CadenaVacia() {
		fail("Not yet implemented");
	}
	
	// PRUEBA DE ACEPTACIÓN 06.1.1.2

	@Test
	public void setSinopsisEpisodio_CadenaMenor500Caracteres_Cadena() {
		fail("Not yet implemented");
	}
	
	// PRUEBA DE ACEPTACIÓN 06.1.1.3
	
	@Test
	public void setSinopsisEpisodio_CadenaMayor500Caracteres_Excepcion() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 06.1.2
	// El episodio no está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 06.1.2.1
	
	@Test
	public void setSinopsisEpisodio_NoExisteEpisodio_Excepcion() {
		fail("Not yet implemented");
	}

}
