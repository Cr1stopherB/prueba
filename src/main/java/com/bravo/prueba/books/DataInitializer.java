package com.bravo.prueba.books;

import com.bravo.prueba.books.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        bookRepository.save(new Book("1", "Clean Code", "Robert C. Martin", "978-0132350884", 5));
        bookRepository.save(new Book("2", "The Pragmatic Programmer", "David Thomas & Andrew Hunt", "978-0135957059", 3));
        bookRepository.save(new Book("3", "Design Patterns", "Gang of Four", "978-0201633610", 2));
        bookRepository.save(new Book("4", "Refactoring", "Martin Fowler", "978-0134757599", 4));
        bookRepository.save(new Book("5", "Domain-Driven Design", "Eric Evans", "978-0321125217", 1));
    }
}
