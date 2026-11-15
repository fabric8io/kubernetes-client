package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class SessionPersistenceFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.SessionPersistenceFluent<A>> extends BaseFluent<A>{

  private String absoluteTimeout;
  private Map<String,Object> additionalProperties;
  private CookieConfigBuilder cookie;
  private HeaderConfigBuilder header;
  private String type;

  public SessionPersistenceFluent() {
  }
  
  public SessionPersistenceFluent(SessionPersistence instance) {
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
  
  public CookieConfig buildCookie() {
    return this.cookie != null ? this.cookie.build() : null;
  }
  
  public HeaderConfig buildHeader() {
    return this.header != null ? this.header.build() : null;
  }
  
  protected void copyInstance(SessionPersistence instance) {
    instance = instance != null ? instance : new SessionPersistence();
    if (instance != null) {
        this.withAbsoluteTimeout(instance.getAbsoluteTimeout());
        this.withCookie(instance.getCookie());
        this.withHeader(instance.getHeader());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CookieNested<A> editCookie() {
    return this.withNewCookieLike(Optional.ofNullable(this.buildCookie()).orElse(null));
  }
  
  public HeaderNested<A> editHeader() {
    return this.withNewHeaderLike(Optional.ofNullable(this.buildHeader()).orElse(null));
  }
  
  public CookieNested<A> editOrNewCookie() {
    return this.withNewCookieLike(Optional.ofNullable(this.buildCookie()).orElse(new CookieConfigBuilder().build()));
  }
  
  public CookieNested<A> editOrNewCookieLike(CookieConfig item) {
    return this.withNewCookieLike(Optional.ofNullable(this.buildCookie()).orElse(item));
  }
  
  public HeaderNested<A> editOrNewHeader() {
    return this.withNewHeaderLike(Optional.ofNullable(this.buildHeader()).orElse(new HeaderConfigBuilder().build()));
  }
  
  public HeaderNested<A> editOrNewHeaderLike(HeaderConfig item) {
    return this.withNewHeaderLike(Optional.ofNullable(this.buildHeader()).orElse(item));
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
    SessionPersistenceFluent that = (SessionPersistenceFluent) o;
    if (!(Objects.equals(absoluteTimeout, that.absoluteTimeout))) {
      return false;
    }
    if (!(Objects.equals(cookie, that.cookie))) {
      return false;
    }
    if (!(Objects.equals(header, that.header))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAbsoluteTimeout() {
    return this.absoluteTimeout;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAbsoluteTimeout() {
    return this.absoluteTimeout != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCookie() {
    return this.cookie != null;
  }
  
  public boolean hasHeader() {
    return this.header != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(absoluteTimeout, cookie, header, type, additionalProperties);
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
    if (!(absoluteTimeout == null)) {
        sb.append("absoluteTimeout:");
        sb.append(absoluteTimeout);
        sb.append(",");
    }
    if (!(cookie == null)) {
        sb.append("cookie:");
        sb.append(cookie);
        sb.append(",");
    }
    if (!(header == null)) {
        sb.append("header:");
        sb.append(header);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAbsoluteTimeout(String absoluteTimeout) {
    this.absoluteTimeout = absoluteTimeout;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withCookie(CookieConfig cookie) {
    this._visitables.remove("cookie");
    if (cookie != null) {
        this.cookie = new CookieConfigBuilder(cookie);
        this._visitables.get("cookie").add(this.cookie);
    } else {
        this.cookie = null;
        this._visitables.get("cookie").remove(this.cookie);
    }
    return (A) this;
  }
  
  public A withHeader(HeaderConfig header) {
    this._visitables.remove("header");
    if (header != null) {
        this.header = new HeaderConfigBuilder(header);
        this._visitables.get("header").add(this.header);
    } else {
        this.header = null;
        this._visitables.get("header").remove(this.header);
    }
    return (A) this;
  }
  
  public CookieNested<A> withNewCookie() {
    return new CookieNested(null);
  }
  
  public A withNewCookie(String lifetimeType,String name,String path) {
    return (A) this.withCookie(new CookieConfig(lifetimeType, name, path));
  }
  
  public CookieNested<A> withNewCookieLike(CookieConfig item) {
    return new CookieNested(item);
  }
  
  public HeaderNested<A> withNewHeader() {
    return new HeaderNested(null);
  }
  
  public A withNewHeader(String name) {
    return (A) this.withHeader(new HeaderConfig(name));
  }
  
  public HeaderNested<A> withNewHeaderLike(HeaderConfig item) {
    return new HeaderNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class CookieNested<N> extends CookieConfigFluent<CookieNested<N>> implements Nested<N>{
  
    CookieConfigBuilder builder;
  
    CookieNested(CookieConfig item) {
      this.builder = new CookieConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SessionPersistenceFluent.this.withCookie(builder.build());
    }
    
    public N endCookie() {
      return and();
    }
    
  }
  public class HeaderNested<N> extends HeaderConfigFluent<HeaderNested<N>> implements Nested<N>{
  
    HeaderConfigBuilder builder;
  
    HeaderNested(HeaderConfig item) {
      this.builder = new HeaderConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SessionPersistenceFluent.this.withHeader(builder.build());
    }
    
    public N endHeader() {
      return and();
    }
    
  }
}