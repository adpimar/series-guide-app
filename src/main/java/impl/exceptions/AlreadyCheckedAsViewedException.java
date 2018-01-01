package impl.exceptions;

public class AlreadyCheckedAsViewedException extends Exception {

	private static final long serialVersionUID = 1L;

	public AlreadyCheckedAsViewedException() {
		super("Episodio indicado como visto.");
	}

}
