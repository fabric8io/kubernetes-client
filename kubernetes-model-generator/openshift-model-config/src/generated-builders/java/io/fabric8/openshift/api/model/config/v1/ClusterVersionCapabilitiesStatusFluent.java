package io.fabric8.openshift.api.model.config.v1;

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
public class ClusterVersionCapabilitiesStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.ClusterVersionCapabilitiesStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> enabledCapabilities = new ArrayList<String>();
  private List<String> knownCapabilities = new ArrayList<String>();

  public ClusterVersionCapabilitiesStatusFluent() {
  }
  
  public ClusterVersionCapabilitiesStatusFluent(ClusterVersionCapabilitiesStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToEnabledCapabilities(Collection<String> items) {
    if (this.enabledCapabilities == null) {
      this.enabledCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.enabledCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addAllToKnownCapabilities(Collection<String> items) {
    if (this.knownCapabilities == null) {
      this.knownCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.knownCapabilities.add(item);
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
  
  public A addToEnabledCapabilities(String... items) {
    if (this.enabledCapabilities == null) {
      this.enabledCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.enabledCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addToEnabledCapabilities(int index,String item) {
    if (this.enabledCapabilities == null) {
      this.enabledCapabilities = new ArrayList();
    }
    this.enabledCapabilities.add(index, item);
    return (A) this;
  }
  
  public A addToKnownCapabilities(String... items) {
    if (this.knownCapabilities == null) {
      this.knownCapabilities = new ArrayList();
    }
    for (String item : items) {
      this.knownCapabilities.add(item);
    }
    return (A) this;
  }
  
  public A addToKnownCapabilities(int index,String item) {
    if (this.knownCapabilities == null) {
      this.knownCapabilities = new ArrayList();
    }
    this.knownCapabilities.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ClusterVersionCapabilitiesStatus instance) {
    instance = instance != null ? instance : new ClusterVersionCapabilitiesStatus();
    if (instance != null) {
        this.withEnabledCapabilities(instance.getEnabledCapabilities());
        this.withKnownCapabilities(instance.getKnownCapabilities());
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
    ClusterVersionCapabilitiesStatusFluent that = (ClusterVersionCapabilitiesStatusFluent) o;
    if (!(Objects.equals(enabledCapabilities, that.enabledCapabilities))) {
      return false;
    }
    if (!(Objects.equals(knownCapabilities, that.knownCapabilities))) {
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
  
  public List<String> getEnabledCapabilities() {
    return this.enabledCapabilities;
  }
  
  public String getEnabledCapability(int index) {
    return this.enabledCapabilities.get(index);
  }
  
  public String getFirstEnabledCapability() {
    return this.enabledCapabilities.get(0);
  }
  
  public String getFirstKnownCapability() {
    return this.knownCapabilities.get(0);
  }
  
  public List<String> getKnownCapabilities() {
    return this.knownCapabilities;
  }
  
  public String getKnownCapability(int index) {
    return this.knownCapabilities.get(index);
  }
  
  public String getLastEnabledCapability() {
    return this.enabledCapabilities.get(enabledCapabilities.size() - 1);
  }
  
  public String getLastKnownCapability() {
    return this.knownCapabilities.get(knownCapabilities.size() - 1);
  }
  
  public String getMatchingEnabledCapability(Predicate<String> predicate) {
      for (String item : enabledCapabilities) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingKnownCapability(Predicate<String> predicate) {
      for (String item : knownCapabilities) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnabledCapabilities() {
    return this.enabledCapabilities != null && !(this.enabledCapabilities.isEmpty());
  }
  
  public boolean hasKnownCapabilities() {
    return this.knownCapabilities != null && !(this.knownCapabilities.isEmpty());
  }
  
  public boolean hasMatchingEnabledCapability(Predicate<String> predicate) {
      for (String item : enabledCapabilities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingKnownCapability(Predicate<String> predicate) {
      for (String item : knownCapabilities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(enabledCapabilities, knownCapabilities, additionalProperties);
  }
  
  public A removeAllFromEnabledCapabilities(Collection<String> items) {
    if (this.enabledCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.enabledCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromKnownCapabilities(Collection<String> items) {
    if (this.knownCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.knownCapabilities.remove(item);
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
  
  public A removeFromEnabledCapabilities(String... items) {
    if (this.enabledCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.enabledCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromKnownCapabilities(String... items) {
    if (this.knownCapabilities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.knownCapabilities.remove(item);
    }
    return (A) this;
  }
  
  public A setToEnabledCapabilities(int index,String item) {
    if (this.enabledCapabilities == null) {
      this.enabledCapabilities = new ArrayList();
    }
    this.enabledCapabilities.set(index, item);
    return (A) this;
  }
  
  public A setToKnownCapabilities(int index,String item) {
    if (this.knownCapabilities == null) {
      this.knownCapabilities = new ArrayList();
    }
    this.knownCapabilities.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(enabledCapabilities == null) && !(enabledCapabilities.isEmpty())) {
        sb.append("enabledCapabilities:");
        sb.append(enabledCapabilities);
        sb.append(",");
    }
    if (!(knownCapabilities == null) && !(knownCapabilities.isEmpty())) {
        sb.append("knownCapabilities:");
        sb.append(knownCapabilities);
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
  
  public A withEnabledCapabilities(List<String> enabledCapabilities) {
    if (enabledCapabilities != null) {
        this.enabledCapabilities = new ArrayList();
        for (String item : enabledCapabilities) {
          this.addToEnabledCapabilities(item);
        }
    } else {
      this.enabledCapabilities = null;
    }
    return (A) this;
  }
  
  public A withEnabledCapabilities(String... enabledCapabilities) {
    if (this.enabledCapabilities != null) {
        this.enabledCapabilities.clear();
        _visitables.remove("enabledCapabilities");
    }
    if (enabledCapabilities != null) {
      for (String item : enabledCapabilities) {
        this.addToEnabledCapabilities(item);
      }
    }
    return (A) this;
  }
  
  public A withKnownCapabilities(List<String> knownCapabilities) {
    if (knownCapabilities != null) {
        this.knownCapabilities = new ArrayList();
        for (String item : knownCapabilities) {
          this.addToKnownCapabilities(item);
        }
    } else {
      this.knownCapabilities = null;
    }
    return (A) this;
  }
  
  public A withKnownCapabilities(String... knownCapabilities) {
    if (this.knownCapabilities != null) {
        this.knownCapabilities.clear();
        _visitables.remove("knownCapabilities");
    }
    if (knownCapabilities != null) {
      for (String item : knownCapabilities) {
        this.addToKnownCapabilities(item);
      }
    }
    return (A) this;
  }
  
}