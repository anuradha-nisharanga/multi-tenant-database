//package com.sample.Test.flyway;
//
//import com.sample.Test.Interceptor.TenantContext;
//import com.sample.Test.config.DataSourceConfig;
//import com.sample.Test.repository.DataSourceConfigRepository;
//import org.flywaydb.core.Flyway;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class FlywayMigrationInitializer {
//
//    @Autowired
//    private DataSourceConfigRepository dataSourceConfigRepository;
//
//    public void migrate(){
//        String tenant = TenantContext.getCurrentTenant();
//        DataSourceConfig config = dataSourceConfigRepository.findByName(tenant);
//
//        if (config != null) {
//
////            DataSourceBuilder factory = DataSourceBuilder
////                    .create()
////                    .username(config.getUsername())
////                    .password(config.getPassword())
////                    .url(config.getUrl());
////            DataSource dataSource = factory.build();
//            String scriptLocation = "db/migration/tenant";
//
//            Flyway flyway = Flyway.configure()
//                    .locations(scriptLocation)
//                    .baselineOnMigrate(Boolean.TRUE)
//                    .dataSource(config.getUrl(), config.getUsername(), config.getPassword() )
//                    .schemas(tenant)
//                    .load();
//
//            flyway.migrate();
//
//        }
//    }
//}
