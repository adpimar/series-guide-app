package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R02_HU1 {

	// REQUISITO 02
	// Debe permitir visualizar la información que hay almacenada en la BDL sobre
	// una serie concreta.

	// HISTORIA DE USUARIO 02.1
	// Como usuario quiero obtener la información de una de mis series para saber
	// acerca de ella.

	// -----------------------------------------------------------------------------

	// ESCENARIO 02.1.1
	// La serie está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 02.1.1.1

	@Test
	public void getInfoSerie_ExisteUnaSerie_UnaInfo() {
		fail("Not yet implemented");
	}

	// PRUEBA DE ACEPTACIÓN 02.1.1.2

	@Test
	public void getInfoSerie_ExistenVariasSeries_UnaInfo() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 02.1.2
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 02.1.2.1

	@Test
	public void getInfoSerie_NoExisteSerie_Excepcion() {
		fail("Not yet implemented");
	}

}
