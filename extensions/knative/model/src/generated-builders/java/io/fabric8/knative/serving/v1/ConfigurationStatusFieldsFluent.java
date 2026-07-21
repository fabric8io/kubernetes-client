package io.fabric8.knative.serving.v1;

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
public class ConfigurationStatusFieldsFluent<A extends io.fabric8.knative.serving.v1.ConfigurationStatusFieldsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String latestCreatedRevisionName;
  private String latestReadyRevisionName;

  public ConfigurationStatusFieldsFluent() {
  }
  
  public ConfigurationStatusFieldsFluent(ConfigurationStatusFields instance) {
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
  
  protected void copyInstance(ConfigurationStatusFields instance) {
    instance = instance != null ? instance : new ConfigurationStatusFields();
    if (instance != null) {
        this.withLatestCreatedRevisionName(instance.getLatestCreatedRevisionName());
        this.withLatestReadyRevisionName(instance.getLatestReadyRevisionName());
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
    ConfigurationStatusFieldsFluent that = (ConfigurationStatusFieldsFluent) o;
    if (!(Objects.equals(latestCreatedRevisionName, that.latestCreatedRevisionName))) {
      return false;
    }
    if (!(Objects.equals(latestReadyRevisionName, that.latestReadyRevisionName))) {
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
  
  public String getLatestCreatedRevisionName() {
    return this.latestCreatedRevisionName;
  }
  
  public String getLatestReadyRevisionName() {
    return this.latestReadyRevisionName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLatestCreatedRevisionName() {
    return this.latestCreatedRevisionName != null;
  }
  
  public boolean hasLatestReadyRevisionName() {
    return this.latestReadyRevisionName != null;
  }
  
  public int hashCode() {
    return Objects.hash(latestCreatedRevisionName, latestReadyRevisionName, additionalProperties);
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
    if (!(latestCreatedRevisionName == null)) {
        sb.append("latestCreatedRevisionName:");
        sb.append(latestCreatedRevisionName);
        sb.append(",");
    }
    if (!(latestReadyRevisionName == null)) {
        sb.append("latestReadyRevisionName:");
        sb.append(latestReadyRevisionName);
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
  
  public A withLatestCreatedRevisionName(String latestCreatedRevisionName) {
    this.latestCreatedRevisionName = latestCreatedRevisionName;
    return (A) this;
  }
  
  public A withLatestReadyRevisionName(String latestReadyRevisionName) {
    this.latestReadyRevisionName = latestReadyRevisionName;
    return (A) this;
  }
  
}