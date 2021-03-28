package br.dev.simon.booksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.simon.booksapi.domain.Author;

public interface AuthorsRepository extends JpaRepository<Author, Long> {

}
