package com.example.system.repository;

import com.example.system.entity.SystemLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemLogRepository extends JpaRepository<SystemLogEntity, Long> {
}
