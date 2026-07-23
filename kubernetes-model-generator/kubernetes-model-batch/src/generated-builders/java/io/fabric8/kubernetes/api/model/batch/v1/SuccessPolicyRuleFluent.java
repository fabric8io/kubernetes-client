package io.fabric8.kubernetes.api.model.batch.v1;

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
public class SuccessPolicyRuleFluent<A extends io.fabric8.kubernetes.api.model.batch.v1.SuccessPolicyRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer succeededCount;
  private String succeededIndexes;

  public SuccessPolicyRuleFluent() {
  }
  
  public SuccessPolicyRuleFluent(SuccessPolicyRule instance) {
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
  
  protected void copyInstance(SuccessPolicyRule instance) {
    instance = instance != null ? instance : new SuccessPolicyRule();
    if (instance != null) {
        this.withSucceededCount(instance.getSucceededCount());
        this.withSucceededIndexes(instance.getSucceededIndexes());
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
    SuccessPolicyRuleFluent that = (SuccessPolicyRuleFluent) o;
    if (!(Objects.equals(succeededCount, that.succeededCount))) {
      return false;
    }
    if (!(Objects.equals(succeededIndexes, that.succeededIndexes))) {
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
  
  public Integer getSucceededCount() {
    return this.succeededCount;
  }
  
  public String getSucceededIndexes() {
    return this.succeededIndexes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasSucceededCount() {
    return this.succeededCount != null;
  }
  
  public boolean hasSucceededIndexes() {
    return this.succeededIndexes != null;
  }
  
  public int hashCode() {
    return Objects.hash(succeededCount, succeededIndexes, additionalProperties);
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
    if (!(succeededCount == null)) {
        sb.append("succeededCount:");
        sb.append(succeededCount);
        sb.append(",");
    }
    if (!(succeededIndexes == null)) {
        sb.append("succeededIndexes:");
        sb.append(succeededIndexes);
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
  
  public A withSucceededCount(Integer succeededCount) {
    this.succeededCount = succeededCount;
    return (A) this;
  }
  
  public A withSucceededIndexes(String succeededIndexes) {
    this.succeededIndexes = succeededIndexes;
    return (A) this;
  }
  
}