package com.example.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class BaseLogEntityListener {

    private final AuditLogService auditLogService;

    @Autowired
    public BaseLogEntityListener(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    protected abstract String getLogActivity();

    protected void methodInvokedAfterPersist(Object entity) {
        log.debug("Created " + entity);
        auditLogService.createLogs(getLogActivity(), "Created " + entity);
    }

    protected void methodInvokedAfterUpdate(Object entity) {
        log.debug("Updated " + entity);
        auditLogService.createLogs(getLogActivity(), "Updated " + entity);
    }

    protected void methodInvokedAfterDelete(Object entity) {
        log.debug("Deleted " + entity);
        auditLogService.createLogs(getLogActivity(), "Deleted " + entity);
    }

}
