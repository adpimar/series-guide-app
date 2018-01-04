package abs.services;

import java.util.Map;

import abs.ISetLocalManager;
import abs.ISetRemoteManager;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NoKeywordsOnRemoteSearchException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;

public interface ISearchService extends ISetLocalManager, ISetRemoteManager {
	
	Map<String, Long> searchSeriesLocal(String pattern);
	
	Map<String, Long> searchSeriesRemote(String pattern);
	
}
