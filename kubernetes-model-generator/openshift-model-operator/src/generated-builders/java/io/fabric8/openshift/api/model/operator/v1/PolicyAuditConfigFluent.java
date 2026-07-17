package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PolicyAuditConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.PolicyAuditConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String destination;
  private Long maxFileSize;
  private Integer maxLogFiles;
  private Long rateLimit;
  private String syslogFacility;

  public PolicyAuditConfigFluent() {
  }
  
  public PolicyAuditConfigFluent(PolicyAuditConfig instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(PolicyAuditConfig instance) {
    instance = instance != null ? instance : new PolicyAuditConfig();
    if (instance != null) {
        this.withDestination(instance.getDestination());
        this.withMaxFileSize(instance.getMaxFileSize());
        this.withMaxLogFiles(instance.getMaxLogFiles());
        this.withRateLimit(instance.getRateLimit());
        this.withSyslogFacility(instance.getSyslogFacility());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    PolicyAuditConfigFluent that = (PolicyAuditConfigFluent) o;
    if (!(Objects.equals(destination, that.destination))) {
      return false;
    }
    if (!(Objects.equals(maxFileSize, that.maxFileSize))) {
      return false;
    }
    if (!(Objects.equals(maxLogFiles, that.maxLogFiles))) {
      return false;
    }
    if (!(Objects.equals(rateLimit, that.rateLimit))) {
      return false;
    }
    if (!(Objects.equals(syslogFacility, that.syslogFacility))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getDestination() {
    return this.destination;
  }
  
  public Long getMaxFileSize() {
    return this.maxFileSize;
  }
  
  public Integer getMaxLogFiles() {
    return this.maxLogFiles;
  }
  
  public Long getRateLimit() {
    return this.rateLimit;
  }
  
  public String getSyslogFacility() {
    return this.syslogFacility;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDestination() {
    return this.destination != null;
  }
  
  public boolean hasMaxFileSize() {
    return this.maxFileSize != null;
  }
  
  public boolean hasMaxLogFiles() {
    return this.maxLogFiles != null;
  }
  
  public boolean hasRateLimit() {
    return this.rateLimit != null;
  }
  
  public boolean hasSyslogFacility() {
    return this.syslogFacility != null;
  }
  
  public int hashCode() {
    return Objects.hash(destination, maxFileSize, maxLogFiles, rateLimit, syslogFacility, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(destination == null)) {
        sb.append("destination:");
        sb.append(destination);
        sb.append(",");
    }
    if (!(maxFileSize == null)) {
        sb.append("maxFileSize:");
        sb.append(maxFileSize);
        sb.append(",");
    }
    if (!(maxLogFiles == null)) {
        sb.append("maxLogFiles:");
        sb.append(maxLogFiles);
        sb.append(",");
    }
    if (!(rateLimit == null)) {
        sb.append("rateLimit:");
        sb.append(rateLimit);
        sb.append(",");
    }
    if (!(syslogFacility == null)) {
        sb.append("syslogFacility:");
        sb.append(syslogFacility);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withDestination(String destination) {
    this.destination = destination;
    return (A) this;
  }
  
  public A withMaxFileSize(Long maxFileSize) {
    this.maxFileSize = maxFileSize;
    return (A) this;
  }
  
  public A withMaxLogFiles(Integer maxLogFiles) {
    this.maxLogFiles = maxLogFiles;
    return (A) this;
  }
  
  public A withRateLimit(Long rateLimit) {
    this.rateLimit = rateLimit;
    return (A) this;
  }
  
  public A withSyslogFacility(String syslogFacility) {
    this.syslogFacility = syslogFacility;
    return (A) this;
  }
  
}