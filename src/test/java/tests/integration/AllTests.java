package tests.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CheckEpisodeAsViewedTest.class,
	CheckSeasonAsViewedTest.class,
	CommentEpisodeViewedTest.class,
	DeleteSeasonTest.class,
	DeleteSerieTest.class,
	DownloadRemoteSeasonTest.class,
	DownloadRemoteSerieTest.class,
	GetEpisodeTest.class,
	GetSerieTest.class,
	ListSerieSeasonEpisodesNamesTest.class,
	ListSeriesNamesTest.class,
	SearchSeriesLocalTest.class,
	SearchSeriesRemoteTest.class,
	StoreRemoteSeasonTest.class,
	StoreRemoteSerieTest.class,
	UncheckEpisodeAsViewed.class,
	UncheckSeasonAsViewedTest.class,
	UpdateEpisodeOverviewTest.class,
	UpdateSerieOverviewTest.class
})
public class AllTests {

}
