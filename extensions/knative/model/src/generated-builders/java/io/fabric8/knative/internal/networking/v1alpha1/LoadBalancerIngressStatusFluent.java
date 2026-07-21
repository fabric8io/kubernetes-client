package io.fabric8.knative.internal.networking.v1alpha1;

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
public class LoadBalancerIngressStatusFluent<A extends io.fabric8.knative.internal.networking.v1alpha1.LoadBalancerIngressStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String domain;
  private String domainInternal;
  private String ip;
  private Boolean meshOnly;

  public LoadBalancerIngressStatusFluent() {
  }
  
  public LoadBalancerIngressStatusFluent(LoadBalancerIngressStatus instance) {
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
  
  protected void copyInstance(LoadBalancerIngressStatus instance) {
    instance = instance != null ? instance : new LoadBalancerIngressStatus();
    if (instance != null) {
        this.withDomain(instance.getDomain());
        this.withDomainInternal(instance.getDomainInternal());
        this.withIp(instance.getIp());
        this.withMeshOnly(instance.getMeshOnly());
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
    LoadBalancerIngressStatusFluent that = (LoadBalancerIngressStatusFluent) o;
    if (!(Objects.equals(domain, that.domain))) {
      return false;
    }
    if (!(Objects.equals(domainInternal, that.domainInternal))) {
      return false;
    }
    if (!(Objects.equals(ip, that.ip))) {
      return false;
    }
    if (!(Objects.equals(meshOnly, that.meshOnly))) {
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
  
  public String getDomain() {
    return this.domain;
  }
  
  public String getDomainInternal() {
    return this.domainInternal;
  }
  
  public String getIp() {
    return this.ip;
  }
  
  public Boolean getMeshOnly() {
    return this.meshOnly;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDomain() {
    return this.domain != null;
  }
  
  public boolean hasDomainInternal() {
    return this.domainInternal != null;
  }
  
  public boolean hasIp() {
    return this.ip != null;
  }
  
  public boolean hasMeshOnly() {
    return this.meshOnly != null;
  }
  
  public int hashCode() {
    return Objects.hash(domain, domainInternal, ip, meshOnly, additionalProperties);
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
    if (!(domain == null)) {
        sb.append("domain:");
        sb.append(domain);
        sb.append(",");
    }
    if (!(domainInternal == null)) {
        sb.append("domainInternal:");
        sb.append(domainInternal);
        sb.append(",");
    }
    if (!(ip == null)) {
        sb.append("ip:");
        sb.append(ip);
        sb.append(",");
    }
    if (!(meshOnly == null)) {
        sb.append("meshOnly:");
        sb.append(meshOnly);
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
  
  public A withDomain(String domain) {
    this.domain = domain;
    return (A) this;
  }
  
  public A withDomainInternal(String domainInternal) {
    this.domainInternal = domainInternal;
    return (A) this;
  }
  
  public A withIp(String ip) {
    this.ip = ip;
    return (A) this;
  }
  
  public A withMeshOnly() {
    return withMeshOnly(true);
  }
  
  public A withMeshOnly(Boolean meshOnly) {
    this.meshOnly = meshOnly;
    return (A) this;
  }
  
}