package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R03_HU1 {

	// REQUISITO 03
	// Debe permitir modificar la descripción que hay almacenada en la BDL sobre una
	// serie concreta.

	// HISTORIA DE USUARIO 03.1
	// Como usuario quiero modificar la sinopsis de una de mis series para que se
	// ajuste más a mi parecer.

	// -----------------------------------------------------------------------------

	// ESCENARIO 03.1.1
	// La serie está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 03.1.1.1

	@Test
	public void setSinopsisSerie_CadenaVacia_CadenaVacia() {
		fail("Not yet implemented");
	}
	
	// PRUEBA DE ACEPTACIÓN 03.1.1.2

	@Test
	public void setSinopsisSerie_CadenaMenor500Caracteres_Cadena() {
		fail("Not yet implemented");
	}
	
	// PRUEBA DE ACEPTACIÓN 03.1.1.3

	@Test
	public void setSinopsisSerie_CadenaMayor500Caracteres_Excepcion() {
		fail("Not yet implemented");
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 03.1.2
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 03.1.2.1
	
	@Test
	public void setSinopsisSerie_NoExisteSerie_Excepcion() {
		fail("Not yet implemented");
	}

}
