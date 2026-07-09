package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class GRPCAuthConfigFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GRPCAuthConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> allowedHeaders = new ArrayList<String>();

  public GRPCAuthConfigFluent() {
  }
  
  public GRPCAuthConfigFluent(GRPCAuthConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedHeaders(Collection<String> items) {
    if (this.allowedHeaders == null) {
      this.allowedHeaders = new ArrayList();
    }
    for (String item : items) {
      this.allowedHeaders.add(item);
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
  
  public A addToAllowedHeaders(String... items) {
    if (this.allowedHeaders == null) {
      this.allowedHeaders = new ArrayList();
    }
    for (String item : items) {
      this.allowedHeaders.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedHeaders(int index,String item) {
    if (this.allowedHeaders == null) {
      this.allowedHeaders = new ArrayList();
    }
    this.allowedHeaders.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(GRPCAuthConfig instance) {
    instance = instance != null ? instance : new GRPCAuthConfig();
    if (instance != null) {
        this.withAllowedHeaders(instance.getAllowedHeaders());
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
    GRPCAuthConfigFluent that = (GRPCAuthConfigFluent) o;
    if (!(Objects.equals(allowedHeaders, that.allowedHeaders))) {
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
  
  public String getAllowedHeader(int index) {
    return this.allowedHeaders.get(index);
  }
  
  public List<String> getAllowedHeaders() {
    return this.allowedHeaders;
  }
  
  public String getFirstAllowedHeader() {
    return this.allowedHeaders.get(0);
  }
  
  public String getLastAllowedHeader() {
    return this.allowedHeaders.get(allowedHeaders.size() - 1);
  }
  
  public String getMatchingAllowedHeader(Predicate<String> predicate) {
      for (String item : allowedHeaders) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowedHeaders() {
    return this.allowedHeaders != null && !(this.allowedHeaders.isEmpty());
  }
  
  public boolean hasMatchingAllowedHeader(Predicate<String> predicate) {
      for (String item : allowedHeaders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(allowedHeaders, additionalProperties);
  }
  
  public A removeAllFromAllowedHeaders(Collection<String> items) {
    if (this.allowedHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedHeaders.remove(item);
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
  
  public A removeFromAllowedHeaders(String... items) {
    if (this.allowedHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedHeaders.remove(item);
    }
    return (A) this;
  }
  
  public A setToAllowedHeaders(int index,String item) {
    if (this.allowedHeaders == null) {
      this.allowedHeaders = new ArrayList();
    }
    this.allowedHeaders.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowedHeaders == null) && !(allowedHeaders.isEmpty())) {
        sb.append("allowedHeaders:");
        sb.append(allowedHeaders);
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
  
  public A withAllowedHeaders(List<String> allowedHeaders) {
    if (allowedHeaders != null) {
        this.allowedHeaders = new ArrayList();
        for (String item : allowedHeaders) {
          this.addToAllowedHeaders(item);
        }
    } else {
      this.allowedHeaders = null;
    }
    return (A) this;
  }
  
  public A withAllowedHeaders(String... allowedHeaders) {
    if (this.allowedHeaders != null) {
        this.allowedHeaders.clear();
        _visitables.remove("allowedHeaders");
    }
    if (allowedHeaders != null) {
      for (String item : allowedHeaders) {
        this.addToAllowedHeaders(item);
      }
    }
    return (A) this;
  }
  
}