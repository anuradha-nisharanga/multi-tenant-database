//package com.sample.Test.flyway;
//
//import com.sample.Test.Interceptor.TenantContext;
//import org.flywaydb.core.Flyway;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class FlywayConfiguration {
//
//    private final String flywayUrl;
//    private final String flywayUser;
//    private final String flywayPassword;
//    private final String flywayDriver;
//
//    DataSource dataSource;
//
//    public FlywayConfiguration(DataSource dataSource,
//                               @Value("${flyway.url}") String flywayUrl,
//                               @Value("${flyway.user}") String flywayUser,
//                               @Value("${flyway.password}") String flywayPassword,
//                               @Value("${flyway.driver-class-name}") String flywayDriver){
//
//        this.flywayUrl = flywayUrl;
//        this.flywayUser = flywayUser;
//        this.flywayPassword = flywayPassword;
//        this.flywayDriver = flywayDriver;
//        this.dataSource = createFlywayDataSource();
//    }
//    String scriptLocation = "db/migration/tenant";
//    @Bean
//    FlywayBuilder flywayBuilder() {
//        return new FlywayBuilder(dataSource);
//    }
//    @Bean
//    Flyway flyway() {
//        Flyway flyway = Flyway.configure()
//                .locations(scriptLocation)
//                .baselineOnMigrate(Boolean.TRUE)
//                .dataSource(flywayUrl, flywayUser, flywayPassword )
//                .schemas(TenantContext.DEFAULT_TENANT_ID)
//                .load();
//        flyway.migrate();
//        return flyway;
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(TenantDomain tenantDomain,
//                                        DataSource dataSource) {
//        return args -> {
//            tenantDomain.getAllTenants().forEach(tenant -> {
//                Flyway flyway = flywayBuilder()
//                        .createFlyway(tenant);
//                flyway.migrate();
//            });
//        };
//    }
//
//    private DataSource createFlywayDataSource() {
//        DataSourceBuilder factory = DataSourceBuilder
//                .create()
//                .driverClassName(flywayDriver)
//                .url(flywayUrl)
//                .username(flywayUser)
//                .password(flywayPassword);
//        DataSource ds = factory.build();
//        return ds;
//    }
//}
