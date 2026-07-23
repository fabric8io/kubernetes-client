package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class HeadersHeaderOperationsFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HeadersHeaderOperationsFluent<A>> extends BaseFluent<A>{

  private Map<String,String> add;
  private Map<String,Object> additionalProperties;
  private List<String> remove = new ArrayList<String>();
  private Map<String,String> set;

  public HeadersHeaderOperationsFluent() {
  }
  
  public HeadersHeaderOperationsFluent(HeadersHeaderOperations instance) {
    this.copyInstance(instance);
  }

  public A addAllToRemove(Collection<String> items) {
    if (this.remove == null) {
      this.remove = new ArrayList();
    }
    for (String item : items) {
      this.remove.add(item);
    }
    return (A) this;
  }
  
  public A addToAdd(Map<String,String> map) {
    if (this.add == null && map != null) {
      this.add = new LinkedHashMap();
    }
    if (map != null) {
      this.add.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdd(String key,String value) {
    if (this.add == null && key != null && value != null) {
      this.add = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.add.put(key, value);
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
  
  public A addToRemove(String... items) {
    if (this.remove == null) {
      this.remove = new ArrayList();
    }
    for (String item : items) {
      this.remove.add(item);
    }
    return (A) this;
  }
  
  public A addToRemove(int index,String item) {
    if (this.remove == null) {
      this.remove = new ArrayList();
    }
    this.remove.add(index, item);
    return (A) this;
  }
  
  public A addToSet(Map<String,String> map) {
    if (this.set == null && map != null) {
      this.set = new LinkedHashMap();
    }
    if (map != null) {
      this.set.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSet(String key,String value) {
    if (this.set == null && key != null && value != null) {
      this.set = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.set.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(HeadersHeaderOperations instance) {
    instance = instance != null ? instance : new HeadersHeaderOperations();
    if (instance != null) {
        this.withAdd(instance.getAdd());
        this.withRemove(instance.getRemove());
        this.withSet(instance.getSet());
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
    HeadersHeaderOperationsFluent that = (HeadersHeaderOperationsFluent) o;
    if (!(Objects.equals(add, that.add))) {
      return false;
    }
    if (!(Objects.equals(remove, that.remove))) {
      return false;
    }
    if (!(Objects.equals(set, that.set))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,String> getAdd() {
    return this.add;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getFirstRemove() {
    return this.remove.get(0);
  }
  
  public String getLastRemove() {
    return this.remove.get(remove.size() - 1);
  }
  
  public String getMatchingRemove(Predicate<String> predicate) {
      for (String item : remove) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getRemove() {
    return this.remove;
  }
  
  public String getRemove(int index) {
    return this.remove.get(index);
  }
  
  public Map<String,String> getSet() {
    return this.set;
  }
  
  public boolean hasAdd() {
    return this.add != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingRemove(Predicate<String> predicate) {
      for (String item : remove) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRemove() {
    return this.remove != null && !(this.remove.isEmpty());
  }
  
  public boolean hasSet() {
    return this.set != null;
  }
  
  public int hashCode() {
    return Objects.hash(add, remove, set, additionalProperties);
  }
  
  public A removeAllFromRemove(Collection<String> items) {
    if (this.remove == null) {
      return (A) this;
    }
    for (String item : items) {
      this.remove.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdd(String key) {
    if (this.add == null) {
      return (A) this;
    }
    if (key != null && this.add != null) {
      this.add.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdd(Map<String,String> map) {
    if (this.add == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.add != null) {
          this.add.remove(key);
        }
      }
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
  
  public A removeFromRemove(String... items) {
    if (this.remove == null) {
      return (A) this;
    }
    for (String item : items) {
      this.remove.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSet(String key) {
    if (this.set == null) {
      return (A) this;
    }
    if (key != null && this.set != null) {
      this.set.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSet(Map<String,String> map) {
    if (this.set == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.set != null) {
          this.set.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToRemove(int index,String item) {
    if (this.remove == null) {
      this.remove = new ArrayList();
    }
    this.remove.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(add == null) && !(add.isEmpty())) {
        sb.append("add:");
        sb.append(add);
        sb.append(",");
    }
    if (!(remove == null) && !(remove.isEmpty())) {
        sb.append("remove:");
        sb.append(remove);
        sb.append(",");
    }
    if (!(set == null) && !(set.isEmpty())) {
        sb.append("set:");
        sb.append(set);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdd(Map<String,String> add) {
    if (add == null) {
      this.add = null;
    } else {
      this.add = new LinkedHashMap(add);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withRemove(List<String> remove) {
    if (remove != null) {
        this.remove = new ArrayList();
        for (String item : remove) {
          this.addToRemove(item);
        }
    } else {
      this.remove = null;
    }
    return (A) this;
  }
  
  public A withRemove(String... remove) {
    if (this.remove != null) {
        this.remove.clear();
        _visitables.remove("remove");
    }
    if (remove != null) {
      for (String item : remove) {
        this.addToRemove(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withSet(Map<String,String> set) {
    if (set == null) {
      this.set = null;
    } else {
      this.set = new LinkedHashMap(set);
    }
    return (A) this;
  }
  
}