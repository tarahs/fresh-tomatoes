package com.slalom.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import com.slalom.exception.BadRequestException;
import com.slalom.beans.Movie;
import com.slalom.constant.ExceptionConstants;
import com.slalom.repository.MovieRepository;
import com.slalom.service.impl.MovieServiceImpl;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tara on 10/27/16.
 */
@RunWith( PowerMockRunner.class )
public class MovieServiceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Mock
    MovieRepository movieRepository;

    @Mock
    Environment environment;

    @InjectMocks
    MovieServiceImpl movieService;

    Movie movie;

    PageRequest pageRequest;

    Page<Movie> movies;

    List<Movie> moviesList;

    @Before
    public void init()
    {
        movie = mockMovie("Fusion", 4.5F,"","Continuing the global exploits in the unstoppable franchise built on speed, Vin Diesel, Paul Walker and Dwayne Johnson lead the returning cast of Fast & Furious 7" );
        when(movieRepository.findByName(anyString())).thenReturn(null);
    }

    private Movie mockMovie(String name, Float ratings, String url, String description){
        Movie movie = new Movie();
        movie.setName(name);
        movie.setRatings(ratings);
        movie.setUrl(url);
        movie.setDescription(description);
        return movie;
    }

    private void mockPageRequest(int page, int size, Sort.Direction order, String sortColumn){
        pageRequest = new PageRequest(page,size,order,sortColumn);
    }

    private void mockMovies(){

        Movie movie1 = mockMovie("Avengers - Age of Ultron", 4.5F, "http://resizing.flixster.com/s8kIQtOhr36lGPkcUGCVeqVWw9Y=/180x270/dkpu1ddg7pbsk.cloudfront.net/movie/11/19/01/11190143_ori.jpg","When Tony Stark jumpstarts a dormant peacekeeping program, things go awry and Earth's Mightiest Heroes, including Iron Man, Captain America, Thor, The Incredible Hulk, Black Widow and Hawkeye, are put to the ultimate test as they battle to save the planet from destruction at the hands of the villainous Ultron." );

        Movie movie2 = mockMovie("Furious 7", 4.0F, "http://resizing.flixster.com/tBSZ6CjTf-YkvC4o-VC0JFIY-vk=/170x270/dkpu1ddg7pbsk.cloudfront.net/movie/11/18/14/11181482_ori.jpg", "Continuing the global exploits in the unstoppable franchise built on speed, Vin Diesel, Paul Walker and Dwayne Johnson lead the returning cast of Fast & Furious 7. James Wan directs this chapter of the hugely successful series that also welcomes back favorites Michelle Rodriguez, Jordana Brewster, Tyrese Gibson, Chris Ludacris Bridges, Elsa Pataky and Lucas Black. They are joined by international action stars new to the franchise including Jason Statham, Djimon Hounsou, Tony Jaa, Ronda Rousey and Kurt Russell.");

        Movie movie3 = mockMovie("Tomorrowland",3.5F, "http://resizing.flixster.com/dH2TEhqdJ5A6xxV3mQBPZ_1yEac=/180x267/dkpu1ddg7pbsk.cloudfront.net/movie/11/19/06/11190666_ori.jpg", "From Disney comes two-time Oscar (R) winner Brad Bird's riveting, mystery adventure Tomorrowland, starring Academy Award (R) winner George Clooney. Bound by a shared destiny, former boy-genius Frank (Clooney), jaded by disillusionment, and Casey (Britt Robertson), a bright, optimistic teen bursting with scientific curiosity, embark on a danger-filled mission to unearth the secrets of an enigmatic place somewhere in time and space known only as Tomorrowland. What they must do there changes the world-and them-forever. Featuring a screenplay by Lost writer and co-creator Damon Lindelof and Brad Bird, from a story by Lindelof & Bird & Jeff Jensen, Tomorrowland promises to take audiences on a thrill ride of nonstop adventures through new dimensions that have only been dreamed of.(C) Walt Disney"  );

        Movie movie4 = mockMovie("Pitch Perfect 2", 3.0F, "http://resizing.flixster.com/CSaptdyboc7JUz266OumNJHeAl4=/180x257/dkpu1ddg7pbsk.cloudfront.net/movie/11/19/12/11191224_ori.jpg","Surprise hit Pitch Perfect gets sequelized in this Universal Pictures production once again scripted by Kay Cannon. ~ Jeremy Wheeler, Rovi");

        moviesList = new ArrayList<>();
        moviesList.add(movie1);
        moviesList.add(movie2);
        moviesList.add(movie3);
        moviesList.add(movie4);

        movies = new PageImpl<Movie>(moviesList,null,moviesList.size());
    }

    //--------    TEST CASES FOR ADD MOVIE    -----------

    @Test
    public void addMovie_withEmptyInput_throwBadRequestException() throws BadRequestException
    {
        expectedEx.expect(BadRequestException.class);
        expectedEx.expectMessage(ExceptionConstants.INVALID_MOVIE);
        movieService.addMovie(null);
    }

    @Test
    public void addMovie_withEmptyMovieName_throwBadRequestException() throws BadRequestException
    {
        expectedEx.expect(BadRequestException.class);
        expectedEx.expectMessage(ExceptionConstants.MANDATORY_MOVIE_NAME);

        movie.setName("");
        movieService.addMovie(movie);
    }

    @Test
    public void addMovie_withDuplicateMovieName_throwBadRequestExceptionWithDuplicateErrorMessage()
            throws BadRequestException
    {

        expectedEx.expect(BadRequestException.class);
        expectedEx.expectMessage(ExceptionConstants.DUPLICATE_MOVIE);

        mockMovies();
        when(movieRepository.findByName(anyString())).thenReturn(moviesList);
        movieService.addMovie(movie);
    }

    @Test
    public void addMovie_withValidMovie_addSuccessfully() throws BadRequestException
    {
        when(movieRepository.save((Movie) anyObject())).thenReturn(movie);
        Movie addedMovie = movieService.addMovie(movie);
        Assert.assertEquals(movie, addedMovie);
    }

}
