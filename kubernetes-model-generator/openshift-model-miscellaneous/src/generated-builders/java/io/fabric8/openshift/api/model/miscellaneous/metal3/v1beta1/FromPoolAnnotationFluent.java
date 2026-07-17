package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class FromPoolAnnotationFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.FromPoolAnnotationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String annotation;
  private String object;

  public FromPoolAnnotationFluent() {
  }
  
  public FromPoolAnnotationFluent(FromPoolAnnotation instance) {
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
  
  protected void copyInstance(FromPoolAnnotation instance) {
    instance = instance != null ? instance : new FromPoolAnnotation();
    if (instance != null) {
        this.withAnnotation(instance.getAnnotation());
        this.withObject(instance.getObject());
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
    FromPoolAnnotationFluent that = (FromPoolAnnotationFluent) o;
    if (!(Objects.equals(annotation, that.annotation))) {
      return false;
    }
    if (!(Objects.equals(object, that.object))) {
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
  
  public String getAnnotation() {
    return this.annotation;
  }
  
  public String getObject() {
    return this.object;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotation() {
    return this.annotation != null;
  }
  
  public boolean hasObject() {
    return this.object != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotation, object, additionalProperties);
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
    if (!(annotation == null)) {
        sb.append("annotation:");
        sb.append(annotation);
        sb.append(",");
    }
    if (!(object == null)) {
        sb.append("object:");
        sb.append(object);
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
  
  public A withAnnotation(String annotation) {
    this.annotation = annotation;
    return (A) this;
  }
  
  public A withObject(String object) {
    this.object = object;
    return (A) this;
  }
  
}