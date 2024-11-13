package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Borrowing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String borrowerName;
	private LocalDate borrowDate;
	private LocalDate dueDate;
	private boolean returned;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	

	public Borrowing(String borrowerName, LocalDate borrowDate, LocalDate dueDate, boolean returned, Book book) {
		this.borrowerName = borrowerName;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.returned = returned;
		this.book = book;
	}


	public Borrowing() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBorrowerName() {
		return borrowerName;
	}


	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}


	public LocalDate getBorrowDate() {
		return borrowDate;
	}


	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public boolean isReturned() {
		return returned;
	}


	public void setReturned(boolean returned) {
		this.returned = returned;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	@Override
	public String toString() {
		return "Borrowing [id=" + id + ", borrowerName=" + borrowerName + ", borrowDate=" + borrowDate + ", dueDate="
				+ dueDate + ", returned=" + returned + ", book=" + book + "]";
	}
	
	
	
}
