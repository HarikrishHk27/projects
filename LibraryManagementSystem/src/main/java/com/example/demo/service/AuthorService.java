package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Optional<Author> getAuthorByName(String name) {
        return Optional.ofNullable(authorRepository.findByName(name));
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Update an existing author
    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with ID: " + id));

        // Ensure the new name is valid
        if (authorDetails.getName() == null || authorDetails.getName().isEmpty()) {
            throw new IllegalArgumentException("Updated author name cannot be null or empty");
        }

        author.setName(authorDetails.getName());
        return authorRepository.save(author);
    }

    // Delete an author
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new IllegalArgumentException("Author not found with ID: " + id);
        }
        authorRepository.deleteById(id);
    }
	/*
	 * public Author updateAuthor(Long id, Author authorDetails) { Author author =
	 * authorRepository.findById(id) .orElseThrow(() -> new
	 * IllegalArgumentException("Author not found"));
	 * 
	 * author.setName(authorDetails.getName());
	 * 
	 * return authorRepository.save(author); }
	 */
	/*
	 * public Author updateAuthor(Long id, Author authorDetails) { Author author =
	 * authorRepository.findById(id) .orElseThrow(() -> new
	 * IllegalArgumentException("Author not found"));
	 * author.setName(authorDetails.getName()); return
	 * authorRepository.save(author); }
	 */

	/*
	 * public void deleteAuthor(Long id) { authorRepository.deleteById(id); }
	 */
}