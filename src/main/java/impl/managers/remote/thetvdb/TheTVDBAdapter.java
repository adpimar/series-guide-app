package impl.managers.remote.thetvdb;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import abs.managers.IRemoteManager;
import impl.exceptions.ErrorOnRemoteServerException;
import impl.exceptions.NoOperationParametersOnRemoteServerException;
import impl.exceptions.NotAuthorizedOnRemoteServerException;
import impl.exceptions.NotFoundOnRemoteServerException;
import impl.exceptions.TimeoutOnRemoteServerException;
import impl.managers.remote.thetvdb.jsonschemas.GetSearchSeries;
import impl.managers.remote.thetvdb.jsonschemas.GetSerieId;
import impl.managers.remote.thetvdb.jsonschemas.GetSeriesIdEpisodesQuery;
import impl.managers.remote.thetvdb.jsonschemas.Login;
import impl.managers.remote.thetvdb.jsonschemas.QueryEpisode;
import impl.managers.remote.thetvdb.jsonschemas.SearchSerie;
import impl.managers.remote.thetvdb.jsonschemas.SpecificSerie;
import impl.managers.remote.thetvdb.jsonschemas.Token;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class TheTVDBAdapter implements IRemoteManager {

	private static final String APIKEY = "A3FCE8D7D14CB414";
	private static final String USERKEY = "4266C50AAC342851";
	private static final String USERNAME = "adpimar";
	
	private static final String URI = "https://api.thetvdb.com";

	private static URI getBaseURI() {
		return UriBuilder.fromUri(URI).build();
	}
	
	// ------------------------------------------------------------------------

	private Client client;
	private Token token;

	public TheTVDBAdapter() {
		client = ClientBuilder.newClient();
		setToken(APIKEY, USERKEY, USERNAME);
	}
	
	public TheTVDBAdapter(String apikey, String userkey, String username) {
		client = ClientBuilder.newClient();
		setToken(apikey, userkey, username);
	}
	
	// ---------- IRemoteManager ----------------------------------------------

	@Override
	public List<Serie> searchRemoteSeries(String pattern) {

		// Dame la respuesta REST
		Response response = client
				.target(getBaseURI())
				.path("search")
				.path("series")
				.queryParam("name", pattern)
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getToken())
				.header("Accept-Language", "en")
				.get();
		
		// Comprueba si la respuesta es ok
		checkStatus(response.getStatus());
		
		// Dame el contenido en json
		GetSearchSeries jsonResponse = response.readEntity(GetSearchSeries.class);
		
		// Cierra la respuesta
		response.close();
		
		// Crea la lista de series
		List<Serie> series = new LinkedList<>();
		for (SearchSerie ss : jsonResponse.getData())
			series.add(toSerieParser(ss));
			
		return series;
	}
	
	
	@Override
	public Serie getRemoteSerie(long codSerie) {
		
		// Dame la respuesta REST
		Response response = client
				.target(getBaseURI())
				.path("series")
				.path(Long.toString(codSerie))
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getToken())
				.header("Accept-Language", "en")
				.get();
		
		// Comprueba si la respuesta es ok
		checkStatus(response.getStatus());
		
		// Dame el contenido en json
		GetSerieId jsonResponse = response.readEntity(GetSerieId.class);
		
		// Cierra la respuesta
		response.close();
		
		// Crea la serie
		Serie serie = toSerieParser(jsonResponse.getData());

		return serie;
	}
	
	@Override
	public Season getRemoteSeason(long codSerie, int airedSeason) {
		
		// Dame la respuesta REST
		Response response = client
				.target(getBaseURI())
				.path("series")
				.path("" + codSerie)
				.path("episodes")
				.path("query")
				.queryParam("airedSeason", "" + airedSeason)
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getToken())
				.header("Accept-Language", "en")
				.get();
		
		// Comprueba si la respuesta es ok
		checkStatus(response.getStatus());
		
		// Dame el contenido en json
		GetSeriesIdEpisodesQuery jsonResponse = response.readEntity(GetSeriesIdEpisodesQuery.class);
		
		// Cierra la respuesta
		response.close();
		
		// Crea la temporada
		Episode[] episodes = new Episode[jsonResponse.getData().size()];
		for (QueryEpisode qe : jsonResponse.getData())
			episodes[qe.getAiredEpisodeNumber() - 1] = toEpisodeParser(qe);
				
		Season season = new Season();	
		season.setCodSerie(codSerie);
		season.setCodSeason(episodes[0].getCodSeason());
		season.setAiredSeason(airedSeason);
		season.setFirstAired(episodes[0].getFirstAired());
		season.setTotalEpisodes(episodes.length);
		season.setSeen(false);
		season.setEpisodes(episodes);
		
		return season;
	}
	
	// ---------- Token -------------------------------------------------------

	private void setToken(String apikey, String userkey, String username) {
		
		Login login = new Login();
		
		login.setApikey(apikey);
		login.setUserkey(userkey);
		login.setUsername(username);
		
		Response response = client
				.target(getBaseURI())
				.path("login")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(login));
		
		checkStatus(response.getStatus());
		
		token = response.readEntity(Token.class);
		response.close();
	}
	
	// ---------- Status -------------------------------------------------------
	
	private void checkStatus(int status) {
		if (status != Status.OK.getStatusCode()) {
			if (status == Status.UNAUTHORIZED.getStatusCode())
				throw new NotAuthorizedOnRemoteServerException();
			if (status == Status.METHOD_NOT_ALLOWED.getStatusCode())
				throw new NoOperationParametersOnRemoteServerException();
			if (status == Status.NOT_FOUND.getStatusCode())
				throw new NotFoundOnRemoteServerException();
			if (status == Status.REQUEST_TIMEOUT.getStatusCode())
				throw new TimeoutOnRemoteServerException();
			throw new ErrorOnRemoteServerException();
		}
	}
	
	// ---------- Parsers -----------------------------------------------------

	private Serie toSerieParser(SearchSerie searchSerie) {
		
		Serie serie = new Serie();
		
		serie.setCodSerie(searchSerie.getId());
		serie.setSeriesName(searchSerie.getSeriesName());
		serie.setStatus(searchSerie.getStatus());
		serie.setFirstAired(searchSerie.getFirstAired());
		serie.setAirsDOW(null);
		serie.setAirsTime(null);
		serie.setNetwork(searchSerie.getNetwork());
		serie.setGenres(null);
		serie.setSiteRating(-1);
		serie.setSiteRatingCount(-1);
		serie.setOverview(searchSerie.getOverview());

		return serie;
	}
	
	private Serie toSerieParser(SpecificSerie specificSerie) {	
		
		Serie serie = new Serie();
		
		serie.setCodSerie(specificSerie.getId());
		serie.setSeriesName(specificSerie.getSeriesName());
		serie.setStatus(specificSerie.getStatus());
		serie.setFirstAired(specificSerie.getFirstAired());
		serie.setAirsDOW(specificSerie.getAirsDayOfWeek());
		serie.setNetwork(specificSerie.getNetwork());
		serie.setSiteRating(specificSerie.getSiteRating());
		serie.setSiteRatingCount(specificSerie.getSiteRatingCount());
		serie.setOverview(specificSerie.getOverview());
		
		String airsTime = specificSerie.getAirsTime();
		airsTime = airsTime.length() == 7 ? "0" + airsTime : airsTime;
		serie.setAirsTime(airsTime);
		
		List<String> genres = specificSerie.getGenre();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < genres.size() - 1; i++)
			sb.append(genres.get(i) + ", ");
		sb.append(genres.get(genres.size() - 1));
		serie.setGenres(sb.toString());
		
		return serie;	
	}
	
	private Episode toEpisodeParser(QueryEpisode queryEpisode) {
		
		Episode episode = new Episode();
		
		episode.setCodEpisode(queryEpisode.getId());
		episode.setCodSeason(queryEpisode.getAiredSeasonID());
		episode.setAiredSeason(queryEpisode.getAiredSeason());
		episode.setAiredEpisode(queryEpisode.getAiredEpisodeNumber());
		episode.setEpisodeName(queryEpisode.getEpisodeName());
		episode.setFirstAired(queryEpisode.getFirstAired());
		episode.setOverview(queryEpisode.getOverview());
		episode.setSeen(false);
		episode.setComment(null);
		
		return episode;
	}
	
}
