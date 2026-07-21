package io.fabric8.openclustermanagement.api.model.apps.v1;

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
public class PlacementDecisionFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.PlacementDecisionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clusterName;
  private String clusterNamespace;

  public PlacementDecisionFluent() {
  }
  
  public PlacementDecisionFluent(PlacementDecision instance) {
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
  
  protected void copyInstance(PlacementDecision instance) {
    instance = instance != null ? instance : new PlacementDecision();
    if (instance != null) {
        this.withClusterName(instance.getClusterName());
        this.withClusterNamespace(instance.getClusterNamespace());
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
    PlacementDecisionFluent that = (PlacementDecisionFluent) o;
    if (!(Objects.equals(clusterName, that.clusterName))) {
      return false;
    }
    if (!(Objects.equals(clusterNamespace, that.clusterNamespace))) {
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
  
  public String getClusterName() {
    return this.clusterName;
  }
  
  public String getClusterNamespace() {
    return this.clusterNamespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterName() {
    return this.clusterName != null;
  }
  
  public boolean hasClusterNamespace() {
    return this.clusterNamespace != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterName, clusterNamespace, additionalProperties);
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
    if (!(clusterName == null)) {
        sb.append("clusterName:");
        sb.append(clusterName);
        sb.append(",");
    }
    if (!(clusterNamespace == null)) {
        sb.append("clusterNamespace:");
        sb.append(clusterNamespace);
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
  
  public A withClusterName(String clusterName) {
    this.clusterName = clusterName;
    return (A) this;
  }
  
  public A withClusterNamespace(String clusterNamespace) {
    this.clusterNamespace = clusterNamespace;
    return (A) this;
  }
  
}