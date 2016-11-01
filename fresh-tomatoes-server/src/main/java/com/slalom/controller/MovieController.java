package com.slalom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.slalom.exception.ActionFailureException;
import com.slalom.beans.Movie;
import com.slalom.controller.base.BaseController;
import com.slalom.service.IMovieService;

/**
 * Created by tara. Movie Controller for handling all requests related to Movie
 */
@Controller
@RequestMapping( "/movies" )
public class MovieController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    IMovieService movieService;

    /**
     * Add Movie to the System
     * 
     * @param movie
     * @return
     */
    @RequestMapping( produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.PUT )
    public ResponseEntity<?> addMovie( @RequestBody Movie movie )
    {
        LOGGER.info("Received request to add movie");
        try
        {
            return buildResponse(movieService.addMovie(movie));
        }
        catch( ActionFailureException e )
        {
            return buildError(e);
        }
        catch( Exception e )
        {
            return buildGlobalError(e);
        }
    }

    /**
     * Get all the Movies
     * 
     * @param page
     * @param size
     * @param searchKey
     * @return
     */
    @RequestMapping( produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET )
    public ResponseEntity<?> getMovies( @RequestParam( value = "page", required = false ) Integer page,
            @RequestParam( value = "size", required = false ) Integer size,
            @RequestParam( value = "searchKey", required = false ) String searchKey,
            @RequestParam( value = "sortByColumn", required = false ) String sortByColumn,
            @RequestParam( value = "orderBy",required = false ) String orderBy )
    {
        LOGGER.info("Received request to get movies");
        try
        {
            return buildResponse(movieService.getMovies(searchKey, page, size, sortByColumn, orderBy));
        }
        catch( Exception e )
        {
            return buildGlobalError(e);
        }
    }

}
