package dev.srinathg.movies.service;

import dev.srinathg.movies.Movie;
import dev.srinathg.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findAllMovies(){
        return repository.findAll();
    }

    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
}
