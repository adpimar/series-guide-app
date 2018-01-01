package impl.services;

import java.util.List;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.IGetAndListService;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class GetAndListSvc implements IGetAndListService {

	private IRemoteManager remoteManager;
	private ILocalManager localManager;

	@Override
	public void setLocalManager(ILocalManager localManager) {
		this.localManager = localManager;
	}

	@Override
	public void setRemoteManager(IRemoteManager remoteManager) {
		this.remoteManager = remoteManager;
	}

	@Override
	public List<String> listSeriesNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] listSerieSeasonsNamesOrderedByAired(long codSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] listSerieSeasonEpisodesNamesOrderedByAired(long codSerie, int airedSeason) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie getSerie(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season getSeason(long codSerie, int airedSeason) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode getEpisode(long codSerie, int airedSeason, int airedEpisode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie getRemoteSerie(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie getRemoteSeason(long idSerie, int seasonNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
