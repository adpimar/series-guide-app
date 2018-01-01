package impl.exceptions;

public class NoSeasonsStoredException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSeasonsStoredException() {
		super("Temporada(s) no almacenada(s) en la BDL.");
	}

}
