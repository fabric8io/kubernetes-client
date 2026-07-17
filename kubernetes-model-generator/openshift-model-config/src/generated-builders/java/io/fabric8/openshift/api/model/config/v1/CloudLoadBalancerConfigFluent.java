package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CloudLoadBalancerConfigFluent<A extends io.fabric8.openshift.api.model.config.v1.CloudLoadBalancerConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CloudLoadBalancerIPsBuilder clusterHosted;
  private String dnsType;

  public CloudLoadBalancerConfigFluent() {
  }
  
  public CloudLoadBalancerConfigFluent(CloudLoadBalancerConfig instance) {
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
  
  public CloudLoadBalancerIPs buildClusterHosted() {
    return this.clusterHosted != null ? this.clusterHosted.build() : null;
  }
  
  protected void copyInstance(CloudLoadBalancerConfig instance) {
    instance = instance != null ? instance : new CloudLoadBalancerConfig();
    if (instance != null) {
        this.withClusterHosted(instance.getClusterHosted());
        this.withDnsType(instance.getDnsType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterHostedNested<A> editClusterHosted() {
    return this.withNewClusterHostedLike(Optional.ofNullable(this.buildClusterHosted()).orElse(null));
  }
  
  public ClusterHostedNested<A> editOrNewClusterHosted() {
    return this.withNewClusterHostedLike(Optional.ofNullable(this.buildClusterHosted()).orElse(new CloudLoadBalancerIPsBuilder().build()));
  }
  
  public ClusterHostedNested<A> editOrNewClusterHostedLike(CloudLoadBalancerIPs item) {
    return this.withNewClusterHostedLike(Optional.ofNullable(this.buildClusterHosted()).orElse(item));
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
    CloudLoadBalancerConfigFluent that = (CloudLoadBalancerConfigFluent) o;
    if (!(Objects.equals(clusterHosted, that.clusterHosted))) {
      return false;
    }
    if (!(Objects.equals(dnsType, that.dnsType))) {
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
  
  public String getDnsType() {
    return this.dnsType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterHosted() {
    return this.clusterHosted != null;
  }
  
  public boolean hasDnsType() {
    return this.dnsType != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterHosted, dnsType, additionalProperties);
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
    if (!(clusterHosted == null)) {
        sb.append("clusterHosted:");
        sb.append(clusterHosted);
        sb.append(",");
    }
    if (!(dnsType == null)) {
        sb.append("dnsType:");
        sb.append(dnsType);
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
  
  public A withClusterHosted(CloudLoadBalancerIPs clusterHosted) {
    this._visitables.remove("clusterHosted");
    if (clusterHosted != null) {
        this.clusterHosted = new CloudLoadBalancerIPsBuilder(clusterHosted);
        this._visitables.get("clusterHosted").add(this.clusterHosted);
    } else {
        this.clusterHosted = null;
        this._visitables.get("clusterHosted").remove(this.clusterHosted);
    }
    return (A) this;
  }
  
  public A withDnsType(String dnsType) {
    this.dnsType = dnsType;
    return (A) this;
  }
  
  public ClusterHostedNested<A> withNewClusterHosted() {
    return new ClusterHostedNested(null);
  }
  
  public ClusterHostedNested<A> withNewClusterHostedLike(CloudLoadBalancerIPs item) {
    return new ClusterHostedNested(item);
  }
  public class ClusterHostedNested<N> extends CloudLoadBalancerIPsFluent<ClusterHostedNested<N>> implements Nested<N>{
  
    CloudLoadBalancerIPsBuilder builder;
  
    ClusterHostedNested(CloudLoadBalancerIPs item) {
      this.builder = new CloudLoadBalancerIPsBuilder(this, item);
    }
  
    public N and() {
      return (N) CloudLoadBalancerConfigFluent.this.withClusterHosted(builder.build());
    }
    
    public N endClusterHosted() {
      return and();
    }
    
  }
}