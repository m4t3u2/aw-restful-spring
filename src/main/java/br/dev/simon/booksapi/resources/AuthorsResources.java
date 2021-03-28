package br.dev.simon.booksapi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.dev.simon.booksapi.domain.Author;
import br.dev.simon.booksapi.services.AuthorsService;

@RestController
@RequestMapping("/authors")
public class AuthorsResources {

	@Autowired
	private AuthorsService authorsService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Author>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(authorsService.list());
	}

	@GetMapping("/{id}")
	// @RequestMapping(value = "/{id}", method = RequestMethod.GET) // Outra forma.
	public ResponseEntity<?> find(@PathVariable Long id) {
		Author author = authorsService.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Author author) {
		author = authorsService.save(author);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(author.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
