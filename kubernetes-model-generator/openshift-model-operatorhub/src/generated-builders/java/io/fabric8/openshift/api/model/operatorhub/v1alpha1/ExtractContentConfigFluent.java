package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class ExtractContentConfigFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.ExtractContentConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cacheDir;
  private String catalogDir;

  public ExtractContentConfigFluent() {
  }
  
  public ExtractContentConfigFluent(ExtractContentConfig instance) {
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
  
  protected void copyInstance(ExtractContentConfig instance) {
    instance = instance != null ? instance : new ExtractContentConfig();
    if (instance != null) {
        this.withCacheDir(instance.getCacheDir());
        this.withCatalogDir(instance.getCatalogDir());
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
    ExtractContentConfigFluent that = (ExtractContentConfigFluent) o;
    if (!(Objects.equals(cacheDir, that.cacheDir))) {
      return false;
    }
    if (!(Objects.equals(catalogDir, that.catalogDir))) {
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
  
  public String getCacheDir() {
    return this.cacheDir;
  }
  
  public String getCatalogDir() {
    return this.catalogDir;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCacheDir() {
    return this.cacheDir != null;
  }
  
  public boolean hasCatalogDir() {
    return this.catalogDir != null;
  }
  
  public int hashCode() {
    return Objects.hash(cacheDir, catalogDir, additionalProperties);
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
    if (!(cacheDir == null)) {
        sb.append("cacheDir:");
        sb.append(cacheDir);
        sb.append(",");
    }
    if (!(catalogDir == null)) {
        sb.append("catalogDir:");
        sb.append(catalogDir);
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
  
  public A withCacheDir(String cacheDir) {
    this.cacheDir = cacheDir;
    return (A) this;
  }
  
  public A withCatalogDir(String catalogDir) {
    this.catalogDir = catalogDir;
    return (A) this;
  }
  
}