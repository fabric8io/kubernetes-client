package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
public class PatchArgsFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.PatchArgsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowKindChange;
  private Boolean allowNameChange;

  public PatchArgsFluent() {
  }
  
  public PatchArgsFluent(PatchArgs instance) {
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
  
  protected void copyInstance(PatchArgs instance) {
    instance = instance != null ? instance : new PatchArgs();
    if (instance != null) {
        this.withAllowKindChange(instance.getAllowKindChange());
        this.withAllowNameChange(instance.getAllowNameChange());
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
    PatchArgsFluent that = (PatchArgsFluent) o;
    if (!(Objects.equals(allowKindChange, that.allowKindChange))) {
      return false;
    }
    if (!(Objects.equals(allowNameChange, that.allowNameChange))) {
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
  
  public Boolean getAllowKindChange() {
    return this.allowKindChange;
  }
  
  public Boolean getAllowNameChange() {
    return this.allowNameChange;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowKindChange() {
    return this.allowKindChange != null;
  }
  
  public boolean hasAllowNameChange() {
    return this.allowNameChange != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowKindChange, allowNameChange, additionalProperties);
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
    if (!(allowKindChange == null)) {
        sb.append("allowKindChange:");
        sb.append(allowKindChange);
        sb.append(",");
    }
    if (!(allowNameChange == null)) {
        sb.append("allowNameChange:");
        sb.append(allowNameChange);
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
  
  public A withAllowKindChange() {
    return withAllowKindChange(true);
  }
  
  public A withAllowKindChange(Boolean allowKindChange) {
    this.allowKindChange = allowKindChange;
    return (A) this;
  }
  
  public A withAllowNameChange() {
    return withAllowNameChange(true);
  }
  
  public A withAllowNameChange(Boolean allowNameChange) {
    this.allowNameChange = allowNameChange;
    return (A) this;
  }
  
}