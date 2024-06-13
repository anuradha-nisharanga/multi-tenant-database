package com.sample.Test.service.impl;

import com.sample.Test.Interceptor.TenantContext;
import com.sample.Test.config.DataSourceConfig;
import com.sample.Test.repository.DataSourceConfigRepository;
import com.sample.Test.service.MigrationService;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
@Slf4j
public class MigrationServiceImpl implements MigrationService {

    private final DataSourceConfigRepository dataSourceConfigRepository;
    @Autowired
    public MigrationServiceImpl(DataSourceConfigRepository dataSourceConfigRepository) {
        this.dataSourceConfigRepository = dataSourceConfigRepository;
    }

    @Override
    public void addMigrationFile() {
//        log.info("schema create serviceImpl class called");
//        String tenant = TenantContext.getCurrentTenant();
//        DataSourceConfig config = dataSourceConfigRepository.findByName(tenant);
//        log.info("config details {} | tenant details {} ", config, tenant);
//        if (config != null) {
//            String scriptLocation = "db/migration/";
//            Flyway flyway = Flyway.configure()
//                    .locations(scriptLocation)
//                    .baselineOnMigrate(Boolean.TRUE)
//                    .dataSource(config.getUrl(), config.getUsername(), config.getPassword())
//                    .schemas("public")
//                    .load();
//            flyway.migrate();
//            log.info("flyway details {}", flyway);
//        }
    }

    @Override
    public void updateAll() {
        List<DataSourceConfig> configList = dataSourceConfigRepository.findAll();
        String scriptLocation = "db/migration/";
        for (DataSourceConfig config : configList){
            log.info("config details {} ", config);
            Flyway flyway = Flyway.configure()
                    .locations(scriptLocation)
                    .baselineOnMigrate(Boolean.TRUE)
                    .dataSource(config.getUrl(), config.getUsername(), config.getPassword())
                    .schemas("public")
                    .load();
            flyway.migrate();
            log.info("flyway details {}", flyway);
        }
    }
}
