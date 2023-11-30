package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    private BookService bookService;

    public BookstoreApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book roman = new Book();
                roman.setAuthor("Tolstoy");
                roman.setName("War and peace");
                roman.setIsbn("War and peace isbn");
                roman.setPrice(BigDecimal.valueOf(100));
                roman.setDescription("War and peace Description");
                roman.setCoverImage("War and peace Cover image");

                bookService.save(roman);

                bookService.findAll().forEach(book -> System.out.println(book.toString()));

            }
        };
    }

}
