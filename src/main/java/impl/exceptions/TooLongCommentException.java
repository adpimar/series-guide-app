package impl.exceptions;

public class TooLongCommentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TooLongCommentException() {
		super("El comentario excede los 150 caracteres.");
	}

}
