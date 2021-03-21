package br.dev.simon.booksapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.dev.simon.booksapi.domain.ErrorDetails;
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

}
