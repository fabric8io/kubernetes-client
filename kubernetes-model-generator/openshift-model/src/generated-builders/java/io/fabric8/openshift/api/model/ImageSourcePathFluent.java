package io.fabric8.openshift.api.model;

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
public class ImageSourcePathFluent<A extends io.fabric8.openshift.api.model.ImageSourcePathFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String destinationDir;
  private String sourcePath;

  public ImageSourcePathFluent() {
  }
  
  public ImageSourcePathFluent(ImageSourcePath instance) {
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
  
  protected void copyInstance(ImageSourcePath instance) {
    instance = instance != null ? instance : new ImageSourcePath();
    if (instance != null) {
        this.withDestinationDir(instance.getDestinationDir());
        this.withSourcePath(instance.getSourcePath());
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
    ImageSourcePathFluent that = (ImageSourcePathFluent) o;
    if (!(Objects.equals(destinationDir, that.destinationDir))) {
      return false;
    }
    if (!(Objects.equals(sourcePath, that.sourcePath))) {
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
  
  public String getDestinationDir() {
    return this.destinationDir;
  }
  
  public String getSourcePath() {
    return this.sourcePath;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDestinationDir() {
    return this.destinationDir != null;
  }
  
  public boolean hasSourcePath() {
    return this.sourcePath != null;
  }
  
  public int hashCode() {
    return Objects.hash(destinationDir, sourcePath, additionalProperties);
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
    if (!(destinationDir == null)) {
        sb.append("destinationDir:");
        sb.append(destinationDir);
        sb.append(",");
    }
    if (!(sourcePath == null)) {
        sb.append("sourcePath:");
        sb.append(sourcePath);
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
  
  public A withDestinationDir(String destinationDir) {
    this.destinationDir = destinationDir;
    return (A) this;
  }
  
  public A withSourcePath(String sourcePath) {
    this.sourcePath = sourcePath;
    return (A) this;
  }
  
}