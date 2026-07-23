package io.fabric8.kubernetes.api.model.discovery.v1beta1;

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
public class EndpointHintsFluent<A extends io.fabric8.kubernetes.api.model.discovery.v1beta1.EndpointHintsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ForZoneBuilder> forZones = new ArrayList<ForZoneBuilder>();

  public EndpointHintsFluent() {
  }
  
  public EndpointHintsFluent(EndpointHints instance) {
    this.copyInstance(instance);
  }

  public A addAllToForZones(Collection<ForZone> items) {
    if (this.forZones == null) {
      this.forZones = new ArrayList();
    }
    for (ForZone item : items) {
        ForZoneBuilder builder = new ForZoneBuilder(item);
        _visitables.get("forZones").add(builder);
        this.forZones.add(builder);
    }
    return (A) this;
  }
  
  public ForZonesNested<A> addNewForZone() {
    return new ForZonesNested(-1, null);
  }
  
  public A addNewForZone(String name) {
    return (A) this.addToForZones(new ForZone(name));
  }
  
  public ForZonesNested<A> addNewForZoneLike(ForZone item) {
    return new ForZonesNested(-1, item);
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
  
  public A addToForZones(ForZone... items) {
    if (this.forZones == null) {
      this.forZones = new ArrayList();
    }
    for (ForZone item : items) {
        ForZoneBuilder builder = new ForZoneBuilder(item);
        _visitables.get("forZones").add(builder);
        this.forZones.add(builder);
    }
    return (A) this;
  }
  
  public A addToForZones(int index,ForZone item) {
    if (this.forZones == null) {
      this.forZones = new ArrayList();
    }
    ForZoneBuilder builder = new ForZoneBuilder(item);
    if (index < 0 || index >= forZones.size()) {
        _visitables.get("forZones").add(builder);
        forZones.add(builder);
    } else {
        _visitables.get("forZones").add(builder);
        forZones.add(index, builder);
    }
    return (A) this;
  }
  
  public ForZone buildFirstForZone() {
    return this.forZones.get(0).build();
  }
  
  public ForZone buildForZone(int index) {
    return this.forZones.get(index).build();
  }
  
  public List<ForZone> buildForZones() {
    return this.forZones != null ? build(forZones) : null;
  }
  
  public ForZone buildLastForZone() {
    return this.forZones.get(forZones.size() - 1).build();
  }
  
  public ForZone buildMatchingForZone(Predicate<ForZoneBuilder> predicate) {
      for (ForZoneBuilder item : forZones) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(EndpointHints instance) {
    instance = instance != null ? instance : new EndpointHints();
    if (instance != null) {
        this.withForZones(instance.getForZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ForZonesNested<A> editFirstForZone() {
    if (forZones.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "forZones"));
    }
    return this.setNewForZoneLike(0, this.buildForZone(0));
  }
  
  public ForZonesNested<A> editForZone(int index) {
    if (forZones.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "forZones"));
    }
    return this.setNewForZoneLike(index, this.buildForZone(index));
  }
  
  public ForZonesNested<A> editLastForZone() {
    int index = forZones.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "forZones"));
    }
    return this.setNewForZoneLike(index, this.buildForZone(index));
  }
  
  public ForZonesNested<A> editMatchingForZone(Predicate<ForZoneBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < forZones.size();i++) {
      if (predicate.test(forZones.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "forZones"));
    }
    return this.setNewForZoneLike(index, this.buildForZone(index));
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
    EndpointHintsFluent that = (EndpointHintsFluent) o;
    if (!(Objects.equals(forZones, that.forZones))) {
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
  
  public boolean hasForZones() {
    return this.forZones != null && !(this.forZones.isEmpty());
  }
  
  public boolean hasMatchingForZone(Predicate<ForZoneBuilder> predicate) {
      for (ForZoneBuilder item : forZones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(forZones, additionalProperties);
  }
  
  public A removeAllFromForZones(Collection<ForZone> items) {
    if (this.forZones == null) {
      return (A) this;
    }
    for (ForZone item : items) {
        ForZoneBuilder builder = new ForZoneBuilder(item);
        _visitables.get("forZones").remove(builder);
        this.forZones.remove(builder);
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
  
  public A removeFromForZones(ForZone... items) {
    if (this.forZones == null) {
      return (A) this;
    }
    for (ForZone item : items) {
        ForZoneBuilder builder = new ForZoneBuilder(item);
        _visitables.get("forZones").remove(builder);
        this.forZones.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromForZones(Predicate<ForZoneBuilder> predicate) {
    if (forZones == null) {
      return (A) this;
    }
    Iterator<ForZoneBuilder> each = forZones.iterator();
    List visitables = _visitables.get("forZones");
    while (each.hasNext()) {
        ForZoneBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ForZonesNested<A> setNewForZoneLike(int index,ForZone item) {
    return new ForZonesNested(index, item);
  }
  
  public A setToForZones(int index,ForZone item) {
    if (this.forZones == null) {
      this.forZones = new ArrayList();
    }
    ForZoneBuilder builder = new ForZoneBuilder(item);
    if (index < 0 || index >= forZones.size()) {
        _visitables.get("forZones").add(builder);
        forZones.add(builder);
    } else {
        _visitables.get("forZones").add(builder);
        forZones.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(forZones == null) && !(forZones.isEmpty())) {
        sb.append("forZones:");
        sb.append(forZones);
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
  
  public A withForZones(List<ForZone> forZones) {
    if (this.forZones != null) {
      this._visitables.get("forZones").clear();
    }
    if (forZones != null) {
        this.forZones = new ArrayList();
        for (ForZone item : forZones) {
          this.addToForZones(item);
        }
    } else {
      this.forZones = null;
    }
    return (A) this;
  }
  
  public A withForZones(ForZone... forZones) {
    if (this.forZones != null) {
        this.forZones.clear();
        _visitables.remove("forZones");
    }
    if (forZones != null) {
      for (ForZone item : forZones) {
        this.addToForZones(item);
      }
    }
    return (A) this;
  }
  public class ForZonesNested<N> extends ForZoneFluent<ForZonesNested<N>> implements Nested<N>{
  
    ForZoneBuilder builder;
    int index;
  
    ForZonesNested(int index,ForZone item) {
      this.index = index;
      this.builder = new ForZoneBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointHintsFluent.this.setToForZones(index, builder.build());
    }
    
    public N endForZone() {
      return and();
    }
    
  }
}