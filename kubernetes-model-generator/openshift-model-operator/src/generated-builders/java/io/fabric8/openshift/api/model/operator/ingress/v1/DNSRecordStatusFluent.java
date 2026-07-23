package io.fabric8.openshift.api.model.operator.ingress.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class DNSRecordStatusFluent<A extends io.fabric8.openshift.api.model.operator.ingress.v1.DNSRecordStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long observedGeneration;
  private ArrayList<DNSZoneStatusBuilder> zones = new ArrayList<DNSZoneStatusBuilder>();

  public DNSRecordStatusFluent() {
  }
  
  public DNSRecordStatusFluent(DNSRecordStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToZones(Collection<DNSZoneStatus> items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (DNSZoneStatus item : items) {
        DNSZoneStatusBuilder builder = new DNSZoneStatusBuilder(item);
        _visitables.get("zones").add(builder);
        this.zones.add(builder);
    }
    return (A) this;
  }
  
  public ZonesNested<A> addNewZone() {
    return new ZonesNested(-1, null);
  }
  
  public ZonesNested<A> addNewZoneLike(DNSZoneStatus item) {
    return new ZonesNested(-1, item);
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
  
  public A addToZones(DNSZoneStatus... items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (DNSZoneStatus item : items) {
        DNSZoneStatusBuilder builder = new DNSZoneStatusBuilder(item);
        _visitables.get("zones").add(builder);
        this.zones.add(builder);
    }
    return (A) this;
  }
  
  public A addToZones(int index,DNSZoneStatus item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    DNSZoneStatusBuilder builder = new DNSZoneStatusBuilder(item);
    if (index < 0 || index >= zones.size()) {
        _visitables.get("zones").add(builder);
        zones.add(builder);
    } else {
        _visitables.get("zones").add(builder);
        zones.add(index, builder);
    }
    return (A) this;
  }
  
  public DNSZoneStatus buildFirstZone() {
    return this.zones.get(0).build();
  }
  
  public DNSZoneStatus buildLastZone() {
    return this.zones.get(zones.size() - 1).build();
  }
  
  public DNSZoneStatus buildMatchingZone(Predicate<DNSZoneStatusBuilder> predicate) {
      for (DNSZoneStatusBuilder item : zones) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DNSZoneStatus buildZone(int index) {
    return this.zones.get(index).build();
  }
  
  public List<DNSZoneStatus> buildZones() {
    return this.zones != null ? build(zones) : null;
  }
  
  protected void copyInstance(DNSRecordStatus instance) {
    instance = instance != null ? instance : new DNSRecordStatus();
    if (instance != null) {
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withZones(instance.getZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ZonesNested<A> editFirstZone() {
    if (zones.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "zones"));
    }
    return this.setNewZoneLike(0, this.buildZone(0));
  }
  
  public ZonesNested<A> editLastZone() {
    int index = zones.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "zones"));
    }
    return this.setNewZoneLike(index, this.buildZone(index));
  }
  
  public ZonesNested<A> editMatchingZone(Predicate<DNSZoneStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < zones.size();i++) {
      if (predicate.test(zones.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "zones"));
    }
    return this.setNewZoneLike(index, this.buildZone(index));
  }
  
  public ZonesNested<A> editZone(int index) {
    if (zones.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "zones"));
    }
    return this.setNewZoneLike(index, this.buildZone(index));
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
    DNSRecordStatusFluent that = (DNSRecordStatusFluent) o;
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
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
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingZone(Predicate<DNSZoneStatusBuilder> predicate) {
      for (DNSZoneStatusBuilder item : zones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(observedGeneration, zones, additionalProperties);
  }
  
  public A removeAllFromZones(Collection<DNSZoneStatus> items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (DNSZoneStatus item : items) {
        DNSZoneStatusBuilder builder = new DNSZoneStatusBuilder(item);
        _visitables.get("zones").remove(builder);
        this.zones.remove(builder);
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
  
  public A removeFromZones(DNSZoneStatus... items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (DNSZoneStatus item : items) {
        DNSZoneStatusBuilder builder = new DNSZoneStatusBuilder(item);
        _visitables.get("zones").remove(builder);
        this.zones.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromZones(Predicate<DNSZoneStatusBuilder> predicate) {
    if (zones == null) {
      return (A) this;
    }
    Iterator<DNSZoneStatusBuilder> each = zones.iterator();
    List visitables = _visitables.get("zones");
    while (each.hasNext()) {
        DNSZoneStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ZonesNested<A> setNewZoneLike(int index,DNSZoneStatus item) {
    return new ZonesNested(index, item);
  }
  
  public A setToZones(int index,DNSZoneStatus item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    DNSZoneStatusBuilder builder = new DNSZoneStatusBuilder(item);
    if (index < 0 || index >= zones.size()) {
        _visitables.get("zones").add(builder);
        zones.add(builder);
    } else {
        _visitables.get("zones").add(builder);
        zones.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
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
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withZones(List<DNSZoneStatus> zones) {
    if (this.zones != null) {
      this._visitables.get("zones").clear();
    }
    if (zones != null) {
        this.zones = new ArrayList();
        for (DNSZoneStatus item : zones) {
          this.addToZones(item);
        }
    } else {
      this.zones = null;
    }
    return (A) this;
  }
  
  public A withZones(DNSZoneStatus... zones) {
    if (this.zones != null) {
        this.zones.clear();
        _visitables.remove("zones");
    }
    if (zones != null) {
      for (DNSZoneStatus item : zones) {
        this.addToZones(item);
      }
    }
    return (A) this;
  }
  public class ZonesNested<N> extends DNSZoneStatusFluent<ZonesNested<N>> implements Nested<N>{
  
    DNSZoneStatusBuilder builder;
    int index;
  
    ZonesNested(int index,DNSZoneStatus item) {
      this.index = index;
      this.builder = new DNSZoneStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSRecordStatusFluent.this.setToZones(index, builder.build());
    }
    
    public N endZone() {
      return and();
    }
    
  }
}