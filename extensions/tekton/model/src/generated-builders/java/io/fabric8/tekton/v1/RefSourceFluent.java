package io.fabric8.tekton.v1;

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
public class RefSourceFluent<A extends io.fabric8.tekton.v1.RefSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> digest;
  private String entryPoint;
  private String uri;

  public RefSourceFluent() {
  }
  
  public RefSourceFluent(RefSource instance) {
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
  
  public A addToDigest(Map<String,String> map) {
    if (this.digest == null && map != null) {
      this.digest = new LinkedHashMap();
    }
    if (map != null) {
      this.digest.putAll(map);
    }
    return (A) this;
  }
  
  public A addToDigest(String key,String value) {
    if (this.digest == null && key != null && value != null) {
      this.digest = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.digest.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(RefSource instance) {
    instance = instance != null ? instance : new RefSource();
    if (instance != null) {
        this.withDigest(instance.getDigest());
        this.withEntryPoint(instance.getEntryPoint());
        this.withUri(instance.getUri());
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
    RefSourceFluent that = (RefSourceFluent) o;
    if (!(Objects.equals(digest, that.digest))) {
      return false;
    }
    if (!(Objects.equals(entryPoint, that.entryPoint))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
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
  
  public Map<String,String> getDigest() {
    return this.digest;
  }
  
  public String getEntryPoint() {
    return this.entryPoint;
  }
  
  public String getUri() {
    return this.uri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDigest() {
    return this.digest != null;
  }
  
  public boolean hasEntryPoint() {
    return this.entryPoint != null;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public int hashCode() {
    return Objects.hash(digest, entryPoint, uri, additionalProperties);
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
  
  public A removeFromDigest(String key) {
    if (this.digest == null) {
      return (A) this;
    }
    if (key != null && this.digest != null) {
      this.digest.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromDigest(Map<String,String> map) {
    if (this.digest == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.digest != null) {
          this.digest.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(digest == null) && !(digest.isEmpty())) {
        sb.append("digest:");
        sb.append(digest);
        sb.append(",");
    }
    if (!(entryPoint == null)) {
        sb.append("entryPoint:");
        sb.append(entryPoint);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
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
  
  public <K,V>A withDigest(Map<String,String> digest) {
    if (digest == null) {
      this.digest = null;
    } else {
      this.digest = new LinkedHashMap(digest);
    }
    return (A) this;
  }
  
  public A withEntryPoint(String entryPoint) {
    this.entryPoint = entryPoint;
    return (A) this;
  }
  
  public A withUri(String uri) {
    this.uri = uri;
    return (A) this;
  }
  
}