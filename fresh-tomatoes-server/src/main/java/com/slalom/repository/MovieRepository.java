package com.slalom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.slalom.beans.Movie;

import java.util.List;

/**
 * Created by tara.
 * Spring Data Repository which supported CRUD operations on Movie Entity
 */
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Override
    Movie save( Movie movie );

    @Override
    Movie findOne( Integer id );

    List<Movie> findByName( String name );

    Page<Movie> findByNameContaining( String name, Pageable pageRequest );

    Page<Movie> findAll( Pageable pageRequest );

}
