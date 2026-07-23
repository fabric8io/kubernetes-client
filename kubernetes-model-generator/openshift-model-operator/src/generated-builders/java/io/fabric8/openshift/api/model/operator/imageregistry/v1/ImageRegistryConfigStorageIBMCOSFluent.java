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
public class ImageRegistryConfigStorageIBMCOSFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigStorageIBMCOSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bucket;
  private String location;
  private String resourceGroupName;
  private String resourceKeyCRN;
  private String serviceInstanceCRN;

  public ImageRegistryConfigStorageIBMCOSFluent() {
  }
  
  public ImageRegistryConfigStorageIBMCOSFluent(ImageRegistryConfigStorageIBMCOS instance) {
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
  
  protected void copyInstance(ImageRegistryConfigStorageIBMCOS instance) {
    instance = instance != null ? instance : new ImageRegistryConfigStorageIBMCOS();
    if (instance != null) {
        this.withBucket(instance.getBucket());
        this.withLocation(instance.getLocation());
        this.withResourceGroupName(instance.getResourceGroupName());
        this.withResourceKeyCRN(instance.getResourceKeyCRN());
        this.withServiceInstanceCRN(instance.getServiceInstanceCRN());
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
    ImageRegistryConfigStorageIBMCOSFluent that = (ImageRegistryConfigStorageIBMCOSFluent) o;
    if (!(Objects.equals(bucket, that.bucket))) {
      return false;
    }
    if (!(Objects.equals(location, that.location))) {
      return false;
    }
    if (!(Objects.equals(resourceGroupName, that.resourceGroupName))) {
      return false;
    }
    if (!(Objects.equals(resourceKeyCRN, that.resourceKeyCRN))) {
      return false;
    }
    if (!(Objects.equals(serviceInstanceCRN, that.serviceInstanceCRN))) {
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
  
  public String getLocation() {
    return this.location;
  }
  
  public String getResourceGroupName() {
    return this.resourceGroupName;
  }
  
  public String getResourceKeyCRN() {
    return this.resourceKeyCRN;
  }
  
  public String getServiceInstanceCRN() {
    return this.serviceInstanceCRN;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBucket() {
    return this.bucket != null;
  }
  
  public boolean hasLocation() {
    return this.location != null;
  }
  
  public boolean hasResourceGroupName() {
    return this.resourceGroupName != null;
  }
  
  public boolean hasResourceKeyCRN() {
    return this.resourceKeyCRN != null;
  }
  
  public boolean hasServiceInstanceCRN() {
    return this.serviceInstanceCRN != null;
  }
  
  public int hashCode() {
    return Objects.hash(bucket, location, resourceGroupName, resourceKeyCRN, serviceInstanceCRN, additionalProperties);
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
    if (!(location == null)) {
        sb.append("location:");
        sb.append(location);
        sb.append(",");
    }
    if (!(resourceGroupName == null)) {
        sb.append("resourceGroupName:");
        sb.append(resourceGroupName);
        sb.append(",");
    }
    if (!(resourceKeyCRN == null)) {
        sb.append("resourceKeyCRN:");
        sb.append(resourceKeyCRN);
        sb.append(",");
    }
    if (!(serviceInstanceCRN == null)) {
        sb.append("serviceInstanceCRN:");
        sb.append(serviceInstanceCRN);
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
  
  public A withLocation(String location) {
    this.location = location;
    return (A) this;
  }
  
  public A withResourceGroupName(String resourceGroupName) {
    this.resourceGroupName = resourceGroupName;
    return (A) this;
  }
  
  public A withResourceKeyCRN(String resourceKeyCRN) {
    this.resourceKeyCRN = resourceKeyCRN;
    return (A) this;
  }
  
  public A withServiceInstanceCRN(String serviceInstanceCRN) {
    this.serviceInstanceCRN = serviceInstanceCRN;
    return (A) this;
  }
  
}