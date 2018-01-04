package impl.exceptions;

public class TimeoutOnRemoteServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TimeoutOnRemoteServerException() {
		super("Espera demasiado largar en el servidor remoto.");
	}

}
