package io.fabric8.openshift.api.model.installer.powervs.v1;

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
public class RegionFluent<A extends io.fabric8.openshift.api.model.installer.powervs.v1.RegionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cOSRegion;
  private String description;
  private String vPCRegion;
  private List<String> vPCZones = new ArrayList<String>();
  private Map<String,Zone> zones;

  public RegionFluent() {
  }
  
  public RegionFluent(Region instance) {
    this.copyInstance(instance);
  }

  public A addAllToVPCZones(Collection<String> items) {
    if (this.vPCZones == null) {
      this.vPCZones = new ArrayList();
    }
    for (String item : items) {
      this.vPCZones.add(item);
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
  
  public A addToVPCZones(String... items) {
    if (this.vPCZones == null) {
      this.vPCZones = new ArrayList();
    }
    for (String item : items) {
      this.vPCZones.add(item);
    }
    return (A) this;
  }
  
  public A addToVPCZones(int index,String item) {
    if (this.vPCZones == null) {
      this.vPCZones = new ArrayList();
    }
    this.vPCZones.add(index, item);
    return (A) this;
  }
  
  public A addToZones(Map<String,Zone> map) {
    if (this.zones == null && map != null) {
      this.zones = new LinkedHashMap();
    }
    if (map != null) {
      this.zones.putAll(map);
    }
    return (A) this;
  }
  
  public A addToZones(String key,Zone value) {
    if (this.zones == null && key != null && value != null) {
      this.zones = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.zones.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(Region instance) {
    instance = instance != null ? instance : new Region();
    if (instance != null) {
        this.withCOSRegion(instance.getCOSRegion());
        this.withDescription(instance.getDescription());
        this.withVPCRegion(instance.getVPCRegion());
        this.withVPCZones(instance.getVPCZones());
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
    RegionFluent that = (RegionFluent) o;
    if (!(Objects.equals(cOSRegion, that.cOSRegion))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(vPCRegion, that.vPCRegion))) {
      return false;
    }
    if (!(Objects.equals(vPCZones, that.vPCZones))) {
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
  
  public String getCOSRegion() {
    return this.cOSRegion;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getFirstVPCZone() {
    return this.vPCZones.get(0);
  }
  
  public String getLastVPCZone() {
    return this.vPCZones.get(vPCZones.size() - 1);
  }
  
  public String getMatchingVPCZone(Predicate<String> predicate) {
      for (String item : vPCZones) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getVPCRegion() {
    return this.vPCRegion;
  }
  
  public String getVPCZone(int index) {
    return this.vPCZones.get(index);
  }
  
  public List<String> getVPCZones() {
    return this.vPCZones;
  }
  
  public Map<String,Zone> getZones() {
    return this.zones;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCOSRegion() {
    return this.cOSRegion != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasMatchingVPCZone(Predicate<String> predicate) {
      for (String item : vPCZones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasVPCRegion() {
    return this.vPCRegion != null;
  }
  
  public boolean hasVPCZones() {
    return this.vPCZones != null && !(this.vPCZones.isEmpty());
  }
  
  public boolean hasZones() {
    return this.zones != null;
  }
  
  public int hashCode() {
    return Objects.hash(cOSRegion, description, vPCRegion, vPCZones, zones, additionalProperties);
  }
  
  public A removeAllFromVPCZones(Collection<String> items) {
    if (this.vPCZones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.vPCZones.remove(item);
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
  
  public A removeFromVPCZones(String... items) {
    if (this.vPCZones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.vPCZones.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromZones(String key) {
    if (this.zones == null) {
      return (A) this;
    }
    if (key != null && this.zones != null) {
      this.zones.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromZones(Map<String,Zone> map) {
    if (this.zones == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.zones != null) {
          this.zones.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToVPCZones(int index,String item) {
    if (this.vPCZones == null) {
      this.vPCZones = new ArrayList();
    }
    this.vPCZones.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cOSRegion == null)) {
        sb.append("cOSRegion:");
        sb.append(cOSRegion);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(vPCRegion == null)) {
        sb.append("vPCRegion:");
        sb.append(vPCRegion);
        sb.append(",");
    }
    if (!(vPCZones == null) && !(vPCZones.isEmpty())) {
        sb.append("vPCZones:");
        sb.append(vPCZones);
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
  
  public A withCOSRegion(String cOSRegion) {
    this.cOSRegion = cOSRegion;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withVPCRegion(String vPCRegion) {
    this.vPCRegion = vPCRegion;
    return (A) this;
  }
  
  public A withVPCZones(List<String> vPCZones) {
    if (vPCZones != null) {
        this.vPCZones = new ArrayList();
        for (String item : vPCZones) {
          this.addToVPCZones(item);
        }
    } else {
      this.vPCZones = null;
    }
    return (A) this;
  }
  
  public A withVPCZones(String... vPCZones) {
    if (this.vPCZones != null) {
        this.vPCZones.clear();
        _visitables.remove("vPCZones");
    }
    if (vPCZones != null) {
      for (String item : vPCZones) {
        this.addToVPCZones(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withZones(Map<String,Zone> zones) {
    if (zones == null) {
      this.zones = null;
    } else {
      this.zones = new LinkedHashMap(zones);
    }
    return (A) this;
  }
  
}