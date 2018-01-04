package impl.exceptions;

public class NotFoundSerieOnRemoteServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundSerieOnRemoteServerException() {
		super("Serie no encontrada en el servidor remoto.");
	}

}
