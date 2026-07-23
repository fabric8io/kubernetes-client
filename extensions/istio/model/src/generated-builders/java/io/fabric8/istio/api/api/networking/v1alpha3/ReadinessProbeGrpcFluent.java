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
public class ReadinessProbeGrpcFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ReadinessProbeGrpcFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GrpcHealthCheckConfigBuilder grpc;

  public ReadinessProbeGrpcFluent() {
  }
  
  public ReadinessProbeGrpcFluent(ReadinessProbeGrpc instance) {
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
  
  public GrpcHealthCheckConfig buildGrpc() {
    return this.grpc != null ? this.grpc.build() : null;
  }
  
  protected void copyInstance(ReadinessProbeGrpc instance) {
    instance = instance != null ? instance : new ReadinessProbeGrpc();
    if (instance != null) {
        this.withGrpc(instance.getGrpc());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GrpcNested<A> editGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(null));
  }
  
  public GrpcNested<A> editOrNewGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(new GrpcHealthCheckConfigBuilder().build()));
  }
  
  public GrpcNested<A> editOrNewGrpcLike(GrpcHealthCheckConfig item) {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(item));
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
    ReadinessProbeGrpcFluent that = (ReadinessProbeGrpcFluent) o;
    if (!(Objects.equals(grpc, that.grpc))) {
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
  
  public boolean hasGrpc() {
    return this.grpc != null;
  }
  
  public int hashCode() {
    return Objects.hash(grpc, additionalProperties);
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
    if (!(grpc == null)) {
        sb.append("grpc:");
        sb.append(grpc);
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
  
  public A withGrpc(GrpcHealthCheckConfig grpc) {
    this._visitables.remove("grpc");
    if (grpc != null) {
        this.grpc = new GrpcHealthCheckConfigBuilder(grpc);
        this._visitables.get("grpc").add(this.grpc);
    } else {
        this.grpc = null;
        this._visitables.get("grpc").remove(this.grpc);
    }
    return (A) this;
  }
  
  public GrpcNested<A> withNewGrpc() {
    return new GrpcNested(null);
  }
  
  public A withNewGrpc(Long port,String service) {
    return (A) this.withGrpc(new GrpcHealthCheckConfig(port, service));
  }
  
  public GrpcNested<A> withNewGrpcLike(GrpcHealthCheckConfig item) {
    return new GrpcNested(item);
  }
  public class GrpcNested<N> extends GrpcHealthCheckConfigFluent<GrpcNested<N>> implements Nested<N>{
  
    GrpcHealthCheckConfigBuilder builder;
  
    GrpcNested(GrpcHealthCheckConfig item) {
      this.builder = new GrpcHealthCheckConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReadinessProbeGrpcFluent.this.withGrpc(builder.build());
    }
    
    public N endGrpc() {
      return and();
    }
    
  }
}