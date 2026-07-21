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
public class FileDeleteSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.FileDeleteSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String dirName;
  private String fileName;

  public FileDeleteSpecFluent() {
  }
  
  public FileDeleteSpecFluent(FileDeleteSpec instance) {
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
  
  protected void copyInstance(FileDeleteSpec instance) {
    instance = instance != null ? instance : new FileDeleteSpec();
    if (instance != null) {
        this.withDirName(instance.getDirName());
        this.withFileName(instance.getFileName());
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
    FileDeleteSpecFluent that = (FileDeleteSpecFluent) o;
    if (!(Objects.equals(dirName, that.dirName))) {
      return false;
    }
    if (!(Objects.equals(fileName, that.fileName))) {
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
  
  public String getDirName() {
    return this.dirName;
  }
  
  public String getFileName() {
    return this.fileName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDirName() {
    return this.dirName != null;
  }
  
  public boolean hasFileName() {
    return this.fileName != null;
  }
  
  public int hashCode() {
    return Objects.hash(dirName, fileName, additionalProperties);
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
    if (!(dirName == null)) {
        sb.append("dirName:");
        sb.append(dirName);
        sb.append(",");
    }
    if (!(fileName == null)) {
        sb.append("fileName:");
        sb.append(fileName);
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
  
  public A withDirName(String dirName) {
    this.dirName = dirName;
    return (A) this;
  }
  
  public A withFileName(String fileName) {
    this.fileName = fileName;
    return (A) this;
  }
  
}