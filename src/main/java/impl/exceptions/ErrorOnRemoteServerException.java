package impl.exceptions;

public class ErrorOnRemoteServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorOnRemoteServerException() {
		super("Error en el servidor remoto.");
	}

}
