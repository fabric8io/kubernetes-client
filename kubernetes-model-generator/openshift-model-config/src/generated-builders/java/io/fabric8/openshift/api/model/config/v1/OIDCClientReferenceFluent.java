package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class OIDCClientReferenceFluent<A extends io.fabric8.openshift.api.model.config.v1.OIDCClientReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clientID;
  private String issuerURL;
  private String oidcProviderName;

  public OIDCClientReferenceFluent() {
  }
  
  public OIDCClientReferenceFluent(OIDCClientReference instance) {
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
  
  protected void copyInstance(OIDCClientReference instance) {
    instance = instance != null ? instance : new OIDCClientReference();
    if (instance != null) {
        this.withClientID(instance.getClientID());
        this.withIssuerURL(instance.getIssuerURL());
        this.withOidcProviderName(instance.getOidcProviderName());
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
    OIDCClientReferenceFluent that = (OIDCClientReferenceFluent) o;
    if (!(Objects.equals(clientID, that.clientID))) {
      return false;
    }
    if (!(Objects.equals(issuerURL, that.issuerURL))) {
      return false;
    }
    if (!(Objects.equals(oidcProviderName, that.oidcProviderName))) {
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
  
  public String getClientID() {
    return this.clientID;
  }
  
  public String getIssuerURL() {
    return this.issuerURL;
  }
  
  public String getOidcProviderName() {
    return this.oidcProviderName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientID() {
    return this.clientID != null;
  }
  
  public boolean hasIssuerURL() {
    return this.issuerURL != null;
  }
  
  public boolean hasOidcProviderName() {
    return this.oidcProviderName != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientID, issuerURL, oidcProviderName, additionalProperties);
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
    if (!(clientID == null)) {
        sb.append("clientID:");
        sb.append(clientID);
        sb.append(",");
    }
    if (!(issuerURL == null)) {
        sb.append("issuerURL:");
        sb.append(issuerURL);
        sb.append(",");
    }
    if (!(oidcProviderName == null)) {
        sb.append("oidcProviderName:");
        sb.append(oidcProviderName);
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
  
  public A withClientID(String clientID) {
    this.clientID = clientID;
    return (A) this;
  }
  
  public A withIssuerURL(String issuerURL) {
    this.issuerURL = issuerURL;
    return (A) this;
  }
  
  public A withOidcProviderName(String oidcProviderName) {
    this.oidcProviderName = oidcProviderName;
    return (A) this;
  }
  
}