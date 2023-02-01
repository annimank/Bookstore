package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			//your code here.. add demo data to db
			
			//creating demo data, obects to add to the dc
			Book s1 = new Book("123456", "Fairytales from The Forest", "Millie Maven", 1995, 29);
			Book s2 = new Book("987654", "Book About Things", "Ronald Weasel", 1999, 15);
			
			//saving demo objects to the db
			repository.save(s1);
			repository.save(s2);
		
		};	 
	}

}
