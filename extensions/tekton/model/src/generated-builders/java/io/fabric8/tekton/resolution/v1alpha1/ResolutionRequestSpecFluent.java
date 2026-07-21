package io.fabric8.tekton.resolution.v1alpha1;

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
public class ResolutionRequestSpecFluent<A extends io.fabric8.tekton.resolution.v1alpha1.ResolutionRequestSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> params;

  public ResolutionRequestSpecFluent() {
  }
  
  public ResolutionRequestSpecFluent(ResolutionRequestSpec instance) {
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
  
  public A addToParams(Map<String,String> map) {
    if (this.params == null && map != null) {
      this.params = new LinkedHashMap();
    }
    if (map != null) {
      this.params.putAll(map);
    }
    return (A) this;
  }
  
  public A addToParams(String key,String value) {
    if (this.params == null && key != null && value != null) {
      this.params = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.params.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(ResolutionRequestSpec instance) {
    instance = instance != null ? instance : new ResolutionRequestSpec();
    if (instance != null) {
        this.withParams(instance.getParams());
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
    ResolutionRequestSpecFluent that = (ResolutionRequestSpecFluent) o;
    if (!(Objects.equals(params, that.params))) {
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
  
  public Map<String,String> getParams() {
    return this.params;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasParams() {
    return this.params != null;
  }
  
  public int hashCode() {
    return Objects.hash(params, additionalProperties);
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
  
  public A removeFromParams(String key) {
    if (this.params == null) {
      return (A) this;
    }
    if (key != null && this.params != null) {
      this.params.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromParams(Map<String,String> map) {
    if (this.params == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.params != null) {
          this.params.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
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
  
  public <K,V>A withParams(Map<String,String> params) {
    if (params == null) {
      this.params = null;
    } else {
      this.params = new LinkedHashMap(params);
    }
    return (A) this;
  }
  
}