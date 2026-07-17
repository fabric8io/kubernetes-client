package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class ImageFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.ImageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String checksum;
  private String checksumType;
  private String format;
  private String url;

  public ImageFluent() {
  }
  
  public ImageFluent(Image instance) {
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
  
  protected void copyInstance(Image instance) {
    instance = instance != null ? instance : new Image();
    if (instance != null) {
        this.withChecksum(instance.getChecksum());
        this.withChecksumType(instance.getChecksumType());
        this.withFormat(instance.getFormat());
        this.withUrl(instance.getUrl());
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
    ImageFluent that = (ImageFluent) o;
    if (!(Objects.equals(checksum, that.checksum))) {
      return false;
    }
    if (!(Objects.equals(checksumType, that.checksumType))) {
      return false;
    }
    if (!(Objects.equals(format, that.format))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getChecksum() {
    return this.checksum;
  }
  
  public String getChecksumType() {
    return this.checksumType;
  }
  
  public String getFormat() {
    return this.format;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasChecksum() {
    return this.checksum != null;
  }
  
  public boolean hasChecksumType() {
    return this.checksumType != null;
  }
  
  public boolean hasFormat() {
    return this.format != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(checksum, checksumType, format, url, additionalProperties);
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
    if (!(checksum == null)) {
        sb.append("checksum:");
        sb.append(checksum);
        sb.append(",");
    }
    if (!(checksumType == null)) {
        sb.append("checksumType:");
        sb.append(checksumType);
        sb.append(",");
    }
    if (!(format == null)) {
        sb.append("format:");
        sb.append(format);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withChecksum(String checksum) {
    this.checksum = checksum;
    return (A) this;
  }
  
  public A withChecksumType(String checksumType) {
    this.checksumType = checksumType;
    return (A) this;
  }
  
  public A withFormat(String format) {
    this.format = format;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
}