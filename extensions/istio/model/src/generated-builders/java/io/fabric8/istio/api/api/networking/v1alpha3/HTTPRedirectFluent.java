package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Long;
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
public class HTTPRedirectFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPRedirectFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authority;
  private Long redirectCode;
  private VisitableBuilder<? extends IsHTTPRedirectRedirectPort,?> redirectPort;
  private String scheme;
  private String uri;

  public HTTPRedirectFluent() {
  }
  
  public HTTPRedirectFluent(HTTPRedirect instance) {
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
  
  public IsHTTPRedirectRedirectPort buildRedirectPort() {
    return this.redirectPort != null ? this.redirectPort.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "HTTPRedirectDerivePort":
    
          return (VisitableBuilder<T,?>) new HTTPRedirectDerivePortBuilder((HTTPRedirectDerivePort) item);
    
      case "HTTPRedirectPort":
    
          return (VisitableBuilder<T,?>) new HTTPRedirectPortBuilder((HTTPRedirectPort) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(HTTPRedirect instance) {
    instance = instance != null ? instance : new HTTPRedirect();
    if (instance != null) {
        this.withRedirectPort(instance.getRedirectPort());
        this.withAuthority(instance.getAuthority());
        this.withRedirectCode(instance.getRedirectCode());
        this.withScheme(instance.getScheme());
        this.withUri(instance.getUri());
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
    HTTPRedirectFluent that = (HTTPRedirectFluent) o;
    if (!(Objects.equals(redirectPort, that.redirectPort))) {
      return false;
    }
    if (!(Objects.equals(authority, that.authority))) {
      return false;
    }
    if (!(Objects.equals(redirectCode, that.redirectCode))) {
      return false;
    }
    if (!(Objects.equals(scheme, that.scheme))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
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
  
  public String getAuthority() {
    return this.authority;
  }
  
  public Long getRedirectCode() {
    return this.redirectCode;
  }
  
  public String getScheme() {
    return this.scheme;
  }
  
  public String getUri() {
    return this.uri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthority() {
    return this.authority != null;
  }
  
  public boolean hasRedirectCode() {
    return this.redirectCode != null;
  }
  
  public boolean hasRedirectPort() {
    return this.redirectPort != null;
  }
  
  public boolean hasScheme() {
    return this.scheme != null;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public int hashCode() {
    return Objects.hash(redirectPort, authority, redirectCode, scheme, uri, additionalProperties);
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
    if (!(redirectPort == null)) {
        sb.append("redirectPort:");
        sb.append(redirectPort);
        sb.append(",");
    }
    if (!(authority == null)) {
        sb.append("authority:");
        sb.append(authority);
        sb.append(",");
    }
    if (!(redirectCode == null)) {
        sb.append("redirectCode:");
        sb.append(redirectCode);
        sb.append(",");
    }
    if (!(scheme == null)) {
        sb.append("scheme:");
        sb.append(scheme);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
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
  
  public A withAuthority(String authority) {
    this.authority = authority;
    return (A) this;
  }
  
  public HTTPRedirectDerivePortNested<A> withNewHTTPRedirectDerivePort() {
    return new HTTPRedirectDerivePortNested(null);
  }
  
  public HTTPRedirectDerivePortNested<A> withNewHTTPRedirectDerivePortLike(HTTPRedirectDerivePort item) {
    return new HTTPRedirectDerivePortNested(item);
  }
  
  public HTTPRedirectPortNested<A> withNewHTTPRedirectPort() {
    return new HTTPRedirectPortNested(null);
  }
  
  public A withNewHTTPRedirectPort(Long port) {
    return (A) this.withRedirectPort(new HTTPRedirectPort(port));
  }
  
  public HTTPRedirectPortNested<A> withNewHTTPRedirectPortLike(HTTPRedirectPort item) {
    return new HTTPRedirectPortNested(item);
  }
  
  public A withRedirectCode(Long redirectCode) {
    this.redirectCode = redirectCode;
    return (A) this;
  }
  
  public A withRedirectPort(IsHTTPRedirectRedirectPort redirectPort) {
    if (redirectPort == null) {
        this.redirectPort = null;
        this._visitables.remove("redirectPort");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsHTTPRedirectRedirectPort,?> builder = builder(redirectPort);
        this._visitables.get("redirectPort").clear();
        this._visitables.get("redirectPort").add(builder);
        this.redirectPort = builder;
        return (A) this;
    }
  }
  
  public A withScheme(String scheme) {
    this.scheme = scheme;
    return (A) this;
  }
  
  public A withUri(String uri) {
    this.uri = uri;
    return (A) this;
  }
  public class HTTPRedirectDerivePortNested<N> extends HTTPRedirectDerivePortFluent<HTTPRedirectDerivePortNested<N>> implements Nested<N>{
  
    HTTPRedirectDerivePortBuilder builder;
  
    HTTPRedirectDerivePortNested(HTTPRedirectDerivePort item) {
      this.builder = new HTTPRedirectDerivePortBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRedirectFluent.this.withRedirectPort(builder.build());
    }
    
    public N endHTTPRedirectDerivePort() {
      return and();
    }
    
  }
  public class HTTPRedirectPortNested<N> extends HTTPRedirectPortFluent<HTTPRedirectPortNested<N>> implements Nested<N>{
  
    HTTPRedirectPortBuilder builder;
  
    HTTPRedirectPortNested(HTTPRedirectPort item) {
      this.builder = new HTTPRedirectPortBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRedirectFluent.this.withRedirectPort(builder.build());
    }
    
    public N endHTTPRedirectPort() {
      return and();
    }
    
  }
}