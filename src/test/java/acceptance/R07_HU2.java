package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R07_HU2 {

	// REQUISITO 07
	// Debe permitir que el usuario indique que ha visto un episodio concreto de una
	// temporada determinada para una serie dada. En ese caso el programa debe
	// permitir que el usuario introduzca un comentario al respecto si es su
	// voluntad -máx. 150 caracteres.

	// HISTORIA DE USUARIO 07.2
	// Como usuario quiero comentar un episodio visto de una temporada de una de mis
	// series para expresar y recordar las impresiones que tuve de él.

	// -----------------------------------------------------------------------------

	// ESCENARIO 07.2.1
	// El episodio está almacenado en la BDL + está indicado como no visto.

	// PRUEBA DE ACEPTACIÓN 07.2.1.1
	
	@Test
	public void comentarEpisodio_ExisteEpisodioNoVisto_Excepcion() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 07.2.2
	// El episodio está almacenado en la BDL + está indicado como visto + no está
	// comentado.

	// PRUEBA DE ACEPTACIÓN 07.2.2.1
	
	@Test
	public void comentarEpisodio_ExisteEpisodioVistoCadenaVacia_CadenaVacia() {

	}

	// PRUEBA DE ACEPTACIÓN 07.2.2.2

	@Test
	public void comentarEpisodio_ExisteEpisodioVistoCadenaMenor150Caracteres_Cadena() {

	}
	
	// PRUEBA DE ACEPTACIÓN 07.2.2.3

	@Test
	public void comentarEpisodio_ExisteEpisodioVistoCadenaMayor150Caracteres_Excepcion() {

	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 07.2.3
	// El episodio está almacenado en la BDL + está indicado como visto + está
	// comentado.

	// PRUEBA DE ACEPTACIÓN 07.2.3.1
	
	@Test
	public void comentarEpisodio_ExisteEpisodioVistoComentado_NuevoComentario() {

	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 07.2.4
	// El episodio no está almacenado en la BDL.
	
	// PRUEBA DE ACEPTACIÓN 07.2.4.1
	
	@Test
	public void comentarEpisodio_NoExisteEpisodio_Excepcion() {

	}

}
