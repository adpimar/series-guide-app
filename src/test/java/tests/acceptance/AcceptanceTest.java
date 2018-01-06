package tests.acceptance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import abs.managers.ILocalManager;
import abs.managers.IRemoteManager;
import abs.services.ICheckAsViewedService;
import abs.services.IDeleteService;
import abs.services.IDownloadAndStoreService;
import abs.services.IGetAndListService;
import abs.services.ISearchService;
import abs.services.IUpdateOverviewService;
import impl.services.CheckAsViewedSvc;
import impl.services.DeleteSvc;
import impl.services.DownloadAndStoreSvc;
import impl.services.GetAndListSvc;
import impl.services.SearchSvc;
import impl.services.UpdateOverviewSvc;

public class AcceptanceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	protected static ICheckAsViewedService checkAsViewedService;
	protected static IDeleteService deleteService;
	protected static IGetAndListService getAndListService;
	protected static ISearchService searchService;
	protected static IDownloadAndStoreService downloadAndStoreService;
	protected static IUpdateOverviewService updateOverviewService;

	@BeforeClass
	public static void inicia() {
		checkAsViewedService = new CheckAsViewedSvc();
		deleteService = new DeleteSvc();
		getAndListService = new GetAndListSvc();
		searchService = new SearchSvc();
		downloadAndStoreService = new DownloadAndStoreSvc();
		updateOverviewService = new UpdateOverviewSvc();
	}

	@AfterClass
	public static void termina() {
		checkAsViewedService = null;
		deleteService = null;
		getAndListService = null;
		searchService = null;
		downloadAndStoreService = null;
		updateOverviewService = null;
	}

	public void setLocalManagers(ILocalManager localManager) {
		checkAsViewedService.setLocalManager(localManager);
		deleteService.setLocalManager(localManager);
		getAndListService.setLocalManager(localManager);
		searchService.setLocalManager(localManager);
		downloadAndStoreService.setLocalManager(localManager);
		updateOverviewService.setLocalManager(localManager);
	}
	
	public void setRemoteManagers(IRemoteManager remoteManager) {
		downloadAndStoreService.setRemoteManager(remoteManager);
		searchService.setRemoteManager(remoteManager);
	}
	
}
