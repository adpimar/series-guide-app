package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R15_HU2 {

	// REQUISITO 15
	// Debe permitir que el usuario indique que ha visto todos los episodios de una
	// determinada temporada a través de ella y viceversa.

	// HISTORIA DE USUARIO 15.2
	// Como usuario quiero indicar como no vista una temporada de una de mis series
	// para que se indiquen automáticamente todos los episodios como no vistos de
	// dicha temporada.

	// -----------------------------------------------------------------------------

	// ESCENARIO 15.2.1
	// La temporada está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 15.2.1.1
	
	@Test
	public void indicarNoVistaTemporada_ExisteTemporadaNoVista_Excepcion() {

	}

	// PRUEBA DE ACEPTACIÓN 15.2.1.2

	@Test
	public void indicarNoVistaTemporada_ExisteTemporadaVista_TemporadaNoVista() {

	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 15.2.2
	// La temporada no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 15.2.2.1
	
	@Test
	public void indicarNoVistaTemporada_NoExisteTemporada_Excepcion() {

	}

}
