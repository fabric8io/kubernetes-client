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
public class HTTPDirectResponseFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPDirectResponseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HTTPBodyBuilder body;
  private Long status;

  public HTTPDirectResponseFluent() {
  }
  
  public HTTPDirectResponseFluent(HTTPDirectResponse instance) {
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
  
  public HTTPBody buildBody() {
    return this.body != null ? this.body.build() : null;
  }
  
  protected void copyInstance(HTTPDirectResponse instance) {
    instance = instance != null ? instance : new HTTPDirectResponse();
    if (instance != null) {
        this.withBody(instance.getBody());
        this.withStatus(instance.getStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BodyNested<A> editBody() {
    return this.withNewBodyLike(Optional.ofNullable(this.buildBody()).orElse(null));
  }
  
  public BodyNested<A> editOrNewBody() {
    return this.withNewBodyLike(Optional.ofNullable(this.buildBody()).orElse(new HTTPBodyBuilder().build()));
  }
  
  public BodyNested<A> editOrNewBodyLike(HTTPBody item) {
    return this.withNewBodyLike(Optional.ofNullable(this.buildBody()).orElse(item));
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
    HTTPDirectResponseFluent that = (HTTPDirectResponseFluent) o;
    if (!(Objects.equals(body, that.body))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
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
  
  public Long getStatus() {
    return this.status;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBody() {
    return this.body != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public int hashCode() {
    return Objects.hash(body, status, additionalProperties);
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
    if (!(body == null)) {
        sb.append("body:");
        sb.append(body);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
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
  
  public A withBody(HTTPBody body) {
    this._visitables.remove("body");
    if (body != null) {
        this.body = new HTTPBodyBuilder(body);
        this._visitables.get("body").add(this.body);
    } else {
        this.body = null;
        this._visitables.get("body").remove(this.body);
    }
    return (A) this;
  }
  
  public BodyNested<A> withNewBody() {
    return new BodyNested(null);
  }
  
  public BodyNested<A> withNewBodyLike(HTTPBody item) {
    return new BodyNested(item);
  }
  
  public A withStatus(Long status) {
    this.status = status;
    return (A) this;
  }
  public class BodyNested<N> extends HTTPBodyFluent<BodyNested<N>> implements Nested<N>{
  
    HTTPBodyBuilder builder;
  
    BodyNested(HTTPBody item) {
      this.builder = new HTTPBodyBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPDirectResponseFluent.this.withBody(builder.build());
    }
    
    public N endBody() {
      return and();
    }
    
  }
}