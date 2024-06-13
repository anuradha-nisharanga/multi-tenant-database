package com.sample.Test.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver {
//    public
    public static final String defaultTenant ="public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        log.info("calling resolveCurrent Tenant Identifier");
        String tenant = TenantContext.getCurrentTenant();
        if (tenant != null){
            log.info("TenantSchemaResolver:{}",tenant);
            return tenant;
        }
        else {
            log.info("TenantSchemaResolver Default tenant:{}",tenant);
            return defaultTenant;
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        log.info("calling validateExistingCurrentSessions in tenant schema resolver");
        return true;
    }
}
