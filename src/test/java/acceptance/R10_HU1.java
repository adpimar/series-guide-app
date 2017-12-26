package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R10_HU1 {

	// REQUISITO 10
	// Debe permitir borrar todos los datos que hay almacenados en la BDL sobre una
	// serie concreta.

	// HISTORIA DE USUARIO 01.1
	// Como usuario quiero eliminar toda la información de una de mis series porque
	// porque ya no me interesa ni la quiero tener almacenada.

	// -----------------------------------------------------------------------------

	// ESCENARIO 10.1.1
	// La serie está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 10.1.1.1
	
	@Test
	public void eliminarSerie_ExisteSerieConVariasTemporadas_SerieBorrada() {

	}

	// PRUEBA DE ACEPTACIÓN 10.1.1.2
	
	@Test
	public void eliminarSerie_ExisteSerieConUnaTemporada_SerieBorrada() {

	}

	// PRUEBA DE ACEPTACIÓN 10.1.1.3
	
	@Test
	public void eliminarSerie_ExisteSerieConCeroTemporada_SerieBorrada() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 10.1.4
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 10.1.4.1
	
	@Test
	public void eliminarSerie_NoExisteSerie_Excepcion() {

	}

}
