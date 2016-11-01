package com.slalom.service.impl;

import java.util.Date;
import java.util.List;

import com.slalom.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.slalom.exception.BadRequestException;
import com.slalom.beans.Movie;
import com.slalom.constant.Constants;
import com.slalom.constant.ExceptionConstants;
import com.slalom.repository.MovieRepository;
import com.slalom.service.IMovieService;

/**
 * Created by tara. Movie Management Services Implementation
 */
@Service
public class MovieServiceImpl implements IMovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private Environment environment;

    /**
     * Add Movie to DataBase
     * 1. Throw an exception if the input is Invalid or the movie name already exist in the System
     * 2. Otherwise, create an entry with the input Moview Details
     * @param movie
     * @return
     */
    @Override
    public Movie addMovie( Movie movie ) throws BadRequestException
    {
        if( movie == null )
        {
            LOGGER.error(ExceptionConstants.INVALID_MOVIE);
            throw new BadRequestException(ExceptionConstants.INVALID_MOVIE);
        }

        if( Utils.isNullOrNullString(movie.getName()) )
        {
            LOGGER.error(ExceptionConstants.MANDATORY_MOVIE_NAME);
            throw new BadRequestException(ExceptionConstants.MANDATORY_MOVIE_NAME);
        }

        movie.setName(movie.getName().trim());

        List<Movie> moviesWithSameName = movieRepository.findByName(movie.getName());

        if( moviesWithSameName != null && moviesWithSameName.size() > 0 )
        {
            LOGGER.error(ExceptionConstants.MANDATORY_MOVIE_NAME);
            throw new BadRequestException(ExceptionConstants.DUPLICATE_MOVIE);
        }

        movie.setCreatedDate(new Date());
        Movie addedMovie = movieRepository.save(movie);
        LOGGER.info("Movie {} is successfully added!", movie.getName());
        return addedMovie;
    }

    /**
     * Get Movies
     * 1. Check if the Search Key is received as an Input, If yes get the results based on the search key
     * 2. Otherwise get all the movies with the ascending order of name
     * @param searchKey
     * @param page
     * @param size
     * @Param sortBy
     * @Param orderBy
     * @return
     */
    @Override
    public Page<Movie> getMovies( String searchKey, Integer page, Integer size, String sortBy, String orderBy )
    {
        PageRequest pageRequest = createPageRequest(page, size, sortBy, orderBy);
        Page<Movie> movies;

        if( searchKey != null && !searchKey.isEmpty() ){
            searchKey = Utils.escapeWildCards(searchKey);
            movies = movieRepository.findByNameContaining(searchKey, pageRequest);
        }
        else{
            movies = movieRepository.findAll(pageRequest);
        }

        LOGGER.info("Getting movies is successful");

        return movies;
    }

    /**
     * Create PageRequest Object inorder to get the list according to the requested pagination
     * Parameters
     * 
     * @param page
     * @param size
     * @return
     */
    private PageRequest createPageRequest( Integer page, Integer size, String sortBy, String orderBy )
    {
        Sort.Direction sortDirection;

        if( page == null || page == 0 )
            page = Constants.PAGE;

        if( size == null || size == 0 )
            size = new Integer(environment.getProperty("movies.count.per.page"));

        if(!isValidateSortByColumn(sortBy) )
            sortBy = environment.getProperty("movies.default.sortby.column");

        if(!isValidateOrderBy(orderBy))
            orderBy = Constants.SORT_ASCENDING;

        if( orderBy.equalsIgnoreCase(Constants.SORT_ASCENDING) )
            sortDirection = Sort.Direction.ASC;
        else
            sortDirection = Sort.Direction.DESC;

        return new PageRequest(page - 1, size, sortDirection, sortBy);
    }

    /**
     * Validate Sort By Column sent as an input
     * 
     * @param sortBy
     * @return
     */
    private boolean isValidateSortByColumn( String sortBy )
    {
        if( !Utils.isNullOrNullString(sortBy) && (sortBy.equals(Constants.MOVIE_NAME_COLUMN) || sortBy.equals(Constants.MOVIE_RATINGS_COLUMN)) )
            return true;

        return false;
    }

    /**
     * Validate Order By Value
     *
     * @param sortBy
     * @return
     */
    private boolean isValidateOrderBy( String orderBy )
    {
        if( !Utils.isNullOrNullString(orderBy) && (orderBy.equalsIgnoreCase(Constants.SORT_ASCENDING) || orderBy.equalsIgnoreCase(Constants.SORT_DESCENDING)) )
            return true;

        return false;
    }

}
