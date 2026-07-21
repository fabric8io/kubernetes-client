package io.fabric8.chaosmesh.v1alpha1;

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
public class FrameFluent<A extends io.fabric8.chaosmesh.v1alpha1.FrameFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String funcname;
  private String parameters;
  private String predicate;

  public FrameFluent() {
  }
  
  public FrameFluent(Frame instance) {
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
  
  protected void copyInstance(Frame instance) {
    instance = instance != null ? instance : new Frame();
    if (instance != null) {
        this.withFuncname(instance.getFuncname());
        this.withParameters(instance.getParameters());
        this.withPredicate(instance.getPredicate());
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
    FrameFluent that = (FrameFluent) o;
    if (!(Objects.equals(funcname, that.funcname))) {
      return false;
    }
    if (!(Objects.equals(parameters, that.parameters))) {
      return false;
    }
    if (!(Objects.equals(predicate, that.predicate))) {
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
  
  public String getFuncname() {
    return this.funcname;
  }
  
  public String getParameters() {
    return this.parameters;
  }
  
  public String getPredicate() {
    return this.predicate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFuncname() {
    return this.funcname != null;
  }
  
  public boolean hasParameters() {
    return this.parameters != null;
  }
  
  public boolean hasPredicate() {
    return this.predicate != null;
  }
  
  public int hashCode() {
    return Objects.hash(funcname, parameters, predicate, additionalProperties);
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
    if (!(funcname == null)) {
        sb.append("funcname:");
        sb.append(funcname);
        sb.append(",");
    }
    if (!(parameters == null)) {
        sb.append("parameters:");
        sb.append(parameters);
        sb.append(",");
    }
    if (!(predicate == null)) {
        sb.append("predicate:");
        sb.append(predicate);
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
  
  public A withFuncname(String funcname) {
    this.funcname = funcname;
    return (A) this;
  }
  
  public A withParameters(String parameters) {
    this.parameters = parameters;
    return (A) this;
  }
  
  public A withPredicate(String predicate) {
    this.predicate = predicate;
    return (A) this;
  }
  
}