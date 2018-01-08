package impl;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import abs.ISeriesGuideApp;
import abs.managers.ILocalManager;
import abs.managers.IRemoteManager;
import impl.exceptions.NoEpisodesStoredException;
import impl.exceptions.NoKeywordsOnRemoteSearchException;
import impl.exceptions.NoSeasonsStoredException;
import impl.exceptions.NoSeriesStoredException;
import impl.exceptions.NotFoundSeasonOnRemoteServerException;
import impl.exceptions.NotFoundSerieOnRemoteServerException;
import impl.exceptions.SeasonAlreadyStoredException;
import impl.exceptions.SerieAlreadyStoredException;
import impl.exceptions.TooLongCommentException;
import impl.exceptions.TooLongOverviewException;
import impl.managers.remote.thetvdb.TheTVDBAdapter;
import impl.model.Episode;
import impl.model.Season;
import impl.model.Serie;
import resources.FakeBDL;

public class ConsoleInterface {

	private ISeriesGuideApp seriesGuideApp;
	private Scanner entradaEscaner;

	public static void main(String[] args) {	
		new ConsoleInterface();
		System.exit(0);
	}
	
	// ------------------------------------------------------------------------
	
	public ConsoleInterface() {
		
		System.out.println("======================================================");
		System.out.println("  SERIES GUIDE APP");
		System.out.println();
		System.out.println("  Asignatura:   EI1048 - Paradigmas de Programación");
		System.out.println("  Autores:      Adrián Picazo Marín");
		System.out.println("                Ángel Bayo Esteller");
		System.out.println("======================================================");
		
		System.out.println("\n"
				+ " La interfaz por consola que se presenta a continuación permite realizar todas las\n"
				+ " funcionalidades descritas en la documentación. Como pequeña guía se incluye en el\n"
				+ " apartado 'ayuda' un esquema conceptual de todas las funcionalidad y cómo llegar hasta\n"
				+ " ellas. Por lo intuitivo de la aplicación esperamos que sea suficiente para probar la\n"
				+ " aplicación.\n\n"
				+ " Indicar que no es posible que se lancen todas las excepciones contempladas en la\n"
				+ " documentación ya que la propia interfaz restringe un poco. Por ejemplo: no es posible\n"
				+ " borrar una serie que no exista en la BDL puesto que para acceder a esta funcionalidad\n"
				+ " previamente se ha accedido a la serie, por tanto siempre se le suministrará un código\n"
				+ " correcto.");
		
		inicia();

		menuPrincipal();

		cierra();
		
		System.out.println("\n¡Adiós!");
		
	}
	
	// ------------------------------------------------------------------------
	
	private void inicia() {
		seriesGuideApp = new SeriesGuideApp();
		seriesGuideApp.setLocalManager(getLocalManager());
		seriesGuideApp.setRemoteManager(getRemoteManager());
		entradaEscaner = new Scanner(System.in);
	}
	
	private void cierra() {
		entradaEscaner.close();
	}

	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	
	private void menuPrincipal() {

		int option;
		
		do {
			System.out.print("\n");
			System.out.print(" ===========================\n");
			System.out.print("  0. Terminar\n");
			System.out.print("  1. Listar series\n");
			System.out.print("  2. Visualizar serie\n");
			System.out.print("  3. Buscar series locales\n");
			System.out.print("  4. Buscar series remotas\n");
			System.out.print("  5. Descargar serie remota\n");
			System.out.print("  6. Ayuda\n");
			System.out.print(" ===========================\n");
			System.out.print("  Elija una opción: ");
			
			option = dameOpcion(0, 6);
			
			switch (option) {
				case 1: listarSeries(); break;
				case 2: visualizarSerie(); break;
				case 3: buscarSerieLocal(); break;
				case 4: buscarSerieRemota(); break;
				case 5: descargarSerieRemota(); break;
				case 6: ayuda(); break;
			}
						
		} while (option != 0);
		
	}
	
	private void listarSeries() {
		mostrarTitulo("Listar todas las series");
		Map<String, Long> series = seriesGuideApp.listSeriesNames();
		listarSeriesAuxiliar(series);
	}
	
