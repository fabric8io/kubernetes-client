package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class FieldOptionsFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.FieldOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean create;
  private String delimiter;
  private String encoding;
  private Integer index;

  public FieldOptionsFluent() {
  }
  
  public FieldOptionsFluent(FieldOptions instance) {
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
  
  protected void copyInstance(FieldOptions instance) {
    instance = instance != null ? instance : new FieldOptions();
    if (instance != null) {
        this.withCreate(instance.getCreate());
        this.withDelimiter(instance.getDelimiter());
        this.withEncoding(instance.getEncoding());
        this.withIndex(instance.getIndex());
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
    FieldOptionsFluent that = (FieldOptionsFluent) o;
    if (!(Objects.equals(create, that.create))) {
      return false;
    }
    if (!(Objects.equals(delimiter, that.delimiter))) {
      return false;
    }
    if (!(Objects.equals(encoding, that.encoding))) {
      return false;
    }
    if (!(Objects.equals(index, that.index))) {
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
  
  public Boolean getCreate() {
    return this.create;
  }
  
  public String getDelimiter() {
    return this.delimiter;
  }
  
  public String getEncoding() {
    return this.encoding;
  }
  
  public Integer getIndex() {
    return this.index;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCreate() {
    return this.create != null;
  }
  
  public boolean hasDelimiter() {
    return this.delimiter != null;
  }
  
  public boolean hasEncoding() {
    return this.encoding != null;
  }
  
  public boolean hasIndex() {
    return this.index != null;
  }
  
  public int hashCode() {
    return Objects.hash(create, delimiter, encoding, index, additionalProperties);
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
    if (!(create == null)) {
        sb.append("create:");
        sb.append(create);
        sb.append(",");
    }
    if (!(delimiter == null)) {
        sb.append("delimiter:");
        sb.append(delimiter);
        sb.append(",");
    }
    if (!(encoding == null)) {
        sb.append("encoding:");
        sb.append(encoding);
        sb.append(",");
    }
    if (!(index == null)) {
        sb.append("index:");
        sb.append(index);
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
  
  public A withCreate() {
    return withCreate(true);
  }
  
  public A withCreate(Boolean create) {
    this.create = create;
    return (A) this;
  }
  
  public A withDelimiter(String delimiter) {
    this.delimiter = delimiter;
    return (A) this;
  }
  
  public A withEncoding(String encoding) {
    this.encoding = encoding;
    return (A) this;
  }
  
  public A withIndex(Integer index) {
    this.index = index;
    return (A) this;
  }
  
}