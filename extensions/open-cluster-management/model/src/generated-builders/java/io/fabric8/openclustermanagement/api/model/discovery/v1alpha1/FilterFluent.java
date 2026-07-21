package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

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
public class FilterFluent<A extends io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.FilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer lastActive;
  private List<String> openShiftVersions = new ArrayList<String>();

  public FilterFluent() {
  }
  
  public FilterFluent(Filter instance) {
    this.copyInstance(instance);
  }

  public A addAllToOpenShiftVersions(Collection<String> items) {
    if (this.openShiftVersions == null) {
      this.openShiftVersions = new ArrayList();
    }
    for (String item : items) {
      this.openShiftVersions.add(item);
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
  
  public A addToOpenShiftVersions(String... items) {
    if (this.openShiftVersions == null) {
      this.openShiftVersions = new ArrayList();
    }
    for (String item : items) {
      this.openShiftVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToOpenShiftVersions(int index,String item) {
    if (this.openShiftVersions == null) {
      this.openShiftVersions = new ArrayList();
    }
    this.openShiftVersions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Filter instance) {
    instance = instance != null ? instance : new Filter();
    if (instance != null) {
        this.withLastActive(instance.getLastActive());
        this.withOpenShiftVersions(instance.getOpenShiftVersions());
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
    FilterFluent that = (FilterFluent) o;
    if (!(Objects.equals(lastActive, that.lastActive))) {
      return false;
    }
    if (!(Objects.equals(openShiftVersions, that.openShiftVersions))) {
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
  
  public String getFirstOpenShiftVersion() {
    return this.openShiftVersions.get(0);
  }
  
  public Integer getLastActive() {
    return this.lastActive;
  }
  
  public String getLastOpenShiftVersion() {
    return this.openShiftVersions.get(openShiftVersions.size() - 1);
  }
  
  public String getMatchingOpenShiftVersion(Predicate<String> predicate) {
      for (String item : openShiftVersions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOpenShiftVersion(int index) {
    return this.openShiftVersions.get(index);
  }
  
  public List<String> getOpenShiftVersions() {
    return this.openShiftVersions;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLastActive() {
    return this.lastActive != null;
  }
  
  public boolean hasMatchingOpenShiftVersion(Predicate<String> predicate) {
      for (String item : openShiftVersions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOpenShiftVersions() {
    return this.openShiftVersions != null && !(this.openShiftVersions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(lastActive, openShiftVersions, additionalProperties);
  }
  
  public A removeAllFromOpenShiftVersions(Collection<String> items) {
    if (this.openShiftVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.openShiftVersions.remove(item);
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
  
  public A removeFromOpenShiftVersions(String... items) {
    if (this.openShiftVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.openShiftVersions.remove(item);
    }
    return (A) this;
  }
  
  public A setToOpenShiftVersions(int index,String item) {
    if (this.openShiftVersions == null) {
      this.openShiftVersions = new ArrayList();
    }
    this.openShiftVersions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(lastActive == null)) {
        sb.append("lastActive:");
        sb.append(lastActive);
        sb.append(",");
    }
    if (!(openShiftVersions == null) && !(openShiftVersions.isEmpty())) {
        sb.append("openShiftVersions:");
        sb.append(openShiftVersions);
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
  
  public A withLastActive(Integer lastActive) {
    this.lastActive = lastActive;
    return (A) this;
  }
  
  public A withOpenShiftVersions(List<String> openShiftVersions) {
    if (openShiftVersions != null) {
        this.openShiftVersions = new ArrayList();
        for (String item : openShiftVersions) {
          this.addToOpenShiftVersions(item);
        }
    } else {
      this.openShiftVersions = null;
    }
    return (A) this;
  }
  
  public A withOpenShiftVersions(String... openShiftVersions) {
    if (this.openShiftVersions != null) {
        this.openShiftVersions.clear();
        _visitables.remove("openShiftVersions");
    }
    if (openShiftVersions != null) {
      for (String item : openShiftVersions) {
        this.addToOpenShiftVersions(item);
      }
    }
    return (A) this;
  }
  
}