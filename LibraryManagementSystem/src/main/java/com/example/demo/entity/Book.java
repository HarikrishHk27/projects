package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String title;
	 private String publicationYear;
	 private boolean available = true;

	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "author_id")
	 private Author author;

	 
		/*
		 * public Book() { }
		 */
	 public Book() {
		}

	public Book(String title, String publicationYear, boolean available, Author author) {
		this.title = title;
		this.publicationYear = publicationYear;
		this.available = available;
		this.author = author;
	}
	/*
	 * public Book() { }
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publicationYear=" + publicationYear + ", available="
				+ available + ", author=" + author + "]";
	}
	 
	 

}

