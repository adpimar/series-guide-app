package abs.services;

import java.util.List;
import java.util.Map;

public interface ISearchService {
	
	List<String> searchSeriesLocal(String pattern);
	
	Map<Long, String> searchSeriesRemote(String pattern);
	
}
