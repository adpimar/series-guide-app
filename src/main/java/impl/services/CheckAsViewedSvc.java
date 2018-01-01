package impl.services;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.ICheckAsViewedService;
import impl.model.Episode;
import impl.model.Season;

public class CheckAsViewedSvc implements ICheckAsViewedService {

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
	public Episode checkEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode uncheckEpisodeAsViewed(long idSerie, int seasonNumber, int episodeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode commentEpisodeViewed(long idSerie, int seasonNumber, int episodeNumber, String comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season checkSeasonAsViewed(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season uncheckSeasonAsViewed(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
