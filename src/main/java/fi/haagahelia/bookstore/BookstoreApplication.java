package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.AppUser;
import fi.haagahelia.bookstore.domain.AppUserRepository;
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
	public CommandLineRunner bookstore(BookRepository bookRepository, CategoryRepository categoryRepository, AppUserRepository appUserRepository) {
		return (args) -> {
			//your code here.. add demo data to db
			
			//creating demo data, obects to add to the dc
			//Book s1 = new Book("123456", "Fairytales from The Forest", "Millie Maven", 1995, 29);
			//Book s2 = new Book("987654", "Book About Things", "Ronald Weasel", 1999, 15);
			
			//saving demo objects to the db
			//bookRepository.save(s1);
			//bookRepository.save(s2);
			appUserRepository.save(new AppUser("admin", "$2a$12$6ZMoGWJkzoKcg1qIriU2HOmFjEIOH/Sxzc4OityfQnpo.PwTWV9Lm", "ADMIN"));
			appUserRepository.save(new AppUser("user", "$2a$12$YD68Waw0kCduoqtglyrFGusp4u73urkl6g8hicK5DeZEbX/YnifLq", "USER"));
			
			//AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			//AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			//appUserRepository.save(user1);
			//appUserRepository.save(user2);
			
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