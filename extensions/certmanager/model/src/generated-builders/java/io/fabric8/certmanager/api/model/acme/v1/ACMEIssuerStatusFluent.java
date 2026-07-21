package io.fabric8.certmanager.api.model.acme.v1;

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
public class ACMEIssuerStatusFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String lastPrivateKeyHash;
  private String lastRegisteredEmail;
  private String uri;

  public ACMEIssuerStatusFluent() {
  }
  
  public ACMEIssuerStatusFluent(ACMEIssuerStatus instance) {
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
  
  protected void copyInstance(ACMEIssuerStatus instance) {
    instance = instance != null ? instance : new ACMEIssuerStatus();
    if (instance != null) {
        this.withLastPrivateKeyHash(instance.getLastPrivateKeyHash());
        this.withLastRegisteredEmail(instance.getLastRegisteredEmail());
        this.withUri(instance.getUri());
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
    ACMEIssuerStatusFluent that = (ACMEIssuerStatusFluent) o;
    if (!(Objects.equals(lastPrivateKeyHash, that.lastPrivateKeyHash))) {
      return false;
    }
    if (!(Objects.equals(lastRegisteredEmail, that.lastRegisteredEmail))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
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
  
  public String getLastPrivateKeyHash() {
    return this.lastPrivateKeyHash;
  }
  
  public String getLastRegisteredEmail() {
    return this.lastRegisteredEmail;
  }
  
  public String getUri() {
    return this.uri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLastPrivateKeyHash() {
    return this.lastPrivateKeyHash != null;
  }
  
  public boolean hasLastRegisteredEmail() {
    return this.lastRegisteredEmail != null;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public int hashCode() {
    return Objects.hash(lastPrivateKeyHash, lastRegisteredEmail, uri, additionalProperties);
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
    if (!(lastPrivateKeyHash == null)) {
        sb.append("lastPrivateKeyHash:");
        sb.append(lastPrivateKeyHash);
        sb.append(",");
    }
    if (!(lastRegisteredEmail == null)) {
        sb.append("lastRegisteredEmail:");
        sb.append(lastRegisteredEmail);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
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
  
  public A withLastPrivateKeyHash(String lastPrivateKeyHash) {
    this.lastPrivateKeyHash = lastPrivateKeyHash;
    return (A) this;
  }
  
  public A withLastRegisteredEmail(String lastRegisteredEmail) {
    this.lastRegisteredEmail = lastRegisteredEmail;
    return (A) this;
  }
  
  public A withUri(String uri) {
    this.uri = uri;
    return (A) this;
  }
  
}