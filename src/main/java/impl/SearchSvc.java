package impl;

import java.util.List;

import abs.SearchService;
import abs.TheTVDBManager;

public class SearchSvc implements SearchService {

	private TheTVDBManager theTVDBManager;
	
	public SearchSvc(TheTVDBManager theTVDBManager) {
		this.theTVDBManager = theTVDBManager;
	}
	
	@Override
	public List<String> searchSeries(String pattern) {
		return null;
	}

}
