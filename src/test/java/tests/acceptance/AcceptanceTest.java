package tests.acceptance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import abs.ISeriesGuideApp;
import impl.SeriesGuideApp;

public class AcceptanceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	protected static ISeriesGuideApp seriesGuideApp;
	
	@BeforeClass
	public static void inicia() {
		seriesGuideApp = new SeriesGuideApp();
	}

	@AfterClass
	public static void termina() {
		seriesGuideApp = null;
	}
	
}
