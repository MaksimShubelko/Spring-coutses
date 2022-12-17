package com.example.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class AuditLogServiceImpl implements AuditLogService {
    @Override
    public void createLogs(String activity, String message) {
        log.debug(activity, message);
    }
}
