package impl.services;

import java.util.Map;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.ISearchService;

public class SearchSvc implements ISearchService {

	private IRemoteManager remoteManager;
	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRemoteManager(IRemoteManager remoteManager) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, Long> searchSeriesLocal(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> searchSeriesRemote(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

}
