package impl.exceptions;

public class TooLongOverviewException extends Exception {

	private static final long serialVersionUID = 1L;

	public TooLongOverviewException() {
		super("La sinopsis excede los 500 caracteres.");
	}

}
