package com.bravo.prueba.books;

import com.bravo.prueba.books.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {

    private final Map<String, Book> store = new LinkedHashMap<>();

    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Book> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    public Book save(Book book) {
        store.put(book.getId(), book);
        return book;
    }

    public boolean existsById(String id) {
        return store.containsKey(id);
    }

    public void deleteById(String id) {
        store.remove(id);
    }
}