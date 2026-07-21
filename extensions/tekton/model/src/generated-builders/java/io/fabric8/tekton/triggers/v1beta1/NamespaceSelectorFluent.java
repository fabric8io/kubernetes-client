package io.fabric8.tekton.triggers.v1beta1;

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
public class NamespaceSelectorFluent<A extends io.fabric8.tekton.triggers.v1beta1.NamespaceSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> matchNames = new ArrayList<String>();

  public NamespaceSelectorFluent() {
  }
  
  public NamespaceSelectorFluent(NamespaceSelector instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchNames(Collection<String> items) {
    if (this.matchNames == null) {
      this.matchNames = new ArrayList();
    }
    for (String item : items) {
      this.matchNames.add(item);
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
  
  public A addToMatchNames(String... items) {
    if (this.matchNames == null) {
      this.matchNames = new ArrayList();
    }
    for (String item : items) {
      this.matchNames.add(item);
    }
    return (A) this;
  }
  
  public A addToMatchNames(int index,String item) {
    if (this.matchNames == null) {
      this.matchNames = new ArrayList();
    }
    this.matchNames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NamespaceSelector instance) {
    instance = instance != null ? instance : new NamespaceSelector();
    if (instance != null) {
        this.withMatchNames(instance.getMatchNames());
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
    NamespaceSelectorFluent that = (NamespaceSelectorFluent) o;
    if (!(Objects.equals(matchNames, that.matchNames))) {
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
  
  public String getFirstMatchName() {
    return this.matchNames.get(0);
  }
  
  public String getLastMatchName() {
    return this.matchNames.get(matchNames.size() - 1);
  }
  
  public String getMatchName(int index) {
    return this.matchNames.get(index);
  }
  
  public List<String> getMatchNames() {
    return this.matchNames;
  }
  
  public String getMatchingMatchName(Predicate<String> predicate) {
      for (String item : matchNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchNames() {
    return this.matchNames != null && !(this.matchNames.isEmpty());
  }
  
  public boolean hasMatchingMatchName(Predicate<String> predicate) {
      for (String item : matchNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(matchNames, additionalProperties);
  }
  
  public A removeAllFromMatchNames(Collection<String> items) {
    if (this.matchNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.matchNames.remove(item);
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
  
  public A removeFromMatchNames(String... items) {
    if (this.matchNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.matchNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToMatchNames(int index,String item) {
    if (this.matchNames == null) {
      this.matchNames = new ArrayList();
    }
    this.matchNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(matchNames == null) && !(matchNames.isEmpty())) {
        sb.append("matchNames:");
        sb.append(matchNames);
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
  
  public A withMatchNames(List<String> matchNames) {
    if (matchNames != null) {
        this.matchNames = new ArrayList();
        for (String item : matchNames) {
          this.addToMatchNames(item);
        }
    } else {
      this.matchNames = null;
    }
    return (A) this;
  }
  
  public A withMatchNames(String... matchNames) {
    if (this.matchNames != null) {
        this.matchNames.clear();
        _visitables.remove("matchNames");
    }
    if (matchNames != null) {
      for (String item : matchNames) {
        this.addToMatchNames(item);
      }
    }
    return (A) this;
  }
  
}