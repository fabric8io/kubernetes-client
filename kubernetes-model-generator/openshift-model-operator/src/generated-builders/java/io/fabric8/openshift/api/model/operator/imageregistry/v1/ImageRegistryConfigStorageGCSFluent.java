package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
public class ImageRegistryConfigStorageGCSFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigStorageGCSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bucket;
  private String keyID;
  private String projectID;
  private String region;

  public ImageRegistryConfigStorageGCSFluent() {
  }
  
  public ImageRegistryConfigStorageGCSFluent(ImageRegistryConfigStorageGCS instance) {
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
  
  protected void copyInstance(ImageRegistryConfigStorageGCS instance) {
    instance = instance != null ? instance : new ImageRegistryConfigStorageGCS();
    if (instance != null) {
        this.withBucket(instance.getBucket());
        this.withKeyID(instance.getKeyID());
        this.withProjectID(instance.getProjectID());
        this.withRegion(instance.getRegion());
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
    ImageRegistryConfigStorageGCSFluent that = (ImageRegistryConfigStorageGCSFluent) o;
    if (!(Objects.equals(bucket, that.bucket))) {
      return false;
    }
    if (!(Objects.equals(keyID, that.keyID))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
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
  
  public String getBucket() {
    return this.bucket;
  }
  
  public String getKeyID() {
    return this.keyID;
  }
  
  public String getProjectID() {
    return this.projectID;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBucket() {
    return this.bucket != null;
  }
  
  public boolean hasKeyID() {
    return this.keyID != null;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public int hashCode() {
    return Objects.hash(bucket, keyID, projectID, region, additionalProperties);
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
    if (!(bucket == null)) {
        sb.append("bucket:");
        sb.append(bucket);
        sb.append(",");
    }
    if (!(keyID == null)) {
        sb.append("keyID:");
        sb.append(keyID);
        sb.append(",");
    }
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
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
  
  public A withBucket(String bucket) {
    this.bucket = bucket;
    return (A) this;
  }
  
  public A withKeyID(String keyID) {
    this.keyID = keyID;
    return (A) this;
  }
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
}