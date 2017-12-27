package impl.services;

import java.util.NoSuchElementException;

import abs.ILocalManager;
import abs.services.IUpdateOverviewService;
import impl.Serie;

public class UpdateOverviewSvc implements IUpdateOverviewService {

	private static final int LIMITE_CARACTERES_SINOPSIS = 500;
	
	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public Serie updateSerieOverview(long idSerie, String newOverview) {
		if (newOverview.length() > LIMITE_CARACTERES_SINOPSIS)
			throw new IllegalArgumentException("La nueva sinopsis excede los 500 caracteres.");
		
		Serie serie = localManager.getSerie(idSerie);
		
		if (serie == null)
			throw new NoSuchElementException("No existe la serie con id " + idSerie + " en la BDL.");
		
		serie.setSinopsis(newOverview);
		return serie;
	}

	@Override
	public void updateEpisodeOverview(long idSerie, int seasonNumber, int episodeNumber, String newOverview) {
		// TODO Auto-generated method stub

	}

}
