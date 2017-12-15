package acceptance;

import static org.junit.Assert.fail;

import org.junit.Test;

public class R08_HU1 {

	// REQUISITO 08
	// Debe permitir que el usuario indique que NO ha visto un episodio concreto de
	// una temporada determinada para una serie dada. Si hubiese un comentario del
	// usuario asociado con dicho episodio, debe borrarlo en este caso.

	// HISTORIA DE USUARIO 08.1
	// Como usuario quiero indicar que no he visto un episodio de una temporada de
	// una de mis series para saber que no lo he visto.

	// -----------------------------------------------------------------------------

	// ESCENARIO 08.1.1
	// El episodio está almacenado en la BDL + está ya indicado como no visto.

	// PRUEBA DE ACEPTACIÓN 08.1.1.1
	
	@Test
	public void indicarNoVistoEpisodio_ExisteEpisodioNoVisto_Excepcion() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 08.1.2
	// El episodio está almacenado en la BDL + está indicado como visto + no está
	// comentado.

	// PRUEBA DE ACEPTACIÓN 08.1.2.1
	
	@Test
	public void indicarNoVistoEpisodio_ExisteEpisodioVistoNoComentado_EpisodioNoVisto() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 08.1.3
	// El episodio está almacenado en la BDL + está indicado como visto + está
	// comentado.

	// PRUEBA DE ACEPTACIÓN 08.1.3.1
	
	@Test
	public void indicarNoVistoEpisodio_ExisteEpisodioVistoComentado_EpisodioNoVistoSinComentario() {
		fail("Not yet implemented");
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 08.1.4
	// El episodio no está almacenado en la BDL.

	// PRUEBA DE ACEPTACIÓN 08.1.4.1
	
	@Test
	public void indicarNoVistoEpisodio_NoExisteEpisodio_Excepcion() {
		fail("Not yet implemented");
	}

}
