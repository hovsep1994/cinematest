package com.sample.cinema.service;

import com.sample.cinema.model.Movie;
import com.sample.cinema.model.MovieDto;
import com.sample.cinema.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Mono<Movie> get(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Mono<Movie> create(MovieDto dto) {
        Movie movie = new Movie(UUID.randomUUID().toString(), dto.getTitle(), dto.getGenre());
        return movieRepository.save(movie);
    }

    @Override
    public Flux<Movie> getStream() {
        Flux<Movie> movieFlux = movieRepository.findAll();
        return Flux.zip(Flux.interval(Duration.ofSeconds(1)), movieFlux).map(Tuple2::getT2);
    }

}
