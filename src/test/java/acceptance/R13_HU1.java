package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R13_HU1 {

	// REQUISITO 13
	// Debe permitir la descarga de todos los datos de una serie concreta para su
	// consulta y su almacenamiento en la BDL si el usuario así lo indica.

	// HISTORIA DE USUARIO 13.1
	// Como usuario quiero que a través de la aplicación pueda descargar de TheTVDB
	// toda la información de una serie para consultarla y decidir si almacenarla o
	// no.

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.1
	// Existe la serie en el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 13.1.1.1
	
	@Test
	public void descargarSerie_ExisteSerie_SerieDescargada() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.2
	// No existe la serie en el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 13.1.2.1
	
	@Test
	public void descargarSerie_NoExisteSerie_Excepcion() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 13.1.3
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 13.1.3.1
	
	@Test
	public void descargarSerie_ErrorDeServidor_Excepcion() {
		fail("Not yet implemented");
	}

	// PRUEBA DE ACEPTACIÓN 13.1.3.2
	
	@Test
	public void descargarSerie_ErrorDeTimeout_Excepcion() {
		fail("Not yet implemented");
	}

}
