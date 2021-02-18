package com.egemsoft.demo.repository;

import com.egemsoft.demo.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

//    List<AuditLog> findAllByRequestMethodAndRequestURIOrderById(String requestMethod, String requestURI);

    Integer countAllByRequestMethod(String requestMethod);

    Integer countAllByRequestURI(String requestURI);

    /***
     * countAllBy kısmı sql olarak count komutunu temsil eder
     * Bydan sonra yer alan kısım filtreleme kısmıdır
     * @param requestMethod metot tipi
     * @param requestURI endpoint adı
     * @return kaç adet istek atıldığını döndürür
     */
    Integer countAllByRequestMethodAndRequestURI(String requestMethod, String requestURI);
}