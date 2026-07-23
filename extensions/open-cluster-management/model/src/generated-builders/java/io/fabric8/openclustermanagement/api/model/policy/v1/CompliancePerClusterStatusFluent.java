package io.fabric8.openclustermanagement.api.model.policy.v1;

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
public class CompliancePerClusterStatusFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1.CompliancePerClusterStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clustername;
  private String clusternamespace;
  private String compliant;

  public CompliancePerClusterStatusFluent() {
  }
  
  public CompliancePerClusterStatusFluent(CompliancePerClusterStatus instance) {
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
  
  protected void copyInstance(CompliancePerClusterStatus instance) {
    instance = instance != null ? instance : new CompliancePerClusterStatus();
    if (instance != null) {
        this.withClustername(instance.getClustername());
        this.withClusternamespace(instance.getClusternamespace());
        this.withCompliant(instance.getCompliant());
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
    CompliancePerClusterStatusFluent that = (CompliancePerClusterStatusFluent) o;
    if (!(Objects.equals(clustername, that.clustername))) {
      return false;
    }
    if (!(Objects.equals(clusternamespace, that.clusternamespace))) {
      return false;
    }
    if (!(Objects.equals(compliant, that.compliant))) {
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
  
  public String getClustername() {
    return this.clustername;
  }
  
  public String getClusternamespace() {
    return this.clusternamespace;
  }
  
  public String getCompliant() {
    return this.compliant;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClustername() {
    return this.clustername != null;
  }
  
  public boolean hasClusternamespace() {
    return this.clusternamespace != null;
  }
  
  public boolean hasCompliant() {
    return this.compliant != null;
  }
  
  public int hashCode() {
    return Objects.hash(clustername, clusternamespace, compliant, additionalProperties);
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
    if (!(clustername == null)) {
        sb.append("clustername:");
        sb.append(clustername);
        sb.append(",");
    }
    if (!(clusternamespace == null)) {
        sb.append("clusternamespace:");
        sb.append(clusternamespace);
        sb.append(",");
    }
    if (!(compliant == null)) {
        sb.append("compliant:");
        sb.append(compliant);
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
  
  public A withClustername(String clustername) {
    this.clustername = clustername;
    return (A) this;
  }
  
  public A withClusternamespace(String clusternamespace) {
    this.clusternamespace = clusternamespace;
    return (A) this;
  }
  
  public A withCompliant(String compliant) {
    this.compliant = compliant;
    return (A) this;
  }
  
}