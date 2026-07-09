package io.fabric8.kubernetes.api.model.networking.v1beta1;

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
public class IngressRuleFluent<A extends io.fabric8.kubernetes.api.model.networking.v1beta1.IngressRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String host;
  private HTTPIngressRuleValueBuilder http;

  public IngressRuleFluent() {
  }
  
  public IngressRuleFluent(IngressRule instance) {
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
  
  public HTTPIngressRuleValue buildHttp() {
    return this.http != null ? this.http.build() : null;
  }
  
  protected void copyInstance(IngressRule instance) {
    instance = instance != null ? instance : new IngressRule();
    if (instance != null) {
        this.withHost(instance.getHost());
        this.withHttp(instance.getHttp());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpNested<A> editHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(null));
  }
  
  public HttpNested<A> editOrNewHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(new HTTPIngressRuleValueBuilder().build()));
  }
  
  public HttpNested<A> editOrNewHttpLike(HTTPIngressRuleValue item) {
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
    IngressRuleFluent that = (IngressRuleFluent) o;
    if (!(Objects.equals(host, that.host))) {
      return false;
    }
    if (!(Objects.equals(http, that.http))) {
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
  
  public String getHost() {
    return this.host;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHost() {
    return this.host != null;
  }
  
  public boolean hasHttp() {
    return this.http != null;
  }
  
  public int hashCode() {
    return Objects.hash(host, http, additionalProperties);
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
    if (!(host == null)) {
        sb.append("host:");
        sb.append(host);
        sb.append(",");
    }
    if (!(http == null)) {
        sb.append("http:");
        sb.append(http);
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
  
  public A withHost(String host) {
    this.host = host;
    return (A) this;
  }
  
  public A withHttp(HTTPIngressRuleValue http) {
    this._visitables.remove("http");
    if (http != null) {
        this.http = new HTTPIngressRuleValueBuilder(http);
        this._visitables.get("http").add(this.http);
    } else {
        this.http = null;
        this._visitables.get("http").remove(this.http);
    }
    return (A) this;
  }
  
  public HttpNested<A> withNewHttp() {
    return new HttpNested(null);
  }
  
  public HttpNested<A> withNewHttpLike(HTTPIngressRuleValue item) {
    return new HttpNested(item);
  }
  public class HttpNested<N> extends HTTPIngressRuleValueFluent<HttpNested<N>> implements Nested<N>{
  
    HTTPIngressRuleValueBuilder builder;
  
    HttpNested(HTTPIngressRuleValue item) {
      this.builder = new HTTPIngressRuleValueBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressRuleFluent.this.withHttp(builder.build());
    }
    
    public N endHttp() {
      return and();
    }
    
  }
}