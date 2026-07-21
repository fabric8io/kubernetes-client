package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class EnvoyFilterEnvoyConfigObjectMatchClusterFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchClusterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EnvoyFilterClusterMatchBuilder cluster;

  public EnvoyFilterEnvoyConfigObjectMatchClusterFluent() {
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchClusterFluent(EnvoyFilterEnvoyConfigObjectMatchCluster instance) {
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
  
  public EnvoyFilterClusterMatch buildCluster() {
    return this.cluster != null ? this.cluster.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterEnvoyConfigObjectMatchCluster instance) {
    instance = instance != null ? instance : new EnvoyFilterEnvoyConfigObjectMatchCluster();
    if (instance != null) {
        this.withCluster(instance.getCluster());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterNested<A> editCluster() {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(null));
  }
  
  public ClusterNested<A> editOrNewCluster() {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(new EnvoyFilterClusterMatchBuilder().build()));
  }
  
  public ClusterNested<A> editOrNewClusterLike(EnvoyFilterClusterMatch item) {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(item));
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
    EnvoyFilterEnvoyConfigObjectMatchClusterFluent that = (EnvoyFilterEnvoyConfigObjectMatchClusterFluent) o;
    if (!(Objects.equals(cluster, that.cluster))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCluster() {
    return this.cluster != null;
  }
  
  public int hashCode() {
    return Objects.hash(cluster, additionalProperties);
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
    if (!(cluster == null)) {
        sb.append("cluster:");
        sb.append(cluster);
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
  
  public A withCluster(EnvoyFilterClusterMatch cluster) {
    this._visitables.remove("cluster");
    if (cluster != null) {
        this.cluster = new EnvoyFilterClusterMatchBuilder(cluster);
        this._visitables.get("cluster").add(this.cluster);
    } else {
        this.cluster = null;
        this._visitables.get("cluster").remove(this.cluster);
    }
    return (A) this;
  }
  
  public ClusterNested<A> withNewCluster() {
    return new ClusterNested(null);
  }
  
  public A withNewCluster(String name,Long portNumber,String service,String subset) {
    return (A) this.withCluster(new EnvoyFilterClusterMatch(name, portNumber, service, subset));
  }
  
  public ClusterNested<A> withNewClusterLike(EnvoyFilterClusterMatch item) {
    return new ClusterNested(item);
  }
  public class ClusterNested<N> extends EnvoyFilterClusterMatchFluent<ClusterNested<N>> implements Nested<N>{
  
    EnvoyFilterClusterMatchBuilder builder;
  
    ClusterNested(EnvoyFilterClusterMatch item) {
      this.builder = new EnvoyFilterClusterMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterEnvoyConfigObjectMatchClusterFluent.this.withCluster(builder.build());
    }
    
    public N endCluster() {
      return and();
    }
    
  }
}