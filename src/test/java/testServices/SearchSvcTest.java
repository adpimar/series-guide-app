package testServices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;

import org.junit.Test;

import abs.SearchService;
import abs.TheTVDBManager;
import impl.SearchSvc;

public class SearchSvcTest {
	
	@Test
	public void prueba() {
		TheTVDBManager theTVDBMock = mock(TheTVDBManager.class);
		when(theTVDBMock.searchSeries("Game of Thrones")).thenReturn(new LinkedList<String>());
		SearchService searchService = new SearchSvc(theTVDBMock);
		System.out.println(searchService.searchSeries("Game of Thrones"));
	}
	
	@Test
	public void searchSeries_NombreExactoYSerieEnBDL_ExitoDevuelveSerie() {
		
	}

}
