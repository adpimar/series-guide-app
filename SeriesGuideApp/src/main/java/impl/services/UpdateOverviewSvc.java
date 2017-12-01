package impl.services;

import abs.ILocalManager;
import abs.services.IUpdateOverviewService;

public class UpdateOverviewSvc implements IUpdateOverviewService {
	
	private ILocalManager localManager;
	
	public UpdateOverviewSvc(ILocalManager localManager) {
		this.localManager = localManager;
	}
	
	@Override
	public void updateSerieOverview(long idSerie, String newOverview) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEpisodeOverview(long idSerie, int seasonNumber, int episodeNumber, String newOverview) {
		// TODO Auto-generated method stub
		
	}

}
