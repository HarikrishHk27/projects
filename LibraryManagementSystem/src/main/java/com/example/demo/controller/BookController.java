package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        //  return book.map(ResponseEntity::OK)
          //      .orElseGet(() -> ResponseEntity.notFound().build());
       
    }
        

	/*
	 * @GetMapping("/search") public List<Book> getBooksByTitle(@RequestParam String
	 * title) { return bookService.getBooksByTitle(title); }
	 * 
	 * @GetMapping("/author/{authorId}") public List<Book>
	 * getBooksByAuthorId(@PathVariable Long authorId) { return
	 * bookService.getBooksByAuthorId(authorId); }
	 */

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

	/*
	 * @PutMapping("/{id}") public ResponseEntity<Book> updateBook(@PathVariable
	 * Long id, @RequestBody Book bookDetails) { return
	 * ResponseEntity.ok(bookService.updateBook(id, bookDetails)); }
	 */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book bookDetails) {
        Optional<Book> existingBook = bookService.getBookById(id);

        if (existingBook.isPresent()) {
            Book updatedBook = bookService.updateBook(id, bookDetails);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        try {
            boolean isDeleted = bookService.deleteBook(id);
            if (isDeleted) {
                return ResponseEntity.noContent().build();
            } 
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
    }
    
	/*
	 * @DeleteMapping("/{id}") public ResponseEntity<Void> deleteBook(@PathVariable
	 * Long id) { try { boolean isDeleted = bookService.deleteBook(id); if
	 * (isDeleted) { return ResponseEntity.noContent().build(); } } catch
	 * (RuntimeException e) { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).build(); } return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }
	 */
}