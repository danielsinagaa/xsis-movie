package com.xsis.movie.service;

import com.xsis.movie.model.entity.Movie;
import com.xsis.movie.model.exception.EntityNotFoundEx;
import com.xsis.movie.model.request.MovieServiceRequest;
import com.xsis.movie.model.response.MovieServiceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService extends AbstractService<Movie> {
    public MovieService(JpaRepository<Movie, Long> repository) {
        super(repository);
    }

    public MovieServiceResponse findById(Long id){
        Movie movie = repository.findById(id).orElseThrow(EntityNotFoundEx::new);
        return generateResponse(movie);
    }

    public MovieServiceResponse save(MovieServiceRequest request){
        Movie movie = repository.save(generateEntity(request));
        return generateResponse(movie);
    }

    public List<MovieServiceResponse> findAll(){
        List<MovieServiceResponse> response = new ArrayList<>();
        List<Movie> movies = repository.findAll();
        movies.forEach(it -> response.add(generateResponse(it)));
        return response;
    }

    public MovieServiceResponse deleteById(Long id){
        Movie movie = repository.findById(id).orElseThrow(EntityNotFoundEx::new);
        repository.deleteById(id);
        return generateResponse(movie);
    }

    private MovieServiceResponse generateResponse(Movie movie){
        MovieServiceResponse response = new MovieServiceResponse();
        response.setId(movie.getId());
        response.setRating(movie.getRating());
        response.setImage(movie.getImage());
        response.setTitle(movie.getTitle());
        response.setDescription(movie.getDescription());
        response.setCreatedDate(movie.getCreatedDate());
        response.setModifiedDate(movie.getModifiedDate());
        return response;
    }

    private Movie generateEntity(MovieServiceRequest movie){
        Movie response = new Movie();
        response.setRating(movie.getRating());
        response.setImage(movie.getImage());
        response.setTitle(movie.getTitle());
        response.setDescription(movie.getDescription());
        return response;
    }
}
