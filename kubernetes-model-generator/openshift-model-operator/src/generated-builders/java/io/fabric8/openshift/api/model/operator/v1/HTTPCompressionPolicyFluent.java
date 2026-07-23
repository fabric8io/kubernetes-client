package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPCompressionPolicyFluent<A extends io.fabric8.openshift.api.model.operator.v1.HTTPCompressionPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> mimeTypes = new ArrayList<String>();

  public HTTPCompressionPolicyFluent() {
  }
  
  public HTTPCompressionPolicyFluent(HTTPCompressionPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToMimeTypes(Collection<String> items) {
    if (this.mimeTypes == null) {
      this.mimeTypes = new ArrayList();
    }
    for (String item : items) {
      this.mimeTypes.add(item);
    }
    return (A) this;
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
  
  public A addToMimeTypes(String... items) {
    if (this.mimeTypes == null) {
      this.mimeTypes = new ArrayList();
    }
    for (String item : items) {
      this.mimeTypes.add(item);
    }
    return (A) this;
  }
  
  public A addToMimeTypes(int index,String item) {
    if (this.mimeTypes == null) {
      this.mimeTypes = new ArrayList();
    }
    this.mimeTypes.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(HTTPCompressionPolicy instance) {
    instance = instance != null ? instance : new HTTPCompressionPolicy();
    if (instance != null) {
        this.withMimeTypes(instance.getMimeTypes());
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
    HTTPCompressionPolicyFluent that = (HTTPCompressionPolicyFluent) o;
    if (!(Objects.equals(mimeTypes, that.mimeTypes))) {
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
  
  public String getFirstMimeType() {
    return this.mimeTypes.get(0);
  }
  
  public String getLastMimeType() {
    return this.mimeTypes.get(mimeTypes.size() - 1);
  }
  
  public String getMatchingMimeType(Predicate<String> predicate) {
      for (String item : mimeTypes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMimeType(int index) {
    return this.mimeTypes.get(index);
  }
  
  public List<String> getMimeTypes() {
    return this.mimeTypes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingMimeType(Predicate<String> predicate) {
      for (String item : mimeTypes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMimeTypes() {
    return this.mimeTypes != null && !(this.mimeTypes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(mimeTypes, additionalProperties);
  }
  
  public A removeAllFromMimeTypes(Collection<String> items) {
    if (this.mimeTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mimeTypes.remove(item);
    }
    return (A) this;
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
  
  public A removeFromMimeTypes(String... items) {
    if (this.mimeTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mimeTypes.remove(item);
    }
    return (A) this;
  }
  
  public A setToMimeTypes(int index,String item) {
    if (this.mimeTypes == null) {
      this.mimeTypes = new ArrayList();
    }
    this.mimeTypes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(mimeTypes == null) && !(mimeTypes.isEmpty())) {
        sb.append("mimeTypes:");
        sb.append(mimeTypes);
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
  
  public A withMimeTypes(List<String> mimeTypes) {
    if (mimeTypes != null) {
        this.mimeTypes = new ArrayList();
        for (String item : mimeTypes) {
          this.addToMimeTypes(item);
        }
    } else {
      this.mimeTypes = null;
    }
    return (A) this;
  }
  
  public A withMimeTypes(String... mimeTypes) {
    if (this.mimeTypes != null) {
        this.mimeTypes.clear();
        _visitables.remove("mimeTypes");
    }
    if (mimeTypes != null) {
      for (String item : mimeTypes) {
        this.addToMimeTypes(item);
      }
    }
    return (A) this;
  }
  
}