package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class APIRequestCountSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCountSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long numberOfUsersToReport;

  public APIRequestCountSpecFluent() {
  }
  
  public APIRequestCountSpecFluent(APIRequestCountSpec instance) {
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
  
  protected void copyInstance(APIRequestCountSpec instance) {
    instance = instance != null ? instance : new APIRequestCountSpec();
    if (instance != null) {
        this.withNumberOfUsersToReport(instance.getNumberOfUsersToReport());
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
    APIRequestCountSpecFluent that = (APIRequestCountSpecFluent) o;
    if (!(Objects.equals(numberOfUsersToReport, that.numberOfUsersToReport))) {
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
  
  public Long getNumberOfUsersToReport() {
    return this.numberOfUsersToReport;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNumberOfUsersToReport() {
    return this.numberOfUsersToReport != null;
  }
  
  public int hashCode() {
    return Objects.hash(numberOfUsersToReport, additionalProperties);
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
    if (!(numberOfUsersToReport == null)) {
        sb.append("numberOfUsersToReport:");
        sb.append(numberOfUsersToReport);
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
  
  public A withNumberOfUsersToReport(Long numberOfUsersToReport) {
    this.numberOfUsersToReport = numberOfUsersToReport;
    return (A) this;
  }
  
}