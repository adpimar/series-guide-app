package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R09_HU1 {

	// REQUISITO 09
	// Debe permitir borrar todos los datos que hay almacenados en la BDL sobre una
	// temporada concreta de una serie determinada.

	// HISTORIA DE USUARIO 09.1
	// Como usuario quiero eliminar toda la información de una temporada de una de
	// mis series porque ya no me interesa ni la quiero tener almacenada.

	// -----------------------------------------------------------------------------

	// ESCENARIO 09.1.1
	// La temporada está almacenada en la BDL + tiene varios episodios almacenados.

	// PRUEBA DE ACEPTACIÓN 09.1.1.1
	
	@Test
	public void eliminarTemporada_ExisteTemporadaConVariosEpisodiosNoVistos_TemporadaBorrada() {

	}

	// PRUEBA DE ACEPTACIÓN 09.1.1.2

	@Test
	public void eliminarTemporada_ExisteTemporadaConVariosEpisodiosAlgunoVisto_TemporadaBorrada() {

	}
	
	// PRUEBA DE ACEPTACIÓN 09.1.1.3
	
	@Test
	public void eliminarTemporada_ExisteTemporadaConVariosEpisodiosAlgunoVistoComentado_TemporadaBorrada() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 09.1.2
	// La temporada está almacenada en la BDL + tiene un episodio almacenado.

	// PRUEBA DE ACEPTACIÓN 09.1.2.1
	
	@Test
	public void eliminarTemporada_ExisteTemporadaConUnEpisodio_TemporadaBorrada() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 09.1.3
	// La temporada está almacenada en la BDL + no tiene ningún episodio almacenado.

	// PRUEBA DE ACEPTACIÓN 09.1.3.1
	
	@Test
	public void eliminarTemporada_ExisteTemporadaSinEpisodios_Excepcion() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 09.1.4
	// Existen varias temporadas de una misma serie almacenadas en la BDL.

	// PRUEBA DE ACEPTACIÓN 09.1.4.1
	
	@Test
	public void eliminarTemporada_VariasTemporadasExisteTemporada_TemporadaBorrada() {

	}

	// PRUEBA DE ACEPTACIÓN 09.1.4.2
	
	@Test
	public void eliminarTemporada_VariasTemporadasNoExisteTemporada_Excepcion() {

	}
	
}
