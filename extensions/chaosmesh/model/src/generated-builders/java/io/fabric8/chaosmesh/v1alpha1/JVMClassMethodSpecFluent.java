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
public class JVMClassMethodSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.JVMClassMethodSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String className;
  private String method;

  public JVMClassMethodSpecFluent() {
  }
  
  public JVMClassMethodSpecFluent(JVMClassMethodSpec instance) {
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
  
  protected void copyInstance(JVMClassMethodSpec instance) {
    instance = instance != null ? instance : new JVMClassMethodSpec();
    if (instance != null) {
        this.withClassName(instance.getClassName());
        this.withMethod(instance.getMethod());
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
    JVMClassMethodSpecFluent that = (JVMClassMethodSpecFluent) o;
    if (!(Objects.equals(className, that.className))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
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
  
  public String getClassName() {
    return this.className;
  }
  
  public String getMethod() {
    return this.method;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClassName() {
    return this.className != null;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public int hashCode() {
    return Objects.hash(className, method, additionalProperties);
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
    if (!(className == null)) {
        sb.append("className:");
        sb.append(className);
        sb.append(",");
    }
    if (!(method == null)) {
        sb.append("method:");
        sb.append(method);
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
  
  public A withClassName(String className) {
    this.className = className;
    return (A) this;
  }
  
  public A withMethod(String method) {
    this.method = method;
    return (A) this;
  }
  
}