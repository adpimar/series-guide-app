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
	
	// ---------------------------- EQUALS -----------------------------------------
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (cadena == null) {
			if (other.cadena != null)
				return false;
		} else if (!cadena.equals(other.cadena))
			return false;
		if (diaEmision == null) {
			if (other.diaEmision != null)
				return false;
		} else if (!diaEmision.equals(other.diaEmision))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (generos == null) {
			if (other.generos != null)
				return false;
		} else if (!generos.equals(other.generos))
			return false;
		if (horarioEmision == null) {
			if (other.horarioEmision != null)
				return false;
		} else if (!horarioEmision.equals(other.horarioEmision))
			return false;
		if (id != other.id)
			return false;
		if (inicioEmision == null) {
			if (other.inicioEmision != null)
				return false;
		} else if (!inicioEmision.equals(other.inicioEmision))
			return false;
		if (Double.doubleToLongBits(puntuacion) != Double.doubleToLongBits(other.puntuacion))
			return false;
		if (seasons == null) {
			if (other.seasons != null)
				return false;
		} else if (!seasons.equals(other.seasons))
			return false;
		if (sinopsis == null) {
			if (other.sinopsis != null)
				return false;
		} else if (!sinopsis.equals(other.sinopsis))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (totalPuntuaciones != other.totalPuntuaciones)
			return false;
		return true;
	}
	
	// ---------------------------- GETTERS && SETTERS -----------------------------

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
