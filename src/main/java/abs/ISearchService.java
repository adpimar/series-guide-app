package abs;

import java.util.List;

public interface ISearchService {
	
	List<String> searchSeriesLocal(String pattern);
	
	List<String> searchSeriesRemote(String pattern);
	
}
