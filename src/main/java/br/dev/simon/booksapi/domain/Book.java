package br.dev.simon.booksapi.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Book {

	@Id
	@JsonInclude(Include.NON_NULL) // Só mostra no JSON se não for NULL.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonInclude(Include.NON_NULL)
	private String nome;

	@JsonInclude(Include.NON_NULL)
	private Date publicacao;

	@JsonInclude(Include.NON_NULL)
	private String editora;

	@JsonInclude(Include.NON_NULL)
	private String resumo;

	// @Transient //Evita fazer relação.
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "book") // Um livro tem vários comentários.
	private List<Comment> comentarios;

	@JsonInclude(Include.NON_NULL)
	private String autor;

	public Book() {
	}

	public Book(String nome) {
		this.nome = nome;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
