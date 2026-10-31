package io.fabric8.kubernetes.api.model;

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
public class PodVolumeHealthFluent<A extends io.fabric8.kubernetes.api.model.PodVolumeHealthFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<VolumeHealthConditionBuilder> healthConditions = new ArrayList<VolumeHealthConditionBuilder>();
  private String lastTransitionTime;
  private String name;

  public PodVolumeHealthFluent() {
  }
  
  public PodVolumeHealthFluent(PodVolumeHealth instance) {
    this.copyInstance(instance);
  }

  public A addAllToHealthConditions(Collection<VolumeHealthCondition> items) {
    if (this.healthConditions == null) {
      this.healthConditions = new ArrayList();
    }
    for (VolumeHealthCondition item : items) {
        VolumeHealthConditionBuilder builder = new VolumeHealthConditionBuilder(item);
        _visitables.get("healthConditions").add(builder);
        this.healthConditions.add(builder);
    }
    return (A) this;
  }
  
  public HealthConditionsNested<A> addNewHealthCondition() {
    return new HealthConditionsNested(-1, null);
  }
  
  public A addNewHealthCondition(String message,String reason,String status) {
    return (A) this.addToHealthConditions(new VolumeHealthCondition(message, reason, status));
  }
  
  public HealthConditionsNested<A> addNewHealthConditionLike(VolumeHealthCondition item) {
    return new HealthConditionsNested(-1, item);
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
  
  public A addToHealthConditions(VolumeHealthCondition... items) {
    if (this.healthConditions == null) {
      this.healthConditions = new ArrayList();
    }
    for (VolumeHealthCondition item : items) {
        VolumeHealthConditionBuilder builder = new VolumeHealthConditionBuilder(item);
        _visitables.get("healthConditions").add(builder);
        this.healthConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToHealthConditions(int index,VolumeHealthCondition item) {
    if (this.healthConditions == null) {
      this.healthConditions = new ArrayList();
    }
    VolumeHealthConditionBuilder builder = new VolumeHealthConditionBuilder(item);
    if (index < 0 || index >= healthConditions.size()) {
        _visitables.get("healthConditions").add(builder);
        healthConditions.add(builder);
    } else {
        _visitables.get("healthConditions").add(builder);
        healthConditions.add(index, builder);
    }
    return (A) this;
  }
  
  public VolumeHealthCondition buildFirstHealthCondition() {
    return this.healthConditions.get(0).build();
  }
  
  public VolumeHealthCondition buildHealthCondition(int index) {
    return this.healthConditions.get(index).build();
  }
  
  public List<VolumeHealthCondition> buildHealthConditions() {
    return this.healthConditions != null ? build(healthConditions) : null;
  }
  
  public VolumeHealthCondition buildLastHealthCondition() {
    return this.healthConditions.get(healthConditions.size() - 1).build();
  }
  
  public VolumeHealthCondition buildMatchingHealthCondition(Predicate<VolumeHealthConditionBuilder> predicate) {
      for (VolumeHealthConditionBuilder item : healthConditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PodVolumeHealth instance) {
    instance = instance != null ? instance : new PodVolumeHealth();
    if (instance != null) {
        this.withHealthConditions(instance.getHealthConditions());
        this.withLastTransitionTime(instance.getLastTransitionTime());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HealthConditionsNested<A> editFirstHealthCondition() {
    if (healthConditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "healthConditions"));
    }
    return this.setNewHealthConditionLike(0, this.buildHealthCondition(0));
  }
  
  public HealthConditionsNested<A> editHealthCondition(int index) {
    if (healthConditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "healthConditions"));
    }
    return this.setNewHealthConditionLike(index, this.buildHealthCondition(index));
  }
  
  public HealthConditionsNested<A> editLastHealthCondition() {
    int index = healthConditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "healthConditions"));
    }
    return this.setNewHealthConditionLike(index, this.buildHealthCondition(index));
  }
  
  public HealthConditionsNested<A> editMatchingHealthCondition(Predicate<VolumeHealthConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < healthConditions.size();i++) {
      if (predicate.test(healthConditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "healthConditions"));
    }
    return this.setNewHealthConditionLike(index, this.buildHealthCondition(index));
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
    PodVolumeHealthFluent that = (PodVolumeHealthFluent) o;
    if (!(Objects.equals(healthConditions, that.healthConditions))) {
      return false;
    }
    if (!(Objects.equals(lastTransitionTime, that.lastTransitionTime))) {
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
  
  public String getLastTransitionTime() {
    return this.lastTransitionTime;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHealthConditions() {
    return this.healthConditions != null && !(this.healthConditions.isEmpty());
  }
  
  public boolean hasLastTransitionTime() {
    return this.lastTransitionTime != null;
  }
  
  public boolean hasMatchingHealthCondition(Predicate<VolumeHealthConditionBuilder> predicate) {
      for (VolumeHealthConditionBuilder item : healthConditions) {
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
    return Objects.hash(healthConditions, lastTransitionTime, name, additionalProperties);
  }
  
  public A removeAllFromHealthConditions(Collection<VolumeHealthCondition> items) {
    if (this.healthConditions == null) {
      return (A) this;
    }
    for (VolumeHealthCondition item : items) {
        VolumeHealthConditionBuilder builder = new VolumeHealthConditionBuilder(item);
        _visitables.get("healthConditions").remove(builder);
        this.healthConditions.remove(builder);
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
  
  public A removeFromHealthConditions(VolumeHealthCondition... items) {
    if (this.healthConditions == null) {
      return (A) this;
    }
    for (VolumeHealthCondition item : items) {
        VolumeHealthConditionBuilder builder = new VolumeHealthConditionBuilder(item);
        _visitables.get("healthConditions").remove(builder);
        this.healthConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHealthConditions(Predicate<VolumeHealthConditionBuilder> predicate) {
    if (healthConditions == null) {
      return (A) this;
    }
    Iterator<VolumeHealthConditionBuilder> each = healthConditions.iterator();
    List visitables = _visitables.get("healthConditions");
    while (each.hasNext()) {
        VolumeHealthConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HealthConditionsNested<A> setNewHealthConditionLike(int index,VolumeHealthCondition item) {
    return new HealthConditionsNested(index, item);
  }
  
  public A setToHealthConditions(int index,VolumeHealthCondition item) {
    if (this.healthConditions == null) {
      this.healthConditions = new ArrayList();
    }
    VolumeHealthConditionBuilder builder = new VolumeHealthConditionBuilder(item);
    if (index < 0 || index >= healthConditions.size()) {
        _visitables.get("healthConditions").add(builder);
        healthConditions.add(builder);
    } else {
        _visitables.get("healthConditions").add(builder);
        healthConditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(healthConditions == null) && !(healthConditions.isEmpty())) {
        sb.append("healthConditions:");
        sb.append(healthConditions);
        sb.append(",");
    }
    if (!(lastTransitionTime == null)) {
        sb.append("lastTransitionTime:");
        sb.append(lastTransitionTime);
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
  
  public A withHealthConditions(List<VolumeHealthCondition> healthConditions) {
    if (this.healthConditions != null) {
      this._visitables.get("healthConditions").clear();
    }
    if (healthConditions != null) {
        this.healthConditions = new ArrayList();
        for (VolumeHealthCondition item : healthConditions) {
          this.addToHealthConditions(item);
        }
    } else {
      this.healthConditions = null;
    }
    return (A) this;
  }
  
  public A withHealthConditions(VolumeHealthCondition... healthConditions) {
    if (this.healthConditions != null) {
        this.healthConditions.clear();
        _visitables.remove("healthConditions");
    }
    if (healthConditions != null) {
      for (VolumeHealthCondition item : healthConditions) {
        this.addToHealthConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withLastTransitionTime(String lastTransitionTime) {
    this.lastTransitionTime = lastTransitionTime;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  public class HealthConditionsNested<N> extends VolumeHealthConditionFluent<HealthConditionsNested<N>> implements Nested<N>{
  
    VolumeHealthConditionBuilder builder;
    int index;
  
    HealthConditionsNested(int index,VolumeHealthCondition item) {
      this.index = index;
      this.builder = new VolumeHealthConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) PodVolumeHealthFluent.this.setToHealthConditions(index, builder.build());
    }
    
    public N endHealthCondition() {
      return and();
    }
    
  }
}