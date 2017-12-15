package impl;

public class Episode {

	private int numeroEpisodio;
	private String titulo;
	private String fechaEmision;
	private String sinopsis;
	private String visto;
	private long id;
	private String comentario;

	public Episode() {

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ EPISODE " + numeroEpisodio + " ]");
		sb.append("\nTítulo			    : " + titulo);
		sb.append("\nfechaEmision       : " + fechaEmision);
		sb.append("\nVisto	            : " + visto);
		sb.append("\nId  	            : " + id);
		sb.append("\nComentario         : " + comentario);

		return sb.toString();
	}

	// ---------------------------- GETTERS && SETTERS -----------------------------

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getVisto() {
		return visto;
	}

	public void setVisto(String visto) {
		this.visto = visto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
