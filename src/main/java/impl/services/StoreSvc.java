package impl.services;

import abs.ILocalManager;
import abs.services.IStoreService;
import impl.Season;
import impl.Serie;

public class StoreSvc implements IStoreService {

	private ILocalManager localManager;
	
	public StoreSvc(ILocalManager localManager) {
		this.localManager = localManager;
	}
	
	@Override
	public void storeRemoteSerie(Serie remoteSerie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeRemoteSeason(Serie serie, Season remoteSeason) {
		// TODO Auto-generated method stub
		
	}

}
