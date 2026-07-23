package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
public class ImageRegistryConfigStorageS3CloudFrontFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigStorageS3CloudFrontFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String baseURL;
  private String duration;
  private String keypairID;
  private SecretKeySelector privateKey;

  public ImageRegistryConfigStorageS3CloudFrontFluent() {
  }
  
  public ImageRegistryConfigStorageS3CloudFrontFluent(ImageRegistryConfigStorageS3CloudFront instance) {
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
  
  protected void copyInstance(ImageRegistryConfigStorageS3CloudFront instance) {
    instance = instance != null ? instance : new ImageRegistryConfigStorageS3CloudFront();
    if (instance != null) {
        this.withBaseURL(instance.getBaseURL());
        this.withDuration(instance.getDuration());
        this.withKeypairID(instance.getKeypairID());
        this.withPrivateKey(instance.getPrivateKey());
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
    ImageRegistryConfigStorageS3CloudFrontFluent that = (ImageRegistryConfigStorageS3CloudFrontFluent) o;
    if (!(Objects.equals(baseURL, that.baseURL))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(keypairID, that.keypairID))) {
      return false;
    }
    if (!(Objects.equals(privateKey, that.privateKey))) {
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
  
  public String getBaseURL() {
    return this.baseURL;
  }
  
  public String getDuration() {
    return this.duration;
  }
  
  public String getKeypairID() {
    return this.keypairID;
  }
  
  public SecretKeySelector getPrivateKey() {
    return this.privateKey;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseURL() {
    return this.baseURL != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasKeypairID() {
    return this.keypairID != null;
  }
  
  public boolean hasPrivateKey() {
    return this.privateKey != null;
  }
  
  public int hashCode() {
    return Objects.hash(baseURL, duration, keypairID, privateKey, additionalProperties);
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
    if (!(baseURL == null)) {
        sb.append("baseURL:");
        sb.append(baseURL);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(keypairID == null)) {
        sb.append("keypairID:");
        sb.append(keypairID);
        sb.append(",");
    }
    if (!(privateKey == null)) {
        sb.append("privateKey:");
        sb.append(privateKey);
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
  
  public A withBaseURL(String baseURL) {
    this.baseURL = baseURL;
    return (A) this;
  }
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withKeypairID(String keypairID) {
    this.keypairID = keypairID;
    return (A) this;
  }
  
  public A withNewPrivateKey(String key,String name,Boolean optional) {
    return (A) this.withPrivateKey(new SecretKeySelector(key, name, optional));
  }
  
  public A withPrivateKey(SecretKeySelector privateKey) {
    this.privateKey = privateKey;
    return (A) this;
  }
  
}