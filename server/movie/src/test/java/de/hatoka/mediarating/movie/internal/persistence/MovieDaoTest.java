package de.hatoka.mediarating.movie.internal.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tests.de.hatoka.mediarating.movie.MovieTestConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MovieTestConfiguration.class })
public class MovieDaoTest
{

    @Autowired
    private MovieDao dao;

    @Test
    public void testCRUD()
    {
        MoviePO moviePO = new MoviePO();
        moviePO.setName("Matrix 1");
        moviePO.setExternalID("Matrix");
        moviePO.setUserRef("Mona");
        moviePO.setRating(10);
        moviePO.setYearOfPublication(1999);
        dao.save(moviePO);
        Optional<MoviePO> findMoviePO= dao.findByExternalID("Matrix");
        assertTrue(findMoviePO.isPresent(), "movie gefunden");
        assertEquals(moviePO, findMoviePO.get());
    }
    @Test
    public void test2Movies()
    {
        MoviePO moviePO = new MoviePO();
        moviePO.setName("Matrix 2");
        moviePO.setExternalID("Matrix");
        moviePO.setUserRef("Mona");
        moviePO.setRating(10);
        moviePO.setYearOfPublication(2001);
        dao.save(moviePO);
        dao.delete(moviePO);
    }

}
