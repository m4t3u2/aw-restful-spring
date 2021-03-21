package br.dev.simon.booksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.simon.booksapi.domain.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
