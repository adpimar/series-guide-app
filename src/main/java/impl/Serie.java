package impl;

import java.util.LinkedList;
import java.util.List;

public class Serie {

	private long id;
	private String titulo;
	private String estado;
	private String inicioEmision;
	private String diaEmision;
	private String horarioEmision;
	private String cadena;
	private List<String> generos;
	private double puntuacion;
	private int totalPuntuaciones;
	private String sinopsis;

	private List<Season> seasons;
	
	public Serie() {
		generos = new LinkedList<>();
		seasons = new LinkedList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ SERIE ]");
		sb.append("\nId                 : " + id);
		sb.append("\nTítulo             : " + titulo);
		sb.append("\nEstado             : " + estado);
		sb.append("\nInicio de emisión  : " + inicioEmision);
		sb.append("\nDía de emisión     : " + diaEmision);
		sb.append("\nHorario de emisión : " + horarioEmision);
		sb.append("\nCadena             : " + cadena);
		sb.append("\nGéneros            : ");

		for (String genero : generos)
			sb.append(genero + " ");
		
		sb.append("\nPuntuación         : " + puntuacion);
		sb.append("\nTotal puntuaciones : " + totalPuntuaciones);
		sb.append("\nSinopsis           : " + sinopsis);
		
		return sb.toString();
	}
	
	// ------------------------------------------------------------------------

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEstado() {
		return estado;
	}

	public String getInicioEmision() {
		return inicioEmision;
	}

	public String getDiaEmision() {
		return diaEmision;
	}

	public String getHorarioEmision() {
		return horarioEmision;
	}

	public String getCadena() {
		return cadena;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public int getTotalPuntuaciones() {
		return totalPuntuaciones;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	// ------------------------------------------------------------------------

	public void setId(long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setInicioEmision(String inicioEmision) {
		this.inicioEmision = inicioEmision;
	}

	public void setDiaEmision(String diaEmision) {
		this.diaEmision = diaEmision;
	}

	public void setHorarioEmision(String horarioEmision) {
		this.horarioEmision = horarioEmision;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public void setGeneros(List<String> generos) {
		if (generos == null) return;
		this.generos = generos;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void setTotalPuntuaciones(int totalPuntuaciones) {
		this.totalPuntuaciones = totalPuntuaciones;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

}
