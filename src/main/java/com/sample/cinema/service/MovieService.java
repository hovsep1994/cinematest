package com.sample.cinema.service;

import com.sample.cinema.model.Movie;
import com.sample.cinema.model.MovieDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Mono<Movie> get(String id);

    Flux<Movie> getAll();

    Mono<Movie> create(MovieDto dto);

    Flux<Movie> getStream();
}
