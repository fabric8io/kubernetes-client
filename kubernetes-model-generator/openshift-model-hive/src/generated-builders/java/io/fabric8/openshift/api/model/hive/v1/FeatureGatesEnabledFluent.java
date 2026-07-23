package io.fabric8.openshift.api.model.hive.v1;

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
public class FeatureGatesEnabledFluent<A extends io.fabric8.openshift.api.model.hive.v1.FeatureGatesEnabledFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> enabled = new ArrayList<String>();

  public FeatureGatesEnabledFluent() {
  }
  
  public FeatureGatesEnabledFluent(FeatureGatesEnabled instance) {
    this.copyInstance(instance);
  }

  public A addAllToEnabled(Collection<String> items) {
    if (this.enabled == null) {
      this.enabled = new ArrayList();
    }
    for (String item : items) {
      this.enabled.add(item);
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
  
  public A addToEnabled(String... items) {
    if (this.enabled == null) {
      this.enabled = new ArrayList();
    }
    for (String item : items) {
      this.enabled.add(item);
    }
    return (A) this;
  }
  
  public A addToEnabled(int index,String item) {
    if (this.enabled == null) {
      this.enabled = new ArrayList();
    }
    this.enabled.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(FeatureGatesEnabled instance) {
    instance = instance != null ? instance : new FeatureGatesEnabled();
    if (instance != null) {
        this.withEnabled(instance.getEnabled());
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
    FeatureGatesEnabledFluent that = (FeatureGatesEnabledFluent) o;
    if (!(Objects.equals(enabled, that.enabled))) {
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
  
  public List<String> getEnabled() {
    return this.enabled;
  }
  
  public String getEnabled(int index) {
    return this.enabled.get(index);
  }
  
  public String getFirstEnabled() {
    return this.enabled.get(0);
  }
  
  public String getLastEnabled() {
    return this.enabled.get(enabled.size() - 1);
  }
  
  public String getMatchingEnabled(Predicate<String> predicate) {
      for (String item : enabled) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnabled() {
    return this.enabled != null && !(this.enabled.isEmpty());
  }
  
  public boolean hasMatchingEnabled(Predicate<String> predicate) {
      for (String item : enabled) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(enabled, additionalProperties);
  }
  
  public A removeAllFromEnabled(Collection<String> items) {
    if (this.enabled == null) {
      return (A) this;
    }
    for (String item : items) {
      this.enabled.remove(item);
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
  
  public A removeFromEnabled(String... items) {
    if (this.enabled == null) {
      return (A) this;
    }
    for (String item : items) {
      this.enabled.remove(item);
    }
    return (A) this;
  }
  
  public A setToEnabled(int index,String item) {
    if (this.enabled == null) {
      this.enabled = new ArrayList();
    }
    this.enabled.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(enabled == null) && !(enabled.isEmpty())) {
        sb.append("enabled:");
        sb.append(enabled);
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
  
  public A withEnabled(List<String> enabled) {
    if (enabled != null) {
        this.enabled = new ArrayList();
        for (String item : enabled) {
          this.addToEnabled(item);
        }
    } else {
      this.enabled = null;
    }
    return (A) this;
  }
  
  public A withEnabled(String... enabled) {
    if (this.enabled != null) {
        this.enabled.clear();
        _visitables.remove("enabled");
    }
    if (enabled != null) {
      for (String item : enabled) {
        this.addToEnabled(item);
      }
    }
    return (A) this;
  }
  
}