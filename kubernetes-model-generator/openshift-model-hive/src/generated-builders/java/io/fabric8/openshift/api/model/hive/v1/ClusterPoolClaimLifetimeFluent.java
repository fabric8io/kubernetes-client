package io.fabric8.openshift.api.model.hive.v1;

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
public class ClusterPoolClaimLifetimeFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterPoolClaimLifetimeFluent<A>> extends BaseFluent<A>{

  private String _default;
  private Map<String,Object> additionalProperties;
  private String maximum;

  public ClusterPoolClaimLifetimeFluent() {
  }
  
  public ClusterPoolClaimLifetimeFluent(ClusterPoolClaimLifetime instance) {
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
  
  protected void copyInstance(ClusterPoolClaimLifetime instance) {
    instance = instance != null ? instance : new ClusterPoolClaimLifetime();
    if (instance != null) {
        this.withDefault(instance.getDefault());
        this.withMaximum(instance.getMaximum());
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
    ClusterPoolClaimLifetimeFluent that = (ClusterPoolClaimLifetimeFluent) o;
    if (!(Objects.equals(_default, that._default))) {
      return false;
    }
    if (!(Objects.equals(maximum, that.maximum))) {
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
  
  public String getDefault() {
    return this._default;
  }
  
  public String getMaximum() {
    return this.maximum;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public boolean hasMaximum() {
    return this.maximum != null;
  }
  
  public int hashCode() {
    return Objects.hash(_default, maximum, additionalProperties);
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
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
        sb.append(",");
    }
    if (!(maximum == null)) {
        sb.append("maximum:");
        sb.append(maximum);
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
  
  public A withDefault(String _default) {
    this._default = _default;
    return (A) this;
  }
  
  public A withMaximum(String maximum) {
    this.maximum = maximum;
    return (A) this;
  }
  
}