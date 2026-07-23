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
public class DecisionGroupFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.DecisionGroupFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GroupClusterSelectorBuilder groupClusterSelector;
  private String groupName;

  public DecisionGroupFluent() {
  }
  
  public DecisionGroupFluent(DecisionGroup instance) {
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
  
  public GroupClusterSelector buildGroupClusterSelector() {
    return this.groupClusterSelector != null ? this.groupClusterSelector.build() : null;
  }
  
  protected void copyInstance(DecisionGroup instance) {
    instance = instance != null ? instance : new DecisionGroup();
    if (instance != null) {
        this.withGroupClusterSelector(instance.getGroupClusterSelector());
        this.withGroupName(instance.getGroupName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GroupClusterSelectorNested<A> editGroupClusterSelector() {
    return this.withNewGroupClusterSelectorLike(Optional.ofNullable(this.buildGroupClusterSelector()).orElse(null));
  }
  
  public GroupClusterSelectorNested<A> editOrNewGroupClusterSelector() {
    return this.withNewGroupClusterSelectorLike(Optional.ofNullable(this.buildGroupClusterSelector()).orElse(new GroupClusterSelectorBuilder().build()));
  }
  
  public GroupClusterSelectorNested<A> editOrNewGroupClusterSelectorLike(GroupClusterSelector item) {
    return this.withNewGroupClusterSelectorLike(Optional.ofNullable(this.buildGroupClusterSelector()).orElse(item));
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
    DecisionGroupFluent that = (DecisionGroupFluent) o;
    if (!(Objects.equals(groupClusterSelector, that.groupClusterSelector))) {
      return false;
    }
    if (!(Objects.equals(groupName, that.groupName))) {
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
  
  public String getGroupName() {
    return this.groupName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGroupClusterSelector() {
    return this.groupClusterSelector != null;
  }
  
  public boolean hasGroupName() {
    return this.groupName != null;
  }
  
  public int hashCode() {
    return Objects.hash(groupClusterSelector, groupName, additionalProperties);
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
    if (!(groupClusterSelector == null)) {
        sb.append("groupClusterSelector:");
        sb.append(groupClusterSelector);
        sb.append(",");
    }
    if (!(groupName == null)) {
        sb.append("groupName:");
        sb.append(groupName);
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
  
  public A withGroupClusterSelector(GroupClusterSelector groupClusterSelector) {
    this._visitables.remove("groupClusterSelector");
    if (groupClusterSelector != null) {
        this.groupClusterSelector = new GroupClusterSelectorBuilder(groupClusterSelector);
        this._visitables.get("groupClusterSelector").add(this.groupClusterSelector);
    } else {
        this.groupClusterSelector = null;
        this._visitables.get("groupClusterSelector").remove(this.groupClusterSelector);
    }
    return (A) this;
  }
  
  public A withGroupName(String groupName) {
    this.groupName = groupName;
    return (A) this;
  }
  
  public GroupClusterSelectorNested<A> withNewGroupClusterSelector() {
    return new GroupClusterSelectorNested(null);
  }
  
  public GroupClusterSelectorNested<A> withNewGroupClusterSelectorLike(GroupClusterSelector item) {
    return new GroupClusterSelectorNested(item);
  }
  public class GroupClusterSelectorNested<N> extends GroupClusterSelectorFluent<GroupClusterSelectorNested<N>> implements Nested<N>{
  
    GroupClusterSelectorBuilder builder;
  
    GroupClusterSelectorNested(GroupClusterSelector item) {
      this.builder = new GroupClusterSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) DecisionGroupFluent.this.withGroupClusterSelector(builder.build());
    }
    
    public N endGroupClusterSelector() {
      return and();
    }
    
  }
}