package io.fabric8.kubernetes.api.model;

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
public class PodCertificateProjectionFluent<A extends io.fabric8.kubernetes.api.model.PodCertificateProjectionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String certificateChainPath;
  private String credentialBundlePath;
  private String keyPath;
  private String keyType;
  private Integer maxExpirationSeconds;
  private String signerName;
  private Map<String,String> userAnnotations;

  public PodCertificateProjectionFluent() {
  }
  
  public PodCertificateProjectionFluent(PodCertificateProjection instance) {
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
  
  public A addToUserAnnotations(Map<String,String> map) {
    if (this.userAnnotations == null && map != null) {
      this.userAnnotations = new LinkedHashMap();
    }
    if (map != null) {
      this.userAnnotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUserAnnotations(String key,String value) {
    if (this.userAnnotations == null && key != null && value != null) {
      this.userAnnotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.userAnnotations.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(PodCertificateProjection instance) {
    instance = instance != null ? instance : new PodCertificateProjection();
    if (instance != null) {
        this.withCertificateChainPath(instance.getCertificateChainPath());
        this.withCredentialBundlePath(instance.getCredentialBundlePath());
        this.withKeyPath(instance.getKeyPath());
        this.withKeyType(instance.getKeyType());
        this.withMaxExpirationSeconds(instance.getMaxExpirationSeconds());
        this.withSignerName(instance.getSignerName());
        this.withUserAnnotations(instance.getUserAnnotations());
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
    PodCertificateProjectionFluent that = (PodCertificateProjectionFluent) o;
    if (!(Objects.equals(certificateChainPath, that.certificateChainPath))) {
      return false;
    }
    if (!(Objects.equals(credentialBundlePath, that.credentialBundlePath))) {
      return false;
    }
    if (!(Objects.equals(keyPath, that.keyPath))) {
      return false;
    }
    if (!(Objects.equals(keyType, that.keyType))) {
      return false;
    }
    if (!(Objects.equals(maxExpirationSeconds, that.maxExpirationSeconds))) {
      return false;
    }
    if (!(Objects.equals(signerName, that.signerName))) {
      return false;
    }
    if (!(Objects.equals(userAnnotations, that.userAnnotations))) {
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
  
  public String getCertificateChainPath() {
    return this.certificateChainPath;
  }
  
  public String getCredentialBundlePath() {
    return this.credentialBundlePath;
  }
  
  public String getKeyPath() {
    return this.keyPath;
  }
  
  public String getKeyType() {
    return this.keyType;
  }
  
  public Integer getMaxExpirationSeconds() {
    return this.maxExpirationSeconds;
  }
  
  public String getSignerName() {
    return this.signerName;
  }
  
  public Map<String,String> getUserAnnotations() {
    return this.userAnnotations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertificateChainPath() {
    return this.certificateChainPath != null;
  }
  
  public boolean hasCredentialBundlePath() {
    return this.credentialBundlePath != null;
  }
  
  public boolean hasKeyPath() {
    return this.keyPath != null;
  }
  
  public boolean hasKeyType() {
    return this.keyType != null;
  }
  
  public boolean hasMaxExpirationSeconds() {
    return this.maxExpirationSeconds != null;
  }
  
  public boolean hasSignerName() {
    return this.signerName != null;
  }
  
  public boolean hasUserAnnotations() {
    return this.userAnnotations != null;
  }
  
  public int hashCode() {
    return Objects.hash(certificateChainPath, credentialBundlePath, keyPath, keyType, maxExpirationSeconds, signerName, userAnnotations, additionalProperties);
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
  
  public A removeFromUserAnnotations(String key) {
    if (this.userAnnotations == null) {
      return (A) this;
    }
    if (key != null && this.userAnnotations != null) {
      this.userAnnotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUserAnnotations(Map<String,String> map) {
    if (this.userAnnotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.userAnnotations != null) {
          this.userAnnotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(certificateChainPath == null)) {
        sb.append("certificateChainPath:");
        sb.append(certificateChainPath);
        sb.append(",");
    }
    if (!(credentialBundlePath == null)) {
        sb.append("credentialBundlePath:");
        sb.append(credentialBundlePath);
        sb.append(",");
    }
    if (!(keyPath == null)) {
        sb.append("keyPath:");
        sb.append(keyPath);
        sb.append(",");
    }
    if (!(keyType == null)) {
        sb.append("keyType:");
        sb.append(keyType);
        sb.append(",");
    }
    if (!(maxExpirationSeconds == null)) {
        sb.append("maxExpirationSeconds:");
        sb.append(maxExpirationSeconds);
        sb.append(",");
    }
    if (!(signerName == null)) {
        sb.append("signerName:");
        sb.append(signerName);
        sb.append(",");
    }
    if (!(userAnnotations == null) && !(userAnnotations.isEmpty())) {
        sb.append("userAnnotations:");
        sb.append(userAnnotations);
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
  
  public A withCertificateChainPath(String certificateChainPath) {
    this.certificateChainPath = certificateChainPath;
    return (A) this;
  }
  
  public A withCredentialBundlePath(String credentialBundlePath) {
    this.credentialBundlePath = credentialBundlePath;
    return (A) this;
  }
  
  public A withKeyPath(String keyPath) {
    this.keyPath = keyPath;
    return (A) this;
  }
  
  public A withKeyType(String keyType) {
    this.keyType = keyType;
    return (A) this;
  }
  
  public A withMaxExpirationSeconds(Integer maxExpirationSeconds) {
    this.maxExpirationSeconds = maxExpirationSeconds;
    return (A) this;
  }
  
  public A withSignerName(String signerName) {
    this.signerName = signerName;
    return (A) this;
  }
  
  public <K,V>A withUserAnnotations(Map<String,String> userAnnotations) {
    if (userAnnotations == null) {
      this.userAnnotations = null;
    } else {
      this.userAnnotations = new LinkedHashMap(userAnnotations);
    }
    return (A) this;
  }
  
}