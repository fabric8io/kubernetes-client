package io.fabric8.chaosmesh.v1alpha1;

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
public class RawIptablesFluent<A extends io.fabric8.chaosmesh.v1alpha1.RawIptablesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String device;
  private String direction;
  private List<String> ipsets = new ArrayList<String>();
  private String name;
  private String source;

  public RawIptablesFluent() {
  }
  
  public RawIptablesFluent(RawIptables instance) {
    this.copyInstance(instance);
  }

  public A addAllToIpsets(Collection<String> items) {
    if (this.ipsets == null) {
      this.ipsets = new ArrayList();
    }
    for (String item : items) {
      this.ipsets.add(item);
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
  
  public A addToIpsets(String... items) {
    if (this.ipsets == null) {
      this.ipsets = new ArrayList();
    }
    for (String item : items) {
      this.ipsets.add(item);
    }
    return (A) this;
  }
  
  public A addToIpsets(int index,String item) {
    if (this.ipsets == null) {
      this.ipsets = new ArrayList();
    }
    this.ipsets.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(RawIptables instance) {
    instance = instance != null ? instance : new RawIptables();
    if (instance != null) {
        this.withDevice(instance.getDevice());
        this.withDirection(instance.getDirection());
        this.withIpsets(instance.getIpsets());
        this.withName(instance.getName());
        this.withSource(instance.getSource());
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
    RawIptablesFluent that = (RawIptablesFluent) o;
    if (!(Objects.equals(device, that.device))) {
      return false;
    }
    if (!(Objects.equals(direction, that.direction))) {
      return false;
    }
    if (!(Objects.equals(ipsets, that.ipsets))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
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
  
  public String getDevice() {
    return this.device;
  }
  
  public String getDirection() {
    return this.direction;
  }
  
  public String getFirstIpset() {
    return this.ipsets.get(0);
  }
  
  public String getIpset(int index) {
    return this.ipsets.get(index);
  }
  
  public List<String> getIpsets() {
    return this.ipsets;
  }
  
  public String getLastIpset() {
    return this.ipsets.get(ipsets.size() - 1);
  }
  
  public String getMatchingIpset(Predicate<String> predicate) {
      for (String item : ipsets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDevice() {
    return this.device != null;
  }
  
  public boolean hasDirection() {
    return this.direction != null;
  }
  
  public boolean hasIpsets() {
    return this.ipsets != null && !(this.ipsets.isEmpty());
  }
  
  public boolean hasMatchingIpset(Predicate<String> predicate) {
      for (String item : ipsets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public int hashCode() {
    return Objects.hash(device, direction, ipsets, name, source, additionalProperties);
  }
  
  public A removeAllFromIpsets(Collection<String> items) {
    if (this.ipsets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipsets.remove(item);
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
  
  public A removeFromIpsets(String... items) {
    if (this.ipsets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ipsets.remove(item);
    }
    return (A) this;
  }
  
  public A setToIpsets(int index,String item) {
    if (this.ipsets == null) {
      this.ipsets = new ArrayList();
    }
    this.ipsets.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(device == null)) {
        sb.append("device:");
        sb.append(device);
        sb.append(",");
    }
    if (!(direction == null)) {
        sb.append("direction:");
        sb.append(direction);
        sb.append(",");
    }
    if (!(ipsets == null) && !(ipsets.isEmpty())) {
        sb.append("ipsets:");
        sb.append(ipsets);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
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
  
  public A withDevice(String device) {
    this.device = device;
    return (A) this;
  }
  
  public A withDirection(String direction) {
    this.direction = direction;
    return (A) this;
  }
  
  public A withIpsets(List<String> ipsets) {
    if (ipsets != null) {
        this.ipsets = new ArrayList();
        for (String item : ipsets) {
          this.addToIpsets(item);
        }
    } else {
      this.ipsets = null;
    }
    return (A) this;
  }
  
  public A withIpsets(String... ipsets) {
    if (this.ipsets != null) {
        this.ipsets.clear();
        _visitables.remove("ipsets");
    }
    if (ipsets != null) {
      for (String item : ipsets) {
        this.addToIpsets(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withSource(String source) {
    this.source = source;
    return (A) this;
  }
  
}