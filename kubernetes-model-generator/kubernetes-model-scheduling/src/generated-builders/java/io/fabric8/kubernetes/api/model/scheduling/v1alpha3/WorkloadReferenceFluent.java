package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class WorkloadReferenceFluent<A extends io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String templateName;
  private String workloadName;

  public WorkloadReferenceFluent() {
  }
  
  public WorkloadReferenceFluent(WorkloadReference instance) {
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
  
  protected void copyInstance(WorkloadReference instance) {
    instance = instance != null ? instance : new WorkloadReference();
    if (instance != null) {
        this.withTemplateName(instance.getTemplateName());
        this.withWorkloadName(instance.getWorkloadName());
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
    WorkloadReferenceFluent that = (WorkloadReferenceFluent) o;
    if (!(Objects.equals(templateName, that.templateName))) {
      return false;
    }
    if (!(Objects.equals(workloadName, that.workloadName))) {
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
  
  public String getTemplateName() {
    return this.templateName;
  }
  
  public String getWorkloadName() {
    return this.workloadName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasTemplateName() {
    return this.templateName != null;
  }
  
  public boolean hasWorkloadName() {
    return this.workloadName != null;
  }
  
  public int hashCode() {
    return Objects.hash(templateName, workloadName, additionalProperties);
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
    if (!(templateName == null)) {
        sb.append("templateName:");
        sb.append(templateName);
        sb.append(",");
    }
    if (!(workloadName == null)) {
        sb.append("workloadName:");
        sb.append(workloadName);
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
  
  public A withTemplateName(String templateName) {
    this.templateName = templateName;
    return (A) this;
  }
  
  public A withWorkloadName(String workloadName) {
    this.workloadName = workloadName;
    return (A) this;
  }
  
}