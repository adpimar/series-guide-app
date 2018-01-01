package impl.exceptions;

public class NoCommentEpisodeNotChekedException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoCommentEpisodeNotChekedException() {
		super("No es posible comentar el episodio si no está marcado como visto.");
	}

}
