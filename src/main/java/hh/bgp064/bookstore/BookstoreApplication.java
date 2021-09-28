package hh.bgp064.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bgp064.bookstore.domain.Book;
import hh.bgp064.bookstore.domain.BookRepository;
import hh.bgp064.bookstore.domain.CatRepository;
import hh.bgp064.bookstore.domain.Category;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository bookRepository, CatRepository catRepository) {
		return (args) -> {
			log.info("save a couple of books");
			Category catScifi = new Category("scifi");
			catRepository.save(catScifi);
			Category catComic = new Category("comic");
			catRepository.save(catComic);
			Category catKids = new Category("kids");
			catRepository.save(catKids);
			
			bookRepository.save(new Book("Kirjayksi", "Meikäläinen", 1982, "2938LOL", catScifi ));
			bookRepository.save(new Book("Kirjakaksi", "Meikäläinen",1976, "JEE927", catComic));
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			log.info("fetch all categories");
			for (Category category : catRepository.findAll()) {
				log.info(category.toString());
			}
		};
	}
}
