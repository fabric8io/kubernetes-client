package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class TokenConfigFluent<A extends io.fabric8.openshift.api.model.config.v1.TokenConfigFluent<A>> extends BaseFluent<A>{

  private String accessTokenInactivityTimeout;
  private Integer accessTokenInactivityTimeoutSeconds;
  private Integer accessTokenMaxAgeSeconds;
  private Map<String,Object> additionalProperties;

  public TokenConfigFluent() {
  }
  
  public TokenConfigFluent(TokenConfig instance) {
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
  
  protected void copyInstance(TokenConfig instance) {
    instance = instance != null ? instance : new TokenConfig();
    if (instance != null) {
        this.withAccessTokenInactivityTimeout(instance.getAccessTokenInactivityTimeout());
        this.withAccessTokenInactivityTimeoutSeconds(instance.getAccessTokenInactivityTimeoutSeconds());
        this.withAccessTokenMaxAgeSeconds(instance.getAccessTokenMaxAgeSeconds());
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
    TokenConfigFluent that = (TokenConfigFluent) o;
    if (!(Objects.equals(accessTokenInactivityTimeout, that.accessTokenInactivityTimeout))) {
      return false;
    }
    if (!(Objects.equals(accessTokenInactivityTimeoutSeconds, that.accessTokenInactivityTimeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(accessTokenMaxAgeSeconds, that.accessTokenMaxAgeSeconds))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAccessTokenInactivityTimeout() {
    return this.accessTokenInactivityTimeout;
  }
  
  public Integer getAccessTokenInactivityTimeoutSeconds() {
    return this.accessTokenInactivityTimeoutSeconds;
  }
  
  public Integer getAccessTokenMaxAgeSeconds() {
    return this.accessTokenMaxAgeSeconds;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAccessTokenInactivityTimeout() {
    return this.accessTokenInactivityTimeout != null;
  }
  
  public boolean hasAccessTokenInactivityTimeoutSeconds() {
    return this.accessTokenInactivityTimeoutSeconds != null;
  }
  
  public boolean hasAccessTokenMaxAgeSeconds() {
    return this.accessTokenMaxAgeSeconds != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessTokenInactivityTimeout, accessTokenInactivityTimeoutSeconds, accessTokenMaxAgeSeconds, additionalProperties);
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
    if (!(accessTokenInactivityTimeout == null)) {
        sb.append("accessTokenInactivityTimeout:");
        sb.append(accessTokenInactivityTimeout);
        sb.append(",");
    }
    if (!(accessTokenInactivityTimeoutSeconds == null)) {
        sb.append("accessTokenInactivityTimeoutSeconds:");
        sb.append(accessTokenInactivityTimeoutSeconds);
        sb.append(",");
    }
    if (!(accessTokenMaxAgeSeconds == null)) {
        sb.append("accessTokenMaxAgeSeconds:");
        sb.append(accessTokenMaxAgeSeconds);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessTokenInactivityTimeout(String accessTokenInactivityTimeout) {
    this.accessTokenInactivityTimeout = accessTokenInactivityTimeout;
    return (A) this;
  }
  
  public A withAccessTokenInactivityTimeoutSeconds(Integer accessTokenInactivityTimeoutSeconds) {
    this.accessTokenInactivityTimeoutSeconds = accessTokenInactivityTimeoutSeconds;
    return (A) this;
  }
  
  public A withAccessTokenMaxAgeSeconds(Integer accessTokenMaxAgeSeconds) {
    this.accessTokenMaxAgeSeconds = accessTokenMaxAgeSeconds;
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
  
}