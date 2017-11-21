package impl;

import java.util.List;

import abs.ISearchService;
import abs.IRemoteManager;

public class SearchSvc implements ISearchService {

	private IRemoteManager theTVDBManager;
	
	public SearchSvc(IRemoteManager theTVDBManager) {
		this.theTVDBManager = theTVDBManager;
	}
	
	@Override
	public List<String> searchSeries(String pattern) {
		return null;
	}

}
