package io.fabric8.knative.duck.v1;

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
public class CloudEventOverridesFluent<A extends io.fabric8.knative.duck.v1.CloudEventOverridesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> extensions;

  public CloudEventOverridesFluent() {
  }
  
  public CloudEventOverridesFluent(CloudEventOverrides instance) {
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
  
  public A addToExtensions(Map<String,String> map) {
    if (this.extensions == null && map != null) {
      this.extensions = new LinkedHashMap();
    }
    if (map != null) {
      this.extensions.putAll(map);
    }
    return (A) this;
  }
  
  public A addToExtensions(String key,String value) {
    if (this.extensions == null && key != null && value != null) {
      this.extensions = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.extensions.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(CloudEventOverrides instance) {
    instance = instance != null ? instance : new CloudEventOverrides();
    if (instance != null) {
        this.withExtensions(instance.getExtensions());
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
    CloudEventOverridesFluent that = (CloudEventOverridesFluent) o;
    if (!(Objects.equals(extensions, that.extensions))) {
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
  
  public Map<String,String> getExtensions() {
    return this.extensions;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExtensions() {
    return this.extensions != null;
  }
  
  public int hashCode() {
    return Objects.hash(extensions, additionalProperties);
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
  
  public A removeFromExtensions(String key) {
    if (this.extensions == null) {
      return (A) this;
    }
    if (key != null && this.extensions != null) {
      this.extensions.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromExtensions(Map<String,String> map) {
    if (this.extensions == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.extensions != null) {
          this.extensions.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(extensions == null) && !(extensions.isEmpty())) {
        sb.append("extensions:");
        sb.append(extensions);
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
  
  public <K,V>A withExtensions(Map<String,String> extensions) {
    if (extensions == null) {
      this.extensions = null;
    } else {
      this.extensions = new LinkedHashMap(extensions);
    }
    return (A) this;
  }
  
}