package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R15_HU1 {

	// REQUISITO 15
	// Debe permitir que el usuario indique que ha visto todos los episodios de una
	// determinada temporada a través de ella y viceversa.

	// HISTORIA DE USUARIO 15.1
	// Como usuario quiero indicar como vista una temporada de una de mis series
	// para que se indiquen automáticamente todos los episodios como vistos de dicha
	// temporada.

	// -----------------------------------------------------------------------------

	// ESCENARIO 15.1.1
	// La temporada está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 15.1.1.1
	
	@Test
	public void indicarVistaTemporada_ExisteTemporadaNoVista_TemporadaVista() {

	}

	// PRUEBA DE ACEPTACIÓN 15.1.1.2

	@Test
	public void indicarVistaTemporada_ExisteTemporadaVista_Excepcion() {

	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 15.1.2
	// La temporada no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 15.1.2.1
	
	@Test
	public void indicarVistaTemporada_NoExisteTemporada_Excepcion() {

	}

}
