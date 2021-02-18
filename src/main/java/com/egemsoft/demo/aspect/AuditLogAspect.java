package com.egemsoft.demo.aspect;

import com.egemsoft.demo.entity.AuditLog;
import com.egemsoft.demo.repository.AuditLogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static com.egemsoft.demo.entity.AuditLog.AuditLogBuilder.anAuditLog;

/***
 * AuditLogAspect sınıfı atılan isteklerden sonra (@After) tüm crud istekleri ve controller paketinin altındaki
 * methodu, url ve bodysini h2 veritabanına yazmaktadır.
 */
@Aspect
@Component
public class AuditLogAspect {

    private final AuditLogRepository auditLogRepository;
    private final ObjectMapper objectMapper;

    public AuditLogAspect(
            AuditLogRepository auditLogRepository,
            ObjectMapper objectMapper
    ) {
        this.auditLogRepository = auditLogRepository;
        this.objectMapper = objectMapper;
    }

    /***
     * Bu metot after annatationı kullanılarak aşağıda belirtilen istekler
     * ve bu isteklerin controller paketinin altında olması durumunda loglama işlemini
     * h2 veritabanına yapar.
     * @param joinPoint
     * @throws JsonProcessingException
     */
    @After("(@annotation(org.springframework.web.bind.annotation.PostMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.PutMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.DeleteMapping))" +
            "&& within(com.egemsoft.demo.controller.*)")
    public void audit(final JoinPoint joinPoint) throws JsonProcessingException {
        AuditLog auditLog = buildAuditLogFrom(joinPoint.getArgs());
        auditLogRepository.save(auditLog);
    }

    /***
     * istek atılan endpointin istenilen özellikleri set edilerek build alınır
     * build metotu audit entity sınıfını set eder
     * @param args
     * @return
     * @throws JsonProcessingException
     */
    private AuditLog buildAuditLogFrom(Object[] args) throws JsonProcessingException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        // request.getHeader()
        return anAuditLog()
                .requestMethod(request.getMethod())
                .requestURI(request.getRequestURI())
                .requestBody(requestBody(args))
                .build();
    }

    private String requestBody(Object[] args) throws JsonProcessingException {
        return Objects.isNull(args) || args.length == 0 ? "" : objectMapper.writeValueAsString(args);
    }
}