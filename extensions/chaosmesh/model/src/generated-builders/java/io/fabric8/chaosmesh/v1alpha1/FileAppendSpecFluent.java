package io.fabric8.chaosmesh.v1alpha1;

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
public class FileAppendSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.FileAppendSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer count;
  private String data;
  private String fileName;

  public FileAppendSpecFluent() {
  }
  
  public FileAppendSpecFluent(FileAppendSpec instance) {
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
  
  protected void copyInstance(FileAppendSpec instance) {
    instance = instance != null ? instance : new FileAppendSpec();
    if (instance != null) {
        this.withCount(instance.getCount());
        this.withData(instance.getData());
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
    FileAppendSpecFluent that = (FileAppendSpecFluent) o;
    if (!(Objects.equals(count, that.count))) {
      return false;
    }
    if (!(Objects.equals(data, that.data))) {
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
  
  public Integer getCount() {
    return this.count;
  }
  
  public String getData() {
    return this.data;
  }
  
  public String getFileName() {
    return this.fileName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCount() {
    return this.count != null;
  }
  
  public boolean hasData() {
    return this.data != null;
  }
  
  public boolean hasFileName() {
    return this.fileName != null;
  }
  
  public int hashCode() {
    return Objects.hash(count, data, fileName, additionalProperties);
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
    if (!(count == null)) {
        sb.append("count:");
        sb.append(count);
        sb.append(",");
    }
    if (!(data == null)) {
        sb.append("data:");
        sb.append(data);
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
  
  public A withCount(Integer count) {
    this.count = count;
    return (A) this;
  }
  
  public A withData(String data) {
    this.data = data;
    return (A) this;
  }
  
  public A withFileName(String fileName) {
    this.fileName = fileName;
    return (A) this;
  }
  
}