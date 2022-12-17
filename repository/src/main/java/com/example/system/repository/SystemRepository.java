package com.example.system.repository;

import com.example.system.entity.SystemOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemRepository extends JpaRepository<SystemOptionEntity, String> {
}
