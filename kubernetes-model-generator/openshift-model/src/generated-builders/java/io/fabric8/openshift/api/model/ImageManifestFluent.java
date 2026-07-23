package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class ImageManifestFluent<A extends io.fabric8.openshift.api.model.ImageManifestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String architecture;
  private String digest;
  private Long manifestSize;
  private String mediaType;
  private String os;
  private String variant;

  public ImageManifestFluent() {
  }
  
  public ImageManifestFluent(ImageManifest instance) {
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
  
  protected void copyInstance(ImageManifest instance) {
    instance = instance != null ? instance : new ImageManifest();
    if (instance != null) {
        this.withArchitecture(instance.getArchitecture());
        this.withDigest(instance.getDigest());
        this.withManifestSize(instance.getManifestSize());
        this.withMediaType(instance.getMediaType());
        this.withOs(instance.getOs());
        this.withVariant(instance.getVariant());
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
    ImageManifestFluent that = (ImageManifestFluent) o;
    if (!(Objects.equals(architecture, that.architecture))) {
      return false;
    }
    if (!(Objects.equals(digest, that.digest))) {
      return false;
    }
    if (!(Objects.equals(manifestSize, that.manifestSize))) {
      return false;
    }
    if (!(Objects.equals(mediaType, that.mediaType))) {
      return false;
    }
    if (!(Objects.equals(os, that.os))) {
      return false;
    }
    if (!(Objects.equals(variant, that.variant))) {
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
  
  public String getArchitecture() {
    return this.architecture;
  }
  
  public String getDigest() {
    return this.digest;
  }
  
  public Long getManifestSize() {
    return this.manifestSize;
  }
  
  public String getMediaType() {
    return this.mediaType;
  }
  
  public String getOs() {
    return this.os;
  }
  
  public String getVariant() {
    return this.variant;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArchitecture() {
    return this.architecture != null;
  }
  
  public boolean hasDigest() {
    return this.digest != null;
  }
  
  public boolean hasManifestSize() {
    return this.manifestSize != null;
  }
  
  public boolean hasMediaType() {
    return this.mediaType != null;
  }
  
  public boolean hasOs() {
    return this.os != null;
  }
  
  public boolean hasVariant() {
    return this.variant != null;
  }
  
  public int hashCode() {
    return Objects.hash(architecture, digest, manifestSize, mediaType, os, variant, additionalProperties);
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
    if (!(architecture == null)) {
        sb.append("architecture:");
        sb.append(architecture);
        sb.append(",");
    }
    if (!(digest == null)) {
        sb.append("digest:");
        sb.append(digest);
        sb.append(",");
    }
    if (!(manifestSize == null)) {
        sb.append("manifestSize:");
        sb.append(manifestSize);
        sb.append(",");
    }
    if (!(mediaType == null)) {
        sb.append("mediaType:");
        sb.append(mediaType);
        sb.append(",");
    }
    if (!(os == null)) {
        sb.append("os:");
        sb.append(os);
        sb.append(",");
    }
    if (!(variant == null)) {
        sb.append("variant:");
        sb.append(variant);
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
  
  public A withArchitecture(String architecture) {
    this.architecture = architecture;
    return (A) this;
  }
  
  public A withDigest(String digest) {
    this.digest = digest;
    return (A) this;
  }
  
  public A withManifestSize(Long manifestSize) {
    this.manifestSize = manifestSize;
    return (A) this;
  }
  
  public A withMediaType(String mediaType) {
    this.mediaType = mediaType;
    return (A) this;
  }
  
  public A withOs(String os) {
    this.os = os;
    return (A) this;
  }
  
  public A withVariant(String variant) {
    this.variant = variant;
    return (A) this;
  }
  
}