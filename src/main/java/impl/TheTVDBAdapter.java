package impl;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import abs.IRemoteManager;
import impl.model.RemoteEpisode;
import impl.model.RemoteSearchSerie;
import impl.model.RemoteSerie;
import impl.model.Serie;

public class TheTVDBAdapter implements IRemoteManager {

	private static final String URI = "https://api.thetvdb.com";

	private static URI getBaseURI() {
		return UriBuilder.fromUri(URI).build();
	}
	
	// ------------------------------------------------------------------------

	private Client client;
	private JsonFactory jsonFactory;
	private Token token;

	public TheTVDBAdapter() {
		client = ClientBuilder.newClient();
		jsonFactory = new JsonFactory();
		this.setToken();
	}
	
	
	public static void main(String[] args) {
		
		new TheTVDBAdapter().metodo();
	}
	
	public void metodo() {
		
		// 305288
	
		Response response = client
				.target(getBaseURI())
				.path("series")
				.path("305288")
				.path("episodes")
				.path("query")
				.queryParam("airedSeason", "1")
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getToken())
				.header("Accept-Language", "en")
				.get();
			
		switch(response.getStatus()) {
			case 200: System.out.println("Ok!"); break;
			case 401: System.out.print("Not Authorized"); break;
			case 404: System.out.println("Not found"); break;
		}
		
		JsonParser jsonParser = null;
		try {
			jsonParser = jsonFactory.createParser(response.readEntity(String.class));
			
			while (!jsonParser.isClosed()) {
//				System.out.println(jsonParser.getCurrentName());
//				System.out.println(jsonParser.getValueAsString());			
				JsonToken jsonToken = jsonParser.nextToken();
				System.out.println(jsonToken + " -> " + jsonParser.getCurrentName() + " : " + jsonParser.getValueAsString());			
			}
			
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		response.close();
	}
		
	// ------------------------------------------------------------------------

	@Override
	public List<RemoteSearchSerie> searchRemoteSeries(String pattern) {
		Map<Long, String> theTVDBSeries = new TreeMap<>();

		Response response = client
				.target(getBaseURI())
				.path("search")
				.path("series")
				.queryParam("name", pattern)
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getToken())
				.header("Accept-Language", "en")
				.get();

		try {
			JsonParser jsonParser = jsonFactory.createParser(response.readEntity(String.class));
			
			String idSerie = null;
			String serieName = null;
			
			while (!jsonParser.isClosed()) {
				JsonToken jsonToken = jsonParser.nextToken();
				
				if (JsonToken.FIELD_NAME.equals(jsonToken)) {
					
					if (jsonParser.getCurrentName().equals("id")) {
						jsonParser.nextToken();
						idSerie = jsonParser.getValueAsString();
					}
					
					if (jsonParser.getCurrentName().equals("seriesName")) {
						jsonParser.nextToken();
						serieName = jsonParser.getValueAsString();
					}
					
					if (idSerie != null && serieName != null) {
						theTVDBSeries.put(Long.parseLong(idSerie), serieName);
						idSerie = null;
						serieName = null;
					}

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		response.close();

		return null;
	}
	
	
	public RemoteSerie getSerie(long codSerie) {
		Serie serie = new Serie();
		Map<String, String> theTVDBSeriefields = new HashMap<>();
		
		Response response = client
				.target(getBaseURI())
				.path("series")
				.path(Long.toString(codSerie))
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getToken())
				.header("Accept-Language", "en")
				.get();
		
		try {
			JsonParser jsonParser = jsonFactory.createParser(response.readEntity(String.class));

			while (!jsonParser.isClosed()) {
				JsonToken jsonToken = jsonParser.nextToken();

				if (JsonToken.FIELD_NAME.equals(jsonToken)) {
					String fieldName = jsonParser.getCurrentName();
					jsonParser.nextToken();					
					theTVDBSeriefields.put(fieldName, jsonParser.getValueAsString());
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		response.close();
		
		serie.setCodSerie(Long.parseLong(theTVDBSeriefields.get("id")));
		serie.setSeriesName(theTVDBSeriefields.get("seriesName"));
		serie.setStatus(theTVDBSeriefields.get("status"));
		serie.setFirstAired(theTVDBSeriefields.get("firstAired"));
		serie.setAirsDOW(theTVDBSeriefields.get("airsDayOfWeek"));
		serie.setAirsTime(theTVDBSeriefields.get("airsTime"));
		serie.setNetwork(theTVDBSeriefields.get("network"));
		serie.setGenres(null);
		serie.setSiteRating(Double.parseDouble(theTVDBSeriefields.get("siteRating")));
		serie.setSiteRatingCount(Integer.parseInt(theTVDBSeriefields.get("siteRatingCount")));
		serie.setOverview(theTVDBSeriefields.get("overview"));

		return null;
	}

	private void setToken() {
		Response response = client
				.target(getBaseURI())
				.path("login")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(new Login()));
		
		token = response.readEntity(Token.class);
		response.close();
	}
	
	// ------------------------------------------------------------------------


	@Override
	public RemoteSerie getRemoteSerie(long codSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RemoteEpisode[] getRemoteSeason(long codSerie, int airedSeason) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
