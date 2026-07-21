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
public class FileReplaceSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.FileReplaceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String destString;
  private String fileName;
  private Integer line;
  private String originString;

  public FileReplaceSpecFluent() {
  }
  
  public FileReplaceSpecFluent(FileReplaceSpec instance) {
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
  
  protected void copyInstance(FileReplaceSpec instance) {
    instance = instance != null ? instance : new FileReplaceSpec();
    if (instance != null) {
        this.withDestString(instance.getDestString());
        this.withFileName(instance.getFileName());
        this.withLine(instance.getLine());
        this.withOriginString(instance.getOriginString());
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
    FileReplaceSpecFluent that = (FileReplaceSpecFluent) o;
    if (!(Objects.equals(destString, that.destString))) {
      return false;
    }
    if (!(Objects.equals(fileName, that.fileName))) {
      return false;
    }
    if (!(Objects.equals(line, that.line))) {
      return false;
    }
    if (!(Objects.equals(originString, that.originString))) {
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
  
  public String getDestString() {
    return this.destString;
  }
  
  public String getFileName() {
    return this.fileName;
  }
  
  public Integer getLine() {
    return this.line;
  }
  
  public String getOriginString() {
    return this.originString;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDestString() {
    return this.destString != null;
  }
  
  public boolean hasFileName() {
    return this.fileName != null;
  }
  
  public boolean hasLine() {
    return this.line != null;
  }
  
  public boolean hasOriginString() {
    return this.originString != null;
  }
  
  public int hashCode() {
    return Objects.hash(destString, fileName, line, originString, additionalProperties);
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
    if (!(destString == null)) {
        sb.append("destString:");
        sb.append(destString);
        sb.append(",");
    }
    if (!(fileName == null)) {
        sb.append("fileName:");
        sb.append(fileName);
        sb.append(",");
    }
    if (!(line == null)) {
        sb.append("line:");
        sb.append(line);
        sb.append(",");
    }
    if (!(originString == null)) {
        sb.append("originString:");
        sb.append(originString);
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
  
  public A withDestString(String destString) {
    this.destString = destString;
    return (A) this;
  }
  
  public A withFileName(String fileName) {
    this.fileName = fileName;
    return (A) this;
  }
  
  public A withLine(Integer line) {
    this.line = line;
    return (A) this;
  }
  
  public A withOriginString(String originString) {
    this.originString = originString;
    return (A) this;
  }
  
}