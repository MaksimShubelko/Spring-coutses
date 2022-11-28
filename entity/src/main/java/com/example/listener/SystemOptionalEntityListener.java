package com.example.listener;

import com.example.system.entity.SystemOptionEntity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

@Component
@Slf4j
public class SystemOptionalEntityListener extends BaseLogEntityListener {

    public static final String AUDIT_ACTIVITY = "system_option";

    @Autowired
    public SystemOptionalEntityListener(AuditLogService auditLogService) {
        super(auditLogService);
    }

    @Override
    protected String getLogActivity() {
        return AUDIT_ACTIVITY;
    }

    @PostPersist
    protected void methodInvokedAfterPersist(Object entity) {
        super.methodInvokedAfterPersist(entity);
    }

    @PostUpdate
    protected void methodInvokedAfterUpdate(Object entity) {
        super.methodInvokedAfterUpdate(entity);
    }

    @PostRemove
    protected void methodInvokedAfterDelete(Object entity) {
        super.methodInvokedAfterDelete(entity);
    }
}


