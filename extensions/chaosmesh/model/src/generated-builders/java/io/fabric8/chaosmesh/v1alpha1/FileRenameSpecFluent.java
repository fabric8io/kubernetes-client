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
public class FileRenameSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.FileRenameSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String destFile;
  private String sourceFile;

  public FileRenameSpecFluent() {
  }
  
  public FileRenameSpecFluent(FileRenameSpec instance) {
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
  
  protected void copyInstance(FileRenameSpec instance) {
    instance = instance != null ? instance : new FileRenameSpec();
    if (instance != null) {
        this.withDestFile(instance.getDestFile());
        this.withSourceFile(instance.getSourceFile());
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
    FileRenameSpecFluent that = (FileRenameSpecFluent) o;
    if (!(Objects.equals(destFile, that.destFile))) {
      return false;
    }
    if (!(Objects.equals(sourceFile, that.sourceFile))) {
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
  
  public String getDestFile() {
    return this.destFile;
  }
  
  public String getSourceFile() {
    return this.sourceFile;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDestFile() {
    return this.destFile != null;
  }
  
  public boolean hasSourceFile() {
    return this.sourceFile != null;
  }
  
  public int hashCode() {
    return Objects.hash(destFile, sourceFile, additionalProperties);
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
    if (!(destFile == null)) {
        sb.append("destFile:");
        sb.append(destFile);
        sb.append(",");
    }
    if (!(sourceFile == null)) {
        sb.append("sourceFile:");
        sb.append(sourceFile);
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
  
  public A withDestFile(String destFile) {
    this.destFile = destFile;
    return (A) this;
  }
  
  public A withSourceFile(String sourceFile) {
    this.sourceFile = sourceFile;
    return (A) this;
  }
  
}