/*
 * MultiTenantConnectionProvider.java
 *
 * Created on 10.08.2020
 *
 *
 */
package com.loggro.micronaut.multitenant;

import jakarta.inject.Singleton;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;

//import javax.inject.Singleton;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tariq Ahmed
 */
@Singleton
public class MultiTenantConnectionProvider extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    public static final String DEFAULT_TENANT_ID = "default";

    private Map<String, DataSource> map = new HashMap<>();

    @Override
    protected DataSource selectAnyDataSource() {
        return map.get(DEFAULT_TENANT_ID);
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        return map.get(tenantIdentifier) != null ? map.get(tenantIdentifier) : map.get(DEFAULT_TENANT_ID);
    }

    public void register(String dataSourceName, DataSource dataSource) {
        map.put(dataSourceName, dataSource);
    }

}