	private void visualizarSerie() {
		mostrarTitulo("Visualizar una serie");	
		long codSerie = pideCodigoSerie();
		Serie serie = seriesGuideApp.getSerie(codSerie);	
		imprimeObjeto(serie);
		menuSerie(serie);
	}
	
	private void buscarSerieLocal() {
		mostrarTitulo("Búsqueda de series en la BDL");
		String pattern = pidePatronBusqueda();
		try {
			Map<String, Long> series = seriesGuideApp.searchSeriesLocal(pattern);
			System.out.println();
			listarSeriesAuxiliar(series);
		} catch (NoSeriesStoredException e) {
			imprimeFeedback("ERROR: No hay series almacenadas en la BDL.");
		} catch (NoKeywordsOnRemoteSearchException e) {
			imprimeFeedback("ERROR: No se han introducido palabras válidas.");
		}
	}
	
	private void buscarSerieRemota() {
		mostrarTitulo("Búsqueda de series en el servidor remoto");
		String pattern = pidePatronBusqueda();
		try {
			Map<String, Long> series = seriesGuideApp.searchSeriesRemote(pattern);
			System.out.println();
			listarSeriesAuxiliar(series);
		} catch (NotFoundSerieOnRemoteServerException e) {
			imprimeFeedback("ERROR: No se han encontrado coincidencias en el servidor remoto.");
		} catch (NoKeywordsOnRemoteSearchException e) {
			imprimeFeedback("ERROR: No se han introducido palabras válidas.");
		}
	}
	
	private void descargarSerieRemota() {
		mostrarTitulo("Descargar una serie remota");
		long codSerie = pideCodigoSerie();
		try {
			Serie serie = seriesGuideApp.downloadRemoteSerie(codSerie);
			imprimeFeedback("Descargada la serie " + serie.getSeriesName());
			imprimeObjeto(serie);
			if (pregunta("¿Quiere almacenar la serie?"))
				almacenarSerieRemota(serie);
		} catch (NotFoundSerieOnRemoteServerException e) {
			imprimeFeedback("ERROR: La serie no se encuentra en el servidor remoto.");
		}
	}
	
	private void almacenarSerieRemota(Serie remoteSerie) {
		mostrarTitulo("Almacenar una serie remota descargada");
		try {
			seriesGuideApp.storeRemoteSerie(remoteSerie);
			imprimeFeedback("Serie almacenada en la BDL.");
		} catch (SerieAlreadyStoredException e) {
			imprimeFeedback("ERROR: La serie ya está almacenada en la BDL.");
		}
	}
	
	private void ayuda() {
		mostrarTitulo("Esquema de funcionalidades");	
		System.out.println("    -> Terminar");
		System.out.println("    -> Listar series");
		System.out.println("    -> Visualizar serie");
		System.out.println("         |-> Listar episodios de una temporada");
		System.out.println("         |-> Modificar sinopsis");
		System.out.println("         |-> Visualizar episodio");
		System.out.println("               |-> Modificar sinopsis");
		System.out.println("               |-> Marcar episodio visto");
		System.out.println("                     |-> Comentar");
		System.out.println("    	       |-> Marcar episodio no visto");
		System.out.println("         |-> Marcar temporada vista");
		System.out.println("         |-> Marcar temporada no vista");
		System.out.println("         |-> Descargar temporada remota");
		System.out.println("    	       |-> Almacenar");
		System.out.println("         |-> Borrar temporada");
		System.out.println("         |-> Borrar serie");
		System.out.println("    -> Buscar series locales");
		System.out.println("    -> Buscar series remotas");
		System.out.println("    -> Descargar serie remota");
		System.out.println("         |-> Almacenar");
		System.out.println("    -> Ayuda");
	}

	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	
	private void menuSerie(Serie serie) {

		int option;
		
		do {
			
			System.out.print("\n");
			System.out.print(" -----------------------------------------\n");
			System.out.print("  0. Volver\n");
			System.out.print("  1. Listar episodios de una temporada\n");
			System.out.print("  2. Modificar sinopsis\n");
			System.out.print("  3. Visualizar episodio\n");
			System.out.print("  4. Marcar temporada vista\n");
			System.out.print("  5. Marcar temporada no vista\n");
			System.out.print("  6. Descargar temporada remota\n");
			System.out.print("  7. Borrar temporada\n");
			System.out.print("  8. Borrar serie\n");
			System.out.print(" -----------------------------------------\n");
			System.out.print("  Elija una opción: ");

			option = dameOpcion(0, 8);
			
			switch (option) {
				case 1: listarTemporadaEpisodios(serie); break;
				case 2: modificarSinopsisSerie(serie); break;
				case 3: visualizarEpisodio(serie); break;
				case 4: marcarTemporadaVista(serie); break;
				case 5: marcarTemporadaNoVista(serie); break;
				case 6: descargarTemporadaRemota(serie); break;
				case 7: borrarTemporada(serie); break;
				case 8: borrarSerie(serie); option = 0; break;
			}
			
		} while (option != 0);
		
	}
	
