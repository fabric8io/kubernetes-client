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
public class DNSZoneFluent<A extends io.fabric8.openshift.api.model.config.v1.DNSZoneFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String id;
  private Map<String,String> tags;

  public DNSZoneFluent() {
  }
  
  public DNSZoneFluent(DNSZone instance) {
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
  
  public A addToTags(Map<String,String> map) {
    if (this.tags == null && map != null) {
      this.tags = new LinkedHashMap();
    }
    if (map != null) {
      this.tags.putAll(map);
    }
    return (A) this;
  }
  
  public A addToTags(String key,String value) {
    if (this.tags == null && key != null && value != null) {
      this.tags = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.tags.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(DNSZone instance) {
    instance = instance != null ? instance : new DNSZone();
    if (instance != null) {
        this.withId(instance.getId());
        this.withTags(instance.getTags());
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
    DNSZoneFluent that = (DNSZoneFluent) o;
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
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
  
  public String getId() {
    return this.id;
  }
  
  public Map<String,String> getTags() {
    return this.tags;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasTags() {
    return this.tags != null;
  }
  
  public int hashCode() {
    return Objects.hash(id, tags, additionalProperties);
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
  
  public A removeFromTags(String key) {
    if (this.tags == null) {
      return (A) this;
    }
    if (key != null && this.tags != null) {
      this.tags.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromTags(Map<String,String> map) {
    if (this.tags == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.tags != null) {
          this.tags.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
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
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public <K,V>A withTags(Map<String,String> tags) {
    if (tags == null) {
      this.tags = null;
    } else {
      this.tags = new LinkedHashMap(tags);
    }
    return (A) this;
  }
  
}