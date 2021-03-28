package br.dev.simon.booksapi.services.exceptions;

public class AuthorExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthorExistException(String msg) {
		super(msg);
	}

	public AuthorExistException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
