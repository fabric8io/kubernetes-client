package io.fabric8.openshift.api.model.installer.openstack.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class RootVolumeFluent<A extends io.fabric8.openshift.api.model.installer.openstack.v1.RootVolumeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer size;
  private String type;
  private List<String> types = new ArrayList<String>();
  private List<String> zones = new ArrayList<String>();

  public RootVolumeFluent() {
  }
  
  public RootVolumeFluent(RootVolume instance) {
    this.copyInstance(instance);
  }

  public A addAllToTypes(Collection<String> items) {
    if (this.types == null) {
      this.types = new ArrayList();
    }
    for (String item : items) {
      this.types.add(item);
    }
    return (A) this;
  }
  
  public A addAllToZones(Collection<String> items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
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
  
  public A addToTypes(String... items) {
    if (this.types == null) {
      this.types = new ArrayList();
    }
    for (String item : items) {
      this.types.add(item);
    }
    return (A) this;
  }
  
  public A addToTypes(int index,String item) {
    if (this.types == null) {
      this.types = new ArrayList();
    }
    this.types.add(index, item);
    return (A) this;
  }
  
  public A addToZones(String... items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
  }
  
  public A addToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(RootVolume instance) {
    instance = instance != null ? instance : new RootVolume();
    if (instance != null) {
        this.withSize(instance.getSize());
        this.withType(instance.getType());
        this.withTypes(instance.getTypes());
        this.withZones(instance.getZones());
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
    RootVolumeFluent that = (RootVolumeFluent) o;
    if (!(Objects.equals(size, that.size))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(types, that.types))) {
      return false;
    }
    if (!(Objects.equals(zones, that.zones))) {
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
  
  public String getFirstType() {
    return this.types.get(0);
  }
  
  public String getFirstZone() {
    return this.zones.get(0);
  }
  
  public String getLastType() {
    return this.types.get(types.size() - 1);
  }
  
  public String getLastZone() {
    return this.zones.get(zones.size() - 1);
  }
  
  public String getMatchingType(Predicate<String> predicate) {
      for (String item : types) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getSize() {
    return this.size;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getType(int index) {
    return this.types.get(index);
  }
  
  public List<String> getTypes() {
    return this.types;
  }
  
  public String getZone(int index) {
    return this.zones.get(index);
  }
  
  public List<String> getZones() {
    return this.zones;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingType(Predicate<String> predicate) {
      for (String item : types) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSize() {
    return this.size != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasTypes() {
    return this.types != null && !(this.types.isEmpty());
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(size, type, types, zones, additionalProperties);
  }
  
  public A removeAllFromTypes(Collection<String> items) {
    if (this.types == null) {
      return (A) this;
    }
    for (String item : items) {
      this.types.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromZones(Collection<String> items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
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
  
  public A removeFromTypes(String... items) {
    if (this.types == null) {
      return (A) this;
    }
    for (String item : items) {
      this.types.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromZones(String... items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
    }
    return (A) this;
  }
  
  public A setToTypes(int index,String item) {
    if (this.types == null) {
      this.types = new ArrayList();
    }
    this.types.set(index, item);
    return (A) this;
  }
  
  public A setToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(size == null)) {
        sb.append("size:");
        sb.append(size);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(types == null) && !(types.isEmpty())) {
        sb.append("types:");
        sb.append(types);
        sb.append(",");
    }
    if (!(zones == null) && !(zones.isEmpty())) {
        sb.append("zones:");
        sb.append(zones);
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
  
  public A withSize(Integer size) {
    this.size = size;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withTypes(List<String> types) {
    if (types != null) {
        this.types = new ArrayList();
        for (String item : types) {
          this.addToTypes(item);
        }
    } else {
      this.types = null;
    }
    return (A) this;
  }
  
  public A withTypes(String... types) {
    if (this.types != null) {
        this.types.clear();
        _visitables.remove("types");
    }
    if (types != null) {
      for (String item : types) {
        this.addToTypes(item);
      }
    }
    return (A) this;
  }
  
  public A withZones(List<String> zones) {
    if (zones != null) {
        this.zones = new ArrayList();
        for (String item : zones) {
          this.addToZones(item);
        }
    } else {
      this.zones = null;
    }
    return (A) this;
  }
  
  public A withZones(String... zones) {
    if (this.zones != null) {
        this.zones.clear();
        _visitables.remove("zones");
    }
    if (zones != null) {
      for (String item : zones) {
        this.addToZones(item);
      }
    }
    return (A) this;
  }
  
}