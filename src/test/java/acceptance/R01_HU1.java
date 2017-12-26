package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R01_HU1 {

	// REQUISITO 01
	// Debe permitir obtener una lista con los títulos de todas las series
	// almacenadas en la BDL.

	// HISTORIA DE USUARIO 01.1
	// Como usuario quiero obtener un listado de todos los títulos de mis series
	// para saber cuáles estoy siguiendo.

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.1
	// Existen varias series almacenadas en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.1.1

	@Test
	public void listar_ExistenVariasSeries_DosSeries() {
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.2
	// Existe sólo una serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.2.1

	@Test
	public void listar_ExisteUnaSerie_UnaSerie() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 01.1.3
	// No existe ninguna serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 01.1.3.1

	@Test
	public void listar_NoExistenSeries_Excepcion() {

	}

}
