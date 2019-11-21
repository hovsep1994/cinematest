package com.sample.cinema.controller;

import com.sample.cinema.model.Movie;
import com.sample.cinema.model.MovieDto;
import com.sample.cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("{id}")
    public Mono<Movie> get(@PathVariable String id) {
        return movieService.get(id);
    }

    @GetMapping
    public Flux<Movie> get() {
        return movieService.getAll();
    }

    @PostMapping
    public Mono<Movie> create(@RequestBody MovieDto movieDto) {
        return movieService.create(movieDto);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Movie> getStream() {
        return movieService.getStream();
    }

}
