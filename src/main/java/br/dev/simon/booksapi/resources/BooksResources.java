package br.dev.simon.booksapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.dev.simon.booksapi.domain.Book;
import br.dev.simon.booksapi.services.BooksService;

@RestController
@RequestMapping("/books")
public class BooksResources {

	@Autowired
	private BooksService service;

	@GetMapping
	public ResponseEntity<List<Book>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(service.list());
	}

	@GetMapping("/{id}")
	// @RequestMapping(value = "/{id}", method = RequestMethod.GET) // Outra forma.
	public ResponseEntity<?> find(@PathVariable Long id) {
		Book book = service.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Book book) {
		book = service.save(book);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); // Ideal retornar quando deletado.
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Book book, @PathVariable Long id) {
		book.setId(id);
		service.update(book);
		return ResponseEntity.noContent().build();
	}

}
