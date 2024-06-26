package com.sample.Test.config;

import com.sample.Test.repository.DataSourceConfigRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class TenantDataSource{

    @Autowired
    private DataSourceConfigRepository configRepo;

    private HashMap<String, DataSource> dataSources = new HashMap<>();

    public DataSource getDataSource(String name) {

        if (dataSources.get(name) != null) {
            log.info("calling get Data Source method in Tenant DataSource");
            return dataSources.get(name);
        }
        DataSource dataSource = createDataSource(name);
        if (dataSource != null) {
            log.info("calling create Data Source method in Tenant DataSource");
            dataSources.put(name, dataSource);
        }
        return dataSource;
    }

    @PostConstruct
    public Map<String, DataSource> getAll() {
        log.info("calling getAll method in Tenant DataSource");
        List<DataSourceConfig> configList = configRepo.findAll();
        log.info("Tenant Data Source class config List {}", configList);
        Map<String, DataSource> result = new HashMap<>();
        for (DataSourceConfig config : configList) {
            DataSource dataSource = getDataSource(config.getName());
            result.put(config.getName(), dataSource);
        }
        return result;
    }

    private DataSource createDataSource(String name) {
        log.info("calling createDataSource method in Tenant DataSource");
        DataSourceConfig config = configRepo.findByName(name);
        log.info("Tenant Data Source class config {}", config);
        if (config != null) {
            DataSourceBuilder factory = DataSourceBuilder
                    .create().driverClassName(config.getDriverClassName())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getUrl());
            DataSource ds = factory.build();
            return ds;
        }
        return null;
    }
}
