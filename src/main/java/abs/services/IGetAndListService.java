package abs.services;

import java.util.List;

import impl.Season;

public interface IGetAndListService {

	List<String> listSeries();

	String getInfoSerie(long id);

	String getRemoteSerie(long idSerie, int seasonNumber);

	Season getRemoteSeason(long idSerie, int seasonNumber);

}
