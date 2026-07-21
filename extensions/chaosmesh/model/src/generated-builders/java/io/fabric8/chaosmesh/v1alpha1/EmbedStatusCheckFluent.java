package io.fabric8.chaosmesh.v1alpha1;

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
public class EmbedStatusCheckFluent<A extends io.fabric8.chaosmesh.v1alpha1.EmbedStatusCheckFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HTTPStatusCheckBuilder http;

  public EmbedStatusCheckFluent() {
  }
  
  public EmbedStatusCheckFluent(EmbedStatusCheck instance) {
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
  
  public HTTPStatusCheck buildHttp() {
    return this.http != null ? this.http.build() : null;
  }
  
  protected void copyInstance(EmbedStatusCheck instance) {
    instance = instance != null ? instance : new EmbedStatusCheck();
    if (instance != null) {
        this.withHttp(instance.getHttp());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpNested<A> editHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(null));
  }
  
  public HttpNested<A> editOrNewHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(new HTTPStatusCheckBuilder().build()));
  }
  
  public HttpNested<A> editOrNewHttpLike(HTTPStatusCheck item) {
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
    EmbedStatusCheckFluent that = (EmbedStatusCheckFluent) o;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttp() {
    return this.http != null;
  }
  
  public int hashCode() {
    return Objects.hash(http, additionalProperties);
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
  
  public A withHttp(HTTPStatusCheck http) {
    this._visitables.remove("http");
    if (http != null) {
        this.http = new HTTPStatusCheckBuilder(http);
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
  
  public HttpNested<A> withNewHttpLike(HTTPStatusCheck item) {
    return new HttpNested(item);
  }
  public class HttpNested<N> extends HTTPStatusCheckFluent<HttpNested<N>> implements Nested<N>{
  
    HTTPStatusCheckBuilder builder;
  
    HttpNested(HTTPStatusCheck item) {
      this.builder = new HTTPStatusCheckBuilder(this, item);
    }
  
    public N and() {
      return (N) EmbedStatusCheckFluent.this.withHttp(builder.build());
    }
    
    public N endHttp() {
      return and();
    }
    
  }
}