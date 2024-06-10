package com.sample.Test.repository;

import com.sample.Test.config.DataSourceConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Long> {

    DataSourceConfig findByName(String name);
}
