package io.fabric8.openshift.api.model.config.v1;

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
public class ExternalIPPolicyFluent<A extends io.fabric8.openshift.api.model.config.v1.ExternalIPPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> allowedCIDRs = new ArrayList<String>();
  private List<String> rejectedCIDRs = new ArrayList<String>();

  public ExternalIPPolicyFluent() {
  }
  
  public ExternalIPPolicyFluent(ExternalIPPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedCIDRs(Collection<String> items) {
    if (this.allowedCIDRs == null) {
      this.allowedCIDRs = new ArrayList();
    }
    for (String item : items) {
      this.allowedCIDRs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRejectedCIDRs(Collection<String> items) {
    if (this.rejectedCIDRs == null) {
      this.rejectedCIDRs = new ArrayList();
    }
    for (String item : items) {
      this.rejectedCIDRs.add(item);
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
  
  public A addToAllowedCIDRs(String... items) {
    if (this.allowedCIDRs == null) {
      this.allowedCIDRs = new ArrayList();
    }
    for (String item : items) {
      this.allowedCIDRs.add(item);
    }
    return (A) this;
  }
  
  public A addToAllowedCIDRs(int index,String item) {
    if (this.allowedCIDRs == null) {
      this.allowedCIDRs = new ArrayList();
    }
    this.allowedCIDRs.add(index, item);
    return (A) this;
  }
  
  public A addToRejectedCIDRs(String... items) {
    if (this.rejectedCIDRs == null) {
      this.rejectedCIDRs = new ArrayList();
    }
    for (String item : items) {
      this.rejectedCIDRs.add(item);
    }
    return (A) this;
  }
  
  public A addToRejectedCIDRs(int index,String item) {
    if (this.rejectedCIDRs == null) {
      this.rejectedCIDRs = new ArrayList();
    }
    this.rejectedCIDRs.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ExternalIPPolicy instance) {
    instance = instance != null ? instance : new ExternalIPPolicy();
    if (instance != null) {
        this.withAllowedCIDRs(instance.getAllowedCIDRs());
        this.withRejectedCIDRs(instance.getRejectedCIDRs());
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
    ExternalIPPolicyFluent that = (ExternalIPPolicyFluent) o;
    if (!(Objects.equals(allowedCIDRs, that.allowedCIDRs))) {
      return false;
    }
    if (!(Objects.equals(rejectedCIDRs, that.rejectedCIDRs))) {
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
  
  public String getAllowedCIDR(int index) {
    return this.allowedCIDRs.get(index);
  }
  
  public List<String> getAllowedCIDRs() {
    return this.allowedCIDRs;
  }
  
  public String getFirstAllowedCIDR() {
    return this.allowedCIDRs.get(0);
  }
  
  public String getFirstRejectedCIDR() {
    return this.rejectedCIDRs.get(0);
  }
  
  public String getLastAllowedCIDR() {
    return this.allowedCIDRs.get(allowedCIDRs.size() - 1);
  }
  
  public String getLastRejectedCIDR() {
    return this.rejectedCIDRs.get(rejectedCIDRs.size() - 1);
  }
  
  public String getMatchingAllowedCIDR(Predicate<String> predicate) {
      for (String item : allowedCIDRs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRejectedCIDR(Predicate<String> predicate) {
      for (String item : rejectedCIDRs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRejectedCIDR(int index) {
    return this.rejectedCIDRs.get(index);
  }
  
  public List<String> getRejectedCIDRs() {
    return this.rejectedCIDRs;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowedCIDRs() {
    return this.allowedCIDRs != null && !(this.allowedCIDRs.isEmpty());
  }
  
  public boolean hasMatchingAllowedCIDR(Predicate<String> predicate) {
      for (String item : allowedCIDRs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRejectedCIDR(Predicate<String> predicate) {
      for (String item : rejectedCIDRs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRejectedCIDRs() {
    return this.rejectedCIDRs != null && !(this.rejectedCIDRs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(allowedCIDRs, rejectedCIDRs, additionalProperties);
  }
  
  public A removeAllFromAllowedCIDRs(Collection<String> items) {
    if (this.allowedCIDRs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedCIDRs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRejectedCIDRs(Collection<String> items) {
    if (this.rejectedCIDRs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.rejectedCIDRs.remove(item);
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
  
  public A removeFromAllowedCIDRs(String... items) {
    if (this.allowedCIDRs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.allowedCIDRs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRejectedCIDRs(String... items) {
    if (this.rejectedCIDRs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.rejectedCIDRs.remove(item);
    }
    return (A) this;
  }
  
  public A setToAllowedCIDRs(int index,String item) {
    if (this.allowedCIDRs == null) {
      this.allowedCIDRs = new ArrayList();
    }
    this.allowedCIDRs.set(index, item);
    return (A) this;
  }
  
  public A setToRejectedCIDRs(int index,String item) {
    if (this.rejectedCIDRs == null) {
      this.rejectedCIDRs = new ArrayList();
    }
    this.rejectedCIDRs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowedCIDRs == null) && !(allowedCIDRs.isEmpty())) {
        sb.append("allowedCIDRs:");
        sb.append(allowedCIDRs);
        sb.append(",");
    }
    if (!(rejectedCIDRs == null) && !(rejectedCIDRs.isEmpty())) {
        sb.append("rejectedCIDRs:");
        sb.append(rejectedCIDRs);
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
  
  public A withAllowedCIDRs(List<String> allowedCIDRs) {
    if (allowedCIDRs != null) {
        this.allowedCIDRs = new ArrayList();
        for (String item : allowedCIDRs) {
          this.addToAllowedCIDRs(item);
        }
    } else {
      this.allowedCIDRs = null;
    }
    return (A) this;
  }
  
  public A withAllowedCIDRs(String... allowedCIDRs) {
    if (this.allowedCIDRs != null) {
        this.allowedCIDRs.clear();
        _visitables.remove("allowedCIDRs");
    }
    if (allowedCIDRs != null) {
      for (String item : allowedCIDRs) {
        this.addToAllowedCIDRs(item);
      }
    }
    return (A) this;
  }
  
  public A withRejectedCIDRs(List<String> rejectedCIDRs) {
    if (rejectedCIDRs != null) {
        this.rejectedCIDRs = new ArrayList();
        for (String item : rejectedCIDRs) {
          this.addToRejectedCIDRs(item);
        }
    } else {
      this.rejectedCIDRs = null;
    }
    return (A) this;
  }
  
  public A withRejectedCIDRs(String... rejectedCIDRs) {
    if (this.rejectedCIDRs != null) {
        this.rejectedCIDRs.clear();
        _visitables.remove("rejectedCIDRs");
    }
    if (rejectedCIDRs != null) {
      for (String item : rejectedCIDRs) {
        this.addToRejectedCIDRs(item);
      }
    }
    return (A) this;
  }
  
}