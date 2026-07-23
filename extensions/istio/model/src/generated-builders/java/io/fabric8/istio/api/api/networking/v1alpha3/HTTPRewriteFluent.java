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
public class HTTPRewriteFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPRewriteFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authority;
  private String uri;
  private RegexRewriteBuilder uriRegexRewrite;

  public HTTPRewriteFluent() {
  }
  
  public HTTPRewriteFluent(HTTPRewrite instance) {
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
  
  public RegexRewrite buildUriRegexRewrite() {
    return this.uriRegexRewrite != null ? this.uriRegexRewrite.build() : null;
  }
  
  protected void copyInstance(HTTPRewrite instance) {
    instance = instance != null ? instance : new HTTPRewrite();
    if (instance != null) {
        this.withAuthority(instance.getAuthority());
        this.withUri(instance.getUri());
        this.withUriRegexRewrite(instance.getUriRegexRewrite());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public UriRegexRewriteNested<A> editOrNewUriRegexRewrite() {
    return this.withNewUriRegexRewriteLike(Optional.ofNullable(this.buildUriRegexRewrite()).orElse(new RegexRewriteBuilder().build()));
  }
  
  public UriRegexRewriteNested<A> editOrNewUriRegexRewriteLike(RegexRewrite item) {
    return this.withNewUriRegexRewriteLike(Optional.ofNullable(this.buildUriRegexRewrite()).orElse(item));
  }
  
  public UriRegexRewriteNested<A> editUriRegexRewrite() {
    return this.withNewUriRegexRewriteLike(Optional.ofNullable(this.buildUriRegexRewrite()).orElse(null));
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
    HTTPRewriteFluent that = (HTTPRewriteFluent) o;
    if (!(Objects.equals(authority, that.authority))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
      return false;
    }
    if (!(Objects.equals(uriRegexRewrite, that.uriRegexRewrite))) {
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
  
  public String getUri() {
    return this.uri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthority() {
    return this.authority != null;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public boolean hasUriRegexRewrite() {
    return this.uriRegexRewrite != null;
  }
  
  public int hashCode() {
    return Objects.hash(authority, uri, uriRegexRewrite, additionalProperties);
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
    if (!(authority == null)) {
        sb.append("authority:");
        sb.append(authority);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
        sb.append(",");
    }
    if (!(uriRegexRewrite == null)) {
        sb.append("uriRegexRewrite:");
        sb.append(uriRegexRewrite);
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
  
  public UriRegexRewriteNested<A> withNewUriRegexRewrite() {
    return new UriRegexRewriteNested(null);
  }
  
  public A withNewUriRegexRewrite(String match,String rewrite) {
    return (A) this.withUriRegexRewrite(new RegexRewrite(match, rewrite));
  }
  
  public UriRegexRewriteNested<A> withNewUriRegexRewriteLike(RegexRewrite item) {
    return new UriRegexRewriteNested(item);
  }
  
  public A withUri(String uri) {
    this.uri = uri;
    return (A) this;
  }
  
  public A withUriRegexRewrite(RegexRewrite uriRegexRewrite) {
    this._visitables.remove("uriRegexRewrite");
    if (uriRegexRewrite != null) {
        this.uriRegexRewrite = new RegexRewriteBuilder(uriRegexRewrite);
        this._visitables.get("uriRegexRewrite").add(this.uriRegexRewrite);
    } else {
        this.uriRegexRewrite = null;
        this._visitables.get("uriRegexRewrite").remove(this.uriRegexRewrite);
    }
    return (A) this;
  }
  public class UriRegexRewriteNested<N> extends RegexRewriteFluent<UriRegexRewriteNested<N>> implements Nested<N>{
  
    RegexRewriteBuilder builder;
  
    UriRegexRewriteNested(RegexRewrite item) {
      this.builder = new RegexRewriteBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRewriteFluent.this.withUriRegexRewrite(builder.build());
    }
    
    public N endUriRegexRewrite() {
      return and();
    }
    
  }
}