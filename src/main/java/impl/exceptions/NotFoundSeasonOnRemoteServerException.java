package impl.exceptions;

public class NotFoundSeasonOnRemoteServerException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundSeasonOnRemoteServerException() {
		super("Temporada no encontrada en el servidor remoto.");
	}

}
