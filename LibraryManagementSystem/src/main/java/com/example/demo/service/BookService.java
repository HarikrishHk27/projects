package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
       return bookRepository.findById(id);
    }
		/*
		 * Optional<Book> book = bookRepository.findById(id); if (book.isPresent()) {
		 * return book.get(); } else { throw new
		 * RuntimeException("Book not found with id: " + id); } }
		 */

	/*
	 * public List<Book> getBooksByTitle(String title) { // return
	 * bookRepository.findByTitleContaining(title); }
	 * 
	 * public List<Book> getBooksByAuthorId(Long authorId) { // return
	 * bookRepository.findByAuthorId(authorId); }
	 */

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

	/*
	 * public Book updateBook(Long id, Book bookDetails) { Book book =
	 * bookRepository.findById(id) .orElseThrow(() -> new
	 * IllegalArgumentException("Book not found"));
	 * book.setTitle(bookDetails.getTitle());
	 * book.setPublicationYear(bookDetails.getPublicationYear());
	 * book.setAvailable(bookDetails.isAvailable()); return
	 * bookRepository.save(book); }
	 */
    public Book updateBook(Long id, Book bookDetails) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setPublicationYear(bookDetails.getPublicationYear());
        existingBook.setAvailable(bookDetails.isAvailable());
        existingBook.setAuthor(bookDetails.getAuthor());

        return bookRepository.save(existingBook);
    }
    
	/*
	 * public void deleteBook(Long id) { bookRepository.deleteById(id); }
	 */
	/*
	 * public boolean deleteBook(Long id) { Optional<Book> book =
	 * bookRepository.findById(id); if (book.isPresent()) {
	 * bookRepository.deleteById(id); return true; } return false; }
	 */
    
    public boolean deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return true; // Indicates successful deletion
        } else {
            throw new RuntimeException("Book with ID " + id + " not found.");
            }
    }
}