package at;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import abs.IRemoteManager;
import impl.exceptions.NoKeywordsOnRemoteSearchException;
import impl.exceptions.NoSeriesStoredException;

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

	@Mock
	private IRemoteManager remoteManager;
	
	@Before
	public void prepara() {
		MockitoAnnotations.initMocks(this);
		setRemoteManagers(remoteManager);
	}
	
	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.1
	// Existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).
	
	// PRUEBA DE ACEPTACIÓN 12.1.1.1

	@Test
	public void buscarRemotamenteSerie_ConCadenaVacia_Excepcion() 
			throws NoKeywordsOnRemoteSearchException 
	{
		thrown.expect(NoKeywordsOnRemoteSearchException.class);
		
		// Given
		//when(remoteManager.searchSeries("")).thenThrow(new NoKeywordsOnRemoteSearchException());
		
		// When
		searchService.searchSeriesRemote("");
		
		// Then
		
	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.2

	@Test
	public void buscarRemotamenteSerie_ConUnaPalabraClave_Excepcion() 
	{
		// Given
		//when(remoteManager.searchSeries("")).thenReturn(value);
		
		// When
		
		// Then
		
	}

	// PRUEBA DE ACEPTACIÓN 12.1.1.3

	@Test
	public void buscarRemotamenteSerie_ConVariasPalabrasClave_Excepcion() 
	{
		// Given
		
		// When
		
		// Then
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.2
	// No existe la serie a buscar en el servidor de TheTVDB (búsqueda en inglés).

	// PRUEBA DE ACEPTACIÓN 12.1.2.1

	@Test
	public void buscarRemotamenteSerie_NoExisteSerie_Excepcion() 
	{
		// Given
		
		// When
		
		// Then
		
	}

	// -----------------------------------------------------------------------------

	// ESCENARIO 12.1.3
	// Surgen problemas con el servidor de TheTVDB.

	// PRUEBA DE ACEPTACIÓN 12.1.3.1

	@Test
	public void buscarRemotamenteSerie_ErrorDeServidor_Excepcion() 
	{
		// Given
		
		// When
		
		// Then
		
	}

	// PRUEBA DE ACEPTACIÓN 12.1.3.2

	@Test
	public void buscarRemotamenteSerie_ErrorDeTimeout_Excepcion() 
	{
		// Given
		
		// When
		
		// Then
		
	}

}
