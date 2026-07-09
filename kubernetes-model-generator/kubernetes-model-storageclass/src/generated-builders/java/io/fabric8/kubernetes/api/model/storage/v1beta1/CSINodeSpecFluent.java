package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CSINodeSpecFluent<A extends io.fabric8.kubernetes.api.model.storage.v1beta1.CSINodeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<CSINodeDriverBuilder> drivers = new ArrayList<CSINodeDriverBuilder>();

  public CSINodeSpecFluent() {
  }
  
  public CSINodeSpecFluent(CSINodeSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToDrivers(Collection<CSINodeDriver> items) {
    if (this.drivers == null) {
      this.drivers = new ArrayList();
    }
    for (CSINodeDriver item : items) {
        CSINodeDriverBuilder builder = new CSINodeDriverBuilder(item);
        _visitables.get("drivers").add(builder);
        this.drivers.add(builder);
    }
    return (A) this;
  }
  
  public DriversNested<A> addNewDriver() {
    return new DriversNested(-1, null);
  }
  
  public DriversNested<A> addNewDriverLike(CSINodeDriver item) {
    return new DriversNested(-1, item);
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
  
  public A addToDrivers(CSINodeDriver... items) {
    if (this.drivers == null) {
      this.drivers = new ArrayList();
    }
    for (CSINodeDriver item : items) {
        CSINodeDriverBuilder builder = new CSINodeDriverBuilder(item);
        _visitables.get("drivers").add(builder);
        this.drivers.add(builder);
    }
    return (A) this;
  }
  
  public A addToDrivers(int index,CSINodeDriver item) {
    if (this.drivers == null) {
      this.drivers = new ArrayList();
    }
    CSINodeDriverBuilder builder = new CSINodeDriverBuilder(item);
    if (index < 0 || index >= drivers.size()) {
        _visitables.get("drivers").add(builder);
        drivers.add(builder);
    } else {
        _visitables.get("drivers").add(builder);
        drivers.add(index, builder);
    }
    return (A) this;
  }
  
  public CSINodeDriver buildDriver(int index) {
    return this.drivers.get(index).build();
  }
  
  public List<CSINodeDriver> buildDrivers() {
    return this.drivers != null ? build(drivers) : null;
  }
  
  public CSINodeDriver buildFirstDriver() {
    return this.drivers.get(0).build();
  }
  
  public CSINodeDriver buildLastDriver() {
    return this.drivers.get(drivers.size() - 1).build();
  }
  
  public CSINodeDriver buildMatchingDriver(Predicate<CSINodeDriverBuilder> predicate) {
      for (CSINodeDriverBuilder item : drivers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CSINodeSpec instance) {
    instance = instance != null ? instance : new CSINodeSpec();
    if (instance != null) {
        this.withDrivers(instance.getDrivers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DriversNested<A> editDriver(int index) {
    if (drivers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "drivers"));
    }
    return this.setNewDriverLike(index, this.buildDriver(index));
  }
  
  public DriversNested<A> editFirstDriver() {
    if (drivers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "drivers"));
    }
    return this.setNewDriverLike(0, this.buildDriver(0));
  }
  
  public DriversNested<A> editLastDriver() {
    int index = drivers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "drivers"));
    }
    return this.setNewDriverLike(index, this.buildDriver(index));
  }
  
  public DriversNested<A> editMatchingDriver(Predicate<CSINodeDriverBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < drivers.size();i++) {
      if (predicate.test(drivers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "drivers"));
    }
    return this.setNewDriverLike(index, this.buildDriver(index));
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
    CSINodeSpecFluent that = (CSINodeSpecFluent) o;
    if (!(Objects.equals(drivers, that.drivers))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDrivers() {
    return this.drivers != null && !(this.drivers.isEmpty());
  }
  
  public boolean hasMatchingDriver(Predicate<CSINodeDriverBuilder> predicate) {
      for (CSINodeDriverBuilder item : drivers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(drivers, additionalProperties);
  }
  
  public A removeAllFromDrivers(Collection<CSINodeDriver> items) {
    if (this.drivers == null) {
      return (A) this;
    }
    for (CSINodeDriver item : items) {
        CSINodeDriverBuilder builder = new CSINodeDriverBuilder(item);
        _visitables.get("drivers").remove(builder);
        this.drivers.remove(builder);
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
  
  public A removeFromDrivers(CSINodeDriver... items) {
    if (this.drivers == null) {
      return (A) this;
    }
    for (CSINodeDriver item : items) {
        CSINodeDriverBuilder builder = new CSINodeDriverBuilder(item);
        _visitables.get("drivers").remove(builder);
        this.drivers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDrivers(Predicate<CSINodeDriverBuilder> predicate) {
    if (drivers == null) {
      return (A) this;
    }
    Iterator<CSINodeDriverBuilder> each = drivers.iterator();
    List visitables = _visitables.get("drivers");
    while (each.hasNext()) {
        CSINodeDriverBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DriversNested<A> setNewDriverLike(int index,CSINodeDriver item) {
    return new DriversNested(index, item);
  }
  
  public A setToDrivers(int index,CSINodeDriver item) {
    if (this.drivers == null) {
      this.drivers = new ArrayList();
    }
    CSINodeDriverBuilder builder = new CSINodeDriverBuilder(item);
    if (index < 0 || index >= drivers.size()) {
        _visitables.get("drivers").add(builder);
        drivers.add(builder);
    } else {
        _visitables.get("drivers").add(builder);
        drivers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(drivers == null) && !(drivers.isEmpty())) {
        sb.append("drivers:");
        sb.append(drivers);
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
  
  public A withDrivers(List<CSINodeDriver> drivers) {
    if (this.drivers != null) {
      this._visitables.get("drivers").clear();
    }
    if (drivers != null) {
        this.drivers = new ArrayList();
        for (CSINodeDriver item : drivers) {
          this.addToDrivers(item);
        }
    } else {
      this.drivers = null;
    }
    return (A) this;
  }
  
  public A withDrivers(CSINodeDriver... drivers) {
    if (this.drivers != null) {
        this.drivers.clear();
        _visitables.remove("drivers");
    }
    if (drivers != null) {
      for (CSINodeDriver item : drivers) {
        this.addToDrivers(item);
      }
    }
    return (A) this;
  }
  public class DriversNested<N> extends CSINodeDriverFluent<DriversNested<N>> implements Nested<N>{
  
    CSINodeDriverBuilder builder;
    int index;
  
    DriversNested(int index,CSINodeDriver item) {
      this.index = index;
      this.builder = new CSINodeDriverBuilder(this, item);
    }
  
    public N and() {
      return (N) CSINodeSpecFluent.this.setToDrivers(index, builder.build());
    }
    
    public N endDriver() {
      return and();
    }
    
  }
}