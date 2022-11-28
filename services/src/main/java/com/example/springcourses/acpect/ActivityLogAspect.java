package com.example.springcourses.acpect;

import com.example.listener.AuditLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Aspect
@Component
public class ActivityLogAspect {

    @Autowired
    private AuditLogService auditLogService;
    private long timeToExecute;

    @After("@annotation(activityLog)")
    public void logAction(JoinPoint joinPoint, ActivityLog activityLog) {
        String activity = activityLog.activity();
        String message = activityLog.value();

        String[] names = StringUtils.substringsBetween(message, "{", "}");
        if (!ArrayUtils.isEmpty(names)) {
            message = prepareMessage(message, names, joinPoint);
        }
        log.debug("Logging activity {} msg {}", activity, message);
        auditLogService.createLogs(activity, message);
    }

    private String prepareMessage(String message, String[] names, JoinPoint joinPoint) {
        int size = names.length;
        String[] values = new String[size];

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Object value = getParameter(joinPoint, name);
            String valueStr = Objects.isNull(value) ? "UNDERFINED" : String.valueOf(value);
            values[i] = valueStr;
            names[i] = "{" + name + "}";
        }

        return StringUtils.replaceEach(message, names, values);
    }

    private Object getParameter(JoinPoint joinPoint, String name) {
        if (Objects.nonNull(joinPoint) && joinPoint.getSignature() instanceof MethodSignature
                && Objects.nonNull(name)) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            String[] params = methodSignature.getParameterNames();
            for (int i = 0; i < params.length; i++) {
                if (Objects.nonNull(params[i]) && params[i].equals(name)) {
                    Object[] objects = joinPoint.getArgs();
                    return objects[i];
                }
            }
        }
        return null;
    }
}
