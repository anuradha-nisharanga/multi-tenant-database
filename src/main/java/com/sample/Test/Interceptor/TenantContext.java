package com.sample.Test.Interceptor;


import lombok.extern.slf4j.Slf4j;

public class TenantContext {
    public static final String DEFAULT_TENANT_ID = "multi_tenant_V1";
    private static ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();
    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        currentTenant.set(null);
    }
}
