package at;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import abs.ILocalManager;
import abs.IRemoteManager;
import abs.services.ICheckAsViewedService;
import abs.services.IDeleteService;
import abs.services.IGetAndListService;
import abs.services.ISearchService;
import abs.services.IStoreService;
import abs.services.IUpdateOverviewService;
import impl.services.CheckAsViewedSvc;
import impl.services.DeleteSvc;
import impl.services.GetAndListSvc;
import impl.services.SearchSvc;
import impl.services.StoreSvc;
import impl.services.UpdateOverviewSvc;

public class AcceptanceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	protected static ICheckAsViewedService checkAsViewedService;
	protected static IDeleteService deleteService;
	protected static IGetAndListService getAndListService;
	protected static ISearchService searchService;
	protected static IStoreService storeService;
	protected static IUpdateOverviewService updateOverviewService;

	@BeforeClass
	public static void inicia() {
		checkAsViewedService = new CheckAsViewedSvc();
		deleteService = new DeleteSvc();
		getAndListService = new GetAndListSvc();
		searchService = new SearchSvc();
		storeService = new StoreSvc();
		updateOverviewService = new UpdateOverviewSvc();
	}

	@AfterClass
	public static void termina() {
		checkAsViewedService = null;
		deleteService = null;
		getAndListService = null;
		searchService = null;
		storeService = null;
		updateOverviewService = null;
	}

	public void setLocalManagers(ILocalManager localManager) {
		checkAsViewedService.setLocalManager(localManager);
		deleteService.setLocalManager(localManager);
		getAndListService.setLocalManager(localManager);
		searchService.setLocalManager(localManager);
		storeService.setLocalManager(localManager);
		updateOverviewService.setLocalManager(localManager);
	}
	
	public void setRemoteManagers(IRemoteManager remoteManager) {
		getAndListService.setRemoteManager(remoteManager);
		searchService.setRemoteManager(remoteManager);
	}
	
}
