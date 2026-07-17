package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
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
public class AzureOAuthFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AzureOAuthFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clientId;
  private SecretKeySelector clientSecret;
  private String tenantId;

  public AzureOAuthFluent() {
  }
  
  public AzureOAuthFluent(AzureOAuth instance) {
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
  
  protected void copyInstance(AzureOAuth instance) {
    instance = instance != null ? instance : new AzureOAuth();
    if (instance != null) {
        this.withClientId(instance.getClientId());
        this.withClientSecret(instance.getClientSecret());
        this.withTenantId(instance.getTenantId());
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
    AzureOAuthFluent that = (AzureOAuthFluent) o;
    if (!(Objects.equals(clientId, that.clientId))) {
      return false;
    }
    if (!(Objects.equals(clientSecret, that.clientSecret))) {
      return false;
    }
    if (!(Objects.equals(tenantId, that.tenantId))) {
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
  
  public String getClientId() {
    return this.clientId;
  }
  
  public SecretKeySelector getClientSecret() {
    return this.clientSecret;
  }
  
  public String getTenantId() {
    return this.tenantId;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientId() {
    return this.clientId != null;
  }
  
  public boolean hasClientSecret() {
    return this.clientSecret != null;
  }
  
  public boolean hasTenantId() {
    return this.tenantId != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientId, clientSecret, tenantId, additionalProperties);
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
    if (!(clientId == null)) {
        sb.append("clientId:");
        sb.append(clientId);
        sb.append(",");
    }
    if (!(clientSecret == null)) {
        sb.append("clientSecret:");
        sb.append(clientSecret);
        sb.append(",");
    }
    if (!(tenantId == null)) {
        sb.append("tenantId:");
        sb.append(tenantId);
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
  
  public A withClientId(String clientId) {
    this.clientId = clientId;
    return (A) this;
  }
  
  public A withClientSecret(SecretKeySelector clientSecret) {
    this.clientSecret = clientSecret;
    return (A) this;
  }
  
  public A withNewClientSecret(String key,String name,Boolean optional) {
    return (A) this.withClientSecret(new SecretKeySelector(key, name, optional));
  }
  
  public A withTenantId(String tenantId) {
    this.tenantId = tenantId;
    return (A) this;
  }
  
}