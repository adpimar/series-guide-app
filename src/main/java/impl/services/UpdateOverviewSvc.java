package impl.services;

import abs.ILocalManager;
import abs.services.IUpdateOverviewService;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.TooLongOverviewException;
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
	public Serie updateSerieOverview(long codSerie, String newOverview)
			throws NoSeriesStoredException, TooLongOverviewException {
		
		if (newOverview.length() > LIMITE_CARACTERES_SINOPSIS)
			throw new TooLongOverviewException();

		Serie serie = localManager.getSerie(codSerie);
		if (serie == null)
			throw new NoSeriesStoredException();
		serie.setOverview(newOverview);
		
		return serie;
	}

	@Override
	public Episode updateEpisodeOverview(long codSerie, int airedSeason, int airedEpisode, String newOverview) {
		// TODO Auto-generated method stub
		return null;
	}

}
