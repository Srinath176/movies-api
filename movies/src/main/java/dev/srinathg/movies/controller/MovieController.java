package dev.srinathg.movies.controller;

import dev.srinathg.movies.Movie;
import dev.srinathg.movies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    private MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }


    @GetMapping("/movies-api")
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("movies-api/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(service.findMovieByImdbId(imdbId), HttpStatus.OK);
    }


}
