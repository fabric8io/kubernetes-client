package io.fabric8.chaosmesh.v1alpha1;

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
public class PodHttpChaosTLSFluent<A extends io.fabric8.chaosmesh.v1alpha1.PodHttpChaosTLSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caName;
  private String certName;
  private String keyName;
  private String secretName;
  private String secretNamespace;

  public PodHttpChaosTLSFluent() {
  }
  
  public PodHttpChaosTLSFluent(PodHttpChaosTLS instance) {
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
  
  protected void copyInstance(PodHttpChaosTLS instance) {
    instance = instance != null ? instance : new PodHttpChaosTLS();
    if (instance != null) {
        this.withCaName(instance.getCaName());
        this.withCertName(instance.getCertName());
        this.withKeyName(instance.getKeyName());
        this.withSecretName(instance.getSecretName());
        this.withSecretNamespace(instance.getSecretNamespace());
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
    PodHttpChaosTLSFluent that = (PodHttpChaosTLSFluent) o;
    if (!(Objects.equals(caName, that.caName))) {
      return false;
    }
    if (!(Objects.equals(certName, that.certName))) {
      return false;
    }
    if (!(Objects.equals(keyName, that.keyName))) {
      return false;
    }
    if (!(Objects.equals(secretName, that.secretName))) {
      return false;
    }
    if (!(Objects.equals(secretNamespace, that.secretNamespace))) {
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
  
  public String getCaName() {
    return this.caName;
  }
  
  public String getCertName() {
    return this.certName;
  }
  
  public String getKeyName() {
    return this.keyName;
  }
  
  public String getSecretName() {
    return this.secretName;
  }
  
  public String getSecretNamespace() {
    return this.secretNamespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaName() {
    return this.caName != null;
  }
  
  public boolean hasCertName() {
    return this.certName != null;
  }
  
  public boolean hasKeyName() {
    return this.keyName != null;
  }
  
  public boolean hasSecretName() {
    return this.secretName != null;
  }
  
  public boolean hasSecretNamespace() {
    return this.secretNamespace != null;
  }
  
  public int hashCode() {
    return Objects.hash(caName, certName, keyName, secretName, secretNamespace, additionalProperties);
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
    if (!(caName == null)) {
        sb.append("caName:");
        sb.append(caName);
        sb.append(",");
    }
    if (!(certName == null)) {
        sb.append("certName:");
        sb.append(certName);
        sb.append(",");
    }
    if (!(keyName == null)) {
        sb.append("keyName:");
        sb.append(keyName);
        sb.append(",");
    }
    if (!(secretName == null)) {
        sb.append("secretName:");
        sb.append(secretName);
        sb.append(",");
    }
    if (!(secretNamespace == null)) {
        sb.append("secretNamespace:");
        sb.append(secretNamespace);
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
  
  public A withCaName(String caName) {
    this.caName = caName;
    return (A) this;
  }
  
  public A withCertName(String certName) {
    this.certName = certName;
    return (A) this;
  }
  
  public A withKeyName(String keyName) {
    this.keyName = keyName;
    return (A) this;
  }
  
  public A withSecretName(String secretName) {
    this.secretName = secretName;
    return (A) this;
  }
  
  public A withSecretNamespace(String secretNamespace) {
    this.secretNamespace = secretNamespace;
    return (A) this;
  }
  
}