package impl.exceptions;

public class NoSeriesStoredException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSeriesStoredException() {
		super("Serie(s) no almacenada(s) en la BDL.");
	}

}
