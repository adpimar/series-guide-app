package impl.exceptions;

public class TooLongOverviewException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TooLongOverviewException() {
		super("La sinopsis excede los 500 caracteres.");
	}

}
