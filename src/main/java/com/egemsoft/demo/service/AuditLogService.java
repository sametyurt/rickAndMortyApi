package com.egemsoft.demo.service;

import com.egemsoft.demo.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public Integer getCountByRequestMethodAndRequestURI(String requestMethod, String requestURI) {
        return auditLogRepository.countAllByRequestMethodAndRequestURI(requestMethod, requestURI);
    }
}