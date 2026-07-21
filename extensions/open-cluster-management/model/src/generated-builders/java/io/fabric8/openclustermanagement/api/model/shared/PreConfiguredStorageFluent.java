package io.fabric8.openclustermanagement.api.model.shared;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class PreConfiguredStorageFluent<A extends io.fabric8.openclustermanagement.api.model.shared.PreConfiguredStorageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String key;
  private String name;
  private Boolean serviceAccountProjection;
  private String tlsSecretMountPath;
  private String tlsSecretName;

  public PreConfiguredStorageFluent() {
  }
  
  public PreConfiguredStorageFluent(PreConfiguredStorage instance) {
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
  
  protected void copyInstance(PreConfiguredStorage instance) {
    instance = instance != null ? instance : new PreConfiguredStorage();
    if (instance != null) {
        this.withKey(instance.getKey());
        this.withName(instance.getName());
        this.withServiceAccountProjection(instance.getServiceAccountProjection());
        this.withTlsSecretMountPath(instance.getTlsSecretMountPath());
        this.withTlsSecretName(instance.getTlsSecretName());
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
    PreConfiguredStorageFluent that = (PreConfiguredStorageFluent) o;
    if (!(Objects.equals(key, that.key))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountProjection, that.serviceAccountProjection))) {
      return false;
    }
    if (!(Objects.equals(tlsSecretMountPath, that.tlsSecretMountPath))) {
      return false;
    }
    if (!(Objects.equals(tlsSecretName, that.tlsSecretName))) {
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
  
  public String getKey() {
    return this.key;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Boolean getServiceAccountProjection() {
    return this.serviceAccountProjection;
  }
  
  public String getTlsSecretMountPath() {
    return this.tlsSecretMountPath;
  }
  
  public String getTlsSecretName() {
    return this.tlsSecretName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasServiceAccountProjection() {
    return this.serviceAccountProjection != null;
  }
  
  public boolean hasTlsSecretMountPath() {
    return this.tlsSecretMountPath != null;
  }
  
  public boolean hasTlsSecretName() {
    return this.tlsSecretName != null;
  }
  
  public int hashCode() {
    return Objects.hash(key, name, serviceAccountProjection, tlsSecretMountPath, tlsSecretName, additionalProperties);
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
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(serviceAccountProjection == null)) {
        sb.append("serviceAccountProjection:");
        sb.append(serviceAccountProjection);
        sb.append(",");
    }
    if (!(tlsSecretMountPath == null)) {
        sb.append("tlsSecretMountPath:");
        sb.append(tlsSecretMountPath);
        sb.append(",");
    }
    if (!(tlsSecretName == null)) {
        sb.append("tlsSecretName:");
        sb.append(tlsSecretName);
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
  
  public A withKey(String key) {
    this.key = key;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withServiceAccountProjection() {
    return withServiceAccountProjection(true);
  }
  
  public A withServiceAccountProjection(Boolean serviceAccountProjection) {
    this.serviceAccountProjection = serviceAccountProjection;
    return (A) this;
  }
  
  public A withTlsSecretMountPath(String tlsSecretMountPath) {
    this.tlsSecretMountPath = tlsSecretMountPath;
    return (A) this;
  }
  
  public A withTlsSecretName(String tlsSecretName) {
    this.tlsSecretName = tlsSecretName;
    return (A) this;
  }
  
}