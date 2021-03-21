package br.dev.simon.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.dev.simon.booksapi.domain.Book;
import br.dev.simon.booksapi.repository.BooksRepository;
import br.dev.simon.booksapi.services.exceptions.BookNotFoundException;

@Service
public class BooksService {

	@Autowired
	private BooksRepository repository;

	public List<Book> list() {
		return repository.findAll();
	}

	public Book find(Long id) {
		Optional<Book> book = repository.findById(id);
		if (book.isPresent() == false) {
			throw new BookNotFoundException("Book not found!");
		}
		return book.get();
	}

	public Book save(Book book) {
		book.setId(null);
		return repository.save(book);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BookNotFoundException("Book not found!");
		}
	}

	public void update(Book book) {
		bookExist(book);
		repository.save(book);
	}

	private void bookExist(Book book) {
		find(book.getId());
	}

}
