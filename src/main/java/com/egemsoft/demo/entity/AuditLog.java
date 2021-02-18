package com.egemsoft.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/***
 * h2 veritabanına logların tutulacağı table oluşturuldu.
 * Daha fazla column eklenebilir AuditLogAspect sınıfında build alırken o kısım da eklenerek
 * log tutulur.
 */
@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String requestMethod;

    @Column
    private String requestURI;

    @Column
    private String requestBody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public static final class AuditLogBuilder {
        private Integer id;
        private String requestMethod;
        private String requestURI;
        private String requestBody;

        private AuditLogBuilder() {
        }

        public static AuditLogBuilder anAuditLog() {
            return new AuditLogBuilder();
        }

        public AuditLogBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public AuditLogBuilder requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }

        public AuditLogBuilder requestURI(String requestURI) {
            this.requestURI = requestURI;
            return this;
        }

        public AuditLogBuilder requestBody(String requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        /***
         * By metot gelen isteğin bilgilerinin set edildiği kısımdır.
         * @return AuditLog türünde bir değişken döndürür. Tabloya yazılacak veriler burada oluşturulur.
         */
        public AuditLog build() {
            AuditLog auditLog = new AuditLog();
            auditLog.setId(id);
            auditLog.setRequestMethod(requestMethod);
            auditLog.setRequestURI(requestURI);
            auditLog.setRequestBody(requestBody);
            return auditLog;
        }
    }
}