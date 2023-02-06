package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
 
@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	//bookstore tilalla oli demo tossa alla
	public CommandLineRunner bookstore(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			//your code here.. add demo data to db
			
			//creating demo data, obects to add to the dc
			//Book s1 = new Book("123456", "Fairytales from The Forest", "Millie Maven", 1995, 29);
			//Book s2 = new Book("987654", "Book About Things", "Ronald Weasel", 1999, 15);
			
			//saving demo objects to the db
			//bookRepository.save(s1);
			//bookRepository.save(s2);
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("Biography"));
			categoryRepository.save(new Category("Romance"));
			categoryRepository.save(new Category("Fiction"));
			categoryRepository.save(new Category("Historical"));
		
			
			bookRepository.save(new Book("123456", "Fairytales from The Forest", "Millie Maven", 1995, 29, categoryRepository.findByName("Horror").get(0)));
			bookRepository.save(new Book("987654", "Book About Things", "Ronald Weasel", 1999, 15, categoryRepository.findByName("Fiction").get(0)));
			bookRepository.save(new Book("29384756", "What should we do about dinner?", "Jolly Koven", 1857, 102, categoryRepository.findByName("Historical").get(0)));
			
		
		
		};	 
	}

}
