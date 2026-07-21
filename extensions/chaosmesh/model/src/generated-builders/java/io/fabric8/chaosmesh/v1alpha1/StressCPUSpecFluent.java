package io.fabric8.chaosmesh.v1alpha1;

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
public class StressCPUSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.StressCPUSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer load;
  private List<String> options = new ArrayList<String>();
  private Integer workers;

  public StressCPUSpecFluent() {
  }
  
  public StressCPUSpecFluent(StressCPUSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToOptions(Collection<String> items) {
    if (this.options == null) {
      this.options = new ArrayList();
    }
    for (String item : items) {
      this.options.add(item);
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
  
  public A addToOptions(String... items) {
    if (this.options == null) {
      this.options = new ArrayList();
    }
    for (String item : items) {
      this.options.add(item);
    }
    return (A) this;
  }
  
  public A addToOptions(int index,String item) {
    if (this.options == null) {
      this.options = new ArrayList();
    }
    this.options.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(StressCPUSpec instance) {
    instance = instance != null ? instance : new StressCPUSpec();
    if (instance != null) {
        this.withLoad(instance.getLoad());
        this.withOptions(instance.getOptions());
        this.withWorkers(instance.getWorkers());
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
    StressCPUSpecFluent that = (StressCPUSpecFluent) o;
    if (!(Objects.equals(load, that.load))) {
      return false;
    }
    if (!(Objects.equals(options, that.options))) {
      return false;
    }
    if (!(Objects.equals(workers, that.workers))) {
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
  
  public String getFirstOption() {
    return this.options.get(0);
  }
  
  public String getLastOption() {
    return this.options.get(options.size() - 1);
  }
  
  public Integer getLoad() {
    return this.load;
  }
  
  public String getMatchingOption(Predicate<String> predicate) {
      for (String item : options) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOption(int index) {
    return this.options.get(index);
  }
  
  public List<String> getOptions() {
    return this.options;
  }
  
  public Integer getWorkers() {
    return this.workers;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLoad() {
    return this.load != null;
  }
  
  public boolean hasMatchingOption(Predicate<String> predicate) {
      for (String item : options) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOptions() {
    return this.options != null && !(this.options.isEmpty());
  }
  
  public boolean hasWorkers() {
    return this.workers != null;
  }
  
  public int hashCode() {
    return Objects.hash(load, options, workers, additionalProperties);
  }
  
  public A removeAllFromOptions(Collection<String> items) {
    if (this.options == null) {
      return (A) this;
    }
    for (String item : items) {
      this.options.remove(item);
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
  
  public A removeFromOptions(String... items) {
    if (this.options == null) {
      return (A) this;
    }
    for (String item : items) {
      this.options.remove(item);
    }
    return (A) this;
  }
  
  public A setToOptions(int index,String item) {
    if (this.options == null) {
      this.options = new ArrayList();
    }
    this.options.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(load == null)) {
        sb.append("load:");
        sb.append(load);
        sb.append(",");
    }
    if (!(options == null) && !(options.isEmpty())) {
        sb.append("options:");
        sb.append(options);
        sb.append(",");
    }
    if (!(workers == null)) {
        sb.append("workers:");
        sb.append(workers);
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
  
  public A withLoad(Integer load) {
    this.load = load;
    return (A) this;
  }
  
  public A withOptions(List<String> options) {
    if (options != null) {
        this.options = new ArrayList();
        for (String item : options) {
          this.addToOptions(item);
        }
    } else {
      this.options = null;
    }
    return (A) this;
  }
  
  public A withOptions(String... options) {
    if (this.options != null) {
        this.options.clear();
        _visitables.remove("options");
    }
    if (options != null) {
      for (String item : options) {
        this.addToOptions(item);
      }
    }
    return (A) this;
  }
  
  public A withWorkers(Integer workers) {
    this.workers = workers;
    return (A) this;
  }
  
}