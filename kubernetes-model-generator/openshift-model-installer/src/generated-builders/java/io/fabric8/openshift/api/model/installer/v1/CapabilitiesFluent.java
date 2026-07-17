package io.fabric8.openshift.api.model.installer.v1;

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
public class CapabilitiesFluent<A extends io.fabric8.openshift.api.model.installer.v1.CapabilitiesFluent<A>> extends BaseFluent<A>{

  private List<String> additionalEnabledCapabilities = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private String baselineCapabilitySet;

  public CapabilitiesFluent() {
  }
  
  public CapabilitiesFluent(Capabilities instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalEnabledCapabilities(Collection<String> items) {
    if (this.additionalEnabledCapabilities == null) {
      this.additionalEnabledCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.additionalEnabledCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalEnabledCapabilities(String... items) {
    if (this.additionalEnabledCapabilities == null) {
      this.additionalEnabledCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.additionalEnabledCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalEnabledCapabilities(int index,String item) {
    if (this.additionalEnabledCapabilities == null) {
      this.additionalEnabledCapabilities = new ArrayList();
    }
    this.additionalEnabledCapabilities.add(index, item);
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
  
  protected void copyInstance(Capabilities instance) {
    instance = instance != null ? instance : new Capabilities();
    if (instance != null) {
        this.withAdditionalEnabledCapabilities(instance.getAdditionalEnabledCapabilities());
        this.withBaselineCapabilitySet(instance.getBaselineCapabilitySet());
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
    CapabilitiesFluent that = (CapabilitiesFluent) o;
    if (!(Objects.equals(additionalEnabledCapabilities, that.additionalEnabledCapabilities))) {
      return false;
    }
    if (!(Objects.equals(baselineCapabilitySet, that.baselineCapabilitySet))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public List<String> getAdditionalEnabledCapabilities() {
    return this.additionalEnabledCapabilities;
  }
  
  public String getAdditionalEnabledCapability(int index) {
    return this.additionalEnabledCapabilities.get(index);
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getBaselineCapabilitySet() {
    return this.baselineCapabilitySet;
  }
  
  public String getFirstAdditionalEnabledCapability() {
    return this.additionalEnabledCapabilities.get(0);
  }
  
  public String getLastAdditionalEnabledCapability() {
    return this.additionalEnabledCapabilities.get(additionalEnabledCapabilities.size() - 1);
  }
  
  public String getMatchingAdditionalEnabledCapability(Predicate<String> predicate) {
      for (String item : additionalEnabledCapabilities) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalEnabledCapabilities() {
    return this.additionalEnabledCapabilities != null && !(this.additionalEnabledCapabilities.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaselineCapabilitySet() {
    return this.baselineCapabilitySet != null;
  }
  
  public boolean hasMatchingAdditionalEnabledCapability(Predicate<String> predicate) {
      for (String item : additionalEnabledCapabilities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(additionalEnabledCapabilities, baselineCapabilitySet, additionalProperties);
  }
  
  public A removeAllFromAdditionalEnabledCapabilities(Collection<String> items) {
    if (this.additionalEnabledCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalEnabledCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalEnabledCapabilities(String... items) {
    if (this.additionalEnabledCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalEnabledCapabilities.remove(item);
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
  
  public A setToAdditionalEnabledCapabilities(int index,String item) {
    if (this.additionalEnabledCapabilities == null) {
      this.additionalEnabledCapabilities = new ArrayList();
    }
    this.additionalEnabledCapabilities.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalEnabledCapabilities == null) && !(additionalEnabledCapabilities.isEmpty())) {
        sb.append("additionalEnabledCapabilities:");
        sb.append(additionalEnabledCapabilities);
        sb.append(",");
    }
    if (!(baselineCapabilitySet == null)) {
        sb.append("baselineCapabilitySet:");
        sb.append(baselineCapabilitySet);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalEnabledCapabilities(List<String> additionalEnabledCapabilities) {
    if (additionalEnabledCapabilities != null) {
        this.additionalEnabledCapabilities = new ArrayList();
        for (String item : additionalEnabledCapabilities) {
          this.addToAdditionalEnabledCapabilities(item);
        }
    } else {
      this.additionalEnabledCapabilities = null;
    }
    return (A) this;
  }
  
  public A withAdditionalEnabledCapabilities(String... additionalEnabledCapabilities) {
    if (this.additionalEnabledCapabilities != null) {
        this.additionalEnabledCapabilities.clear();
        _visitables.remove("additionalEnabledCapabilities");
    }
    if (additionalEnabledCapabilities != null) {
      for (String item : additionalEnabledCapabilities) {
        this.addToAdditionalEnabledCapabilities(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBaselineCapabilitySet(String baselineCapabilitySet) {
    this.baselineCapabilitySet = baselineCapabilitySet;
    return (A) this;
  }
  
}