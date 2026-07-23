package io.fabric8.openshift.api.model.config.v1alpha2;

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
public class CustomFluent<A extends io.fabric8.openshift.api.model.config.v1alpha2.CustomFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<GathererConfigBuilder> configs = new ArrayList<GathererConfigBuilder>();

  public CustomFluent() {
  }
  
  public CustomFluent(Custom instance) {
    this.copyInstance(instance);
  }

  public A addAllToConfigs(Collection<GathererConfig> items) {
    if (this.configs == null) {
      this.configs = new ArrayList();
    }
    for (GathererConfig item : items) {
        GathererConfigBuilder builder = new GathererConfigBuilder(item);
        _visitables.get("configs").add(builder);
        this.configs.add(builder);
    }
    return (A) this;
  }
  
  public ConfigsNested<A> addNewConfig() {
    return new ConfigsNested(-1, null);
  }
  
  public A addNewConfig(String name,String state) {
    return (A) this.addToConfigs(new GathererConfig(name, state));
  }
  
  public ConfigsNested<A> addNewConfigLike(GathererConfig item) {
    return new ConfigsNested(-1, item);
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
  
  public A addToConfigs(GathererConfig... items) {
    if (this.configs == null) {
      this.configs = new ArrayList();
    }
    for (GathererConfig item : items) {
        GathererConfigBuilder builder = new GathererConfigBuilder(item);
        _visitables.get("configs").add(builder);
        this.configs.add(builder);
    }
    return (A) this;
  }
  
  public A addToConfigs(int index,GathererConfig item) {
    if (this.configs == null) {
      this.configs = new ArrayList();
    }
    GathererConfigBuilder builder = new GathererConfigBuilder(item);
    if (index < 0 || index >= configs.size()) {
        _visitables.get("configs").add(builder);
        configs.add(builder);
    } else {
        _visitables.get("configs").add(builder);
        configs.add(index, builder);
    }
    return (A) this;
  }
  
  public GathererConfig buildConfig(int index) {
    return this.configs.get(index).build();
  }
  
  public List<GathererConfig> buildConfigs() {
    return this.configs != null ? build(configs) : null;
  }
  
  public GathererConfig buildFirstConfig() {
    return this.configs.get(0).build();
  }
  
  public GathererConfig buildLastConfig() {
    return this.configs.get(configs.size() - 1).build();
  }
  
  public GathererConfig buildMatchingConfig(Predicate<GathererConfigBuilder> predicate) {
      for (GathererConfigBuilder item : configs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Custom instance) {
    instance = instance != null ? instance : new Custom();
    if (instance != null) {
        this.withConfigs(instance.getConfigs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigsNested<A> editConfig(int index) {
    if (configs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "configs"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public ConfigsNested<A> editFirstConfig() {
    if (configs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "configs"));
    }
    return this.setNewConfigLike(0, this.buildConfig(0));
  }
  
  public ConfigsNested<A> editLastConfig() {
    int index = configs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "configs"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public ConfigsNested<A> editMatchingConfig(Predicate<GathererConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < configs.size();i++) {
      if (predicate.test(configs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "configs"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
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
    CustomFluent that = (CustomFluent) o;
    if (!(Objects.equals(configs, that.configs))) {
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
  
  public boolean hasConfigs() {
    return this.configs != null && !(this.configs.isEmpty());
  }
  
  public boolean hasMatchingConfig(Predicate<GathererConfigBuilder> predicate) {
      for (GathererConfigBuilder item : configs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(configs, additionalProperties);
  }
  
  public A removeAllFromConfigs(Collection<GathererConfig> items) {
    if (this.configs == null) {
      return (A) this;
    }
    for (GathererConfig item : items) {
        GathererConfigBuilder builder = new GathererConfigBuilder(item);
        _visitables.get("configs").remove(builder);
        this.configs.remove(builder);
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
  
  public A removeFromConfigs(GathererConfig... items) {
    if (this.configs == null) {
      return (A) this;
    }
    for (GathererConfig item : items) {
        GathererConfigBuilder builder = new GathererConfigBuilder(item);
        _visitables.get("configs").remove(builder);
        this.configs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConfigs(Predicate<GathererConfigBuilder> predicate) {
    if (configs == null) {
      return (A) this;
    }
    Iterator<GathererConfigBuilder> each = configs.iterator();
    List visitables = _visitables.get("configs");
    while (each.hasNext()) {
        GathererConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConfigsNested<A> setNewConfigLike(int index,GathererConfig item) {
    return new ConfigsNested(index, item);
  }
  
  public A setToConfigs(int index,GathererConfig item) {
    if (this.configs == null) {
      this.configs = new ArrayList();
    }
    GathererConfigBuilder builder = new GathererConfigBuilder(item);
    if (index < 0 || index >= configs.size()) {
        _visitables.get("configs").add(builder);
        configs.add(builder);
    } else {
        _visitables.get("configs").add(builder);
        configs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(configs == null) && !(configs.isEmpty())) {
        sb.append("configs:");
        sb.append(configs);
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
  
  public A withConfigs(List<GathererConfig> configs) {
    if (this.configs != null) {
      this._visitables.get("configs").clear();
    }
    if (configs != null) {
        this.configs = new ArrayList();
        for (GathererConfig item : configs) {
          this.addToConfigs(item);
        }
    } else {
      this.configs = null;
    }
    return (A) this;
  }
  
  public A withConfigs(GathererConfig... configs) {
    if (this.configs != null) {
        this.configs.clear();
        _visitables.remove("configs");
    }
    if (configs != null) {
      for (GathererConfig item : configs) {
        this.addToConfigs(item);
      }
    }
    return (A) this;
  }
  public class ConfigsNested<N> extends GathererConfigFluent<ConfigsNested<N>> implements Nested<N>{
  
    GathererConfigBuilder builder;
    int index;
  
    ConfigsNested(int index,GathererConfig item) {
      this.index = index;
      this.builder = new GathererConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomFluent.this.setToConfigs(index, builder.build());
    }
    
    public N endConfig() {
      return and();
    }
    
  }
}