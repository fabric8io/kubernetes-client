package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
public class StaticConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.StaticConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> labels;
  private List<String> targets = new ArrayList<String>();

  public StaticConfigFluent() {
  }
  
  public StaticConfigFluent(StaticConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToTargets(Collection<String> items) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    for (String item : items) {
      this.targets.add(item);
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
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTargets(String... items) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    for (String item : items) {
      this.targets.add(item);
    }
    return (A) this;
  }
  
  public A addToTargets(int index,String item) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    this.targets.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(StaticConfig instance) {
    instance = instance != null ? instance : new StaticConfig();
    if (instance != null) {
        this.withLabels(instance.getLabels());
        this.withTargets(instance.getTargets());
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
    StaticConfigFluent that = (StaticConfigFluent) o;
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(targets, that.targets))) {
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
  
  public String getFirstTarget() {
    return this.targets.get(0);
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public String getLastTarget() {
    return this.targets.get(targets.size() - 1);
  }
  
  public String getMatchingTarget(Predicate<String> predicate) {
      for (String item : targets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getTarget(int index) {
    return this.targets.get(index);
  }
  
  public List<String> getTargets() {
    return this.targets;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasMatchingTarget(Predicate<String> predicate) {
      for (String item : targets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTargets() {
    return this.targets != null && !(this.targets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(labels, targets, additionalProperties);
  }
  
  public A removeAllFromTargets(Collection<String> items) {
    if (this.targets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targets.remove(item);
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
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTargets(String... items) {
    if (this.targets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targets.remove(item);
    }
    return (A) this;
  }
  
  public A setToTargets(int index,String item) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    this.targets.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(targets == null) && !(targets.isEmpty())) {
        sb.append("targets:");
        sb.append(targets);
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
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public A withTargets(List<String> targets) {
    if (targets != null) {
        this.targets = new ArrayList();
        for (String item : targets) {
          this.addToTargets(item);
        }
    } else {
      this.targets = null;
    }
    return (A) this;
  }
  
  public A withTargets(String... targets) {
    if (this.targets != null) {
        this.targets.clear();
        _visitables.remove("targets");
    }
    if (targets != null) {
      for (String item : targets) {
        this.addToTargets(item);
      }
    }
    return (A) this;
  }
  
}