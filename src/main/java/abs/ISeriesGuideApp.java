package abs;

import abs.services.ICheckAsViewedService;
import abs.services.IDeleteService;
import abs.services.IDownloadAndStoreService;
import abs.services.IGetAndListService;
import abs.services.ISearchService;
import abs.services.IUpdateOverviewService;

public interface ISeriesGuideApp extends 
	ICheckAsViewedService, 
	IDeleteService, 
	IDownloadAndStoreService,
	IGetAndListService, 
	ISearchService, 
	IUpdateOverviewService 
{

}
