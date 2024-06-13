//package com.sample.Test.flyway;
//
//import com.sample.Test.Interceptor.TenantContext;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import static com.sample.Test.Interceptor.TenantSchemaResolver.defaultTenant;
//
//public class RoutingDataSource extends AbstractRoutingDataSource {
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return TenantContext.getCurrentTenant() != null ? TenantContext.getCurrentTenant() : defaultTenant;
//    }
//}
