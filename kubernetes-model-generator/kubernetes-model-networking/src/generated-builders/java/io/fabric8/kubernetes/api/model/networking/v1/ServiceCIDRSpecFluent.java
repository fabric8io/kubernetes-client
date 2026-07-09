package io.fabric8.kubernetes.api.model.networking.v1;

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
public class ServiceCIDRSpecFluent<A extends io.fabric8.kubernetes.api.model.networking.v1.ServiceCIDRSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> cidrs = new ArrayList<String>();

  public ServiceCIDRSpecFluent() {
  }
  
  public ServiceCIDRSpecFluent(ServiceCIDRSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToCidrs(Collection<String> items) {
    if (this.cidrs == null) {
      this.cidrs = new ArrayList();
    }
    for (String item : items) {
      this.cidrs.add(item);
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
  
  public A addToCidrs(String... items) {
    if (this.cidrs == null) {
      this.cidrs = new ArrayList();
    }
    for (String item : items) {
      this.cidrs.add(item);
    }
    return (A) this;
  }
  
  public A addToCidrs(int index,String item) {
    if (this.cidrs == null) {
      this.cidrs = new ArrayList();
    }
    this.cidrs.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ServiceCIDRSpec instance) {
    instance = instance != null ? instance : new ServiceCIDRSpec();
    if (instance != null) {
        this.withCidrs(instance.getCidrs());
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
    ServiceCIDRSpecFluent that = (ServiceCIDRSpecFluent) o;
    if (!(Objects.equals(cidrs, that.cidrs))) {
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
  
  public String getCidr(int index) {
    return this.cidrs.get(index);
  }
  
  public List<String> getCidrs() {
    return this.cidrs;
  }
  
  public String getFirstCidr() {
    return this.cidrs.get(0);
  }
  
  public String getLastCidr() {
    return this.cidrs.get(cidrs.size() - 1);
  }
  
  public String getMatchingCidr(Predicate<String> predicate) {
      for (String item : cidrs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCidrs() {
    return this.cidrs != null && !(this.cidrs.isEmpty());
  }
  
  public boolean hasMatchingCidr(Predicate<String> predicate) {
      for (String item : cidrs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(cidrs, additionalProperties);
  }
  
  public A removeAllFromCidrs(Collection<String> items) {
    if (this.cidrs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.cidrs.remove(item);
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
  
  public A removeFromCidrs(String... items) {
    if (this.cidrs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.cidrs.remove(item);
    }
    return (A) this;
  }
  
  public A setToCidrs(int index,String item) {
    if (this.cidrs == null) {
      this.cidrs = new ArrayList();
    }
    this.cidrs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cidrs == null) && !(cidrs.isEmpty())) {
        sb.append("cidrs:");
        sb.append(cidrs);
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
  
  public A withCidrs(List<String> cidrs) {
    if (cidrs != null) {
        this.cidrs = new ArrayList();
        for (String item : cidrs) {
          this.addToCidrs(item);
        }
    } else {
      this.cidrs = null;
    }
    return (A) this;
  }
  
  public A withCidrs(String... cidrs) {
    if (this.cidrs != null) {
        this.cidrs.clear();
        _visitables.remove("cidrs");
    }
    if (cidrs != null) {
      for (String item : cidrs) {
        this.addToCidrs(item);
      }
    }
    return (A) this;
  }
  
}