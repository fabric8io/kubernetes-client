package io.fabric8.openshift.api.model.monitoring.v1;

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
public class AlertingRuleSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AlertingRuleSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RuleGroupBuilder> groups = new ArrayList<RuleGroupBuilder>();

  public AlertingRuleSpecFluent() {
  }
  
  public AlertingRuleSpecFluent(AlertingRuleSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToGroups(Collection<RuleGroup> items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (RuleGroup item : items) {
        RuleGroupBuilder builder = new RuleGroupBuilder(item);
        _visitables.get("groups").add(builder);
        this.groups.add(builder);
    }
    return (A) this;
  }
  
  public GroupsNested<A> addNewGroup() {
    return new GroupsNested(-1, null);
  }
  
  public GroupsNested<A> addNewGroupLike(RuleGroup item) {
    return new GroupsNested(-1, item);
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
  
  public A addToGroups(RuleGroup... items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (RuleGroup item : items) {
        RuleGroupBuilder builder = new RuleGroupBuilder(item);
        _visitables.get("groups").add(builder);
        this.groups.add(builder);
    }
    return (A) this;
  }
  
  public A addToGroups(int index,RuleGroup item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    RuleGroupBuilder builder = new RuleGroupBuilder(item);
    if (index < 0 || index >= groups.size()) {
        _visitables.get("groups").add(builder);
        groups.add(builder);
    } else {
        _visitables.get("groups").add(builder);
        groups.add(index, builder);
    }
    return (A) this;
  }
  
  public RuleGroup buildFirstGroup() {
    return this.groups.get(0).build();
  }
  
  public RuleGroup buildGroup(int index) {
    return this.groups.get(index).build();
  }
  
  public List<RuleGroup> buildGroups() {
    return this.groups != null ? build(groups) : null;
  }
  
  public RuleGroup buildLastGroup() {
    return this.groups.get(groups.size() - 1).build();
  }
  
  public RuleGroup buildMatchingGroup(Predicate<RuleGroupBuilder> predicate) {
      for (RuleGroupBuilder item : groups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(AlertingRuleSpec instance) {
    instance = instance != null ? instance : new AlertingRuleSpec();
    if (instance != null) {
        this.withGroups(instance.getGroups());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GroupsNested<A> editFirstGroup() {
    if (groups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "groups"));
    }
    return this.setNewGroupLike(0, this.buildGroup(0));
  }
  
  public GroupsNested<A> editGroup(int index) {
    if (groups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "groups"));
    }
    return this.setNewGroupLike(index, this.buildGroup(index));
  }
  
  public GroupsNested<A> editLastGroup() {
    int index = groups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "groups"));
    }
    return this.setNewGroupLike(index, this.buildGroup(index));
  }
  
  public GroupsNested<A> editMatchingGroup(Predicate<RuleGroupBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < groups.size();i++) {
      if (predicate.test(groups.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "groups"));
    }
    return this.setNewGroupLike(index, this.buildGroup(index));
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
    AlertingRuleSpecFluent that = (AlertingRuleSpecFluent) o;
    if (!(Objects.equals(groups, that.groups))) {
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
  
  public boolean hasGroups() {
    return this.groups != null && !(this.groups.isEmpty());
  }
  
  public boolean hasMatchingGroup(Predicate<RuleGroupBuilder> predicate) {
      for (RuleGroupBuilder item : groups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(groups, additionalProperties);
  }
  
  public A removeAllFromGroups(Collection<RuleGroup> items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (RuleGroup item : items) {
        RuleGroupBuilder builder = new RuleGroupBuilder(item);
        _visitables.get("groups").remove(builder);
        this.groups.remove(builder);
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
  
  public A removeFromGroups(RuleGroup... items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (RuleGroup item : items) {
        RuleGroupBuilder builder = new RuleGroupBuilder(item);
        _visitables.get("groups").remove(builder);
        this.groups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromGroups(Predicate<RuleGroupBuilder> predicate) {
    if (groups == null) {
      return (A) this;
    }
    Iterator<RuleGroupBuilder> each = groups.iterator();
    List visitables = _visitables.get("groups");
    while (each.hasNext()) {
        RuleGroupBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public GroupsNested<A> setNewGroupLike(int index,RuleGroup item) {
    return new GroupsNested(index, item);
  }
  
  public A setToGroups(int index,RuleGroup item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    RuleGroupBuilder builder = new RuleGroupBuilder(item);
    if (index < 0 || index >= groups.size()) {
        _visitables.get("groups").add(builder);
        groups.add(builder);
    } else {
        _visitables.get("groups").add(builder);
        groups.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(groups == null) && !(groups.isEmpty())) {
        sb.append("groups:");
        sb.append(groups);
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
  
  public A withGroups(List<RuleGroup> groups) {
    if (this.groups != null) {
      this._visitables.get("groups").clear();
    }
    if (groups != null) {
        this.groups = new ArrayList();
        for (RuleGroup item : groups) {
          this.addToGroups(item);
        }
    } else {
      this.groups = null;
    }
    return (A) this;
  }
  
  public A withGroups(RuleGroup... groups) {
    if (this.groups != null) {
        this.groups.clear();
        _visitables.remove("groups");
    }
    if (groups != null) {
      for (RuleGroup item : groups) {
        this.addToGroups(item);
      }
    }
    return (A) this;
  }
  public class GroupsNested<N> extends RuleGroupFluent<GroupsNested<N>> implements Nested<N>{
  
    RuleGroupBuilder builder;
    int index;
  
    GroupsNested(int index,RuleGroup item) {
      this.index = index;
      this.builder = new RuleGroupBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertingRuleSpecFluent.this.setToGroups(index, builder.build());
    }
    
    public N endGroup() {
      return and();
    }
    
  }
}