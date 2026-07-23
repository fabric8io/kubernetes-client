package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class LoadBalancerSettingsConsistentHashLBHttpCookieFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBHttpCookieFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder httpCookie;

  public LoadBalancerSettingsConsistentHashLBHttpCookieFluent() {
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpCookieFluent(LoadBalancerSettingsConsistentHashLBHttpCookie instance) {
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
  
  public LoadBalancerSettingsConsistentHashLBHTTPCookie_ buildHttpCookie() {
    return this.httpCookie != null ? this.httpCookie.build() : null;
  }
  
  protected void copyInstance(LoadBalancerSettingsConsistentHashLBHttpCookie instance) {
    instance = instance != null ? instance : new LoadBalancerSettingsConsistentHashLBHttpCookie();
    if (instance != null) {
        this.withHttpCookie(instance.getHttpCookie());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpCookieNested<A> editHttpCookie() {
    return this.withNewHttpCookieLike(Optional.ofNullable(this.buildHttpCookie()).orElse(null));
  }
  
  public HttpCookieNested<A> editOrNewHttpCookie() {
    return this.withNewHttpCookieLike(Optional.ofNullable(this.buildHttpCookie()).orElse(new LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder().build()));
  }
  
  public HttpCookieNested<A> editOrNewHttpCookieLike(LoadBalancerSettingsConsistentHashLBHTTPCookie_ item) {
    return this.withNewHttpCookieLike(Optional.ofNullable(this.buildHttpCookie()).orElse(item));
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
    LoadBalancerSettingsConsistentHashLBHttpCookieFluent that = (LoadBalancerSettingsConsistentHashLBHttpCookieFluent) o;
    if (!(Objects.equals(httpCookie, that.httpCookie))) {
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
  
  public boolean hasHttpCookie() {
    return this.httpCookie != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpCookie, additionalProperties);
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
    if (!(httpCookie == null)) {
        sb.append("httpCookie:");
        sb.append(httpCookie);
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
  
  public A withHttpCookie(LoadBalancerSettingsConsistentHashLBHTTPCookie_ httpCookie) {
    this._visitables.remove("httpCookie");
    if (httpCookie != null) {
        this.httpCookie = new LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder(httpCookie);
        this._visitables.get("httpCookie").add(this.httpCookie);
    } else {
        this.httpCookie = null;
        this._visitables.get("httpCookie").remove(this.httpCookie);
    }
    return (A) this;
  }
  
  public HttpCookieNested<A> withNewHttpCookie() {
    return new HttpCookieNested(null);
  }
  
  public HttpCookieNested<A> withNewHttpCookieLike(LoadBalancerSettingsConsistentHashLBHTTPCookie_ item) {
    return new HttpCookieNested(item);
  }
  public class HttpCookieNested<N> extends LoadBalancerSettingsConsistentHashLBHTTPCookie_Fluent<HttpCookieNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder builder;
  
    HttpCookieNested(LoadBalancerSettingsConsistentHashLBHTTPCookie_ item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashLBHttpCookieFluent.this.withHttpCookie(builder.build());
    }
    
    public N endHttpCookie() {
      return and();
    }
    
  }
}