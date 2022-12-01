package com.xsis.movie.controller;

import com.xsis.movie.model.request.MovieServiceRequest;
import com.xsis.movie.model.response.MovieServiceResponse;
import com.xsis.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController(value = ("/movie"))
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/{id}")
    public MovieServiceResponse getMovieById(@PathVariable( value = "id") Long id){
        return movieService.findById(id);
    }

    @GetMapping
    public List<MovieServiceResponse> getMovieById(){
        return movieService.findAll();
    }

    @PostMapping
    public MovieServiceResponse addMovie(MovieServiceRequest request){
        return movieService.save(request);
    }

    @PatchMapping
    public MovieServiceResponse updateMovie(MovieServiceRequest request){
        return movieService.save(request);
    }

    @DeleteMapping(value = "/{id}")
    public MovieServiceResponse deleteMovieById(@PathVariable( value = "id") Long id){
        return movieService.deleteById(id);
    }

}
