package dev.srinathg.movies.reviews;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import dev.srinathg.movies.Movie;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    private ReviewRepository repository;
    private MongoTemplate mongoTemplate;

    public ReviewService(ReviewRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }


    public Review createReview(String reviewBody, String imdbId) {

        Review review = repository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();
        return review;
    }



}
