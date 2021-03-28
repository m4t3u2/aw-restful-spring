package br.dev.simon.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.simon.booksapi.domain.Author;
import br.dev.simon.booksapi.repository.AuthorsRepository;
import br.dev.simon.booksapi.services.exceptions.AuthorExistException;
import br.dev.simon.booksapi.services.exceptions.AuthorNotExistException;

@Service
public class AuthorsService {

	@Autowired
	private AuthorsRepository authorsRepository;

	public List<Author> list() {
		return authorsRepository.findAll();
	}

	public Author find(Long id) {
		Optional<Author> author = authorsRepository.findById(id);
		if (author.isPresent() == false) {
			throw new AuthorNotExistException("Author not found!");
		}
		return author.get();
	}

	public Author save(Author author) {
		if (author.getId() != null) {
			Optional<Author> exist = authorsRepository.findById(author.getId());
			if (exist.isPresent() == true) {
				throw new AuthorExistException("Autor já existe!");
			}
		}
		return authorsRepository.save(author);
	}
//
//	public void delete(Long id) {
//		try {
//			booksRepository.deleteById(id);
//		} catch (EmptyResultDataAccessException e) {
//			throw new BookNotFoundException("Book not found!");
//		}
//	}
//
//	public void update(Book book) {
//		bookExist(book);
//		booksRepository.save(book);
//	}
//
//	private void bookExist(Book book) {
//		find(book.getId());
//	}
//
//	// Esse método poderia ficar em Service separado.
//	public Comment saveComment(Long bookId, Comment comment) {
//		Book book = find(bookId);
//		comment.setBook(book);
//		comment.setData(new Date());
//		return commentsRepository.save(comment);
//	}
//
//	// Esse método poderia ficar em Service separado.
//	public List<Comment> listComment(Long bookId) {
//		Book book = find(bookId);
//		return book.getComentarios();
//	}

}
