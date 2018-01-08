package impl.managers.local;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abs.managers.ILocalManager;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;

public class SeriesDAO implements ILocalManager {

	@Override
	public List<Serie> listSeries() {
		List<Serie> misSeries = new ArrayList<Serie>();
	    MySQLConnect conexion = new MySQLConnect();
	     
	    try {
	    	PreparedStatement consulta = conexion.getConnection().prepareStatement("SELECT * FROM SERIES");
	    	ResultSet res = consulta.executeQuery();
	    	while(res.next()){
	    		Serie serie= new Serie();
	    		serie.setCodSerie(res.getLong("cod_serie"));
	    		serie.setSeriesName(res.getString("series_name"));
	    		serie.setStatus(res.getString("status"));
	    		serie.setFirstAired(res.getString("first_aired"));
	    		serie.setAirsDOW(res.getString("airs_dow"));
	    		serie.setAirsTime(res.getString("airs_time"));
	    		serie.setNetwork(res.getString("network"));
	    		serie.setGenres(res.getString("genres"));
	    		serie.setSiteRating(Double.parseDouble(res.getString("site_rating")));
	    		serie.setSiteRatingCount(Integer.parseInt(res.getString("site_rating_count")));
	    		serie.setOverview(res.getString("overview"));
	    		
	    		misSeries.add(serie);
	    	}
	    	res.close();
	    	consulta.close();
	    	conexion.disconnect();
	    	
	    } catch (Exception e) {
	    	System.out.println("Error: Clase SeriesDAO, método listSeries()");
	    	e.printStackTrace();
	    }
	    
	    return misSeries;
		
	}

	@Override
	public Serie getSerie(long codSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSerie(Serie serie) {
		 MySQLConnect conexion = new MySQLConnect();
	     
		 Statement stm= null;
			
		 String sql="UPDATE SERIES SET series_name='"+serie.getSeriesName()+
				 "', status='"+serie.getStatus()+
				 "', first_aired='"+serie.getFirstAired()+
				 "', airs_dow='"+serie.getAirsDOW()+
				 "', airs_time='"+serie.getAirsTime()+
				 "', network='"+serie.getNetwork()+
				 "', genres='"+serie.getGenres()+
				 "', site_rating='"+serie.getSiteRating()+
				 "', site_rating_count='"+serie.getSiteRatingCount()+
				 "', overview='"+serie.getOverview() + "'" +
				 " WHERE cod_serie="+serie.getCodSerie();
		 
		 try {
			 Connection connect =conexion.getConnection();
			 stm=connect.createStatement();
			 stm.execute(sql);
		 } catch (SQLException e) {
			 System.out.println("Error: Clase SeriesDAO, método updateSerie(serie)");
			 e.printStackTrace();
		 }		
	}

	@Override
	public void removeSerie(Serie serie) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm= null;
		
		String sql="DELETE FROM SERIES WHERE cod_serie="+serie.getCodSerie();
		try {
			Connection connect = conexion.getConnection();
			stm=connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método removeSerie(serie)");
			e.printStackTrace();
		}		

	}

	@Override
	public List<Season> listSeasons() {
		List<Season> misTemporadas = new ArrayList<Season>();
	    MySQLConnect conexion = new MySQLConnect();
	     
	    try {
	    	PreparedStatement consulta = conexion.getConnection().prepareStatement("SELECT * FROM TEMPORADAS");
	    	ResultSet res = consulta.executeQuery();
	    	while(res.next()){
	    		Season season= new Season();
	    		season.setCodSerie(res.getLong("cod_serie"));
	    		season.setCodSeason(res.getLong("cod_season"));
	    		season.setAiredSeason(Integer.parseInt("aired_season"));
	    		season.setFirstAired(res.getString("first_aired"));
	    		season.setTotalEpisodes(Integer.parseInt("total_episodes"));
	    		season.setSeen(Boolean.parseBoolean("seen"));
	    		
	    		misTemporadas.add(season);
	    	}
	    	res.close();
	    	consulta.close();
	    	conexion.disconnect();
	    	
	    } catch (Exception e) {
	    	System.out.println("Error: Clase SeriesDAO, método listSeasons()");
	    	e.printStackTrace();
	    }
	    
	    return misTemporadas;
	}

	@Override
	public Season getSeason(long codSeason) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSeason(Season season) {
		MySQLConnect conexion = new MySQLConnect();
	     
		Statement stm= null;
			
		String sql="UPDATE TEMPORADAS SET aired_season='"+season.getAiredSeason()+
				 "', first_aired='"+season.getFirstAired()+
				 "', total_episodes='"+season.getTotalEpisodes()+
				 "', seen='"+season.isSeen()+
				 " WHERE cod_season="+season.getCodSeason();
		 
		 try {
			 Connection connect =conexion.getConnection();
			 stm=connect.createStatement();
			 stm.execute(sql);
		 } catch (SQLException e) {
			 System.out.println("Error: Clase SeriesDAO, método updateSeason(season)");
			 e.printStackTrace();
		 }		

	}

	@Override
	public void removeSeason(Season season) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm= null;
		
		String sql="DELETE FROM TEMPORADAS WHERE cod_season="+season.getCodSeason();
		try {
			Connection connect = conexion.getConnection();
			stm=connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método removeSeason(season)");
			e.printStackTrace();
		}		

	}

	@Override
	public List<Episode> listEpisodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episode getEpisode(long codEpisode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEpisode(Episode episode) {
		MySQLConnect conexion = new MySQLConnect();
	     
		Statement stm= null;
			
		String sql="UPDATE EPISODIOS SET aired_season='"+episode.getAiredSeason()+
				 "', aired_episode='"+episode.getAiredEpisode()+
				 "', episode_name='"+episode.getEpisodeName()+
				 "', first_aired='"+episode.getFirstAired()+
				 "', overview='"+episode.getOverview()+
				 "', seen='"+episode.isSeen()+
				 "', comment='"+episode.getComment()+
				 " WHERE cod_episode="+episode.getCodEpisode();
		 
		 try {
			 Connection connect =conexion.getConnection();
			 stm=connect.createStatement();
			 stm.execute(sql);
		 } catch (SQLException e) {
			 System.out.println("Error: Clase SeriesDAO, método updateEpisode(episode)");
			 e.printStackTrace();
		 }	

	}

	@Override
	public void removeEpisode(Episode episode) {
		MySQLConnect conexion = new MySQLConnect();
		Statement stm= null;
		
		String sql="DELETE FROM EPISODIOS WHERE cod_episode="+episode.getCodEpisode();
		try {
			Connection connect = conexion.getConnection();
			stm=connect.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método removeEpisode(episode)");
			e.printStackTrace();
		}		

	}

	@Override
	public void addSerie(Serie serie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSeason(Season season) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEpisode(Episode episode) {
		Statement stm= null;
		MySQLConnect conexion = new MySQLConnect();
		
		String sql="INSERT INTO EPISODIOS values ('"+episode.getCodEpisode()+"','"+episode.getCodSeason()+"','"+episode.getAiredSeason()+"','"+episode.getAiredEpisode()+"','"+episode.getEpisodeName()+"','"+episode.getFirstAired()+"','"+episode.getOverview()+"','"+episode.isSeen()+"','"+episode.getComment()+"')";
		
		try {			
			Connection connect = conexion.getConnection();
			stm= connect.createStatement();
			stm.execute(sql);
			stm.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase SeriesDAO, método addEpisode(episode)");
			e.printStackTrace();
		}
		
	}

}