	private void listarTemporadaEpisodios(Serie serie) {
		mostrarTitulo("Listar episodios de una temporada");	
		int airedSeason = pideNumeroTemporada();	
		try {
			String[] episodes = seriesGuideApp.listSerieSeasonsEpisodesNames(serie.getCodSerie(), airedSeason);
			System.out.print("\n         Temporada " + airedSeason);
			System.out.print("\n       -----------------------------------\n");
			for (int i = 0; i < episodes.length; i++)
				System.out.print(String.format("%10d - %s%n", i+1, episodes[i]));
			System.out.print("\n");
			imprimeFeedback("NOTA: Si detecta la ausencia de episodios en el listado (null) puede que se deba a un error en la descarga. En ese caso borre la temporada y descárguela de nuevo.");
		} catch (NoSeasonsStoredException e) {
			imprimeFeedback("ERROR: La temporada " + airedSeason + " no está almacenada.");
		}
	}
	
	private void modificarSinopsisSerie(Serie serie) {
		mostrarTitulo("Modificar la sinopsis de la serie");
		String newOverview = pideNuevaSinopsis();
		try {
			Serie newSerie = seriesGuideApp.updateSerieOverview(serie.getCodSerie(), newOverview);
			imprimeFeedback("La serie se ha actualizado con una nueva sinopsis.\n\n");
			imprimeObjeto(newSerie);
		} catch (TooLongOverviewException e) {
			imprimeFeedback("ERROR: La nueva sinopsis excede de los 500 caracteres.");
		}
	}
	
	private void visualizarEpisodio(Serie serie) {
		mostrarTitulo("Visualizar un episodio");	
		int airedSeason = pideNumeroTemporada();
		int airedEpisode = pideNumeroEpisodio();
		try {
			Episode episode = seriesGuideApp.getEpisode(serie.getCodSerie(), airedSeason, airedEpisode);
			imprimeObjeto(episode);
			menuEpisodio(serie.getSeasonByAired(airedSeason), episode);
		} catch (NoSeasonsStoredException e) {
			imprimeFeedback("ERROR: La temporada " + airedSeason + " no está almacenada.");
		} catch (NoEpisodesStoredException e) {
			imprimeFeedback("ERROR: El episodio " + airedEpisode + " no está almacenado en la temporada. Borre la temporada y descárguela de nuevo.");
		}
	}
	
	private void marcarTemporadaVista(Serie serie) {
		mostrarTitulo("Marcar como vista una temporada");
		int airedSeason = pideNumeroTemporada();
		try {
			seriesGuideApp.checkSeasonAsViewed(serie.getCodSerie(), airedSeason);
			imprimeFeedback("Todos los episodios de la temporada " + airedSeason + " se han marcado como vistos.");
		} catch (NoSeasonsStoredException e) {
			imprimeFeedback("ERROR: La temporada " + airedSeason + " no está almacenada.");
		} catch (NoEpisodesStoredException e) {
			imprimeFeedback("ERROR: La temporada " + airedSeason + " no tiene todos los episodios. Borre la temporada y descárguela de nuevo.");
		}
	}
	
	private void marcarTemporadaNoVista(Serie serie) {
		mostrarTitulo("Desmarcar como vista una temporada");
		int airedSeason = pideNumeroTemporada();
		try {
			seriesGuideApp.uncheckSeasonAsViewed(serie.getCodSerie(), airedSeason);
			imprimeFeedback("Todos los episodios de la temporada " + airedSeason + " se han desmarcado como vistos.");
		} catch (NoSeasonsStoredException e) {
			imprimeFeedback("ERROR: La temporada " + airedSeason + " no está almacenada.");
		} catch (NoEpisodesStoredException e) {
			imprimeFeedback("ERROR: La temporada " + airedSeason + " no tiene todos los episodios. Borre la temporada y descárguela de nuevo.");
		}
	}
	
