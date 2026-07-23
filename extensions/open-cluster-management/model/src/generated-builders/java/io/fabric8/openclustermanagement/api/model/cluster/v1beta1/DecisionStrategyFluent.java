package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DecisionStrategyFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.DecisionStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GroupStrategyBuilder groupStrategy;

  public DecisionStrategyFluent() {
  }
  
  public DecisionStrategyFluent(DecisionStrategy instance) {
    this.copyInstance(instance);
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
  
  public GroupStrategy buildGroupStrategy() {
    return this.groupStrategy != null ? this.groupStrategy.build() : null;
  }
  
  protected void copyInstance(DecisionStrategy instance) {
    instance = instance != null ? instance : new DecisionStrategy();
    if (instance != null) {
        this.withGroupStrategy(instance.getGroupStrategy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GroupStrategyNested<A> editGroupStrategy() {
    return this.withNewGroupStrategyLike(Optional.ofNullable(this.buildGroupStrategy()).orElse(null));
  }
  
  public GroupStrategyNested<A> editOrNewGroupStrategy() {
    return this.withNewGroupStrategyLike(Optional.ofNullable(this.buildGroupStrategy()).orElse(new GroupStrategyBuilder().build()));
  }
  
  public GroupStrategyNested<A> editOrNewGroupStrategyLike(GroupStrategy item) {
    return this.withNewGroupStrategyLike(Optional.ofNullable(this.buildGroupStrategy()).orElse(item));
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
    DecisionStrategyFluent that = (DecisionStrategyFluent) o;
    if (!(Objects.equals(groupStrategy, that.groupStrategy))) {
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
  
  public boolean hasGroupStrategy() {
    return this.groupStrategy != null;
  }
  
  public int hashCode() {
    return Objects.hash(groupStrategy, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(groupStrategy == null)) {
        sb.append("groupStrategy:");
        sb.append(groupStrategy);
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
  
  public A withGroupStrategy(GroupStrategy groupStrategy) {
    this._visitables.remove("groupStrategy");
    if (groupStrategy != null) {
        this.groupStrategy = new GroupStrategyBuilder(groupStrategy);
        this._visitables.get("groupStrategy").add(this.groupStrategy);
    } else {
        this.groupStrategy = null;
        this._visitables.get("groupStrategy").remove(this.groupStrategy);
    }
    return (A) this;
  }
  
  public GroupStrategyNested<A> withNewGroupStrategy() {
    return new GroupStrategyNested(null);
  }
  
  public GroupStrategyNested<A> withNewGroupStrategyLike(GroupStrategy item) {
    return new GroupStrategyNested(item);
  }
  public class GroupStrategyNested<N> extends GroupStrategyFluent<GroupStrategyNested<N>> implements Nested<N>{
  
    GroupStrategyBuilder builder;
  
    GroupStrategyNested(GroupStrategy item) {
      this.builder = new GroupStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) DecisionStrategyFluent.this.withGroupStrategy(builder.build());
    }
    
    public N endGroupStrategy() {
      return and();
    }
    
  }
}