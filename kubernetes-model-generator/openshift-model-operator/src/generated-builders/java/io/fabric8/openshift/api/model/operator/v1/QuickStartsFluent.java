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
public class QuickStartsFluent<A extends io.fabric8.openshift.api.model.operator.v1.QuickStartsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> disabled = new ArrayList<String>();

  public QuickStartsFluent() {
  }
  
  public QuickStartsFluent(QuickStarts instance) {
    this.copyInstance(instance);
  }

  public A addAllToDisabled(Collection<String> items) {
    if (this.disabled == null) {
      this.disabled = new ArrayList();
    }
    for (String item : items) {
      this.disabled.add(item);
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
  
  public A addToDisabled(String... items) {
    if (this.disabled == null) {
      this.disabled = new ArrayList();
    }
    for (String item : items) {
      this.disabled.add(item);
    }
    return (A) this;
  }
  
  public A addToDisabled(int index,String item) {
    if (this.disabled == null) {
      this.disabled = new ArrayList();
    }
    this.disabled.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(QuickStarts instance) {
    instance = instance != null ? instance : new QuickStarts();
    if (instance != null) {
        this.withDisabled(instance.getDisabled());
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
    QuickStartsFluent that = (QuickStartsFluent) o;
    if (!(Objects.equals(disabled, that.disabled))) {
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
  
  public List<String> getDisabled() {
    return this.disabled;
  }
  
  public String getDisabled(int index) {
    return this.disabled.get(index);
  }
  
  public String getFirstDisabled() {
    return this.disabled.get(0);
  }
  
  public String getLastDisabled() {
    return this.disabled.get(disabled.size() - 1);
  }
  
  public String getMatchingDisabled(Predicate<String> predicate) {
      for (String item : disabled) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisabled() {
    return this.disabled != null && !(this.disabled.isEmpty());
  }
  
  public boolean hasMatchingDisabled(Predicate<String> predicate) {
      for (String item : disabled) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(disabled, additionalProperties);
  }
  
  public A removeAllFromDisabled(Collection<String> items) {
    if (this.disabled == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disabled.remove(item);
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
  
  public A removeFromDisabled(String... items) {
    if (this.disabled == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disabled.remove(item);
    }
    return (A) this;
  }
  
  public A setToDisabled(int index,String item) {
    if (this.disabled == null) {
      this.disabled = new ArrayList();
    }
    this.disabled.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(disabled == null) && !(disabled.isEmpty())) {
        sb.append("disabled:");
        sb.append(disabled);
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
  
  public A withDisabled(List<String> disabled) {
    if (disabled != null) {
        this.disabled = new ArrayList();
        for (String item : disabled) {
          this.addToDisabled(item);
        }
    } else {
      this.disabled = null;
    }
    return (A) this;
  }
  
  public A withDisabled(String... disabled) {
    if (this.disabled != null) {
        this.disabled.clear();
        _visitables.remove("disabled");
    }
    if (disabled != null) {
      for (String item : disabled) {
        this.addToDisabled(item);
      }
    }
    return (A) this;
  }
  
}