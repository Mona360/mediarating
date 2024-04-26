package de.hatoka.mediarating.movie.internal.persistence;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MovieDao extends JpaRepository<MoviePO, Long>
{
    default Optional<MoviePO> findByExternalID(String externalID)
    {
        return findByMovieext(externalID);
    }

    /**
     * @param movieExternalID
     * @return movie found by externalid
     * @deprecated don't use it outside only for JpaRepository use {@link #findByExternalID(String)}
     */
    @Deprecated
    Optional<MoviePO> findByMovieext(String movieExternalID);

    Collection<MoviePO> findByUserref(String userRef);

}