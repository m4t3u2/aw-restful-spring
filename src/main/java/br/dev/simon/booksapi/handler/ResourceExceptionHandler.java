package br.dev.simon.booksapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.dev.simon.booksapi.domain.ErrorDetails;
import br.dev.simon.booksapi.services.exceptions.AuthorExistException;
import br.dev.simon.booksapi.services.exceptions.AuthorNotExistException;
import br.dev.simon.booksapi.services.exceptions.BookNotFoundException;

@ControllerAdvice // Intercepta as exceptions.
public class ResourceExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleBookNotFoundException(BookNotFoundException e,
			HttpServletRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitulo("Book not found!");
		error.setMsgDev("simon.dev.br");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(AuthorExistException.class)
	public ResponseEntity<ErrorDetails> handleAuthorExistException(AuthorExistException e, HttpServletRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitulo("Author already exists!");
		error.setMsgDev("simon.dev.br");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	@ExceptionHandler(AuthorNotExistException.class)
	public ResponseEntity<ErrorDetails> handleAuthorNotExistException(AuthorNotExistException e,
			HttpServletRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitulo("Author not exists!");
		error.setMsgDev("simon.dev.br");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
