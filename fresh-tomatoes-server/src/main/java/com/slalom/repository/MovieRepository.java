package com.slalom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.slalom.beans.Movie;

/**
 * Created by tara.
 */
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Override
    Movie save( Movie movie );

    @Override
    Movie findOne( Integer id );

    Movie findByName( String name );

    Page<Movie> findByNameContaining( String name, Pageable pageRequest );

    Page<Movie> findAll( Pageable pageRequest );

}
