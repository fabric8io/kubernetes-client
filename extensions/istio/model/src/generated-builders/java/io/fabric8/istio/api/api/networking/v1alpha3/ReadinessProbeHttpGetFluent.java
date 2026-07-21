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
public class ReadinessProbeHttpGetFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ReadinessProbeHttpGetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HTTPHealthCheckConfigBuilder httpGet;

  public ReadinessProbeHttpGetFluent() {
  }
  
  public ReadinessProbeHttpGetFluent(ReadinessProbeHttpGet instance) {
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
  
  public HTTPHealthCheckConfig buildHttpGet() {
    return this.httpGet != null ? this.httpGet.build() : null;
  }
  
  protected void copyInstance(ReadinessProbeHttpGet instance) {
    instance = instance != null ? instance : new ReadinessProbeHttpGet();
    if (instance != null) {
        this.withHttpGet(instance.getHttpGet());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpGetNested<A> editHttpGet() {
    return this.withNewHttpGetLike(Optional.ofNullable(this.buildHttpGet()).orElse(null));
  }
  
  public HttpGetNested<A> editOrNewHttpGet() {
    return this.withNewHttpGetLike(Optional.ofNullable(this.buildHttpGet()).orElse(new HTTPHealthCheckConfigBuilder().build()));
  }
  
  public HttpGetNested<A> editOrNewHttpGetLike(HTTPHealthCheckConfig item) {
    return this.withNewHttpGetLike(Optional.ofNullable(this.buildHttpGet()).orElse(item));
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
    ReadinessProbeHttpGetFluent that = (ReadinessProbeHttpGetFluent) o;
    if (!(Objects.equals(httpGet, that.httpGet))) {
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
  
  public boolean hasHttpGet() {
    return this.httpGet != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpGet, additionalProperties);
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
    if (!(httpGet == null)) {
        sb.append("httpGet:");
        sb.append(httpGet);
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
  
  public A withHttpGet(HTTPHealthCheckConfig httpGet) {
    this._visitables.remove("httpGet");
    if (httpGet != null) {
        this.httpGet = new HTTPHealthCheckConfigBuilder(httpGet);
        this._visitables.get("httpGet").add(this.httpGet);
    } else {
        this.httpGet = null;
        this._visitables.get("httpGet").remove(this.httpGet);
    }
    return (A) this;
  }
  
  public HttpGetNested<A> withNewHttpGet() {
    return new HttpGetNested(null);
  }
  
  public HttpGetNested<A> withNewHttpGetLike(HTTPHealthCheckConfig item) {
    return new HttpGetNested(item);
  }
  public class HttpGetNested<N> extends HTTPHealthCheckConfigFluent<HttpGetNested<N>> implements Nested<N>{
  
    HTTPHealthCheckConfigBuilder builder;
  
    HttpGetNested(HTTPHealthCheckConfig item) {
      this.builder = new HTTPHealthCheckConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ReadinessProbeHttpGetFluent.this.withHttpGet(builder.build());
    }
    
    public N endHttpGet() {
      return and();
    }
    
  }
}