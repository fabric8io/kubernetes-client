package io.fabric8.kubernetes.api.model.storage;

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
public class StorageHealthFluent<A extends io.fabric8.kubernetes.api.model.storage.StorageHealthFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<StorageHealthConditionBuilder> healthConditions = new ArrayList<StorageHealthConditionBuilder>();
  private String name;

  public StorageHealthFluent() {
  }
  
  public StorageHealthFluent(StorageHealth instance) {
    this.copyInstance(instance);
  }

  public A addAllToHealthConditions(Collection<StorageHealthCondition> items) {
    if (this.healthConditions == null) {
      this.healthConditions = new ArrayList();
    }
    for (StorageHealthCondition item : items) {
        StorageHealthConditionBuilder builder = new StorageHealthConditionBuilder(item);
        _visitables.get("healthConditions").add(builder);
        this.healthConditions.add(builder);
    }
    return (A) this;
  }
  
  public HealthConditionsNested<A> addNewHealthCondition() {
    return new HealthConditionsNested(-1, null);
  }
  
  public HealthConditionsNested<A> addNewHealthConditionLike(StorageHealthCondition item) {
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
  
  public A addToHealthConditions(StorageHealthCondition... items) {
    if (this.healthConditions == null) {
      this.healthConditions = new ArrayList();
    }
    for (StorageHealthCondition item : items) {
        StorageHealthConditionBuilder builder = new StorageHealthConditionBuilder(item);
        _visitables.get("healthConditions").add(builder);
        this.healthConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToHealthConditions(int index,StorageHealthCondition item) {
    if (this.healthConditions == null) {
      this.healthConditions = new ArrayList();
    }
    StorageHealthConditionBuilder builder = new StorageHealthConditionBuilder(item);
    if (index < 0 || index >= healthConditions.size()) {
        _visitables.get("healthConditions").add(builder);
        healthConditions.add(builder);
    } else {
        _visitables.get("healthConditions").add(builder);
        healthConditions.add(index, builder);
    }
    return (A) this;
  }
  
  public StorageHealthCondition buildFirstHealthCondition() {
    return this.healthConditions.get(0).build();
  }
  
  public StorageHealthCondition buildHealthCondition(int index) {
    return this.healthConditions.get(index).build();
  }
  
  public List<StorageHealthCondition> buildHealthConditions() {
    return this.healthConditions != null ? build(healthConditions) : null;
  }
  
  public StorageHealthCondition buildLastHealthCondition() {
    return this.healthConditions.get(healthConditions.size() - 1).build();
  }
  
  public StorageHealthCondition buildMatchingHealthCondition(Predicate<StorageHealthConditionBuilder> predicate) {
      for (StorageHealthConditionBuilder item : healthConditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(StorageHealth instance) {
    instance = instance != null ? instance : new StorageHealth();
    if (instance != null) {
        this.withHealthConditions(instance.getHealthConditions());
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
  
  public HealthConditionsNested<A> editMatchingHealthCondition(Predicate<StorageHealthConditionBuilder> predicate) {
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
    StorageHealthFluent that = (StorageHealthFluent) o;
    if (!(Objects.equals(healthConditions, that.healthConditions))) {
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
  
  public boolean hasHealthConditions() {
    return this.healthConditions != null && !(this.healthConditions.isEmpty());
  }
  
  public boolean hasMatchingHealthCondition(Predicate<StorageHealthConditionBuilder> predicate) {
      for (StorageHealthConditionBuilder item : healthConditions) {
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
    return Objects.hash(healthConditions, name, additionalProperties);
  }
  
  public A removeAllFromHealthConditions(Collection<StorageHealthCondition> items) {
    if (this.healthConditions == null) {
      return (A) this;
    }
    for (StorageHealthCondition item : items) {
        StorageHealthConditionBuilder builder = new StorageHealthConditionBuilder(item);
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
  
  public A removeFromHealthConditions(StorageHealthCondition... items) {
    if (this.healthConditions == null) {
      return (A) this;
    }
    for (StorageHealthCondition item : items) {
        StorageHealthConditionBuilder builder = new StorageHealthConditionBuilder(item);
        _visitables.get("healthConditions").remove(builder);
        this.healthConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHealthConditions(Predicate<StorageHealthConditionBuilder> predicate) {
    if (healthConditions == null) {
      return (A) this;
    }
    Iterator<StorageHealthConditionBuilder> each = healthConditions.iterator();
    List visitables = _visitables.get("healthConditions");
    while (each.hasNext()) {
        StorageHealthConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HealthConditionsNested<A> setNewHealthConditionLike(int index,StorageHealthCondition item) {
    return new HealthConditionsNested(index, item);
  }
  
  public A setToHealthConditions(int index,StorageHealthCondition item) {
    if (this.healthConditions == null) {
      this.healthConditions = new ArrayList();
    }
    StorageHealthConditionBuilder builder = new StorageHealthConditionBuilder(item);
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
  
  public A withHealthConditions(List<StorageHealthCondition> healthConditions) {
    if (this.healthConditions != null) {
      this._visitables.get("healthConditions").clear();
    }
    if (healthConditions != null) {
        this.healthConditions = new ArrayList();
        for (StorageHealthCondition item : healthConditions) {
          this.addToHealthConditions(item);
        }
    } else {
      this.healthConditions = null;
    }
    return (A) this;
  }
  
  public A withHealthConditions(StorageHealthCondition... healthConditions) {
    if (this.healthConditions != null) {
        this.healthConditions.clear();
        _visitables.remove("healthConditions");
    }
    if (healthConditions != null) {
      for (StorageHealthCondition item : healthConditions) {
        this.addToHealthConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  public class HealthConditionsNested<N> extends StorageHealthConditionFluent<HealthConditionsNested<N>> implements Nested<N>{
  
    StorageHealthConditionBuilder builder;
    int index;
  
    HealthConditionsNested(int index,StorageHealthCondition item) {
      this.index = index;
      this.builder = new StorageHealthConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) StorageHealthFluent.this.setToHealthConditions(index, builder.build());
    }
    
    public N endHealthCondition() {
      return and();
    }
    
  }
}