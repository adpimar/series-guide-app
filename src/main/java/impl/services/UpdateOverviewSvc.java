package impl.services;

import abs.ILocalManager;
import abs.services.IUpdateOverviewService;
import impl.model.Episode;
import impl.model.Serie;

public class UpdateOverviewSvc implements IUpdateOverviewService {

	private static final int LIMITE_CARACTERES_SINOPSIS = 500;

	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public Serie updateSerieOverview(long idSerie, String newOverview) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode updateEpisodeOverview(long idSerie, int seasonNumber, int episodeNumber, String newOverview) {
		// TODO Auto-generated method stub
		return null;
	}

}
