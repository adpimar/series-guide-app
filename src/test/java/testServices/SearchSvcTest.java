package testServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;

import org.junit.Test;

import abs.IRemoteManager;
import abs.services.ISearchService;
import impl.services.SearchSvc;

public class SearchSvcTest {
	
	@Test
	public void prueba() {
		IRemoteManager theTVDBMock = mock(IRemoteManager.class);
		when(theTVDBMock.searchSeries("Game of Thrones")).thenReturn(new LinkedList<String>());
		ISearchService searchService = new SearchSvc(theTVDBMock, null);
		System.out.println(searchService.searchSeriesRemote("Game of Thrones"));
	}
	
	@Test
	public void searchSeries_NombreExactoYSerieEnBDL_ExitoDevuelveSerie() {
		
	}

}
