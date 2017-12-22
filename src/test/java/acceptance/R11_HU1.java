package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R11_HU1 {

	// REQUISITO 11
	// Debe permitir la realización de búsquedas de series en la BDL mediante
	// palabras clave que puedan aparecer en su título.

	// HISTORIA DE USUARIO 11.1
	// Como usuario quiero realizar búsquedas de series en mi BDL mediante palabras
	// clave que puedan aparecer en el título para poder consultarlas.

	// -----------------------------------------------------------------------------

	// ESCENARIO 11.1.1
	// Existen varias series almacenadas en la BDL y existe la serie a buscar.

	// PRUEBA DE ACEPTACIÓN 11.1.1.1

	@Test
	public void buscarLocalmenteSerie_ConCadenaVacia_ListaVacia() {
		fail("Not yet implemented");
	}
	
	// PRUEBA DE ACEPTACIÓN 11.1.1.2
	
	@Test
	public void buscarLocalmenteSerie_ConUnaPalabraClave_ListaNoVacia() {
		fail("Not yet implemented");
	}

	// PRUEBA DE ACEPTACIÓN 11.1.1.3

	@Test
	public void buscarLocalmenteSerie_ConPalabrasClave_ListaNoVacia() {
		fail("Not yet implemented");
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 11.1.2
	// Existen varias series almacenadas en la BDL y no existe la serie a buscar.

	// PRUEBA DE ACEPTACIÓN 11.1.1.1

	@Test
	public void buscarLocalmenteSerie_ConCadenaVacia_Excepcion() {
		fail("Not yet implemented");
	}
	
	// PRUEBA DE ACEPTACIÓN 11.1.1.2
	
	@Test
	public void buscarLocalmenteSerie_ConUnaPalabraClave_Excepcion() {
		fail("Not yet implemented");
	}

	// PRUEBA DE ACEPTACIÓN 11.1.1.3

	@Test
	public void buscarLocalmenteSerie_ConPalabrasClave_Excepcion() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 11.1.3
	// No existe ninguna serie almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 11.1.3.1
	
	@Test
	public void buscarLocalmenteSerie_NoExistenSeries_Excepcion() {
		fail("Not yet implemented");
	}

}
