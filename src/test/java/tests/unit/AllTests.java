package tests.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	CheckEpisodeAsViewedTest.class,
	CheckSeasonAsViewedTest.class,
	UncheckEpisodeAsViewed.class,
	UncheckSeasonAsViewedTest.class,
	CommentEpisodeViewedTest.class,

	DeleteSeasonTest.class,
	DeleteSerieTest.class,
	
	DownloadRemoteSerieTest.class,
	DownloadRemoteSeasonTest.class,
	StoreRemoteSerieTest.class,
	StoreRemoteSeasonTest.class,
	
	ListSeriesNamesTest.class,
	ListSerieSeasonEpisodesNamesTest.class,
	GetSerieTest.class,
	GetEpisodeTest.class,
		
	SearchSeriesLocalTest.class,
	SearchSeriesRemoteTest.class,

	UpdateSerieOverviewTest.class,
	UpdateEpisodeOverviewTest.class,
	
	//TheTVDBAdapterTest.class
	
	})
public class AllTests {

}
