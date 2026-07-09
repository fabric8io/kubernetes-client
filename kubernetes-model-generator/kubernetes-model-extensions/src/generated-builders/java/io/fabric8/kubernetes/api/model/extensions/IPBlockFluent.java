package io.fabric8.kubernetes.api.model.extensions;

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
public class IPBlockFluent<A extends io.fabric8.kubernetes.api.model.extensions.IPBlockFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cidr;
  private List<String> except = new ArrayList<String>();

  public IPBlockFluent() {
  }
  
  public IPBlockFluent(IPBlock instance) {
    this.copyInstance(instance);
  }

  public A addAllToExcept(Collection<String> items) {
    if (this.except == null) {
      this.except = new ArrayList();
    }
    for (String item : items) {
      this.except.add(item);
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
  
  public A addToExcept(String... items) {
    if (this.except == null) {
      this.except = new ArrayList();
    }
    for (String item : items) {
      this.except.add(item);
    }
    return (A) this;
  }
  
  public A addToExcept(int index,String item) {
    if (this.except == null) {
      this.except = new ArrayList();
    }
    this.except.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(IPBlock instance) {
    instance = instance != null ? instance : new IPBlock();
    if (instance != null) {
        this.withCidr(instance.getCidr());
        this.withExcept(instance.getExcept());
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
    IPBlockFluent that = (IPBlockFluent) o;
    if (!(Objects.equals(cidr, that.cidr))) {
      return false;
    }
    if (!(Objects.equals(except, that.except))) {
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
  
  public String getCidr() {
    return this.cidr;
  }
  
  public List<String> getExcept() {
    return this.except;
  }
  
  public String getExcept(int index) {
    return this.except.get(index);
  }
  
  public String getFirstExcept() {
    return this.except.get(0);
  }
  
  public String getLastExcept() {
    return this.except.get(except.size() - 1);
  }
  
  public String getMatchingExcept(Predicate<String> predicate) {
      for (String item : except) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCidr() {
    return this.cidr != null;
  }
  
  public boolean hasExcept() {
    return this.except != null && !(this.except.isEmpty());
  }
  
  public boolean hasMatchingExcept(Predicate<String> predicate) {
      for (String item : except) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(cidr, except, additionalProperties);
  }
  
  public A removeAllFromExcept(Collection<String> items) {
    if (this.except == null) {
      return (A) this;
    }
    for (String item : items) {
      this.except.remove(item);
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
  
  public A removeFromExcept(String... items) {
    if (this.except == null) {
      return (A) this;
    }
    for (String item : items) {
      this.except.remove(item);
    }
    return (A) this;
  }
  
  public A setToExcept(int index,String item) {
    if (this.except == null) {
      this.except = new ArrayList();
    }
    this.except.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cidr == null)) {
        sb.append("cidr:");
        sb.append(cidr);
        sb.append(",");
    }
    if (!(except == null) && !(except.isEmpty())) {
        sb.append("except:");
        sb.append(except);
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
  
  public A withCidr(String cidr) {
    this.cidr = cidr;
    return (A) this;
  }
  
  public A withExcept(List<String> except) {
    if (except != null) {
        this.except = new ArrayList();
        for (String item : except) {
          this.addToExcept(item);
        }
    } else {
      this.except = null;
    }
    return (A) this;
  }
  
  public A withExcept(String... except) {
    if (this.except != null) {
        this.except.clear();
        _visitables.remove("except");
    }
    if (except != null) {
      for (String item : except) {
        this.addToExcept(item);
      }
    }
    return (A) this;
  }
  
}