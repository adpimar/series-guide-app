package impl.services;

import abs.ILocalManager;
import abs.services.IDeleteService;

public class DeleteSvc implements IDeleteService {

	private ILocalManager localManager;
	
	public DeleteSvc(ILocalManager localManager) {
		this.localManager = localManager;
	}
	
	@Override
	public void deleteSeason(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSerie(long idSerie) {
		// TODO Auto-generated method stub
		
	}

}
