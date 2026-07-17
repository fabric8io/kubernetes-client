package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class HealthCheckFluent<A extends io.fabric8.openshift.api.model.operator.v1.HealthCheckFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String advisorURI;
  private String description;
  private String state;
  private Integer totalRisk;

  public HealthCheckFluent() {
  }
  
  public HealthCheckFluent(HealthCheck instance) {
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
  
  protected void copyInstance(HealthCheck instance) {
    instance = instance != null ? instance : new HealthCheck();
    if (instance != null) {
        this.withAdvisorURI(instance.getAdvisorURI());
        this.withDescription(instance.getDescription());
        this.withState(instance.getState());
        this.withTotalRisk(instance.getTotalRisk());
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
    HealthCheckFluent that = (HealthCheckFluent) o;
    if (!(Objects.equals(advisorURI, that.advisorURI))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
      return false;
    }
    if (!(Objects.equals(totalRisk, that.totalRisk))) {
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
  
  public String getAdvisorURI() {
    return this.advisorURI;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getState() {
    return this.state;
  }
  
  public Integer getTotalRisk() {
    return this.totalRisk;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdvisorURI() {
    return this.advisorURI != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasTotalRisk() {
    return this.totalRisk != null;
  }
  
  public int hashCode() {
    return Objects.hash(advisorURI, description, state, totalRisk, additionalProperties);
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
    if (!(advisorURI == null)) {
        sb.append("advisorURI:");
        sb.append(advisorURI);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(totalRisk == null)) {
        sb.append("totalRisk:");
        sb.append(totalRisk);
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
  
  public A withAdvisorURI(String advisorURI) {
    this.advisorURI = advisorURI;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  
  public A withTotalRisk(Integer totalRisk) {
    this.totalRisk = totalRisk;
    return (A) this;
  }
  
}