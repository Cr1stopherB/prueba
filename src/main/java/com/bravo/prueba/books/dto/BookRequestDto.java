package com.bravo.prueba.books.dto;

public record BookRequestDto(String title, String author, String isbn, Integer availableCopies) {
}