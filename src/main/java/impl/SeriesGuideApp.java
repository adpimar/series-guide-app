package impl;

import java.util.Map;

import abs.ISeriesGuideApp;
import abs.managers.ILocalManager;
import abs.managers.IRemoteManager;
import abs.services.ICheckAsViewedService;
import abs.services.IDeleteService;
import abs.services.IDownloadAndStoreService;
import abs.services.IGetAndListService;
import abs.services.ISearchService;
import abs.services.IUpdateOverviewService;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;
import impl.services.CheckAsViewedSvc;
import impl.services.DeleteSvc;
import impl.services.DownloadAndStoreSvc;
import impl.services.GetAndListSvc;
import impl.services.SearchSvc;
import impl.services.UpdateOverviewSvc;

public class SeriesGuideApp implements ISeriesGuideApp {
	
	private ICheckAsViewedService checkAsViewedService;
	private IDeleteService deleteService;
	private IGetAndListService getAndListService;
	private ISearchService searchService;
	private IDownloadAndStoreService downloadAndStoreService;
	private IUpdateOverviewService updateOverviewService;
	
	public SeriesGuideApp() {
		checkAsViewedService = new CheckAsViewedSvc();
		deleteService = new DeleteSvc();
		getAndListService = new GetAndListSvc();
		searchService = new SearchSvc();
		downloadAndStoreService = new DownloadAndStoreSvc();
		updateOverviewService = new UpdateOverviewSvc();
	}

	// ------------------------------------------------------------------------
	
	@Override
	public void setLocalManager(ILocalManager localManager) {
		checkAsViewedService.setLocalManager(localManager);
		deleteService.setLocalManager(localManager);
		getAndListService.setLocalManager(localManager);
		searchService.setLocalManager(localManager);
		downloadAndStoreService.setLocalManager(localManager);
		updateOverviewService.setLocalManager(localManager);
	}

	@Override
	public void setRemoteManager(IRemoteManager remoteManager) {
		downloadAndStoreService.setRemoteManager(remoteManager);
		searchService.setRemoteManager(remoteManager);
	}

	// ------------------------------------------------------------------------
	
	@Override
	public Episode checkEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode) {
		return checkAsViewedService.checkEpisodeAsViewed(codSerie, airedSeason, airedEpisode);
	}

	@Override
	public Episode uncheckEpisodeAsViewed(long codSerie, int airedSeason, int airedEpisode) {
		return checkAsViewedService.uncheckEpisodeAsViewed(codSerie, airedSeason, airedEpisode);
	}

	@Override
	public Episode commentEpisodeViewed(long codSerie, int airedSeason, int airedEpisode, String comment) {
		return checkAsViewedService.commentEpisodeViewed(codSerie, airedSeason, airedEpisode, comment);
	}

	@Override
	public Season checkSeasonAsViewed(long codSerie, int airedSeason) {
		return checkAsViewedService.checkSeasonAsViewed(codSerie, airedSeason);
	}

	@Override
	public Season uncheckSeasonAsViewed(long codSerie, int airedSeason) {
		return checkAsViewedService.uncheckSeasonAsViewed(codSerie, airedSeason);
	}

	@Override
	public void deleteSeason(long codSerie, int airedSeason) {
		deleteService.deleteSeason(codSerie, airedSeason);
	}
	
	@Override
	public void deleteSerie(long codSerie) {
		deleteService.deleteSerie(codSerie);
	}

	@Override
	public Serie downloadRemoteSerie(long codSerie) {
		return downloadAndStoreService.downloadRemoteSerie(codSerie);
	}

	@Override
	public Season downloadRemoteSeason(long codSerie, int airedSeason) {
		return downloadAndStoreService.downloadRemoteSeason(codSerie, airedSeason);
	}

	@Override
	public void storeRemoteSerie(Serie remoteSerie) {
		downloadAndStoreService.storeRemoteSerie(remoteSerie);
	}

	@Override
	public void storeRemoteSeason(Season remoteSeason) {
		downloadAndStoreService.storeRemoteSeason(remoteSeason);
	}

	@Override
	public Map<String, Long> listSeriesNames() {
		return getAndListService.listSeriesNames();
	}

	@Override
	public String[] listSerieSeasonsEpisodesNames(long codSerie, int airedSeason) {
		return getAndListService.listSerieSeasonsEpisodesNames(codSerie, airedSeason);
	}

	@Override
	public Serie getSerie(long codSerie) {
		return getAndListService.getSerie(codSerie);
	}

	@Override
	public Season getSeason(long codSerie, int airedSeason) {
		return getAndListService.getSeason(codSerie, airedSeason);
	}

	@Override
	public Episode getEpisode(long codSerie, int airedSeason, int airedEpisode) {
		return getAndListService.getEpisode(codSerie, airedSeason, airedEpisode);
	}

	@Override
	public Map<String, Long> searchSeriesLocal(String pattern) {
		return searchService.searchSeriesLocal(pattern);
	}

	@Override
	public Map<String, Long> searchSeriesRemote(String pattern) {
		return searchService.searchSeriesRemote(pattern);
	}

	@Override
	public Serie updateSerieOverview(long codSerie, String newOverview) {
		return updateOverviewService.updateSerieOverview(codSerie, newOverview);
	}

	@Override
	public Episode updateEpisodeOverview(long codSerie, int airedSeason, int airedEpisode, String newOverview) {
		return updateOverviewService.updateEpisodeOverview(codSerie, airedSeason, airedEpisode, newOverview);
	}	
	
}