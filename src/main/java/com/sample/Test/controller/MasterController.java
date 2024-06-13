package com.sample.Test.controller;

import com.sample.Test.Interceptor.TenantContext;
import com.sample.Test.service.MigrationService;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/db")
@CrossOrigin(origins = "*")
@Slf4j
public class MasterController {
    private final MigrationService migrationService;
    @Autowired
    public MasterController(MigrationService migrationService) {
        this.migrationService = migrationService;
    }

    @PostMapping("/migration")
    public void addMigrationFiles(){
        log.info("add migrations");
        migrationService.addMigrationFile();
    }

    @PostMapping("/migrateAll")
    public void updateHistory(){
        migrationService.updateAll();
    }
}
