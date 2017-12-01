package abs;

import java.util.Map;

public interface IRemoteManager {

	Map<Long, String> searchSeries(String pattern);
	
}
