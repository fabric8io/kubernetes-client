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
public class MetaDataFromLabelFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.MetaDataFromLabelFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String key;
  private String label;
  private String object;

  public MetaDataFromLabelFluent() {
  }
  
  public MetaDataFromLabelFluent(MetaDataFromLabel instance) {
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
  
  protected void copyInstance(MetaDataFromLabel instance) {
    instance = instance != null ? instance : new MetaDataFromLabel();
    if (instance != null) {
        this.withKey(instance.getKey());
        this.withLabel(instance.getLabel());
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
    MetaDataFromLabelFluent that = (MetaDataFromLabelFluent) o;
    if (!(Objects.equals(key, that.key))) {
      return false;
    }
    if (!(Objects.equals(label, that.label))) {
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
  
  public String getKey() {
    return this.key;
  }
  
  public String getLabel() {
    return this.label;
  }
  
  public String getObject() {
    return this.object;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public boolean hasLabel() {
    return this.label != null;
  }
  
  public boolean hasObject() {
    return this.object != null;
  }
  
  public int hashCode() {
    return Objects.hash(key, label, object, additionalProperties);
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
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
        sb.append(",");
    }
    if (!(label == null)) {
        sb.append("label:");
        sb.append(label);
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
  
  public A withKey(String key) {
    this.key = key;
    return (A) this;
  }
  
  public A withLabel(String label) {
    this.label = label;
    return (A) this;
  }
  
  public A withObject(String object) {
    this.object = object;
    return (A) this;
  }
  
}