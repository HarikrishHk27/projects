package com.example.demo.controller;


import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id) {
        Optional<Author> author = authorService.getAuthorById(id);
        return author.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
	/*
	 * public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
	 * Optional<Book> book = bookService.getBookById(id); if (book.isPresent()) {
	 * return ResponseEntity.ok(book.get()); } else { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); }
	 */

    @GetMapping("/search")
    public ResponseEntity<Author> getAuthorByName(@RequestParam String name) {
        Optional<Author> author = authorService.getAuthorByName(name);
        return author.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") Long id, @RequestBody Author authorDetails) {
        Author updatedAuthor = authorService.updateAuthor(id, authorDetails);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
	/*
	 * @PutMapping("/{id}") public ResponseEntity<Author> updateAuthor(@PathVariable
	 * Long id, @RequestBody Author authorDetails) { Author updatedAuthor =
	 * authorService.updateAuthor(id, authorDetails); return
	 * ResponseEntity.ok(updatedAuthor); }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Void>
	 * deleteAuthor(@PathVariable Long id) { authorService.deleteAuthor(id); return
	 * ResponseEntity.noContent().build(); }
	 */
}