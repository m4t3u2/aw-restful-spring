package br.dev.simon.booksapi.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonInclude(Include.NON_NULL) // Só mostra no JSON se não for NULL.
	private String nome;

	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date publicacao;

	@JsonInclude(Include.NON_NULL)
	private String editora;

	@JsonInclude(Include.NON_NULL)
	@Size(max = 1500, message = "O resumo não pode conter mais que 1500 caracteres.")
	private String resumo;

	// @Transient //Evita fazer relação.
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "book") // Um livro para vários comentários.
	private List<Comment> comentarios;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne // Vários livros para um autor.
	@JoinColumn(name = "AUTHOR_ID")
	private Author autor;

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public List<Comment> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comment> comentarios) {
		this.comentarios = comentarios;
	}

	public Author getAutor() {
		return autor;
	}

	public void setAutor(Author autor) {
		this.autor = autor;
	}

}
