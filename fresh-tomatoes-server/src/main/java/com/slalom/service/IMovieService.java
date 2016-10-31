package com.slalom.service;

import com.slalom.exception.BadRequestException;
import org.springframework.data.domain.Page;

import com.slalom.beans.Movie;

/**
 * Created by tara.
 */
public interface IMovieService {

    public Movie addMovie( Movie movie ) throws BadRequestException;

    public Page<Movie> getMovies( String searchKey, Integer page, Integer size, String sortBy, String orderBy );

}
