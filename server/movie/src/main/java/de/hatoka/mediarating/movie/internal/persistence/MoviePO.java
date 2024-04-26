package de.hatoka.mediarating.movie.internal.persistence;

import java.io.Serializable;
import java.util.Objects;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "movies", uniqueConstraints = { @UniqueConstraint(columnNames = { "movie_ext" }) })
public class MoviePO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * Internal identifier for persistence only
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "movie_id")
    private Long id;

    /**
     * Initial owner of the movie
     */
    @NotNull
    @Column(name = "user_ref", nullable = false)
    private String userref;

    /**
     * External key of movie
     */
    @NotNull
    @Column(name = "movie_ext", nullable = false)
    private String movieext;

    /**
     * Readable name of movie
     */
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "year_of_publication", nullable = true)
    private Integer yearOfPublication;
    @Column(name = "rating", nullable = true)
    private Integer rating;


    public MoviePO()
    {
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(movieext);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MoviePO other = (MoviePO)obj;
        return Objects.equals(movieext, other.movieext);
    }

    public String getUserRef()
    {
        return userref;
    }

    public void setUserRef(String userRef)
    {
        this.userref = userRef;
    }

    public String getExternalID()
    {
        return movieext;
    }

    public void setExternalID(String movieExternalID)
    {
        this.movieext = movieExternalID;
    }

    public Integer getYearOfPublication()
    {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication)
    {
        this.yearOfPublication = yearOfPublication;
    }
    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }
}
