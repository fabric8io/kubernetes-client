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
public class MultiClusterHubStatusFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.MultiClusterHubStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,StatusCondition> components;
  private ArrayList<HubConditionBuilder> conditions = new ArrayList<HubConditionBuilder>();
  private String currentVersion;
  private String desiredVersion;
  private String phase;

  public MultiClusterHubStatusFluent() {
  }
  
  public MultiClusterHubStatusFluent(MultiClusterHubStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<HubCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (HubCondition item : items) {
        HubConditionBuilder builder = new HubConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(HubCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToComponents(Map<String,StatusCondition> map) {
    if (this.components == null && map != null) {
      this.components = new LinkedHashMap();
    }
    if (map != null) {
      this.components.putAll(map);
    }
    return (A) this;
  }
  
  public A addToComponents(String key,StatusCondition value) {
    if (this.components == null && key != null && value != null) {
      this.components = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.components.put(key, value);
    }
    return (A) this;
  }
  
  public A addToConditions(HubCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (HubCondition item : items) {
        HubConditionBuilder builder = new HubConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,HubCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    HubConditionBuilder builder = new HubConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public HubCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<HubCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public HubCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public HubCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public HubCondition buildMatchingCondition(Predicate<HubConditionBuilder> predicate) {
      for (HubConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(MultiClusterHubStatus instance) {
    instance = instance != null ? instance : new MultiClusterHubStatus();
    if (instance != null) {
        this.withComponents(instance.getComponents());
        this.withConditions(instance.getConditions());
        this.withCurrentVersion(instance.getCurrentVersion());
        this.withDesiredVersion(instance.getDesiredVersion());
        this.withPhase(instance.getPhase());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<HubConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
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
    MultiClusterHubStatusFluent that = (MultiClusterHubStatusFluent) o;
    if (!(Objects.equals(components, that.components))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentVersion, that.currentVersion))) {
      return false;
    }
    if (!(Objects.equals(desiredVersion, that.desiredVersion))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
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
  
  public Map<String,StatusCondition> getComponents() {
    return this.components;
  }
  
  public String getCurrentVersion() {
    return this.currentVersion;
  }
  
  public String getDesiredVersion() {
    return this.desiredVersion;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComponents() {
    return this.components != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasCurrentVersion() {
    return this.currentVersion != null;
  }
  
  public boolean hasDesiredVersion() {
    return this.desiredVersion != null;
  }
  
  public boolean hasMatchingCondition(Predicate<HubConditionBuilder> predicate) {
      for (HubConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public int hashCode() {
    return Objects.hash(components, conditions, currentVersion, desiredVersion, phase, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<HubCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (HubCondition item : items) {
        HubConditionBuilder builder = new HubConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromComponents(String key) {
    if (this.components == null) {
      return (A) this;
    }
    if (key != null && this.components != null) {
      this.components.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromComponents(Map<String,StatusCondition> map) {
    if (this.components == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.components != null) {
          this.components.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromConditions(HubCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (HubCondition item : items) {
        HubConditionBuilder builder = new HubConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<HubConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<HubConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        HubConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,HubCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,HubCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    HubConditionBuilder builder = new HubConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(components == null) && !(components.isEmpty())) {
        sb.append("components:");
        sb.append(components);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(currentVersion == null)) {
        sb.append("currentVersion:");
        sb.append(currentVersion);
        sb.append(",");
    }
    if (!(desiredVersion == null)) {
        sb.append("desiredVersion:");
        sb.append(desiredVersion);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
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
  
  public <K,V>A withComponents(Map<String,StatusCondition> components) {
    if (components == null) {
      this.components = null;
    } else {
      this.components = new LinkedHashMap(components);
    }
    return (A) this;
  }
  
  public A withConditions(List<HubCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (HubCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(HubCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (HubCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentVersion(String currentVersion) {
    this.currentVersion = currentVersion;
    return (A) this;
  }
  
  public A withDesiredVersion(String desiredVersion) {
    this.desiredVersion = desiredVersion;
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  public class ConditionsNested<N> extends HubConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    HubConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,HubCondition item) {
      this.index = index;
      this.builder = new HubConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) MultiClusterHubStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}