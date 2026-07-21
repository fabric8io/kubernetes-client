package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class ContainerConfigFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ContainerConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EnvConfigBuilder> env = new ArrayList<EnvConfigBuilder>();
  private String name;

  public ContainerConfigFluent() {
  }
  
  public ContainerConfigFluent(ContainerConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToEnv(Collection<EnvConfig> items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (EnvConfig item : items) {
        EnvConfigBuilder builder = new EnvConfigBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public EnvNested<A> addNewEnv() {
    return new EnvNested(-1, null);
  }
  
  public A addNewEnv(String name,String value) {
    return (A) this.addToEnv(new EnvConfig(name, value));
  }
  
  public EnvNested<A> addNewEnvLike(EnvConfig item) {
    return new EnvNested(-1, item);
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
  
  public A addToEnv(EnvConfig... items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (EnvConfig item : items) {
        EnvConfigBuilder builder = new EnvConfigBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public A addToEnv(int index,EnvConfig item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    EnvConfigBuilder builder = new EnvConfigBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.add(index, builder);
    }
    return (A) this;
  }
  
  public List<EnvConfig> buildEnv() {
    return this.env != null ? build(env) : null;
  }
  
  public EnvConfig buildEnv(int index) {
    return this.env.get(index).build();
  }
  
  public EnvConfig buildFirstEnv() {
    return this.env.get(0).build();
  }
  
  public EnvConfig buildLastEnv() {
    return this.env.get(env.size() - 1).build();
  }
  
  public EnvConfig buildMatchingEnv(Predicate<EnvConfigBuilder> predicate) {
      for (EnvConfigBuilder item : env) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ContainerConfig instance) {
    instance = instance != null ? instance : new ContainerConfig();
    if (instance != null) {
        this.withEnv(instance.getEnv());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EnvNested<A> editEnv(int index) {
    if (env.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public EnvNested<A> editFirstEnv() {
    if (env.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(0, this.buildEnv(0));
  }
  
  public EnvNested<A> editLastEnv() {
    int index = env.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public EnvNested<A> editMatchingEnv(Predicate<EnvConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < env.size();i++) {
      if (predicate.test(env.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
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
    ContainerConfigFluent that = (ContainerConfigFluent) o;
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnv() {
    return this.env != null && !(this.env.isEmpty());
  }
  
  public boolean hasMatchingEnv(Predicate<EnvConfigBuilder> predicate) {
      for (EnvConfigBuilder item : env) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(env, name, additionalProperties);
  }
  
  public A removeAllFromEnv(Collection<EnvConfig> items) {
    if (this.env == null) {
      return (A) this;
    }
    for (EnvConfig item : items) {
        EnvConfigBuilder builder = new EnvConfigBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
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
  
  public A removeFromEnv(EnvConfig... items) {
    if (this.env == null) {
      return (A) this;
    }
    for (EnvConfig item : items) {
        EnvConfigBuilder builder = new EnvConfigBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEnv(Predicate<EnvConfigBuilder> predicate) {
    if (env == null) {
      return (A) this;
    }
    Iterator<EnvConfigBuilder> each = env.iterator();
    List visitables = _visitables.get("env");
    while (each.hasNext()) {
        EnvConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EnvNested<A> setNewEnvLike(int index,EnvConfig item) {
    return new EnvNested(index, item);
  }
  
  public A setToEnv(int index,EnvConfig item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    EnvConfigBuilder builder = new EnvConfigBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(env == null) && !(env.isEmpty())) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withEnv(List<EnvConfig> env) {
    if (this.env != null) {
      this._visitables.get("env").clear();
    }
    if (env != null) {
        this.env = new ArrayList();
        for (EnvConfig item : env) {
          this.addToEnv(item);
        }
    } else {
      this.env = null;
    }
    return (A) this;
  }
  
  public A withEnv(EnvConfig... env) {
    if (this.env != null) {
        this.env.clear();
        _visitables.remove("env");
    }
    if (env != null) {
      for (EnvConfig item : env) {
        this.addToEnv(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  public class EnvNested<N> extends EnvConfigFluent<EnvNested<N>> implements Nested<N>{
  
    EnvConfigBuilder builder;
    int index;
  
    EnvNested(int index,EnvConfig item) {
      this.index = index;
      this.builder = new EnvConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerConfigFluent.this.setToEnv(index, builder.build());
    }
    
    public N endEnv() {
      return and();
    }
    
  }
}