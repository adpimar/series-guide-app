package impl.exceptions;

public class NoEpisodesStoredException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoEpisodesStoredException() {
		super("Episodio(s) no almacenado(s) en la BDL.");
	}

}