	private void descargarTemporadaRemota(Serie serie) {
		mostrarTitulo("Descargar una temporada remota");
		int airedSeason = pideNumeroTemporada();
		try {
			Season season = seriesGuideApp.downloadRemoteSeason(serie.getCodSerie(), airedSeason);
			imprimeFeedback("Descargada la temporada " + airedSeason);
			System.out.print("\n         Temporada " + airedSeason);
			System.out.print("\n       -----------------------------------\n");
			for (Episode episode : season.getEpisodes())
				imprimeObjeto(episode);
			if (pregunta("¿Quiere almacenar la temporada?"))
				almacenarTemporadaRemota(season);
		} catch (NotFoundSeasonOnRemoteServerException e) {
			imprimeFeedback("ERROR: La temporada no se encuentra en el servidor remoto.");
		}
	}
	
	private void almacenarTemporadaRemota(Season remoteSeason) {
		mostrarTitulo("Almacenar una temporada remota descargada");
		try {
			seriesGuideApp.storeRemoteSeason(remoteSeason);
			imprimeFeedback("Temporada almacenada en la BDL.");
		} catch (SeasonAlreadyStoredException e) {
			imprimeFeedback("ERROR: La temporada ya está almacenada en la BDL.");
		}
	}
	
	private void borrarTemporada(Serie serie) {
		mostrarTitulo("Borrar una temporada");
		int airedSeason = pideNumeroTemporada();
		try {
			seriesGuideApp.deleteSeason(serie.getCodSerie(), airedSeason);
			imprimeFeedback("Temporada " + airedSeason + " borrada.");
		} catch (NoSeasonsStoredException e) {
			imprimeFeedback("ERROR: La temporada " + airedSeason + " no está almacenada.");
		}
	}
	
	private void borrarSerie(Serie serie) {
		mostrarTitulo("Borrar la serie");
		seriesGuideApp.deleteSerie(serie.getCodSerie());
		imprimeFeedback("Serie '" + serie.getSeriesName() + "' borrada.");
	}
	
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	
	private void menuEpisodio(Season season, Episode episodio) {
		
		int option;
		
		do {
			
			System.out.print("\n");
			System.out.print(" -----------------------------------------\n");
			System.out.print("  0. Volver\n");
			System.out.print("  1. Modificar sinopsis\n");
			System.out.print("  2. Marcar episodio visto\n");
			System.out.print("  3. Marcar episodio no visto\n");
			System.out.print(" -----------------------------------------\n");
			System.out.print("  Elija una opción: ");

			option = dameOpcion(0, 3);
			
			switch (option) {
				case 1: modificarSinopsisEpisodio(season, episodio); break;
				case 2: marcarEpisodioVisto(season, episodio); break;
				case 3: marcarEpisodioNoVisto(season, episodio); break;
			}
			
		} while (option != 0);
		
	}
	
	private void modificarSinopsisEpisodio(Season season, Episode episode) {
		mostrarTitulo("Modificar la sinopsis del episodio (límite 500 caract.)");
		String newOverview = pideNuevaSinopsis();
		try {
			Episode newEpisode = seriesGuideApp.updateEpisodeOverview(season.getCodSerie(), season.getAiredSeason(), episode.getAiredEpisode(), newOverview);
			imprimeFeedback("El episodio se ha actualizado con una nueva sinopsis.\n\n");
			imprimeObjeto(newEpisode);
		} catch (TooLongOverviewException e) {
			imprimeFeedback("ERROR: La nueva sinopsis excede de los 500 caracteres.");
		}
	}
	
	private void marcarEpisodioVisto(Season season, Episode episode) {
		mostrarTitulo("Marcar como visto el episodio");
		Episode newEpisode = seriesGuideApp.checkEpisodeAsViewed(season.getCodSerie(), season.getAiredSeason(), episode.getAiredEpisode());
		imprimeFeedback("El episodio se ha marcado como visto.");
		imprimeObjeto(newEpisode);
		if (pregunta("¿Quiere comentar el episodio?"))
			introducirComentario(season, newEpisode);
	}
	
