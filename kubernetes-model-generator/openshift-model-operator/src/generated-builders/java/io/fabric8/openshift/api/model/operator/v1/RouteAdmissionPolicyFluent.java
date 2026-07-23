package io.fabric8.openshift.api.model.operator.v1;

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
public class RouteAdmissionPolicyFluent<A extends io.fabric8.openshift.api.model.operator.v1.RouteAdmissionPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String namespaceOwnership;
  private String wildcardPolicy;

  public RouteAdmissionPolicyFluent() {
  }
  
  public RouteAdmissionPolicyFluent(RouteAdmissionPolicy instance) {
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
  
  protected void copyInstance(RouteAdmissionPolicy instance) {
    instance = instance != null ? instance : new RouteAdmissionPolicy();
    if (instance != null) {
        this.withNamespaceOwnership(instance.getNamespaceOwnership());
        this.withWildcardPolicy(instance.getWildcardPolicy());
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
    RouteAdmissionPolicyFluent that = (RouteAdmissionPolicyFluent) o;
    if (!(Objects.equals(namespaceOwnership, that.namespaceOwnership))) {
      return false;
    }
    if (!(Objects.equals(wildcardPolicy, that.wildcardPolicy))) {
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
  
  public String getNamespaceOwnership() {
    return this.namespaceOwnership;
  }
  
  public String getWildcardPolicy() {
    return this.wildcardPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNamespaceOwnership() {
    return this.namespaceOwnership != null;
  }
  
  public boolean hasWildcardPolicy() {
    return this.wildcardPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(namespaceOwnership, wildcardPolicy, additionalProperties);
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
    if (!(namespaceOwnership == null)) {
        sb.append("namespaceOwnership:");
        sb.append(namespaceOwnership);
        sb.append(",");
    }
    if (!(wildcardPolicy == null)) {
        sb.append("wildcardPolicy:");
        sb.append(wildcardPolicy);
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
  
  public A withNamespaceOwnership(String namespaceOwnership) {
    this.namespaceOwnership = namespaceOwnership;
    return (A) this;
  }
  
  public A withWildcardPolicy(String wildcardPolicy) {
    this.wildcardPolicy = wildcardPolicy;
    return (A) this;
  }
  
}