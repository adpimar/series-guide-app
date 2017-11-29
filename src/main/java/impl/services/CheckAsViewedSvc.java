package impl.services;

import abs.ILocalManager;
import abs.services.ICheckAsViewedService;

public class CheckAsViewedSvc implements ICheckAsViewedService {

	private ILocalManager localManager;
	
	public CheckAsViewedSvc(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public void checkEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uncheckEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEpisodeComment(long idSerie, int seasonNumber, int episodeNumber, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkSeasonAsViewed(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uncheckSeasonAsViewed(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		
	}

}
