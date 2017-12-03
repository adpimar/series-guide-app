package impl.services;

import java.util.List;
import java.util.Map;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.ISearchService;

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
	public Map<Long, String> searchSeriesRemote(String pattern) {

		Map<Long, String> listSeries = null;
				
		try {
			listSeries = remoteManager.searchSeries(pattern);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("REQUERIDO_NOMBRE_PARA_BÚSQUEDA_EN_EL_SERVIDOR_REMOTO");
		}
		
		return listSeries;

	}

}
