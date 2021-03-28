package br.dev.simon.booksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.simon.booksapi.domain.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

}
