package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
public class AddOnScoreFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.AddOnScoreFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String resourceName;
  private String scoreName;

  public AddOnScoreFluent() {
  }
  
  public AddOnScoreFluent(AddOnScore instance) {
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
  
  protected void copyInstance(AddOnScore instance) {
    instance = instance != null ? instance : new AddOnScore();
    if (instance != null) {
        this.withResourceName(instance.getResourceName());
        this.withScoreName(instance.getScoreName());
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
    AddOnScoreFluent that = (AddOnScoreFluent) o;
    if (!(Objects.equals(resourceName, that.resourceName))) {
      return false;
    }
    if (!(Objects.equals(scoreName, that.scoreName))) {
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
  
  public String getResourceName() {
    return this.resourceName;
  }
  
  public String getScoreName() {
    return this.scoreName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasResourceName() {
    return this.resourceName != null;
  }
  
  public boolean hasScoreName() {
    return this.scoreName != null;
  }
  
  public int hashCode() {
    return Objects.hash(resourceName, scoreName, additionalProperties);
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
    if (!(resourceName == null)) {
        sb.append("resourceName:");
        sb.append(resourceName);
        sb.append(",");
    }
    if (!(scoreName == null)) {
        sb.append("scoreName:");
        sb.append(scoreName);
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
  
  public A withResourceName(String resourceName) {
    this.resourceName = resourceName;
    return (A) this;
  }
  
  public A withScoreName(String scoreName) {
    this.scoreName = scoreName;
    return (A) this;
  }
  
}