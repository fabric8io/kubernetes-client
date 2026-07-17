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
public class AWSSubnetsFluent<A extends io.fabric8.openshift.api.model.operator.v1.AWSSubnetsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> ids = new ArrayList<String>();
  private List<String> names = new ArrayList<String>();

  public AWSSubnetsFluent() {
  }
  
  public AWSSubnetsFluent(AWSSubnets instance) {
    this.copyInstance(instance);
  }

  public A addAllToIds(Collection<String> items) {
    if (this.ids == null) {
      this.ids = new ArrayList();
    }
    for (String item : items) {
      this.ids.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNames(Collection<String> items) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    for (String item : items) {
      this.names.add(item);
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
  
  public A addToIds(String... items) {
    if (this.ids == null) {
      this.ids = new ArrayList();
    }
    for (String item : items) {
      this.ids.add(item);
    }
    return (A) this;
  }
  
  public A addToIds(int index,String item) {
    if (this.ids == null) {
      this.ids = new ArrayList();
    }
    this.ids.add(index, item);
    return (A) this;
  }
  
  public A addToNames(String... items) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    for (String item : items) {
      this.names.add(item);
    }
    return (A) this;
  }
  
  public A addToNames(int index,String item) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    this.names.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(AWSSubnets instance) {
    instance = instance != null ? instance : new AWSSubnets();
    if (instance != null) {
        this.withIds(instance.getIds());
        this.withNames(instance.getNames());
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
    AWSSubnetsFluent that = (AWSSubnetsFluent) o;
    if (!(Objects.equals(ids, that.ids))) {
      return false;
    }
    if (!(Objects.equals(names, that.names))) {
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
  
  public String getFirstId() {
    return this.ids.get(0);
  }
  
  public String getFirstName() {
    return this.names.get(0);
  }
  
  public String getId(int index) {
    return this.ids.get(index);
  }
  
  public List<String> getIds() {
    return this.ids;
  }
  
  public String getLastId() {
    return this.ids.get(ids.size() - 1);
  }
  
  public String getLastName() {
    return this.names.get(names.size() - 1);
  }
  
  public String getMatchingId(Predicate<String> predicate) {
      for (String item : ids) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingName(Predicate<String> predicate) {
      for (String item : names) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName(int index) {
    return this.names.get(index);
  }
  
  public List<String> getNames() {
    return this.names;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIds() {
    return this.ids != null && !(this.ids.isEmpty());
  }
  
  public boolean hasMatchingId(Predicate<String> predicate) {
      for (String item : ids) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingName(Predicate<String> predicate) {
      for (String item : names) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNames() {
    return this.names != null && !(this.names.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(ids, names, additionalProperties);
  }
  
  public A removeAllFromIds(Collection<String> items) {
    if (this.ids == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ids.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNames(Collection<String> items) {
    if (this.names == null) {
      return (A) this;
    }
    for (String item : items) {
      this.names.remove(item);
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
  
  public A removeFromIds(String... items) {
    if (this.ids == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ids.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNames(String... items) {
    if (this.names == null) {
      return (A) this;
    }
    for (String item : items) {
      this.names.remove(item);
    }
    return (A) this;
  }
  
  public A setToIds(int index,String item) {
    if (this.ids == null) {
      this.ids = new ArrayList();
    }
    this.ids.set(index, item);
    return (A) this;
  }
  
  public A setToNames(int index,String item) {
    if (this.names == null) {
      this.names = new ArrayList();
    }
    this.names.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ids == null) && !(ids.isEmpty())) {
        sb.append("ids:");
        sb.append(ids);
        sb.append(",");
    }
    if (!(names == null) && !(names.isEmpty())) {
        sb.append("names:");
        sb.append(names);
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
  
  public A withIds(List<String> ids) {
    if (ids != null) {
        this.ids = new ArrayList();
        for (String item : ids) {
          this.addToIds(item);
        }
    } else {
      this.ids = null;
    }
    return (A) this;
  }
  
  public A withIds(String... ids) {
    if (this.ids != null) {
        this.ids.clear();
        _visitables.remove("ids");
    }
    if (ids != null) {
      for (String item : ids) {
        this.addToIds(item);
      }
    }
    return (A) this;
  }
  
  public A withNames(List<String> names) {
    if (names != null) {
        this.names = new ArrayList();
        for (String item : names) {
          this.addToNames(item);
        }
    } else {
      this.names = null;
    }
    return (A) this;
  }
  
  public A withNames(String... names) {
    if (this.names != null) {
        this.names.clear();
        _visitables.remove("names");
    }
    if (names != null) {
      for (String item : names) {
        this.addToNames(item);
      }
    }
    return (A) this;
  }
  
}