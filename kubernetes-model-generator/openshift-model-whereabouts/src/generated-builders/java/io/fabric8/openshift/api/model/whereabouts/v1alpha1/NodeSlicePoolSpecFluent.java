package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

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
public class NodeSlicePoolSpecFluent<A extends io.fabric8.openshift.api.model.whereabouts.v1alpha1.NodeSlicePoolSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String range;
  private String sliceSize;

  public NodeSlicePoolSpecFluent() {
  }
  
  public NodeSlicePoolSpecFluent(NodeSlicePoolSpec instance) {
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
  
  protected void copyInstance(NodeSlicePoolSpec instance) {
    instance = instance != null ? instance : new NodeSlicePoolSpec();
    if (instance != null) {
        this.withRange(instance.getRange());
        this.withSliceSize(instance.getSliceSize());
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
    NodeSlicePoolSpecFluent that = (NodeSlicePoolSpecFluent) o;
    if (!(Objects.equals(range, that.range))) {
      return false;
    }
    if (!(Objects.equals(sliceSize, that.sliceSize))) {
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
  
  public String getRange() {
    return this.range;
  }
  
  public String getSliceSize() {
    return this.sliceSize;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRange() {
    return this.range != null;
  }
  
  public boolean hasSliceSize() {
    return this.sliceSize != null;
  }
  
  public int hashCode() {
    return Objects.hash(range, sliceSize, additionalProperties);
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
    if (!(range == null)) {
        sb.append("range:");
        sb.append(range);
        sb.append(",");
    }
    if (!(sliceSize == null)) {
        sb.append("sliceSize:");
        sb.append(sliceSize);
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
  
  public A withRange(String range) {
    this.range = range;
    return (A) this;
  }
  
  public A withSliceSize(String sliceSize) {
    this.sliceSize = sliceSize;
    return (A) this;
  }
  
}