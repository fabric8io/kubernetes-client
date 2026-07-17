package io.fabric8.openshift.api.model.config.v1;

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
public class StringSourceSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.StringSourceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String env;
  private String file;
  private String keyFile;
  private String value;

  public StringSourceSpecFluent() {
  }
  
  public StringSourceSpecFluent(StringSourceSpec instance) {
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
  
  protected void copyInstance(StringSourceSpec instance) {
    instance = instance != null ? instance : new StringSourceSpec();
    if (instance != null) {
        this.withEnv(instance.getEnv());
        this.withFile(instance.getFile());
        this.withKeyFile(instance.getKeyFile());
        this.withValue(instance.getValue());
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
    StringSourceSpecFluent that = (StringSourceSpecFluent) o;
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(file, that.file))) {
      return false;
    }
    if (!(Objects.equals(keyFile, that.keyFile))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
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
  
  public String getEnv() {
    return this.env;
  }
  
  public String getFile() {
    return this.file;
  }
  
  public String getKeyFile() {
    return this.keyFile;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnv() {
    return this.env != null;
  }
  
  public boolean hasFile() {
    return this.file != null;
  }
  
  public boolean hasKeyFile() {
    return this.keyFile != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(env, file, keyFile, value, additionalProperties);
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
    if (!(env == null)) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(file == null)) {
        sb.append("file:");
        sb.append(file);
        sb.append(",");
    }
    if (!(keyFile == null)) {
        sb.append("keyFile:");
        sb.append(keyFile);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
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
  
  public A withEnv(String env) {
    this.env = env;
    return (A) this;
  }
  
  public A withFile(String file) {
    this.file = file;
    return (A) this;
  }
  
  public A withKeyFile(String keyFile) {
    this.keyFile = keyFile;
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  
}