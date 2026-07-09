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
  private CookieConfigBuilder cookieConfig;
  private String idleTimeout;
  private String sessionName;
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
  
  public CookieConfig buildCookieConfig() {
    return this.cookieConfig != null ? this.cookieConfig.build() : null;
  }
  
  protected void copyInstance(SessionPersistence instance) {
    instance = instance != null ? instance : new SessionPersistence();
    if (instance != null) {
        this.withAbsoluteTimeout(instance.getAbsoluteTimeout());
        this.withCookieConfig(instance.getCookieConfig());
        this.withIdleTimeout(instance.getIdleTimeout());
        this.withSessionName(instance.getSessionName());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CookieConfigNested<A> editCookieConfig() {
    return this.withNewCookieConfigLike(Optional.ofNullable(this.buildCookieConfig()).orElse(null));
  }
  
  public CookieConfigNested<A> editOrNewCookieConfig() {
    return this.withNewCookieConfigLike(Optional.ofNullable(this.buildCookieConfig()).orElse(new CookieConfigBuilder().build()));
  }
  
  public CookieConfigNested<A> editOrNewCookieConfigLike(CookieConfig item) {
    return this.withNewCookieConfigLike(Optional.ofNullable(this.buildCookieConfig()).orElse(item));
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
    if (!(Objects.equals(cookieConfig, that.cookieConfig))) {
      return false;
    }
    if (!(Objects.equals(idleTimeout, that.idleTimeout))) {
      return false;
    }
    if (!(Objects.equals(sessionName, that.sessionName))) {
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
  
  public String getIdleTimeout() {
    return this.idleTimeout;
  }
  
  public String getSessionName() {
    return this.sessionName;
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
  
  public boolean hasCookieConfig() {
    return this.cookieConfig != null;
  }
  
  public boolean hasIdleTimeout() {
    return this.idleTimeout != null;
  }
  
  public boolean hasSessionName() {
    return this.sessionName != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(absoluteTimeout, cookieConfig, idleTimeout, sessionName, type, additionalProperties);
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
    if (!(cookieConfig == null)) {
        sb.append("cookieConfig:");
        sb.append(cookieConfig);
        sb.append(",");
    }
    if (!(idleTimeout == null)) {
        sb.append("idleTimeout:");
        sb.append(idleTimeout);
        sb.append(",");
    }
    if (!(sessionName == null)) {
        sb.append("sessionName:");
        sb.append(sessionName);
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
  
  public A withCookieConfig(CookieConfig cookieConfig) {
    this._visitables.remove("cookieConfig");
    if (cookieConfig != null) {
        this.cookieConfig = new CookieConfigBuilder(cookieConfig);
        this._visitables.get("cookieConfig").add(this.cookieConfig);
    } else {
        this.cookieConfig = null;
        this._visitables.get("cookieConfig").remove(this.cookieConfig);
    }
    return (A) this;
  }
  
  public A withIdleTimeout(String idleTimeout) {
    this.idleTimeout = idleTimeout;
    return (A) this;
  }
  
  public CookieConfigNested<A> withNewCookieConfig() {
    return new CookieConfigNested(null);
  }
  
  public A withNewCookieConfig(String lifetimeType) {
    return (A) this.withCookieConfig(new CookieConfig(lifetimeType));
  }
  
  public CookieConfigNested<A> withNewCookieConfigLike(CookieConfig item) {
    return new CookieConfigNested(item);
  }
  
  public A withSessionName(String sessionName) {
    this.sessionName = sessionName;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class CookieConfigNested<N> extends CookieConfigFluent<CookieConfigNested<N>> implements Nested<N>{
  
    CookieConfigBuilder builder;
  
    CookieConfigNested(CookieConfig item) {
      this.builder = new CookieConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SessionPersistenceFluent.this.withCookieConfig(builder.build());
    }
    
    public N endCookieConfig() {
      return and();
    }
    
  }
}