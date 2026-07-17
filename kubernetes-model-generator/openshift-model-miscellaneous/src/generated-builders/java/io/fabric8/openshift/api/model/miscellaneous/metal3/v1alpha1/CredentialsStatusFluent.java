package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
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
public class CredentialsStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.CredentialsStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretReference credentials;
  private String credentialsVersion;

  public CredentialsStatusFluent() {
  }
  
  public CredentialsStatusFluent(CredentialsStatus instance) {
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
  
  protected void copyInstance(CredentialsStatus instance) {
    instance = instance != null ? instance : new CredentialsStatus();
    if (instance != null) {
        this.withCredentials(instance.getCredentials());
        this.withCredentialsVersion(instance.getCredentialsVersion());
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
    CredentialsStatusFluent that = (CredentialsStatusFluent) o;
    if (!(Objects.equals(credentials, that.credentials))) {
      return false;
    }
    if (!(Objects.equals(credentialsVersion, that.credentialsVersion))) {
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
  
  public SecretReference getCredentials() {
    return this.credentials;
  }
  
  public String getCredentialsVersion() {
    return this.credentialsVersion;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCredentials() {
    return this.credentials != null;
  }
  
  public boolean hasCredentialsVersion() {
    return this.credentialsVersion != null;
  }
  
  public int hashCode() {
    return Objects.hash(credentials, credentialsVersion, additionalProperties);
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
    if (!(credentials == null)) {
        sb.append("credentials:");
        sb.append(credentials);
        sb.append(",");
    }
    if (!(credentialsVersion == null)) {
        sb.append("credentialsVersion:");
        sb.append(credentialsVersion);
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
  
  public A withCredentials(SecretReference credentials) {
    this.credentials = credentials;
    return (A) this;
  }
  
  public A withCredentialsVersion(String credentialsVersion) {
    this.credentialsVersion = credentialsVersion;
    return (A) this;
  }
  
  public A withNewCredentials(String name,String namespace) {
    return (A) this.withCredentials(new SecretReference(name, namespace));
  }
  
}