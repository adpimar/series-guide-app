package impl.exceptions;

public class NoEpisodeCheckedAsViewedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoEpisodeCheckedAsViewedException() {
		super("No es posible comentar el episodio si no está marcado como visto.");
	}

}
