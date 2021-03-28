package br.dev.simon.booksapi.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.dev.simon.booksapi.domain.Book;
import br.dev.simon.booksapi.domain.Comment;
import br.dev.simon.booksapi.repository.BooksRepository;
import br.dev.simon.booksapi.repository.CommentsRepository;
import br.dev.simon.booksapi.services.exceptions.BookNotFoundException;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private CommentsRepository commentsRepository;

	public List<Book> list() {
		return booksRepository.findAll();
	}

	public Book find(Long id) {
		Optional<Book> book = booksRepository.findById(id);
		if (book.isPresent() == false) {
			throw new BookNotFoundException("Book not found!");
		}
		return book.get();
	}

	public Book save(Book book) {
		book.setId(null);
		return booksRepository.save(book);
	}

	public void delete(Long id) {
		try {
			booksRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BookNotFoundException("Book not found!");
		}
	}

	public void update(Book book) {
		bookExist(book);
		booksRepository.save(book);
	}

	private void bookExist(Book book) {
		find(book.getId());
	}

	// Esse método poderia ficar em Service separado.
	public Comment saveComment(Long bookId, Comment comment) {
		Book book = find(bookId);
		comment.setBook(book);
		comment.setData(new Date());
		return commentsRepository.save(comment);
	}

	// Esse método poderia ficar em Service separado.
	public List<Comment> listComment(Long bookId) {
		Book book = find(bookId);
		return book.getComentarios();
	}

}
