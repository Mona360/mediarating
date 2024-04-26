package tests.de.hatoka.mediarating.movie;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import de.hatoka.mediarating.movie.capi.MovieConfiguration;
import de.hatoka.common.capi.CommonConfiguration;
import de.hatoka.oidc.capi.IdentityProviderConfiguration;
import de.hatoka.user.capi.UserConfiguration;

@Configuration
@PropertySource("classpath:application-test.properties")
@EnableAutoConfiguration
@ImportAutoConfiguration({ MovieConfiguration.class, IdentityProviderConfiguration.class, UserConfiguration.class, CommonConfiguration.class })
public class MovieTestConfiguration
{
}
