package impl.services;

import java.util.List;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.IGetAndListService;
import impl.Season;

public class GetAndListSvc implements IGetAndListService {

	private IRemoteManager remoteManager;
	private ILocalManager localManager;
	
	public GetAndListSvc(IRemoteManager remoteManager, ILocalManager localManager) {
		this.remoteManager = remoteManager;
		this.localManager = localManager;
	}
	
	@Override
	public List<String> listSeries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInfoSerie(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRemoteSerie(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season getRemoteSeason(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
