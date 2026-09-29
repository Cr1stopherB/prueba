package com.bravo.prueba.reviews;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final List<Review> reviewsList = new ArrayList<>();

    public ReviewController() {
        reviewsList.add(new Review(UUID.randomUUID().toString(), "1", "user@test.com", 5, "Excelente libro"));
    }

    // GET /api/books/{bookId}/reviews
    @GetMapping("/{bookId}/reviews")
    public List<Review> getReviewsByBook(@PathVariable String bookId) {
        return reviewsList.stream()
                .filter(r -> r.getBookId().equals(bookId))
                .collect(Collectors.toList());
    }

    // POST /api/books/{bookId}/reviews
    @PostMapping("/{bookId}/reviews")
    public Review createReview(@PathVariable String bookId, @RequestBody Review review) {
        review.setId(UUID.randomUUID().toString());
        review.setBookId(bookId);
        reviewsList.add(review);
        return review;
    }
}