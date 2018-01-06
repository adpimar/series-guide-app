package tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import abs.managers.IRemoteManager;
import impl.exceptions.NoOperationParametersOnRemoteServerException;
import impl.exceptions.NotAuthorizedOnRemoteServerException;
import impl.exceptions.NotFoundOnRemoteServerException;
import impl.managers.remote.thetvdb.TheTVDBAdapter;
import impl.model.Season;
import impl.model.Serie;

public class TheTVDBAdapterTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
	
	// -----------------------------------------------------------------------------
	
	private static IRemoteManager tvdb;

	@BeforeClass
	public static void inicia() {
		tvdb = new TheTVDBAdapter();
	}

	@AfterClass
	public static void termina() {
		tvdb = null;
	}
	
	// -----------------------------------------------------------------------------

	@Test
	public void cualquierOperacion_TokenNoValido_Excepcion() {

		// Arrange 
		thrown.expect(NotAuthorizedOnRemoteServerException.class);
		String pattern = "";
		
		// Act
		new TheTVDBAdapter("apikey", "userkey", "username").searchRemoteSeries(pattern);

		// Assert

	}
	
	// -----------------------------------------------------------------------------
	
	@Test
	public void busquedaSeriesRemota_CadenaVacia_Excepcion() {

		// Arrange 
		thrown.expect(NoOperationParametersOnRemoteServerException.class);
		String pattern = "";
		
		// Act
		tvdb.searchRemoteSeries(pattern);

		// Assert

	}

	@Test
	public void busquedaSeriesRemota_CadenaConBlancos_Excepcion() {

		// Arrange 
		thrown.expect(NotFoundOnRemoteServerException.class);
		String pattern = "  ";
		
		// Act
		tvdb.searchRemoteSeries(pattern);

		// Assert

	}
	
	@Test
	public void busquedaSeriesRemota_CadenaConCaracteresNoAlfanumericos_Excepcion() {

		// Arrange 
		thrown.expect(NotFoundOnRemoteServerException.class);
		String pattern = "\"\";)(";
		
		// Act
		tvdb.searchRemoteSeries(pattern);

		// Assert

	}

	@Test
	public void busquedaSeriesRemota_UnaPalabraClaveHayCoincidencias_Respuesta() {

		// Arrange 
		String pattern = "Thrones";
		long[] resultExpected = {
				268310,
				273385,
				311939,
				312618,
				309875,
				121361,
				321282
		};
		
		// Act
		List<Serie> resultReturned = tvdb.searchRemoteSeries(pattern);

		// Assert
		assertNotNull(resultReturned);
		assertTrue(resultReturned.size() >= resultExpected.length);
		assertTrue(compruebaQueEstanAlMenosLasSeriesEsperadas(resultExpected, resultReturned));

	}
	
	@Test
	public void busquedaSeriesRemota_VariasPalabrasClaveHayCoincidencias_Respuesta() {

		// Arrange 
		String pattern = "Game of Thrones";
		long[] resultExpected = {
				311939,
				121361,
				321282
		};
		
		// Act
		List<Serie> resultReturned = tvdb.searchRemoteSeries(pattern);

		// Assert
		assertNotNull(resultReturned);
		assertTrue(resultReturned.size() >= resultExpected.length);
		assertTrue(compruebaQueEstanAlMenosLasSeriesEsperadas(resultExpected, resultReturned));

	}
	
	@Test
	public void busquedaSeriesRemota_UnaPalabraClaveNoHayCoincidencias_Excepcion() {

		// Arrange 
		thrown.expect(NotFoundOnRemoteServerException.class);
		String pattern = "lalilo";

		// Act
		tvdb.searchRemoteSeries(pattern);

		// Assert

	}
	
	@Test
	public void busquedaSeriesRemota_VariasPalabrasClaveNoHayCoincidencias_Respuesta() {

		// Arrange
		thrown.expect(NotFoundOnRemoteServerException.class);
		String pattern = "lalilo tiroriro";

		// Act
		tvdb.searchRemoteSeries(pattern);

		// Assert

	}
	
	// -----------------------------------------------------------------------------
	
	@Test
	public void obtencionSerieRemota_CodigoNegativo_Excepcion() {

		// Arrange
		thrown.expect(NotFoundOnRemoteServerException.class);
		long codSerie = -1;
		
		// Act
		tvdb.getRemoteSerie(codSerie);

		// Assert

	}

	@Test
	public void obtencionSerieRemota_CodigoInexistente_Excepcion() {

		// Arrange
		thrown.expect(NotFoundOnRemoteServerException.class);
		long codSerie = 9999999;
		
		// Act
		tvdb.getRemoteSerie(codSerie);

		// Assert

	}

	@Test
	public void obtencionSerieRemota_CodigoExistente_Serie() {

		// Arrange
		long codSerie = 321060;
		
		// Act
		Serie resultReturned = tvdb.getRemoteSerie(codSerie);

		// Assert
		assertNotNull(resultReturned);

	}

	// -----------------------------------------------------------------------------

	@Test
	public void obtencionTemporadaRemota_CodigoSerieNegativo_Excepcion() {

		// Arrange
		thrown.expect(NotFoundOnRemoteServerException.class);
		long codSerie = -1;
		int airedSeason = 1;
		
		// Act
		tvdb.getRemoteSeason(codSerie, airedSeason);

		// Assert

	}
	
	@Test
	public void obtencionTemporadaRemota_NumeroTemporadaNegativo_Excepcion() {

		// Arrange
		thrown.expect(NotFoundOnRemoteServerException.class);
		long codSerie = 321060;
		int airedSeason = -1;
		
		// Act
		tvdb.getRemoteSeason(codSerie, airedSeason);

		// Assert

	}

	@Test
	public void obtencionTemporadaRemota_CodigoInexistente_Excepcion() {

		// Arrange
		thrown.expect(NotFoundOnRemoteServerException.class);
		long codSerie = 9999999;
		int airedSeason = 1;
		
		// Act
		tvdb.getRemoteSeason(codSerie, airedSeason);

		// Assert

	}
	
	@Test
	public void obtencionTemporadaRemota_NumeroTemporadaInexistente_Excepcion() {

		// Arrange
		thrown.expect(NotFoundOnRemoteServerException.class);
		long codSerie = 321060;
		int airedSeason = 9999999;
		
		// Act
		tvdb.getRemoteSeason(codSerie, airedSeason);

		// Assert

	}

	@Test
	public void obtencionTemporadaRemota_CodigoExistenteTemporadaExistente_Temporada() {

		// Arrange
		long codSerie = 321060;
		int airedSeason = 1;
		int resultExpected = 8;
		
		// Act
		Season season = tvdb.getRemoteSeason(codSerie, airedSeason);

		// Assert
		assertNotNull(season);
		assertEquals(resultExpected, season.getEpisodes().length);
		
	}
	
	// -----------------------------------------------------------------------------

	private boolean compruebaQueEstanAlMenosLasSeriesEsperadas(long[] resultExpected, List<Serie> resultReturned) {
		Set<Long> resultExpectedCods = new HashSet<>();
		for (Serie serie : resultReturned)
			resultExpectedCods.add(serie.getCodSerie());
		
		for (Long codSerie : resultExpected)
			if (!resultExpectedCods.contains(codSerie))
				return false;
		
		return true;
	}
		
}
