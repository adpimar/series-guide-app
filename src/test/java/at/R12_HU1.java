package at;

import org.junit.Test;

public class R12_HU1 extends AcceptanceTest {

	// 503 Service Unavailable
	// No server is available to handle this request.

	// REQUISITO 12
	// Debe permitir la realización de búsquedas por Internet usando los servicios
	// REST que proporciona el API del servidor TheTVDB. Las búsquedas se realizarán
	// siempre mediante palabras clave que puedan aparecer en el título de una
	// serie.

	// HISTORIA DE USUARIO 12.1
	// Como usuario quiero que a través de la aplicación pueda realizar búsquedas de
	// series en TheTVDB mediante palabras clave que puedan aparecer en el título
	// para poder almacenarlas en mi BDL.

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.1
	// Existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).
	
	// PRUEBA DE ACEPTACIÓN 12.1.1.1

	@Test
	public void buscarRemotamenteSerie_ConCadenaVacia_Excepcion() {

	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.2

	@Test
	public void buscarRemotamenteSerie_ConUnaPalabraClave_Excepcion() {

	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.3

	@Test
	public void buscarRemotamenteSerie_ConVariasPalabrasClave_Excepcion() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.2
	// No existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).

	// PRUEBA DE ACEPTACIÓN 12.1.2.1

	@Test
	public void buscarRemotamenteSerie_NoExisteSerie_Excepcion() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.3
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 12.1.3.1

	@Test
	public void buscarRemotamenteSerie_ErrorDeServidor_Excepcion() {

	}

	// PRUEBA DE ACEPTACIÓN 12.1.3.2

	@Test
	public void buscarRemotamenteSerie_ErrorDeTimeout_Excepcion() {

	}

}
