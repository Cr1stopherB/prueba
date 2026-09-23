package com.bravo.prueba.reviews;

public class Review {
    private String id;
    private String bookId;
    private String userEmail;
    private int rating;
    private String comment;

    public Review() {}

    public Review(String id, String bookId, String userEmail, int rating, String comment) {
        this.id = id;
        this.bookId = bookId;
        this.userEmail = userEmail;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}