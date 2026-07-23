package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class NodeDaemonEndpointsFluent<A extends io.fabric8.kubernetes.api.model.NodeDaemonEndpointsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DaemonEndpointBuilder kubeletEndpoint;

  public NodeDaemonEndpointsFluent() {
  }
  
  public NodeDaemonEndpointsFluent(NodeDaemonEndpoints instance) {
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
  
  public DaemonEndpoint buildKubeletEndpoint() {
    return this.kubeletEndpoint != null ? this.kubeletEndpoint.build() : null;
  }
  
  protected void copyInstance(NodeDaemonEndpoints instance) {
    instance = instance != null ? instance : new NodeDaemonEndpoints();
    if (instance != null) {
        this.withKubeletEndpoint(instance.getKubeletEndpoint());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KubeletEndpointNested<A> editKubeletEndpoint() {
    return this.withNewKubeletEndpointLike(Optional.ofNullable(this.buildKubeletEndpoint()).orElse(null));
  }
  
  public KubeletEndpointNested<A> editOrNewKubeletEndpoint() {
    return this.withNewKubeletEndpointLike(Optional.ofNullable(this.buildKubeletEndpoint()).orElse(new DaemonEndpointBuilder().build()));
  }
  
  public KubeletEndpointNested<A> editOrNewKubeletEndpointLike(DaemonEndpoint item) {
    return this.withNewKubeletEndpointLike(Optional.ofNullable(this.buildKubeletEndpoint()).orElse(item));
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
    NodeDaemonEndpointsFluent that = (NodeDaemonEndpointsFluent) o;
    if (!(Objects.equals(kubeletEndpoint, that.kubeletEndpoint))) {
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
  
  public boolean hasKubeletEndpoint() {
    return this.kubeletEndpoint != null;
  }
  
  public int hashCode() {
    return Objects.hash(kubeletEndpoint, additionalProperties);
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
    if (!(kubeletEndpoint == null)) {
        sb.append("kubeletEndpoint:");
        sb.append(kubeletEndpoint);
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
  
  public A withKubeletEndpoint(DaemonEndpoint kubeletEndpoint) {
    this._visitables.remove("kubeletEndpoint");
    if (kubeletEndpoint != null) {
        this.kubeletEndpoint = new DaemonEndpointBuilder(kubeletEndpoint);
        this._visitables.get("kubeletEndpoint").add(this.kubeletEndpoint);
    } else {
        this.kubeletEndpoint = null;
        this._visitables.get("kubeletEndpoint").remove(this.kubeletEndpoint);
    }
    return (A) this;
  }
  
  public KubeletEndpointNested<A> withNewKubeletEndpoint() {
    return new KubeletEndpointNested(null);
  }
  
  public A withNewKubeletEndpoint(Integer port) {
    return (A) this.withKubeletEndpoint(new DaemonEndpoint(port));
  }
  
  public KubeletEndpointNested<A> withNewKubeletEndpointLike(DaemonEndpoint item) {
    return new KubeletEndpointNested(item);
  }
  public class KubeletEndpointNested<N> extends DaemonEndpointFluent<KubeletEndpointNested<N>> implements Nested<N>{
  
    DaemonEndpointBuilder builder;
  
    KubeletEndpointNested(DaemonEndpoint item) {
      this.builder = new DaemonEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDaemonEndpointsFluent.this.withKubeletEndpoint(builder.build());
    }
    
    public N endKubeletEndpoint() {
      return and();
    }
    
  }
}