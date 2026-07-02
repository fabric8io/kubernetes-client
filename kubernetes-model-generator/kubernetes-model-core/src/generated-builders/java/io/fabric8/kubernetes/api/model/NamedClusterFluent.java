package io.fabric8.kubernetes.api.model;

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
public class NamedClusterFluent<A extends io.fabric8.kubernetes.api.model.NamedClusterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterBuilder cluster;
  private String name;

  public NamedClusterFluent() {
  }
  
  public NamedClusterFluent(NamedCluster instance) {
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
  
  public Cluster buildCluster() {
    return this.cluster != null ? this.cluster.build() : null;
  }
  
  protected void copyInstance(NamedCluster instance) {
    instance = instance != null ? instance : new NamedCluster();
    if (instance != null) {
        this.withCluster(instance.getCluster());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterNested<A> editCluster() {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(null));
  }
  
  public ClusterNested<A> editOrNewCluster() {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(new ClusterBuilder().build()));
  }
  
  public ClusterNested<A> editOrNewClusterLike(Cluster item) {
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
    NamedClusterFluent that = (NamedClusterFluent) o;
    if (!(Objects.equals(cluster, that.cluster))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCluster() {
    return this.cluster != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(cluster, name, additionalProperties);
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
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withCluster(Cluster cluster) {
    this._visitables.remove("cluster");
    if (cluster != null) {
        this.cluster = new ClusterBuilder(cluster);
        this._visitables.get("cluster").add(this.cluster);
    } else {
        this.cluster = null;
        this._visitables.get("cluster").remove(this.cluster);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ClusterNested<A> withNewCluster() {
    return new ClusterNested(null);
  }
  
  public ClusterNested<A> withNewClusterLike(Cluster item) {
    return new ClusterNested(item);
  }
  public class ClusterNested<N> extends ClusterFluent<ClusterNested<N>> implements Nested<N>{
  
    ClusterBuilder builder;
  
    ClusterNested(Cluster item) {
      this.builder = new ClusterBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedClusterFluent.this.withCluster(builder.build());
    }
    
    public N endCluster() {
      return and();
    }
    
  }
}