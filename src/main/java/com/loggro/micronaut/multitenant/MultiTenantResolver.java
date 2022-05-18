/**
 * TestFilter.java
 * <p>
 * Created on 29.07.20
 * <p>
 *
 */
package com.loggro.micronaut.multitenant;


import io.micronaut.multitenancy.exceptions.TenantNotFoundException;
import io.micronaut.multitenancy.tenantresolver.TenantResolver;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

//import javax.inject.Inject;
//import javax.inject.Singleton;
import java.io.Serializable;

/**
 * @author Tariq Ahmed
 */
@Singleton
public class MultiTenantResolver implements CurrentTenantIdentifierResolver
{
    @Inject
    TenantResolver resolver;

    @Override
    public String resolveCurrentTenantIdentifier() {
        try {
            Serializable tenantIdRaw = resolver.resolveTenantIdentifier();
            String tenantId = (String) tenantIdRaw;
            if(tenantId.equalsIgnoreCase("example")) {
                tenantId = MultiTenantConnectionProvider.DEFAULT_TENANT_ID;
            }
            return tenantId;
        } catch (TenantNotFoundException notFoundException) {
            return MultiTenantConnectionProvider.DEFAULT_TENANT_ID;
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
