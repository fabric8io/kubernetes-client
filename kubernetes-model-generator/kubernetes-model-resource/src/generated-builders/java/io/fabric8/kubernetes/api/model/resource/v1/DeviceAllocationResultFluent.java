package io.fabric8.kubernetes.api.model.resource.v1;

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
public class DeviceAllocationResultFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.DeviceAllocationResultFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DeviceAllocationConfigurationBuilder> config = new ArrayList<DeviceAllocationConfigurationBuilder>();
  private ArrayList<DeviceRequestAllocationResultBuilder> results = new ArrayList<DeviceRequestAllocationResultBuilder>();

  public DeviceAllocationResultFluent() {
  }
  
  public DeviceAllocationResultFluent(DeviceAllocationResult instance) {
    this.copyInstance(instance);
  }

  public A addAllToConfig(Collection<DeviceAllocationConfiguration> items) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    for (DeviceAllocationConfiguration item : items) {
        DeviceAllocationConfigurationBuilder builder = new DeviceAllocationConfigurationBuilder(item);
        _visitables.get("config").add(builder);
        this.config.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResults(Collection<DeviceRequestAllocationResult> items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (DeviceRequestAllocationResult item : items) {
        DeviceRequestAllocationResultBuilder builder = new DeviceRequestAllocationResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public ConfigNested<A> addNewConfig() {
    return new ConfigNested(-1, null);
  }
  
  public ConfigNested<A> addNewConfigLike(DeviceAllocationConfiguration item) {
    return new ConfigNested(-1, item);
  }
  
  public ResultsNested<A> addNewResult() {
    return new ResultsNested(-1, null);
  }
  
  public ResultsNested<A> addNewResultLike(DeviceRequestAllocationResult item) {
    return new ResultsNested(-1, item);
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
  
  public A addToConfig(DeviceAllocationConfiguration... items) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    for (DeviceAllocationConfiguration item : items) {
        DeviceAllocationConfigurationBuilder builder = new DeviceAllocationConfigurationBuilder(item);
        _visitables.get("config").add(builder);
        this.config.add(builder);
    }
    return (A) this;
  }
  
  public A addToConfig(int index,DeviceAllocationConfiguration item) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    DeviceAllocationConfigurationBuilder builder = new DeviceAllocationConfigurationBuilder(item);
    if (index < 0 || index >= config.size()) {
        _visitables.get("config").add(builder);
        config.add(builder);
    } else {
        _visitables.get("config").add(builder);
        config.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResults(DeviceRequestAllocationResult... items) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    for (DeviceRequestAllocationResult item : items) {
        DeviceRequestAllocationResultBuilder builder = new DeviceRequestAllocationResultBuilder(item);
        _visitables.get("results").add(builder);
        this.results.add(builder);
    }
    return (A) this;
  }
  
  public A addToResults(int index,DeviceRequestAllocationResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    DeviceRequestAllocationResultBuilder builder = new DeviceRequestAllocationResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.add(index, builder);
    }
    return (A) this;
  }
  
  public List<DeviceAllocationConfiguration> buildConfig() {
    return this.config != null ? build(config) : null;
  }
  
  public DeviceAllocationConfiguration buildConfig(int index) {
    return this.config.get(index).build();
  }
  
  public DeviceAllocationConfiguration buildFirstConfig() {
    return this.config.get(0).build();
  }
  
  public DeviceRequestAllocationResult buildFirstResult() {
    return this.results.get(0).build();
  }
  
  public DeviceAllocationConfiguration buildLastConfig() {
    return this.config.get(config.size() - 1).build();
  }
  
  public DeviceRequestAllocationResult buildLastResult() {
    return this.results.get(results.size() - 1).build();
  }
  
  public DeviceAllocationConfiguration buildMatchingConfig(Predicate<DeviceAllocationConfigurationBuilder> predicate) {
      for (DeviceAllocationConfigurationBuilder item : config) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceRequestAllocationResult buildMatchingResult(Predicate<DeviceRequestAllocationResultBuilder> predicate) {
      for (DeviceRequestAllocationResultBuilder item : results) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceRequestAllocationResult buildResult(int index) {
    return this.results.get(index).build();
  }
  
  public List<DeviceRequestAllocationResult> buildResults() {
    return this.results != null ? build(results) : null;
  }
  
  protected void copyInstance(DeviceAllocationResult instance) {
    instance = instance != null ? instance : new DeviceAllocationResult();
    if (instance != null) {
        this.withConfig(instance.getConfig());
        this.withResults(instance.getResults());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigNested<A> editConfig(int index) {
    if (config.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "config"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public ConfigNested<A> editFirstConfig() {
    if (config.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "config"));
    }
    return this.setNewConfigLike(0, this.buildConfig(0));
  }
  
  public ResultsNested<A> editFirstResult() {
    if (results.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(0, this.buildResult(0));
  }
  
  public ConfigNested<A> editLastConfig() {
    int index = config.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "config"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public ResultsNested<A> editLastResult() {
    int index = results.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public ConfigNested<A> editMatchingConfig(Predicate<DeviceAllocationConfigurationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < config.size();i++) {
      if (predicate.test(config.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "config"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public ResultsNested<A> editMatchingResult(Predicate<DeviceRequestAllocationResultBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < results.size();i++) {
      if (predicate.test(results.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
  }
  
  public ResultsNested<A> editResult(int index) {
    if (results.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "results"));
    }
    return this.setNewResultLike(index, this.buildResult(index));
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
    DeviceAllocationResultFluent that = (DeviceAllocationResultFluent) o;
    if (!(Objects.equals(config, that.config))) {
      return false;
    }
    if (!(Objects.equals(results, that.results))) {
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
  
  public boolean hasConfig() {
    return this.config != null && !(this.config.isEmpty());
  }
  
  public boolean hasMatchingConfig(Predicate<DeviceAllocationConfigurationBuilder> predicate) {
      for (DeviceAllocationConfigurationBuilder item : config) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResult(Predicate<DeviceRequestAllocationResultBuilder> predicate) {
      for (DeviceRequestAllocationResultBuilder item : results) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResults() {
    return this.results != null && !(this.results.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(config, results, additionalProperties);
  }
  
  public A removeAllFromConfig(Collection<DeviceAllocationConfiguration> items) {
    if (this.config == null) {
      return (A) this;
    }
    for (DeviceAllocationConfiguration item : items) {
        DeviceAllocationConfigurationBuilder builder = new DeviceAllocationConfigurationBuilder(item);
        _visitables.get("config").remove(builder);
        this.config.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResults(Collection<DeviceRequestAllocationResult> items) {
    if (this.results == null) {
      return (A) this;
    }
    for (DeviceRequestAllocationResult item : items) {
        DeviceRequestAllocationResultBuilder builder = new DeviceRequestAllocationResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
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
  
  public A removeFromConfig(DeviceAllocationConfiguration... items) {
    if (this.config == null) {
      return (A) this;
    }
    for (DeviceAllocationConfiguration item : items) {
        DeviceAllocationConfigurationBuilder builder = new DeviceAllocationConfigurationBuilder(item);
        _visitables.get("config").remove(builder);
        this.config.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResults(DeviceRequestAllocationResult... items) {
    if (this.results == null) {
      return (A) this;
    }
    for (DeviceRequestAllocationResult item : items) {
        DeviceRequestAllocationResultBuilder builder = new DeviceRequestAllocationResultBuilder(item);
        _visitables.get("results").remove(builder);
        this.results.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConfig(Predicate<DeviceAllocationConfigurationBuilder> predicate) {
    if (config == null) {
      return (A) this;
    }
    Iterator<DeviceAllocationConfigurationBuilder> each = config.iterator();
    List visitables = _visitables.get("config");
    while (each.hasNext()) {
        DeviceAllocationConfigurationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResults(Predicate<DeviceRequestAllocationResultBuilder> predicate) {
    if (results == null) {
      return (A) this;
    }
    Iterator<DeviceRequestAllocationResultBuilder> each = results.iterator();
    List visitables = _visitables.get("results");
    while (each.hasNext()) {
        DeviceRequestAllocationResultBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConfigNested<A> setNewConfigLike(int index,DeviceAllocationConfiguration item) {
    return new ConfigNested(index, item);
  }
  
  public ResultsNested<A> setNewResultLike(int index,DeviceRequestAllocationResult item) {
    return new ResultsNested(index, item);
  }
  
  public A setToConfig(int index,DeviceAllocationConfiguration item) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    DeviceAllocationConfigurationBuilder builder = new DeviceAllocationConfigurationBuilder(item);
    if (index < 0 || index >= config.size()) {
        _visitables.get("config").add(builder);
        config.add(builder);
    } else {
        _visitables.get("config").add(builder);
        config.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResults(int index,DeviceRequestAllocationResult item) {
    if (this.results == null) {
      this.results = new ArrayList();
    }
    DeviceRequestAllocationResultBuilder builder = new DeviceRequestAllocationResultBuilder(item);
    if (index < 0 || index >= results.size()) {
        _visitables.get("results").add(builder);
        results.add(builder);
    } else {
        _visitables.get("results").add(builder);
        results.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(config == null) && !(config.isEmpty())) {
        sb.append("config:");
        sb.append(config);
        sb.append(",");
    }
    if (!(results == null) && !(results.isEmpty())) {
        sb.append("results:");
        sb.append(results);
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
  
  public A withConfig(List<DeviceAllocationConfiguration> config) {
    if (this.config != null) {
      this._visitables.get("config").clear();
    }
    if (config != null) {
        this.config = new ArrayList();
        for (DeviceAllocationConfiguration item : config) {
          this.addToConfig(item);
        }
    } else {
      this.config = null;
    }
    return (A) this;
  }
  
  public A withConfig(DeviceAllocationConfiguration... config) {
    if (this.config != null) {
        this.config.clear();
        _visitables.remove("config");
    }
    if (config != null) {
      for (DeviceAllocationConfiguration item : config) {
        this.addToConfig(item);
      }
    }
    return (A) this;
  }
  
  public A withResults(List<DeviceRequestAllocationResult> results) {
    if (this.results != null) {
      this._visitables.get("results").clear();
    }
    if (results != null) {
        this.results = new ArrayList();
        for (DeviceRequestAllocationResult item : results) {
          this.addToResults(item);
        }
    } else {
      this.results = null;
    }
    return (A) this;
  }
  
  public A withResults(DeviceRequestAllocationResult... results) {
    if (this.results != null) {
        this.results.clear();
        _visitables.remove("results");
    }
    if (results != null) {
      for (DeviceRequestAllocationResult item : results) {
        this.addToResults(item);
      }
    }
    return (A) this;
  }
  public class ConfigNested<N> extends DeviceAllocationConfigurationFluent<ConfigNested<N>> implements Nested<N>{
  
    DeviceAllocationConfigurationBuilder builder;
    int index;
  
    ConfigNested(int index,DeviceAllocationConfiguration item) {
      this.index = index;
      this.builder = new DeviceAllocationConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceAllocationResultFluent.this.setToConfig(index, builder.build());
    }
    
    public N endConfig() {
      return and();
    }
    
  }
  public class ResultsNested<N> extends DeviceRequestAllocationResultFluent<ResultsNested<N>> implements Nested<N>{
  
    DeviceRequestAllocationResultBuilder builder;
    int index;
  
    ResultsNested(int index,DeviceRequestAllocationResult item) {
      this.index = index;
      this.builder = new DeviceRequestAllocationResultBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceAllocationResultFluent.this.setToResults(index, builder.build());
    }
    
    public N endResult() {
      return and();
    }
    
  }
}