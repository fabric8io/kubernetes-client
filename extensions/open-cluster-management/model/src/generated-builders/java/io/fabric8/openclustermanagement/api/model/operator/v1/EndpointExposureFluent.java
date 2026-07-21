package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class EndpointExposureFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.EndpointExposureFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EndpointBuilder grpc;
  private EndpointBuilder https;
  private String protocol;
  private String usage;

  public EndpointExposureFluent() {
  }
  
  public EndpointExposureFluent(EndpointExposure instance) {
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
  
  public Endpoint buildGrpc() {
    return this.grpc != null ? this.grpc.build() : null;
  }
  
  public Endpoint buildHttps() {
    return this.https != null ? this.https.build() : null;
  }
  
  protected void copyInstance(EndpointExposure instance) {
    instance = instance != null ? instance : new EndpointExposure();
    if (instance != null) {
        this.withGrpc(instance.getGrpc());
        this.withHttps(instance.getHttps());
        this.withProtocol(instance.getProtocol());
        this.withUsage(instance.getUsage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GrpcNested<A> editGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(null));
  }
  
  public HttpsNested<A> editHttps() {
    return this.withNewHttpsLike(Optional.ofNullable(this.buildHttps()).orElse(null));
  }
  
  public GrpcNested<A> editOrNewGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(new EndpointBuilder().build()));
  }
  
  public GrpcNested<A> editOrNewGrpcLike(Endpoint item) {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(item));
  }
  
  public HttpsNested<A> editOrNewHttps() {
    return this.withNewHttpsLike(Optional.ofNullable(this.buildHttps()).orElse(new EndpointBuilder().build()));
  }
  
  public HttpsNested<A> editOrNewHttpsLike(Endpoint item) {
    return this.withNewHttpsLike(Optional.ofNullable(this.buildHttps()).orElse(item));
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
    EndpointExposureFluent that = (EndpointExposureFluent) o;
    if (!(Objects.equals(grpc, that.grpc))) {
      return false;
    }
    if (!(Objects.equals(https, that.https))) {
      return false;
    }
    if (!(Objects.equals(protocol, that.protocol))) {
      return false;
    }
    if (!(Objects.equals(usage, that.usage))) {
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
  
  public String getProtocol() {
    return this.protocol;
  }
  
  public String getUsage() {
    return this.usage;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGrpc() {
    return this.grpc != null;
  }
  
  public boolean hasHttps() {
    return this.https != null;
  }
  
  public boolean hasProtocol() {
    return this.protocol != null;
  }
  
  public boolean hasUsage() {
    return this.usage != null;
  }
  
  public int hashCode() {
    return Objects.hash(grpc, https, protocol, usage, additionalProperties);
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
    if (!(https == null)) {
        sb.append("https:");
        sb.append(https);
        sb.append(",");
    }
    if (!(protocol == null)) {
        sb.append("protocol:");
        sb.append(protocol);
        sb.append(",");
    }
    if (!(usage == null)) {
        sb.append("usage:");
        sb.append(usage);
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
  
  public A withGrpc(Endpoint grpc) {
    this._visitables.remove("grpc");
    if (grpc != null) {
        this.grpc = new EndpointBuilder(grpc);
        this._visitables.get("grpc").add(this.grpc);
    } else {
        this.grpc = null;
        this._visitables.get("grpc").remove(this.grpc);
    }
    return (A) this;
  }
  
  public A withHttps(Endpoint https) {
    this._visitables.remove("https");
    if (https != null) {
        this.https = new EndpointBuilder(https);
        this._visitables.get("https").add(this.https);
    } else {
        this.https = null;
        this._visitables.get("https").remove(this.https);
    }
    return (A) this;
  }
  
  public GrpcNested<A> withNewGrpc() {
    return new GrpcNested(null);
  }
  
  public GrpcNested<A> withNewGrpcLike(Endpoint item) {
    return new GrpcNested(item);
  }
  
  public HttpsNested<A> withNewHttps() {
    return new HttpsNested(null);
  }
  
  public HttpsNested<A> withNewHttpsLike(Endpoint item) {
    return new HttpsNested(item);
  }
  
  public A withProtocol(String protocol) {
    this.protocol = protocol;
    return (A) this;
  }
  
  public A withUsage(String usage) {
    this.usage = usage;
    return (A) this;
  }
  public class GrpcNested<N> extends EndpointFluent<GrpcNested<N>> implements Nested<N>{
  
    EndpointBuilder builder;
  
    GrpcNested(Endpoint item) {
      this.builder = new EndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointExposureFluent.this.withGrpc(builder.build());
    }
    
    public N endGrpc() {
      return and();
    }
    
  }
  public class HttpsNested<N> extends EndpointFluent<HttpsNested<N>> implements Nested<N>{
  
    EndpointBuilder builder;
  
    HttpsNested(Endpoint item) {
      this.builder = new EndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointExposureFluent.this.withHttps(builder.build());
    }
    
    public N endHttps() {
      return and();
    }
    
  }
}