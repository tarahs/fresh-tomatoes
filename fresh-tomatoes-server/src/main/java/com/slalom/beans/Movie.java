package com.slalom.beans;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by tara.
 */
@Entity
@Table( name = "movie" )
public class Movie {

    private Integer id;
    private String name;
    private String url;
    private String description;
    private Float ratings;
    private Date createdDate;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id" )
    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    @Column( name = "name" )
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    @Column( name = "url" )
    public String getUrl()
    {
        return url;
    }

    public void setUrl( String url )
    {
        this.url = url;
    }

    @Column( name = "description", columnDefinition = "TEXT" )
    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    @Column( name = "rating" )
    public Float getRatings()
    {
        return ratings;
    }

    public void setRatings( Float ratings )
    {
        this.ratings = ratings;
    }

    @JsonIgnore
    @Column( name = "created_date" )
    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate( Date createdDate )
    {
        this.createdDate = createdDate;
    }
}
