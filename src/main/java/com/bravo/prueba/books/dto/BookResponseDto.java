package com.bravo.prueba.books.dto;

public record BookResponseDto(String id, String title, String author, String isbn, Integer availableCopies) {
}