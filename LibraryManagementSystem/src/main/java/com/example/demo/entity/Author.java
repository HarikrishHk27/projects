package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

	 private String name;

	 @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	 private List<Book> books = new ArrayList<>();

	 public Author() {
			
	 }
	 
	 public Author(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		books.add(book);
	    book.setAuthor(this);
	    }

	public void removeBook(Book book) {
		books.remove(book);
	    book.setAuthor(null);
	    }

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
	 
}
