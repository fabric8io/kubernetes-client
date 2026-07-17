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
public class ZoneFluent<A extends io.fabric8.openshift.api.model.installer.powervs.v1.ZoneFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> sysTypes = new ArrayList<String>();

  public ZoneFluent() {
  }
  
  public ZoneFluent(Zone instance) {
    this.copyInstance(instance);
  }

  public A addAllToSysTypes(Collection<String> items) {
    if (this.sysTypes == null) {
      this.sysTypes = new ArrayList();
    }
    for (String item : items) {
      this.sysTypes.add(item);
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
  
  public A addToSysTypes(String... items) {
    if (this.sysTypes == null) {
      this.sysTypes = new ArrayList();
    }
    for (String item : items) {
      this.sysTypes.add(item);
    }
    return (A) this;
  }
  
  public A addToSysTypes(int index,String item) {
    if (this.sysTypes == null) {
      this.sysTypes = new ArrayList();
    }
    this.sysTypes.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Zone instance) {
    instance = instance != null ? instance : new Zone();
    if (instance != null) {
        this.withSysTypes(instance.getSysTypes());
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
    ZoneFluent that = (ZoneFluent) o;
    if (!(Objects.equals(sysTypes, that.sysTypes))) {
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
  
  public String getFirstSysType() {
    return this.sysTypes.get(0);
  }
  
  public String getLastSysType() {
    return this.sysTypes.get(sysTypes.size() - 1);
  }
  
  public String getMatchingSysType(Predicate<String> predicate) {
      for (String item : sysTypes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getSysType(int index) {
    return this.sysTypes.get(index);
  }
  
  public List<String> getSysTypes() {
    return this.sysTypes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingSysType(Predicate<String> predicate) {
      for (String item : sysTypes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSysTypes() {
    return this.sysTypes != null && !(this.sysTypes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(sysTypes, additionalProperties);
  }
  
  public A removeAllFromSysTypes(Collection<String> items) {
    if (this.sysTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.sysTypes.remove(item);
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
  
  public A removeFromSysTypes(String... items) {
    if (this.sysTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.sysTypes.remove(item);
    }
    return (A) this;
  }
  
  public A setToSysTypes(int index,String item) {
    if (this.sysTypes == null) {
      this.sysTypes = new ArrayList();
    }
    this.sysTypes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(sysTypes == null) && !(sysTypes.isEmpty())) {
        sb.append("sysTypes:");
        sb.append(sysTypes);
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
  
  public A withSysTypes(List<String> sysTypes) {
    if (sysTypes != null) {
        this.sysTypes = new ArrayList();
        for (String item : sysTypes) {
          this.addToSysTypes(item);
        }
    } else {
      this.sysTypes = null;
    }
    return (A) this;
  }
  
  public A withSysTypes(String... sysTypes) {
    if (this.sysTypes != null) {
        this.sysTypes.clear();
        _visitables.remove("sysTypes");
    }
    if (sysTypes != null) {
      for (String item : sysTypes) {
        this.addToSysTypes(item);
      }
    }
    return (A) this;
  }
  
}