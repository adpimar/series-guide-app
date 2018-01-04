package impl.exceptions;

public class NoKeywordsOnRemoteSearchException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoKeywordsOnRemoteSearchException() {
		super("Necesario introducir alguna palabra clave en la búsqueda.");
	}

}
