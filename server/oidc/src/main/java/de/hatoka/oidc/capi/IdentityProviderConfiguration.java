package de.hatoka.oidc.capi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import de.hatoka.oidc.capi.event.UserEventListener;
import de.hatoka.oidc.internal.business.IdentityProviderBORepositoryImpl;
import de.hatoka.oidc.internal.persistence.IdentityProviderDao;
import de.hatoka.oidc.internal.persistence.IdentityProviderPO;
import de.hatoka.oidc.internal.remote.IdentityProviderController;

@Configuration
@EntityScan(basePackageClasses = { IdentityProviderPO.class })
@EnableJpaRepositories(basePackageClasses = { IdentityProviderDao.class })
@ComponentScan(basePackageClasses = { IdentityProviderBORepositoryImpl.class, IdentityProviderController.class, UserEventListener.class })
public class IdentityProviderConfiguration implements WebMvcConfigurer
{
    @Value("${oidc.identityprovider.authenticationToken}")
    private String oidcAuthenticationToken;
    @Value("${oidc.identityprovider.environment}")
    private String environment;
    @Value("${oidc.identityprovider.fakeUserId}")
    private String fakeUserId;

    public String getOidcAuthenticationToken()
    {
        return oidcAuthenticationToken;
    }

    public String getFakeUserId()
    {
        return fakeUserId;
    }

    public boolean isDevelopmentEnvironment()
    {
        return "development".equals(environment);
    }
}
