package com.example.demo.controller;

import com.example.demo.entity.Borrowing;
import com.example.demo.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @GetMapping
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }

    @PostMapping("/borrow")
    public Borrowing borrowBook(@RequestParam String borrowerName, @RequestParam Long bookId) {
        return borrowingService.borrowBook(borrowerName, bookId);
    }

    @PutMapping("/return/{borrowingId}")
    public ResponseEntity<Void> returnBook(@PathVariable Long borrowingId) {
        borrowingService.returnBook(borrowingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/borrower")
    public List<Borrowing> getBorrowingsByBorrowerName(@RequestParam String borrowerName) {
        return borrowingService.getBorrowingsByBorrowerName(borrowerName);
    }

    @GetMapping("/active")
    public List<Borrowing> getActiveBorrowings() {
        return borrowingService.getActiveBorrowings();
    }
}