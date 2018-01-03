package abs.services;

import java.util.Map;

import abs.ISetLocalManager;
import abs.ISetRemoteManager;
import impl.exceptions.NoSeriesStoredException;

public interface ISearchService extends ISetLocalManager, ISetRemoteManager {
	
	Map<String, Long> searchSeriesLocal(String pattern) throws NoSeriesStoredException;
	
	Map<String, Long> searchSeriesRemote(String pattern);
	
}
