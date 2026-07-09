package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class NamedResourcesStringSliceFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.NamedResourcesStringSliceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> strings = new ArrayList<String>();

  public NamedResourcesStringSliceFluent() {
  }
  
  public NamedResourcesStringSliceFluent(NamedResourcesStringSlice instance) {
    this.copyInstance(instance);
  }

  public A addAllToStrings(Collection<String> items) {
    if (this.strings == null) {
      this.strings = new ArrayList();
    }
    for (String item : items) {
      this.strings.add(item);
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
  
  public A addToStrings(String... items) {
    if (this.strings == null) {
      this.strings = new ArrayList();
    }
    for (String item : items) {
      this.strings.add(item);
    }
    return (A) this;
  }
  
  public A addToStrings(int index,String item) {
    if (this.strings == null) {
      this.strings = new ArrayList();
    }
    this.strings.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(NamedResourcesStringSlice instance) {
    instance = instance != null ? instance : new NamedResourcesStringSlice();
    if (instance != null) {
        this.withStrings(instance.getStrings());
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
    NamedResourcesStringSliceFluent that = (NamedResourcesStringSliceFluent) o;
    if (!(Objects.equals(strings, that.strings))) {
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
  
  public String getFirstString() {
    return this.strings.get(0);
  }
  
  public String getLastString() {
    return this.strings.get(strings.size() - 1);
  }
  
  public String getMatchingString(Predicate<String> predicate) {
      for (String item : strings) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getString(int index) {
    return this.strings.get(index);
  }
  
  public List<String> getStrings() {
    return this.strings;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingString(Predicate<String> predicate) {
      for (String item : strings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStrings() {
    return this.strings != null && !(this.strings.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(strings, additionalProperties);
  }
  
  public A removeAllFromStrings(Collection<String> items) {
    if (this.strings == null) {
      return (A) this;
    }
    for (String item : items) {
      this.strings.remove(item);
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
  
  public A removeFromStrings(String... items) {
    if (this.strings == null) {
      return (A) this;
    }
    for (String item : items) {
      this.strings.remove(item);
    }
    return (A) this;
  }
  
  public A setToStrings(int index,String item) {
    if (this.strings == null) {
      this.strings = new ArrayList();
    }
    this.strings.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(strings == null) && !(strings.isEmpty())) {
        sb.append("strings:");
        sb.append(strings);
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
  
  public A withStrings(List<String> strings) {
    if (strings != null) {
        this.strings = new ArrayList();
        for (String item : strings) {
          this.addToStrings(item);
        }
    } else {
      this.strings = null;
    }
    return (A) this;
  }
  
  public A withStrings(String... strings) {
    if (this.strings != null) {
        this.strings.clear();
        _visitables.remove("strings");
    }
    if (strings != null) {
      for (String item : strings) {
        this.addToStrings(item);
      }
    }
    return (A) this;
  }
  
}