	private void marcarEpisodioNoVisto(Season season, Episode episode) {
		mostrarTitulo("Desmarcar como visto el episodio");
		Episode newEpisode = seriesGuideApp.uncheckEpisodeAsViewed(season.getCodSerie(), season.getAiredSeason(), episode.getAiredEpisode());
		imprimeFeedback("El episodio se ha desmarcado como visto.");
		imprimeObjeto(newEpisode);
	}
	
	private void introducirComentario(Season season, Episode episode) {
		mostrarTitulo("Introducir un comentario en un episodio visto (límite 150 caract.)");
		String comment = pideComentario();
		try {
			Episode newEpisode = seriesGuideApp.commentEpisodeViewed(season.getCodSerie(), season.getAiredSeason(), episode.getAiredEpisode(), comment);
			imprimeFeedback("El episodio ha sido comentado.");
			imprimeObjeto(newEpisode);
		} catch (TooLongCommentException e) {
			imprimeFeedback("ERROR: El comentario excede de los 150 caracteres.");
		}
	}

	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	
	private ILocalManager getLocalManager() {	
		String filename = "src" 
				+ File.separator + "test" 
				+ File.separator + "resources" 
				+ File.separator + "interface" 
				+ File.separator + "bdl.txt";	
		return new FakeBDL(filename);
	}
	
	private IRemoteManager getRemoteManager() {
		return new TheTVDBAdapter();
	}
	
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	
	private void mostrarTitulo(String cadena) {
		System.out.print("\n");
		System.out.print("    " + cadena + "\n");
		System.out.print("  ------------------------------------------------------\n");
	}
	
	private int dameOpcion(int limitePorAbajo, int limitePorArriba) {
		int opcion;
		do {
			opcion = pideOpcionMenu();	
			if (opcion < limitePorAbajo || opcion > limitePorArriba)
				System.out.print("  ¡Opción incorrecta! Elija una opción: ");
		} while(opcion < limitePorAbajo || opcion > limitePorArriba);
		return opcion;
	}
	
	private void imprimeFeedback(String feedback) {
		System.out.print("      " + feedback + "\n");
	}
	
	private void imprimeObjeto(Object o) {
		System.out.println();
		System.out.println(o);
	}
	
	private void listarSeriesAuxiliar(Map<String, Long> series) {
		for (Entry<String, Long> entry : series.entrySet())
			System.out.print(String.format("%10d - %s%n", entry.getValue(), entry.getKey()));	
	}
	
	
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	
	private long pideCodigoSerie() {
		System.out.print("      Introduzca el código de la serie: ");
		long entrada = entradaEscaner.nextLong();
		entradaEscaner.nextLine();
		return entrada;
	}
	
	private int pideNumeroTemporada() {
		System.out.print("      Introduzca el número de la temporada: ");
		int entrada = entradaEscaner.nextInt();
		entradaEscaner.nextLine();
		return entrada;
	}
	
	private int pideNumeroEpisodio() {
		System.out.print("      Introduzca el número del episodio: ");
		int entrada = entradaEscaner.nextInt();
		entradaEscaner.nextLine();
		return entrada;
	}
	
	private String pideNuevaSinopsis() {
		System.out.print("      Introduzca la nueva sinopsis: ");
		return entradaEscaner.nextLine();
	}
	
	private String pideComentario() {
		System.out.print("      Introduzca el comentario: ");
		return entradaEscaner.nextLine();
	}
	
	private int pideOpcionMenu() {
		int entrada = entradaEscaner.nextInt();
		entradaEscaner.nextLine();
		return entrada;
	}
	
	private String pidePatronBusqueda() {
		System.out.print("      Introduzca un patrón de búsqueda (palabras clave): ");
		return entradaEscaner.nextLine();
	}
	
	private boolean pregunta(String pregunta) {
		System.out.println();
		char opcion;
		do {
			System.out.print("      " + pregunta + " (s/n): ");
			opcion = entradaEscaner.next().toLowerCase().charAt(0);	
		} while(opcion != 's' && opcion != 'n');
		entradaEscaner.nextLine();
		return opcion == 's';
	}
	
}
