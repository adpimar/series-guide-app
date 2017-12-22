package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R14_HU2 {

	// REQUISITO 14
	// Debe permitir la descarga del título y la descripción de todos los episodios
	// que conforman una temporada concreta de una serie dada y su almacenamiento en
	// la BDL si el usuario así lo indica.

	// HISTORIA DE USUARIO 14.1
	// Como usuario quiero que a través de la aplicación pueda almacenar toda la
	// información de una temporada (todos los episodios) de una serie previamente
	// consultada en TheTVDB para disponer de ella en la BDL.

	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.1
	// La serie no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 14.1.1.1
	
	@Test
	public void almacenarTemporada_SerieNoAlmacenada_SerieAlmacenadaTemporadaAlmacenada() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.2
	// La serie está almacenada en la BDL + la temporada no está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 14.1.2.1
	
	@Test
	public void almacenarTemporada_SerieAlmacenadaTemporadaNoAlmacenada_TemporadaAlmacenada() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 14.1.3
	// La serie está almacenada en la BDL + la temporada está almacenada en la BDL.

	// PRUEBA DE ACEPTACIÓN 14.1.3.1
	
	@Test
	public void almacenarTemporada_SerieAlmacenadaTemporadaAlmacenada_Excepcion() {
		fail("Not yet implemented");
	}

}
