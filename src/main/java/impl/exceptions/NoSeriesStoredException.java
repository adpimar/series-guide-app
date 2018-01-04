package impl.exceptions;

public class NoSeriesStoredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSeriesStoredException() {
		super("Serie(s) no almacenada(s) en la BDL.");
	}

}
