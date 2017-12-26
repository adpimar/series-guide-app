package resources;

import java.util.LinkedList;
import java.util.List;

import impl.Serie;

public enum FakeSeriesFactory {

	THE_OA_SIN_TEMPORADAS() {
		@Override
		public Serie getSerie() {
			Serie serie = new Serie();
			setSerieTheOA(serie);
			return serie;
		}
	},

	VIKINGS_SIN_TEMPORADAS() {
		@Override
		public Serie getSerie() {
			Serie serie = new Serie();
			setSerieVikings(serie);
			return serie;
		}
	};

	public abstract Serie getSerie();

	// ---------- SERIE: The OA -----------------------------------------------

	private static void setSerieTheOA(Serie serie) {
		List<String> generos = new LinkedList<>();
		generos.add("Drama");
		generos.add("Misterio");
		generos.add("Ciencia Ficción");

		serie.setId(321060);
		serie.setTitulo("The OA");
		serie.setEstado("Continúa");
		serie.setInicioEmision("16/12/2016");
		serie.setDiaEmision("Viernes");
		serie.setHorarioEmision("12:00 AM");
		serie.setCadena("Netflix");
		serie.setGeneros(generos);
		serie.setPuntuacion(8.1);
		serie.setTotalPuntuaciones(18);
		serie.setSinopsis("Having gone missing seven years ago, the previously "
				+ "blind Prairie Johnson returns home, now in her 20s with her "
				+ "sight restored. While many believe she is a miracle, others "
				+ "worry that she could be dangerous.");
	}
	
	// ---------- SERIE: Vikings ----------------------------------------------

	private static void setSerieVikings(Serie serie) {
		List<String> generos = new LinkedList<>();
		generos.add("Drama");
		generos.add("Acción");

		serie.setId(260449);
		serie.setTitulo("Vikings");
		serie.setEstado("Continúa");
		serie.setInicioEmision("03/03/2013");
		serie.setDiaEmision("Viernes");
		serie.setHorarioEmision("9:00 PM");
		serie.setCadena("History");
		serie.setGeneros(generos);
		serie.setPuntuacion(8.0);
		serie.setTotalPuntuaciones(441);
		serie.setSinopsis("Vikings follows the adventures of Ragnar Lothbrok the"
				+ " greatest hero of his age. The series tells the sagas of Ragnar's"
				+ " band of Viking brothers and his family, as he rises to become "
				+ "King of the Viking tribes. As well as being a fearless warrior, "
				+ "Ragnar embodies the Norse traditions of devotion to the gods, "
				+ "legend has it that he was a direct descendant of Odin, the god "
				+ "of war and warriors.");
	}

}
