package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class HTTPExternalAuthFilterFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPExternalAuthFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BackendObjectReferenceBuilder backendRef;
  private ForwardBodyConfigBuilder forwardBody;
  private GRPCAuthConfigBuilder grpc;
  private HTTPAuthConfigBuilder http;
  private String protocol;

  public HTTPExternalAuthFilterFluent() {
  }
  
  public HTTPExternalAuthFilterFluent(HTTPExternalAuthFilter instance) {
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
  
  public BackendObjectReference buildBackendRef() {
    return this.backendRef != null ? this.backendRef.build() : null;
  }
  
  public ForwardBodyConfig buildForwardBody() {
    return this.forwardBody != null ? this.forwardBody.build() : null;
  }
  
  public GRPCAuthConfig buildGrpc() {
    return this.grpc != null ? this.grpc.build() : null;
  }
  
  public HTTPAuthConfig buildHttp() {
    return this.http != null ? this.http.build() : null;
  }
  
  protected void copyInstance(HTTPExternalAuthFilter instance) {
    instance = instance != null ? instance : new HTTPExternalAuthFilter();
    if (instance != null) {
        this.withBackendRef(instance.getBackendRef());
        this.withForwardBody(instance.getForwardBody());
        this.withGrpc(instance.getGrpc());
        this.withHttp(instance.getHttp());
        this.withProtocol(instance.getProtocol());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BackendRefNested<A> editBackendRef() {
    return this.withNewBackendRefLike(Optional.ofNullable(this.buildBackendRef()).orElse(null));
  }
  
  public ForwardBodyNested<A> editForwardBody() {
    return this.withNewForwardBodyLike(Optional.ofNullable(this.buildForwardBody()).orElse(null));
  }
  
  public GrpcNested<A> editGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(null));
  }
  
  public HttpNested<A> editHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(null));
  }
  
  public BackendRefNested<A> editOrNewBackendRef() {
    return this.withNewBackendRefLike(Optional.ofNullable(this.buildBackendRef()).orElse(new BackendObjectReferenceBuilder().build()));
  }
  
  public BackendRefNested<A> editOrNewBackendRefLike(BackendObjectReference item) {
    return this.withNewBackendRefLike(Optional.ofNullable(this.buildBackendRef()).orElse(item));
  }
  
  public ForwardBodyNested<A> editOrNewForwardBody() {
    return this.withNewForwardBodyLike(Optional.ofNullable(this.buildForwardBody()).orElse(new ForwardBodyConfigBuilder().build()));
  }
  
  public ForwardBodyNested<A> editOrNewForwardBodyLike(ForwardBodyConfig item) {
    return this.withNewForwardBodyLike(Optional.ofNullable(this.buildForwardBody()).orElse(item));
  }
  
  public GrpcNested<A> editOrNewGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(new GRPCAuthConfigBuilder().build()));
  }
  
  public GrpcNested<A> editOrNewGrpcLike(GRPCAuthConfig item) {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(item));
  }
  
  public HttpNested<A> editOrNewHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(new HTTPAuthConfigBuilder().build()));
  }
  
  public HttpNested<A> editOrNewHttpLike(HTTPAuthConfig item) {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(item));
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
    HTTPExternalAuthFilterFluent that = (HTTPExternalAuthFilterFluent) o;
    if (!(Objects.equals(backendRef, that.backendRef))) {
      return false;
    }
    if (!(Objects.equals(forwardBody, that.forwardBody))) {
      return false;
    }
    if (!(Objects.equals(grpc, that.grpc))) {
      return false;
    }
    if (!(Objects.equals(http, that.http))) {
      return false;
    }
    if (!(Objects.equals(protocol, that.protocol))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackendRef() {
    return this.backendRef != null;
  }
  
  public boolean hasForwardBody() {
    return this.forwardBody != null;
  }
  
  public boolean hasGrpc() {
    return this.grpc != null;
  }
  
  public boolean hasHttp() {
    return this.http != null;
  }
  
  public boolean hasProtocol() {
    return this.protocol != null;
  }
  
  public int hashCode() {
    return Objects.hash(backendRef, forwardBody, grpc, http, protocol, additionalProperties);
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
    if (!(backendRef == null)) {
        sb.append("backendRef:");
        sb.append(backendRef);
        sb.append(",");
    }
    if (!(forwardBody == null)) {
        sb.append("forwardBody:");
        sb.append(forwardBody);
        sb.append(",");
    }
    if (!(grpc == null)) {
        sb.append("grpc:");
        sb.append(grpc);
        sb.append(",");
    }
    if (!(http == null)) {
        sb.append("http:");
        sb.append(http);
        sb.append(",");
    }
    if (!(protocol == null)) {
        sb.append("protocol:");
        sb.append(protocol);
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
  
  public A withBackendRef(BackendObjectReference backendRef) {
    this._visitables.remove("backendRef");
    if (backendRef != null) {
        this.backendRef = new BackendObjectReferenceBuilder(backendRef);
        this._visitables.get("backendRef").add(this.backendRef);
    } else {
        this.backendRef = null;
        this._visitables.get("backendRef").remove(this.backendRef);
    }
    return (A) this;
  }
  
  public A withForwardBody(ForwardBodyConfig forwardBody) {
    this._visitables.remove("forwardBody");
    if (forwardBody != null) {
        this.forwardBody = new ForwardBodyConfigBuilder(forwardBody);
        this._visitables.get("forwardBody").add(this.forwardBody);
    } else {
        this.forwardBody = null;
        this._visitables.get("forwardBody").remove(this.forwardBody);
    }
    return (A) this;
  }
  
  public A withGrpc(GRPCAuthConfig grpc) {
    this._visitables.remove("grpc");
    if (grpc != null) {
        this.grpc = new GRPCAuthConfigBuilder(grpc);
        this._visitables.get("grpc").add(this.grpc);
    } else {
        this.grpc = null;
        this._visitables.get("grpc").remove(this.grpc);
    }
    return (A) this;
  }
  
  public A withHttp(HTTPAuthConfig http) {
    this._visitables.remove("http");
    if (http != null) {
        this.http = new HTTPAuthConfigBuilder(http);
        this._visitables.get("http").add(this.http);
    } else {
        this.http = null;
        this._visitables.get("http").remove(this.http);
    }
    return (A) this;
  }
  
  public BackendRefNested<A> withNewBackendRef() {
    return new BackendRefNested(null);
  }
  
  public A withNewBackendRef(String group,String kind,String name,String namespace,Integer port) {
    return (A) this.withBackendRef(new BackendObjectReference(group, kind, name, namespace, port));
  }
  
  public BackendRefNested<A> withNewBackendRefLike(BackendObjectReference item) {
    return new BackendRefNested(item);
  }
  
  public ForwardBodyNested<A> withNewForwardBody() {
    return new ForwardBodyNested(null);
  }
  
  public A withNewForwardBody(Integer maxSize) {
    return (A) this.withForwardBody(new ForwardBodyConfig(maxSize));
  }
  
  public ForwardBodyNested<A> withNewForwardBodyLike(ForwardBodyConfig item) {
    return new ForwardBodyNested(item);
  }
  
  public GrpcNested<A> withNewGrpc() {
    return new GrpcNested(null);
  }
  
  public GrpcNested<A> withNewGrpcLike(GRPCAuthConfig item) {
    return new GrpcNested(item);
  }
  
  public HttpNested<A> withNewHttp() {
    return new HttpNested(null);
  }
  
  public HttpNested<A> withNewHttpLike(HTTPAuthConfig item) {
    return new HttpNested(item);
  }
  
  public A withProtocol(String protocol) {
    this.protocol = protocol;
    return (A) this;
  }
  public class BackendRefNested<N> extends BackendObjectReferenceFluent<BackendRefNested<N>> implements Nested<N>{
  
    BackendObjectReferenceBuilder builder;
  
    BackendRefNested(BackendObjectReference item) {
      this.builder = new BackendObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPExternalAuthFilterFluent.this.withBackendRef(builder.build());
    }
    
    public N endBackendRef() {
      return and();
    }
    
  }
  public class ForwardBodyNested<N> extends ForwardBodyConfigFluent<ForwardBodyNested<N>> implements Nested<N>{
  
    ForwardBodyConfigBuilder builder;
  
    ForwardBodyNested(ForwardBodyConfig item) {
      this.builder = new ForwardBodyConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPExternalAuthFilterFluent.this.withForwardBody(builder.build());
    }
    
    public N endForwardBody() {
      return and();
    }
    
  }
  public class GrpcNested<N> extends GRPCAuthConfigFluent<GrpcNested<N>> implements Nested<N>{
  
    GRPCAuthConfigBuilder builder;
  
    GrpcNested(GRPCAuthConfig item) {
      this.builder = new GRPCAuthConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPExternalAuthFilterFluent.this.withGrpc(builder.build());
    }
    
    public N endGrpc() {
      return and();
    }
    
  }
  public class HttpNested<N> extends HTTPAuthConfigFluent<HttpNested<N>> implements Nested<N>{
  
    HTTPAuthConfigBuilder builder;
  
    HttpNested(HTTPAuthConfig item) {
      this.builder = new HTTPAuthConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPExternalAuthFilterFluent.this.withHttp(builder.build());
    }
    
    public N endHttp() {
      return and();
    }
    
  }
}