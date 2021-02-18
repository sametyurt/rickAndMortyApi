package com.egemsoft.demo.controller;

import com.egemsoft.demo.model.report.UrlRequestCountRequest;
import com.egemsoft.demo.service.AuditLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Burada h2 veritabanında tutulan logların istenilen bilgilere göre
 * repo kullanılarak gösterilmesini sağlar
 */
@RestController
@RequestMapping("/api/report")
public class AuditLogController {

    private final AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    /***
     * Bu metot isteğin türünü ve endpointin adını alarak kaç defa istek atıldığını
     * repo sayesinde döndürür.
     * @param request url request body
     * @return metot tipine ve hangi endpointe kaç tane istek atılıdğını döndürür
     */
    @GetMapping("/url-request-count")
    public Integer getUrlRequestCount(UrlRequestCountRequest request) {
        return auditLogService.getCountByRequestMethodAndRequestURI(request.getRequestMethod(), request.getRequestURI());
    }
}