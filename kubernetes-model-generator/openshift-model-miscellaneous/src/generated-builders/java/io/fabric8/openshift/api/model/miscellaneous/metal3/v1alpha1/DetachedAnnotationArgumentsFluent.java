package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class DetachedAnnotationArgumentsFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.DetachedAnnotationArgumentsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String deleteAction;
  private Boolean force;

  public DetachedAnnotationArgumentsFluent() {
  }
  
  public DetachedAnnotationArgumentsFluent(DetachedAnnotationArguments instance) {
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
  
  protected void copyInstance(DetachedAnnotationArguments instance) {
    instance = instance != null ? instance : new DetachedAnnotationArguments();
    if (instance != null) {
        this.withDeleteAction(instance.getDeleteAction());
        this.withForce(instance.getForce());
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
    DetachedAnnotationArgumentsFluent that = (DetachedAnnotationArgumentsFluent) o;
    if (!(Objects.equals(deleteAction, that.deleteAction))) {
      return false;
    }
    if (!(Objects.equals(force, that.force))) {
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
  
  public String getDeleteAction() {
    return this.deleteAction;
  }
  
  public Boolean getForce() {
    return this.force;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeleteAction() {
    return this.deleteAction != null;
  }
  
  public boolean hasForce() {
    return this.force != null;
  }
  
  public int hashCode() {
    return Objects.hash(deleteAction, force, additionalProperties);
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
    if (!(deleteAction == null)) {
        sb.append("deleteAction:");
        sb.append(deleteAction);
        sb.append(",");
    }
    if (!(force == null)) {
        sb.append("force:");
        sb.append(force);
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
  
  public A withDeleteAction(String deleteAction) {
    this.deleteAction = deleteAction;
    return (A) this;
  }
  
  public A withForce() {
    return withForce(true);
  }
  
  public A withForce(Boolean force) {
    this.force = force;
    return (A) this;
  }
  
}