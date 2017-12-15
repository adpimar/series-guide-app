package impl;

import java.util.LinkedList;
import java.util.List;

public class Season {

	private int numeroTemporada;
	private String inicioEmision;
	private String estado;
	private String vista;

	private List<Episode> episodes;

	public Season() {
		episodes = new LinkedList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ SEASON " + numeroTemporada + " ]");
		sb.append("\nInicio de emisión  : " + inicioEmision);
		sb.append("\nEstado             : " + estado);
		sb.append("\nVista	            : " + vista);

		return sb.toString();
	}

	// ---------------------------- GETTERS && SETTERS -----------------------------

	public String getInicioEmision() {
		return inicioEmision;
	}

	public void setInicioEmision(String inicioEmision) {
		this.inicioEmision = inicioEmision;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getVista() {
		return vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

}
