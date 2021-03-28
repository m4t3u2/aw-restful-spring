package br.dev.simon.booksapi.services.exceptions;

public class AuthorNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthorNotExistException(String msg) {
		super(msg);
	}

	public AuthorNotExistException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
