package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class MandatoryDecisionGroupFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.MandatoryDecisionGroupFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer groupIndex;
  private String groupName;

  public MandatoryDecisionGroupFluent() {
  }
  
  public MandatoryDecisionGroupFluent(MandatoryDecisionGroup instance) {
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
  
  protected void copyInstance(MandatoryDecisionGroup instance) {
    instance = instance != null ? instance : new MandatoryDecisionGroup();
    if (instance != null) {
        this.withGroupIndex(instance.getGroupIndex());
        this.withGroupName(instance.getGroupName());
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
    MandatoryDecisionGroupFluent that = (MandatoryDecisionGroupFluent) o;
    if (!(Objects.equals(groupIndex, that.groupIndex))) {
      return false;
    }
    if (!(Objects.equals(groupName, that.groupName))) {
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
  
  public Integer getGroupIndex() {
    return this.groupIndex;
  }
  
  public String getGroupName() {
    return this.groupName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGroupIndex() {
    return this.groupIndex != null;
  }
  
  public boolean hasGroupName() {
    return this.groupName != null;
  }
  
  public int hashCode() {
    return Objects.hash(groupIndex, groupName, additionalProperties);
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
    if (!(groupIndex == null)) {
        sb.append("groupIndex:");
        sb.append(groupIndex);
        sb.append(",");
    }
    if (!(groupName == null)) {
        sb.append("groupName:");
        sb.append(groupName);
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
  
  public A withGroupIndex(Integer groupIndex) {
    this.groupIndex = groupIndex;
    return (A) this;
  }
  
  public A withGroupName(String groupName) {
    this.groupName = groupName;
    return (A) this;
  }
  
}