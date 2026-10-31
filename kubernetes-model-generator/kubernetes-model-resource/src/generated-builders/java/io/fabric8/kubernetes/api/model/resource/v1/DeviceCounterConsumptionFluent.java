package io.fabric8.kubernetes.api.model.resource.v1;

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
public class DeviceCounterConsumptionFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.DeviceCounterConsumptionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> compatibilityGroups = new ArrayList<String>();
  private String counterSet;
  private Map<String,Counter> counters;

  public DeviceCounterConsumptionFluent() {
  }
  
  public DeviceCounterConsumptionFluent(DeviceCounterConsumption instance) {
    this.copyInstance(instance);
  }

  public A addAllToCompatibilityGroups(Collection<String> items) {
    if (this.compatibilityGroups == null) {
      this.compatibilityGroups = new ArrayList();
    }
    for (String item : items) {
      this.compatibilityGroups.add(item);
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
  
  public A addToCompatibilityGroups(String... items) {
    if (this.compatibilityGroups == null) {
      this.compatibilityGroups = new ArrayList();
    }
    for (String item : items) {
      this.compatibilityGroups.add(item);
    }
    return (A) this;
  }
  
  public A addToCompatibilityGroups(int index,String item) {
    if (this.compatibilityGroups == null) {
      this.compatibilityGroups = new ArrayList();
    }
    this.compatibilityGroups.add(index, item);
    return (A) this;
  }
  
  public A addToCounters(Map<String,Counter> map) {
    if (this.counters == null && map != null) {
      this.counters = new LinkedHashMap();
    }
    if (map != null) {
      this.counters.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCounters(String key,Counter value) {
    if (this.counters == null && key != null && value != null) {
      this.counters = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.counters.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(DeviceCounterConsumption instance) {
    instance = instance != null ? instance : new DeviceCounterConsumption();
    if (instance != null) {
        this.withCompatibilityGroups(instance.getCompatibilityGroups());
        this.withCounterSet(instance.getCounterSet());
        this.withCounters(instance.getCounters());
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
    DeviceCounterConsumptionFluent that = (DeviceCounterConsumptionFluent) o;
    if (!(Objects.equals(compatibilityGroups, that.compatibilityGroups))) {
      return false;
    }
    if (!(Objects.equals(counterSet, that.counterSet))) {
      return false;
    }
    if (!(Objects.equals(counters, that.counters))) {
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
  
  public String getCompatibilityGroup(int index) {
    return this.compatibilityGroups.get(index);
  }
  
  public List<String> getCompatibilityGroups() {
    return this.compatibilityGroups;
  }
  
  public String getCounterSet() {
    return this.counterSet;
  }
  
  public Map<String,Counter> getCounters() {
    return this.counters;
  }
  
  public String getFirstCompatibilityGroup() {
    return this.compatibilityGroups.get(0);
  }
  
  public String getLastCompatibilityGroup() {
    return this.compatibilityGroups.get(compatibilityGroups.size() - 1);
  }
  
  public String getMatchingCompatibilityGroup(Predicate<String> predicate) {
      for (String item : compatibilityGroups) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCompatibilityGroups() {
    return this.compatibilityGroups != null && !(this.compatibilityGroups.isEmpty());
  }
  
  public boolean hasCounterSet() {
    return this.counterSet != null;
  }
  
  public boolean hasCounters() {
    return this.counters != null;
  }
  
  public boolean hasMatchingCompatibilityGroup(Predicate<String> predicate) {
      for (String item : compatibilityGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(compatibilityGroups, counterSet, counters, additionalProperties);
  }
  
  public A removeAllFromCompatibilityGroups(Collection<String> items) {
    if (this.compatibilityGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.compatibilityGroups.remove(item);
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
  
  public A removeFromCompatibilityGroups(String... items) {
    if (this.compatibilityGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.compatibilityGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromCounters(String key) {
    if (this.counters == null) {
      return (A) this;
    }
    if (key != null && this.counters != null) {
      this.counters.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCounters(Map<String,Counter> map) {
    if (this.counters == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.counters != null) {
          this.counters.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToCompatibilityGroups(int index,String item) {
    if (this.compatibilityGroups == null) {
      this.compatibilityGroups = new ArrayList();
    }
    this.compatibilityGroups.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(compatibilityGroups == null) && !(compatibilityGroups.isEmpty())) {
        sb.append("compatibilityGroups:");
        sb.append(compatibilityGroups);
        sb.append(",");
    }
    if (!(counterSet == null)) {
        sb.append("counterSet:");
        sb.append(counterSet);
        sb.append(",");
    }
    if (!(counters == null) && !(counters.isEmpty())) {
        sb.append("counters:");
        sb.append(counters);
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
  
  public A withCompatibilityGroups(List<String> compatibilityGroups) {
    if (compatibilityGroups != null) {
        this.compatibilityGroups = new ArrayList();
        for (String item : compatibilityGroups) {
          this.addToCompatibilityGroups(item);
        }
    } else {
      this.compatibilityGroups = null;
    }
    return (A) this;
  }
  
  public A withCompatibilityGroups(String... compatibilityGroups) {
    if (this.compatibilityGroups != null) {
        this.compatibilityGroups.clear();
        _visitables.remove("compatibilityGroups");
    }
    if (compatibilityGroups != null) {
      for (String item : compatibilityGroups) {
        this.addToCompatibilityGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withCounterSet(String counterSet) {
    this.counterSet = counterSet;
    return (A) this;
  }
  
  public <K,V>A withCounters(Map<String,Counter> counters) {
    if (counters == null) {
      this.counters = null;
    } else {
      this.counters = new LinkedHashMap(counters);
    }
    return (A) this;
  }
  
}