package com.example.demo.service;

import com.example.demo.entity.Borrowing;
import com.example.demo.entity.Book;
import com.example.demo.repository.BorrowingRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private BookRepository bookRepository;

    // Get all borrowings
    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    // Borrow a book
    public Borrowing borrowBook(String borrowerName, Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is not available for borrowing.");
        }

        book.setAvailable(false);
        bookRepository.save(book);

        Borrowing borrowing = new Borrowing();
        borrowing.setBorrowerName(borrowerName);
        borrowing.setBook(book);
        borrowing.setBorrowDate(LocalDate.now());
        borrowing.setDueDate(LocalDate.now().plusWeeks(2));
        borrowing.setReturned(false);

        return borrowingRepository.save(borrowing);
    }

    // Return a borrowed book
    public void returnBook(Long borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(borrowingId)
                .orElseThrow(() -> new IllegalArgumentException("Borrowing record not found"));

        borrowing.setReturned(true);
        Book book = borrowing.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        borrowingRepository.save(borrowing);
    }

    // Find borrowings by borrower name
    public List<Borrowing> getBorrowingsByBorrowerName(String borrowerName) {
        return borrowingRepository.findByBorrowerName(borrowerName);
    }

    // Get all active borrowings (books not returned)
    public List<Borrowing> getActiveBorrowings() {
        return borrowingRepository.findByReturnedFalse();
    }
}