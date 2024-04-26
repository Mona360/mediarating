package de.hatoka.mediarating.movie.capi;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import de.hatoka.mediarating.movie.internal.persistence.MovieDao;
import de.hatoka.mediarating.movie.internal.persistence.MoviePO;

@Configuration
@EntityScan(basePackageClasses = { MoviePO.class })
@EnableJpaRepositories(basePackageClasses = { MovieDao.class })
public class MovieConfiguration
{
    /**
     * Allow matrix parameter
     * @return adapted http fire wall
     */
    @Bean
    public HttpFirewall getHttpFirewall() {
        StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
        strictHttpFirewall.setAllowSemicolon(true);
        return strictHttpFirewall;
    }
}
