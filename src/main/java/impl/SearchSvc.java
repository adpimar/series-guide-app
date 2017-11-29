package impl;

import java.util.List;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.ISearchService;

public class SearchSvc implements ISearchService {

	private IRemoteManager remoteManager;
	private ILocalManager localManager;
	
	public SearchSvc(IRemoteManager remoteManager, ILocalManager localManager) {
		this.remoteManager = remoteManager;
		this.localManager = localManager;
	}
	
	@Override
	public List<String> searchSeriesLocal(String pattern) {
		return null;
	}
	
	@Override
	public List<String> searchSeriesRemote(String pattern) {
		return null;
	}

}
