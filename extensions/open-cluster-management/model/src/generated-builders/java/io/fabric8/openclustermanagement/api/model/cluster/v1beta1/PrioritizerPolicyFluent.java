package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
public class PrioritizerPolicyFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.PrioritizerPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PrioritizerConfigBuilder> configurations = new ArrayList<PrioritizerConfigBuilder>();
  private String mode;

  public PrioritizerPolicyFluent() {
  }
  
  public PrioritizerPolicyFluent(PrioritizerPolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToConfigurations(Collection<PrioritizerConfig> items) {
    if (this.configurations == null) {
      this.configurations = new ArrayList();
    }
    for (PrioritizerConfig item : items) {
        PrioritizerConfigBuilder builder = new PrioritizerConfigBuilder(item);
        _visitables.get("configurations").add(builder);
        this.configurations.add(builder);
    }
    return (A) this;
  }
  
  public ConfigurationsNested<A> addNewConfiguration() {
    return new ConfigurationsNested(-1, null);
  }
  
  public ConfigurationsNested<A> addNewConfigurationLike(PrioritizerConfig item) {
    return new ConfigurationsNested(-1, item);
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
  
  public A addToConfigurations(PrioritizerConfig... items) {
    if (this.configurations == null) {
      this.configurations = new ArrayList();
    }
    for (PrioritizerConfig item : items) {
        PrioritizerConfigBuilder builder = new PrioritizerConfigBuilder(item);
        _visitables.get("configurations").add(builder);
        this.configurations.add(builder);
    }
    return (A) this;
  }
  
  public A addToConfigurations(int index,PrioritizerConfig item) {
    if (this.configurations == null) {
      this.configurations = new ArrayList();
    }
    PrioritizerConfigBuilder builder = new PrioritizerConfigBuilder(item);
    if (index < 0 || index >= configurations.size()) {
        _visitables.get("configurations").add(builder);
        configurations.add(builder);
    } else {
        _visitables.get("configurations").add(builder);
        configurations.add(index, builder);
    }
    return (A) this;
  }
  
  public PrioritizerConfig buildConfiguration(int index) {
    return this.configurations.get(index).build();
  }
  
  public List<PrioritizerConfig> buildConfigurations() {
    return this.configurations != null ? build(configurations) : null;
  }
  
  public PrioritizerConfig buildFirstConfiguration() {
    return this.configurations.get(0).build();
  }
  
  public PrioritizerConfig buildLastConfiguration() {
    return this.configurations.get(configurations.size() - 1).build();
  }
  
  public PrioritizerConfig buildMatchingConfiguration(Predicate<PrioritizerConfigBuilder> predicate) {
      for (PrioritizerConfigBuilder item : configurations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PrioritizerPolicy instance) {
    instance = instance != null ? instance : new PrioritizerPolicy();
    if (instance != null) {
        this.withConfigurations(instance.getConfigurations());
        this.withMode(instance.getMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigurationsNested<A> editConfiguration(int index) {
    if (configurations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "configurations"));
    }
    return this.setNewConfigurationLike(index, this.buildConfiguration(index));
  }
  
  public ConfigurationsNested<A> editFirstConfiguration() {
    if (configurations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "configurations"));
    }
    return this.setNewConfigurationLike(0, this.buildConfiguration(0));
  }
  
  public ConfigurationsNested<A> editLastConfiguration() {
    int index = configurations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "configurations"));
    }
    return this.setNewConfigurationLike(index, this.buildConfiguration(index));
  }
  
  public ConfigurationsNested<A> editMatchingConfiguration(Predicate<PrioritizerConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < configurations.size();i++) {
      if (predicate.test(configurations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "configurations"));
    }
    return this.setNewConfigurationLike(index, this.buildConfiguration(index));
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
    PrioritizerPolicyFluent that = (PrioritizerPolicyFluent) o;
    if (!(Objects.equals(configurations, that.configurations))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigurations() {
    return this.configurations != null && !(this.configurations.isEmpty());
  }
  
  public boolean hasMatchingConfiguration(Predicate<PrioritizerConfigBuilder> predicate) {
      for (PrioritizerConfigBuilder item : configurations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(configurations, mode, additionalProperties);
  }
  
  public A removeAllFromConfigurations(Collection<PrioritizerConfig> items) {
    if (this.configurations == null) {
      return (A) this;
    }
    for (PrioritizerConfig item : items) {
        PrioritizerConfigBuilder builder = new PrioritizerConfigBuilder(item);
        _visitables.get("configurations").remove(builder);
        this.configurations.remove(builder);
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
  
  public A removeFromConfigurations(PrioritizerConfig... items) {
    if (this.configurations == null) {
      return (A) this;
    }
    for (PrioritizerConfig item : items) {
        PrioritizerConfigBuilder builder = new PrioritizerConfigBuilder(item);
        _visitables.get("configurations").remove(builder);
        this.configurations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConfigurations(Predicate<PrioritizerConfigBuilder> predicate) {
    if (configurations == null) {
      return (A) this;
    }
    Iterator<PrioritizerConfigBuilder> each = configurations.iterator();
    List visitables = _visitables.get("configurations");
    while (each.hasNext()) {
        PrioritizerConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConfigurationsNested<A> setNewConfigurationLike(int index,PrioritizerConfig item) {
    return new ConfigurationsNested(index, item);
  }
  
  public A setToConfigurations(int index,PrioritizerConfig item) {
    if (this.configurations == null) {
      this.configurations = new ArrayList();
    }
    PrioritizerConfigBuilder builder = new PrioritizerConfigBuilder(item);
    if (index < 0 || index >= configurations.size()) {
        _visitables.get("configurations").add(builder);
        configurations.add(builder);
    } else {
        _visitables.get("configurations").add(builder);
        configurations.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(configurations == null) && !(configurations.isEmpty())) {
        sb.append("configurations:");
        sb.append(configurations);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
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
  
  public A withConfigurations(List<PrioritizerConfig> configurations) {
    if (this.configurations != null) {
      this._visitables.get("configurations").clear();
    }
    if (configurations != null) {
        this.configurations = new ArrayList();
        for (PrioritizerConfig item : configurations) {
          this.addToConfigurations(item);
        }
    } else {
      this.configurations = null;
    }
    return (A) this;
  }
  
  public A withConfigurations(PrioritizerConfig... configurations) {
    if (this.configurations != null) {
        this.configurations.clear();
        _visitables.remove("configurations");
    }
    if (configurations != null) {
      for (PrioritizerConfig item : configurations) {
        this.addToConfigurations(item);
      }
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  public class ConfigurationsNested<N> extends PrioritizerConfigFluent<ConfigurationsNested<N>> implements Nested<N>{
  
    PrioritizerConfigBuilder builder;
    int index;
  
    ConfigurationsNested(int index,PrioritizerConfig item) {
      this.index = index;
      this.builder = new PrioritizerConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PrioritizerPolicyFluent.this.setToConfigurations(index, builder.build());
    }
    
    public N endConfiguration() {
      return and();
    }
    
  }
}