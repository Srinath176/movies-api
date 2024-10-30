package dev.srinathg.movies.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReviewController {


    private ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping("movies-api/v1/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }



}
