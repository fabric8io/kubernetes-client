package io.fabric8.kubernetes.api.model;

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
public class NodeRuntimeHandlerFeaturesFluent<A extends io.fabric8.kubernetes.api.model.NodeRuntimeHandlerFeaturesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean recursiveReadOnlyMounts;
  private Boolean userNamespaces;

  public NodeRuntimeHandlerFeaturesFluent() {
  }
  
  public NodeRuntimeHandlerFeaturesFluent(NodeRuntimeHandlerFeatures instance) {
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
  
  protected void copyInstance(NodeRuntimeHandlerFeatures instance) {
    instance = instance != null ? instance : new NodeRuntimeHandlerFeatures();
    if (instance != null) {
        this.withRecursiveReadOnlyMounts(instance.getRecursiveReadOnlyMounts());
        this.withUserNamespaces(instance.getUserNamespaces());
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
    NodeRuntimeHandlerFeaturesFluent that = (NodeRuntimeHandlerFeaturesFluent) o;
    if (!(Objects.equals(recursiveReadOnlyMounts, that.recursiveReadOnlyMounts))) {
      return false;
    }
    if (!(Objects.equals(userNamespaces, that.userNamespaces))) {
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
  
  public Boolean getRecursiveReadOnlyMounts() {
    return this.recursiveReadOnlyMounts;
  }
  
  public Boolean getUserNamespaces() {
    return this.userNamespaces;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRecursiveReadOnlyMounts() {
    return this.recursiveReadOnlyMounts != null;
  }
  
  public boolean hasUserNamespaces() {
    return this.userNamespaces != null;
  }
  
  public int hashCode() {
    return Objects.hash(recursiveReadOnlyMounts, userNamespaces, additionalProperties);
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
    if (!(recursiveReadOnlyMounts == null)) {
        sb.append("recursiveReadOnlyMounts:");
        sb.append(recursiveReadOnlyMounts);
        sb.append(",");
    }
    if (!(userNamespaces == null)) {
        sb.append("userNamespaces:");
        sb.append(userNamespaces);
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
  
  public A withRecursiveReadOnlyMounts() {
    return withRecursiveReadOnlyMounts(true);
  }
  
  public A withRecursiveReadOnlyMounts(Boolean recursiveReadOnlyMounts) {
    this.recursiveReadOnlyMounts = recursiveReadOnlyMounts;
    return (A) this;
  }
  
  public A withUserNamespaces() {
    return withUserNamespaces(true);
  }
  
  public A withUserNamespaces(Boolean userNamespaces) {
    this.userNamespaces = userNamespaces;
    return (A) this;
  }
  
}