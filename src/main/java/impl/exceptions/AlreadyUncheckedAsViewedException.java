package impl.exceptions;

public class AlreadyUncheckedAsViewedException extends Exception {

	private static final long serialVersionUID = 1L;

	public AlreadyUncheckedAsViewedException() {
		super("Episodio indicado como no visto.");
	}

}
