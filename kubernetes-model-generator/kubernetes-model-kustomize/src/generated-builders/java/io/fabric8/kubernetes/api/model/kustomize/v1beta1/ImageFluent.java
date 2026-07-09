package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
public class ImageFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.ImageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String digest;
  private String name;
  private String newName;
  private String newTag;
  private String tagSuffix;

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
        this.withDigest(instance.getDigest());
        this.withName(instance.getName());
        this.withNewName(instance.getNewName());
        this.withNewTag(instance.getNewTag());
        this.withTagSuffix(instance.getTagSuffix());
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
    if (!(Objects.equals(digest, that.digest))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(newName, that.newName))) {
      return false;
    }
    if (!(Objects.equals(newTag, that.newTag))) {
      return false;
    }
    if (!(Objects.equals(tagSuffix, that.tagSuffix))) {
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
  
  public String getDigest() {
    return this.digest;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNewName() {
    return this.newName;
  }
  
  public String getNewTag() {
    return this.newTag;
  }
  
  public String getTagSuffix() {
    return this.tagSuffix;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDigest() {
    return this.digest != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNewName() {
    return this.newName != null;
  }
  
  public boolean hasNewTag() {
    return this.newTag != null;
  }
  
  public boolean hasTagSuffix() {
    return this.tagSuffix != null;
  }
  
  public int hashCode() {
    return Objects.hash(digest, name, newName, newTag, tagSuffix, additionalProperties);
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
    if (!(digest == null)) {
        sb.append("digest:");
        sb.append(digest);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(newName == null)) {
        sb.append("newName:");
        sb.append(newName);
        sb.append(",");
    }
    if (!(newTag == null)) {
        sb.append("newTag:");
        sb.append(newTag);
        sb.append(",");
    }
    if (!(tagSuffix == null)) {
        sb.append("tagSuffix:");
        sb.append(tagSuffix);
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
  
  public A withDigest(String digest) {
    this.digest = digest;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNewName(String newName) {
    this.newName = newName;
    return (A) this;
  }
  
  public A withNewTag(String newTag) {
    this.newTag = newTag;
    return (A) this;
  }
  
  public A withTagSuffix(String tagSuffix) {
    this.tagSuffix = tagSuffix;
    return (A) this;
  }
  
}