package com.bravo.prueba.books;

import com.bravo.prueba.books.dto.BookRequestDto;
import com.bravo.prueba.books.dto.BookResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponseDto> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getById(@PathVariable String id) {
        return bookService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAnyRole('Admin', 'Colaborador')")
    @PostMapping
    public ResponseEntity<BookResponseDto> create(@RequestBody BookRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(request));
    }

    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable String id, @RequestBody BookRequestDto request) {
        return bookService.update(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('Admin')")
    @PatchMapping("/{id}")
    public ResponseEntity<BookResponseDto> partialUpdate(@PathVariable String id, @RequestBody BookRequestDto request) {
        return bookService.partialUpdate(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return bookService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}