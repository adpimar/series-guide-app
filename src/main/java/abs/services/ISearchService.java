package abs.services;

import java.util.Map;

import abs.managers.ISetLocalManager;
import abs.managers.ISetRemoteManager;

public interface ISearchService extends ISetLocalManager, ISetRemoteManager {
	
	Map<String, Long> searchSeriesLocal(String pattern);
	
	Map<String, Long> searchSeriesRemote(String pattern);
	
}
