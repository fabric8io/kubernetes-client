package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class WebHTTPConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.WebHTTPConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private WebHTTPHeadersBuilder headers;
  private Boolean http2;

  public WebHTTPConfigFluent() {
  }
  
  public WebHTTPConfigFluent(WebHTTPConfig instance) {
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
  
  public WebHTTPHeaders buildHeaders() {
    return this.headers != null ? this.headers.build() : null;
  }
  
  protected void copyInstance(WebHTTPConfig instance) {
    instance = instance != null ? instance : new WebHTTPConfig();
    if (instance != null) {
        this.withHeaders(instance.getHeaders());
        this.withHttp2(instance.getHttp2());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HeadersNested<A> editHeaders() {
    return this.withNewHeadersLike(Optional.ofNullable(this.buildHeaders()).orElse(null));
  }
  
  public HeadersNested<A> editOrNewHeaders() {
    return this.withNewHeadersLike(Optional.ofNullable(this.buildHeaders()).orElse(new WebHTTPHeadersBuilder().build()));
  }
  
  public HeadersNested<A> editOrNewHeadersLike(WebHTTPHeaders item) {
    return this.withNewHeadersLike(Optional.ofNullable(this.buildHeaders()).orElse(item));
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
    WebHTTPConfigFluent that = (WebHTTPConfigFluent) o;
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(http2, that.http2))) {
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
  
  public Boolean getHttp2() {
    return this.http2;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasHttp2() {
    return this.http2 != null;
  }
  
  public int hashCode() {
    return Objects.hash(headers, http2, additionalProperties);
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
    if (!(headers == null)) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(http2 == null)) {
        sb.append("http2:");
        sb.append(http2);
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
  
  public A withHeaders(WebHTTPHeaders headers) {
    this._visitables.remove("headers");
    if (headers != null) {
        this.headers = new WebHTTPHeadersBuilder(headers);
        this._visitables.get("headers").add(this.headers);
    } else {
        this.headers = null;
        this._visitables.get("headers").remove(this.headers);
    }
    return (A) this;
  }
  
  public A withHttp2() {
    return withHttp2(true);
  }
  
  public A withHttp2(Boolean http2) {
    this.http2 = http2;
    return (A) this;
  }
  
  public HeadersNested<A> withNewHeaders() {
    return new HeadersNested(null);
  }
  
  public A withNewHeaders(String contentSecurityPolicy,String strictTransportSecurity,String xContentTypeOptions,String xFrameOptions,String xXSSProtection) {
    return (A) this.withHeaders(new WebHTTPHeaders(contentSecurityPolicy, strictTransportSecurity, xContentTypeOptions, xFrameOptions, xXSSProtection));
  }
  
  public HeadersNested<A> withNewHeadersLike(WebHTTPHeaders item) {
    return new HeadersNested(item);
  }
  public class HeadersNested<N> extends WebHTTPHeadersFluent<HeadersNested<N>> implements Nested<N>{
  
    WebHTTPHeadersBuilder builder;
  
    HeadersNested(WebHTTPHeaders item) {
      this.builder = new WebHTTPHeadersBuilder(this, item);
    }
  
    public N and() {
      return (N) WebHTTPConfigFluent.this.withHeaders(builder.build());
    }
    
    public N endHeaders() {
      return and();
    }
    
  }
}