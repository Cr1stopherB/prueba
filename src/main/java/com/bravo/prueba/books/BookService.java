package com.bravo.prueba.books;

import com.bravo.prueba.books.dto.BookRequestDto;
import com.bravo.prueba.books.dto.BookResponseDto;
import com.bravo.prueba.books.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponseDto> getAll() {
        return bookRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public Optional<BookResponseDto> getById(String id) {
        return bookRepository.findById(id).map(this::toResponseDto);
    }

    public BookResponseDto create(BookRequestDto request) {
        Book book = new Book(
                UUID.randomUUID().toString(),
                request.title(),
                request.author(),
                request.isbn(),
                request.availableCopies()
        );
        return toResponseDto(bookRepository.save(book));
    }

    public Optional<BookResponseDto> update(String id, BookRequestDto request) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(request.title());
            book.setAuthor(request.author());
            book.setIsbn(request.isbn());
            book.setAvailableCopies(request.availableCopies());
            return toResponseDto(bookRepository.save(book));
        });
    }

    public Optional<BookResponseDto> partialUpdate(String id, BookRequestDto request) {
        return bookRepository.findById(id).map(book -> {
            if (request.title() != null) book.setTitle(request.title());
            if (request.author() != null) book.setAuthor(request.author());
            if (request.isbn() != null) book.setIsbn(request.isbn());
            if (request.availableCopies() != null) book.setAvailableCopies(request.availableCopies());
            return toResponseDto(bookRepository.save(book));
        });
    }

    public boolean delete(String id) {
        if (!bookRepository.existsById(id)) {
            return false;
        }
        bookRepository.deleteById(id);
        return true;
    }

    private BookResponseDto toResponseDto(Book book) {
        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getAvailableCopies()
        );
    }
}