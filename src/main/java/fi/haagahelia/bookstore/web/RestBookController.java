package fi.haagahelia.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

//instead of tymeleaf temp, rest returns json info
@RestController
public class RestBookController {
	
	@Autowired
	BookRepository bookRepository;
	
	// get all
	@GetMapping("/books")
	public Iterable<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	// get one by id
	@GetMapping("/books/{id}")
	public Optional<Book> getBook(@PathVariable Long id) {
		return bookRepository.findById(id);
	}
	
	// add a new book
	@PostMapping("books")
	Book newBook(@RequestBody Book newBook) {
		return bookRepository.save(newBook);
	}
	
	// edit 
	@PutMapping("/books/{id}")
	Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
		editedBook.setId(id);
		return bookRepository.save(editedBook);
	}
	
	// delete
	@DeleteMapping("books/{id}")
	public Iterable<Book> deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
		return bookRepository.findAll();
	}
		
}
